<%@ page pageEncoding="utf-8"%> 
<%@ taglib prefix="s" uri="/struts-tags" %>  
<s:action name="Person" namespace="/"></s:action>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

   
String user_name = (String)session.getAttribute("user_name"); 
String user_nickname = (String)session.getAttribute("user_nickname");  

String usergender=(String)session.getAttribute("usergender"); 
String userphone=(String)session.getAttribute("userphone"); 
String userwechat=(String)session.getAttribute("userwechat"); 
String useravatar=(String)session.getAttribute("useravatar"); 
String useremail=(String)session.getAttribute("useremail"); 
String userhouse=(String)session.getAttribute("PersonHouse");
String userorder= (String)session.getAttribute("PersonOrder");
String userordered= (String)session.getAttribute("PersonOrdered");
String userstar= (String)session.getAttribute("PersonStar");
%>  

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
        
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
         <link rel="stylesheet" href="./css/me.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
          <title>个人中心</title>
<style>
*{
font-family:"微软雅黑",Calibri;
}
hr.style5 {
	

	border-top: 1px dashed #8c8b8b;
}
</style>
<script type="text/javascript">
function state(id){
var obj = document.getElementById("house");
obj.setAttribute('value',id);
}
function state1(id){
var obj = document.getElementById("housemodify");
obj.setAttribute('value',id);
document.form1.action="HouseModify";
document.form1.submit();

}
function state2(id){
var obj = document.getElementById("cancelorder");
obj.setAttribute('value',id);


}
function state3(id){
var obj = document.getElementById("setorder");
obj.setAttribute('value',id);
var obj1 = document.getElementById("settype");
obj1.setAttribute('value',1);

}
function state4(id){
var obj = document.getElementById("setorder");
obj.setAttribute('value',id);
var obj1 = document.getElementById("settype");
obj1.setAttribute('value',2);


}

function state5(id){

var obj = document.getElementById("deletehouse");
obj.setAttribute('value',id);

var second = confirm("是否删除该房源");

if(second){
document.form1.action="HouseDelete";
document.form1.submit();


}else{

//取消

}



}
function state6(id){

var obj = document.getElementById("offhouse");
obj.setAttribute('value',id);

var second = confirm("是否下架该房源");

if(second){
document.form1.action="HouseOff";
document.form1.submit();


}else{

//取消

}



}
function state7(id){

var obj = document.getElementById("uphouse");
obj.setAttribute('value',id);


document.form1.action="HouseUp";
document.form1.submit();

}
function order(id){

var obj = document.getElementById("ownerid");
obj.setAttribute('value',id);
document.getElementById('Owner').submit();

}
</script>
<title>个人中心页</title>
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
	  <a href="<s:url action="Person"/>" class="m-padded-small item"><i class="tini info icon"></i>个人中心</a>
      <a href="./upload.jsp" class="center aligned m-padded-small item"  style="font-family:'微软雅黑'!important;font-size:13px"><i class="tini upload icon"></i>上传房源</a>
      <a href="Logout!execute" class="center aligned m-padded-small item"  style="font-family:'微软雅黑'!important;font-size:13px"><i class="tini remove user icon"></i>注销</a>

	</s:else>
     
      
      
    </div>
  </div>
  <br><br>

 <div class="ui container" style="left-margin:350px ;width:800px;height:200px;background-color:#F9F9F9">
   <div class="ui items" >
  <div class="item " >
    <a class="ui small image" style="margin-left:25px!important;margin-top:25px!important" >
     <s:if test='#session.useravatar!=null'>
      <img src=<%= useravatar%>>
      </s:if>
      <s:else>
      <img src="./avatar/default.jpg"/>
      </s:else>
    </a>
    <div class="content "  style="margin-left:25px!important;margin-top:29px!important;margin-right:25px!important">
      <a class="header" style="font-size:24px;" ><%= user_nickname %></a>
      <s:if test='#session.usergender=="0"'>
      <i class="large blue mars icon"></i>
      </s:if>
      <s:if test='#session.usergender=="1"'>
      <i class="big pink venus icon"></i>
      </s:if>
     
 <div style="display: inline;float:right;">
 <i class="large angle double right icon" onclick="location='./personmodify.jsp'"></i> 
 </div>

      
      <div class="description" style="font-size:15px;" >
       <s:if test='#session.user_name!=null'>
       <i class="user icon"></i> <span style="line-height:30px;" >姓名：</span><%=user_name %><br>
       </s:if>
       
        <s:if test='#session.userphone!=null'>
       <i class="phone icon"></i> <span style="line-height:30px;" >电话：</span><%=userphone %><br>
        </s:if>
        <s:if test='#session.userwechat!=null'>
       <i class="wechat icon"></i> <span style="line-height:25px;" >微信：</span><%=userwechat %><br>
          </s:if>
            <s:if test='#session.useremail!=null'>
      <i class="envelope outline icon"></i><span style="line-height:30px;padding-left:4px" >邮箱：</span><%=useremail %>
      </s:if>
      </div>
    </div>  
    
 </div>
 </div>
 </div>

  <div class="ui container" style="margin-left:350px ;margin-bottom:50px;width:800px;background-color:#FCFCFC">
 
 <div class="ui attached teal message" style="margin-top:30px ">
 <i class="star icon"></i> 
 <div style="display: inline;float:right;">
 <i class="large angle double right icon" onclick="location='./starmodify.jsp'"></i> 
 </div>
我的收藏： 
</div>
  <s:form action="House" theme="simple" method="post" >  
  <input  type="hidden" value="xxxx" name="housetitle" id="house" />
  <div class="ui left aligned horizontal segments"  >
  <%=userstar %>
 </div>
  </s:form>
 
 <div class="ui attached teal message" style="margin-top:30px ">
 <i class="university icon"></i> 
我的房源： 
</div>

  
  <s:form action="" theme="simple" method="post" name="form1">  
  <input  type="hidden" value="xxxx" name="houseid" id="housemodify" />
  <input  type="hidden" value="xxxx" name="deletehouse" id="deletehouse" />
    <input  type="hidden" value="xxxx" name="uphouse" id="uphouse" />
  <input  type="hidden" value="xxxx" name="offhouse" id="offhouse" />
  <%=userhouse %>
 
  </s:form>


<div class="ui attached teal message">
 <i class="edit icon"></i> 
我的预约： 
</div>
<s:form action="OrderCancel" theme="simple" method="post" >  
  <input  type="hidden" value="xxxx" name="cancelorder" id="cancelorder" />
<%=userorder %>
</s:form>
<div class="ui attached teal message">
 <i class="phone icon"></i> 
预约我的： 

</div>
<s:form action="SetOrder" theme="simple" method="post" >  
  <input  type="hidden" value="xxxx" name="setorder" id="setorder" />
  <input  type="hidden" value="xxxx" name="settype" id="settype" />
<%=userordered %>
</s:form>

 <s:form action="Owner" theme="simple" method="post" id="Owner" >  
				<input  type="hidden" value="xxxx" name="ownerid" id="ownerid" />
</s:form>

</div>

<footer  class="ui center aligned  vertical segment m-padded-tb-massive" style="background-color: #e0f3f1;">
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
