<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>菲剑后台管理系统- 登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/login.css" rel="stylesheet">
    <script type="text/javascript" src="/static/assets/js/jquery.js"></script>
    <script type="text/javascript" src="/plugins/layer/layer.js"></script>
    <script type="text/javascript" src="/js/feijian-common.js"></script>
</head>

<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="m-b"></div>
                    <h4>欢迎来到 <strong>菲剑后台管理系统</strong></h4>
                    <strong>还没有账号？ <a href="#">立即注册&raquo;</a></strong>
                </div>
            </div>
            <div class="col-sm-5">
                <form method="post" id="loginForm" >
                    <h4 class="no-margins">登录：</h4>
                    <p class="m-t-md">登录菲剑后台管理系统</p>
                    <input type="text" id="username" class="form-control uname" placeholder="用户名" />
                    <input type="password" id="password" class="form-control pword m-b" placeholder="密码" />
                    <a href="">忘记密码了？</a>
                    <button class="btn btn-success btn-block" onclick="login();return false;">登录</button>
                </form>
            </div>
        </div>
        <div class="signup-footer">
            <div class="pull-left">
                &copy; 2016 All Rights Reserved. 菲剑
            </div>
        </div>
    </div>
    <script type="text/javascript">
	    $(function(){
	    	$("#loginForm").submit(function(e){
	    		e.preventDefault();
	    		return false;
	    	});
	 		$(".uname").select();
	 		$(document).keydown(function(e){
	 			preventSubmit();
	 			if(e.keyCode==13){
	  				login();
	  			}
	 		});
	  	});
	    
	    //登录
	    function login(){
	    	preventSubmit();
	    	var username = $("#username").val();
	    	var password = $("#password").val();
	    	if(username == '' || username == null){
				layer.msg('请输入用户名！',{anim:4, time: 1000});
				$("#username").focus();
				return;
  			}else if(password == '' || password == null){
				layer.msg('请输入密码！',{anim:4, time: 1000});
				$("#password").focus();
				return ;
			}else{
				//验证
				$.ajax({
					url:"logined",
					type:"post",
					data:{"username":username,"password":password},
					success:function(data){
						if(isNotEmpty(data)){
							if((data.code).trim() == '0012'){
								layer.msg(data.message, {
									  time: 2000,
									  anim:3  //2秒关闭（如果不配置，默认是3秒）
									}, function(){
										window.location.href="sys/index";
									});    
							}else{
								layer.msg(data.message,{anim:4, time: 1000});
							}
						}
					},
					error:function(){
						alert("出错啦");
					}
				});
			}
	    }
	    
	    function preventSubmit(){
	    	$("#loginForm").submit(function(e){
	    		e.preventDefault();
	    		return false;
	    	});
	    }
	    
	   
    </script>
</body>

</html>
