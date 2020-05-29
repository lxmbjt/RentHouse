<%@ page pageEncoding="utf-8"%> 
<%@ taglib prefix="s" uri="/struts-tags" %>  

<s:action name="Main" namespace="/"></s:action>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String user_name = (String)session.getAttribute("user_name"); 
String user_nickname = (String)session.getAttribute("user_nickname");  
String show9=(String)session.getAttribute("show9"); 
%>  


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>

     <link rel="stylesheet" href="./css/me.css">
     <link rel="stylesheet" type="text/css" href="./css/owl.carousel.css" media="all" />
     <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
	 
	
    	<link rel="stylesheet" type="text/css" href="./css/flexslider.css" media="all" />
   	<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" media="all" /> 
   	<link rel="stylesheet" type="text/css" href="./css/bootstrap-select.min.css" media="all" />
	<link rel="stylesheet" type="text/css" href="./css/owl.carousel.css" media="all" />
	<link rel="stylesheet" href="./css/Linearicons.css"> 
	<link rel="stylesheet" href="./css/font-awesome.min.css"> 
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	
<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
	<link rel="stylesheet" type="text/css" href="./css/style.css" media="all" /> 
	
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
        $(function () {
            $(".button3").on("click",function () {
                $(".small.modal.show3").modal("show");
            })
        })
    </script> 
    <script>
        $(function () {
            $(".button4").on("click",function () {
                $(".small.modal.show4").modal("show");
            })
        })
    </script> 
	
<script type="text/javascript"> 

function state(id){
var obj = document.getElementById("house");
obj.setAttribute('value',id);
document:show9.submit();
}
function menu(id){
var obj = document.getElementById("province");
obj.setAttribute('value',id);
document:showcity.submit();



}

</script>

 
  </head>
  
  
 <body>

   <div class="ui small modal show1">
      <img src="./image/about1.png" style="width:700px">
  </div>
   <div class="ui small modal show2">
      <img src="./image/about2.png" style="width:700px">
  </div>
   <div class="ui small modal show3" >
      <img src="./image/about3.png" style="width:700px">
  </div>
   <div class="ui small modal show4">
      <img src="./image/about4.png" style="width:700px">
  </div>
 
<div class="ui attached menu" >
 	<div class="left aligned menu">
 	<img src="./image/wowo.png"alt="" style="height:25px;margin-top:10px;margin-left:20px">
 	<h4 class="ui teal header item"     style="font-family:'微软雅黑'!important;font-size:17px" >蜗蜗租房</h4><!--teal 颜色-->
 	 
 	</div>
    <div class="right aligned menu">
         <a href="./main.jsp" class="center aligned m-padded-small item"  style="font-family:'微软雅黑'!important;font-size:13px"><i class="tini home icon"></i>首页</a>
   	<s:if test="null==#session.user||#session.user.isEmpty()">
   	 <a href="./login.jsp" class="center aligned m-padded-small item"  style="font-family:'微软雅黑'!important;font-size:13px"><i class="tini user icon"></i>登录</a>
      <a href="./register.jsp" class="center aligned m-padded-small item"  style="font-family:'微软雅黑'!important;font-size:13px"><i class="tini add user icon"></i>注册</a>
      <a href="./upload.jsp" class="center aligned m-padded-small item"  style="font-family:'微软雅黑'!important;font-size:13px"><i class="tini upload icon"></i>上传房源</a>
    
	</s:if>
	
	<s:else>
	  <a href="<s:url action="Person"/>" class="m-padded-small item" style="font-family:'微软雅黑'!important;font-size:13px"><i class="tini info icon" ></i>个人中心</a>
      <a href="./upload.jsp" class="center aligned m-padded-small item"  style="font-family:'微软雅黑'!important;font-size:13px"><i class="tini upload icon"></i>上传房源</a>
      <a href="Logout!execute" class="center aligned m-padded-small item"  style="font-family:'微软雅黑'!important;font-size:13px"><i class="tini remove user icon"></i>注销</a>

	</s:else>
     
      
      
    </div>
  </div>
  
 
  
 
