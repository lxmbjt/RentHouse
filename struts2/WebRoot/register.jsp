<%@ page pageEncoding="utf-8"%>  
<%@ taglib prefix="s" uri="/struts-tags" %>  

<%   
String user_name = (String)session.getAttribute("user_name"); 
String user_nickname = (String)session.getAttribute("user_nickname");  
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>       
    <title>注册</title>  

<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
    <link rel="stylesheet" type="text/css" href="./css/style.css" media="all" /> 
       <link rel="stylesheet" href="./css/me.css">
        <style type="text/css">
       
    body {
     background:url("./image/bg1.png");
     background-size: cover;
       font-family:"微软雅黑"!important;
       background-repeat:no-repeat;
    }
    body > .grid {
      height: 100%;
    }
    
    .column {
      max-width: 450px;
    }
    .field{
    height:40px!important;
    
    }
    
  </style>
  <script>
        $(function () {
            $(".button1").on("click",function () {
                $(".small.modal.show1").modal("show");
            })
        })
    </script> 
    <script>
        $(function () {
            $(".button2").on("click",function () {
                $(".small.modal.show2").modal("show");
            })
        })
    </script> 
  <script>
  $(document)
    .ready(function() {
      $('.ui.form')
        .form({
          fields: {
              nickname: {
              identifier  : 'user.user_nickname',
              rules: [
                {
                  type   : 'empty',
                  prompt : '请输入您的昵称！'
                }
              ]
            },
            phone: {
              identifier  : 'user.phone',
              rules: [
                {
                  type   : 'empty',
                  prompt : '请输入您的电话！'
                },{

					type: 'regExp',  //
                    value: /^(13[0-9]{9})|(15[89][0-9]{8})$/,
                    prompt: '请输入正确的手机号码！'
               }
              ]
            },
            password: {
              identifier  : 'user.password',
              rules: [
                {
                  type   : 'empty',
                  prompt : '请输入您的密码！'
                },
                {
                  type   : 'length[6]',
                  prompt : '您的密码至少为6位'
                }
                
              ]
            },
           repassword: {
              identifier  : 'user.repassword',
              rules: [
                {
                  type   : 'empty',
                  prompt : '请再次输入您的密码！'
                },{
                	type: 'match[user.password]',
                    prompt: '您输入的密码不一致！'
                
                
                }
                
                
              ]
            },
            terms: {
        identifier: 'terms',
        rules: [
          {
            type   : 'checked',
            prompt : '您还未同意服务协议和隐私声明！'
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
 
   <div class="ui small modal show1">
      <img src="./image/service.png" style="width:700px">
  </div>
  <div class="ui small modal show2">
      <img src="./image/privacy.png" style="width:700px">
  </div>
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
       
        <div class="ui  center aligned grid"style="margin-top:20px;margin-left:600px">
  <div class="column">
    <h2 class="ui left aligned teal image header" style="margin-left:-200px;margin-bottom:5px">
      <img src="./image/wowo.png" class="image" style="width:40px;height:37px;">
      <div class="content" style=" font-family:'微软雅黑'!important;font-weight:550!important; padding-top:10px;">
        注册&ensp;蜗蜗租房
      </div>
    </h2>
    <form class="ui large form" action="Register">
      <div class="ui stacked segment" >
      <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text"  name="user.user_nickname" placeholder="请输入您的昵称"  style=" font-family:'微软雅黑'!important;">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="phone icon"></i>
            <input type="text"  name="user.phone" placeholder="请输入您的电话"  style=" font-family:'微软雅黑'!important;">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="lock icon"></i>
            <input type="password" name="user.password" placeholder="请输入密码"  style=" font-family:'微软雅黑'!important;">
          </div></div>
 			<div class="field">
          <div class="ui left icon input">
            <i class="lock icon"></i>
            <input type="password" name="user.repassword" placeholder="请再次输入密码"  style=" font-family:'微软雅黑'!important;">
          </div>
        </div>
        <div class="ui checkbox" style="margin-bottom:10px">
  <input name="terms" type="checkbox" name="example">
  <label>我同意 <a class="button1" style="color:00B5AD">《服务协议》</a>、<a class="button2" style="color:00B5AD">《隐私保护声明》</a></label>
</div>
 
        <div class="ui fluid large teal submit button" style=" font-family:'微软雅黑'!important;font-weight:500!important;">注&ensp;&ensp;&ensp;册</div>
  
           <div style=" background-color: #FFF6F6;color: #9F3A38; " >   
 <s:actionerror  /> 
</div></div>
      <div class="ui error message">
     
      </div>

    </form>

    <div class="ui message">
   已有账号？ <a href="./login.jsp" style="color:00B5AD">前往登录>></a>
    </div>
    <br>
  </div>
</div>
   
    
    
    
    
    
    
    
    
    
    
  </body>  
</html>  
