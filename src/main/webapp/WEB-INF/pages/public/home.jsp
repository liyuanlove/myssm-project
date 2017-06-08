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

    <title>首页</title>

    <!-- Bootstrap Core CSS -->
    <link href="static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="static/dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="static/dist/css/myanimation.css" rel="stylesheet">
    
    <link href="static/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<!-- DataTables CSS -->
    <link href="static/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
    <!-- DataTables Responsive CSS -->
    <link href="static/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
	
<!-- jQuery -->
    <script src="static/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="static/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="static/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="static/dist/js/sb-admin-2.js"></script>
    
    <script type="text/javascript" src="static/js/jquery.md5.js"></script>
	
	<!-- DataTables JavaScript -->
    <script src="static/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="static/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script src="static/vendor/datatables-responsive/dataTables.responsive.js"></script>
	
	<!-- Morris Charts JavaScript -->
    <script src="static/vendor/raphael/raphael.min.js"></script>
    <script src="static/vendor/morrisjs/morris.min.js"></script>
    <script src="static/data/morris-data.js"></script>
    
    <!-- Flot Charts JavaScript -->
    <script src="static/vendor/flot/excanvas.min.js"></script>
    <script src="static/vendor/flot/jquery.flot.js"></script>
    <script src="static/vendor/flot/jquery.flot.pie.js"></script>
    <script src="static/vendor/flot/jquery.flot.resize.js"></script>
    <script src="static/vendor/flot/jquery.flot.time.js"></script>
    <script src="static/vendor/flot-tooltip/jquery.flot.tooltip.min.js"></script>
    <script src="static/data/flot-data.js"></script>
	
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
                                    <span class="pull-right text-muted small">4 minutes ago</span>
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
                        <li><a href="to_user_page"><i class="fa fa-user fa-fw"></i> 个人中心</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> 设置</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="logout"><i class="fa fa-sign-out fa-fw"></i> 注销</a>
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
                                <input type="text" id="searchText" value="${condition}" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button" id="searchBtn">
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
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 出货概览<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="###">Flot Charts</a>
                                </li>
                                <li>
                                    <a href="###">Morris.js Charts</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="###"><i class="fa fa-table fa-fw"></i> 销售详细表</a>
                        </li>
                        <li>
                            <a href="###"><i class="fa fa-edit fa-fw"></i> 报表</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> Brake管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="get_bm_assembly">总成类目</a>
                                </li>
                                <li>
                                    <a href="to_ass_add_page">总成添加</a>
                                </li>
                                <li>
                                    <a href="#">零配件列表</a>
                                </li>
                                <li>
                                    <a href="#">暂无</a>
                                </li>
                                <li>
                                    <a href="#"> 暂无</a>
                                </li>
                                <li>
                                    <a href="to_recycle_bin">回收站</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> 客户中心<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">客户管理</a>
                                </li>
                                <li>
                                    <a href="#">产品编号管理</a>
                                </li>
                                <li>
                                    <a href="#">订单管理 <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="#">订单列表</a>
                                        </li>
                                        <li>
                                            <a href="#">添加订单</a>
                                        </li>
                                        <li>
                                            <a href="#">编辑订单</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li class="active">
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> 账号管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a class="active" href="add_user">新增用户</a>
                                </li>
                                <li>
                                    <a href="into_all_user_info">管理账号</a>
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
        <!-- <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Blank</h1>
                    </div> -->
                    <!-- /.col-lg-12 -->
               <!--  </div> -->
                <!-- /.row -->
          <!--   </div> -->
            <!-- /.container-fluid -->
       <!--  </div> -->
        <!-- /#page-wrapper -->

    </div>
    <script type="text/javascript">
    
   $(function(){
	   
	   
	   $('#searchBtn').click(function(){
		   
		   window.location.href="search_all_part?condition="+$('#searchText').val();
		   
		
	   });
	   
	  
	   $('a').click(function(){
		   //alert("a click");
					console.log('a click');
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
	   
	    $('input[type=button]').click(function(){
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
    
    $('button').click(function(){
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
	   
   });
   
   
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
    
	
    </script>
	<%-- <script type="text/javascript" src="static/js/canvas-nest.min.js"></script><canvas height="926" width="1920" style="position: fixed; top: 0px; left: 0px; z-index: -1; opacity: 0.5;" id="c_n1"></canvas>
	 --%>
</body>

</html>