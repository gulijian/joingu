<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>员工管理</title>
	<link rel="shortcut icon" href="favicon.ico">
   	<%@include file="/WEB-INF/include/public-page.jsp" %>
	<style type="text/css">
		.page-content-search-header{padding:10px;}
		.header-toolbar{float: left; position: absolute;  margin-left: -260px;  margin-top: 9px;}
	</style>
</head>

<body >

	<div class="container">
		<!-- 内容搜索 开始 -->
		<div class="page-content-search-header">
			 <div class="row">
                    <div class="col-xs-3">
                          <div class="input-group">
                              <input type="text" id="username" class="form-control" placeholder="昵称...">
                              <span class="input-group-btn">
                                  <button class="btn btn-info yk_search_column_css" type="button">
                                     		 昵称
                                  </button>
                              </span>
                          </div>
                      </div>
                      <div class="col-xs-3">
                          <div class="input-group">
                              <input type="text" id="phone" class="form-control" placeholder="手机号...">
                              <span class="input-group-btn">
                                  <button class="btn btn-info yk_search_column_css" type="button">
                                      	手机号
                                  </button>
                              </span>
                          </div>
                      </div>
                      <div class="col-lg-4 extra-buttons">
                          <button class="btn btn-info " type="button" id="fj_btnReset">
                              	重置
                          </button>
                          <button class="btn btn-info " type="button" id="fj_btnSearch" >
                              	搜索
                          </button>
                      </div>
                  </div>
              </div>
			 <div class="header-toolbar">
    				<button type="button" class="btn btn-primary " onclick="operate.add(this)">
    					<i class="ace-icon fa  fa-plus bigger-120"></i>新增 
    				</button>
    				<button type="button" class="btn btn-danger "  onclick="operate.delBatch(this)">
    					<i class="ace-icon fa fa-trash-o bigger-120"></i>批量删除
    				</button>
					<button type="button" class="btn btn-info ">
						<i class="ace-icon fa fa-sign-in bigger-120"></i>导出 
					</button>
			</div>
		</div>
		<!-- 内容搜索 结束 -->
	
		<!-- 内容主题 开始 -->
		<div class="bootstrap-table">
			 <table id="table"></table>
		</div>
		<!-- 内容主题 结束 -->
		
		
		<script>
			$('#table').bootstrapTable({
			    url: '/sys/sys/user/queryUserLst',
			    method: 'post',
			    contentType: "application/x-www-form-urlencoded",
			    dataType: "json",
			    //toolbar: '#toolbar',  
			    pagination: true, //分页
			    paginationLoop:true,
			    clickToSelect: true, //是否启用点击选中行
			    height: 725,  //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
	            pageNumber:1,
			    singleSelect: false,
			    showRefresh: true,     //是否显示刷新按钮
			    minimumCountColumns: 2,    //最少允许的列数
			    striped: true, //是否显示行间隔色
			    //queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
			    queryParamsType:"",//默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort  // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
			    pageSize: 14,
			    pageList:[10,14,25],
			    sidePagination: "server", //服务端请求
			    search: false, //不显示搜索框
			    cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	            showColumns: false, //不显示下拉框（选择显示的列）
	            sortable: false,   //是否启用排序
	            sortOrder: "asc", //排序方式
			    columns: [
			              { field: "state",titleTooltip: "全选/全不选",checkbox: true,align: 'center',valign: 'middle'},
			              { field: 'sid',title: 'ID'},
			              { field: 'username',title: '姓名'},
			              {	field: 'email', title: '邮箱' }, 
			              {	field: 'createTime', title: '创建时间' }, 
				   		  { title: '操作', field: 'id',align: 'center', formatter:operateFormatter } 
			             ]
				});
			
				function operateFormatter(value,row,index){
					 var e = '<a href="#" mce_href="#" onclick="operate.edit('+ row.sid + ',this)">编辑</a> ';  
	                 var d = '<a href="#" mce_href="#" onclick="operate.del('+ row.sid +',this)">删除</a> ';  
	                 return e+d;  
				}
				
				
				//搜索
				$("#fj_btnSearch").click(function(){
					 var params = $('#table').bootstrapTable('getOptions');  
				        params.queryParams = function(params) {  
				            //定义参数  
				           /*  var search = {};  
				          	search.username="1213";
				          	search.phone="15295059075" */
				            //参数转为json字符串，并赋给search变量 ,JSON.stringify <ie7不支持，有第三方解决插件  
				            params.username = $("#username").val().trim();
				            params.phone = $("#phone").val().trim();;
				            return params;  
				        }  
				        $('#table').bootstrapTable('refresh', params)  
				});
				
				//重置
				$("#fj_btnReset").click(function(){
					$("#username").val("");
					$("#phone").val("");
				});
		</script>
		
		<!-- CRUD -->
		<script type="text/javascript">
			var operate = {
					add:function(){
						$.post(basePath+"/sys/sys/user/toAddPage",null,
								 function(){
							 			window.location.href=basePath+"/sys/sys/user/toAddPage";
							 	}
						);
					},
					edit:function(id){
						$.post(basePath+"/sys/sys/user/toEditPage",null,
								 function(){
							 			window.location.href=basePath+"/sys/sys/user/toEditPage?sid="+id+"";
							 	}
						);
					},
					del:function(id,obj){
						 delIndex = layer.open({
								title:'温馨提醒',
							    content: '你确认删除吗？',
							    btn: ['确认', '取消'],
							    offset: '280px',
							    shadeClose: false,
							    yes: function(){
							    	delsend(id,obj);
							    }, end : function(){
							    	//去除行样式
							    	$(obj).parent().parent().removeClass("selected"); 
							    	//去除checkbox选中样式
							    	$(obj).parent().parent().find("input[type='checkbox']").prop("checked",false);
							    }
						});
					},
					 delBatch:function(){//批量删除
						 	//获取选中的数据组
			                var array = $("table input[type=checkbox]:checked").map(function () {
			                    return { "cell3": $.trim($(this).closest("tr").find("td:eq(1)").text()), "cell2": $.trim($(this).closest("tr").find("td:eq(2)").text()) };
			                }).get();
			 
			                var id_array  = [];
			                $.each(array, function (i, d) {
			                   // alert(d.cell3 + "|" + d.cell2);
			                    id_array.push(d.cell3);
			                })
							var idstr=id_array.join(',');//将数组元素连接起来以构建一个字符串  
							if(isNotEmpty(idstr)){
								 delBatchIndex = layer.open({
										title:'温馨提醒',
									    content: '你确认删除吗？',
									    btn: ['确认', '取消'],
									    offset: '280px',
									    shadeClose: false,
									    yes: function(){
									    	delBatchSend(idstr);
									    }, end : function(){
									    	//去除选中行样式
									    	$("input[type=checkbox]:checked").parent().parent().removeClass("selected"); 
									    	//去除checkbox选中样式
									    	$("input[type='checkbox']:checked").prop("checked",false);
									    }
								 });
							}else{
								layer.msg('请至少选择一条记录',{icon: 6, time: 1000, offset: '380px',skin: 'demo-class' }); 
							}
					 },
					 exportData:function(){//导出
						 
						 
					 }
			}
		
			//删除
			function delsend(id,obj){
				$(obj).removeClass("active");
				$.ajax({
					url:basePath+"/sys/sys/user/delEmployee",
					type:"post",
					data:{id:id},
					success:function(data){
						if(isNotEmpty(data)){
							layer.msg(data.message,{icon: 1,time: 1300});
							//window.location.href=basePath+"/sys/sys/employee/list";
							 $('#table').bootstrapTable('refresh', {
								    query: {pageSize: $('#table').bootstrapTable('getOptions').pageSize}
							 });
						}
					},error:function(){
						layer.msg("出错啦！",{icon: 2,time: 2000});
					}
				});
			}
		
			//批量删除
			function delBatchSend(idstr){
				
				alert("============"+idstr);
			}
		</script>
</body>

</html>