/**
 * Created by Administrator on 2017/4/6.
 */

// 页面加载完回调
$(function () {
    
    // tree折叠代码开始
    $('#tree_1_switch').click(function () {
        $(this).toggleClass('switch_root_open');
        $('#tree_1_ul').toggle(500)
    });
    
    $('#tree_3_switch').click(function () {
        $(this).toggleClass('switch_center_close');
        $('#tree_3_ul').toggle(500);
    });
    
    $('#tree_5_switch').click(function () {
        $(this).toggleClass('switch_center_close');
        $('#tree_5_ul').toggle(500);
    });
    
    $('#tree_8_switch').click(function () {
        $(this).toggleClass('switch_center_close');
        $('#tree_8_ul').toggle(500);
    });
    
    $('#tree_11_switch').click(function () {
        $(this).toggleClass('switch_center_close');
        $('#tree_11_ul').toggle(500);
    });
    
    $('#tree_15_switch').click(function () {
        $(this).toggleClass('switch_center_close');
        $('#tree_15_ul').toggle(500);
    });
    
    $('#tree_18_switch').click(function () {
        $(this).toggleClass('switch_center_close');
        $('#tree_18_ul').toggle(500);
    });
    
    $('#tree_23_switch').click(function () {
        $(this).toggleClass('switch_center_close');
        $('#tree_23_ul').toggle(500);
    });
    
    $('#tree_26_switch').click(function () {
        $(this).toggleClass('switch_bottom_close');
        $('#tree_26_ul').toggle(500);
    });
    // tree折叠代码结束
    //table里面弹出框代码开始
    $('.kb_item').mouseover(function () {
        console.log('over');
        $(this).popover('show');
    }).mouseout(function () {
        console.log('out');
        $(this).popover('hide');
    });
    //table里面弹出框代码结束


    
});


