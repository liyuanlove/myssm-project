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

    <title>新增用户</title>

    
</head>
<body>
	 
	<%@ include file="public/home.jsp" %>
	
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                       <div class="panel panel-default">
                        <div class="panel-heading">
                           新增账号
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form">
                                         <div class="form-group has-success">
				                            <label class="control-label" for="inputSuccess">手机号码</label>
				                            <input type="text" class="form-control" name="phone" id="phone">
				                        </div>
                                         <div class="form-group has-success">
				                            <label class="control-label" for="inputSuccess">密码</label>
				                            <input type="password" class="form-control" name="Password1" id="password1">
				                        </div>
                                         <div class="form-group has-success">
				                            <label class="control-label" for="inputSuccess">重复输入密码</label>
				                            <input type="password" class="form-control" name="password" id="password2">
				                            <font color="red" id="warning" size="1"></font>
				                        </div>
				                        <div class="form-group has-success">
				                            <label class="control-label" for="inputSuccess">姓名</label>
				                            <input type="text" class="form-control" name="userName" id="userName">
				                        </div>
                                        <div class="form-group">
                                            <label>权限</label>
                                            <select class="form-control" name="roldId">
                                                <option value="0">仓库管理员</option>
                                                <option value="1">技术员</option>
                                                <option value="2">总经理</option>
                                            </select>
                                        </div>
                                        <button type="button" id="aSub" class="btn btn-default">提交</button>
                                        <button type="submit" class="btn btn-default" style="display:none;"></button>
                                        <button type="reset" class="btn btn-default">清除内容</button>
                                    </form>
                                </div>
                               
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                    
                    
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <!-- Button trigger modal -->
                            <button class="btn btn-primary btn-lg" id="okButton" data-toggle="modal" data-target="#myModal" style="display:none;">
                                Launch Demo Modal
                            </button>
                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">提示</h4>
                                        </div>
                                        <div class="modal-body">
                                            	<label id="info"></label>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="close" class="btn btn-default" data-dismiss="modal">关闭</button>
                                            <button type="button" id="add_new" class="btn btn-primary">新增下一个</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->
                    </div>
                    <!-- /.panel -->
                   </div>
                   <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    <script type="text/javascript">
    	$(function(){
    		$('#aSub').click(function(){
    			comparePassword();
    			
    			$('#aSub').attr("disabled",true);
    		});
    		
    		$('#add_new').click(function(){
    			
    			window.location.href ="add_user";
    		});
    		
    		$('#password1').focus(function(){
    			$('#warning').html("");
    			$('#aSub').attr("disabled",false);
    		});
    		$('#password2').focus(function(){
    			$('#warning').html("");
    			$('#aSub').attr("disabled",false);
    		});
    		
    		
    	});
    	
    	function comparePassword(){
    		var new1 = $('#password1').val();
    		var new2 = $('#password2').val();
    		if(new1 != new2){
    			$('#aSub').attr("disabled",true);
    			$('#warning').html("两次输入的密码不对应");
    		}else{
    			saveNewUser();
    		}
    	}
    	
    	function saveNewUser(){
    		$.ajax({
				type : "POST",
				url : "to_add_user",
				async : false,
				data : $('form').serialize(),
				success : function(data){
					if(data.data == 200){
						$('#okButton').click();
						$('#info').html("新用户添加成功");
						}
					if(data.data == 202){
						$('#okButton').click();
						$('#add_new').html("重试");
						$('#info').html("信息有误，请核实后在试");
					}
				}
				
				
			})
    	}
    	
    
    </script>
	<%-- <script type="text/javascript" src="static/js/canvas-nest.min.js"></script><canvas height="926" width="1920" style="position: fixed; top: 0px; left: 0px; z-index: -1; opacity: 0.5;" id="c_n1"></canvas>
	 --%>
</body>

</html>