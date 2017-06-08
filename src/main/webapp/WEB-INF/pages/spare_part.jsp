<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- DataTables CSS -->
<link href="static/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">
<!-- Custom Fonts -->
<link href="static/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">


<title>零件列表</title>

<style type="text/css">
/* dataTables列内容居中 */  
 


</style>
</head>
<body>

	<%@ include file="public/home.jsp"%>

	<!-- Page Content -->
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
                    <div class="panel panel-default" style="heigth:100%;">
                        <div class="panel-heading">
                        <label style="margin-bottom:1px;" id="assPartId">${data.partId }</label>
                        <label style="right: 190px;position: absolute;">可装配数量为：&nbsp;&nbsp;&nbsp;<font id="num"></font></label>
                        	<a id="insert" style="right: 93px;position: absolute;">装配</a><label style="right: 80px;position: absolute;">&nbsp;|&nbsp;</label>
                            <a href="to_add_sparepart_page?partId=${data.partId }" style="right: 50px;position: absolute;">添加</a>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>编号</th>
                                            <th>名称</th>
                                            <th>图片</th>
                                            <th>材料</th>
                                            <th>单价</th>
                                            <th>数量</th>
                                            <th>供应商</th>
                                            <th>入库时间</th>
                                            <th>出库时间</th>
                                            <th>记录人</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="a" items="${data.sparePart}">
                                        <tr>
                                            <td>${a.partId }</td>
                                            <td>${a.partName}</td>
                                            <td><a class="pics" href="###" onclick="lookPic(this)">查看</a><input class="ppi" type="hidden" value="${a.partPicture}"></td>
                                            <td>${a.material }</td>
                                            <td>${a.price }</td>
                                            <td>${a.number }</td>
                                            <td>${a.supplier }</td>
                                            <td>${a.addTime }</td>
                                            <td>${a.outTime }</td>
                                            <td>${a.userId }</td>
                                            <td>
                                            <a class="toanimaition" href="edit_spare_part?partId=${a.partId }&assId=${data.partId}">编辑&nbsp;|&nbsp;</a>
                                            <a class="deletePart" href="#">删除&nbsp;</a><input name="part_Id"  type="hidden" value="${a.partId}" />
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->

				<!-- 图片弹窗 -->
				<div class="panel-body" >
					<!-- Button trigger modal -->
					<button class="btn btn-primary btn-lg" id="changePBut"
						data-toggle="modal" data-target="#myModal1" style="display: none;">删除零件</button>
					<!-- Modal -->
					<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true" >
						<div class="modal-dialog">
								<div class="modal-header" style="width:740px;height:450px;border: 0;">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true" style="font-size: 30px; color: #fff;">&times;</button>
									
								<img style="width:706px;height:454px;" src="" id="picc">
								</div>
								
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
				</div>
				<!-- .panel-body -->
				
				<!-- 装配弹窗 -->
						<div class="panel-body">
							<!-- Button trigger modal -->
							<button class="btn btn-primary btn-lg" id="insertBut"
								data-toggle="modal" data-target="#insertF"
								style="display: none;">总称装配</button>
							<!-- Modal -->
							<div class="modal fade" id="insertF" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel">进行总称的装配</h4>
										</div>
										<div class="modal-body">
											 <div class="form-group">
                                            <label>请输入装配的数量  最大可装配数：<font id="num2"></font></label>
                                            <input class="form-control" id="insertNum"><font style="color:red;" id="wanring"></font>
                                        </div>
										</div>
										<div class="modal-footer">
											<button type="button" id="close" class="btn btn-default"
												data-dismiss="modal">取消</button>
											<button type="button" id="insertOk" class="btn btn-primary">确认</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->
						</div>
						<!-- .panel-body -->
					<!-- / 装配弹窗 -->
				<!-- 删除弹窗 -->
						<div class="panel-body">
							<!-- Button trigger modal -->
							<button class="btn btn-primary btn-lg" id="deleBut"
								data-toggle="modal" data-target="#insertD"
								style="display: none;">删除</button>
							<!-- Modal -->
							<div class="modal fade" id="insertD" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel22" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel22">删除零件</h4>
										</div>
										<div class="modal-body">
											 <div class="form-group">
                                            <label>是否删除零件：<font id="num23"></font></label>
                                        </div>
										</div>
										<div class="modal-footer">
											<button type="button" id="close" class="btn btn-default"
												data-dismiss="modal">取消</button>
											<button type="button" id="deleOk" class="btn btn-primary">确认</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->
						</div>
						<!-- .panel-body -->
					<!-- / 删除弹窗 -->




			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
	<script type="text/javascript">
		$(function(){
			var part = $('#assPartId').html();
			$.ajax({
				type : "POST",
				url : "get_max_assembly_num",
				async : false,
				data : { partId : part },
				success : function(data){
					$('#num').html(data.maxNum);
					$('#num2').html(data.maxNum);
				}
			});
			
			//阻止按enter键自动提交表单。
    		document.onkeypress = function(){  
    		    if(event.keyCode == 13)   
    		   {  
    		         return  false;  
    		   }  
    		} 
			
			
			$(".toanimaition").click(function(){
				
				toAnimaition();
			});
			
			$('.deletePart').click(function(){
				var ppId = $(this).siblings("input[name=part_Id]").val();
				$("#deleBut").click();
				$("#num23").html(ppId);
				$("#deleOk").click(function(){
					
				 $.ajax({
					
					type : "POST",
					url : "delete_spare_part",
					async : false,
					data : {
						partId : ppId
					},
					success : function(data){
						console.log(data)
						window.location.reload();
					}
				 
					
				}); 
				 
				});
				
			});
			
			$('#insert').click(function(){
				
				$('#insertBut').click();
				
			});
			
			$("#insertNum").blur(function(){
				
				if(parseInt($('#num2').html()) < $('#insertNum').val()){
					$('#wanring').html("超过最大可装配数");
					$('#insertOk').attr("disabled",true);
				}
				
			});
			
			$('#insertNum').focus(function(){
					$('#wanring').html("");
				$('#insertOk').attr("disabled",false);
			});
			
			$('#insertOk').click(function(){
				$.ajax({
					type : "POST",
					url : "to_assemble_ass",
					async : false,
					data : {
						
						assId : $('#assPartId').html(),
						num : $('#insertNum').val()
					},
					success : function(data){
						if(data.flag == 200){
							//alert("成功装配");						
							window.location.reload();
						}
					}
				});
			});
			
			
		});

		function lookPic(obj){
			
			var pic = $(obj).siblings("input").val();
			console.log(pic);
			$("#picc").attr("src",pic);

			$("#changePBut").click();
			
		}
	</script>

</body>

</html>