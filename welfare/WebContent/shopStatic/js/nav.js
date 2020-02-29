'use strict';

(function () {
"use strict";

/**
   * [isMobile description]
   * @type {Object}
*/

window.isMobile = {
	Android: function Android() {
		return navigator.userAgent.match(/Android/i);
	},
	BlackBerry: function BlackBerry() {
		return navigator.userAgent.match(/BlackBerry/i);
	},
	iOS: function iOS() {
		return navigator.userAgent.match(/iPhone|iPad|iPod/i);
	},
	Opera: function Opera() {
		return navigator.userAgent.match(/Opera Mini/i);
	},
	Windows: function Windows() {
		return navigator.userAgent.match(/IEMobile/i);
	},
	any: function any() {
		return isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Opera() || isMobile.Windows();
	}
};
window.isIE = /(MSIE|Trident\/|Edge\/)/i.test(navigator.userAgent);
window.windowHeight = window.innerHeight;
window.windowWidth = window.innerWidth;

/**
   * Fullscreen menu
   */
$('.fullscreenmenu__module').each(function () {
	var self = $(this),
		    triggerID = self.attr('trigger');

	self.on("click", function () {
		$(triggerID).toggleClass('open');
		$(this).toggleClass('open');
	});
	$(triggerID).on("click", function () {
		$(triggerID).toggleClass('open');
		self.toggleClass('open');
	});
});

//*
// Header
//*

var wh = $(window).height(),
	    half = wh / 5,
	    headerHeight = $('header').outerHeight();

$(window).scroll(function () {
	var scrollTop = $(window).scrollTop();

	if (scrollTop >= half) {
		$('header').addClass('is-scroll');
	} else {
		$('header').removeClass('is-scroll');
	}
});

$('.onepage-nav').dropdownMenu({
	menuClass: 'onepage-menu',
	breakpoint: 1200,
	toggleClass: 'active',
	classButtonToggle: 'navbar-toggle',
	subMenu: {
		class: 'sub-menu',
		parentClass: 'menu-item-has-children',
		toggleClass: 'active'
	}
});

$('.onepage-nav').onePageNav({
	currentClass: 'current-menu-item',
	scrollOffset: headerHeight
});

})();