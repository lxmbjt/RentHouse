<%@ page pageEncoding="utf-8"%> 
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

   
String rs = (String)session.getAttribute("searchresult"); 
String tag = (String)session.getAttribute("tag"); 
  
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
<title>
搜索结果页
</title>
    <base href="<%=basePath%>">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
         <link rel="stylesheet" href="./css/me.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
  <script>
  $(document)
    .ready(function() {
      $('.ui.borderless.menu a.item')
        .on('click', function() {
          $(this)
            .addClass('active')
            .siblings()
            .removeClass('active')
          ;
          
        })
      ;
    })
  ;
</script>
 <script type="text/javascript"> 

function state(id){
var obj = document.getElementById("house");
obj.setAttribute('value',id);
}

function menu1(id){
var obj = document.getElementById("menu1");
obj.setAttribute('value',id);


}
function menu2(id){
var obj = document.getElementById("menu2");
obj.setAttribute('value',id);

}
function menu3(id){
var obj = document.getElementById("menu3");
obj.setAttribute('value',id);

}
function menu4(id){
var obj = document.getElementById("menu4");
obj.setAttribute('value',id);

}
function menu5(id){
var obj = document.getElementById("menu5");
obj.setAttribute('value',id);

}
function menu6(id){
var obj = document.getElementById("menu6");
obj.setAttribute('value',id);

}
</script>

  </head>
  
  
 <body >
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
	  <a href="<s:url action="Person"/>" class="m-padded-small item" style="font-family:'微软雅黑'!important;font-size:13px"><i class="tini info icon"></i>个人中心</a>
      <a href="./upload.jsp" class="center aligned m-padded-small item"  style="font-family:'微软雅黑'!important;font-size:13px"><i class="tini upload icon"></i>上传房源</a>
      <a href="Logout!execute" class="center aligned m-padded-small item"  style="font-family:'微软雅黑'!important;font-size:13px"><i class="tini remove user icon"></i>注销</a>

	</s:else>
     
      
      
    </div>
  </div><br/><br>
  
  <div class="ui center aligned container">
 
<s:form action="Search" theme="simple" method="post">  




<!-- 下拉列表 -->


<select name="province"  style="width:80px;height:35px;font-family:微软雅黑 ;border-top-right-radius:0.3em!important;
    border-bottom-right-radius:0.3em!important;"  >
<option value="1">北京市</option>
<option value="2">天津市</option>
<option value="3">上海市</option>
<option value="4">重庆市</option>
<option value="5">河北省</option>
<option value="6">山西省</option>
<option value="7">辽宁省</option>
<option value="8">吉林省</option>
<option value="9">黑龙江省</option>
<option value="10">江苏省</option>
<option value="11">浙江省</option>
<option value="12">安徽省</option>
<option value="13">福建省</option>
<option value="14">江西省</option>
<option value="15">山东省</option>
<option value="16">河南省</option>
<option value="17">湖北省</option>
<option value="18">湖南省</option>
<option value="19">广东省</option>
<option value="20">海南省</option>
<option value="21">四川省</option>
<option value="22">贵州省</option>
<option value="23">云南省</option>
<option value="24">陕西省</option>
<option value="25">甘肃省</option>
<option value="26">青海省</option>
<option value="27">内蒙古</option>
<option value="28">广西</option>
<option value="29">西藏</option>
<option value="30">宁夏</option>
<option value="31">新疆</option>
<option value="32">香港</option>
<option value="33">澳门</option>
<option value="34">台湾</option>

</select>



  <!-- 搜索框 -->
	 <div class="ui action left icon input">

  	<i class="small search icon"></i>
  	<input type="text" placeholder="搜索城市或标题..." name="search" style="height:35px;">
  	<s:submit style="background-color:#00B5AD;width:100px;height:35px;font-family:微软雅黑 ;font-size:14px;color:white;border-top-right-radius:0.3em!important;border-top-left-radius:0em!important;
    border-bottom-right-radius:0.3em!important;border-bottom-left-radius:0em!important;    border-width: 0px;!important"  align="center" value="搜索"></s:submit> 
	</div>   

  
  </s:form>
   </div>

  

<div class="ui center aligned container" style="width:850px;">
<s:form action="SearchByTag" theme="simple" method="post" >  
<input type="hidden" value="0" name="menu1" id="menu1" />
<input type="hidden" value="" name="menu2" id="menu2" />
<input type="hidden" value="" name="menu3" id="menu3" />
<input type="hidden" value="" name="menu4" id="menu4" />
<input type="hidden" value="" name="menu5" id="menu5" />
<input type="hidden" value="" name="menu6" id="menu6" />
  <div class="ui attached borderless menu">
  <h5 class="ui teal header item">租金： </h5>
  <a class="item active" id="0" onclick="menu1(this.id)">全部</a>
  <a class="item" id="1" onclick="menu1(this.id)">500元以下</a>
  <a class="item" id="2" onclick="menu1(this.id)">500-1000元</a>
  <a class="item" id="3" onclick="menu1(this.id)">1000-1500元</a>
  <a class="item" id="4" onclick="menu1(this.id)">1500-2000元</a>
  <a class="item" id="5" onclick="menu1(this.id)">2000-3000元</a>
  <a class="item" id="6" onclick="menu1(this.id)">3000元以上</a>
