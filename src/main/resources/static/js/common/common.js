var webApiUrl = "http://localhost:8080";

//判断当前设备
var browser = {
    versions: function () {
        var u = navigator.userAgent, app = navigator.appVersion;
        return {
            trident: u.indexOf('Trident') > -1, //IE内核
            isOpera: u.indexOf("Opera") > -1,
            isIEbrowser: u.indexOf("compatible") > -1 && u.indexOf("MSIE") > -1 && !(u.indexOf("Opera") > -1),//判断是否IE<11浏览器
            isEdge: u.indexOf("Edge") > -1,
            presto: u.indexOf('Presto') > -1, //opera内核
            webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
            gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1,//火狐内核
            mobile: !!u.match(/AppleWebKit.*Mobile.*/), //是否为移动终端
            ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
            android: u.indexOf('Android') > -1 || u.indexOf('Adr') > -1, //android终端
            iPhone: u.indexOf('iPhone') > -1, //是否为iPhone或者QQHD浏览器
            iPad: u.indexOf('iPad') > -1, //是否iPad
            webApp: u.indexOf('Safari') == -1, //是否web应该程序，没有头部与底部
            weixin: u.indexOf('MicroMessenger') > -1, //是否微信 （2015-01-22新增）
            qq: u.match(/\sQQ/i) == " qq" //是否QQ
        };
    }(),
    language: (navigator.browserLanguage || navigator.language).toLowerCase()
}

jQuery.extend({
    /** * @see 将json字符串转换为对象 * @param json字符串 * @return 返回object,array,string等对象 */
    evalJSON: function (strJson) {
        return eval("(" + strJson + ")");
    }
});
/*** 将javascript数据类型转换为json字符串的方法。** @public* @param  {object}
 需转换为json字符串的对象, 一般为Json 【支持object,array,string,function,number,boolean,regexp *】*
 @return 返回json字符串**/
jQuery.extend({
    toJSONString: function (object) {
        var type = typeof object;
        if ('object' == type && object != null) {
            if (jQuery.isArray(object)) type = 'array';
            else if (RegExp == object.constructor) type = 'regexp';
            else type = 'object';
        }
        switch (type) {
            case 'undefined':
            case 'unknown':
                return;
                break;
            case 'function':
            case 'boolean':
            case 'regexp':
                return object.toString();
                break;
            case 'number':
                return isFinite(object) ? object.toString() : 'null';
                break;
            case 'string':
                return '"' + object.replace(/(\\|\")/g, "\\$1").replace(/\n|\r|\t/g, function () {
                    var a = arguments[0];
                    return (a == '\n') ? '\\n' : (a == '\r') ? '\\r' : (a == '\t') ? '\\t' : ""
                }) + '"';
                break;
            case 'object':
                if (object === null) return 'null';
                var results = [];
                for (var property in object) {
                    var value = jQuery.toJSONString(object[property]);
                    if (value !== undefined) results.push(jQuery.toJSONString(property) + ':' + value);
                }
                return '{' + results.join(',') + '}';
                break;
            case 'array':
                var results = [];
                for (var i = 0; i < object.length; i++) {
                    var value = jQuery.toJSONString(object[i]);
                    if (value !== undefined) results.push(value);
                }
                return '[' + results.join(',') + ']';
                break;
        }
    }
});

//format  字符串格式化插件
$.format = function (source, params) {
    if (arguments.length == 1)
        return function () {
            var args = $.makeArray(arguments);
            args.unshift(source);
            return $.format.apply(this, args);
        };
    if (arguments.length > 2 && params.constructor != Array) {
        params = $.makeArray(arguments).slice(1);
    }
    if (params.constructor != Array) {
        params = [params];
    }
    $.each(params, function (i, n) {
        source = source.replace(new RegExp("\\{" + i + "\\}", "g"), n);
    });
    return source;
};

