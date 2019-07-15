layui.use('table', function () {
    var table = layui.table;
    table.render({
        elem: '#test',
        url: '/goods/goods',
        cellMinWidth: 100,
        cols: [
            [
                {
                    field: 'id',
                    align: 'center',
                    title: '编号',
                    sort: true,
                }
                , {
                field: 'goodsName',
                align: 'center',
                title: '商品名字',
            }
                , {
                field: 'picture',
                align: 'center',
                title: '图片'
            }
                , {
                field: 'mainName',
                align: 'center',
                title: '主分类'
            }
                , {
                field: 'childName',
                align: 'center',
                title: '子分类'
            }
                , {
                field: 'price',
                align: 'center',
                title: '价格'
            }
                , {
                field: 'count',
                align: 'center',
                title: '库存'
            }
                , {
                field: 'freight',
                align: 'center',
                title: '运费'
            }
                , {
                field: 'describe',
                align: 'center',
                title: '描述'
            }
                , {
                field: 'right',
                align: 'center',
                toolbar: '#barDemo',
                title: '操作'
            }
            ]
        ],
        id: 'testReload'
        , page: true,
    });
    //监听工具条
    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'detail') {
            layer.msg('ID：' + data.id + ' 的查看操作');
        } else if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                var url = '/function/function?id=' + data.id;
                var dataType = "json";
                $.ajax({
                    type: "DELETE",
                    url: url,
                    dataType: "json",
                    success: function (dataJson) {
                        layer.close(index);
                        layer.alert(dataJson.msg)
                        reloadTable()
                    },
                    error: function (dataJson) {
                        layer.close(index);
                        layer.alert("您无此权限")
                    }
                });
            });
        } else if (obj.event === 'edit') {
            var url = '';
            if (data.parent == 'true') {
                url = '/function/toupdateparentfunction?id=' + data.id;
            } else {
                url = '/function/toupdatefunction?id=' + data.id;
            }

            layer.open({
                type: 2,
                title: '修改页面',
                shadeClose: true,
                shade: false,
                maxmin: true, //开启最大化最小化按钮
                area: ['800px', '700px'],
                content: url,
                end: function () {
                    var demoReload = $('#demoReload');
                    table.reload('testReload', {
                        page: {
                            curr: 1
                        },
                        where: {
                            search: demoReload.val()
                        }
                    });
                }
            });
        }
    });

    reloadTable = function () {
        var demoReload = $('#demoReload');
        //执行重载
        table.reload('testReload', {
            page: {
                curr: 1
            },
            where: {
                search: demoReload.val()
            }
        });
    }

    var $ = layui.$,
        active = {
            reload: function () {
                var demoReload = $('#demoReload');
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1
                    },
                    where: {
                        search: demoReload.val()
                    }
                });
            }
        };

    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});