//default parameter

var cycleTime;          //定时器
var status              //js状态管理

/**
 * 默认执行的function
 * 加入拓展机制
 */
function init() {
    
}

function destroy() {
    cycleTime=null;
    timeListen={};
    jsonAnalysis={};
    config={};
    console.clear();
}


function timeListen(json) {
    //对传入的json判断解析为
    
    cycleTime = setInterval(()=>jsonAnalysis(json,'cycleTime',{}),1000);

}

/**
 * 根据请求解析json中的参数
 * @param {*} json  json类型的数据源
 * @param {*} info  要请求的内容
 * @param {*} data  默认的返回数据，在json中查找不到或者其他错误时返回该值
 */
function jsonAnalysis(json,info,data) {
    //当传入的json，info数据内容或格式错误时
    if(!isNull(info)||!isNull(json)||!isNull(toJson(json))){
        return data;
    }
    json=toJson(json);
    var result=eval('json.'+info);
    //如果json中包含吃数据，则返回
    if(isNull(result)){
        return result;
    }
    //默认返回data
    return data;
}

/**
 * 根据json中的配置文件，对整个系统进行修改
 * @param {*} json  json格式的配置文件
 */
function config(json) {
    
}

/**
 * 关闭程序进程和网页
 * （删除留下的痕迹等信息）
 * @param {*} params 
 */
function stop(params) {
    
}

/**
 * 判断输入数据是否为空
 * @param {*} data 
 */
function isNull(data) {
    if(data==null){
        console.log("[INFO]:isNull() data:"+data+" is null");
        return false;
    }
    if(data==""){
        console.log("[INFO]:isNull() data:"+data+" is ''");
        return false;
    }
    if(data==undefined){
        console.log("[INFO]:isNull() data:"+data+" is undefined");
        return false;
    }
    return true;
}
/**
 * 字符串转为json
 * @param {*} json 
 */
function toJson(json) {
    if(!isNull(json))
        return null;
    if (typeof json == 'string') {
        try {
            json=JSON.parse(json);
            return json;
        } catch(e) {
            console.log('[ERROR]:toJson() json:'+json+'转化异常');
        }
    }
    return json;
}


