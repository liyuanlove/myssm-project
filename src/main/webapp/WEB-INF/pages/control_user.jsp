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
    <link href="static/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="static/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
     <!-- Custom Fonts -->
    <link href="static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
    <title>账号管理</title>

    
</head>
<body>
	 
	<%@ include file="public/home.jsp" %>
	
        <!-- Page Content -->
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Context Classes</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table" id="user_table">
								
								</table>
							</div>
							<!-- /.table-responsive -->
						</div>
						<!-- /.panel-body -->


					</div>
					<!-- /.col-lg-12 -->
					
					<!-- 更改用户密码弹窗 -->
						<div class="panel-body">
							<!-- Button trigger modal -->
							<button class="btn btn-primary btn-lg" id="changePBut"
								data-toggle="modal" data-target="#myModal1"
								style="display: none;">更改用户密码</button>
							<!-- Modal -->
							<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel">更改用户密码</h4>
										</div>
										<div class="modal-body">
											<div class="form-group has-warning">
					                            <label class="control-label" for="inputWarning">新密码</label>
					                            <input type="password" class="form-control"  id="newPassword1">
					                        </div>
					                        <div class="form-group has-warning">
					                            <label class="control-label" for="inputError">重复输入新密码</label>
					                            <input type="password" class="form-control" name="newPassword" id="newPassword2">
					                            <font color="red" id="warning" size="1">&nbsp;&nbsp;&nbsp;${data}</font>
					                        </div>
										</div>
										<div class="modal-footer">
											<button type="button" id="close" class="btn btn-default"
												data-dismiss="modal">取消</button>
											<button type="button" id="changePOk" class="btn btn-primary">确认</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->
						</div>
						<!-- .panel-body -->
					<!-- / 更改用户密码弹窗 -->
					
					<!-- 更改权限弹窗 -->
						<div class="panel-body">
							<!-- Button trigger modal -->
							<button class="btn btn-primary btn-lg" id="changeRoleBut"
								data-toggle="modal" data-target="#myModal2"
								style="display: none;">更改用户权限</button>
							<!-- Modal -->
							<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel">更改用户权限</h4>
										</div>
										<div class="modal-body">
											<div class="radio">
                                                <label>
                                                    <input type="radio"  name="roldId" id="optionsRadios1" value="0" checked="true">仓库管理员
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="roldId" id="optionsRadios2" value="1">技术员
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="roldId" id="optionsRadios3" value="2">总经理
                                                </label>
                                            </div>
										</div>
										<div class="modal-footer">
											<button type="button" id="close" class="btn btn-default"
												data-dismiss="modal">关闭</button>
											<button type="button" id="changeRole1" class="btn btn-primary">确定</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->
						</div>
						<!-- .panel-body -->
					<!-- / 更改权限弹窗 -->
					
					<!-- 删除弹窗 -->
						<!-- /.panel-heading -->
						<div class="panel-body">
							<!-- Button trigger modal -->
							<button class="btn btn-primary btn-lg" id="deleteUBut"
								data-toggle="modal" data-target="#myModal3"
								style="display: none;">删除账号</button>
							<!-- Modal -->
							<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel">删除用户账号</h4>
										</div>
										<div class="modal-body">
											<label id="info">确认删除当前账号？</label>
										</div>
										<div class="modal-footer">
											<button type="button" id="close" class="btn btn-default"
												data-dismiss="modal">关闭</button>
											<button type="button" id="deleteU" class="btn btn-primary">确认</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->
					</div>
					<!-- / 删除弹窗 -->
					<!-- 启用账号弹窗 -->
						<!-- /.panel-heading -->
						<div class="panel-body">
							<!-- Button trigger modal -->
							<button class="btn btn-primary btn-lg" id="useUBut"
								data-toggle="modal" data-target="#myModal4"
								style="display: none;">启用账号</button>
							<!-- Modal -->
							<div class="modal fade" id="myModal4" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel">启用用户账号</h4>
										</div>
										<div class="modal-body">
											<label id="info">确认启用当前账号？</label>
										</div>
										<div class="modal-footer">
											<button type="button" id="close" class="btn btn-default"
												data-dismiss="modal">关闭</button>
											<button type="button" id="useU" class="btn btn-primary">确认</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->
					</div>
					<!-- / 启用账号弹窗 -->
				</div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /#page-wrapper -->
	
	<script type="text/javascript">
    	$(function(){
    		
    		//阻止按enter键自动提交表单。
    		document.onkeypress = function(){  
    		    if(event.keyCode == 13)   
    		   {  
    		         return  false;  
    		   }  
    		}
    		
    		getAllUserInfo();
    		
    		//修改密码点击事件
    		var aa = '';
    		$('.ff').click(function(){
    			 var num = $(this).parent().parent().index();
    			aa = $(".pp").eq(num).html();
    			$('#changePBut').click();
    			
    		});
    		//修改密码
    		$("#changePOk").click(function(){
    			
    			$("#changePOk").attr("disabled","disabled");
    			var n1 = $.md5($('#newPassword1').val());
    			var n2 = $.md5($('#newPassword2').val());
    			if(n1 == n2){
	    			$.ajax({
	    				type : "POST",
	    				url : "change_password_ajax",
	    				async : false,
	    				data : {phone : aa, password : n1},
	    				success : function(data){
	    					if(data.data1 == 200){
	    						window.location.href ="into_all_user_info";
	    					}
	    				}
	    			});
    			}else{
    				$('#warning').html("两次输入的密码不匹配");
    				$('input').val("");
    			}
    		});
    		
    		//密码框获得焦点
    		$('#newPassword1').focus(function(){
    			$('#warning').html("");
    			$("#changePOk").attr("disabled",false);
    		});
    		$('#newPassword2').focus(function(){
    			$('#warning').html("");
    			$("#changePOk").attr("disabled",false);
    		});
    		
    		//更改权限
    		var roledd = '';
    		$('.rr').click(function(){
    			 var num = $(this).parent().parent().index();
    			 roledd = $(".dd").eq(num).html();
    			$('#changeRoleBut').click();
    		});
    		//更改权限提交
    		$('#changeRole1').click(function(){
    			var role = $("input[name='roldId']:checked").val();
    			
    			$.ajax({
    				type : "POST",
    				url : "change_user_role",
    				async : false,
    				data : {phone : roledd, roldId:role},
    				success : function(data){
    					if(data == 1){
    						window.location.href ="into_all_user_info";
    					}
    				}
    			})
    		});
    		
    		
    		//删除用户账号
    		var dele1 = '';
    		$('.oo').click(function(){
    			var num = $(this).parent().parent().index();
    			dele1 =  $(".hh").eq(num).html();
    			$('#deleteUBut').click();
    		});
    		
    		//进行用户的删除
    		$('#deleteU').click(function(){
    			 $.ajax({
    				type : "POST",
    				url : "change_user_status",
    				async : false,
    				data : {phone : dele1, userStatus : 3},
    				success : function(data){
    					if(data == 1){
    						window.location.href ="into_all_user_info";
    					}
    				}
    			}); 
    		});	
    		
	    	//启用账号
	    	var use1 = '';
	    	$('.vv').click(function(){
	    		var num = $(this).parent().parent().index();
	    		use1 = $(".qq").eq(num).html();
	    		$('#useUBut').click();
	    	});
	    	
	    	//异步启用账号
	    	$('#useU').click(function(){
	    		$.ajax({
	    			type : "POST",
	    			url : "change_user_status",
	    			async : false,
	    			data : {phone :use1, userStatus : 1},
	    			success : function(data){
	    				if(data == 1){
	    					window.location.href ="into_all_user_info";
	    				}
	    			}
	    		});
	    	});
	    	
	    	
    	});
    	
    	
    	
    	
    	function getAllUserInfo(){
    		$.ajax({
				type : "POST",
				url : "get_all_user_info",
				async : false,
				success : function(data){
					fillAllUserInfo(data);
					
				}
			})
    	}
    	
    	function fillAllUserInfo(data){
    		var numm = 1;
    		var s = "<thead><tr><th>#</th><th>账号</th><th>姓名</th><th>权限</th><th>状态</th><th>创建时间</th><th>操作</th></tr></thead><tbody>";
    		$.each(data,function(v,o){
    			if(numm%2==0){
    				s += "<tr class='success'>";
									s += "<td>" + numm + "</td>";
									s += "<td>" + o.phone + "</td>";
									s += "<td>" + o.userName + "</td>";
									if (o.roldId == 0)
										s += "<td>仓库管理员</td>";
									if (o.roldId == 1)
										s += "<td>技术员</td>";
									if (o.roldId == 2)
										s += "<td>总经理</td>";
									if (o.roldId == 3)
										s += "<td>超级管理员</td>";

									if (o.userStatus == 0)
										s += "<td>申请中</td>";
									if (o.userStatus == 1)
										s += "<td>正常</td>";
									if (o.userStatus == 2)
										s += "<td>冻结</td>";
									if (o.userStatus == 3)
										s += "<td>删除</td>";
									s += "<td>" + o.createTime + "</td>";
									s += "<td>";
									if(o.roldId != 3 && o.userStatus != 1)
										s += "<button type='button' class='btn btn-info btn-circle vv' data-toggle='tooltip' data-placement='top' title='启用账号'><a class='qq' style='display:none;'>"+o.phone+"</a><i class='fa fa-check'></i></button>";
										else
											s += "<button type='button' style='display:none;' class='btn btn-info btn-circle vv' data-toggle='tooltip' data-placement='top' title='启用账号'><a class='qq' style='display:none;'>"+o.phone+"</a><i class='fa fa-check'></i></button>";
										
									if(o.userStatus != 3)
										s += "<button type='button'  class='btn btn-primary btn-circle ff' data-toggle='tooltip' data-placement='top' title='修改密码'><a class='pp' style='display:none;'>"+o.phone+"</a><i class='fa fa-edit'></i></button>";
										else
											s += "<button type='button'  style='display:none;' class='btn btn-primary btn-circle ff' data-toggle='tooltip' data-placement='top' title='修改密码'><a class='pp' style='display:none;'>"+o.phone+"</a><i class='fa fa-edit'></i></button>";
											
									if(o.userStatus != 3)
										s += "<button type='button'  class='btn btn-success btn-circle rr' data-toggle='tooltip' data-placement='top' title='更改权限'><a class='dd' style='display:none;'>"+o.phone+"</a><i class='fa fa-user'></i></button>";
										else
											s += "<button type='button'  style='display:none;' class='btn btn-success btn-circle rr' data-toggle='tooltip' data-placement='top' title='更改权限'><a class='dd' style='display:none;'>"+o.phone+"</a><i class='fa fa-user'></i></button>";
											
									if (o.roldId != 3  && o.userStatus != 3)
										s += "<button type='button' class='btn btn-warning btn-circle oo' data-toggle='tooltip' data-placement='top' title='删除账号'><a class='hh' style='display:none;'>"+o.phone+"</a><i class='fa fa-times'></i></button>";
										else
											s += "<button type='button' style='display:none;' class='btn btn-warning btn-circle oo' data-toggle='tooltip' data-placement='top' title='删除账号'><a class='hh' style='display:none;'>"+o.phone+"</a><i class='fa fa-times'></i></button>";
											
									
								} else {
									s += "<tr class='info'>";
									s += "<td>" + numm + "</td>";
									s += "<td>" + o.phone + "</td>";
									s += "<td>" + o.userName + "</td>";
									if (o.roldId == 0)
										s += "<td>仓库管理员</td>";
									if (o.roldId == 1)
										s += "<td>技术员</td>";
									if (o.roldId == 2)
										s += "<td>总经理</td>";
									if (o.roldId == 3)
										s += "<td>超级管理员</td>";

									if (o.userStatus == 0)
										s += "<td>申请中</td>";
									if (o.userStatus == 1)
										s += "<td>正常</td>";
									if (o.userStatus == 2)
										s += "<td>冻结</td>";
									if (o.userStatus == 3)
										s += "<td>删除</td>";
									s += "<td>" + o.createTime + "</td>";
									s += "<td>";
									
									if(o.roldId != 3 && o.userStatus != 1)
										s += "<button type='button' class='btn btn-info btn-circle vv' data-toggle='tooltip' data-placement='top' title='启用账号'><a class='qq' style='display:none;'>"+o.phone+"</a><i class='fa fa-check'></i></button>";
										else
											s += "<button type='button' style='display:none;' class='btn btn-info btn-circle vv' data-toggle='tooltip' data-placement='top' title='启用账号'><a class='qq' style='display:none;'>"+o.phone+"</a><i class='fa fa-check'></i></button>";
											
									if(o.userStatus != 3)
										s += "<button type='button'  class='btn btn-primary btn-circle ff' data-toggle='tooltip' data-placement='top' title='修改密码'><a class='pp' style='display:none;'>"+o.phone+"</a><i class='fa fa-edit'></i></button>";
										else
											s += "<button type='button'  style='display:none;' class='btn btn-primary btn-circle ff' data-toggle='tooltip' data-placement='top' title='修改密码'><a class='pp' style='display:none;'>"+o.phone+"</a><i class='fa fa-edit'></i></button>";
											
									if(o.userStatus != 3)
										s += "<button type='button'  class='btn btn-success btn-circle rr' data-toggle='tooltip' data-placement='top' title='更改权限'><a class='dd' style='display:none;'>"+o.phone+"</a><i class='fa fa-user'></i></button>";
										else
											s += "<button type='button'  style='display:none;' class='btn btn-success btn-circle rr' data-toggle='tooltip' data-placement='top' title='更改权限'><a class='dd' style='display:none;'>"+o.phone+"</a><i class='fa fa-user'></i></button>";
											
									if (o.roldId != 3  && o.userStatus != 3)
										s += "<button type='button' class='btn btn-warning btn-circle oo' data-toggle='tooltip' data-placement='top' title='删除账号'><a class='hh' style='display:none;'>"+o.phone+"</a><i class='fa fa-times'></i></button>";
										else
											s += "<button type='button' style='display:none;' class='btn btn-warning btn-circle oo' data-toggle='tooltip' data-placement='top' title='删除账号'><a class='hh' style='display:none;'>"+o.phone+"</a><i class='fa fa-times'></i></button>";
											

								}

								numm += 1;
								s += "</td>";
							});
			s += "</tr></tbody>"

			if (s != "") {
				$('#user_table').append(s);
			}

		}
	</script>
</body>

</html>