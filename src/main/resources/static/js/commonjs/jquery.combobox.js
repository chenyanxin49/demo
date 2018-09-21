(function ($) {
    //自定义jquery控件， 下拉菜单
    $.fn.combobox = function (options) {
        var defaults = {
            //显示的最大长度
            maxLength: 30,
            //是否必须选择
            mustSelect: true,
            //是不按照下拉框显示
            isshowdropbutton: false,
            //当没有对应项时，是否自动清除文本框的值
            isClearInput: true,
            //数据id
            fieldValue: 'id',
            //数据text
            fieldText: 'text',
            //数据showtext显示值
            fieldShowText: 'showtext',
            //数据detailtext数据详细信息
            fieldDetailText: 'detailtext',
            //数据源
            dataSource: null,
            //数据源
            url: null,
            //扩展数据源Ajax参数，默认参数为：filter、maxLength
            urlParams: {},
            //选中事件，带入参数：detailtext
            onSelected: function (detailtext) {

            }
        };

        options = $.extend(defaults, options);
        var keys = { up: 38, down: 40, enter: 13, tab: 9, esc: 27 };
        function keydown(e, optionsContainer, defaultText) {
            switch (e.keyCode) {
                case keys.esc:
                    e.preventDefault();
                    break;
                case keys.enter:
                    choose.call(this, optionsContainer, defaultText);
                    e.preventDefault();
                    break;
                case keys.tab:
                    choose.call(this, optionsContainer, defaultText);
                    break;
                case keys.up:
                    up.call(this, optionsContainer);
                    break;
                case keys.down:
                    down.call(this, optionsContainer);
                    break;
            }
        }

        function choose(optionsContainer, defaultText) {
            var combobox = this;
            var selected = optionsContainer.children("li.selected");
            if (selected.length > 0) {
                combobox.val(selected.attr("gettext"));
                combobox.attr("valueField", selected.attr("id")).attr("textField", selected.attr("gettext"));
                options.onSelected(unescape(selected.attr("getdetail")));
            }
            if (!combobox.val()) combobox.val(defaultText);
            optionsContainer.hide().children().remove();
        }

        function up(optionsContainer) {
            if (!optionsContainer.is(":visible")) return;
            var list = optionsContainer.children('li');
            var index = list.index($(".selected"));
            if (index > 0) {
                list.filter(".selected").prev().addClass("selected").siblings().removeClass("selected");
            }
        }

        function down(optionsContainer) {
            if (!optionsContainer.is(":visible")) return;
            var list = optionsContainer.children('li');
            var index = list.index($(".selected"));
            if (index < list.size() - 1) {
                list.filter(".selected").next().addClass("selected").siblings().removeClass("selected");
            }
        }

        function showOptions(optionsContainer) {
            var combobox = this;
            var filter = $.trim(this.val()).toLowerCase();
            if (!filter) {
                optionsContainer.hide().children().remove();
                return;
            }
            var dataSource = options.dataSource;
            var html = '';
            if (!dataSource && options.url) {
                var defaultParams = { filter: filter, maxLength: options.maxLength };
                var urlParams = options.urlParams;
                var dataParams = $.extend(defaultParams, urlParams);
                $.rtAjax({
                    url: options.url,
                    async: false,
                    cache: false,
                    type: 'post',
                    dataType: 'json',
                    data: dataParams,
                    success: function (result) {
                        dataSource = result;
                    }
                });
                for (var k = 0; k < dataSource.length; k++) {
                    var v = dataSource[k][options.fieldText]; //text
                    var vShowText = dataSource[k][options.fieldShowText]; //fieldShowText
                    var vid = dataSource[k][options.fieldValue]; //value
                    var vDetailText = escape(dataSource[k][options.fieldDetailText]); //fieldDetailText
                    html += '<li style="height:auto" id="' + vid + '" gettext="' + v + '" getdetail=' + vDetailText + '>' + vShowText + '</li>';
                }
            } else {
                var ulLength = 0;
                for (var k = 0; k < dataSource.length; k++) {
                    var v = dataSource[k][options.fieldText]; //text
                    var vShowText = dataSource[k][options.fieldShowText] || v; //fieldShowText
                    var vid = dataSource[k][options.fieldValue]; //value
                    var vDetailText = escape(dataSource[k][options.fieldDetailText]); //fieldDetailText

                    var inputStr = vShowText.toLowerCase().indexOf(filter);
                    if ((!filter) || (filter && inputStr >= 0)) {
                        html += '<li style="height:auto" id="' + vid + '" gettext="' + v + '" getdetail=' + vDetailText + '>' + vShowText + '</li>';
                        if (++ulLength >= options.maxLength) {
                            break;
                        }
                    }
                }
            }
            html = html === '' ? '<span style="text-align:center;display:block;">--未能搜索到数据--<span>' : html;
            var loc = { left: combobox.offset().left - 1, top: combobox.offset().top + combobox.height() + 3, width: combobox.width() + combobox.next().width() + 5 }
            optionsContainer.html(html).css(loc);
            optionsContainer.children('li').eq(0).addClass('selected');

            //mouse hover to change the highlight option, clicking to select it
            optionsContainer.children('li').hover(function () {
                $(this).addClass('selected').siblings().removeClass("selected");
            }).click(function () {
                choose.call(combobox, optionsContainer);
            });

            if (optionsContainer.children().length === 0 || !filter) {
                optionsContainer.hide().children().remove();
            } else {
                optionsContainer.show();
            }
        }

        var hideTimer;

        return this.each(function (index, dom) {
            var combobox = $(dom);
            var optionsContainer;
            //记录combobox的一些信息，重复初始化combobox控件时使用，便于移除事件
            var comboboxData = combobox.data("comboboxData");
            var defaultText = combobox.val();
            if (!comboboxData) {
                if (options.isshowdropbutton) {
                    combobox.wrap('<div class="diapol_comboboxselect"  />');
                    var btn = $('<input type="button" class="button" />').insertAfter(combobox).css({ height: combobox.height() + 3, "background-image": 'url(/combobox/dropdown.gif)' });
                    combobox.width(combobox.width() - btn.width());
                }
                optionsContainer = $('<ul class="diapol_comboboxDropdown" style="position:absolute;display:none;z-index:100000000000" />').appendTo($('body'));
                if ($.fn.bgiframe) optionsContainer.bgiframe();
                comboboxData = { container: optionsContainer };
                combobox.attr('autocomplete', 'off');
            } else {
                optionsContainer = comboboxData["container"];
            }

            if (comboboxData["keydown"]) combobox.unbind("keydown", comboboxData["keydown"]);
            if (comboboxData["keyup"]) combobox.unbind("keyup", comboboxData["keyup"]);
            if (comboboxData["blur"]) combobox.unbind("blur", comboboxData["blur"]);

            combobox.keydown(comboboxData["keydown"] = function (e) {
                keydown.call(combobox, e, optionsContainer, defaultText);
            }).keyup(comboboxData["keyup"] = function (e) {
                for (key in keys) {
                    if (e.keyCode === keys[key]) return;
                }
                //使用定时器拦截短时间多余的事件
                if (hideTimer) {
                    hideTimer = clearTimeout(hideTimer);
                }
                hideTimer = setTimeout(function () {
                    showOptions.call(combobox, optionsContainer, defaultText);
                    hideTimer = 0;
                }, 100);
            }).blur(comboboxData["blur"] = function () {
                setTimeout(function () {
                    if (options.isClearInput && combobox.attr("textField") !== combobox.val()) {
                        combobox.val(combobox.attr("textField"));
                    }
                    optionsContainer.hide().children().remove();
                }, 300);
            });

            combobox.data("comboboxData", comboboxData);
        });
    }
})
(jQuery);