//main_slide swiper
$(function(){
    let mainSwiper = new Swiper('.main_slide .swiper-container', {
        autoplay: {
            delay: 3500,
            disableOnInteraction: false,
        },
        speed: 700,
        loop: true,
        effect: "fade",
        navigation: {
            nextEl: ".main_slide .swiper-button-next",
            prevEl: ".main_slide .swiper-button-prev",
        },
        pagination: {
            el: ".main_slide .swiper-pagination",
          },
    });

    let mobileSize = window.matchMedia("(max-width: 500px)");
    if (mobileSize.matches) {
        // 0 ~ 500px
        $(".main_img1").attr("src", "/tiggle/resources/images/mobile_slide_1.jpg");
        $(".main_img2").attr("src", "/tiggle/resources/images/mobile_slide_2.jpg");
        $(".main_img3").attr("src", "/tiggle/resources/images/mobile_slide_3.jpg");
        $(".main_img4").attr("src", "/tiggle/resources/images/mobile_slide_4.jpg");
        $(".main_img5").attr("src", "/tiggle/resources/images/mobile_slide_5.jpg");
    } else {
        // 501px ~
        $(".main_img1").attr("src", "/tiggle/resources/images/pc_slide_1.jpg");
        $(".main_img2").attr("src", "/tiggle/resources/images/pc_slide_2.jpg");
        $(".main_img3").attr("src", "/tiggle/resources/images/pc_slide_3.jpg");
        $(".main_img4").attr("src", "/tiggle/resources/images/pc_slide_4.jpg");
        $(".main_img5").attr("src", "/tiggle/resources/images/pc_slide_5.jpg");
    }
});

$(window).resize(function(){
    let mobileSize = window.matchMedia("(max-width: 500px)");
    if (mobileSize.matches) {
        // 0 ~ 500px
        $(".main_img1").attr("src", "/tiggle/resources/images/mobile_slide_1.jpg");
        $(".main_img2").attr("src", "/tiggle/resources/images/mobile_slide_2.jpg");
        $(".main_img3").attr("src", "/tiggle/resources/images/mobile_slide_3.jpg");
        $(".main_img4").attr("src", "/tiggle/resources/images/mobile_slide_4.jpg");
        $(".main_img5").attr("src", "/tiggle/resources/images/mobile_slide_5.jpg");
    } else {
        // 501px ~
        $(".main_img1").attr("src", "/tiggle/resources/images/pc_slide_1.jpg");
        $(".main_img2").attr("src", "/tiggle/resources/images/pc_slide_2.jpg");
        $(".main_img3").attr("src", "/tiggle/resources/images/pc_slide_3.jpg");
        $(".main_img4").attr("src", "/tiggle/resources/images/pc_slide_4.jpg");
        $(".main_img5").attr("src", "/tiggle/resources/images/pc_slide_5.jpg");
    }
});
//main_slide swiper end

//main_notice swiper
$(function(){
    $.ajax({
        url: 'ntop3.do',
        type: 'post',
        dataType: 'json',
        success: function(data){
            console.log('success : ' + data); //[object Object]
				
            //배열을 가지고 오는 json 을 처리할 때
            //object --> string
            var str = JSON.stringify(data);
            
            //string --> json : parsing
            var json = JSON.parse(str);

            values = '';

            for (var i in json.nlist) {
                var noticeHTML = '<p>번호&nbsp;' + json.nlist[i].nNo
                                + '</p><p><a href="ndetail.do?no=' + json.nlist[i].nNo + '">'
                                    + decodeURIComponent(json.nlist[i].nTitle).replace(/\+/gi, ' ')
                                + '</a></p><p>' + json.nlist[i].nDate 
                                + '</p>';
                                
                // swiper-slide의 nth-child에 해당하는 .new_notice에 각각의 값을 추가
                $('.swiper-slide:nth-child(' + (parseInt(i) + 1) + ') .new_notice').html(noticeHTML);
            }
        }, //success end
        error: function(jqXHR, textStatus, errorThrown){
            console.log('error : ' + jqXHR + ', ' + textStatus + ', ' + errorThrown);
        }, //error end
    });//ajax end

    let mainNoticeSwiper = new Swiper('.main_notice .swiper-container', {
        direction: 'vertical',
        autoplay: {
            delay: 3500,
            disableOnInteraction: false,
        },
        speed: 700,
        loop: true,
    });
});
//main_notice swiper end