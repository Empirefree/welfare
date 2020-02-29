<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>消息管理</title>
    <meta name="keywords" content="welfare" />
    <meta name="description" content="welfare" />
    <meta content="zh-cn" http-equiv="content-language" />
    <meta content="本页版权归welfare所有。all rights reserved" name="copyright" />
   <link rel="icon" href="${pwd }/images/topicon.png" type="image/ico">
    <link rel="stylesheet" type="text/css" href="${pwd}/css/my_nav.css" />
    <link rel="stylesheet" type="text/css" href="${pwd}/userInfoStatic/comments.css" />
    <link href="${pwd}/userInfoStatic/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pwd}/userInfoStatic/bootstrap.min.css">
    <link rel="stylesheet" href="${pwd}/userInfoStatic/AdminLTE.min.css">
    <link rel="stylesheet" href="${pwd}/userInfoStatic/skin-blue.min.css">
    <link rel="stylesheet" href="${pwd}/userInfoStatic/style.css">
    <link rel="stylesheet" href="${pwd}/userInfoStatic/layer.css">
    <link rel="stylesheet" type="text/css" href="${pwd}/userInfoStatic/main.css" />
    <script type="text/javascript" src="${pwd}/userInfoStatic/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pwd}/userInfoStatic/jquery.jcarousel.min.js"></script>
    <script type="text/javascript" src="${pwd}/userInfoStatic/jquery.fancybox-1.3.4.js"></script>
</head>

<body>
    <%@ include file="navmain.jsp" %>
    <div class="main">
        <div class="content-wrapper" style="min-height: 571px;margin-left: 0px">
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
                            <div class="box box-solid">
                                <div class="box-header with-border">
                                    <h3 class="box-title">消息管理</h3>
                                </div>
                                <div class="box-body table-responsive" id="right-box-body">
                                    <div id="right-box-body-replace">
                                        <div class="nav-tabs-custom" style="box-shadow: 0 0;">
                                        	<ul class="nav nav-tabs" id="myTab">
                                                <li class="active"><a href="#itemTab" class="tab-a" id="profile" data-toggle="tab">物品相关</a></li>
                                                <li><a href="#actionTab" class="tab-a" id="profile" data-toggle="tab">活动相关</a></li>
                                                <li><a href="#webTab" class="tab-a" id="profile" data-toggle="tab">网站反馈</a></li>
                                            </ul>
                                            <!-- 物品相关 -->
                                            <div class="tab-content" id="tab-content">
                                                <div class="tab-pane active" id="itemTab" data-comment-type="in">
                                                    <div class="article-list-item">
                                                        <!--我收到的物品-->
                                                        <ul class="comment-list">
                                                        	<!-- <li class="clearfix" style="width:100%">
                                                                <div class="content-box">
	                                                                    <div class="title" style="margin-left:30px">
	                                                                        <span class="user-name">fantsy</span>
	                                                                        <span class="date">1996-1-1</span>
	                                                                        <span>领取了您的：<a class="article-title c-blue" target="_blank"
                                                                            href="">sugar</a></span>
	                                                                    </div>
                                                                </div>
                                                            </li>
                                                             <li class="clearfix" style="width:100%">
                                                                <div class="content-box">
	                                                                    <div class="title" style="margin-left:30px">
	                                                                        <span>您成功领取了</span>
	                                                                        <span class="user-name">leaves</span>的
	                                                                        <span class="user-name"><a class="article-title c-blue" target="_blank"
                                                                            href="">microphone</a></span>
	                                                                        <span class="date">
	                                                                    </div>
	                                                                   	
                                                                </div>
                                                            </li> -->
                                                            
                                                            <!--捐赠物品-->
	                                                        <c:set var = "i" value = "0"/>
	                                                        <c:forEach items="${requestScope.itemsupports1}" var="itemsupports1" varStatus="stat">
	                                                            <li class="clearfix" style="width:100%">
	                                                                <div class="content-box">
		                                                                    <div class="title" style="margin-left:30px">
		                                                                        <span class="user-name">您捐赠的物品${itemsupports1.itemname }</span>
		                                                                        <span class="date">${itemsupports1.createtime}已成功上传！</span>
		                                                                    </div>
	                                                                </div>
	                                                            </li>
	                                                             <c:set var = "i" value = "${i+1 }"/>
	                                                        </c:forEach>
	                                                        <c:set var = "i" value = "0"/>
	                                                        <c:forEach items="${requestScope.itemsupports2}" var="itemsupports2" varStatus="stat">
	                                                            <li class="clearfix" style="width:100%">
	                                                                <div class="content-box">
		                                                                    <div class="title" style="margin-left:30px">
		                                                                        <span class="user-name">您捐赠的物品${itemsupports2.itemname }</span>
		                                                                        <span class="date">${itemsupports2.createtime}未能通过审核！</span>
		                                                                    </div>
	                                                                </div>
	                                                            </li>
	                                                             <c:set var = "i" value = "${i+1 }"/>
	                                                        </c:forEach>
	                                                        
	                                                        <!--领取物品-->
	                                                      	<c:set var = "i" value = "0"/>
	                                                        <c:forEach items="${requestScope.applyusername1}" var="applyusername1" varStatus="stat">
	                                                            <li class="clearfix" style="width:100%">
	                                                                <div class="content-box">
		                                                                    <div class="title" style="margin-left:30px">
		                                                                        <span class="user-name">您领取${applyusername1.username }</span>
		                                                                        <span><a class="article-title c-blue" target="_blank"
	                                                                            href="${pwd }/user/userItemDetail?id=${requestScope.itemname1[i].id}">${requestScope.itemname1[i].itemname}</a></span>
		                                                                        <span class="date">${requestScope.applysupports1[i].createtime}成功</span>
		                                                                        </div>
	                                                                </div>
	                                                            </li>
	                                                             <c:set var = "i" value = "${i+1 }"/>
	                                                        </c:forEach>
	                                                        <c:set var = "i" value = "0"/>
	                                                        <c:forEach items="${requestScope.applyusername2}" var="applyusername2" varStatus="stat">
	                                                            <li class="clearfix" style="width:100%">
	                                                                <div class="content-box">
		                                                                    <div class="title" style="margin-left:30px">
		                                                                        <span class="user-name">您领取${applyusername2.username }</span>
		                                                                        <span><a class="article-title c-blue" target="_blank"
	                                                                            href="${pwd }/user/userItemDetail?id=${requestScope.itemname2[i].id}">${requestScope.itemname2[i].itemname}</a></span>
		                                                                        <span class="date">${requestScope.applysupports2[i].createtime}失败</span>
		                                                                        </div>
	                                                                </div>
	                                                            </li>
	                                                             <c:set var = "i" value = "${i+1 }"/>
	                                                        </c:forEach>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="tab-pane" id="actionTab" data-comment-type="in">
                                                    <div class="article-list-item">
                                                        <ul class="comment-list">
	                                                        <c:set var = "i" value = "0"/>
	                                                        <c:forEach items="${requestScope.actinfos1}" var="actname">
	                                                            <li class="clearfix" style="width:100%">
	                                                                <div class="content-box">
		                                                                    <div class="title" style="margin-left:30px">
		                                                                        <span>您的活动</span>
		                                                                        <span class="user-name"><a class="article-title c-blue" target="_blank"
	                                                                            href="">${actname.name }</a></span>
		                                                                        <span class="date">${requestScope.supports1[i].createtime}成功</span>
		                                                            	            已通过审核	
		                                                                        <span class="date">
		                                                                    </div>
	                                                                </div>
	                                                            </li>
	                                                             <c:set var = "i" value = "${i+1 }"/>
	                                                           </c:forEach>
	                                                         	                                                        <c:set var = "i" value = "0"/>
	                                                        <c:forEach items="${requestScope.actinfos2}" var="actname">
	                                                            <li class="clearfix" style="width:100%">
	                                                                <div class="content-box">
		                                                                    <div class="title" style="margin-left:30px">
		                                                                        <span>您参与</span>
		                                                                        <span class="user-name"><a class="article-title c-blue" target="_blank"
	                                                                            href="">${actname.name }的活动</span>
		                                                                        <span class="date">${requestScope.supports1[i].createtime}成功</span>
		                                                            	            失败	
		                                                                        <span class="date">
		                                                                    </div>
		                                                                   	
	                                                                </div>
	                                                            </li>
	                                                             <c:set var = "i" value = "${i+1 }"/>
	                                                           </c:forEach>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="tab-pane" id="webTab" data-comment-type="in">
                                                    <div class="article-list-item">
                                                        <!--我收到的评论-->
                                                        <ul class="comment-list">
	                                                        <c:set var = "i" value = "0"/>
	                                                        <c:forEach items="${requestScope.leaveideas}" var="inter" varStatus="stat">
	                                                            <li class="clearfix" style="width:100%;border-bottom: 1px dashed #000;">
	                                                            	<c:if test="${requestScope.adminLeaves[i] != null }">
		                                                            	<div class="content-box">
		                                                            		<div class="title" style="">
		                                                                        <span class="user-name">管理员</span>
		                                                                        <span class="date">
		                                                                            <time title="2019-03-16 20:13:54">${inter.createtime }</time></span>
		                                                                        <span>回复了您的问题：</span>
		                                                                        <a class="article-title c-blue" target="_blank"
		                                                                            href="#">${adminLeaves[i].comment}
