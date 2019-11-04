$(function() {
    load();
});

function load() {
    $('#table')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: "/getPointList", // 服务器数据的加载地址
                //	showRefresh : true,
                //	showToggle : true,
                //	showColumns : true,
                iconSize: 'outline',
                //  toolbar: '#toolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                 queryParamsType : "limit", //设置为limit则会发送符合RESTFull格式的参数
                singleSelect: false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize : 10, // 如果设置了分页，每页数据条数
                pageNumber : 1, // 如果设置了分布，首页页码
                pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
                clickToSelect: true,                //是否启用点击选中行
                //search : true, // 是否显示搜索框
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams : function(params) {
                    var temp = {
                        limit : params.limit, // 每页显示数量
                        offset : params.offset, // SQL语句起始索引
                         page: (params.offset / params.limit) + 1,   //当前页码
                    };
                    return temp;

                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns: [
                    {
                        field: 'operator',
                        title: '运营商'
                    }, {
                        field: 'city',
                        title: '城市'
                    }, {
                        field: 'area',
                        title: '区域'
                    }, {
                        field: 'community',
                        title: '小区'
                    },
                    {
                        field: 'projectType',
                        title: '项目类型'
                    },
                    {
                        field: 'address',
                        title: '地址'
                    },
                    {
                        field: 'site',
                        title: '点位'
                    },
                    {
                        field: 'state',
                        title: '状态 '
                    }, {
                        field: 'deviceType',
                        title: '设备类型'
                    }, {
                        field: 'deviceId',
                        title: '设备ID'
                    }, {
                        field: 'deviceMacAddress',
                        title: 'Mac地址'
                    }, {
                        field: 'sale',
                        title: '是否销售'
                    }, {
                        field: 'is4G',
                        title: '是否4G'
                    }, {
                        field: 'installationTime',
                        title: '安装时间'
                    }, {
                        field: 'yearBuilt',
                        title: '建筑年代'
                    }, {
                        field: 'visitorsFlowrate',
                        title: '人流量'
                    }, {
                        field: 'households',
                        title: '户数'
                    }, {
                        field: 'occupancyRates',
                        title: '入住率'
                    }, {
                        field: 'CBD',
                        title: '商圈'
                    }, {
                        field: 'tabooIndustry',
                        title: '禁忌行业'
                    }, {
                        field: 'floors',
                        title: '电梯楼层'
                    },
                    {
                        field: 'ISUSING',
                        title: '操作',
                        formatter: function (value, row, index) {
                            if (value == "启用")
                                return '<span class="glyphicon glyphicon-ok label label-success" style="font-size:90%"> <button value="查看"></button></span>';
                            else
                                return '<span class="glyphicon glyphicon-remove label label-danger" style="font-size:90%"> ' +
                                    '<input type="button" class="act-but submit" style="color: #0062cc; display: inline-block" value="查看" onclick="look()"></span>';
                        }

                    },
                ]
            });
}