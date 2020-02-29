<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>个人信息</title>
    <meta name="keywords" content="welfare" />
    <meta name="description" content="welfare" />
    <meta content="zh-cn" http-equiv="content-language" />
    <meta content="本页版权归welfare所有。all rights reserved" name="copyright" />
    <link rel="icon" href="${pwd }/images/topicon.png" type="image/ico">
    <link rel="stylesheet" type="text/css" href="${pwd}/userInfoStatic/main.css" />
    <link rel="stylesheet" type="text/css" href="${pwd}/css/my_nav.css" />
    <link href="${pwd}/userInfoStatic/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pwd}/css/leaves.css" />
    <link rel="stylesheet" href="${pwd}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pwd}/userInfoStatic/AdminLTE.min.css">
    <link rel="stylesheet" href="${pwd}/userInfoStatic/skin-blue.min.css">
    <link rel="stylesheet" href="${pwd}/userInfoStatic/style.css">
    <link rel="stylesheet" href="${pwd}/userInfoStatic/layer.css">
    <script type="text/javascript" src="${pwd}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${pwd}/js/city.js"></script>
    <script type="text/javascript" src="${pwd}/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pwd}/js/formUtil.js"></script>
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
                                    <h3 class="box-title">我的账号</h3>
                                </div>
                                <div class="box-body" id="right-box-body">
                                    <div id="right-box-body-replace">
                                        <div class="nav-tabs-custom" style="box-shadow: 0 0;">
                                            <ul class="nav nav-tabs" id="myTab">
                                                <li class="active"><a href="#baseInfo" class="tab-a" id="profile"
                                                        data-toggle="tab">基本资料</a></li>
                                                <li><a href="#actual" class="tab-a" id="profile" data-toggle="tab">实名认证</a></li>
                                                <li><a href="#updatePassword" class="tab-a" id="profile" data-toggle="tab">修改密码</a></li>
                                            </ul>
                                            <div class="tab-content" id="myTabContent">
                                                <div class="tab-pane fade in active" id="baseInfo">
                                                    <form action="${pwd}/user/updataInfo"  class="form-horizontal userForm" id="profileForm" >
                                                        <div class="box-body">
                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">用户名</label>
                                                                <div class="col-sm-6">
                                                                    <label class="control-label">${user.username }</label>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="sex" class="col-sm-2 control-label">性别</label>
																	<div class="col-sm-6">
																		<c:if test="${user.sex == '男' }">
																			<label class="radio-inline"> <input
																				type="radio" name="sex" id="sex1" value="男" checked>男
																			</label>
																			<label class="radio-inline"> <input
																				type="radio" name="sex" id="sex2" value="女">女
																			</label>
																		</c:if>
																		<c:if test="${user.sex == '女' }">
																			<label class="radio-inline"> <input
																				type="radio" name="sex" id="sex1" value="男">男
																			</label>
																			<label class="radio-inline"> <input
																				type="radio" name="sex" id="sex2" value="女" checked>女
																			</label>
																		</c:if>
																	</div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="sex" class="col-sm-2 control-label">地址</label>
                                                                <div class="col-sm-6">
                                                                    <select class="col-md-5" id="leaves-province" style="height: 34px;padding: 6px 12px;font-size: 14px;line-height: 1.42857143;color: #555;background-color: #fff;background-image: none;border: 1px solid #ccc;border-radius: 4px;">
                                                                    </select>
                                                                    <select class="col-md-5 col-md-offset-1" id="leaves-city" style="height: 34px;padding: 6px 12px;font-size: 14px;line-height: 1.42857143;color: #555;background-color: #fff;background-image: none;border: 1px solid #ccc;border-radius: 4px;">
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="address" class="col-sm-2 control-label">详细地址</label>
                                                                <div class="col-sm-6">
                                                                    <textarea name="address" class="form-control" rows="3" check="checkNotEmpty(this)">${user.address }</textarea>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="phone" class="col-sm-2 control-label">电话</label>
                                                                <div class="col-sm-6">
                                                                    <input type="text" class="form-control" id="phone"  check="checkPhone(this)"
                                                                        name="phone" value="${user.phone }">
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="email" class="col-sm-2 control-label">Email</label>
                                                                <div class="col-sm-6">
                                                                    <input type="text" class="form-control" id="email"  check="checkEmail(this)"
                                                                        name="email" value="${user.email }">
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="introduce" class="col-sm-2 control-label">个人简介</label>
                                                                <div class="col-sm-6">
                                                                    <textarea name="introduce" class="form-control" check="checkNotEmpty(this)"
                                                                        rows="3">${user.introduce }</textarea>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="col-md-12">
                                                                    <button type="button" class="btn btn-primary col-md-2 col-md-offset-5" id="profile-form-submit" onclick="checkForm(this)">确定修改
                                                                    </button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="tab-pane fade" id="actual">
                                                    <form action="${pwd}/user/updataInfo"  class="form-horizontal userForm" id="profileForm" method="post">
                                                        <div class="form-group">
                                                            <label for="actualname" class="col-sm-2 control-label">真实姓名</label>
                                                            <div class="col-sm-6">
                                                                <input type="text" class="form-control" id="actualname" check="checkChinese(this)"
                                                                    name="actualname" value="${user.actualname }">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="identity" class="col-sm-2 control-label">学号</label>
                                                            <div class="col-sm-6">
                                                                <input type="text" class="form-control" id="identity"
                                                                    name="identity" value="${user.identity }" check="checkNotEmpty(this)">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-md-12">
                                                                <button type="button" class="btn btn-primary col-md-2 col-md-offset-5" id="profile-form-submit" onclick="checkForm(this)">提交
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="tab-pane fade" id="updatePassword">
                                                    <form  action="${pwd}/user/updatPassword"   class="form-horizontal userForm" id="profileForm" method="post">
                                                        <div class="form-group">
                                                            <label for="password" class="col-sm-2 control-label">原密码</label>
                                                            <div class="col-sm-6">
                                                                <input type="password" class="form-control" id="password" check="checkNotEmpty(this)"
                                                                    name="password" value="">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="newpassword" class="col-sm-2 control-label">新密码</label>
                                                            <div class="col-sm-6">
                                                                <input type="password" class="form-control" id="newpassword" check="checkNotEmpty(this)"
                                                                    name="newpassword" value="">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="renewpassword" class="col-sm-2 control-label">新密码</label>
                                                            <div class="col-sm-6">
                                                                <input type="password" class="form-control" id="renewpassword"  check="compareInput('newpassword','renewpassword')"
                                                                    name="renewpassword" value="">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-md-12">
                                                                <button type="button" onclick="myCheckForm(this)" class="btn btn-primary col-md-2 col-md-offset-5" id="profile-form-submit">提交
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </form>
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

    <script>
    	function myCheckForm(obj){
    		var formDOM = $(obj).parents("form");
    	    var varList = $(formDOM).find("[name]");
    	    var flag = true;
    	    varList.each(function () {
    	        var checkFun = $(this).attr("check");
    	        if (checkFun && /(\S+)/.test(checkFun)) {
    	            if (!eval(checkFun)) {
    	                $(this).addClass("inp_error");
    	                $(this).focus();
    	                flag = false;
    	                console.error(this);
    					var errmsg = $.trim($(this).attr("errmsg"));
    					if(errmsg){
    						alert(errmsg);
    					}else{
    						alert("请按要求填写所有信息");
    					}
    	                return false;
    	            }
    	            $(this).removeClass("inp_error");
    	        }
    	    });
    	    if (!flag) return;
    	    $.ajax({
    	    	url:formDOM.attr("action"),
    	    	method:"post",
    	    	dateType:"text",
    	    	contentType: "application/x-www-form-urlencoded; charset=UTF-8",
    	    	data:getDataToJson(obj),
    	    	success:function(msg){
    	    		alert(decodeURI(msg));
    	    		console.log(msg);
    	    	},
    	    	error:function(){
    	    		alert("network error");
    	    	}
    	    });
    	}
    </script>
</body>

</html>