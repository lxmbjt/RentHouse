<%@ page language="java"  pageEncoding="UTF-8"%>  
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%   

String ownername=(String)session.getAttribute("ownername"); 
String ownergender=(String)session.getAttribute("ownergender"); 
String ownerphone=(String)session.getAttribute("ownerphone"); 
String ownerwechat=(String)session.getAttribute("ownerwechat"); 
String owneravatar=(String)session.getAttribute("owneravatar"); 
String owneremail=(String)session.getAttribute("owneremail"); 
String ownerhouse=(String)session.getAttribute("ownerhouse"); 
	  

%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
  <style>
  
  hr.style5 {
	

	border-top: 1px dashed #8c8b8b;
}
*{
	font-family:"微软雅黑",Calibri;
}

}</style>
    <title>用户信息页</title>  
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
       <link rel="stylesheet" href="./css/me.css">
    
  <script type="text/javascript">
function state(id){
var obj = document.getElementById("house");
obj.setAttribute('value',id);
}
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
  <br><br>
 <div class="ui container" style="left-margin:350px ;width:800px;background-color:#F9F9F9">
   <div class="ui items" >
  <div class="item " >
    <a class="ui small image" style="margin-left:25px!important;margin-top:25px!important" >
      <img src=<%= owneravatar%>>
    </a>
    <div class="content "  style="margin-left:25px!important;margin-top:29px!important;margin-right:25px!important">
      <a class="header" style="font-size:24px;" ><%= ownername %></a>
      <s:if test='#session.ownergender=="0"'>
      <i class="large blue mars icon"></i>
      </s:if>
      <s:if test='#session.ownergender=="1"'>
      <i class="big pink venus icon"></i>
      </s:if>
      
      <div class="description" style="font-size:15px;" >
       <s:if test='#session.ownerphone!=null'>
       <i class="phone icon"></i> <span style="line-height:30px;" >电话：</span><%=ownerphone %><br>
       </s:if>
       <s:if test='#session.ownerwechat!=null'>
       <i class="wechat icon"></i> <span style="line-height:25px;" >微信：</span><%=ownerwechat %><br>
       </s:if>
       <s:if test='#session.owneremail!=null'>
      <i class="envelope outline icon"></i><span style="line-height:30px;" >邮箱：</span><%=owneremail %>
      </s:if>
      </div>
    </div>  
 </div>
 </div>
 </div>
 <br><br>
 <div>
 <div class="ui container" style="margin-left:350px ;margin-bottom:150px;width:800px;background-color:#FCFCFC">
 <div class="ui teal message">
 <i class="university icon"></i> 
ta上传的房源如下： </div>
      <hr class="style5">

  <s:form action="House" theme="simple" method="post" style="margin-bottom:150px">  
  <input  type="hidden" value="xxxx" name="housetitle" id="house" />
 <%= ownerhouse%>
 </s:form>
 </div>
 </div>


 <!--底部footer-->
<footer  class="ui center aligned  vertical segment m-padded-tb-massive" style="background-color: #e0f3f1;font-family:'微软雅黑'!important"><!--vertical 取消圆角不留缝隙 css定义上下宽度-->
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
