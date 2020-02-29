<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>公益活动</title>
	<meta name="keywords" content="welfare" />
	<meta name="description" content="welfare" />
	<meta content="zh-cn" http-equiv="content-language" />
	<meta content="本页版权归welfare所有。all rights reserved" name="copyright" />
	<link rel="icon" href="${pwd }/images/topicon.png" type="image/ico">
	<link rel="stylesheet" type="text/css" href="${pwd}/css/main.css" />
	<link rel="stylesheet" type="text/css" href="${pwd}/css/my_nav.css" />
	<script type="text/javascript" src="${pwd}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pwd}/js/jquery.jcarousel.min.js"></script>
	<script type="text/javascript" src="${pwd}/js/jquery.fancybox-1.3.4.js"></script>
</head>

<body>
	<%@ include file="../baseFrame/userHead.jsp"%>
			<div class="contentRight">
				<h2 class="conTtile c mt_55">
					<span class="conTtile_name"><i class="conTtile_ico"></i>公益活动</span>
				</h2>
				<div class="contentText pb_67">
					<ul class="listCon ml_34 pt_10">
						
						<c:forEach items="${list}" var="act" varStatus="stat">
							<li class="c"><i class="i-point"></i><em><a href="${pwd }/user/actinfoDetail?id=${act.id}"> ${act.name}   </a></em><span> ${act.starttime } </span></li>
						</c:forEach> 
					
					</ul>
					<div class="page mt_50 tar">
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="footer">
	<%@ include file="../baseFrame/userFoot.jsp"%>
	</div>

	<script type="text/javascript" src="${pwd}/js/common.js"></script>
</body>

</html>