<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@include file="/WEB-INF/include/taglib.jsp" %>
<%@include file="/WEB-INF/include/public-page.jsp" %>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>新增页面</title>
</head>
<body>
	<div class="container">
		  <div class="row">
		    	<div class="col-md-12">
					<form class="form-horizontal"  id="addForm" >
						  <div class="form-group">
							    <label for="username" class="col-sm-2 control-label">账号</label>
							    <div class="col-sm-7">
							      <input type="text" class="form-control" id="username"  name="username" placeholder="账号">
							      <input type="hidden" class="form-control" id="scenicIds"  name="scenicId" placeholder="账号">
							   </div>
							   <div class="col-sm-2">
							   		<span class="nonspanxin">*</span>
							   		<span class="nonspan usernameSpan" id="usernameSpanId">请填写账号</span>
							   </div>
						  </div>
						  <div class="form-group">
							    <label for="email" class="col-sm-2 control-label">邮箱</label>
							    <div class="col-sm-7">
							      <input type="text" class="form-control" id="email" name="email" placeholder="邮箱">
							   </div>
							   <div class="col-sm-2">
							   		<span class="nonspanxin">*</span>
							   		<span class="nonspan emailSpan" id="emailNameSpanId">请填写邮箱</span>
							   </div>
						  </div>
						  <div class="form-group">
							    <label for="mobile" class="col-sm-2 control-label">手机号</label>
							    <div class="col-sm-7">
							      <input type="text" class="form-control" id="phone" name="phone" placeholder="手机号">
							   </div>
							   <div class="col-sm-2">
							   		<span class="nonspanxin">*</span>
							   		<span class="nonspan mobileSpan" id="mobile">请填写手机号</span>
							   </div>
						  </div>
					</form>
				</div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-3 col-sm-4">
		      	<button type="button" class="btn btn-info" onclick="addEmployee(this)"  id="btnSave">保存</button>
		    </div>
		    <div class="col-sm-offset-1 col-sm-4">
		      	<button type="button" class="btn btn-info " onclick="javascript:window.history.go(-1)" >返回</button>
		    </div>
		</div>
	</div>
	
	<script type="text/javascript">
		//表单提交(添加员工)
		function addEmployee(){
			//非空判断
			if(isNotEmptyEmployee()){
				//提交表单
				$.ajax({
					url:basePath+"/sys/sys/user/addEmployee",
					type:"post",
					data:$('#addForm').serialize(),
					dataType:"json",
					success:function(data){
						if(isNotEmpty(data)){
							if((data.message).indexOf("成功") != -1){
								layer.alert(data.message, {
									  skin: 'layui-layer-molv', //样式类名
									  closeBtn: 0,
									  anim: 4
									  }, function(){
										 window.location.href=basePath+"/sys/sys/employee/list";
									});
							}else{
								layer.msg(data.message,{icon: 2,time: 1000});
							}
						}
					},error:function(){
						alert("出错啦");
					}
				});
			};
		}
		//表单提交千非空验证
		function isNotEmptyEmployee(){
			var username = $("#username").val();
			var email = $("#email").val();
			var phone = $("#phone").val();
			if(isEmpty(username)){
				return false;
			}
			if(isEmpty(email)){
				return false;
			}
			if(isEmpty(phone)){
				return false;
			}
			return true;
		}
	
	</script>
	
	

</body>
</html>