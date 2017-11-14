/**
 * Created by Administrator on 2017/4/11 0011.
 */


$(function () {
   var oImg=$('#img_box').children();
    var num=0;
    for(var i=0;i<oImg.length;i++){
        (function (index) {
            $(oImg[i]).mouseover(function () {
                $(oImg[index]).prevAll().attr('src','../../assets/img/star-on.png');
                $(oImg[index]).attr('src','../../assets/img/star-on.png');
                $(oImg[index]).nextAll().attr('src','../../assets/img/star-off.png');
            });
            $(oImg[i]).mouseout(function () {
                if(num<1){
                    $(oImg[0]).nextAll().attr('src','../../assets/img/star-off.png');
                }
            });
            $(oImg[i]).click(function () {
                num=index;
                $(oImg[index+1]).prevAll().attr('src','../../assets/img/star-on.png');
            })
        })(i);
    }
});