</div>
 <div class="ui attached borderless menu">
  <h5 class="ui teal header item">房间： </h5>
  <a class="item active" id="" onclick="menu2(this.id)">全部</a>
  <a class="item" id="1" onclick="menu2(this.id)">一室</a>
  <a class="item" id="2" onclick="menu2(this.id)">二室</a>
  <a class="item" id="3" onclick="menu2(this.id)">三室</a>
  <a class="item" id="4" onclick="menu2(this.id)">四室</a>
  <a class="item" id="5" onclick="menu2(this.id)">五室及以上</a>
</div>
 <div class="ui attached borderless menu">
  <h5 class="ui teal header item">类型： </h5>
  <a class="item active" id="" onclick="menu3(this.id)">全部</a>
  <a class="item" id="1" onclick="menu3(this.id)">整租</a>
  <a class="item" id="2" onclick="menu3(this.id)">合租</a>
  <a class="item" id="3" onclick="menu3(this.id)">无限制</a>
  
</div>
 <div class="ui attached borderless menu">
  <h5 class="ui teal header item">种类： </h5>
  <a class="item active" id="" onclick="menu4(this.id)">全部</a>
  <a class="item" id="1" onclick="menu4(this.id)">普通住宅</a>
  <a class="item" id="2" onclick="menu4(this.id)">公寓</a>
  <a class="item" id="3" onclick="menu4(this.id)">别墅</a>
  <a class="item" id="4" onclick="menu4(this.id)">四合院</a>
  <a class="item" id="5" onclick="menu4(this.id)">商住两用</a>
  <a class="item" id="6" onclick="menu4(this.id)">新里洋房</a>
  <a class="item" id="7" onclick="menu4(this.id)">老公房</a>
  <a class="item" id="8" onclick="menu4(this.id)">平房</a>
  <a class="item" id="9" onclick="menu4(this.id)">其他</a>
</div>

  <div class="ui attached borderless menu">
  <h5 class="ui teal header item">朝向： </h5>
  <a class="item active" id="" onclick="menu5(this.id)">全部</a>
  <a class="item" id="1" onclick="menu5(this.id)">朝南</a>
  <a class="item" id="2" onclick="menu5(this.id)">朝北</a>
  <a class="item" id="3" onclick="menu5(this.id)">朝东</a>
  <a class="item" id="4" onclick="menu5(this.id)">朝西</a>
</div>
  
    <div class="ui attached borderless menu">
  <h5 class="ui teal header item">付款： </h5>
  <a class="item active" id="" onclick="menu6(this.id)">全部</a>
  <a class="item" id="1" onclick="menu6(this.id)">押一付一</a>
  <a class="item" id="2" onclick="menu6(this.id)">押一付二</a>
  <a class="item" id="3" onclick="menu6(this.id)">押一付三</a>
  <a class="item" id="4" onclick="menu6(this.id)">押三付三</a>
  <a class="item" id="5" onclick="menu6(this.id)">押三付六</a>
  <a class="item" id="6" onclick="menu6(this.id)">年付</a>
   <div class="ui  action left icon input" style="margin-left:117px;">
  <s:submit style="background-color:#00B5AD;width:100px;height:40px;font-family:微软雅黑 ;color:white;border-top-right-radius:0.3em!important;
    border-bottom-right-radius:0.3em!important;border-width: 0px;!important"  align="center" value="搜索"></s:submit> 
	</div>   

</div>

</s:form>
  </div>
  
  
  
  
  
  
  
  
  
  <!-- 列表 -->
  <div style="margin-left:200px;margin-right:200px;">
  
  <s:form action="House" theme="simple" method="post" >  
  <input  type="hidden" value="xxxx" name="housetitle" id="house" />
   <hr class="style5">

 <%=rs%>
 </s:form>
 <div >

 <s:if test='!#session.tag.equals("true")'>
   	 <s:url id="url_pre" value="Search.action" >
 <s:param name="pageNow" value="pageNow-1"></s:param>
 </s:url>
  <s:url id="url" value="Search.action" >
 <s:param name="pageNow" value="pageNow"></s:param>
 
 </s:url> 
 <s:url id="url_next" value="Search.action" >  
 <s:param name="pageNow" value="pageNow+1"/>  
 </s:url>  

 <s:a href="%{url_pre}" style="margin-left:25px; color: #00B5AD;text-decoration:underline;font-family: '微软雅黑';background:#ffffff;font-size:15px;padding:5px;padding-left:15px;padding-right:15px;border-bottom-right-radius:0.3em!important;border-bottom-left-radius:0.3em!important;border-top-right-radius:0.3em!important;border-top-left-radius:0.3em!important;border-bottom-right-radius:0.3em!important;" >上一页</s:a>
  <s:a href="%{url_next}" style="margin-left:600px;color: #00B5AD;text-decoration:underline;font-family: '微软雅黑';background:#ffffff;font-size:15px;padding:5px;padding-left:15px;padding-right:15px;border-bottom-right-radius:0.3em!important;border-bottom-left-radius:0.3em!important;border-top-right-radius:0.3em!important;border-top-left-radius:0.3em!important;border-bottom-right-radius:0.3em!important;">下一页</s:a>
 <s:actionerror/> 
    
	</s:if>
 
 
 
 </div>
 </div>
  <br>

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
