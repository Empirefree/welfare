<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>活动详情</title>
	<script src="${pwd}/js/formatUtil.js"></script>
	<script src="${pwd}/js/formUtil.js"></script>
	<link rel="icon" href="${pwd }/images/topicon.png" type="image/ico">
	<link rel="stylesheet" href="${pwd}/shopStatic/main.css" />
	<link rel="stylesheet" href="${pwd}/shopStatic/css/div-shop/div-shop-product.css" />
	<link rel="stylesheet" href="${pwd}/shopStatic/css/div-shop/div-shop-product-respon.css" />
	<link rel="stylesheet" href="${pwd}/shopStatic/assets/fonts/fontawesome/font-awesome.min.css" />
	<link rel="stylesheet" href="${pwd}/shopStatic/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pwd}/shopStatic/css/div-shop/div-shop-checkout1.css">
	<script type="text/javascript" src="${pwd}/js/jquery-1.7.2.min.js"></script>
</head>

<body>
	<%@ include file="../baseFrame/userHead.jsp"%>
				<div class="contentRight">
					<!-- Page Banner -->
					<div class="page-banner container-fluid no-padding"
						style="background-color: #f9f9f9; margin-bottom: 20px;">
						<!-- Container -->
						<div class="" style="padding:0 15px">
							<div class="banner-content">
								<h3>活动详情</h3>
							</div>
						</div><!-- Container /- -->
					</div><!-- Page Banner /- -->

					<!-- Product -->
					<div class="">
						<div class="row product_row">
							<!-- Product Content -->
							<div class="">
								<div class="product_content">
									<div class="product_name"><img src="${pwd}/upload/${offinfo.actimg}" alt=""
											style="display:block;width:300px;margin:0 auto;"></div>
									<div class="product_text">
										<p style="text-indent:2em">${offinfo.introduce}
										</p>
									</div>
									<!-- Product Size -->
									<div class="product_size_container">
										<a class="btn btn-primary" style="font-size: 25px;margin:0 auto;display: block;width: 200px"  data-toggle="modal" data-target="#myModal">帮助Ta</a>
									</div>
								</div>
							</div>
						</div>
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						    <div class="modal-dialog">
						        <div class="modal-content">
						            <div class="modal-header">
						                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						                <h4 class="modal-title" id="myModalLabel">小额捐赠</h4>
						            </div>
						            <div class="modal-body">
						            	 <form action="${pwd }/user/alipay2" method="post" class="form-horizontal">
											  <div class="form-group">
											    <label for="lastname" class="col-md-2 control-label">金额</label>
											    <div class="col-md-7">
											    	<input type="text" class="form-control" name="money" id="money" check="checkNum(this)" placeholder="请输入要捐赠的金额" value="5">
											    	<input type="hidden" class="form-control" name="id" id="id" value = "${offinfo.id }">
											    </div>
											    <button type="button" class="btn col-md-2" onclick="randomMoney()">随机金额</button>
											  </div>
											  <div class="form-group">
											     <div class="col-md-12">
											      <button type="button" class="btn btn-default col-md-2 col-md-offset-5" onclick="checkForm(this)">提交</button>
											    </div>
											  </div>
						            	</form>
						            	<script>
						            		function randomMoney(){
						            			var min = 10,max = 100;
						            			var randomValue = Math.ceil(Math.random()*(max-min+1)+min);
						            			$("#money").val(randomValue);
						            		}
						            	</script>
									</div>
						        </div><!-- /.modal-content -->
						    </div><!-- /.modal -->
						</div>
						<script type="text/javascript" src="${pwd}/userInfoStatic/jquery.min.js"></script>
    					<script type="text/javascript" src="${pwd}/userInfoStatic/bootstrap.min.js"></script>
						<!-- Reviews -->
						<div class="row">
							<div class="col">
								<div class="reviews">
									<div class="reviews_title" style="border-bottom: 1px solid rgba(0,0,0,0.5);padding: 20px 10px;margin-bottom:30px">评价</div>
									<div class="row">
										<div class="col-md-8 col-md-offset-2">
											<form action="${pwd }/user/activitypl" class="form" method="POST" id="addComment">
												<div class="form-group row">
													<div class="col-md-8">
														<input type="hidden"  name="itemid" id = "itemid" class="form-control" value = "${offinfo.id }">
														<input type="text" name="content" id = "content" class="form-control">
													</div>
													<input type="button" class="btn col-md-2" onclick="submitComment()" value="评论">
												</div>
											</form>
											<script>
												function submitComment(){
													$.ajax({
														url:"${pwd }/user/activitypl",
														type: "post",
														data:{
															"content": $("#content").val(),
															"itemid": $("#itemid").val()
														},
													 	success: function (msg) {
											                if (msg == "1") {
											                	alert("发布成功");
											                    window.location.href="";
											                } else {
											                	alert(msg);
											                }
											            },
											            error: function(){
											            	alert("网络错误");
											            }
													});
												}
											</script>
										</div>
									</div>
									<div class="reviews_container">
										<ul>
											<!-- Review -->
										<c:set var = "i" value = "0"/>
										<c:forEach items="${list}" var="inter" varStatus="stat">
											<li class=" review clearfix">
												<div class="review_image">
													<img src="${pwd}/shopStatic/imgs/hi.png" alt="">
												</div>
												<div class="review_content">
													<div class="review_name">
														<a href="#">${userList[i].username}</a>
													</div>
													<div class="review_date">${inter.createtime }</div>
													<div class="rating rating_4 review_rating" data-rating="4">
														<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i>
													</div>
													<div class="review_text">
														<p class="">
															 ${inter.content }
														</p>
													</div>
												</div>
											</li>
											<c:set var = "i" value = "${i + 1}"/>
										</c:forEach>
										<!-- Review -->
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>
</body>

</html>