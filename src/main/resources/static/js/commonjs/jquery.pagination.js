/*
* 分页导航条
* pageNumber 页码，当前页
* pageSize   每页数据条数
* totalCount      数据总条数
*/

(function ($) {
    var pagination = function (that, initPara) {
        this.ele = that;
        this.defaults = {
            pageNumber: 1, // 当前页
            totalCount: 10,  // 总数据量，
            pageSize: 10, // 每页数据条数
            isShow: !0, // 是否显示导航条
            count: 10, // 每页条数
            homePageText: "首页",
            endPageText: "末页",
            prevPageText: "上一页",
            nextPageText: "下一页",
            callback: function () { // 回调函数
            }
        };
        this.opts = $.extend({}, this.defaults, initPara);
        this.current = this.opts.pageNumber;
        this.totalPage = Math.ceil(this.opts.totalCount / this.opts.pageSize);
        this.init()
    };
    pagination.prototype = {
        init: function () {
            this.isRender = !0;
            this.render();
            this.eventBind()
        },
        render: function () {
            var opts = this.opts,
                cur = this.current,
                totPage = this.totalPage,
                pageText = this.getPagesTpl();
            this.pageBox = '<div class="bottombtnbox cl"><div class="page_left">当前记录：<span class="marright10">' +
                (opts.totalCount === 0 ? 0 : ((cur * 10 - 9) + '-' + (cur * 10 > opts.totalCount ? opts.totalCount : cur * 10)))
                + '  &nbsp;</span>记录总数：<span>' + opts.totalCount + '</span></div><div class="page">';
            this.homePage = '<a href="javascript:void(0);" class="ui-pagination-page-item" data-current="1">'
                + opts.homePageText + "</a>";
            this.prevPage = '<a href="javascript:void(0);" class="ui-pagination-page-item" data-current="'
                + (cur - 1) + '">' + opts.prevPageText + "</a>";
            this.nextPage = '<a href="javascript:void(0);" class="ui-pagination-page-item" data-current="'
                + (cur + 1) + '">' + opts.nextPageText + "</a>";
            this.endPage = '<a href="javascript:void(0);" class="ui-pagination-page-item" data-current="' + totPage + '">'
                + opts.endPageText + "</a>";
            this.checkPage();
            this.isRender && this.ele.html(this.pageBox + this.homePage + this.prevPage + pageText + this.nextPage + this.endPage + "</div></div>")
        },
        checkPage: function () {
            var opts = this.opts,
                totPage = this.totalPage,
                cur = this.current;
            opts.isShow || (this.homePage = this.endPage = "");
            1 === cur && (this.homePage = this.prevPage = "");
            cur === totPage && (this.endPage = this.nextPage = "");
            1 === totPage && (this.homePage = this.prevPage = this.endPage = this.nextPage = "");
            totPage <= 1 && (this.endPage = this.nextPage = "");
            // totPage <= 1 && (this.isRender = !1);
        },
        getPagesTpl: function () {
            var opts = this.opts,
                totPage = this.totalPage,
                cur = this.current,
                pageText = "",
                count = opts.count;
            if (totPage <= count)
                for (g = 1; g <= totPage; g++)
                    pageText += g === cur ? '<a href="javascript:void(0);" class="ui-pagination-page-item pageon" data-current="'
                        + g + '">' + g + "</a>" : '<a href="javascript:void(0);" class="ui-pagination-page-item" data-current="'
                        + g + '">' + g + "</a>";
            else {
                var s = count / 2;
                var r = Math.floor(s);
                if (cur <= s) {
                    for (g = 1; g <= count; g++)
                        pageText += g === cur ? '<a href="javascript:void(0);" class="ui-pagination-page-item pageon" data-current="'
                            + g + '">' + g + "</a>" : '<a href="javascript:void(0);" class="ui-pagination-page-item" data-current="'
                            + g + '">' + g + "</a>";
                    cur + r < totPage && (pageText += '<a href="javascript:void(0);" class="ui-pagination-page-item" data-current="'
                        + totPage + '">...' + totPage + "</a>");
                }
                else {
                    var c = cur + r,
                        h = cur - r,
                        o = count % 2 === 0;
                    h > 1 && (pageText += '<a href="javascript:void(0);" class="ui-pagination-page-item" data-current="1">1...</a>');
                    c > totPage && (o ? (h -= c - totPage - 1, c = totPage + 1) : (h -= c - totPage, c = totPage)), o || c++;
                    for (var g = h; g < c; g++)
                        pageText += g === cur ? '<a href="javascript:void(0);" class="ui-pagination-page-item pageon" data-current="'
                            + g + '">' + g + "</a>" : '<a href="javascript:void(0);" class="ui-pagination-page-item" data-current="'
                            + g + '">' + g + "</a>";
                    !(c > totPage) && (pageText += '<a href="javascript:void(0);" class="ui-pagination-page-item" data-current="'
                        + totPage + '">...' + totPage + "</a>");
                }
            }
            return pageText;
        },
        eventBind: function () {
            var a = this,
                call = this.opts.callback;
            this.ele.find(".ui-pagination-page-item").click(function () {
                var cur = $(this).data("current");
                a.current !== cur && (a.current = cur, a.render(),
                call && "function" === typeof call && call(cur))
            });
        }
    };

    // 更多自定义参数使用这个方法，传入一个对象
    $.fn.pagination = function (initPara) {
        return new pagination(this, initPara);
    }
    // requestData（） 只需要一个页码参数
    $.fn.initPage = function (pageNumber, total, requestData) {
        new pagination(this, {
            pageNumber: pageNumber,
            totalCount: total,
            callback: function (current) {
                if (requestData && requestData.call) {
                    requestData.call(window, current);
                }
            }
        });
    }
})(jQuery);