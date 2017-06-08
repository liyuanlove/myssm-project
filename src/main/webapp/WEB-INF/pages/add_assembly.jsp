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

<!-- Custom Fonts -->
<link href="static/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<title>总成添加</title>


</head>
<body>

	<%@ include file="public/home.jsp"%>

	<!-- Page Content -->
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-6">
					<div class="panel panel-default">
						<div class="panel-heading">总成添加</div>
						<!-- /.panel-heading -->
						<div class="panel-body" style="margin: 0 auto; width: 100%;">
							<form role="form" action="add_one_assembly" method="post"
								enctype="multipart/form-data">
								<!-- 总成添加 -->
								<div class="panel-body">
									<div class="form-group input-group">
										<span class="input-group-addon">总称编号</span> <input type="text"
											name="partId" id="partId" class="form-control"
											placeholder="CM..."><font id="mess"
											style="color: red;"></font>
									</div>
									<div class="form-group input-group">
										<span class="input-group-addon">OE编号</span> <input type="text"
											name="oeNumber" class="form-control" placeholder="">
									</div>
									<div class="form-group input-group">
										<span class="input-group-addon">总称名称</span> <input type="text"
											name="partName" id="partName" class="form-control"
											placeholder="离合..">
									</div>
									<div class="form-group input-group">
										<span class="input-group-addon">缸径</span> <input type="text"
											name="diameter" class="form-control"> <span
											class="input-group-addon"> mm</span>
									</div>
									<div class="form-group input-group">
										<span class="input-group-addon">重量</span> <input type="text"
											name="weight" class="form-control"> <span
											class="input-group-addon"> Kg</span>
									</div>
									<div class="form-group">
										<label>产品图片：</label> <input type="file" name="pic">
									</div>
									<div class="form-group input-group">
										<span class="input-group-addon">单价&nbsp;&nbsp;$</span> <input
											type="text" name="price" class="form-control"
											placeholder="保留两位小数">
									</div>
									<div class="form-group input-group">
										<span class="input-group-addon">最后更改时间</span> <input
											type="text" name="assembleTime" class="form-control"
											readonly="true" value="${currentTime}">
									</div>
									<div class="form-group input-group">
										<span class="input-group-addon">操作人</span> <input type="text"
											class="form-control" readonly="true"
											value="${userInfo.userName}">
									</div>
								</div>
								<input type="submit" id="subBtn"
									class="btn btn-primary btn-lg btn-block" value="提交">
							</form>
						</div>
						<!-- /.panel-body -->


					</div>
					<!-- /.col-lg-12 -->

					<!-- 更改用户密码弹窗 -->
					<div class="panel-body">
						<!-- Button trigger modal -->
						<button class="btn btn-primary btn-lg" id="changePBut"
							data-toggle="modal" data-target="#myModal1"
							style="display: none;">零配件关联</button>
						<!-- Modal -->
						<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
										<h4 class="modal-title" id="myModalLabel">添加总称零配件关联</h4>
									</div>
									<div class="modal-body">
										<label>确认添加总成和零配件的关联吗？</label>
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
    		
    		$('#subBtn').click(function(){
        		
    			toAnimaition();
    		});
    		
    		$('#partId').blur(function(){
    			var pId = $('#partId').val();
    			var pName = "";
    			if(pId != null && pId != ""){
    				var subId = pId.substring(0,2);
    				if(subId == "BM" || subId == "bm" || subId == "Bm")
    					$('#partName').val("制动总泵");
    				if(subId == "CM" || subId == "cm" || subId == "Cm")
    					$('#partName').val("离合器总泵");
    				if(subId == "CS" || subId == "cs" || subId == "Cs")
    					$('#partName').val("离合器分泵");
    				if(subId == "WC" || subId == "wc" || subId == "Wc")
    					$('#partName').val("制动总泵");
    			}
    			
    			
		if (pId != "") {

					$.ajax({
						type : "POST",
						url : "verification_part",
						async : true,
						data : {
							partId : pId
						},
						success : function(data) {

							if (data.fl == 202) {
								$("#mess").html(data.message);
								$('#subBtn').attr("disabled", true);
							}
						}
					});
				}

			});

			$('#partId').focus(function() {
				$("#mess").html("");
				$('#subBtn').attr("disabled", false);
			});

		});
	</script>
</body>

</html>