function sightInit(selector,callback) {
    $(selector).combobox({
        // sight
        url: "/sight/findLikeSightName",
        // 数据id
        fieldValue: 'sightId',
        // 输入框显示
        fieldText: 'sightName',
        // 提示框显示
        fieldShowText: 'destinationName',
        // 点添加后的回调数据
        fieldDetailText: 'sightName',
        // 回调函数，返回点添加时需要的数据
        onSelected: callback
    });
}