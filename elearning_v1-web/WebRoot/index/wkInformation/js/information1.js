/**
 * Created by Administrator on 2017/4/7 0007.
 */

$(function () {
    stystem();
    curriculum();
    company();
    department();
    department1();
});
//插入两个td元素
function insetToTd(title,pubdate,long,tbody,src) {
    for(var i=0;i<long;i++){
        var oTr=$("<tr></tr>");
        var oTd1=$("<td><a href='"+src[i]+"'>"+title[i]+"</a></td>");
        var oTd2=$("<td>"+pubdate[i]+"</td>");
        oTr.append(oTd1);
        oTr.append(oTd2);
        $(tbody).append(oTr)
    }
}
//插入三个td元素
function insetToTd1(title,pubdate,long,tbody,name,src) {
    for(var i=0;i<long;i++){
        var oTr=$("<tr></tr>");
        var oTd1=$("<td><a href='"+src[i]+"'>"+title[i]+"</a></td>");
        var oTd2=$("<td>"+name[i]+"</td>");
        var oTd3=$("<td>"+pubdate[i]+"</td>");
        oTr.append(oTd1);
        oTr.append(oTd2);
        oTr.append(oTd3);
        $(tbody).append(oTr)
    }
}
//系统公告
function stystem() {
    var title=["相比于传统教育，在线教育的好处很多","相比于传统模式的教育，在线教育的劣势也很明显。",
    "在线教育，一个新的教育发展行业","组织高效的学习活动是培训人追寻的目标","以满腔的热情和良好的师德做个好老师",
    "课程开发不得不注意的一些地方，提升你的开发效率","分型pdf文档管理技巧，不得不学的技巧","五种常用的设计模型，设计模型游刃有余",
"如何制作scorm标准的网络课程？","scorm到底是做什么的？如何播放scorm课件？","国内做elearning课程一般都会用SCORM标准吗？",
    "e-learing课件的现实与发展方向以及解决方案","学习对象(LO)与LMS交互实现","scorm的好处和原理",
    "从传统教室到网络学习，需要的是“转变”而不是“传递”"];
    var pubdate=["2015-07-17","2015-07-17","2015-07-17","2015-07-17","2015-07-17","2015-07-17","2015-07-16","2015-07-16"
    ,"2013-05-20","	2013-05-17","2013-05-17","2013-05-17","2013-05-17","2012-08-31","2012-08-31"];
    var href=["informztion-zi/template.html","informztion-zi/template.html","informztion-zi/template.html"
        ,"informztion-zi/template.html","informztion-zi/template.html","informztion-zi/template.html"
        ,"informztion-zi/template.html","informztion-zi/template.html","informztion-zi/template.html"
        ,"informztion-zi/template.html","informztion-zi/template.html","informztion-zi/template.html"
        ,"informztion-zi/template.html","informztion-zi/template.html","informztion-zi/template.html"];
    var long=title.length;
    $('.badge1').text(long);
    var tbody=".tbody1";
    var tbody1=".tbody1 tr";
    var badge=".badge1";
    var input=".input1";
    insetToTd(title,pubdate,long,tbody,href);
    search(input,tbody1,badge)
}
//课程公告
function curriculum() {
        var title=["月底进行测验考试，请大家做好复习","Chrome调试小技巧","Javascript执行效率小结",
        "浅谈算法和数据结构: 二 基本排序算法","每个程序员都应该知道的8个Linux命令","跟新的课件请大家及时观看",
        "相关课件资料已上传，请及时下载！","近期将会开设线下培训课程，请大家踊跃报名！"];
        var name=["学习平台演示课程","LMS操作指南","LMS操作指南","LMS操作指南","LMS操作指南","LMS操作指南",
        "学习平台演示课程","学习平台演示课程"];
        var pubdate=["2015-07-23","2015-07-23","2015-07-23","2015-07-23","2015-07-23","	2013-11-05",
        "2013-03-16","2013-03-16"];
        var href=["informztion-zi/template.html","informztion-zi/template.html"
            ,"informztion-zi/template.html","informztion-zi/template.html"
            ,"informztion-zi/template.html","informztion-zi/template.html"
            ,"informztion-zi/template.html","informztion-zi/template.html"];
        var tbody=".tbody2";
        var tbody1=".tbody2 tr";
        var long=title.length;
         $('.badge2').text(long);
        insetToTd1(title,pubdate,long,tbody,name,href);
        var badge=".badge2";
        var input=".input2";
        search(input,tbody1,badge);
}
//公司信息
function company(){
    var title=["电力学院召开“LMS学习管理系统”培训","华东理工大学与我们签约合作","盐城市级行政执法人员在线学习考试系统开通",
    "盐城公安成功上线LMS学习管理系统","北大CIO成功签约 构建卓越学习管理平台","LMS一张张漂亮的成绩单",
        "北京燃气正式牵手LMS学习管理系统","签约新客户--西蒙电器","LMS成功签约重庆博腾制药","上海春宇上线学习管理系统",
    "上海理工大学国家级专业技术人员继续教育基地项目","喜迎珠海魅族科技项目验收上线","新疆哈密地区开通网络在线学习平台",
    "微课是个“多面怪”，您真的认识它吗？"];
    var name=["	公司重要信息","公司重要信息","公司重要信息","公司重要信息","公司重要信息","公司重要信息"
        ,"公司重要信息","公司重要信息","公司重要信息","公司重要信息","公司重要信息","公司重要信息","公司重要信息"
        ,"公司重要信息"];
    var pubdate=["2016-07-15","2016-07-15","2016-07-15","2015-09-21","2015-09-21","2015-09-21","2015-09-21",
    "2015-09-21","2015-09-21","2015-07-23","2015-07-23","2015-07-23","2015-07-23","2015-07-21"];
    var href=["informztion-zi/template.html","informztion-zi/template.html"
        ,"informztion-zi/template.html","informztion-zi/template.html","informztion-zi/template.html"
        ,"informztion-zi/template.html","informztion-zi/template.html","informztion-zi/template.html"
        ,"informztion-zi/template.html","informztion-zi/template.html","informztion-zi/template.html"
        ,"informztion-zi/template.html","informztion-zi/template.html","informztion-zi/template.html"];
    var tbody=".tbody3";
    var long=title.length;
    $('.badge3').text(long);
    insetToTd1(title,pubdate,long,tbody,name,href);
    var tbody1=".tbody3 tr";
    var badge=".badge3";
    var input=".input3";
    search(input,tbody1,badge)
}
//部门信息
function   department(){
    var title=["测试学员部门通告","5种JavaScript和CSS交互的方法","Javascript常用方法函数收集(二)",
        "12个不可不知的Sublime Text应用技巧和诀窍","用CSS制作Loading加载动画【第一期】","9 个使用前必须再三小心的 Linux 命令",
        "用CSS制作Loading加载动画【第一期】","12款最佳的Linux命令行终端工具","每周编程80+个小时怎么活？",
        "近期推出了一批 IT 技能培训课程，望你们能积极参与","CSS3实现8种Loading效果【第二波】","公司与SAP合作，为企业内部开展Sup培训，大家可踊跃报名",
        "个人常用iOS第三方库以及XCode插件介绍","完美程序员的10种品质","17个有趣实用的CSS 3悬停效果教程"];
    var name=["	部门活动通知","	部门活动通知","	部门活动通知","	部门活动通知","	部门活动通知",
        "	部门活动通知","	部门活动通知","	部门活动通知","	部门活动通知","	部门活动通知","	部门活动通知",
        "	部门活动通知","	部门活动通知","	部门活动通知","	部门活动通知","	部门活动通知","	部门活动通知",];
    var pubdate=["2016-04-25","2015-07-17","2015-07-17","2015-07-17","2015-07-17","2015-07-17"
        ,"2015-07-17","2015-07-17","2015-07-17","2015-07-17","2015-07-17","2015-07-17","2015-07-17"
        ,"2015-07-17","2015-07-17","2015-07-17","2015-07-17"];
    var href=["informztion-zi/template.html","informztion-zi/template.html","informztion-zi/template.html"
        ,"informztion-zi/template.html","informztion-zi/template.html","informztion-zi/template.html"
        ,"informztion-zi/template.html","informztion-zi/template.html","informztion-zi/template.html"
        ,"informztion-zi/template.html","informztion-zi/template.html","informztion-zi/template.html"
        ,"informztion-zi/template.html","informztion-zi/template.html","informztion-zi/template.html"];
    var tbody=".tbody4";
    var long=title.length;
    $('.badge4').text(long);
    insetToTd1(title,pubdate,long,tbody,name,href);
    var tbody1=".tbody4 tr";
    var badge=".badge4";
    var input=".input4";
    search(input,tbody1,badge)
}
//部门信息1
function   department1(){
    var title=["photoshop工具基本介绍","&lt;毛毛分享&gt;在网页中制作iOS风格放大镜"];
    var name=["部门内部通告","部门内部通告"];
    var pubdate=["2015-07-17","2015-07-17"];
    var href=["informztion-zi/template.html","informztion-zi/template.html"];
    var tbody=".tbody5";
    var long=title.length;
    $('.badge5').text(long);
    insetToTd1(title,pubdate,long,tbody,name,href);
    var tbody1=".tbody5 tr";
    var badge=".badge5";
    var input=".input5";
    search(input,tbody1,badge)
}
//搜索框
function search(input,tbody1,badge) {
    //点击按钮时实现搜索框的改变
    $(".searchBtn").click(function () {
            var txt=$(input).val();
            var rows=$(tbody1);
            var col=rows.children().children();
            if(txt==""){
                rows.show();
                $(badge).text(rows.length);
            }else{
                var j=0;
                for(var i=0;i<rows.length;i++){
                    var str1=col[i].innerHTML;
                    if(str1.search(txt)!=-1){
                        j++;
                        $(badge).text(j);
                        $(rows[i]).show();
                    }else{
                        $(rows[i]).hide();
                    }
                }
            }
        });
    /*当Input内容发生改变时实现模糊搜索功能*/
    $(input).keyup(function () {
        var txt=$(input).val();
        var rows=$(tbody1);
        var col=rows.children().children();
        if(txt==""){
            rows.show();
            $(badge).text(rows.length);
        }else{
            var j=0;
            for(var i=0;i<rows.length;i++){
                var str1=$(col[i]).text();
                 if(str1.search(txt)!=-1){
                    j++;
                    $(badge).text(j);
                    $(rows[i]).show();
                }else{
                    $(rows[i]).hide();
                     $(badge).text(j);
                 }
            }

        }
    })
    
}

