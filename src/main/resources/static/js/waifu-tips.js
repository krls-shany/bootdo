$(document).on('copy',function(){
    showMessage('你都复制了些什么呀，转载要记得加上出处哦',8000);
});
$('.waifu-tool .fa-home').click(function(){
    try{if(typeof(ajax)==="function") ajax(window.location.protocol+'//'+window.location.hostname+'/',"pagelink"); else window.location = window.location.protocol+'//'+window.location.hostname+'/';}catch(e){}
});
var model_p = 22;
//点击改变人物角色
$('.waifu-tool .fa-drivers-license-o').click(function(){
    loadlive2d('live2d','/model/model'+model_p+'.json');
    if(model_p===22){
        model_p = 33;
        showMessage('33有点累了，现在该我上场了',4000);
    }else if(model_p===33){
        model_p = 22;
        showMessage('我又回来了！',4000);
    }
    //暂时关闭该人物
    // else{
    //     model_p = 22;
    //     showMessage('伊斯特瓦尔登场',4000);
    // }
});
$('.waifu-tool .fa-comments').click(function(){
    showHitokoto();
});
var cloth_num=1;
$('.waifu-tool .fa-street-view').click(function (){
    if(model_p===22) loadlive2d('live2d','/model/model33-'+cloth_num+'.json'); else loadlive2d('live2d','/model/model22-'+cloth_num+'.json');
    // change dynamic get json function
    // if(model_p===22) loadlive2d('live2d',getJsonFile(33,cloth_num)); else loadlive2d('live2d',getJsonFile(22,cloth_num));
    // if(model_p===22) loadlive2d('live2d',getModel(22,null)); else loadlive2d('live2d',getModel(33,null));
    // if(model_p===22) loadlive2d('live2d','/model/api.php?p=33&model=rand'); else loadlive2d('live2d','/model/api.php?p=22&model=rand');
    cloth_num=(cloth_num)%15+1;
    showMessage('我的新衣服好看嘛',4000);
});
var moveStatus=true;
// 设置能否移动 -》 原功能是显示页面信息
$('.waifu-tool .fa-info-circle').click(function (){
    if(isPhone()){
        showMessage('在手机上没地方可以跑，死定了。。o(╥﹏╥)o',4000);
    }else{
        if(moveStatus)
            showMessage('我被你施了定身魔法，跑不掉了。。o(╥﹏╥)o',4000);
        else
            showMessage('定身魔法终于解除了',4000);
        moveStatus=!moveStatus;
    }
});
$('.waifu-tool .fa-camera').click(function (){
    showMessage('照好了嘛，是不是很可爱呢？',5000);
    window.Live2D.captureName = model_p+'.png';
    window.Live2D.captureFrame = true;
});
$('.waifu-tool .fa-close').click(function(){
    sessionStorage.setItem('waifu-dsiplay','none');
    showMessage('愿你有一天能与重要的人重逢',2000);
    window.setTimeout(function(){$('.waifu').hide();},1000);
});
loadlive2d('live2d','/model/model33.json');

//not use
//获取指定格式的json对象
function getJson(name,num){
    name=parseInt(name);
    num=parseInt(num);
    if(name!=22||name!=33)
        name=22;
    if(num==null||num<0||num>16)
        num=1;
    var jsonDate='{"model":"'+name+'/'+name+'.v2.moc","textures":["'+name+'/textures/texture_00.png","'+name+'/textures/texture_01/'+num+'.png","'+name+'/textures/texture_02/'+num+'.png","'+name+'/textures/texture_03/'+num+'.png"],"hit_areas_custom":{"head_x":[-0.35,0.6],"head_y":[0.19,-0.2],"body_x":[-0.3,-0.25],"body_y":[0.3,-0.9]},"layout":{"center_x":-0.05,"center_y":0.25,"height":2.7},"motions":{"idle":[{"file":"'+name+'/'+name+'.v2.idle-01.mtn","fade_in":2000,"fade_out":2000},{"file":"'+name+'/'+name+'.v2.idle-02.mtn","fade_in":2000,"fade_out":2000},{"file":"'+name+'/'+name+'.v2.idle-03.mtn","fade_in":100,"fade_out":100}],"tap_body":[{"file":"'+name+'/'+name+'.v2.touch.mtn","fade_in":150,"fade_out":100}],"thanking":[{"file":"'+name+'/'+name+'.v2.thanking.mtn","fade_in":2000,"fade_out":2000}]}}';   
    //console.log(jsonDate);     
    return JSON.parse(jsonDate);
}