// 重写toFixed方法
Number.prototype.toFixed = function (len) {
    var isLess0 = false;
    if (this < 0) {
        isLess0 = true;
    }
    // 多加一位小数（jsbug 79585.95+0.01=79585.95999999999）
    var strNumber = this == 0 ? "0" : (Math.abs(this) + (1 / Math.pow(10, len + 3))).toString();
    var newNumber = "";
    var i = 0;
    if (strNumber.indexOf(".") === -1) { // 原数值不包含小数点
        newNumber = strNumber;
        if (len > 0) {
            newNumber += ".";
            for (i = 0; i < len; i++) {
                newNumber += "0";
            }
        }
    } else {
        var strNumber2 = strNumber.substr(strNumber.indexOf(".") + 1);
        if (strNumber2.length === len) { // 原数值小数位数与结果相同
            return strNumber;
        }
        if (strNumber2.length > len) { // 原数值小数位数大于结果
            var endIndex = 0;
            var lastNumber = strNumber2.substr(len, 1);
            if (lastNumber > 4) { // 保留的小数点后一位大于4（进1）;
                var addNumber1 = 1 / Math.pow(10, len);
                var tempNumber = (parseFloat(strNumber) + addNumber1).toString();
                endIndex = tempNumber.indexOf(".") !== -1 ? (tempNumber.indexOf(".") + (len === 0 ? 0 : 1)) : tempNumber.length;
                newNumber = tempNumber.substr(0, endIndex + len);
            } else {
                endIndex = strNumber.indexOf(".") !== -1 ? (strNumber.indexOf(".") + (len === 0 ? 0 : 1)) : strNumber.length;
                newNumber = strNumber.substr(0, endIndex + len);
            }
        } else {// 原数值小数位数大于结果，补0
            newNumber = strNumber;
            for (i = 0; i < len - strNumber2.length; i++) {
                newNumber += "0";
            }
        }
    }
    return (isLess0 ? "-" : "") + newNumber;
}


//页签切换
function changeTabs(bindElementName,curClassName,ShowElementNames){
    $(bindElementName).on('click',function(){
        var index=$(this).index();
        $(this).addClass(curClassName).siblings().removeClass(curClassName);
        $(ShowElementNames).eq(index).show().siblings().hide();
    })
}


//////////////////////////////////////////////////////字符串判断//////////////////////////////////////////////////

//判断字符串是否为空
function isBlank(input) {
    return input == null || /^\s*$/.test(input);
}

//判断字符串是否是Int型
function isInt(input) {
    var partten = /(^[1-9][0-9]*$)|(^[0-9]$)/;
    return partten.test(input);
}

//判断字符串是否是浮点类型
function isFloat(input) {
    var partten = /(^[1-9][0-9]*[\.]{0,1}[0-9]*[0-9]$)|(^[0].[0-9]*[0-9]$)|(^[0-9]$)/;
    return partten.test(input);
}

//判断字符串是否是Email
function isEmail(input) {
    var partten = "^(([0-9a-zA-Z]+)|([0-9a-zA-Z]+[_.0-9a-zA-Z-]*))@([a-zA-Z0-9-]+[.])+([a-zA-Z]{2}|net|com|gov|mil|org|edu|int|name|asia)$";
    var re = new RegExp(partten);
    if (input.search(re) == -1) {
        return false;
    }
    else {
        return true;
    }
}

//判断字符串是否是日期
function isDate(input) {
    return (!isNaN(new Date(input).getYear()));
}

//把String类型转换成Float  并保留n位小数
function setStrToFixed(strValue, n) {
    if ((strValue && (parseFloat(strValue) || parseFloat(strValue) === 0)) || strValue == "0") {
        var StrToFixed = (parseFloat(strValue)).toFixed(n);
        return StrToFixed;
    } else {
        return "";
    }
}

//判断字符串是否是身份证号码
function isIdentityNo(str) {
    var partten = /^(\d{15}|\d{17}[0-9X]{1})$/i;
    var birthStr = "";
    if (partten.test(str)) {
        if (str.length == 18) birthStr = str.substring(6, 10) + "-" + str.substring(10, 12) + "-" + str.substring(12, 14);
        else birthStr = "19" + str.substring(6, 8) + "-" + str.substring(8, 10) + "-" + str.substring(10, 12);
        if (!isDate(birthStr)) return false;
        else return true;
    } else return false;
}

//判断字符串是否是手机号
function isMobile(input) {
    var pattern = /1[3|4|5|6|7|8]\d{9}/;
    return pattern.test(input);
}

//获取当前参数
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURIComponent(r[2]);
    return null;
}

//guid
var guidList = [];

