<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
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
				<table data-toggle="table">
				    <thead>
				        <tr>
				        	<th class="bs-checkbox " style="text-align: center; vertical-align: middle; width: 36px; " rowspan="2" data-field="state" tabindex="0">
				        		<div class="th-inner ">
				        			<input name="btSelectAll" type="checkbox">
				        		</div>
				        		<div class="fht-cell" style="width: 35px;"></div>
				        	</th>
				            <th>Item ID</th>
				            <th>Item Name</th>
				            <th>Item Price</th>
				        </tr>
				    </thead>
				    <tbody>
				        <tr>
				        	<td class="bs-checkbox "><input data-index="0" name="btSelectItem" type="checkbox" value="773"></td>
				            <td>1</td>
				            <td>Item 1</td>
				            <td>$1</td>
				        </tr>
				        <tr>
				        	<td class="bs-checkbox "><input data-index="0" name="btSelectItem" type="checkbox" value="773"></td>
				            <td>2</td>
				            <td>Item 2</td>
				            <td>$2</td>
				        </tr>
				    </tbody>
				</table>
				<div class="fixed-table-pagination" style="display: block;"><div class="pull-left pagination-detail"><span class="pagination-info">Showing 51 to 60 of 800 rows</span><span class="page-list"><span class="btn-group dropup"><button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="page-size">10</span> <span class="caret"></span></button><ul class="dropdown-menu" role="menu"><li class="active"><a href="javascript:void(0)">10</a></li><li><a href="javascript:void(0)">25</a></li><li><a href="javascript:void(0)">50</a></li><li><a href="javascript:void(0)">100</a></li><li><a href="javascript:void(0)">All</a></li></ul></span> rows per page</span></div><div class="pull-right pagination"><ul class="pagination"><li class="page-pre"><a href="javascript:void(0)">‹</a></li><li class="page-first"><a href="javascript:void(0)">1</a></li><li class="page-first-separator disabled"><a href="javascript:void(0)">...</a></li><li class="page-number"><a href="javascript:void(0)">5</a></li><li class="page-number active"><a href="javascript:void(0)">6</a></li><li class="page-number"><a href="javascript:void(0)">7</a></li><li class="page-last-separator disabled"><a href="javascript:void(0)">...</a></li><li class="page-last"><a href="javascript:void(0)">80</a></li><li class="page-next"><a href="javascript:void(0)">›</a></li></ul></div></div>
		</div>
		<!-- 内容主题 结束 -->
	
    

</body>

</html>