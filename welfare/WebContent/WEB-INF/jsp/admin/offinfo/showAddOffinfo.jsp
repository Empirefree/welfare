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
  <link rel="stylesheet" href="${pwd}/userInfoStatic/bootstrap-datetimepicker.min.css">
  <script src="${pwd}/staticAdmin/js/jquery-3.3.1.min.js"></script>
	<script src="${pwd}/staticAdmin/js/ajaxUtil.js"></script>
	<script src="${pwd}/staticAdmin/js/formatUtil.js"></script>
	<script src="${pwd}/staticAdmin/js/formUtil.js"></script>
	<script type="text/javascript" src="${pwd}/userInfoStatic/bootstrap-datetimepicker.min.js"></script>
	<script src="http://cdn.ckeditor.com/4.5.10/standard/ckeditor.js"></script>
</head>
<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<header class="larry-personal-tit">
				<span>官方活动发布</span>
			</header><!-- /header -->
			<div class="larry-personal-body clearfix">
				<form class="layui-form col-lg-6" action="${pwd }/admin/offinfo/addOffinfo" enctype="multipart/form-data" method="post">
					<input  name="flag" value="2" style="height: 0;width: 0;border: none;">
					<input  name="id" value="" style="height: 0;width: 0;border: none;">
					<input  name="actid" value="1" style="height: 0;width: 0;border: none;">
					<div class="layui-form-item">
						<label class="layui-form-label">活动图片</label>
						<div class="layui-input-block">
							<input type="file" name="file" check="checkNotEmpty(this)" autocomplete="off"
								class="layui-input" value="">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">活动名称</label>
						<div class="layui-input-block">
							<input type="text" name="name" check="checkNotEmpty(this)" autocomplete="off"
								class="layui-input" value="">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">活动介绍</label>
						<div class="layui-input-block">
							<textarea  name="introduce" id="introduce"
								class="layui-textarea"></textarea>
						</div>
					</div>
					<script type="text/javascript">
					    CKEDITOR.replace('introduce');
					</script>
					<div class="layui-form-item">
						<label class="layui-form-label">开始时间</label>
						<div class="layui-input-block">
							<input type="text" name="starttime" value="2019-01-15 21:05" data-date-format="yyyy-mm-dd hh:ii" check="checkNotEmpty(this)" autocomplete="off"
								class="layui-input" id="starttime">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">结束时间</label>
						<div class="layui-input-block">
							<input type="text" name="endtime" value="2019-04-15 21:05" data-date-format="yyyy-mm-dd hh:ii" check="checkNotEmpty(this)" autocomplete="off"
								class="layui-input" id="endtime">
						</div>
					</div>
					<script>
						$('#starttime').datetimepicker();
						$('#endtime').datetimepicker();
					</script>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" type="button" onclick="checkForm(this,false)"
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