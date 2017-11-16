/**
 * Created by Administrator on 2017/4/6.
 */

$(function () {

    showAll();

    var data = [];



    // 显示所有数据
    function showAll() {
        data = trainData.concat();
        showData();
    }

    $('#showAll').click(function () {
        $('.courseList').empty();
        showAll();
    });
    $('#showTypeOne').click(function () {
        $('.courseList').empty();
        showTypeOne();
    });
    $('#showTypeTwo').click(function () {
        $('.courseList').empty();
        showTypeTwo();
    });
    $('#showTypeThree').click(function () {
        $('.courseList').empty();
        showTypeThree();
    });
    $('#showTypeFour').click(function () {
        $('.courseList').empty();
        showTypeFour();
        activeChange();
    });

    function activeChange() {
        $('#id>li').each(function () {

            $(this).click(function () {
                console.log(e.target);
            })

        })
    }
    
    // 显示类型为 IT技能培训
    function showTypeOne() {
        data = [];
        for (var i=0;i<trainData.length;i++){
            if(trainData[i].courseType=="IT技能培训"){
                data.push(trainData[i]);
            }
        }
        showData();
    }

    // 显示类型为 沟通技巧
    function showTypeTwo() {
        data = [];
        for (var i=0;i<trainData.length;i++){
            if(trainData[i].courseType=="沟通技巧"){
                data.push(trainData[i]);
            }
        }
        showData();
    }

    // 显示类型为 管理类课程
    function showTypeThree() {
        data = [];
        for (var i=0;i<trainData.length;i++){
            if(trainData[i].courseType=="管理类课程"){
                data.push(trainData[i]);
            }
        }
        showData();
    }

    // 显示类型为 销售营销
    function showTypeFour() {
        data = [];
        for (var i=0;i<trainData.length;i++){
            if(trainData[i].courseType=="销售营销"){
                data.push(trainData[i]);
            }
        }
        showData();
    }


    // 显示数据函数
    function showData() {
        var list = '';
        for (var i=0;i<data.length;i++){
            // 循环一次，创建一个li
            list += '<li class="courseItem clearfix"> ' +
                '<div class="row"> ' +
                '<div class="col-lg-offset-0 col-lg-3 col-md-offset-0 col-md-3 col-sm-offset-4 col-sm-3 col-xs-offset-2 col-xs-6"> ' +
                '<div class="itemLogoBox"> ' +
                '<a href="#"> ' +
                '<img class="itemLogo" src="'+data[i].img+'" alt=""> ' +
                '</a> ' +
                '</div> ' +
                '<div class="clearfix"></div> ' +
                '<div class="text-center itemBottomText">' +
                '审批状态： ' +
                '<span class="label label-default">'+data[i].approvalStatus+'</span> ' +
                '</div> ' +
                '</div> ' +
                '<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12"> ' +
                '<div class="itemBody"> ' +
                '<div class="itemTitle"> ' +
                '<a href="" target="_blank"> ' +
                '<strong>'+data[i].title+'</strong> ' +
                '</a> ' +
                '</div> ' +
                '<div class="clearfix"></div> ' +
                '<br> ' +
                '<div class="itemContent"> ' +
                '<table> ' +
                '<tr> ' +
                '<td>课程编号：'+data[i].courseId+'</td> ' +
                '<td> ' +
                '<span class="f-1">课程类别：'+data[i].courseType+'</span> ' +
                '</td> ' +
                '</tr> ' +
                '<tr> ' +
                '<td> ' +
                '<span class="f-1">课程讲师：'+data[i].lecturer+'</span> ' +
                '</td> ' +
                '<td> ' +
                '<span>发布时间：</span> ' +
                '<span>'+data[i].releaseTime+'</span> ' +
                '</td> ' +
                '</tr> ' +
                '<tr> ' +
                '<td> ' +
                '<span>课程学分：'+data[i].courseNum+'</span> ' +
                '</td> ' +
                '<td> ' +
                '<span>培训课时：'+data[i].courseHours+'</span> ' +
                '</td> ' +
                '</tr> ' +
                '<tr> ' +
                '<td> ' +
                '<span>培训时间：'+data[i].trainingTime+'</span> ' +
                '</td> ' +
                '<td> ' +
                '<span>报名时间：'+data[i].registrationTime+'</span> ' +
                '</td> ' +
                '</tr> ' +
                '<tr> ' +
                '<td> ' +
                '<span>学员名额：0</span> ' +
                '</td> ' +
                '<td> ' +
                '<span>报名状态：'+data[i].registrationStatus+' </span> ' +
                '</td> ' +
                '</tr> ' +
                '</table> ' +
                '</div> ' +
                '</div> </div> </div> </li>';
        }
        $(list).appendTo('.courseList');
    }
    
    
    
    
});


