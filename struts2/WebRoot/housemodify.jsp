<%@ page language="java"  pageEncoding="UTF-8"%>  
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String user_name = (String)session.getAttribute("user_name"); 
String user_nickname = (String)session.getAttribute("user_nickname");  

String houseid = (String)session.getAttribute("houseresult"); 

%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>Struts2 Person Login Result</title>  
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
       <link rel="stylesheet" href="./me.css">
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
  
  
	<strong>修改房屋资料</strong>
	<br>
	<br>
	<form name="modifyForm" action="<%=path%>/House_save.action"  method="post">
	<table  width="500" >
	  <tr>
	    <td>房屋名称：</td>
	    <td><input type="text" name="houseTitle" value='<s:property value="#session.modify_House.houseTitle"/>'/> </td>
	  </tr>
	  <tr>
	    <td width="100">所在省份：</td>
	    <td width="200"><s:select  name="province" list='#{1:"北京市",2:"天津市",3:"上海市",4:"重庆市",5:"河北省",6:"山西省",7:"辽宁省",8:"吉林省",9:"黑龙江省",10:"江苏省",11:"浙江省",12:"安徽省",13:"福建",14:"江西省",15:"山东省",16:"河南省",17:"湖北省",18:"湖南省",19:"广东省",20:"海南省",21:"四川省",22:"贵州省",23:"云南省",24:"陕西省",25:"甘肃省",26:"青海省",27:"内蒙古自治区",28:"广西壮族自治区",29:"西藏自治区",30:"宁夏回族自治区",31:"新疆维吾尔自治区",32:"香港特别行政区",33:"澳门特别行政区",34:"台湾省"}' listKey="key" listValue="value" value = "#session.modify_House.province" theme="simple"></s:select></td>
	  </tr>
	  <tr>
	    <td>所在市：</td>
	    <td><input type="text" name="city" value='<s:property value="#session.modify_House.city"/>'/> </td>
	  </tr>
	  
	  <tr>
	    <td colspan="2" align="center"><input class="button" type="submit" value="修改"></td>
	  </tr>
	</table>
	
	</form>
    <footer  class="ui center aligned  vertical segment m-padded-tb-massive" style="background-color: #e0f3f1"><!--vertical 取消圆角不留缝隙 css定义上下宽度-->
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
