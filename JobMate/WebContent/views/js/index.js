$(window, document, undefined).ready(function() {
  
  
  // Show overlay & Open modal
  
  $( ".login-modal-overlay" ).click(function() {
    $(this).fadeOut(200);
  });
  $( ".openb" ).click(function() {
    $(".login-modal-overlay").fadeIn(200);
  });
  $(".login-modal").click(function(event) {
    event.stopPropagation();
  });
    
$( ".register-modal-overlay" ).click(function() {
    $(this).fadeOut(200);
  });
  $( ".openrb" ).click(function() {
    $(".register-modal-overlay").fadeIn(200);
  });
  $(".register-modal").click(function(event) {
    event.stopPropagation();
  });
  
     
  
  // Input label

  $('input').blur(function() {
    var $this = $(this);
    if ($this.val())
      $this.addClass('used');
    else
      $this.removeClass('used');
  });
  
  
  // Animations

  var $ripples = $('.ripples');

  $ripples.on('click.Ripples', function(e) {

    var $this = $(this);
    var $offset = $this.parent().offset();
    var $circle = $this.find('.ripplesCircle');

    var x = e.pageX - $offset.left;
    var y = e.pageY - $offset.top;

    $circle.css({
      top: y + 'px',
      left: x + 'px'
    });

    $this.addClass('is-active');

  });

  $ripples.on('animationend webkitAnimationEnd mozAnimationEnd oanimationend MSAnimationEnd', function(e) {
  	$(this).removeClass('is-active');
  });

});

// jQuery for page scrolling feature - requires jQuery Easing plugin
$(function() {
    $('body').on('click', '.page-scroll a', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: $($anchor.attr('href')).offset().top
        }, 1500, 'easeInOutExpo');
        event.preventDefault();
    });
});

// Highlight the top nav as scrolling occurs
$('body').scrollspy({
    target: '.navbar-fixed-top'
})

// Closes the Responsive Menu on Menu Item Click
$('.navbar-collapse ul li a').click(function() {
    $('.navbar-toggle:visible').click();
});

// Reveal CSS Animations
new WOW().init();

jQuery(function( $ ){ //Prevent conflict - http://snipplr.com/view/43906/

// Back to Top
	var scrollDiv = document.createElement("div");
	jQuery(scrollDiv).attr("id", "toTop").attr("data-toggle", "tooltip").attr("data-placement", "left").attr("title", "Back to Top").html("<i class='fa  fa-chevron-up'></i>").appendTo("body");    
	jQuery(window).scroll(function () {
		if (jQuery(this).scrollTop() != 0) {
			jQuery("#toTop").fadeIn();
		} else {
			jQuery("#toTop").fadeOut();
		}
	});
	jQuery("#toTop").click(function () {
		jQuery("body,html").animate({
			scrollTop: 0
		},
		800);
	});
  });


