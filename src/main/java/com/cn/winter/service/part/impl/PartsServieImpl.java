package com.cn.winter.service.part.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cn.winter.mapper.AssemblyMapper;
import com.cn.winter.mapper.SparePartsMapper;
import com.cn.winter.mapper.UserMapper;
import com.cn.winter.pojo.AssAndPartRelation;
import com.cn.winter.pojo.Assembly;
import com.cn.winter.pojo.SpareParts;
import com.cn.winter.pojo.User;
import com.cn.winter.service.part.PartsService;
import com.cn.winter.service.part.impl.dto.PartDTO;
import com.cn.winter.utils.DateUtil;
import com.cn.winter.utils.PicUploadToYun;
import com.cn.winter.utils.StringUtil;
import com.github.pagehelper.PageHelper;

@Service("partsService")
public class PartsServieImpl implements PartsService {

	@Resource
	private SparePartsMapper sparePartMapper;
	@Resource
	private AssemblyMapper assemblyMapper;
	@Resource
	private UserMapper userMapper;

	public int addAssmeblyAndPartRelation(String assId, String partId) {

		if (assId == null && assId.equals(""))
			throw new NullPointerException();
		if (partId == null && partId.equals(""))
			throw new NullPointerException();

		Integer count = 0;

		try {
			count = sparePartMapper.addAssAndPartRelation(assId, partId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	public int addAssmeblyAndPart(String partId, SpareParts part, MultipartFile pic, String saveOrUpdate) {

		if (partId == null)
			return 0;
		if (part == null)
			return 0;

		try {

			if (!pic.isEmpty() && pic.getSize() > 0) {
				String photoName = pic.getOriginalFilename();
				if (photoName.matches("(?i).+?\\.(jpg|gif|bmp|png|jpeg)")) {
					String photoRename = StringUtil.getFileRename(photoName);
					String photoSavePath = PicUploadToYun.upload(photoRename, pic);
					if (photoSavePath != null && !photoSavePath.equals("")) {
						part.setPartPicture(photoSavePath);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 将零配件添加到数据库
		SpareParts p = null;
		int partCount = 0;
		try {
			p = sparePartMapper.findPartById(part.getPartId());
			if (p == null) { // 如果零件已经存在了就更新，不存在就添加
				part.setStatus(1);
				partCount = sparePartMapper.addPartSelective(part);
			} else {
				part.setPartId(p.getPartId());// 更新必须有id才可以
				partCount = sparePartMapper.updatePartSelective(part);
			}

			if("save".equals(saveOrUpdate))
				addAssmeblyAndPartRelation(partId, part.getPartId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return partCount;
	}

	public Assembly findAssemblyAndPartsById(String id) {
		if (id == null && id.equals(""))
			return null;

		Assembly assembly = null;
		try {
			assembly = assemblyMapper.findAssAndPart(id);
			// 将id转换成name
			List<SpareParts> list = new ArrayList<>();
			for (SpareParts sp : assembly.getSparePart()) {

				String userId = sp.getUserId();
				User u = userMapper.findUserById(Integer.parseInt(userId));
				sp.setUserId(u.getUserName());
				list.add(sp);
			}
			assembly.setSparePart(list);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return assembly;
	}

	public SpareParts findSparePartByPartId(String partId) {

		if (partId == null && "".equals(partId))
			return null;

		try {
			SpareParts part = sparePartMapper.findPartById(partId);
			return part;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer updateSparePartByPartId(SpareParts part) {

		if (part == null)
			return null;

		try {

			Integer count = sparePartMapper.updatePartSelective(part);

			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Assembly> findAllAssembly(int pageNum, int pageSize) {
		// 开启分页
		PageHelper.startPage(pageNum, pageSize);
		List<Assembly> list = assemblyMapper.findAllAss(pageNum, pageSize);
		return list;
	}

	@Override
	public Map<String, Object> findAssemblyByFuzzySearch(String ass, int pageNum, int pageSize) {

		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(pageNum, pageSize);
		List<Assembly> aList = new ArrayList<>();

		List<Assembly> list = assemblyMapper.findAssemblyByFuzzy(ass, pageNum, pageSize);

		// 进行按钮的添加
		for (Assembly a : list) {

			StringBuffer butStr = new StringBuffer();
			if (a.getPartStatus() == 1) {
				a.setDesc("正常");
				butStr.append("<a class='qq' href=to_spare_part_page?partId=" + a.getPartId() + ">查看&nbsp;|</a>");
				butStr.append("<a class='qq' href=to_edit_ass_page?partId=" + a.getPartId() + ">&nbsp;编辑&nbsp;|</a>");
				butStr.append("<a class='qq' href=to_delete_ass?partId=" + a.getPartId() + ">&nbsp;删除</a>");
				a.setTags(butStr.toString());
			} else {
				a.setDesc("删除");
				butStr.append("<a class='qq' href=to_use_ass?partId=" + a.getPartId() + ">&nbsp;启用</a>");
				a.setTags(butStr.toString());
			}

			if (!"".equals(a.getUserId()) && a.getUserId() != null) {
				User u = userMapper.findUserById(Integer.parseInt(a.getUserId()));
				a.setUserId(u.getUserName());// 将用户id转成名称显示在前端
			}
			if (a.getPicture() != null && !"".equals(a.getPicture())) {
				String picture = "<img class='myImg' style='width:90px;height:60px;' onclick='lookPic(this)' src='"
						+ a.getPicture() + "'/><input class='ppi' type='hidden' value=" + a.getPicture() + ">";
				a.setPicture(picture);
			}

			aList.add(a);
		}
		map.put("data", aList);

		return map;
	}

	@Override
	public Integer addAssembly(Assembly ass, MultipartFile pic) throws Exception {

		if (ass == null)
			return 0;
		ass.setPartStatus(1);
		if (!pic.isEmpty() && pic.getSize() > 0) {
			String photoName = pic.getOriginalFilename();
			if (photoName.matches("(?i).+?\\.(jpg|gif|bmp|png|jpeg)")) {
				String photoRename = StringUtil.getFileRename(photoName);
				String photoSavePath = PicUploadToYun.upload(photoRename, pic);
				if (photoSavePath != null && !photoSavePath.equals("")) {
					ass.setPicture(photoSavePath);
				}
			}
		}

		// 需要先查询数据库中是否已经添加了，如已经存在，更新即可
		Assembly assem = assemblyMapper.findAssemblyById(ass.getPartId());
		if (assem == null) {
			assemblyMapper.addAssembly(ass);
		} else {
			ass.setPartId(assem.getPartId());
			assemblyMapper.updateAssemblyById(ass);
		}

		return 1;
	}

	@Override
	public Assembly findAssemblyById(String partId) {
		if (StringUtils.isEmpty(partId))
			return null;

		try {
			Assembly ass = assemblyMapper.findAssemblyById(partId);

			return ass;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Integer findMaxAssemableNum(String partId) {

		if (StringUtils.isEmpty(partId))
			return null;

		try {

			Assembly ass = assemblyMapper.findAssAndPart(partId);

			List<SpareParts> list = ass.getSparePart();

			Collections.sort(list, new Comparator<SpareParts>() {

				@Override
				public int compare(SpareParts o1, SpareParts o2) {
					// TODO Auto-generated method stub
					if (o1.getNumber() == null) {
						return -1;
					}

					if (o2.getNumber() == null) {
						return -1;
					}

					return o1.getNumber() - o2.getNumber();
				}

			});

			for (SpareParts sp : list) {

				return sp.getNumber();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer deleteOrUseAssByPartId(String partId, User user, Integer status) {

		if (StringUtils.isEmpty(partId))
			return 0;
		if (user == null)
			return 0;

		try {
			
			//应该在删除总成之前删除关系
			List<AssAndPartRelation> relations = sparePartMapper.findPartAndAssRelation(partId);
			
			for(AssAndPartRelation a : relations){
				
				a.setrStatus(status);
				Integer c = sparePartMapper.updateAssAndPartRelation(a.getAssId(), a.getsPartId(), a.getrStatus(), a.getId());
				if(c == 0)
					return 0;
			}
			
			Assembly ass = assemblyMapper.findAssemblyById(partId);

			ass.setUserId(user.getUserId().toString());
			ass.setPartStatus(status); // 设置状态为删除
			ass.setAssembleTime(DateUtil.format(new Date()));//删除的时间

			Integer count = assemblyMapper.updateAssemblyById(ass);

			return count;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Integer deleteOrUsesparePartById(String partId, User user, Integer status) {

		if (StringUtils.isEmpty(partId))
			return 0;

		// 首先取出partId关系
		List<AssAndPartRelation> relation = sparePartMapper.findAssAndPartRelation(partId);
		for(AssAndPartRelation a : relation) {
			
			// 删除零件关系
			a.setrStatus(status);
			// 并更新状态
			Integer count = sparePartMapper.updateAssAndPartRelation(a.getAssId(), a.getsPartId(),
					a.getrStatus(), a.getId());
			// 然后把零件的状态改为删除
			if (count != 0) {
				SpareParts part = new SpareParts();
				part.setPartId(partId);
				part.setAddTime(DateUtil.format(new Date()));//设置改动时间
				part.setStatus(status);
				part.setUserId(user.getUserId().toString());
				try {
					Integer co = sparePartMapper.updatePartSelective(part);
					return co;
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}




		return 0;
	}

	@Override
	public boolean updateAssAndSparePartNum(String assId, Integer num, User user) {

		if (StringUtils.isEmpty(assId))
			return false;
		if (num == null)
			return false;

		try {

			Assembly ass = findAssemblyAndPartsById(assId);

			// 首先减少零件的数量
			List<SpareParts> parts = ass.getSparePart();

			for (SpareParts sp : parts) {
				sp.setUserId(user.getUserId().toString());
				sp.setNumber(sp.getNumber() - num);

				sparePartMapper.updatePartSelective(sp);
			}

			// 然后添加总成的数量
			ass.setNumber(ass.getNumber() + num);

			assemblyMapper.updateAssemblyById(ass);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<PartDTO> findPartBySearch(String condition) {

		List<PartDTO> list = new ArrayList<>();

		// 首先模糊查找总成
		List<Assembly> ass = assemblyMapper.findAssemblyByFuzzy(condition, 0, 1000);

		for (Assembly a : ass) {
			PartDTO part = new PartDTO();
			part.addAssToPartDTO(a);
			User user = userMapper.findUserById(Integer.parseInt(part.getUserId()));
			part.setUserId(user.getUserName());
			list.add(part);
		}

		// 如果找不到总成那么就查找零件
		List<SpareParts> partList = sparePartMapper.findSparePartByFuzzy(condition);

		for (SpareParts p : partList) {

			PartDTO part = new PartDTO();
			part.addSparePartToPartDTO(p);
			User user = userMapper.findUserById(Integer.parseInt(part.getUserId()));
			part.setUserId(user.getUserName());
			list.add(part);

		}
		return list;
	}

	@Override
	public Integer updateAssemblyNum(String partId, Integer num, String status, User u) {

		if (StringUtils.isEmpty(status))
			return 0;
		if (StringUtils.isEmpty(partId))
			return 0;

		try {
			Assembly ass = assemblyMapper.findAssemblyById(partId);

			if ("add".equals(status)) {
				if (ass.getNumber() == null) {

					ass.setNumber(num);
				} else {

					ass.setNumber(ass.getNumber() + num);
				}
				ass.setUserId(u.getUserId().toString());
				ass.setAssembleTime(DateUtil.format(new Date()));
				Integer count = assemblyMapper.updateAssemblyById(ass);
				return count;

			} else if ("drop".equals(status)) {

				ass.setNumber(ass.getNumber() - num);
				ass.setUserId(u.getUserId().toString());
				ass.setAssembleTime(DateUtil.format(new Date()));
				Integer count = assemblyMapper.updateAssemblyById(ass);
				return count;

			} else {
				return 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public Integer updateSparePartNum(String partId, Integer num, String status, User u) {

		if (StringUtils.isEmpty(status))
			return 0;
		if (StringUtils.isEmpty(partId))
			return 0;

		try {

			SpareParts part = sparePartMapper.findPartById(partId);

			if ("add".equals(status)) {

				if (part.getNumber() == null) {

					part.setNumber(num);
				} else {

					part.setNumber(part.getNumber() + num);
				}
				part.setUserId(u.getUserId().toString());
				part.setAddTime(DateUtil.format(new Date()));
				Integer count = sparePartMapper.updatePartSelective(part);
				return count;

			} else if ("drop".equals(status)) {

				part.setNumber(part.getNumber() - num);
				part.setUserId(u.getUserId().toString());
				part.setAddTime(DateUtil.format(new Date()));
				Integer count = sparePartMapper.updatePartSelective(part);
				return count;

			} else {
				return 0;
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return 0;
	}
	
	@Override
	public List<PartDTO> findDeletePart() {
		
		List<PartDTO> list = new ArrayList<>();
		
		List<Assembly> assList = assemblyMapper.findAssIsDelete();
		for (Assembly a : assList) {
			PartDTO pd = new PartDTO();
			pd.addAssToPartDTO(a);
			User user = userMapper.findUserById(Integer.parseInt(pd.getUserId()));
			pd.setUserId(user.getUserName());
			list.add(pd);
		}
		
		List<SpareParts> spareList = sparePartMapper.findSparePartIsDelete();
		for(SpareParts sp : spareList){
			PartDTO pd = new PartDTO();
			pd.addSparePartToPartDTO(sp);
			User user = userMapper.findUserById(Integer.parseInt(pd.getUserId()));
			pd.setUserId(user.getUserName());
			list.add(pd);
		}
		return list;
	}
	
	
	@Override
	public boolean findVerificationPartIdById(String partId) {
		
		if(StringUtils.isEmpty(partId))
			return false;
		
		try {
			Assembly ass = assemblyMapper.findAssemblyById(partId);
			
			if(ass != null)
				return false;
			
			SpareParts part = sparePartMapper.findPartById(partId);
			if(part != null)
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true; 
	}
	
	
}
