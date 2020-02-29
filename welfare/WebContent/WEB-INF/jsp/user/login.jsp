<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>用户登入</title>
	<meta name="keywords" content="welfare" />
	<meta name="description" content="welfare" />
	<meta content="zh-cn" http-equiv="content-language" />
	<meta content="本页版权归welfare所有。all rights reserved" name="copyright" />
	<link rel="icon" href="${pwd }/images/topicon.png" type="image/ico">
	<link rel="stylesheet" type="text/css" href="${pwd}/css/main.css" />
	<link rel="stylesheet" type="text/css" href="${pwd}/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pwd}/css/my_login.css" />
	<link rel="stylesheet" type="text/css" href="${pwd}/css/my_nav.css" />
	<script type="text/javascript" src="${pwd}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pwd}/js/jquery.jcarousel.min.js"></script>
	<script type="text/javascript" src="${pwd}/js/jquery.fancybox-1.3.4.js"></script>
</head>

<body>
	<%@ include file="navmain.jsp" %>
	<main>
		<img src="${pwd}/images/login_main.jpg" class="main_bg" alt="">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-7 form_div">
					<form action="${pwd}/user/logininfo" class="fh5co-form animate-box" data-animate-effect="fadeInRight">
						<h2>登陆</h2>
						<div class="form-group">
							<label for="username2" class="sr-only">用户名</label>
							<input type="text" class="form-control" id="username" name = "username" placeholder="用户名" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="password2" class="sr-only">密码</label>
							<input type="password" class="form-control" id="password" name = "password"  placeholder="密 码" autocomplete="off">
						</div>
						<div class="form-group">
							<p>没有注册? <a href="${pwd }/user/register">注册</a> | <a href="${pwd }/admin/">管理员登陆?</a></p>
						</div>
						<div style="color:red">${userLoginErrMsg }</div>
						<div class="form-group row">
							<input type="submit" value="登陆" class="btn btn-primary col-md-4 col-md-offset-4" style="">
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>
	<script type="text/javascript">
		$(function () {
			$("#various1").fancybox({
				'centerOnScroll': 'true'
			});
			// $.fancybox({
			// 	'content':$("#inline1"),
			// 	'padding':'0',
			// 	'scrolling':'overflow'
			// });
			$('#mwxd').jcarousel({
				wrap: 'circular',
				auto: 3,
				scroll: 2
			});

			$('#mycarousel').jcarousel({
				wrap: 'circular',
				auto: 0,
				scroll: 2
			});
			$('#mycarousel1').jcarousel({
				wrap: 'circular',
				auto: 0,
				scroll: 2
			});
			$('#mycarousel2').jcarousel({
				wrap: 'circular',
				auto: 0,
				scroll: 2
			});
		});
	</script>
	<script>
		var currentPage = 1;
		var listHeight = 0;
		var slideCurrentIndex = 0;
		var totalDonationsNumber = 0;
		var slideTimer = 0;
		$(function () {
			var url = '/Public/xp_data.json';
			$.getJSON(url, function (data) {

				var time = parseInt(data.time)
				var date = new Date(time);
				$('#dateline-year').html(date.getFullYear());
				$('#dateline-month').html(date.getMonth() + 1);
				$('#dateline-date').html(date.getDate());

				var num = data.total_number;
				$('#totalNumber').html(formateNum(num))

				num = data.total_account;
				num = parseInt(num);
				var intNum = Math.floor(num / 100);
				$('#totalAccount').html(formateNum(intNum))

				loadSlideData(data.list);
			})
			// var top = 0;

			$('.lover_slide').mouseover(function () {
				clearTimeout(slideTimer)
			})

			$('.lover_slide').mouseout(function () {
				startSlideTimer();
			});

			startSlideTimer();
		})

		function startSlideTimer() {
			slideTimer = setTimeout(function () {
				slideUp(slideCurrentIndex + 1);
			}, 3000);
		}

		function slideUp(index) {
			var top = 18 * -1 * index
			$('.lover_list').animate({
				top: top + 'px'
			}, 500, function () {
				if (index > totalDonationsNumber - 1) {
					index = 0;
					top = 0;
					$('.lover_list').css({
						top: top + 'px'
					});
				}
				slideCurrentIndex = index;
			});
			startSlideTimer();
		}

		function getMaxHeight() {
			var height = 0;
			$('.lover_list p').each(function () {
				height += $(this).height();
			})
			return height;
		}

		function loadNextPage() {
			var page = currentPage + 1;
			if (page > 10) {
				return;
			}
			loadSlideData(page)
			currentPage = page;
		}

		function loadSlideData(list) {
			var html = '';
			totalDonationsNumber = list.length;

			list.push(list[0]);
			for (var i = 0; i < list.length; i++) {
				// if (i > 4) {
				// 	break;
				// }
				var item = list[i];
				var amoutTitle = '';
				var amount = parseInt(item.amount);
				amount = Math.floor(amount / 100)
				if (amount >= 10000) {
					amoutTitle = Math.floor(amount / 10000) + '万';
				} else {
					amoutTitle = amount + '元';
				}
				var name = '*' + item.name.substr(1)
				html += '<p><span class="dn_name">' + name + '</span><span class="dn_label">捐赠了</span><span class="dn_amount">' +
					amoutTitle + '</span></p>'
			}
			$('.lover_list').append(html);
		}

		function formateDecimal(num) {
			if (!num) {
				return ''
			}
			num = '' + num;
			if (num.indexOf('.') == -1) {
				return num += '.00';
			}
			num += '00';
			var pointIndex = num.indexOf('.');
			return num.substr(0, pointIndex) + '.' + num.substr(pointIndex + 1, 2);
		}

		function formateNum(numStr) {
			if (!numStr) {
				return ''
			}
			numStr = '' + numStr;
			var result = ''
			while (true) {
				var index = numStr.length - 3;
				if (index < 0) {
					index = 0;
				}
				result = numStr.substr(index) + result;
				if (numStr.length <= 3) {
					break;
				}
				result = ',' + result;
				numStr = numStr.substr(0, numStr.length - 3)
			}
			return result;
		}
	</script>
	<div id="footer">
		<%@ include file="../baseFrame/userFoot.jsp"%>
	</div>
</body>
</html>