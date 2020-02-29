<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--谷歌翻译--><div id="google_translate_element" style="margin-left: 1150px;"></div>    
<div id="header">
	<div class="header c">
		<a href="${pwd}/user/main" class="logo"><img src="${pwd}/images/logo.jpg" style="height: 66px;margin-top:6px" alt="welfare" title="welfare" /></a>
		<ul class=" menu nav_login_ul" style="display:none">
			<li><a href="/Index_2.html">Fantasy</a></li>
		</ul>
		<ul class=" menu nav_login_ul">
			<c:if test="${user == null }">
				<li><a href="${pwd}/user/login">登陆</a></li>
				<li><a href="#">|</a></li>
				<li><a href="${pwd}/user/register">注册</a></li>
			</c:if>
			<c:if test="${user != null }">
				<li><a href="${pwd }/user/userMain">个人主页</a></li>
				<li><a href="${pwd }/user/logout">&nbsp&nbsp退出</a></li>
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
			<li><a href="${pwd}/user/activity">我们的活动</a></li>
			<li><a href="${pwd}/user/aboutUs">关于我们</a></li>
		</ul>
		  <script>
        function googleTranslateElementInit() {
            new google.translate.TranslateElement({
                layout: google.translate.TranslateElement.InlineLayout.HORIZONTAL
            }, 'google_translate_element');
        }
	    </script>
	    <script src="${pwd}/js/googletranslate.js"></script>
	</div>
</div>