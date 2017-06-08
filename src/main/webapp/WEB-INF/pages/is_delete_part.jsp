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


<title>回收站</title>

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
                        <label style="margin-bottom:1px;">回收站</label>
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
                                            <th>单价</th>
                                            <th>数量</th>
                                            <th>状态</th>
                                            <th>记录人</th>
                                            <th>最后操作时间</th>
                                            <th>数量操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="a" items="${list}">
                                        <tr>
                                            <td class="pii">${a.partId }</td>
                                            <td>${a.partName}</td>
                                            <td><a class="pics" href="###" onclick="lookPic(this)">查看</a><input class="ppi" type="hidden" value="${a.picture}"></td>
                                            <td>${a.price }</td>
                                            <td class="pnum">${a.number }</td>
                                            <c:if test="${a.partStatus == 1 }">
                                            <td>正常</td>
                                            </c:if>
                                            <c:if test="${a.partStatus == 0 }">
                                            <td>删除</td>
                                            </c:if>
                                            <td>${a.userId }</td>
                                            <td>${a.lastTime }</td>
                                            <td>
                                            <a class="addPartNum" onclick="reSetPart(this)" href="#">恢复数据</a>
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
				
				
				




			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
	<script type="text/javascript">
		$(function(){
			
			
			
			
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
			
			
			
			
			
			
		});

		function lookPic(obj){
			
			var pic = $(obj).siblings("input").val();
			console.log(pic);
			$("#picc").attr("src",pic);

			$("#changePBut").click();
			
		}
		
		//增加数量
		
		function reSetPart(obj) {
			var currentPartId = $(obj).parent().siblings('.pii').html();
			console.log("恢复数据")
			console.log(currentPartId);
			if(currentPartId.length >= 8){
				console.log("this is sparePart");
				$.ajax({
					type : "POST",
					url : "to_recover_sparepart_data",
					async : false,
					data : {
						id : currentPartId,
					},
					success : function(data) {
						window.location.reload();
						console.log(data);
					}
				});
			}else{
				console.log("this is assembly");
				$.ajax({
					type : "POST",
					url : "to_use_ass",
					async : false,
					data : {
						partId : currentPartId,
					},
					success : function(data) {
						window.location.reload();
						console.log(data);
					}
				});
				
			}

		}

		
	</script>

</body>

</html>