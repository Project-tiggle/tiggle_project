//m_menu slide
$(function(){
    $('.m_btn').on('click', function(){
        $('.m_menu').animate({right: 0}, 300);
    });

    $('.close_btn').on('click', function(){
        $('.m_menu').animate({right : '-300px'}, 300);
    });

});//m_menu slide end
