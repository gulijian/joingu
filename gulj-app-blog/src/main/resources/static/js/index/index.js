//以下将以jquery.ajax为例，演示一个异步分页
// function demo(curr){
//     $.ajax({
//         url:"article/listPage",
//         type:"post",
//         contentType: "application/x-www-form-urlencoded; charset=utf-8",
//         data:{pageNumber: curr || 1},//向服务端传的参数，此处只是演示
//         success:function (res) {
//             console.log(res);
//             console.log( res.totalPage)
//             //显示分页
//             laypage({
//                 cont: 'join_gu_propagation', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
//                 pages: 10, //通过后台拿到的总页数
//                 skin: '#AF0000',
//                 curr: curr || 1, //当前页
//                 jump: function(obj, first){ //触发分页后的回调
//                     if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
//                         console.log("2333333333")
//                         demo(obj.curr);
//                     }
//                 }
//             });
//         }
//     });
// };
// //运行
// demo();

function demo1() {
    var pages = $("#totalPage").val();
    console.log(pages);
    if (pages == undefined){
        pages = 1
    }
    laypage({
        cont: 'join_gu_propagation',
        pages: pages, //可以叫服务端把总页数放在某一个隐藏域，再获取。假设我们获取到的是18
        curr: function(){ //通过url获取当前页，也可以同上（pages）方式获取
            var page = location.search.match(/page=(\d+)/);
            return page ? page[1] : 1;
        }(),
        jump: function(e, first){ //触发分页后的回调
            if(!first){ //一定要加此判断，否则初始时会无限刷新
                location.href = '?page='+e.curr;
            }
        }
    });
}
demo1();