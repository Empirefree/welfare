<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>捐赠详情</title>
	<meta name="keywords" content="welfare" />
	<meta name="description" content="welfare" />
	<meta content="zh-cn" http-equiv="content-language" />
	<meta content="本页版权归welfare所有。all rights reserved" name="copyright" />
	<link rel="icon" href="${pwd }/images/topicon.png" type="image/ico">
	<link rel="stylesheet" type="text/css" href="${pwd}/userInfoStatic/main.css" />
	<link rel="stylesheet" type="text/css" href="${pwd}/css/my_nav.css" />
	<link href="${pwd}/userInfoStatic/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${pwd}/shopStatic/assets/fonts/fontawesome/font-awesome.min.css" />
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
		.mytable td {}
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
							<link rel="stylesheet" href="${pwd }/shopStatic/css/div-shop/div-shop-product.css" />
							<div class="col-md-9">
								<div class="nav-tabs-custom">
									<div class="">
										<link rel="stylesheet" href="${pwd }/css/step-progress.css" />
										<!-- Page Banner -->
										<div class="page-banner container-fluid no-padding">
											<ul class="nav nav-pills nav-justified step step-arrow" id="progress">
												<li class="active">
													<a>已提交</a>
												</li>
												<li>
													<a>审核通过</a>
												</li>
												<li>
													<a>被申请</a>
												</li>
												<li>
													<a>领取成功</a>
												</li>
											</ul>
											<script>
												function bsStep(i) {
												    $('.step').each(function () {
												        var a, $this = $(this);
												        if (i > $this.find('li').length) {
												            console.log('您输入数值已超过步骤最大数量' + $this.find('li').length + '！！！');
												            a = $this.find('li').length;
												        } else if (i == undefined && $this.data('step') == undefined) {
												            a = 1
												        } else if (i == undefined && $this.data('step') != undefined) {
												            a = $(this).data('step');
												        } else {
												            a = i
												        }
												        $(this).find('li').removeClass('active');
												        $(this).find('li:lt(' + a + ')').addClass('active');
												    })
												}
												$(function(){
													bsStep(${st});
												})
											</script>
										</div><!-- Page Banner /- -->
									
										<!-- Product -->
										<div class="">
											<div class="row product_row" style="padding-top:30px">
												<!-- Product Image -->
												<div class="col-lg-7">
													<div class="product_image">
														<div class="product_image_large"><img
																src="${pwd }/upload/${item.itemimg}"
																style="height:300px;display:block;margin:0 auto;"
																alt="">
														</div>
														<div
															class="row product_image_thumbnails d-flex flex-row align-items-start justify-content-start">
														</div>
													</div>
												</div>
												<!-- Product Content -->
												<div class="col-lg-5">
													<div class="product_content">
														<div class="product_name">${item.itemname}</div>
														<div class="product_text">
															<p>${item.introduce}
															</p>
														</div>
													</div>
												</div>
											</div>
											<!-- Reviews -->
											<div class="row">
												<div class="col" style="padding: 30px">
													<c:if test="${user != null }">
														<div class="reviews">
															<c:if test="${st == 4 }">
																<div class="row">
																	<div class="col-md-8 col-md-offset-2">
																		<form action="${pwd }/user/hudong" class="form" method="post" id="addComment">
																			<div class="form-group row">
																				<div class="col-md-8">
																					<input type="hidden" name="id" id="contentid" class="form-control" value="${item.id }">
																					<input type="text" name="content" id="content" class="form-control">
																				</div>
																				<input type="button" onclick="submitComment()" class="btn col-md-2" value="评论">
																			</div>
																		</form>
																	</div>
																</div>
															</c:if>
															<script>
																function submitComment(){
																	$.ajax({
																		url:"${pwd }/user/hudong",
																		type: "POST",
																		data:{
																			"content": $("#content").val(),
																			"id": $("#contentid").val()
																		},
																		success: function(msg){
																			if(msg == '1'){
																				window.location.href = "";
																			}else{
																				alert(msg);
																			}
																		},
																		error: function(XMLHttpRequest, textStatus, errorThrown){
																			alert("网络错误"+XMLHttpRequest);
																			console.error(XMLHttpRequest);
																			console.error(textStatus);
																			console.error(errorThrown);
																		}
																	});
																}
															</script>
														</c:if>	
														<div class="reviews_container">
															<ul>
															<c:set var = "i" value = "0"/>
															<c:forEach items="${requestScope.intList}" var="item" varStatus="stat">	
																<c:if test="${tyList[i] == 0 }">
																	<li class=" review clearfix" style="width:90%">
																		<div class="review_image"><img
																				src="${pwd }/images/hi.png" alt="">
																		</div>
																		<div class="review_content">
																			<div class="review_name"><a
																					href="#">${user2.username } </a></div>
																			<div class="review_date">${user2.createtime }</div>
																			<div class="rating rating_4 review_rating"
																				data-rating="4">
																				<i class="fa fa-star"></i>
																				<i class="fa fa-star"></i>
																				<i class="fa fa-star"></i>
																				<i class="fa fa-star"></i>
																				<i class="fa fa-star"></i>
																			</div>
																			<div class="review_text">
																				<p class="">
																					 ${item.content }
																				</p>
																			</div>
																		</div>
																	</li>
																</c:if>	
																<!-- Review -->
																<c:if test="${tyList[i] == 1 }">
																		<li class=" review clearfix" style="width:90%">
																			<div class="review_image1"><img
																					src="${pwd }/images/hi.png" alt="">
																			</div>
																			<div class="review_content1">
																				<div class="review_name"><a
																						href="#">${user1.username }</a></div>
																				<div class="review_date">${user1.createtime }</div>
																				<div class="rating rating_4 review_rating"
																					data-rating="4">
																					<i class="fa fa-star"></i>
																					<i class="fa fa-star"></i>
																					<i class="fa fa-star"></i>
																					<i class="fa fa-star"></i>
																					<i class="fa fa-star"></i>
																				</div>
																				<div class="review_text">
																					<p>
																						 ${item.content }
																					</p>
																				</div>
																			</div>
																		</li>
																	</c:if>	
																	<c:set var = "i" value = "${i + 1}"/>
																</c:forEach>
															</ul>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
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