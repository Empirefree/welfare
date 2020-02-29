<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>我的捐赠</title>
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
                                    <h3 class="box-title">我的捐赠</h3>
                                </div>

                                <div class="box-body table-responsive" id="right-box-body">

                                    <div id="right-box-body-replace">

                                        <div class="nav-tabs-custom" style="box-shadow: 0 0;">
                                            <div class="tab-content" id="tab-content">
                                                <div class="tab-pane active" id="tab-pane" data-post-status="all">
                                                    <table class="table">
                                                        <tbody>
                                                           <c:set var = "i" value = "0"/>
                                                           <c:forEach items="${itemList}" var="item"
															varStatus="stat">
															<tr>
																<td style="width: 100px; height: 100px;"><img
																	src="${pwd}/upload/${item.itemimg } " alt=""></td>
																<td>
																	<p>
																		<a href="${pwd }/user/userItemDetail?id=${item.id}"> ${item.itemname } </a>
																	</p>
																	<ul class="list-inline">
																		<li><a href="##" class="link-black text-sm">
																				<i class="fa fa-comments-o margin-r-5"></i><span>评论： ${cntList[i] } </span>
																		</a></li>
																		<li><a href="##" class="link-black text-sm">
																				<i class="fa fa-clock-o margin-r-5"></i><span>时间：${item.createtime }</span>
																		</a></li>
																	</ul>
																</td>
															</tr>
															<c:set var = "i" value = "${i + 1}"/>
														</c:forEach>
                                                        </tbody>
                                                    </table>
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
    <script type="text/javascript" src="${pwd}/userInfoStatic/bootstrapValidator.js"></script>
    <script type="text/javascript" src="${pwd}/userInfoStatic/account.js"></script>


</body>

</html>