</a>
		                                                                    </div>
		                                                            	</div>
	                                                            	</c:if>
	                                                                <div class="content-box">
	                                                                    <div class="title" style="margin-left:60px">
	                                                                        <span class="user-name">您在</span>
	                                                                        <span class="date">
	                                                                            <time title="2019-03-16 20:13:54">${inter.createtime }</time></span>
	                                                                        <span>提出了问题：</span>
	                                                                        <a class="article-title c-blue" target="_blank"
	                                                                            href="#">${inter.comment }</a>
	                                                                    </div>
	                                                                </div>
	                                                            </li>
	                                                             <c:set var = "i" value = "${i+1 }"/>
	                                                           </c:forEach>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>
    <%@ include file="../baseFrame/userFoot.jsp"%>

    <script src="${pwd}/userInfoStatic/hm.js"></script>
    <script type="text/javascript" src="${pwd}/userInfoStatic/jquery.min.js"></script>
    <script type="text/javascript" src="${pwd}/userInfoStatic/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pwd}/userInfoStatic/layer.js"></script>
    <script type="text/javascript" src="${pwd}/userInfoStatic/script.js"></script>
    <script type="text/javascript" src="${pwd}/userInfoStatic/adminlte.min.js"></script>
    <script>
        var _hmt = _hmt || [];
        (function () {
            var hm = document.createElement("script");
            hm.src = "https://hm.baidu.com/hm.js?73151ce4e3789ae86d394e4b23743b8b";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>
    <script type="text/javascript" src="${pwd}/userInfoStatic/bootstrapValidator.js"></script>
    <script type="text/javascript" src="${pwd}/userInfoStatic/account.js"></script>


</body>

</html>