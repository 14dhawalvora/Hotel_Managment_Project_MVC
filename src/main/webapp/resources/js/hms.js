$('.forUpScroll').bind('click', function () {
    $('html, body').animate({
        scrollTop: $(".fixed-nav-bar").offset().top
    }, 2500);
});

$('.forDwnScroll').bind('click', function () {
    $('html, body').animate({
        scrollTop: $(".ny5").offset().top
    }, 3500);
});