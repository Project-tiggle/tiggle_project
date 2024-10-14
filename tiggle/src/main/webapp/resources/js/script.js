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

    var mainNoticeSwiper = new Swiper('.main_notice .swiper-container', {
        direction: 'vertical',
        autoplay: {
            delay: 3500,
            disableOnInteraction: false,
        },
        speed: 700,
    });
});
//main_notice swiper end