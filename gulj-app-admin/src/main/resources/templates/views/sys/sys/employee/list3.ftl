<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>员工管理</title>
	<link rel="shortcut icon" href="favicon.ico">
    <link href="/css/style.css" rel="stylesheet">
    
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/plugins/bootstrap-table/bootstrap-table.min.css">

	<script src="/js/jquery-3.1.1.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/plugins/bootstrap-table/bootstrap-table.min.js"></script>
	<script src="/plugins/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
	
	<style type="text/css">
		.page-content-search-header{padding:10px;}
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
                          <button class="btn btn-info yk_search_column_css" type="button">
                              	重置
                          </button>
                          <button class="btn btn-info yk_search_column_css" type="button" id="yk_search">
                              	搜索
                          </button>
                      </div>
                  </div>
              </div>
		
		</div>
		<!-- 内容搜索 结束 -->
	
		<!-- 内容主题 开始 -->
		<div class="bootstrap-table">
			  <div id="toolbar" class="form-inline">
	            <input id="page" class="form-control" style="width: 60px" type="number" value="1" min="1" max="3">
	            <button id="button" class="btn btn-default">selectPage</button>
	            <button id="button2" class="btn btn-default">prevPage</button>
	            <button id="button3" class="btn btn-default">nextPage</button>
       		 </div>
	        <table id="table"
	               data-toggle="table"
	               data-toolbar="#toolbar"
	               data-height="460"
	               data-url="/data/data1.json">
	            <thead>
		            <tr>
		                <th data-field="state" data-checkbox="true"></th>
		                <th data-field="id">ID</th>
		                <th data-field="name">Item Name</th>
		                <th data-field="price">Item Price</th>
		            </tr>
	            </thead>
	        </table>
		</div>
		<!-- 内容主题 结束 -->
	<script>
    var $table = $('#table'),
        $page = $('#page'),
        $button = $('#button'),
        $button2 = $('#button2'),
        $button3 = $('#button3');

    $(function () {
        $button.click(function () {
            $table.bootstrapTable('selectPage', +$page.val());
        });
        $button2.click(function () {
            $table.bootstrapTable('prevPage');
        });
        $button3.click(function () {
            $table.bootstrapTable('nextPage');
        });
    });
</script>
    

</body>

</html>