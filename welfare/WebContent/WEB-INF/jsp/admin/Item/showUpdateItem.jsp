<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>物品信息</title>
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
		<script type="text/javascript" src="${pwd}/staticAdmin/common/layui/layui.js"></script>
	
</head>

<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<header class="larry-personal-tit">
				<span>物品信息</span>
			</header><!-- /header -->
			<div class="larry-personal-body clearfix">
				<form class="layui-form col-lg-5" action="${pwd }/admin/Item/updateItem" method="post">
					<input type="hidden" name="flag" value="2">
					<input type="hidden" name="id" value="${item.id }">
					<div class="layui-form-item">
						<label class="layui-form-label">物品名</label>
						<div class="layui-input-block">
							<input type="text" name="itemname" check="checkNotEmpty(this)" autocomplete="off" class="layui-input"
								value="${Item.itemname }">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">物品数量</label>
						<div class="layui-input-block">
							<input type="text" name="itemcount" check="checkNotEmpty(this)" autocomplete="off" class="layui-input" value="${Item.itemcount }">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">物品简介</label>
						<div class="layui-input-block">
							<textarea placeholder=""check="checkNotEmpty(this)"  name="introduce" class="layui-textarea">${Item.introduce }</textarea>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">上传人ID</label>
						<div class="layui-input-block">
							<input type="text" name="userid" check="checkNotEmpty(this)" autocomplete="off" class="layui-input" value="${Item.userid }">
						</div>
					</div>
					<!-- <div class="layui-form-item">
					<label class="layui-form-label">修改头像</label>
					<div class="layui-input-block">
						<input type="file" name="file" class="layui-upload-file">
					</div>
				</div> -->
					<div class="layui-form-item">
						<label class="layui-form-label">物品类型</label>
						<div class="layui-input-block">
							<select name="typeid" lay-filter="aihao" name="typeid">
								<option value=""></option>
								<option value="1" selected="selected">学习资料</option>
								<option value="2">生活用品</option>
								<option value="3">现金</option>
								<option value="4">其他</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">审核情况</label>
						<div class="layui-input-block">
							<select name="auditid" lay-filter="aihao" name="auditid">
								<option value="1" selected="selected">审核中</option>
								<option value="2">审核成功</option>
								<option value="3">审核失败</option>
							</select> 
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" type="button" onclick="checkForm(this)" lay-filter="demo1">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="${pwd}/staticAdmin/common/layui/layui.js"></script>
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