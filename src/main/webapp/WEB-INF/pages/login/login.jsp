<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>用户登录</title>

<!-- Bootstrap Core CSS -->
<link href="static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="static/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="static/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
	<link href="static/dist/css/myanimation.css" rel="stylesheet">

</head>
<body>
	<!-- 动画 -->
		<div id="progress">
			<span></span>
		</div>
		<!-- 动画 end -->
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">登录</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="user_login" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="手机号码" id="username" name="phone"
										autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="密码" id="password" name="password"
										type="password" value="">
								</div>
								<div class="checkbox">
									<label> <input  name="remember" type="checkbox" id="remember" value="Remember Me">&nbsp;记住密码
									</label><font color="red" size="1">&nbsp;&nbsp;&nbsp;${data}</font>
								</div>
								<!-- Change this to a button or input when using this as a form -->
								<input type="button" id="sub"
									class="btn btn-lg btn-success btn-block" value="提交"/>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- jQuery -->
<script src="static/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="static/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="static/vendor/metisMenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="static/dist/js/sb-admin-2.js"></script>

<script type="text/javascript" src="static/js/jquery.cookie.js"></script>

<script type="text/javascript" src="static/js/jquery.md5.js"></script>
<script type="text/javascript">





	$(function() {
		var n = $.cookie('username');
		var p = $.cookie('password');
		//当账号不为空的时候回显账号密码，如果没有密码回显的密码也为空，
		//当账号为空的时候回显两个空没意义
		
		
		if (n) {
			$("#username").val(n);
			$("#password").val(p);
			$('#remember').attr("checked", true);
		}
		$("#sub").click(function() {
			toAnimaition();
			var n = $("#username").val().trim();
			var p = $("#password").val().trim();

			if ($('#remember').is(':checked')) {
				$('#remember').attr("checked", true);
				$.cookie('username', n, {
					expires : 7
				});
				$.cookie('password', p, {
					expires : 7
				});
				//如果能匹配到说明是记住密码，将复选框设置为选中状态
			} else {
				$.cookie('username', '');
				$.cookie('password', '');
			}
			$("#sub").attr({
				"type" : "submit"
			});
			$('#sub').click();
			$('#sub').attr("disabled","disabled");
		});
		
		
		
		//当密码框失去焦点就将密码进行MD5加密 为了进行区别，将密码的长度限制为18位
		 $('#password').blur(function(){
			var password = $('#password').val();
			if(password.length < 19){
				$('#password').val('');
				$('#password').val($.md5(password));
			}
			
		}); 
		
		//阻止按enter键自动提交表单。
		document.onkeypress = function(){  
		    if(event.keyCode == 13)   
		   {  
		         return  false;  
		   }  
		} 

	});

	
	function toAnimaition(){

		$({property: 0}).animate({property: 100}, {
		    duration: 3000,
		    step: function() {
		        var percentage = Math.round(this.property);

		        $('#progress').css('width',  percentage+"%");

		         if(percentage == 100) {
		                $("#progress").addClass("done");//完成，隐藏进度条
		            }
		    }
		});
	}
</script>
<script type="text/javascript" src="static/js/canvas-nest.min.js"></script><canvas height="926" width="1920" style="position: fixed; top: 0px; left: 0px; z-index: -1; opacity: 0.5;" id="c_n1"></canvas>
	
</body>

</html>