function newGuid() {
    if (guidList.length == 0) {
        $.rtAjax({
            async: false,
            type: "post",
            cache: false,
            url: "/common/getGuidList",
            dataType: "json",
            success: function (result) {
                if (!$.isEmptyObject(result)) {
                    guidList = result;
                }
            }
        });
    }
    var guidArr = guidList.splice(0, 1);
    return guidArr[0];
}

//自定义Ajax
$.rtAjax = function (options) {
    var defaults = {
        async: true,
        cache: false,
        dataType: "text",
        type: "post",
        data: {
            loginMode:"Front"
        },
        beforeSend: null,
        success: null,
        failure:null,
        showMask: false,
        error: null,
        complete: null,
        processData: true,
        contentType: "application/x-www-form-urlencoded"
    }

    options.data = $.extend(defaults.data, options.data);
    options = $.extend(defaults, options);

    $.ajax({
        url: webApiUrl + options.url,
        async: options.async,
        cache: options.cache,
        dataType: "json",
        processData: options.processData,
        contentType: options.contentType,
        xhrFields: {
            withCredentials: true
        },
        type: options.type,
        data: options.data,
        success: function (result) {
            //验证
            if (!$.isEmptyObject(result)) {
                if (result.code == 0) {
                    var realData;
                    if (options.dataType.toLowerCase() == "json") {
                        realData = result.data;
                    } else {
                        realData = $.toJSONString(result.data);
                    }
                    if (options.success && options.success.call) {
                        options.success.call(this, realData);
                    }
                }
                else if (result.code === -3) {
                    //会话超时，跳转到登录页
                    parent.parent.parent.parent.parent.location.href="/login.html";
                }else {
                    if (options.failure && options.failure.call) {
                        options.failure.call(this, result);
                    }else{
                        if(window.showAlert){
                            showAlert(result.msg);
                        }
                        else{
                            alert(result.msg);
                        }
                    }
                    console.log($.format("ajax[{2}]异常:code:{0},msg:{1}", result.code, result.msg, webApiUrl + options.url));
                }
            }

        },
        error: function (result) {
            //验证

            if (options.error && options.error.call) {
                options.error.call(this, result);
            }
        },
        complete: function (result) {
            //验证

            if (options.complete && options.complete.call) {
                options.complete.call(this, result);
            }
        },
        beforeSend: function () {
            if (options.beforeSend && options.beforeSend.call) {
                options.beforeSend.call(this);
            }
        }
    });
}

//格式化金额
function formatPrice(price) {
    if (isNaN(price)) return NaN;
    return parseFloat(price).toFixed(2).toString();
}

/**
 * 获取文件路径
 */
function getImgSrc(ossFilePath) {
    return webApiUrl + "/file?loginMode=Front&objectName=" + encodeURIComponent(ossFilePath);
}

//获取当前滚动条高度
function getWinScrollTop(){
    var scrollTop=0;
    if(document.documentElement&&document.documentElement.scrollTop){
        scrollTop=document.documentElement.scrollTop;
    }else if(document.body){
        scrollTop=document.body.scrollTop;
    }
    return scrollTop;
}

//元素在页面滚动时固定到某个点
function fixedElement(element,className,parentClass){
    var offsetHeight=$(element).offset().top;
    $(window).scroll(function(){
        var winScrollHieght=getWinScrollTop();
        if(winScrollHieght>offsetHeight){
            $(element).addClass(className);
        }else{
            $(element).removeClass(className);
        }
        if(parentClass){
            var parentHeight=$(parentClass).offset().top+$(parentClass).height()-300;
            if(winScrollHieght>=parentHeight){
                $(element).removeClass(className);
            }
        }
    })
}

//页面滚动时导航定位
function fixedNav(nav,contentClass,activeClass,num){

    $(window).on('scroll',function(){
        var len=$(nav).length-1;
        var winScrollTop=getWinScrollTop();
        for(;len>-1;len--){
            var contentItem=$(contentClass).eq(len);
            if(winScrollTop>=$(contentItem).offset().top-num){
                $(nav).removeClass(activeClass).eq(len).addClass(activeClass);
                break;
            }
        }
    })

    $(nav).on('click',function(e){
        e.preventDefault();
        $('html, body').animate({
            'scrollTop': $($(this).attr('href')).offset().top-num+5
        }, 400);
    })
}
