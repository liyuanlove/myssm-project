<%@ page language="java" contentType="text/html;charset=utf-8"
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

    <title>修改密码</title>

    <!-- Bootstrap Core CSS -->
    <link href="static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

	<link href="static/dist/css/myanimation.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="static/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <link href="static/vendor/morrisjs/morris.css" rel="stylesheet" type="text/css">
	
    <link href="static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- Custom Fonts -->
    <link href="static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    

</head>
<body>
	 <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <!-- 动画 -->
		<div id="progress">
			<span></span>
		</div>
		<!-- 动画 end -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="to_home_page">BrakeSystem管理系统</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-tasks">
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>BM</strong>
                                        <span class="pull-right text-muted">40% 剩余</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>CM</strong>
                                        <span class="pull-right text-muted">20% 剩余</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                            <span class="sr-only">20% Complete</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>CS</strong>
                                        <span class="pull-right text-muted">60% 剩余</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>WC</strong>
                                        <span class="pull-right text-muted">80% 剩余</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete (danger)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Tasks</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small" >4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> 个人中心</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> 设置</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> 注销</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="to_home_page"><i class="fa fa-dashboard fa-fw"></i> 首页</a>
                        </li>
                        <li>
                            <a href="#"><i class="glyphicon glyphicon-user fa-fw"></i> 个人中心<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="to_user_page">个人信息</a>
                                </li>
                                <li>
                                    <a href="change_user_password">密码修改</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
      <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6">
                    <!-- this -->
                    <h3>修改密码</h3>
                    <form role="form" action="change_password" method="post">
                        <div class="form-group has-success">
                            <label class="control-label" for="inputSuccess">原始密码</label>
                            <input type="password" class="form-control" name="oldPassword" id="oldPassword">
                        </div>
                        <div class="form-group has-warning">
                            <label class="control-label" for="inputWarning">新密码</label>
                            <input type="password" class="form-control"  id="newPassword1">
                        </div>
                        <div class="form-group has-warning">
                            <label class="control-label" for="inputError">重复输入新密码</label>
                            <input type="password" class="form-control" name="newPassword" id="newPassword2">
                            <font color="red" id="warning" size="1">&nbsp;&nbsp;&nbsp;${data}</font>
                        </div>
                        <button type="button" id="but" style="height:40px; width:115px;" class="btn btn-default">提交</button>
                        <button type="submit" style="display:none;" id="sub" class="btn btn-default"></button>
                    </form>
                       
                    </div> 
                    <!-- /.col-lg-12 -->
                </div> 
                <!-- /.row -->
           </div> 
            <!-- /.container-fluid -->
        </div> 
        <!-- /#page-wrapper -->

    </div>
	<%-- <script type="text/javascript" src="static/js/canvas-nest.min.js"></script><canvas height="926" width="1920" style="position: fixed; top: 0px; left: 0px; z-index: -1; opacity: 0.5;" id="c_n1"></canvas>
	 --%>
	 <!-- jQuery -->
    <script src="static/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="static/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="static/vendor/metisMenu/metisMenu.min.js"></script>
    
    <script type="text/javascript" src="static/js/jquery.md5.js"></script>
    
<!-- Morris Charts JavaScript -->
    <script src="static/vendor/raphael/raphael.min.js"></script>
    <script src="static/vendor/morrisjs/morris.min.js"></script>
    <script src="static/data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="static/dist/js/sb-admin-2.js"></script>


	 
	<script type="text/javascript">
	
	
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
	
	$(function(){
		
		  $('a').click(function(){
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
			    
		   })
		
		$('#newPassword2').blur(function(){
			
			
			
		});
		
		/* $('#sub').mouseenter(function(){
			toComparePassword();
		}); */
		
		$('#but').click(function(){
			
			toComparePassword();
			var oldPassword = $('#oldPassword').val();
			$('#oldPassword').val('');
			$('#oldPassword').val($.md5(oldPassword));
			
			var newPassword1 = $('#newPassword1').val();
			$('#newPassword1').val('');
			$('#newPassword1').val($.md5(newPassword1));
			
			var newPassword2 = $('#newPassword2').val();
			$('#newPassword2').val('');
			$('#newPassword2').val($.md5(newPassword2));
			$('#but').attr("disabled","disabled");
			$("#sub").attr({
				"type" : "submit"
			});
			$("#sub").click();
		});
		
		//阻止按enter键自动提交表单。
		document.onkeypress = function(){  
		    if(event.keyCode == 13)   
		   {  
		         return  false;  
		   }  
		}
		
	});
	
	function toComparePassword(){
		var old1 = $('#newPassword1').val();
		var old2 = $('#newPassword2').val();
		var newp = $('#oldPassword').val();
		
		
		if(old1 != old2){
			$('#sub').attr("disabled",true);
			$('#warning').html("新密码输入不对应，请重新输入");
			$('#newPassword1').val("");
			$('#newPassword2').val("");
		}else{
			$('#sub').attr("disabled",false);
		}
		
		if(old2 == newp){
			$('#sub').attr("disabled",true);
			$('#warning').html("密码并没有更改");
		}else{
			$('#sub').attr("disabled",false);
		}
	}
	
	</script>
</body>

</html>