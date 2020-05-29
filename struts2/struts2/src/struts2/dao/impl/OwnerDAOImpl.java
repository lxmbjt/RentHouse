package struts2.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import struts2.dao.OwnerDAO;

import struts2.db.DBConnect;
import struts2.vo.User;

public class OwnerDAOImpl implements OwnerDAO  {

	@Override
	public User Owner(int id) throws Exception {
		// TODO Auto-generated method stub
		
		//String sql = "select * from userinfo where username=?";
		String sql = "select * from user where user_id=?";
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
        User u=new User();//登录的user
        // 下面是针对数据库的具体操作   
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt.setInt(1, id);
            System.out.println(pstmt);
            // 进行数据库查询操作   
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){   
                // 查询出内容，之后将查询出的内容赋值给person对象   
                
                	//System.out.println(rs.getObject(1));
                	u.setE_mail(rs.getString("e_mail"));
                	u.setGender(rs.getInt("gender"));
                	u.setIdcard_number(rs.getString("idcard_number"));
                	u.setPassword(rs.getString("password"));
                	u.setPhone(rs.getString("phone"));
                	u.setUser_avatar(rs.getString("user_avatar"));
                	u.setUser_id(rs.getInt("user_id"));
                	u.setUser_name(rs.getString("user_name"));
                	u.setUser_nickname(rs.getString("user_nickname"));
                	u.setWechat(rs.getString("wechat"));
                	
                	
                	return u;//返回用户i
                } 
               
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // 关闭数据库连接   
            dbc.close() ;   
        }   
		return null;
	}

	
	public String OwnerHouse(int ownerid) throws Exception{
		
		String sql = "select * from house where f_owner_id=?";
		
		
		String[] towards={"","朝南","朝北 ","朝东","朝西"};
		String[] renttypes={"","整租","合租 ","整租合租均可"};
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
        String str="";
        // 下面是针对数据库的具体操作   
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt.setInt(1, ownerid);
           
            System.out.println(pstmt);
            // 进行数据库查询操作   
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){   
                // 查询出内容，之后将查询出的内容赋值给person对象   
            	 int id = rs.getInt("house_id");
    	         String title = rs.getString("housetitle");
    	         String add=rs.getString("address");
    	         String date=rs.getDate("release_time").toString();
    	         int storey=rs.getInt("storey");
    	         int charge=rs.getInt("charge");
    	         String to=towards[rs.getInt("towards")];
    	         String renttype=renttypes[rs.getInt("rent_type")];
    	         String pic=Pic(id);
    	         System.out.println(pic);
    	         String img="<div class=\"ui center aligned divided items\"  ><div class=\"item\"><div class=\"image\" style=\"width:230px; \"><img src=\""+pic+"\"></div>";
    	         String chargestr="<div class=\"content\"><a class=\"header\">"+title+"</a><div class=\"meta\"><span class=\"price\" style=\"color:#00B5AD ;font-family:微软雅黑 ; font-size:16px font-weight:bold\">"+charge+"</span>"
    	         +"<span class=\"stay\" style=\"color:#00B5AD ;font-family:微软雅黑 ; font-size:13px;font-weight:bold\" >元/月</span></div>";
    	         String description=" <div class=\"description\"><p>"+add+"</p><p>发布日期："+date+"</p><p>楼层："+storey+"层</p></div>";
    	         String extra="<div class=\"extra\" style=\"font-family:微软雅黑 ;\" ><div class=\"ui label\">"+to+"</div><div class=\"ui label\" >"+renttype+"</div>";
    	         String button=" <input type=\"submit\"   style=\"background-color:#00B5AD;width:70px;height:25px;font-family:微软雅黑 ;color:white;border-top-right-radius:0.3em!important;"
    	        	+ "border-bottom-right-radius:0.3em!important;\" value=\"详细信息\"id=\""+title+"\"  onclick=\"state(this.id)\" /></div></div></div></div>" ;
    	        String line=" <hr class=\"style5\">";
    	         
    	         str+=img+chargestr+description+extra+button+line;
    	     
    	         
    	         System.out.println(str);
    	         
                } 
            
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // 关闭数据库连接   
            dbc.close() ;   
        }   
		return str;
			
		
	}


	@Override
	public String PersonHouse(int ownerid) throws Exception {
		//个人信息页，房屋列表
		String sql = "select * from house where f_owner_id=?";
		
		
		String[] towards={"","朝南","朝北 ","朝东","朝西"};
		String[] renttypes={"","整租","合租 ","整租合租均可"};
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
        String str="";
        // 下面是针对数据库的具体操作   
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt.setInt(1, ownerid);
           
            System.out.println(pstmt);
            // 进行数据库查询操作   
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){   
                // 查询出内容，之后将查询出的内容赋值给person对象   
            	 int id = rs.getInt("house_id");
    	         String title = rs.getString("housetitle");
    	         String add=rs.getString("address");
    	         String date=rs.getDate("release_time").toString();
    	         int storey=rs.getInt("storey");
    	         int charge=rs.getInt("charge");
    	         String to=towards[rs.getInt("towards")];
    	         String renttype=renttypes[rs.getInt("rent_type")];
    	         String pic=Pic(id);
    	         System.out.println(pic);
    	         String img="<div class=\"ui center aligned divided items\"  ><div class=\"item\"><div class=\"image\" style=\"width:230px; \"><img src=\""+pic+"\"></div>";
    	         String chargestr="<div class=\"content\"><a class=\"header\">"+title+"</a><div class=\"meta\"><span class=\"price\" style=\"color:#00B5AD ;font-family:微软雅黑 ; font-size:16px font-weight:bold\">"+charge+"</span>"
    	         +"<span class=\"stay\" style=\"color:#00B5AD ;font-family:微软雅黑 ; font-size:13px;font-weight:bold\" >元/月</span></div>";
    	         String description=" <div class=\"description\"><p>"+add+"</p><p>发布日期："+date+"</p><p>楼层："+storey+"层</p></div>";
    	         String extra="<div class=\"extra\" style=\"font-family:微软雅黑 ;\" ><div class=\"ui label\">"+to+"</div><div class=\"ui label\" >"+renttype+"</div>";
    	         String button=" <input type=\"submit\"   style=\"background-color:#00B5AD;width:70px;height:25px;font-family:微软雅黑 ;color:white;border-width:0px;border-bottom-right-radius:0.2em!important;border-bottom-left-radius:0.2em!important;border-top-right-radius:0.3em!important;border-top-left-radius:0.3em!important;\""
    	        	+ " value=\"查看修改\"id=\""+id+"\"  onclick=\"state1(this.id)\" /></div></div></div></div>" ;
    	        String line=" <hr class=\"style5\">";
    	         
    	         str+=img+chargestr+description+extra+button+line;
    	     
    	         
    	         System.out.println(str);
    	         
                } 
            
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // 关闭数据库连接   
            dbc.close() ;   
        }   
		return str;
		
		
		
	}
	
	public String Pic(int house_id) throws Exception{
		
		String sql = "select * from pics where f_pic_house_id=? limit 1";
	
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
        
        // 下面是针对数据库的具体操作   
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt.setInt(1,house_id);
           
            System.out.println(pstmt);
            System.out.println(pstmt);
            // 进行数据库查询操作   
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){   
                // 查询出内容，之后将查询出的内容赋值给person对象   
            	String pic=rs.getString("pic");
            		
                	return pic;//返回用户i
                } 
            
            rs.close() ; 
            pstmt.close() ;   
        }catch (Exception e){   
            System.out.println(e.getMessage());   
        }finally{   
            // 关闭数据库连接   
            dbc.close() ;   
        }   
		return "";
	}


	@Override
	public String PersonOrder(int ownerid) throws Exception {
		//查找我发出的order
		String sql = "select * from reservation where f_user_id_rent=? && date>=current_date()";
		String sql1 = "select * from user where user_id=?";
		
		
		PreparedStatement pstmt = null ;   
		PreparedStatement pstmt1 = null ;  
        DBConnect dbc = null;   
        String str="";
        // 下面是针对数据库的具体操作   
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt1 = dbc.getConnection().prepareStatement(sql1) ; 
            pstmt.setInt(1, ownerid);
           
            System.out.println(pstmt);
            // 进行数据库查询操作   
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){   
                // 查询出内容，之后将查询出的内容赋值给person对象   
            	 int orderedid = rs.getInt("f_user_id_owner");
    	         
    	         String position=rs.getString("position");
    	         String date=rs.getDate("date").toString();
    	         String time=rs.getTime("time").toString();
    	         String message=rs.getString("message");
    	         int isagree=rs.getInt("isagree");
    	         int id=rs.getInt("reverse_id");
    	         String agree="";
    	         String button="";
    	         if (isagree==0){
    	        	 button=" <input type=\"submit\"   style=\"margin-left:20px;background-color:#00B5AD;width:70px;height:25px;font-family:微软雅黑 ;color:white;border-width:0px;border-bottom-right-radius:0.3em!important;border-bottom-left-radius:0.3em!important;border-top-right-radius:0.3em!important;border-top-left-radius:0.3em!important;\""
    	    	        	+ "value=\"取消预约\"id=\""+id+"\"  onclick=\"state2(this.id)\" />";
    	        	  agree="未被处理";
    	         }
    	         else if(isagree==1){
    	        	 agree="已被同意";
    	        	 
    	         }
    	         else if(isagree==2){
    	        	 button=" <input type=\"submit\"   style=\"margin-left:20px;background-color:#00B5AD;width:70px;height:25px;font-family:微软雅黑 ;color:white;border-width:0px;border-bottom-right-radius:0.3em!important;border-bottom-left-radius:0.3em!important;border-top-right-radius:0.3em!important;border-top-left-radius:0.3em!important;\""
 	    	        	+ "value=\"取消预约\"id=\""+id+"\"  onclick=\"state2(this.id)\" />";
 	        	  agree="已被拒绝";
    	        	 
    	         }
    	         pstmt1.setInt(1, orderedid);
    	         ResultSet orderrs = pstmt1.executeQuery();
    	         if( orderrs.next()){
    	         String ordername=orderrs.getString("user_nickname");
    	         String orderphone=orderrs.getString("phone");
    	         String img="<div class=\"ui center aligned  items\"  >";
    	         String chargestr="<div class=\"content\"><a class=\"header\" style=\"color:#00B5AD ;font-family:微软雅黑 ; font-size:22px;margin-left:20px;\">"+date+"</a><span class=\"price\" style=\"color:#00B5AD ;font-family:微软雅黑 ; font-size:16px;\">——"+time+"</span>";
    	         String description=" <div class=\"description\" style=\"margin-top:15px;font-family:微软雅黑 ;margin-left:20px;\"><p style=\"margin:6px auto;\">预约地点："+position+"</p><p style=\"margin:6px auto;\">预约房主："+ordername+"</p><p style=\"margin:6px auto;\">房主电话："+orderphone+"<p style=\"margin:6px auto;\">我的留言："+message+"</p><p style=\"margin:6px auto;\">状态："+agree+button+"</p></div></div></div>" ;
    	         String line=" <hr class=\"style5\">";
    	        
    	         str+=img+chargestr+description+line;
    	     
    	         
    	         System.out.println(str);}
    	         
                } 
            
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // 关闭数据库连接   
            dbc.close() ;   
        }   
		return str;
		
	}


	@Override
	public String PersonOrdered(int ownerid) throws Exception {
		//查找给我发出的order
		String sql = "select * from reservation where f_user_id_owner=? && date>=current_date()";
		String sql1 = "select * from user where user_id=?";
		
		
		PreparedStatement pstmt = null ;   
		PreparedStatement pstmt1 = null ;  
        DBConnect dbc = null;   
        String str="";
        // 下面是针对数据库的具体操作   
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt1 = dbc.getConnection().prepareStatement(sql1) ; 
            pstmt.setInt(1, ownerid);
           
            System.out.println(pstmt);
            // 进行数据库查询操作   
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){   
                // 查询出内容，之后将查询出的内容赋值给person对象   
            	 int orderid = rs.getInt("f_user_id_rent");
    	       
    	         String position=rs.getString("position");
    	         String date=rs.getDate("date").toString();
    	         String time=rs.getTime("time").toString();
    	         String message=rs.getString("message");
    	         pstmt1.setInt(1, orderid);
    	         int isagree=rs.getInt("isagree");
    	         int id=rs.getInt("reverse_id");
    	         String agree="";
    	         String button1="";
    	         String button2="";
    	         if (isagree==0){
    	        	 button1=" <input type=\"submit\"   style=\"margin-left:20px;background-color:#00B5AD;width:70px;height:25px;font-family:微软雅黑 ;color:white;border-width:0px;border-bottom-right-radius:0.3em!important;border-bottom-left-radius:0.3em!important;border-top-right-radius:0.3em!important;border-top-left-radius:0.3em!important;\""
    	    	        	+ "value=\"同意\"id=\""+id+"\"  onclick=\"state3(this.id)\" />";
    	        	 button2=" <input type=\"submit\"   style=\"margin-left:20px;background-color:#00B5AD;width:70px;height:25px;font-family:微软雅黑 ;color:white;border-width:0px;border-bottom-right-radius:0.3em!important;border-bottom-left-radius:0.3em!important;border-top-right-radius:0.3em!important;border-top-left-radius:0.3em!important;\""
 	    	        	+ "value=\"拒绝\"id=\""+id+"\"  onclick=\"state4(this.id)\" />";
    	        	  agree="未处理";
    	         }
    	         else if(isagree==1){
    	        	 agree="已同意";
    	        	 
    	         }
    	         else if(isagree==2){
    	        
 	        	  agree="已拒绝";
    	        	 
    	         }
    	         ResultSet orderrs = pstmt1.executeQuery();
    	         if( orderrs.next()){
    	         String ordername=orderrs.getString("user_nickname");
    	         String orderphone=orderrs.getString("phone");
    	         String img="<div class=\"ui center aligned  items\"  >";
    	         String chargestr="<div class=\"content\"><a class=\"header\" style=\"color:#00B5AD ;font-family:微软雅黑 ; font-size:22px;margin-left:20px;\">"+date+"</a><span class=\"price\" style=\"color:#00B5AD ;font-family:微软雅黑 ; font-size:16px;\">——"+time+"</span>";
    	         String description=" <div class=\"description\" style=\"margin-top:15px;font-family:微软雅黑 ;margin-left:20px;\"><p style=\"margin:6px auto;\">预约地点："+position+"</p><p style=\"margin:6px auto;\">预约租客："+ordername+"</p><p style=\"margin:6px auto;\">租客电话："+orderphone+"<p style=\"margin:6px auto;\">ta的留言："+message+"</p><p style=\"margin:6px auto;\">状态："+agree+button1+button2+"</p></div></div></div>" ;
    	         String line=" <hr class=\"style5\">";
    	        
    	         str+=img+chargestr+description+line;
    	     
    	         
    	         System.out.println(str);}
    	         
                } 
            
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // 关闭数据库连接   
            dbc.close() ;   
        }   
		return str;
	}


	@Override
	public String PersonStar(int ownerid) throws Exception {
		
		String sql = "select * from favorite where f_user_id=?";
		String sql1 = "select * from house where house_id=?";
		
		
		PreparedStatement pstmt = null ;   
		PreparedStatement pstmt1 = null ;  
        DBConnect dbc = null;   
        String str="";
        // 下面是针对数据库的具体操作   
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
            pstmt1 = dbc.getConnection().prepareStatement(sql1) ; 
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt.setInt(1, ownerid);
          
            System.out.println(pstmt);
            // 进行数据库查询操作   
            ResultSet rs = pstmt.executeQuery();
            
            int num=0;
			while(rs.next()&&num<4){   
                // 查询出内容，之后将查询出的内容赋值给person对象   
            	 int id = rs.getInt("f_house_id");
            	 pstmt1.setInt(1, id);
            	 ResultSet rshouse = pstmt1.executeQuery();
            	 if(rshouse.next()){
    	         String title = rshouse.getString("housetitle");  
    	         String displaytitle="";
    	         if(title.length()>6){
    	         displaytitle = title.substring(0,6)+"...";
    	         }  
    	         else  {displaytitle = title;}
    	         String pic=Pic(id);
    	         System.out.println(pic);
    	         String img="<div class=\"ui  segment\" style=\"width:200px!important\"><img src=\""+pic+"\" style=\"width:170px; height:110px; \">";
    	         String chargestr="<div class=\"content\" style=\"width:170px\"><a style=\"color:black;font-size:14px;font-family:微软雅黑\" >"+displaytitle+"</a>";
    	         String button=" <div style=\"display: inline;float:right;\"> <input type=\"submit\"   style=\"background-color:#00B5AD;font-family:微软雅黑 ;color:white;height:25px;border-width:0px;border-bottom-right-radius:0.3em!important;border-bottom-left-radius:0.3em!important;border-top-right-radius:0.3em!important;border-top-left-radius:0.3em!important;\""
    	        	+ "\" value=\"详细信息\"id=\""+title+"\"  onclick=\"state(this.id)\" /></div></div></div>" ;
    	        
    	         
    	         str+=img+chargestr+button;
    	         num++;
    	         
    	         System.out.println(str);
            	 }
            	
                
			}
            rs.close() ; 
            pstmt.close() ;   
        }
        
        catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // 关闭数据库连接   
            dbc.close() ;   
        }   
		return str;
		
	}


	@Override
	public String PersonStarList(int ownerid) throws Exception {
		String sql = "select * from favorite where f_user_id=?";
		String sql1 = "select * from house where house_id=?";
		
		
		PreparedStatement pstmt = null ;   
		PreparedStatement pstmt1 = null ;  
        DBConnect dbc = null;   
        String str="";
        // 下面是针对数据库的具体操作   
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
            pstmt1 = dbc.getConnection().prepareStatement(sql1) ; 
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt.setInt(1, ownerid);
          
            System.out.println(pstmt);
            // 进行数据库查询操作   
            ResultSet rs = pstmt.executeQuery();
            String[] towards={"","朝南","朝北 ","朝东","朝西"};
    		String[] renttypes={"","整租","合租 ","整租合租均可"};

            int num=0;
			while(rs.next()){   
				int starid = rs.getInt("favorite_id");
                // 查询出内容，之后将查询出的内容赋值给person对象   
            	 int id = rs.getInt("f_house_id");
            	 pstmt1.setInt(1, id);
            	 ResultSet rshouse = pstmt1.executeQuery();
            	 if(rshouse.next()){
    	         String title = rshouse.getString("housetitle");  
    	         
    	         String add=rshouse.getString("address");
    	         String date=rshouse.getDate("release_time").toString();
    	         int storey=rshouse.getInt("storey");
    	         int charge=rshouse.getInt("charge");
    	         String to=towards[rshouse.getInt("towards")];
    	         String renttype=renttypes[rshouse.getInt("rent_type")];

    	         String pic=Pic(id);
    	         System.out.println(pic);
    	         String img="<div class=\"ui center aligned divided items\"  ><div class=\"item\"><div class=\"image\" style=\"width:230px; \"><img src=\""+pic+"\"></div>";
    	         String chargestr="<div class=\"content\"><a class=\"header\">"+title+"</a><div class=\"meta\"><span class=\"price\" style=\"color:#00B5AD ;font-family:微软雅黑 ; font-size:16px font-weight:bold\">"+charge+"</span>"
    	         +"<span class=\"stay\" style=\"color:#00B5AD ;font-family:微软雅黑 ; font-size:13px;font-weight:bold\" >元/月</span></div>";
    	         String description=" <div class=\"description\"><p>"+add+"</p><p>发布日期："+date+"</p><p>楼层："+storey+"层</p></div>";
    	         String extra="<div class=\"extra\" style=\"font-family:微软雅黑 ;\" ><div class=\"ui label\">"+to+"</div><div class=\"ui label\" >"+renttype+"</div>";
    	             	             	         
    	         String button=" <input type=\"submit\"   style=\"background-color:#00B5AD;width:70px;height:25px;font-family:微软雅黑 ;color:white;"
     	        	+ "\" value=\"详细信息\"id=\""+title+"\"  onclick=\"state(this.id)\" />" ;
    	         String button2=" <input type=\"submit\"   style=\"background-color:#00B5AD;width:70px;height:25px;font-family:微软雅黑 ;color:white;"
      	        	+ "\" value=\"取消收藏\"id=\""+starid+"\"  onclick=\"state1(this.id)\" /></div></div></div></div>" ;
     	        String line=" <hr class=\"style5\">";

    	        
    	         
     	        str+=img+chargestr+description+extra+button+button2+line;

    	         num++;
    	         
    	         System.out.println(str);
            	 }
                
			}
            rs.close() ; 
            pstmt.close() ;   
        }
	
        catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // 关闭数据库连接   
            dbc.close() ;   
        }   
        System.out.println("str"+str);
		return str;
		
	}

}
