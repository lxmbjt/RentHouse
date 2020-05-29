<%@ page pageEncoding="utf-8"%>  
<%@ taglib prefix="s" uri="/struts-tags" %>  

<%   
String user_name = (String)session.getAttribute("user_name"); 
String user_nickname = (String)session.getAttribute("user_nickname");  
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>       
    <title>登录</title>  

<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
    
       <link rel="stylesheet" href="./css/me.css">
        <style type="text/css">
       
    body {
     background:url("./image/bg1.png");
     background-size: cover;
       font-family:"微软雅黑"!important;
    }
    body > .grid {
      height: 100%;
    }
    
    .column {
      max-width: 450px;
    }
    .field{
    height:45px!important;
    
    }
    
  </style>
  <script>
  $(document)
    .ready(function() {
      $('.ui.form')
        .form({
          fields: {
            phone: {
              identifier  : 'user.phone',
              rules: [
                {
                  type   : 'empty',
                  prompt : '请输入您的电话！'
                }
               
              ]
            },
            password: {
              identifier  : 'user.password',
              rules: [
                {
                  type   : 'empty',
                  prompt : '请输入您的密码！'
                }
              ]
            }
          }
        })
      ;
    })
  ;
  </script>
  </head>
  
  
  <body>
 	<div class="ui attached menu" >
 	<div class="left aligned menu"> 
 	<img src="./image/wowo.png"alt="" style="height:25px;margin-top:10px;margin-left:20px">
 	<h4 class="ui teal header item"     style="font-family:'微软雅黑'!important;font-size:17px">蜗蜗租房</h4><!--teal 颜色-->
 	 
 	</div>
    <div class="right aligned menu">
         <a href="./main.jsp" class="center aligned m-padded-small item"  style="font-family:'微软雅黑'!important;font-size:13px"><i class="tini home icon"></i>首页</a>
   	<s:if test="null==#session.user||#session.user.isEmpty()">
   	 <a href="./login.jsp" class="center aligned m-padded-small item"  style="font-family:'微软雅黑'!important;font-size:13px"><i class="tini user icon"></i>登录</a>
      <a href="./register.jsp" class="center aligned m-padded-small item"  style="font-family:'微软雅黑'!important;font-size:13px"><i class="tini add user icon"></i>注册</a>
      <a href="./upload.jsp" class="center aligned m-padded-small item"  style="font-family:'微软雅黑'!important;font-size:13px"><i class="tini upload icon"></i>上传房源</a>
    
	</s:if>
	
	<s:else>
	  <a href="<s:url action="Person"/>" class="m-padded-mini item"><i class="tini info icon"></i>个人中心</a>
      <a href="./upload.jsp" class="center aligned m-padded-small item"  style="font-family:'微软雅黑'!important;font-size:13px"><i class="tini upload icon"></i>上传房源</a>
      <a href="Logout!execute" class="center aligned m-padded-small item"  style="font-family:'微软雅黑'!important;font-size:13px"><i class="tini remove user icon"></i>注销</a>

	</s:else>
     
      
      
    </div>
  </div>
  
 
    
    
    <div class="ui middle aligned center aligned grid"style="margin-top:-40px;margin-left:600px">
  <div class="column">
    <h2 class="ui teal image header" style="margin-left:-10px;margin-bottom:10px">
      <img src="./image/wowo.png" class="image" style="width:50px;height:47px;">
      <div class="content" style=" font-family:'微软雅黑'!important;font-weight:550!important; padding-top:10px;">
        登录&ensp;蜗蜗租房
      </div>
    </h2>
    <form class="ui large form" action="Login">
      <div class="ui stacked segment" >
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text"  name="user.phone" placeholder="请输入您的电话"  style=" font-family:'微软雅黑'!important;">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="lock icon"></i>
            <input type="password" name="user.password" placeholder="请输入密码"  style=" font-family:'微软雅黑'!important;">
          </div>

        </div>
        <div class="ui fluid large teal submit button" style=" font-family:'微软雅黑'!important;font-weight:500!important;">登&ensp;&ensp;&ensp;录</div>
      </div>
           <div style=" background-color: #FFF6F6;color: #9F3A38; " >   
 <s:actionerror  /> 
</div>
      <div class="ui error message">
     
      </div>

    </form>

    <div class="ui message">
      还没有注册？ <a href="./register.jsp" style="color:00B5AD">加入我们>></a>
    </div>
  </div>
</div>
  
 
  </body>  
</html>  
