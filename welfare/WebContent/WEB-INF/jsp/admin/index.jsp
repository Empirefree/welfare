<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>welfare后台管理系统</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<!-- load css -->
	<link rel="stylesheet" type="text/css" href="${pwd}/staticAdmin/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pwd}/staticAdmin/common/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pwd}/staticAdmin/css/adminstyle.css" media="all">
</head>

<body>
	<div class="layui-layout layui-layout-admin" id="layui_layout">
		<!-- 顶部区域 -->
		<div class="layui-header header header-demo">
			<div class="layui-main">
				<!-- logo区域 -->
				<div class="admin-logo-box">
					<a class="logo" href="${pwd }/admin/index" title="logo">后台管理系统</a>
					<div class="larry-side-menu">
						<i class="fa fa-bars" aria-hidden="true"></i>
					</div>
				</div>
				<!-- 右侧导航 -->
				<ul class="layui-nav larry-header-item">
					<li class="layui-nav-item">
						${admin.username }
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;" id="lock">
							<i class="iconfont icon-diannao1"></i>
							锁屏</a>
					</li>
					<li class="layui-nav-item">
						<a href="${pwd }/admin/logout">
							<i class="iconfont icon-exit"></i>
							退出</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- 左侧侧边导航开始 -->
		<div class="layui-side layui-side-bg layui-larry-side" id="larry-side">
			<div class="layui-side-scroll" id="larry-nav-side" lay-filter="side">

				<!-- 左侧菜单 -->
				<ul class="layui-nav layui-nav-tree">
					<li class="layui-nav-item layui-this">
						<a href="javascript:;" data-url="main.html">
							<i class="iconfont icon-home1" data-icon='icon-home1'></i>
							<span>后台首页</span>
						</a>
					</li>
					<!-- 个人信息 -->
					<li class="layui-nav-item">
						<a href="javascript:;">
							<i class="iconfont icon-jiaoseguanli"></i>
							<span>用户管理</span>
							<em class="layui-nav-more"></em>
						</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" data-url="${pwd }/admin/user/selectUser">
									<i class="iconfont icon-geren1" data-icon='icon-geren1'></i>
									<span>用户管理</span>
								</a>
							</dd>
						</dl>
					</li>
					<!-- 内容管理 -->
					<li class="layui-nav-item">
						<a href="javascript:;">
							<i class="iconfont icon-wenzhang1"></i>
							<span>内容管理</span>
							<em class="layui-nav-more"></em>
						</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" data-url="${pwd }/admin/offinfo/selectOffinfo">
									<i class="iconfont icon-lanmuguanli" data-icon='icon-lanmuguanli'></i>
									<span>官方活动</span>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" data-url="${pwd }/admin/actinfo/selectActinfo">
									<i class="iconfont icon-lanmuguanli" data-icon='icon-lanmuguanli'></i>
									<span>个人活动</span> 
								</a> 
							</dd> 
							<dd>
								<a href="javascript:;" data-url="${pwd }/admin/leaveidea/selectLeaveidea">
									<i class="iconfont icon-wenzhang2" data-icon='icon-wenzhang2'></i>
									<span>留言提问</span>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" data-url="${pwd }/admin/Item/selectItem">
									<i class="iconfont icon-icon1" data-icon='icon-icon1'></i>
									<span>物品管理</span>
								</a>
							</dd>
						</dl>
					</li>
					<!-- 会员管理 -->
					<li class="layui-nav-item">
						<a href="javascript:;">
							<i class="iconfont icon-m-members"></i>
							<span>申请管理</span>
							<em class="layui-nav-more"></em>
						</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" data-url="${pwd }/admin/apply/selectApply">
									<i class="iconfont icon-zhuti" data-icon='icon-zhuti'></i>
									<span>申请审核</span>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" data-url="${pwd }/admin/support/selectSupport">
									<i class="iconfont icon-zhuti" data-icon='icon-zhuti'></i>
									<span>互助记录</span>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" data-url="${pwd }/admin/ItemType/selectItemType">
									<i class="iconfont icon-zhuti" data-icon='icon-zhuti'></i>
									<span>物品类别</span>
								</a>
							</dd>
						</dl>
					</li>
				</ul>
			</div>
		</div>

		<!-- 左侧侧边导航结束 -->
		<!-- 右侧主体内容 -->
		<div class="layui-body" id="larry-body" style="bottom: 0;border-left: solid 2px #2299ee;">
			<div class="layui-tab layui-tab-card larry-tab-box" id="larry-tab" lay-filter="demo" lay-allowclose="true">
				<div class="go-left key-press pressKey" id="titleLeft" title="滚动至最右侧"><i
						class="larry-icon larry-weibiaoti6-copy"></i> </div>
				<ul class="layui-tab-title">
					<li class="layui-this" id="admin-home"><i class="iconfont icon-diannao1"></i><em>后台首页</em></li>
				</ul>
				<div class="go-right key-press pressKey" id="titleRight" title="滚动至最左侧"><i
						class="larry-icon larry-right"></i></div>
				<ul class="layui-nav closeBox">
					<li class="layui-nav-item">
						<a href="javascript:;"><i class="iconfont icon-caozuo"></i> 页面操作</a>
						<dl class="layui-nav-child">
							<dd><a href="javascript:;" class="refresh refreshThis"><i class="layui-icon">&#x1002;</i> 刷新当前</a>
							</dd>
							<dd><a href="javascript:;" class="closePageOther"><i class="iconfont icon-prohibit"></i> 关闭其他</a>
							</dd>
							<dd><a href="javascript:;" class="closePageAll"><i class="iconfont icon-guanbi"></i> 关闭全部</a></dd>
						</dl>
					</li>
				</ul>
				<div class="layui-tab-content" style="min-height: 150px; ">
					<div class="layui-tab-item layui-show">
						<iframe class="larry-iframe" data-id='0' src="${pwd }/admin/main"></iframe>
					</div>
				</div>
			</div>
		</div>
		<!-- 底部区域 -->
		<div class="layui-footer layui-larry-foot" id="larry-footer">
			<div class="layui-mian">
				<p class="p-admin">
					<span>Copyright &copy; 2019</script> 428工作室 all rights reserved.</span>
				</p>
			</div>
		</div>
	</div>
	<!-- 加载js文件-->
	<script type="text/javascript" src="${pwd}/staticAdmin/common/layui/layui.js"></script>
	<script type="text/javascript" src="${pwd}/staticAdmin/js/larry.js"></script>
	<script type="text/javascript" src="${pwd}/staticAdmin/js/index.js"></script>
</body>
</html>