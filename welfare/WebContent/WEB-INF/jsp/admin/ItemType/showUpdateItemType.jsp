<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
  <meta charset="UTF-8">
  <title>官方活动</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="format-detection" content="telephone=no">
  <link rel="stylesheet" type="text/css" href="${pwd}/staticAdmin/common/layui/css/layui.css" media="all">
  <link rel="stylesheet" type="text/css" href="${pwd}/staticAdmin/common/bootstrap/css/bootstrap.css" media="all">
  <link rel="stylesheet" type="text/css" href="${pwd}/staticAdmin/common/global.css" media="all">
  <link rel="stylesheet" type="text/css" href="${pwd}/staticAdmin/css/personal.css" media="all">
  <script src="${pwd}/staticAdmin/js/jquery-3.3.1.min.js"></script>
	<script src="${pwd}/staticAdmin/js/ajaxUtil.js"></script>
	<script src="${pwd}/staticAdmin/js/formatUtil.js"></script>
	<script src="${pwd}/staticAdmin/js/formUtil.js"></script>
</head>
<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<header class="larry-personal-tit">
				<span>官方活动</span>
			</header><!-- /header -->
			<div class="larry-personal-body clearfix">
				<form class="layui-form col-lg-5" action="${pwd }/admin/ItemType/updateItemType" method="post">
					<input type="hidden" name="flag" value="2">
					<input type="hidden" name="id" value="${itemType.id }">
					
					<div class="layui-form-item">
						<label class="layui-form-label">物品类型名称</label>
						<div class="layui-input-block">
							<input type="text" name="userid" check="checkNotEmpty(this)" autocomplete="off"
								class="layui-input" value="${ItemType.itemname }">
						</div>
					</div>
					
					<!-- <div class="layui-form-item">
					<label class="layui-form-label">修改头像</label>
					<div class="layui-input-block">
						<input type="file" name="file" class="layui-upload-file">
					</div>
				</div> -->
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" type="button" onclick="checkForm(this)"
								lay-filter="demo1">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="common/layui/layui.js"></script>
	<script type="text/javascript">
		layui.use(['form', 'upload'], function () {
			var form = layui.form();
			layui.upload({
				url: '', //上传接口 
				success: function (res) {
					//上传成功后的回调 
					console.log(res)
				}
			});
		});
	</script>
</body>

</html>