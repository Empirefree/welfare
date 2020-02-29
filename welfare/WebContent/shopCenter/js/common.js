function gotourl(url) {
  window.location.href = url
  return false
}
$(function() {
	checkMenuHeight()

  var n = 0
  count = $('.item a').length //显示区域的内容长度
  $('.item a').click(function() {
    $(this).addClass('seld').siblings().removeClass('seld')
    var _index = $(this).index() //分屏的数字索引
    $('.cont>a').eq(_index).fadeIn().siblings().fadeOut()
    $('.s_class').show()
    n = _index
  })
  t = setInterval(function() {
    n = n >= count - 1 ? 0 : ++n
    $('.item a').eq(n).trigger('click')
    $('.s_class').show()
  }, 4000) //执行定义好的函数
  $('.banner').hover(
    function() {
      clearInterval(t)
    },
    function() {
      t = setInterval(function() {
        n = n >= count - 1 ? 0 : ++n
        $('.item a').eq(n).trigger('click')
        $('.s_class').show()
      }, 4000)
    }
  )
  //首页幻灯片切换效果

  var $li = $('.tabs-title li'),
    $content = $('.tabs-content-item'),
    $index

  $li.click(function() {
    $(this).addClass('focus').siblings().removeClass('focus')
    $index = $li.index($(this))
    $content.eq($index).show().siblings().hide()
  })

  $('.videoList li').hover(function() {
    $(this).addClass('on').siblings().removeClass('on')
  })

  $('.jobsCon_li').click(function() {
    $('.jobsCon_li').removeClass('select').find('.jobsCons').hide()
    $(this).addClass('select').find('.jobsCons').show()
  })

  $('.listCon li, .auditReport_list li').hover(
    function() {
      $(this).addClass('focus')
    },
    function() {
      $(this).removeClass('focus')
    }
  )

  $('.donateInfo_table tr').hover(
    function() {
      $(this).find('.donateInfo_table_ico_btn').show()
    },
    function() {
      $(this).find('.donateInfo_table_ico_btn').hide()
    }
  )

  /*$(".donateInfo_table_ico_btn").click(function(){
		$(".donateInfo_table_bg, .donateInfo_box").show();
	});*/

  $('.donateInfo_table_ico_btn_1').click(function() {
    $('.donateInfo_table_bg_1, .donateInfo_box_1').show()
  })

  $('.donateInfo_table_ico_btn_2').click(function() {
    $('.donateInfo_table_bg_1, .donateInfo_box_2').show()
  })

  $('.donateInfo_table_ico_btn_3').click(function() {
    $('.donateInfo_table_bg_1, .donateInfo_box_3').show()
  })

  $('.donateInfo_table_ico_btn_4').click(function() {
    $('.donateInfo_table_bg_1, .donateInfo_box_4').show()
  })

  $('.donateInfo_table_ico_btn_5').click(function() {
    $('.donateInfo_table_bg_1, .donateInfo_box_5').show()
  })

  $('.closeA').click(function() {
    $(this).parents('.donateInfo_box').hide()
    $(this).parents('.donateInfo_box').siblings('.donateInfo_table_bg').hide()
  })
})

function checkMenuHeight () {
	setInterval(function () {
    resizePageHeight()
  }, 1000)
	resizePageHeight()
}

function resizePageHeight () {
	var $menu = $('.subMenu')
	if ($menu.length < 1) {
		return
	}
	var $content = $('.content')
	var $contentRight = $('.contentRight')
	var height = $menu.height() + 100
	if ($contentRight.height() < height) {
		$content.height(height)
	} else {
    $content.css('height', 'auto')
  }
}
