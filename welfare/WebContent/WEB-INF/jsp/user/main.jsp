<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>校园公益</title>
	<meta name="keywords" content="welfare" />
	<meta name="description" content="welfare" />
	<meta content="zh-cn" http-equiv="content-language" />
	<meta content="本页版权归welfare所有。all rights reserved" name="copyright" />
	<link rel="icon" href="${pwd }/images/topicon.png" type="image/ico">
	<link rel="stylesheet" type="text/css" href="${pwd}/css/main.css" />
	<link rel="stylesheet" type="text/css" href="${pwd}/css/my_nav.css" />
	<link href="${pwd}/css/index_style.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${pwd}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pwd}/js/jquery.jcarousel.min.js"></script>
	<script type="text/javascript" src="${pwd}/js/jquery.fancybox-1.3.4.js"></script>
</head>

<body>
	<%@ include file="navmain.jsp" %>
	<div id="main">
		<div class="main c">
			<div class="banner" style="width: 100%;">
				<div class="cont">
					<a href="#"> <img src="${pwd}/images/img1.jpg" width="100%"/></a>
					<!--  <a href=""><img src="${pwd}/images/5c09d75a73707.jpg" style="top:143px; position:absolute; left:20px; width:227px;height:130px" /></a>--><a
						href="#"> <img src="${pwd}/images/img2.jpg" width="100%"/></a>
					<!--  <a href=""><img src="${pwd}/images/5b977021e7313.jpg" style="top:143px; position:absolute; left:20px; width:227px;height:130px" /></a>--><a
						href="#"> <img src="${pwd}/images/img3.jpg" width="100%"/></a>
					<!--  <a href="http://wfl.onefoundation.cn/"><img src="${pwd}/images/5b07beefe1dc2.png" style="top:143px; position:absolute; left:20px; width:227px;height:130px" /></a>--><a
						href="#"> <img src="${pwd}/images/img4.jpg" width="100%"/></a>
					<!--  <a href="http://www.onefoundation.cn/index.php?g=home&m=article&a=show&id=1107"><img src="${pwd}/images/5ac19a9715970.png" style="top:143px; position:absolute; left:20px; width:227px;height:130px" /></a>--><a
						href="#"> <img src="${pwd}/images/img5.jpg" width="100%"/></a>
				</div>
				<div class="item">
					<a href="javascript:;" class="seld"></a><a href="javascript:;"></a><a href="javascript:;"></a><a href="javascript:;"></a> </div>
			</div>
			</div>
		<div class="mainMiddle">
			<div class="mainW c">
				<div class="left">
					<div class="c">
						<div class="new">
							<div class="title"><span>官方活动</span></div>
							<div class="newCon">
								<div class="newCon_pic c"> <a href="${pwd }/user/actinfoDetail?id=${topOff.id}"><img src="${pwd}/upload/${topOff.actimg }" alt=" "
										 title="${topOff.name }" width="104" height="78" /></a>
									<div class="newCon_pic_info"> 
										<strong>
											<a href="${pwd }/user/actinfoDetail?id=${topOff.id}"> ${topOff.name } </a>
										</strong>
										${topOff.introduce }<a href="${pwd }/user/actinfoDetail?id=${topOff.id}">[ 详情 ]</a>
									</div>
								</div>
								<ul class="newList" style="padding-bottom:8px;">
									<c:forEach items="${listOffinfo}" var="off" varStatus="stat">
										<li class="c"><a href="${pwd }/user/actinfoDetail?id=${off.id}">  ${off.name} </a><span> ${off.starttime }</span></li>
									</c:forEach>
								</ul>
								<div class="boxMore"><a href="${pwd}/user/activity" class="l">浏览更多</a><a href="${pwd}/user/activity"
									 class="moreIco"></a></div>
							</div>
						</div>
						<div class="video">
							<div class="title"><span>求助信息</span></div>
							<div class="newCon">
								<div class="newCon_pic c"> <a href="${pwd }/user/helpDetial?id=${topAct.id}"><img src="${pwd}/upload/${topAct.actimg }" alt=""
										 title="${topAct.name }" width="104" height="78" /></a>
									<div class="newCon_pic_info"> 
											<strong><a href="${pwd }/user/helpDetial?id=${topAct.id}">${topAct.name }</a>
											</strong>
										<p>${topAct.introduce }<a href="${pwd }/user/helpDetial?id=${topAct.id}">[ 详情 ]</a></p>
									</div>
								</div>
								<ul class="newList" style="padding-bottom:8px;">
									<c:forEach items="${listActinfo}" var="acc" varStatus="stat">
										<li class="c"><a href="${pwd }/user/helpDetial?id=${acc.id}">  ${acc.name} </a><span> ${acc.starttime }</span></li>
									</c:forEach>
								</ul>
								<div class="boxMore"><a href="${pwd }/user/helps" class="l">浏览更多</a><a href="${pwd }/user/helps"
									 class="moreIco"></a></div>
							</div>
						</div>
					</div>
					<style>
						.mwxd .jcarousel-skin-tango .jcarousel-container-horizontal {
							padding: 14px 30px;
							width: 690px;
						}

						.mwxd .jcarousel-skin-tango .jcarousel-clip-horizontal {
							height: 40px;
							width: 690px;
						}

						.mwxd .jcarousel-skin-tango .jcarousel-item {
							width: 95px;
							height: 129px;
						}

						.mwxd .jcarousel-skin-tango .jcarousel-clip-horizontal {
							height: 129px;
						}

						.mwxd .action li a {
							border: none;
						}

						.mwxd .action li {
							border-right: none;
							float: left;
							padding: 12px 35px 5px 13px;
						}

						.mwxd .action ul {
							border: none;
						}

						.mwxd .jcarousel-skin-tango .jcarousel-next-horizontal,
						.mwxd .jcarousel-skin-tango .jcarousel-prev-horizontal {

							top: 65px;
							width: 6px;
						}
					</style>

					<!--  待领取物品 start -->
					<div class="main mwxd" style="width:752px;">
						<ul class="tabsOther tabs-title c">
							<li class="focus"><a href="javascript:;">待领取物品</a></li>
						</ul>
						<div>
							<div class="linkBox tabs-content-item action ">
								<ul id="mwxd" class="jcarousel-skin-tango c">
									<c:forEach items="${listItems}" var="item" varStatus="stat">
										<li> <a href="${pwd }/user/goodsDetial?id=${item.id}" target="_blank"><img
													src="${pwd }/upload/${item.itemimg}" width="100%" height="86" alt="" />
											</a>
											<p align="center" style="display: block;"><a href="${pwd }/user/goodsDetial?id=${item.id}"
													target="_blank">${item.itemname }</a></p>
										</li>
									</c:forEach> 
									
								</ul>
							</div>
						</div>
					</div>
					<!-- 待领取物品 end   -->
				</div>
				<div class="right">
					<p><a href="${pwd }/user/userPublishItem" class="btn_a" style="background:none;background-color: red">我要捐赠</a></p>
					<p><a class="btn_a my_donation" href="${pwd }/user/userDonation" style="background:none;background-color: red">我的捐赠</a></p>
					<div class="mobileList mt_7">
						<div class="index_right">
							<div class="index_love mar_ten section_title" style="padding-left: 40px">
								<div class="index_love_cont">
									<ul>
										<li><span class="name1">捐赠人</span><span class="money1">捐赠内容</span><span
												class="time1">捐赠时间</span></li>
									</ul>
								</div>
								<div class="clear"></div>
								<div id="aa" style="overflow: hidden; height: 142px; margin-bottom:19px;">
									<ul id="aa1">
										<c:set var = "i" value = "0"/>
										<c:forEach items="${items}" var="item" varStatus="stat">
											<li>
												<span class="name2">${userList[i].username}</span>
												<span class="money2">${item.itemname }</span>
												<span class="time2">${item.createtime }</span>
											</li>
											 <c:set var = "i" value = "${i + 1}"/>
										</c:forEach>

									</ul>
									<ul id="aa2">

									</ul>
								</div>
								<script type="text/javascript">
									var speed = 40;
									var aa = document.getElementById("aa");
									var aa2 = document.getElementById("aa2");
									var aa1 = document.getElementById("aa1");
									aa2.innerHTML = aa1.innerHTML;

									function Marquee() {
										if (aa1.offsetHeight <= 136) {
											aa2.innerHTML = "";
										} else {
											if (aa2.offsetTop - aa.scrollTop <= 593) {
												aa.scrollTop = 0;
											} else {
												aa.scrollTop++;
											}
										}
									}
									var MyMar = setInterval(Marquee, speed);
									aa.onmouseover = function () {
										clearInterval(MyMar);
									}
									aa.onmouseout = function () {
										MyMar = setInterval(Marquee, speed);
									}
								</script>
								
							</div>

						</div>
					</div>
					
					
					<div class="subscription mt_10" style="padding-top:14px; padding-bottom:10px;"> 
								<div class="pay" style=" margin-left: 10px;">
									<img src="${pwd}/images/pay.png" style="height:196px;display: block;margin:0 auto;"/>
					</div>
							<div class="mt_6 tar subscription_btn_con" style="padding-top:8px;">
								<p>
									<!-- JiaThis Button BEGIN -->
									<div class="jiathis_style" style="display:inline;">
										<a class="jiathis_button_qzone"></a>
										<a class="jiathis_button_tsina"></a>
										<a class="jiathis_button_tqq"></a>
										<a class="jiathis_button_weixin"></a>
										<a class="jiathis_button_renren"></a>
										<a href="http://www.jiathis.com/share"
											class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"></a>
									</div>
									<script type="text/javascript" src="${pwd}/js/jia.js" charset="utf-8"></script>
								</p>
								<div class="clear"></div>
							</div>
					</div>
				</div>

				
			</div>
		</div>
		<style>
			.jcarousel-skin-tango .jcarousel-item {
				width: 95px;
				height: 120px;
			}

			.jcarousel-skin-tango .jcarousel-clip-horizontal {
				height: 110px;
			}
		</style>
		<div class="main">
			<ul class="tabsOther tabs-title c">
				<li class="focus"><a href="javascript:;">我们的活动</a></li>
			</ul>
			<div>
				<div class="linkBox tabs-content-item" >
					<ul id="mycarousel" class="jcarousel-skin-tango">
						<c:forEach items="${offinfos}" var="off" varStatus="stat">
							<li> <a href="${pwd }/user/actinfoDetail?id=${off.id}" target="_blank"><img src="${pwd }/upload/${off.actimg}" width="95"
										height="86" alt="${off.name }" />
								</a> 
								<h3 style="text-align: center;color:#16aeec">${off.name }</h3>
							</li>
					    </c:forEach>
					    
					</ul>
				</div>
			</div>
		</div>
	</div>
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
				auto: 3,
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
				html += '<p><span class="dn_name">' + name +
					'</span><span class="dn_label">捐赠了</span><span class="dn_amount">' +
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

	<script type="text/javascript" src="${pwd}/js/common.js"></script>
</body>

</html>