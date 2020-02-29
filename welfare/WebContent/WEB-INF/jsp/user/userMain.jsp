<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>个人后台</title>
	<meta name="keywords" content="welfare" />
	<meta name="description" content="welfare" />
	<meta content="zh-cn" http-equiv="content-language" />
	<meta content="本页版权归welfare所有。all rights reserved" name="copyright" />
	<link rel="icon" href="${pwd }/images/topicon.png" type="image/ico">
	<link rel="stylesheet" type="text/css" href="${pwd}/userInfoStatic/main.css" />
	<link rel="stylesheet" type="text/css" href="${pwd}/css/my_nav.css" />
	<link href="${pwd}/userInfoStatic/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${pwd}/userInfoStatic/bootstrap.min.css">
	<link rel="stylesheet" href="${pwd}/userInfoStatic/AdminLTE.min.css">
	<link rel="stylesheet" href="${pwd}/userInfoStatic/skin-blue.min.css">
	<link rel="stylesheet" href="${pwd}/userInfoStatic/style.css">
	<link rel="stylesheet" href="${pwd}/userInfoStatic/layer.css">
	<script type="text/javascript" src="${pwd}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pwd}/js/jquery.jcarousel.min.js"></script>
	<script type="text/javascript" src="${pwd}/js/jquery.fancybox-1.3.4.js"></script>
	<script src="${pwd}/js/formatUtil.js"></script>
	<script src="${pwd}/js/formUtil.js"></script>
	<style>
		.mytable td{
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
												<h4 class="profile-mine__heading"><span>个人信息</span>
												</h4>
												<ul class="profile-mine__content">
												</ul>
											</div>
											<div>
												<div style="padding:50px 10px">
													<table class="table mytable text-left">
														<tbody>
															<tr>
																<td width="80px">用户名</td>
																<td>${user.username }</td>
															</tr>
															<tr>
																<td>真实姓名</td>
																<td>${user.actualname }</td>
															</tr>
															<tr>
																<td>性别</td>
																<td>${user.sex }</td>
															</tr>
															<tr>
																<td>地址</td>
																<td>${user.address }</td>
															</tr>
															<tr>
																<td>联系电话</td>
																<td>${user.phone }</td>
															</tr>
															<tr>
																<td>Email</td>
																<td>${user.email }</td>
															</tr>
															<tr>
																<td>个人简介</td>
																<td>${user.introduce }</td>
															</tr>
															<tr>
																<td>是否实名</td>
																<c:if test="${user.isActualname == 0 }">
																	<td>否 <a href="${pwd }/user/userInfo">去实名</a></td>
																</c:if>
																<c:if test="${user.isActualname == 1 }">
																	<td>是 </td>
																</c:if>
														</tr>
															<tr>
																<td colspan="2" style="padding-left:20px">
																	<button class="btn" onclick="window.location.href='${pwd }/user/userInfo'">修改信息</button>
																</td>
															</tr>
														</tbody>
													</table>
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
</html>