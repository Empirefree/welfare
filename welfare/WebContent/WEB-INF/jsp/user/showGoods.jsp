<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>物品中心</title>
	<link rel="icon" href="${pwd }/images/topicon.png" type="image/ico">
	<link rel="stylesheet" href="${pwd}/shopCenter/css/div-shop/div-shop.css" />
	<link rel="stylesheet" href="${pwd}/shopCenter/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${pwd}/shopCenter/assets/fonts/fontawesome/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="${pwd}/shopCenter/css/main.css" />
	<link rel="stylesheet" type="text/css" href="${pwd}/css/my_nav.css" />
	<!-- Nav-->
	<link rel="stylesheet" type="text/css" href="${pwd}/shopCenter/assets/fonts/pe-icon/pe-icon.css">
	<link rel="stylesheet" type="text/css" id="app-stylesheet" href="${pwd}/shopCenter/css/nav.css">
<script type="text/javascript">

	function submit(id) {
		var params = {
			id : id
		};
		url = '${pwd}/user/love';

		$.post(url, params, function(data) {
			if (data != null) {
				alert("点赞成功！");
				document.getElementById(id).innerHTML = data + "人喜欢";
				return false;
			} else {
				alert("您尚未登入！");
			}
		});
		return false;
	}

	function apply(id, auditid) {
		if (confirm("你确定申请该物品吗？")) {
			var params = {
				id : id,
				auditid: auditid
			};
			url = '${pwd}/user/apply';
			$.post(url, params, function(data) {
				//   alert(data);//这个data就是返回的数据
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
				<div id="product-section" class="product-section container-fluid no-padding">
					<!-- Container -->
					<div class="">
						<div class="row">
							<!-- Section Header -->
							<div class="section-header" style="font-">
								<h3>可领取物品</h3>

							</div><!-- Section Header /- -->
							<ul id="filters" class="products-categories no-left-padding">
								<li><a data-filter="*" class="active" href="#">所有产品</a></li>
								 <!--------------------------------物品标签展示---start--------------------------- -->
								<c:forEach items="${requestScope.typeList}" var="label" varStatus="stat">		
									<li><a data-filter=".${label.itemname }" href="#">${label.itemname }</a></li>
								</c:forEach>	
								<!--------------------------------物品标签展示---end------------------------------ -->	
						
								<li><a data-filter=".video" href="#">其他<i class="fa fa-angle-down"></i></a></li>
							</ul>

							<div class="input-group" style="margin: 0 auto 30px auto;">
								<form action="${pwd }/user/itemsearch">
									<input class="form-control" placeholder="搜索您想要的物品" type="text" style="padding-left: 10px;border: 1px solid rgba(0,0,0,0.5);" name = "name" >
									<span class="input-group-btn">
										<button class="btn btn-search" title="Search" type="submit" style="top:4px;"><i class="fa fa-search"></i></button>
									</span> 
	                       		</form>
							</div>
							<!-- Products ============================-->
							<ul class="products" style="position: relative; height: 1124.6px;">
								<!-- Product -->
								<c:forEach items="${requestScope.listItems}" var="item"
									varStatus="stat">
									<li class="product photography ${item.introduce }"
										style="position: absolute; left: 0px; top: 0px;"><a
										href="${pwd }/user/goodsDetial?id=${item.id}" class="clear"> <img src="${pwd}/upload/${item.itemimg}"
											alt="Product" class="product-img" style="width:100%">
											<h5>${item.itemname}</h5> <span class="price"> 剩余数量： ${item.itemcount}</span>
										</a>
										<div class="wishlist-box">
											<a href="#"><i class="fa fa-arrows-alt"></i></a> 
											<a href="#"><i class="fa fa-search"></i></a>
										</div> 
										<a href="javascript:void(0);" onclick="apply(${item.id}, ${item.auditid } )" class="addto-cart" title="立即申请">立即申请</a>
									</li>
									<!-- Product /- -->
								</c:forEach>
							</ul><!-- Products /- -->
						</div><!-- Row /- -->
						<!-- <nav class="ow-pagination">
							<ul class="pager" style="border-color: rgb(22, 174, 237);">
								<li class="number"><a href="#">Empirefree</a></li>
								<li class="load-more"><a href="#">load More</a></li>
								<li class="previous"><a href="#"><i class="fa fa-angle-right"></i></a></li>
								<li class="next"><a href="#"><i class="fa fa-angle-left"></i></a></li>
							</ul>
						</nav> -->
					</div><!-- Container /- -->
				</div>
			</div>
		</div>
	</div>
	<div id="footer">
		<%@ include file="../baseFrame/userFoot.jsp"%>
	</div>


	<!-- JQuery v1.12.4 -->
	<script src="${pwd}/shopCenter/jquery/all-main/jquery-2.1.3.min.js"></script>
	<!-- Library - Js -->
	<script src="${pwd}/shopCenter/js/div-shop/lib.js"></script>
	<!-- Library - Theme JS -->
	<script src="${pwd}/shopCenter/js/div-shop/div-shop.js"></script>
	<!-- Nav-->
	<script type="text/javascript" src="${pwd}/shopCenter/jquery/nav/jquery.matchHeight.min.js"></script>
	<script type="text/javascript" src="${pwd}/shopCenter/js/nav.js"></script>
</body>

</html>