jQuery(function($) {'use strict',

	
	
	// Hide Header on on scroll down
	 $(window).scroll(function () {
	    if ( $(this).scrollTop() > 150 && !$('header').hasClass('open') ) {
	      $('header').addClass('open');
	      $('header').slideDown();
	    }
	  });

	// accordian
	$('.accordion-toggle').on('click', function(){
		$(this).closest('.panel-group').children().each(function(){
		$(this).find('>.panel-heading').removeClass('active');
		 });

	 	$(this).closest('.panel-heading').toggleClass('active');
	});

	//Initiat WOW JS
	new WOW().init();
	
	
	//smoth scroll
	$(document).ready(function(){
	$('a[href^="#"]').on('click',function (e) {
	    e.preventDefault();

	    var target = this.hash;
	    var $target = $(target);

	  $('html, body').stop().animate({
		'scrollTop': $target.offset().top
	    }, 1300, 'swing');
	});
});
	
	//goto top
	$('.gototop').click(function(event) {
		event.preventDefault();
		$('html, body').animate({
			scrollTop: $("body").offset().top
		}, 500);
	});	


});