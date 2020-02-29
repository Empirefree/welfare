<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="header">
		<div class="header c">
			<a href="${pwd}/user/main" class="logo"><img src="${pwd}/images/logo.jpg" style="height: 66px;margin-top:6px" alt="welfare" title="welfare" /></a>
			<ul class=" menu nav_login_ul">
				<c:if test="${user == null }">
					<li><a href="${pwd}/user/login">登陆</a></li>
					<li><a href="#">|</a></li>
					<li><a href="${pwd}/user/register">注册</a></li>
				</c:if>
				<c:if test="${user != null }">
					<li><a href="${pwd }/user/userMain">个人主页</a></li>
					<li><a href="${pwd }/user/logout">&nbsp退出</a></li>
				</c:if>
			</ul>
			<ul class="menu c">
				<li><a href="${pwd}/user/main">主页</a></li>
				<c:if test="${user == null }">
					<li><a href="${pwd}/user/login">捐赠物品</a></li>
				</c:if>	
				<c:if test="${user != null }">
					<li><a href="${pwd}/user/userPublishItem">捐赠物品</a></li>
				</c:if>
				<li><a href="${pwd}/user/showGoods">领取物品</a></li>
				<li><a href="${pwd}/user/activity">我们的行动</a></li>
				<li><a href="${pwd}/user/aboutUs">关于我们</a></li>
			</ul>
		</div>
	</div>
	
	<style>
		.mcontent{ min-height:450px;}
	</style>
	<div id="main" class="background" style="min-height:700px">
		<div class="content">
			<div class="subMenu">
				<h2><span> 校园公益 </span><i class="icoDown"></i><i class="icoA"></i></h2>
				<ul class="subMenuA">
					<li class="subMenuA_li ">
						<a href="${pwd }/user/activity" class="subMenuA_a">官方活动</a>
					</li>
					<li class="subMenuA_li ">
						<a href="${pwd }/user/helps" class="subMenuA_a">求助信息</a>
					</li>
				</ul>
				<div class="subShare">
					<p class="mt_10"><a href="${pwd }/user/userPublishItem" class="btnA" style="background:none;background-color: red">我要捐赠</a></p>
					<p class="mt_10"><a href="${pwd }/user/userDonation" class="btnA" style="background:none;background-color: red">我的捐赠</a></p>
				</div>
			</div>