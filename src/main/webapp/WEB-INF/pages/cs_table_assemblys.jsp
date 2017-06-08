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

<style type="text/css">
.nav>li>.btn-success {
	position: absolute;
	display: block;
	padding: 10px 15px;
}
</style>
<title>总成列表</title>


</head>
<body>

	<%@ include file="public/home.jsp"%>

	<!-- Page Content -->
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-6"
					style="width: 100%; margin: 0 auto; margin-top: 35px;">
					<div class="panel panel-default">
						<div class="panel-heading">总成列表</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<!-- Nav tabs -->
							<ul class="nav nav-pills">
								<li><a href="get_bm_assembly" id="bm"
									data-toggle="tab">BM</a></li>
								<li><a href="get_cm_assembly" id="cm" data-toggle="tab">CM</a>
								</li>
								<li class="active"><a href="get_cs_assembly" id="cs" data-toggle="tab">CS</a>
								</li>
								<li><a href="get_wc_assembly" id="wc" data-toggle="tab">WC</a>
								</li>
							</ul>

							<!-- Tab panes -->
							<div class="tab-content">
								<div class="tab-pane fade in active" id="home-pills">
									<h4></h4>
									<a href="to_ass_add_page" class="btn btn-outline btn-success"
										style="right: 32px; position: absolute; top: 62.5px; heigth: 40px;"><i
										class='fa fa-plus'></i>添加</a>
									<div class="panel panel-default">
										<!-- /.panel-heading -->
										<div class="panel-body">
											<table width="100%"
												class="table table-striped table-bordered table-hover"
												id="dataTables-example">
												<thead>
													<tr>
														<th>总成编号</th>
														<th>OE编号</th>
														<th>图片</th>
														<th>缸径</th>
														<th>重量</th>
														<th>单价</th>
														<th>数量</th>
														<th>记录人</th>
														<th>入库时间</th>
														<th>状态</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
									</div>
									<!-- /.panel-body -->
								</div>
								
							</div>
						</div>
					</div>

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





			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
	<script type="text/javascript">
	
	var assName = "CS";
    	$(function(){
    		
    		//进入页面获取BM
    		getAllAssembly();
    		
    		
	    	

		    $('#bm').click(function() {
				  window.location.href="get_bm_assembly";
			}); 
			$('#cm').click(function() {
				  window.location.href="get_cm_assembly";
			}); 
			 
			$('#cs').click(function() {
				window.location.href="get_cs_assembly";
			});
			$('#wc').click(function() {
				window.location.href="get_wc_assembly";
			}); 
			
			//编辑按钮
			

		});

		function getAllAssembly() {
			
			$('#dataTables-example').dataTable( {
				"responsive": true,
				//以下两个参数是为了解决第二次点击按钮的时候tomcat会报错
				"retrieve":true,	
				"destroy": true,
				"autoWidth":false,
				"deferRender": true,
    			"columnDefs": [ { "sortable": false, "targets": [ 2, 7, 9 , 10] }], //设置某些列不进行排序
				"ajax":{
					"url" : "get_every_assembly",
					"data" : {
						ass : assName,
						pageNum : 1,
						pageSize : 1000
					}
				},
				"columns": [
					{ "data": "partId" },
					{ "data": "oeNumber" },
		            { "data": "picture" },
		            { "data": "diameter" },
		            { "data": "weight" },
		            { "data": "price" },
		            { "data": "number" },
		            { "data": "userId" },
		            { "data": "assembleTime" },
		            { "data": "desc" },
		            { "data": "tags" }
		        ],
		        "language": {
			        "processing" : "正在获取数据，请稍后...",    
	                "lengthMenu" : "显示 _MENU_ 条",    
	                "zeroRecords" : "没有您要搜索的内容",    
	                "info" : "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",    
	                "infoEmpty" : "记录数为0",    
	                "infoFiltered" : "(全部记录数 _MAX_ 条)",    
	                "infoPostFix" : "",    
	                "search" : "搜索",    
	                "url" : "",    
	                "paginate": {    
	                    "first" : "第一页",    
	                    "previous" : "上一页",    
	                    "next" : "下一页",    
	                    "last" : "最后一页"    
	                } 
		        }
			} );
		}

function lookPic(obj){
			
			var pic = $(obj).siblings("input").val();
			console.log(pic);
			$("#picc").attr("src",pic);

			$("#changePBut").click();
			
		}
	</script>
</body>

</html>