<div id="preloader">
        <div class="loader-xbox"></div>
    </div>


<section class="search_from_aria row">
	    <div class="container coustome-container">
            <div class="row search_img_bg">
                <h2>Find Your Perfect Home Today</h2> 
<s:form action="Search" theme="simple" method="post">  

<!-- 下拉列表 -->

<div class="ui center aligned container">
<select name="province"  style="width:80px;height:40px;font-family:微软雅黑 ;border-top-right-radius:0.3em!important;
    border-bottom-right-radius:0.3em!important; border-width: 0px;!important"  >
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
  	<input type="text" placeholder="搜索城市或标题..." name="search">
  	<s:submit style="background-color:#00B5AD;width:100px;height:40px;font-family:微软雅黑 ;font-size:14px;color:white;border-top-right-radius:0.3em!important;border-top-left-radius:0em!important;
    border-bottom-right-radius:0.3em!important;border-bottom-left-radius:0em!important;    border-width: 0px;!important"  align="center" value="搜索"></s:submit> 
	</div>   

  </div>
          </s:form>          
                </div>
            </div> 


 </section>
 
 

 
      
  <s:form action="House" theme="simple" method="post" id="show9" style="margin-bottom:0">  
  <input  type="hidden" value="xxxx" name="housetitle" id="house" />
   	<!--Latest-Properties -->
	<section class="latest-properties row"> 
		<div class="container coustome-container">
			<div class="row m0 latest_head" style=" padding-bottom:0px">
				<h2>Latest Properties</h2> 
				<div class="properties-slider">
<%=show9 %>
				</div>
			</div>
		</div>
	</section>
	<!--End Latest-Properties -->
 </s:form>


 <section class="latest-properties row"> 
     <s:form action="Search" theme="simple" method="post" id="showcity" style="margin-bottom:0"> 
     <input type="hidden" value="0" name="province" id="province" /> 
     <input type="hidden" value="" name="search" id="search" /> 
		<div class="container coustome-container">
			<div class="row m0 latest_head">
				<h2 style="padding-top: 50px;">most popular city</h2>   
       <a type="submit" onclick="menu(1)"class="ui medium image" style="width:350px!important">
  <img  src="./image/beijing.jpg">
</a>
       <a type="submit" onclick="menu(3)" class="ui medium image" style="width:500px!important;position: absolute;left: 402px;top: 1317px;">
  <img  src="./image/shanghai.jpg">
</a>
<a type="submit" onclick="menu(19)" class="ui medium image" style="height:21px!important;position: absolute;left: 402px;top: 1558px;">
  <img  src="./image/guangdong.jpg" style="height:210px">
</a>
<a type="submit" onclick="menu(21)" class="ui medium image" style="height:210px!important;width:340px!important;position: absolute;left: 706px;top: 1558px;">
  <img  src="./image/sichuan.jpg" style="height:210px">
</a>
<a type="submit" onclick="menu(11)" class="ui medium image" style="height:237.1px!important;position: absolute;left: 906px;top: 1317px;">
  <img  src="./image/zhejiang.jpg" style="height:237.1px">
</a>
<a type="submit" onclick="menu(15)" class="ui medium image" style="height:210px!important;width:340px!important;position: absolute;left: 1026px;top: 1558px;">
  <img  src="./image/shandong.jpg" style="height:210px">
