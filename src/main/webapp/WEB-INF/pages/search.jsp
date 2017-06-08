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
                        <label style="margin-bottom:1px;">搜索结果</label>
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
                                            <a class="addPartNum" onclick="addPartNum(this)" href="#">增加&nbsp;|&nbsp;</a>
                                            <a class="minusPartNum" onclick="minusPartNum(this)" href="#">减少&nbsp;</a>
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
				
				<!-- 增加数量弹窗 -->
						<div class="panel-body">
							<!-- Button trigger modal -->
							<button class="btn btn-primary btn-lg" id="insertBut"
								data-toggle="modal" data-target="#insertF"
								style="display: none;">数量</button>
							<!-- Modal -->
							<div class="modal fade" id="insertF" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myPLabel">进行总称的装配</h4>
										</div>
										<div class="modal-body">
											 <div class="form-group">
                                            <label>当前零件：<font id="name2"></font></label>
                                            </div>
                                            <div class="form-group">
                                            <label>当前数量：<font id="num2"></font></label>
                                            </div>
                                            <div class="form-group">
                                            <label id="info"></label>
                                            <input style="" class="form-control" id="insertNum">
                                            <label><font style="color:red;" id="warning"></font></label>
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
					<!-- / 增加数量弹窗 -->
				<!-- 减少数量弹窗 -->
						<div class="panel-body">
							<!-- Button trigger modal -->
							<button class="btn btn-primary btn-lg" id="insertBut2"
								data-toggle="modal" data-target="#insertF2"
								style="display: none;">数量</button>
							<!-- Modal -->
							<div class="modal fade" id="insertF2" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myPLabel2">进行总称的装配</h4>
										</div>
										<div class="modal-body">
											 <div class="form-group">
                                            <label>当前零件：<font id="name22"></font></label>
                                            </div>
                                            <div class="form-group">
                                            <label>当前数量：<font id="num22"></font></label>
                                            </div>
                                            <div class="form-group">
                                            <label id="info2"></label>
                                            <input style="" class="form-control" id="insertNum2">
                                            <label><font style="color:red;" id="warning2"></font></label>
                                        </div>
										</div>
										<div class="modal-footer">
											<button type="button" id="close" class="btn btn-default"
												data-dismiss="modal">取消</button>
											<button type="button" id="insertOk2" class="btn btn-primary">确认</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->
						</div>
						<!-- .panel-body -->
					<!-- / 减少数量弹窗 -->




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
		
		//增加数量
		function addPartNum(obj){
			var currentPartId = $(obj).parent().siblings('.pii').html();
			var currentNum = $(obj).parent().siblings('.pnum').html();
			
			$('#warning').html("");
			$('#insertNum').val("");
			
			$('#name2').html(currentPartId);
			
			if(currentNum == "")
				$('#num2').html(0);
			else
				$('#num2').html(currentNum);
			
			$('#myPLabel').html("新增数量");
			$('#info').html("添加：")
			$('#insertBut').click();
			
			$('#insertOk').click(function(){
			$('#insertOk').off();
				
				if($('#name2').html().length >= 8){
					console.log("零件")
					$.ajax({
						type : "POST",
						url : "change_part_num",
						async : false,
						data : {
							partId : currentPartId,
							status : "add",
							num : $('#insertNum').val()
						},
						success : function(data){
								window.location.reload();
							console.log(data);
						}
					});
					
				}else if($('#name2').html().length <= 7){
					
					console.log("总成")
					
					$.ajax({
						type : "POST",
						url : "change_ass_num",
						async : false,
						data : {
							partId : currentPartId,
							status : "add",
							num : $('#insertNum').val()
						},
						success : function(data){
							window.location.reload();
							console.log(data);
						}
					});
					
				}
				
			});
			
		}
		
		
		
		//减少数量
		function minusPartNum(obj){
			var currentPartId = $(obj).parent().siblings('.pii').html();
			var currentNum = $(obj).parent().siblings('.pnum').html();
			
			$('#warning2').html("");
			$('#insertNum2').val("");
			
			
			$('#name22').html(currentPartId);

			if(currentNum == "")
				$('#num22').html(0);
			else
				$('#num22').html(currentNum);
			
			$('#myPLabel2').html("减少数量");
			$('#info2').html("减少：")
			$('#insertBut2').click();
			
			$('#insertNum2').blur(function(){
				if(parseInt($('#num22').html()) < parseInt($('#insertNum2').val())){
					$('#warning2').html("数量不能大于现有数量");
					$('#insertOk2').attr("disabled", true);
				}
			})
			$('#insertNum2').focus(function(){
					$('#warning2').html("");
					$('#insertOk2').attr("disabled", false);
					
			})
			
			
			$('#insertOk2').click(function(){
				$('#insertOk2').off();
					
					if($('#name22').html().length >= 8){
						console.log("零件")
						$.ajax({
							type : "POST",
							url : "change_part_num",
							async : false,
							data : {
								partId : currentPartId,
								status : "drop",
								num : $('#insertNum2').val()
							},
							success : function(data){
									window.location.reload();
								console.log(data);
							}
						});
						
					}else if($('#name22').html().length <= 7){
						
						console.log("总成")
						
						$.ajax({
							type : "POST",
							url : "change_ass_num",
							async : false,
							data : {
								partId : currentPartId,
								status : "drop",
								num : $('#insertNum2').val()
							},
							success : function(data){
								window.location.reload();
								console.log(data);
							}
						});
						
					}
					
				});
			
		}
		
		
		
		
		
	</script>

</body>

</html>