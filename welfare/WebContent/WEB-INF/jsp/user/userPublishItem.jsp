<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>捐赠物品</title>
	<meta name="keywords" content="welfare" />
	<meta name="description" content="welfare" />
	<meta content="zh-cn" http-equiv="content-language" />
	<meta content="本页版权归welfare所有。all rights reserved" name="copyright" />
	<link rel="icon" href="${pwd }/images/topicon.png" type="image/ico">
	<link rel="stylesheet" type="text/css" href="${pwd}/userInfoStatic/main.css" />
	<link rel="stylesheet" type="text/css" href="${pwd}/css/my_nav.css" />
	<link rel="stylesheet" type="text/css" href="${pwd}/css/leaves.css" />
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
												<h4 class="profile-mine__heading"><span>捐赠物品信息</span>
												</h4>
												<ul class="profile-mine__content">
												</ul>
											</div>
											<div>
												<div style="padding:50px 10px">
													<form action="${pwd}/user/userPubItem" method="post" id="itemForm"
														enctype="multipart/form-data">
														<table class="table mytable text-left">
															<tbody>
																<tr>
																	<td width="80px">名称</td>
																	<td><input name="itemname" id="" type="text"
																			check="checkNotEmpty(this)"></td>
																</tr>
																<tr>
																	<td>图片</td>
																	<td><input name="file" id="" type="file"
																			check="checkNotEmpty(this)"></td>
																</tr>
																<tr>
																	<td>数量</td>
																	<td><input name="itemcount" id="" type="text"
																			check="checkNotEmpty(this)"></td>
																</tr>
																<tr>
																	<td>类型</td>
																	<td>
																		<select name="typeid" id="typeid">
																			<c:forEach items="${itemTypes }" var="itemtype">
																				<option value="${itemtype.id }">${itemtype.itemname }</option>
																			</c:forEach>
																		</select>
																</tr>
																<tr>
																	<td>简介</td>
																	<td><textarea name="introduce" id="introduce"
																			style="width:400px" class="form-control"
																			rows="4"></textarea></td>
																</tr>
																<tr>
																	<td></td>
																	<td style="padding-left:20px" class="row">
																		<button class="btn btn-primary col-md-2 col-md-offset-1" onclick="checkForm(this,false)"
																			id="submitBtn" type="button">提交</button>
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