</a>
    </div>
    </div>
    </s:form>
    </section>




  <section class="latest-properties row" style="height:400px"> 
		<div class="container coustome-container">
			<div class="row m0 latest_head">
				<h2 style="padding-top: 0px;">things About Us</h2>   
 
    <div class="ui segment" style="background-color:transparent;border: 0px;box-shadow:0 0 0 0">
  <div class="ui center aligned four column grid" style="background-color:transparent;">

  <div class="column" style="width:250px;padding-left:0;padding-right: 0;">
    <div class="ui  fluid card" style="box-shadow:0 0 0 0;background-color:transparent;">
      <div class="image" style="background-color:transparent;border-right:1px solid rgba(34,36,38,.1)">
        <img  class="button1" src="./image/a1.png">
      </div>
      <div class="content" style="border-right:1px solid rgba(34,36,38,.1);border-top:0;">
        <a class="button1" style="color:#666666;font-weight: 600;font-size: 1.28571429em;margin-top: -.21425em;font-family:'微软雅黑'!important" >双方身份验证</a>
      </div>
    </div>
  </div>
  <div class=" column" style="width:250px;padding-left:0;padding-right: 0;">
    <div class="ui fluid card" style="box-shadow:0 0 0 0;background-color:transparent;">
      <div class="image" style="background-color:transparent;border-right:1px solid rgba(34,36,38,.1)">
        <img class="button2" src="./image/a2.png">
      </div>
      <div class="content" style="border-right:1px solid rgba(34,36,38,.1);border-top:0;">
        <a class="button2" style="color:#666666;font-weight: 600;font-size: 1.28571429em;margin-top: -.21425em;font-family:'微软雅黑'!important" >安全线上交易</a>
      </div>
    </div>
  </div>
  <div class="column" style="width:250px;padding-left:0;padding-right: 0;">
    <div class="ui fluid card" style="box-shadow:0 0 0 0;background-color:transparent;">
      <div class="image" style="background-color:transparent;border-right:1px solid rgba(34,36,38,.1)">
        <img src="./image/a3.png" class="button3">
      </div>
      <div class="content" style="border-right:1px solid rgba(34,36,38,.1);border-top:0;">
        <a class="button3" style="color:#666666;font-weight: 600;font-size: 1.28571429em;margin-top: -.21425em;font-family:'微软雅黑'!important" >坚实保障后盾</a>
      </div>
    </div>
  </div>
  <div class="column" style="width:250px;padding-left:0;padding-right:0;">
    <div class="ui fluid card" style="box-shadow:0 0 0 0;background-color:transparent;">
      <div class="image" style="background-color:transparent" >
        <img src="./image/a4.png"  class="button4">
      </div>
      <div class="content" style="border-top:0;" >
        <a class="button4" style="color:#666666;font-weight: 600;font-size: 1.28571429em;margin-top: -.21425em;font-family:'微软雅黑'!important" >点评积累信用</a>
      </div>
    </div>
  </div>
</div>
</div>
    
    </div>
    </div>

    
    </section>
 
    

 
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
 
 
 

    <!--jQuery JS-->
    <script src="./js/jquery-1.12.0.min.js"></script>
    <!--Bootstrap JS-->
    <script src="./js/bootstrap.min.js"></script> 
    <!--Bootstrap-select JS-->
    <script src="./js/bootstrap-select.min.js"></script>
    <!--Flexslider JS-->
    <script src="./js/jquery.flexslider.js"></script>
    <!--Owl Carousel JS-->
    <!--<script src="vendors/owl-carousel/owl.carousel.min.js"></script>-->
    <script src="./js/owl.carousel.min.js"></script>
    <!-- Counterup JS -->
    <script src="./js/waypoints.min.js"></script>
    <script src="./js/jquery.counterup.min.js"></script>
    <!--jQuery ui JS-->
	<script src="./js/jquery-ui.min.js"></script>

    <!--Theme-->
    <script src="./js/theme.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
<script type="text/javascript">
	window.onload = function(){
		$("option").click(function(){
			$("#select").removeAttr("size");
			$("#select").blur();
			this.attr("selected","");
		});
 
		$("#select").focus(function(){
			$("#select").attr("size","5");
		})
	}
	
</script>
<script type="text/javascript"> 

$('.ui.modal')
  .modal()
;
</script>
  </body>
</html>
