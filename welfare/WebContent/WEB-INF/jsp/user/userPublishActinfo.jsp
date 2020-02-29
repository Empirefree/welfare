<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>个人求助页面</title>
	<meta name="keywords" content="welfare" />
	<meta name="description" content="welfare" />
	<meta content="zh-cn" http-equiv="content-language" />
	<meta content="本页版权归welfare所有。all rights reserved" name="copyright" />
	<link rel="stylesheet" type="text/css" href="${pwd}/userInfoStatic/main.css" />
	<link rel="stylesheet" type="text/css" href="${pwd}/css/my_nav.css" />
	<link rel="icon" href="${pwd }/images/topicon.png" type="image/ico">
	<link href="${pwd}/userInfoStatic/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pwd}/css/leaves.css" />
	<link rel="stylesheet" href="${pwd}/userInfoStatic/bootstrap.min.css">
	<link rel="stylesheet" href="${pwd}/userInfoStatic/AdminLTE.min.css">
	<link rel="stylesheet" href="${pwd}/userInfoStatic/skin-blue.min.css">
	<link rel="stylesheet" href="${pwd}/userInfoStatic/style.css">
	<link rel="stylesheet" href="${pwd}/userInfoStatic/layer.css">
	<link rel="stylesheet" href="${pwd}/userInfoStatic/bootstrap-datetimepicker.min.css">
	<script type="text/javascript" src="${pwd}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pwd}/js/jquery.jcarousel.min.js"></script>
	<script type="text/javascript" src="${pwd}/js/jquery.fancybox-1.3.4.js"></script>
	<script type="text/javascript" src="${pwd}/userInfoStatic/bootstrap-datetimepicker.min.js"></script>
	<script src="${pwd}/js/formatUtil.js"></script>
	<script src="${pwd}/js/formUtil.js"></script>
	<style>
		.mytable td input {
			border-bottom: 1px solid rgba(0, 0, 0, 0.2);
			padding: 2px 6px;
		}
	</style>
</head>

<body>
	<%@ include file="navmain.jsp" %>
	<div id="main">
		<div class="wrapper" style="height: auto; min-height: 100%;">
			<div class="content-wrapper" style="min-height: 570px;margin-left: 0px">
				<div class="container">
					<section class="content">
						<div class="row">
							<div class="col-md-3">
								<div class="box box-solid">
									<%@ include file="navLeft.jsp" %>
									<!-- /.box-body -->
								</div>
							</div>
							<div class="col-md-9">
								<div class="nav-tabs-custom">
									<div class="tab-content" id="tab-content">
										<div class="tab-pane active" id="tab-pane">
											<div class="profile-mine">
												<h4 class="profile-mine__heading"><span>求助信息</span>
												</h4>
												<ul class="profile-mine__content">
												</ul>
											</div>
											<div>
												<div style="padding:50px 10px">
													<form action="${pwd}/user/userPubAct" method="post" id="itemForm"
														enctype="multipart/form-data">
														<table class="table mytable text-left">
															<tbody>
															<tr>
																<td>标题</td>
																<td><input name="name" type="text" check="checkNotEmpty(this)"></input></td>
															</tr>
															<tr>
																	<td>相关图片</td>
																	<td>
																		<input name="file"  type="file" ></input> 
																	</td>
																</tr>
																<tr>
																	<td>内容</td>
																	<td><textarea name="introduce" id="introduce"
																			style="width:400px" class="form-control"
																			rows="4"></textarea>
																	</td>
																</tr>
															<tr>
																<td>开始时间</td>
																<td><input name="starttime" type="text" value="2019-01-15 21:05" id="datetimepicker1"  data-date-format="yyyy-mm-dd hh:ii"></input></td>
															</tr>
															<tr>
																<td>结束时间</td>
																<td><input name="endtime" type="text" value="2019-05-15 21:05" id="datetimepicker2"  data-date-format="yyyy-mm-dd hh:ii"></input></td>
															</tr>
															<script>
																$('#datetimepicker1').datetimepicker();
																$('#datetimepicker2').datetimepicker();
															</script>
															<tr>
																	<td></td>
																	<td style="padding-left:20px">
																		<button class="btn btn-primary"  
																			id="submitBtn" type="button" onclick="checkForm(this,false)">发布求助</button>
																	</td>
																</tr>
															</tbody>
														</table>
													</form>
											</div>
											</div>
											<div>
												<script src="${pwd}/userInfoStatic/hm.js"></script>
												<script>
													var pageIndex = 1
												</script>
											</div>
										</div>
									</div>
									<!-- /.tab-content -->
								</div>
								<!-- /.nav-tabs-custom -->
							</div>
							<!-- /.col -->
						</div>
						<!-- /.row -->
					</section>
				</div>
				<!-- /.container -->
			</div>
		</div>
	</div>

	<div id="footer">
		<%@ include file="../baseFrame/userFoot.jsp"%>
	</div>
</body>
<script src="http://cdn.ckeditor.com/4.5.10/standard/ckeditor.js"></script>
<script type="text/javascript">
    CKEDITOR.replace('introduce');
</script>

</html>