<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>物品详情</title>
	<!-- JQuery v1.12.4 -->
	<script src="${pwd}/shopCenter/jquery/all-main/jquery-2.1.3.min.js"></script>
	<!-- Library - Js -->
	<script src="${pwd}/shopCenter/js/div-shop/lib.js"></script>
	<!-- Library - Theme JS -->
	<script src="${pwd}/shopCenter/js/div-shop/div-shop.js"></script>
	<!-- Nav-->
	<script type="text/javascript" src="${pwd}/shopCenter/jquery/nav/jquery.matchHeight.min.js"></script>
	<script type="text/javascript" src="${pwd}/shopCenter/js/nav.js"></script>
	<link rel="icon" href="${pwd }/images/topicon.png" type="image/ico">
	<link rel="stylesheet" href="${pwd}/shopStatic/main.css" />
	<link rel="stylesheet" href="${pwd}/shopStatic/css/div-shop/div-shop-product.css" />
	<link rel="stylesheet" href="${pwd}/shopStatic/css/div-shop/div-shop-product-respon.css" />
	<link rel="stylesheet" href="${pwd}/shopStatic/assets/fonts/fontawesome/font-awesome.min.css" />
	<link rel="stylesheet" href="${pwd}/shopStatic/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pwd}/shopStatic/css/div-shop/div-shop-checkout1.css">
<script type="text/javascript">
	function apply(id, auditid) {
		if (confirm("你确定申请该物品吗？")) {
			var params = {
				id : id,
				auditid: auditid
			};
			url = '${pwd}/user/apply';
			$.post(url, params, function(data) {
				//alert(data);//这个data就是返回的数据
				if (data == "1") {
					alert("申请已提交！");
				} else {
					alert("您尚未登入！");
				}
			});
		}
		return false;
	}
</script>

</head>
<body>
	 <%@ include file="../baseFrame/userHead.jsp"%>
				<div class="contentRight">
					<!-- Page Banner -->
					<div class="page-banner container-fluid no-padding"
						style="background-color: #f9f9f9; margin-bottom: 20px;">
						<!-- Container -->
						<div class="" style="padding: 0 15px">
							<div class="banner-content">
								<h3>物品详情</h3>
							</div>
						</div><!-- Container /- -->
					</div><!-- Page Banner /- -->

					<!-- Product -->
					<div class="">
						<div class="row product_row">
							<!-- Product Image -->
							<div class="col-lg-7">
								<div class="product_image">
									<div class="product_image_large"><img src="${pwd}/upload/${item.itemimg}"
											style="height:300px;display:block;margin:0 auto;" alt="">
									</div>
								</div>
							</div>

							<!-- Product Content -->
							<div class="col-lg-5">
								<div class="product_content">
									<div class="product_name">${item.itemname}</div>
									<div style="margin-top: 20px;"><span style="font-size: 14px;color: #212529;font-weight: 400;">剩余数量：${item.itemcount}</span></div>
									<div style="margin-top: 20px;"><span style="font-size: 14px;color: #212529;font-weight: 400;">捐赠时间：${item.createtime}</span></div>
									<div class="product_text">
										<p style="text-indent:2em ">${item.introduce}
										</p>
									</div>
									<!-- Product Size -->
									<div class="product_size_container">
										<a href="javascript:void(0);" onclick="apply(${item.id}, ${item.auditid } )" class="btn btn-block btn-primary" style="font-size: 25px">申请该物品</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>
	<div id="footer">
		<%@ include file="../baseFrame/userFoot.jsp"%>
	</div>
</body>
</html>