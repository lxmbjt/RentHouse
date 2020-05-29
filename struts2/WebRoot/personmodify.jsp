<%@ page language="java"  pageEncoding="UTF-8"%>  
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%   
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String user_name = (String)session.getAttribute("user_name"); 
String user_nickname = (String)session.getAttribute("user_nickname");  
String user_id=session.getAttribute("user_id").toString();
String starlist=(String)session.getAttribute("starlist"); 

%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>个人信息修改页</title>  

<link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
     <link rel="stylesheet" href="./me.css">

  </head>
  
  
  <body>
  <s:action name="StarModify" namespace="/"></s:action>
 	<div class="ui menu">
 	<div class="left aligned menu">
 	<h4 class="ui teal header item">蜗蜗租房</h4><!--teal 颜色-->
 	 
 	</div>
        <div class="right aligned menu">
         <a href="./main.jsp" class="m-padded-mini item"><i class="tini home icon"></i>首页</a>
   	<s:if test="null==#session.user||#session.user.isEmpty()">
   	 <a href="./login.jsp" class="m-padded-mini item"><i class="tini user icon"></i>登录</a>
      <a href="./register.jsp" class="m-padded-mini item"><i class="tini add user icon"></i>注册</a>
      <a href="./upload.jsp" class="m-padded-mini item"><i class="tini upload icon"></i>上传房源</a>
    
	</s:if>
	
	<s:else>
	   <a href="<s:url action="Person"/>" class="m-padded-mini item"><i class="tini info icon"></i>个人中心</a>
      <a href="./upload.jsp" class="m-padded-mini item"><i class="tini upload icon"></i>上传房源</a>
      <a href="Logout!execute" class="m-padded-mini item"><i class="tini remove user icon"></i>注销</a>

	</s:else>
     
      
      
    </div>
  </div>
<form name="modifyForm" action="<%=path%>/User_save.action"  method="post">
<table  width="700" >
  <tr>
    <td width="100">用户名：</td>
    <td><input type="text" name="userName" value='<s:property value="#session.modify_User.userName"/>'/></td>
    <td height="40" width="400"><s:fielderror fieldName="userName"></s:fielderror> </td>
  </tr>
  <tr>
    <td>昵称：</td>
    <td><input type="text" name="userNickName" value='<s:property value="#session.modify_User.userNickName"/>'/> </td>
    <td height="40" width="400"><s:fielderror fieldName="userNickName"></s:fielderror> </td>
  </tr>
  <tr>
    <td>性别：</td>
    <td>
      <s:if test='%{#session.modify_User.gender=="0"}'>
        <input type="radio" name="gender" value="男" checked="checked"/>男
        <input type="radio" name="gender" value="女"/>女
      </s:if>
      <s:else>
        <input type="radio" name="gender" value="男" />男
        <input type="radio" name="gender" value="女" checked="checked"/>女
      </s:else>
    </td>
  </tr>
  <tr>
    <td>头像：</td>
    <td><img src="<%=request.getContextPath()%>/resources/images/${session.modify_User.userAvatar}" height='100' width='100'/></td>
  </tr>
  <tr>
    <td>电话号码：</td>
    <td><input type="text" name="phone" value='<s:property value="#session.modify_User.phone"/>'/> </td>
    <td height="40" width="400"><s:fielderror fieldName="phone"></s:fielderror> </td>
  </tr>
  <tr>
    <td>微信：</td>
    <td><input type="text" name="wechat" value='<s:property value="#session.modify_User.wechat"/>'/></td>
    <td height="40" width="400"><s:fielderror fieldName="wechat"></s:fielderror> </td>
  </tr>
  <tr>
    <td>邮箱：</td>
    <td><input type="text" name="EMail" value='<s:property value="#session.modify_User.EMail"/>'/></td>
    <td height="40" width="400"><s:fielderror fieldName="EMail"></s:fielderror> </td>
  </tr>
  <tr>
    <td>密码：</td>
    <td><input type="text" name="password" value='<s:property value="#session.modify_User.password"/>'/></td>
    <td height="40" width="400"><s:fielderror fieldName="password"></s:fielderror> </td>
  </tr>
  <tr>
    <td>身份证号：</td>
    <td><input type="text" name="idcardNumber" value='<s:property value="#session.modify_User.idcardNumber"/>'/></td>
    <td height="40" width="400"><s:fielderror fieldName="idcardNumber"></s:fielderror> </td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input class="button" type="submit" value="修改"></td>
  </tr>
</table>

</form>

 
    <footer  class="ui center aligned  vertical segment m-padded-tb-massive" style="background-color: #e0f3f1;top:3400px">
<div class="ui center aligned container"><!--内容居中-->
    <div class="ui  divided  grid">
        <div class="three wide column" style="background-color: #e0f3f1">
            <div class="ui link list">
                <div class="item">
                    <img src="./image/wowowechat.png" class="ui rounded image" alt="" style="width: 110px">
                </div>
            </div>
        </div>
        <div class="three wide column" style="background-color: #e0f3f1">
           
            <div class="ui  link list">
                 <i class="big user  icon" style="opacity: 0.8"></i>
                <a href="./rentguide.jsp" class="item" style="font-weight: 700;">房客指南</a>
                <br>
                   <i class="big building icon" style="opacity: 0.8"></i>
                <a href="./ownerguide.jsp" class="item " style="font-weight: 700;">房东指南</a>
                
            </div>
        </div>
                <div class="five wide column" style="background-color: #e0f3f1">
            <h4 class="ui  header m-text-thin m-text-spaced"></h4>
            <div class="image" style="background-color:transparent" >
        <img src="./image/wowo.png" style="width:70px">
      </div>
            <p class="m-text-spaced m-opacity-mini" style="font-size:16px;font-weight: 600;color:rgba(0,0,0,.6)">蜗蜗租房，为你寻觅温暖的家</p>
        </div>
      
        <div class="four wide column" style="background-color: #e0f3f1">
            <p class="m-text-spaced m-opacity-mini" style="font-size:16px;font-weight: 600;color:rgba(0,0,0,.6)">联系我们</p>
           
            <div class="ui link list">
                <a  class="item"style="height:20px">客服电话: 400 - 010 - 1234</a>
                <a  class="item" style="height:20px">客服邮箱: service@wowo.com</a>
            </div>
        </div>
    </div>
    <div class="ui  divider"  ></div><!--分割线-->
    <p class="m-text-thin m-text-spaced m-opacity-tiny" style="background-color: #e0f3f1"> 京ICP备12035936号-1   许可证号：京ICP证140510号    安全联盟    北京快跑信息科技有限公司    营业执照号 103613118
京公网安备 11010802020380号  </p>
  <p class="m-text-thin m-text-spaced m-opacity-tiny" style="background-color: #e0f3f1"> 违法和不良信息举报电话：4000107890转6    举报邮箱：jubao@wowo.com</p>
    <p class="m-text-thin m-text-spaced m-opacity-tiny" style="background-color: #e0f3f1">Copyright © 2020 - 2100 TBY Designed by TBY</p>

</div>

</footer> 
  
  </body>  
</html>  
