function destinationInit(selector, callback) {
    $(selector).data("onSelected", callback);
    $(selector).combobox({
        // destination
        url: "/destination/findLikeDestinationName",
        // 数据id
        fieldValue: 'destinationId',
        // 输入框显示
        fieldText: 'destinationName',
        // 提示框显示
        fieldShowText: 'fatherDestinationName',
        // 点添加后的数据
        fieldDetailText: 'detail',
        // 回调函数
        onSelected: function (detail) {
            detail = $.parseJSON(detail);
            SetDestinationValue(selector, detail, true);
        }
    });
}

//控件赋值 detail 为JSON
//isCallBack  是否执行事件回调， 不对外公开
function SetDestinationValue(selector, detail, isCallBack) {
    var id = detail ? detail.destinationId : "";
    var name = detail ? detail.destinationName : "";
    $(selector).data("detail", detail);
    $(selector).find("input").attr("valueField", id).attr("textField", name).val(name);
    if (isCallBack === true) {
        var onSelected = $(selector).data("onSelected");
        if (onSelected && onSelected.call) {
            onSelected.call($(selector), detail);
        }
    }
}

//获取选择目的地的值，JSON
function getDestinationValue(selector) {
    return $(selector).data("detail");
}