//not use
function getJsonFile(name,num){
    var date=getJson(name,num);
    var fso=new ActiveXObject(Scripting.FileSystemObject);
    var f=fso.createtextfile("C:/a.json",2,true);
    f.writeLine(date);
    f.close();
    return "c:/a.json"
}


// 判断是否是手机端
function isPhone(){
    if ((navigator.userAgent.match(/(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i))) 
        return true;
    else
        return false;    
}

// 如果是手机端位置固定 
if(isPhone()){
    var box=$('.waifu')[0];
    box.style.left="73px";
    box.style.top="370px";
    moveStatus=false;
}

window.setInterval(showHitokoto,10000);

//调用接口获取名言
function showHitokoto(){
    $.get("https://hitokoto.acgget.com/hitokoto&_"+Math.random(), function(result){
        var out = result.hitokoto+"&nbsp&nbsp&nbsp&nbsp----"+result.from;
         showMessage(out, 4000);
    });
}
function getModel(name, num) {
    if (num == null || num == '') num = parseInt((Math.random()*15+1));
    if (name == null) name = '22';
    if (name != "22" && name != "33" && name != 22 && name != 33 ) name = '33';
    var result = '{"model":"'+name+'/'+name+'.v2.moc","textures":["'+name+'/textures/texture_00.png","'+name+'/textures/texture_01/'+num+'.png","'+name+'/textures/texture_02/'+num+'.png","'+name+'/textures/texture_03/'+num+'.png"],"hit_areas_custom":{"head_x":[-0.35,0.6],"head_y":[0.19,-0.2],"body_x":[-0.3,-0.25],"body_y":[0.3,-0.9]},"layout":{"center_x":-0.05,"center_y":0.25,"height":2.7},"motions":{"idle":[{"file":"'+name+'/'+name+'.v2.idle-01.mtn","fade_in":2000,"fade_out":2000},{"file":"'+name+'/'+name+'.v2.idle-02.mtn","fade_in":2000,"fade_out":2000},{"file":"'+name+'/'+name+'.v2.idle-03.mtn","fade_in":1000,"fade_out":1000}],"tap_body":[{"file":"'+name+'/'+name+'.v2.touch.mtn","fade_in":500,"fade_out":200}],"thanking":[{"file":"'+name+'/'+name+'.v2.thanking.mtn","fade_in":2000,"fade_out":2000}]}}'
    // var result = "{'model':''+name+"/"+name+'.v2.moc','textures':[''+name+'/textures/texture_00.png',''+name+'/textures/texture_01/'+num+'.png',''+name+'/textures/texture_02/'+num+'.png',''+name+'/textures/texture_03/'+num+'.png'],'hit_areas_custom':{'head_x':[-0.35,0.6],'head_y':[0.19,-0.2],'body_x':[-0.3,-0.25],'body_y':[0.3,-0.9]},'layout':{'center_x':-0.05,'center_y':0.25,'height':2.7},'motions':{'idle':[{'file':''+name+"/"+name+'.v2.idle-01.mtn','fade_in':2000,'fade_out':2000},{'file':''+name+"/"+name+'.v2.idle-02.mtn','fade_in':2000,'fade_out':2000},{'file':''+name+"/"+name+'.v2.idle-03.mtn','fade_in':1000,'fade_out':1000}],'tap_body':[{'file':''+name+"/"+name+'.v2.touch.mtn','fade_in':500,'fade_out':200}],'thanking':[{'file':''+name+"/"+name+'.v2.thanking.mtn','fade_in':2000,'fade_out':2000}]}}"
    return JSON.parse(result);
    // return result;
}

function showMessage(a,b){
    if(b==null) b = 10000;
    jQuery(".waifu-tips").hide().stop();
    jQuery(".waifu-tips").html(a);
    jQuery(".waifu-tips").fadeTo("10",1);
    jQuery(".waifu-tips").fadeOut(b);
}
(function(){
    var text;
    var SiteIndexUrl = window.location.protocol+'//'+window.location.hostname+'/';
    if(window.location.href == SiteIndexUrl){
        var now = (new Date()).getHours();
        if(now>23||now<=5){
            text = '你是夜猫子呀？这么晚还不睡觉，明天起的来嘛';
        }else if(now>5&&now<=7){
            text = '早上好！一日之计在于晨，美好的一天就要开始了';
        }else if(now>7&&now<=11){
            text = '上午好！工作顺利嘛，不要久坐，多起来走动走动哦！';
        }else if(now>11&&now<=14){
            text = '中午了，工作了一个上午，现在是午餐时间！';
        }else if(now>14&&now<=17){
            text = '午后很容易犯困呢，今天的运动目标完成了吗？';
        }else if(now>17&&now<=19){
            text = '傍晚了！窗外夕阳的景色很美丽呢，最美不过夕阳红~';
        }else if(now>19&&now<=21){
            text = '晚上好，今天过得怎么样？';
        }else if(now>21&&now<=23){
            text = '已经这么晚了呀，早点休息吧，晚安~';
        }else{
            text = '嗨~ 快来逗我玩吧！';
        }
    }else{
        if(document.referrer!==''){
            var referrer = document.createElement('a');
            referrer.href = document.referrer;
            var domain = referrer.hostname.split('.')[1];
            if(window.location.hostname==referrer.hostname){
                text = '欢迎阅读<span style="color:#0099cc;">『'+document.title.split(' - ')[0]+'』</span>';
            }else if(domain=='baidu') {
                text = 'Hello! 来自 百度搜索 的朋友<br>你是搜索 <span style="color:#0099cc;">'+referrer.search.split('&wd=')[1].split('&')[0]+'</span> 找到的我吗？';
            }else if(domain=='so') {
                text = 'Hello! 来自 360搜索 的朋友<br>你是搜索 <span style="color:#0099cc;">'+referrer.search.split('&q=')[1].split('&')[0]+'</span> 找到的我吗？';
            }else if(domain=='google') {
                text = 'Hello! 来自 谷歌搜索 的朋友<br>欢迎阅读<span style="color:#0099cc;">『'+document.title.split(' - ')[0]+'』</span>';
            }else{
                text = 'Hello! 来自 <span style="color:#0099cc;">'+referrer.hostname+'</span> 的朋友';
            }
        }else{
            text = '欢迎阅读<span style="color:#0099cc;">『'+document.title.split(' - ')[0]+'』</span>';
        }
    }
    $(".waifu").animate({top:$(window).height()-250},800);
    showMessage(text,8000);
})();
$(window).resize(function(){
    $(".waifu").css('top',window.innerHeight-250);
});
$("#live2d").mouseover(function(){
    msgs = ["你要干嘛呀？","鼠…鼠标放错地方了！","喵喵喵？","萝莉控是什么呀？","怕怕","你看到我的小熊了吗"];
    var i = Math.floor(Math.random()*msgs.length);
    showMessage(msgs[i]);
});
jQuery(document).ready(function($){
    
    $('.gotop-box').mouseover(function(){
        showMessage('要回到开始的地方么？');
    });
    $('.waifu-tool .fa-comments').mouseover(function(){
        showMessage('猜猜我要说些什么？');
    });
    $('.waifu-tool .fa-drivers-license-o').mouseover(function(){
        if(model_p===22) showMessage('要见见我的姐姐嘛'); else showMessage('什么？我的服务不好，要33回来？');
    });
    $('.waifu-tool .fa-street-view').mouseover(function(){
        showMessage('喜欢换装play吗？');
    });
    $('.waifu-tool .fa-camera').mouseover(function(){
        showMessage('你要给我拍照呀？一二三～茄子～');
    });
    $('.waifu-tool .fa-info-circle').mouseover(function(){
        showMessage('想知道更多关于我的事么？');
    });
    $('.waifu-tool .fa-close').mouseover(function(){
        showMessage('到了要说再见的时候了吗');
    });
});
jQuery(document).ready(function($){
    //执行显示名言的定时器
    window.setInterval(function(){showMessage(showHitokoto());},25000);
    var stat_click = 0;
    $("#live2d").click(function(){
        if(!ismove){
            stat_click++;
            if(stat_click>6) {
                msgs = ["你有完没完呀？","你已经摸我"+stat_click+"次了","非礼呀！救命！","OH，My ladygaga","110吗，这里有个变态一直在摸我(ó﹏ò｡)"];
                var i = Math.floor(Math.random()*msgs.length);
            }else{
                msgs = ["是…是不小心碰到了吧","我跑呀跑呀跑！~~","再摸的话我可要报警了！⌇●﹏●⌇","别摸我，有什么好摸的！","惹不起你，我还躲不起你么？","不要摸我了，我会告诉老婆来打你的！","干嘛动我呀！小心我咬你！"];
                var i = Math.floor(Math.random()*msgs.length);
            }
            s = [0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.75,-0.1,-0.2,-0.3,-0.4,-0.5,-0.6,-0.7,-0.75];
            var i1 = Math.floor(Math.random()*s.length);
            var i2 = Math.floor(Math.random()*s.length);
            if(moveStatus){  
                // $(".waifu").animate({
                // left:(document.body.offsetWidth-210)/2*(1+s[i1]),
                // top:(window.innerHeight-240)-(window.innerHeight-240)/2*(1-s[i2])
                // },
                // {
                //     duration:500,
                //     complete:showMessage(msgs[i])
                // });
            }else{
                msgs = ["坏人放开我","再摸的话我可要报警了！⌇●﹏●⌇","别摸我，有什么好摸的！","惹不起你，我也躲不了了？","不要摸我了，我会告诉shany的！","干嘛动我呀！"];
                var i = Math.floor(Math.random()*msgs.length);
                showMessage(msgs[i],4000);
            }  
        }else{
            ismove = false;
        }
    });
});
var ismove = false;
//鼠标拖拽移动人物
jQuery(document).ready(function($){
    var box=$('.waifu')[0];
    var topCount = 20;
    box.onmousedown=function(e){
        var Ox=e.offsetX;   
        var Oy=e.offsetY;
        var Ch=document.documentElement.clientHeight;
        var Cw=document.documentElement.clientWidth;
        document.onmousemove=function(e){
            var Cx=e.clientX;
            var Cy=e.clientY;
            box.style.left=Cx-Ox+"px";
            box.style.top=Cy-Oy+"px";
            if(box.offsetLeft<0){
                box.style.left=0;
            }
            else if(box.offsetLeft+box.offsetWidth>Cw){
                box.style.left=Cw-box.offsetWidth+"px";
            }
            if(box.offsetTop-topCount<0){
                box.style.top=topCount+"px";
            }
            else if(box.offsetTop+box.offsetHeight-topCount>Ch){
                box.style.top=Ch-(box.offsetHeight-topCount)+"px";
            }
            ismove = true;
        };
        document.onmouseup=function(e){
            document.onmousemove = null;
            document.onmouseup = null;
        }
    }
});