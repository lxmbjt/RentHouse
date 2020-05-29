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
        User u=new User();//��¼��user
        // ������������ݿ�ľ������   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt.setInt(1, id);
            System.out.println(pstmt);
            // �������ݿ��ѯ����   
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){   
                // ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��person����   
                
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
                	
                	
                	return u;//�����û�i
                } 
               
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // �ر����ݿ�����   
            dbc.close() ;   
        }   
		return null;
	}

	
	public String OwnerHouse(int ownerid) throws Exception{
		
		String sql = "select * from house where f_owner_id=?";
		
		
		String[] towards={"","����","���� ","����","����"};
		String[] renttypes={"","����","���� ","����������"};
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
        String str="";
        // ������������ݿ�ľ������   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt.setInt(1, ownerid);
           
            System.out.println(pstmt);
            // �������ݿ��ѯ����   
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){   
                // ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��person����   
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
    	         String chargestr="<div class=\"content\"><a class=\"header\">"+title+"</a><div class=\"meta\"><span class=\"price\" style=\"color:#00B5AD ;font-family:΢���ź� ; font-size:16px font-weight:bold\">"+charge+"</span>"
    	         +"<span class=\"stay\" style=\"color:#00B5AD ;font-family:΢���ź� ; font-size:13px;font-weight:bold\" >Ԫ/��</span></div>";
    	         String description=" <div class=\"description\"><p>"+add+"</p><p>�������ڣ�"+date+"</p><p>¥�㣺"+storey+"��</p></div>";
    	         String extra="<div class=\"extra\" style=\"font-family:΢���ź� ;\" ><div class=\"ui label\">"+to+"</div><div class=\"ui label\" >"+renttype+"</div>";
    	         String button=" <input type=\"submit\"   style=\"background-color:#00B5AD;width:70px;height:25px;font-family:΢���ź� ;color:white;border-top-right-radius:0.3em!important;"
    	        	+ "border-bottom-right-radius:0.3em!important;\" value=\"��ϸ��Ϣ\"id=\""+title+"\"  onclick=\"state(this.id)\" /></div></div></div></div>" ;
    	        String line=" <hr class=\"style5\">";
    	         
    	         str+=img+chargestr+description+extra+button+line;
    	     
    	         
    	         System.out.println(str);
    	         
                } 
            
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // �ر����ݿ�����   
            dbc.close() ;   
        }   
		return str;
			
		
	}


	@Override
	public String PersonHouse(int ownerid) throws Exception {
		//������Ϣҳ�������б�
		String sql = "select * from house where f_owner_id=?";
		
		
		String[] towards={"","����","���� ","����","����"};
		String[] renttypes={"","����","���� ","����������"};
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
        String str="";
        // ������������ݿ�ľ������   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt.setInt(1, ownerid);
           
            System.out.println(pstmt);
            // �������ݿ��ѯ����   
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){   
                // ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��person����   
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
    	         String chargestr="<div class=\"content\"><a class=\"header\">"+title+"</a><div class=\"meta\"><span class=\"price\" style=\"color:#00B5AD ;font-family:΢���ź� ; font-size:16px font-weight:bold\">"+charge+"</span>"
    	         +"<span class=\"stay\" style=\"color:#00B5AD ;font-family:΢���ź� ; font-size:13px;font-weight:bold\" >Ԫ/��</span></div>";
    	         String description=" <div class=\"description\"><p>"+add+"</p><p>�������ڣ�"+date+"</p><p>¥�㣺"+storey+"��</p></div>";
    	         String extra="<div class=\"extra\" style=\"font-family:΢���ź� ;\" ><div class=\"ui label\">"+to+"</div><div class=\"ui label\" >"+renttype+"</div>";
    	         String button=" <input type=\"submit\"   style=\"background-color:#00B5AD;width:70px;height:25px;font-family:΢���ź� ;color:white;border-width:0px;border-bottom-right-radius:0.2em!important;border-bottom-left-radius:0.2em!important;border-top-right-radius:0.3em!important;border-top-left-radius:0.3em!important;\""
    	        	+ " value=\"�鿴�޸�\"id=\""+id+"\"  onclick=\"state1(this.id)\" /></div></div></div></div>" ;
    	        String line=" <hr class=\"style5\">";
    	         
    	         str+=img+chargestr+description+extra+button+line;
    	     
    	         
    	         System.out.println(str);
    	         
                } 
            
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // �ر����ݿ�����   
            dbc.close() ;   
        }   
		return str;
		
		
		
	}
	
	public String Pic(int house_id) throws Exception{
		
		String sql = "select * from pics where f_pic_house_id=? limit 1";
	
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
        
        // ������������ݿ�ľ������   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt.setInt(1,house_id);
           
            System.out.println(pstmt);
            System.out.println(pstmt);
            // �������ݿ��ѯ����   
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){   
                // ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��person����   
            	String pic=rs.getString("pic");
            		
                	return pic;//�����û�i
                } 
            
            rs.close() ; 
            pstmt.close() ;   
        }catch (Exception e){   
            System.out.println(e.getMessage());   
        }finally{   
            // �ر����ݿ�����   
            dbc.close() ;   
        }   
		return "";
	}


	@Override
	public String PersonOrder(int ownerid) throws Exception {
		//�����ҷ�����order
		String sql = "select * from reservation where f_user_id_rent=? && date>=current_date()";
		String sql1 = "select * from user where user_id=?";
		
		
		PreparedStatement pstmt = null ;   
		PreparedStatement pstmt1 = null ;  
        DBConnect dbc = null;   
        String str="";
        // ������������ݿ�ľ������   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt1 = dbc.getConnection().prepareStatement(sql1) ; 
            pstmt.setInt(1, ownerid);
           
            System.out.println(pstmt);
            // �������ݿ��ѯ����   
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){   
                // ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��person����   
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
    	        	 button=" <input type=\"submit\"   style=\"margin-left:20px;background-color:#00B5AD;width:70px;height:25px;font-family:΢���ź� ;color:white;border-width:0px;border-bottom-right-radius:0.3em!important;border-bottom-left-radius:0.3em!important;border-top-right-radius:0.3em!important;border-top-left-radius:0.3em!important;\""
    	    	        	+ "value=\"ȡ��ԤԼ\"id=\""+id+"\"  onclick=\"state2(this.id)\" />";
    	        	  agree="δ������";
    	         }
    	         else if(isagree==1){
    	        	 agree="�ѱ�ͬ��";
    	        	 
    	         }
    	         else if(isagree==2){
    	        	 button=" <input type=\"submit\"   style=\"margin-left:20px;background-color:#00B5AD;width:70px;height:25px;font-family:΢���ź� ;color:white;border-width:0px;border-bottom-right-radius:0.3em!important;border-bottom-left-radius:0.3em!important;border-top-right-radius:0.3em!important;border-top-left-radius:0.3em!important;\""
 	    	        	+ "value=\"ȡ��ԤԼ\"id=\""+id+"\"  onclick=\"state2(this.id)\" />";
 	        	  agree="�ѱ��ܾ�";
    	        	 
    	         }
    	         pstmt1.setInt(1, orderedid);
    	         ResultSet orderrs = pstmt1.executeQuery();
    	         if( orderrs.next()){
    	         String ordername=orderrs.getString("user_nickname");
    	         String orderphone=orderrs.getString("phone");
    	         String img="<div class=\"ui center aligned  items\"  >";
    	         String chargestr="<div class=\"content\"><a class=\"header\" style=\"color:#00B5AD ;font-family:΢���ź� ; font-size:22px;margin-left:20px;\">"+date+"</a><span class=\"price\" style=\"color:#00B5AD ;font-family:΢���ź� ; font-size:16px;\">����"+time+"</span>";
    	         String description=" <div class=\"description\" style=\"margin-top:15px;font-family:΢���ź� ;margin-left:20px;\"><p style=\"margin:6px auto;\">ԤԼ�ص㣺"+position+"</p><p style=\"margin:6px auto;\">ԤԼ������"+ordername+"</p><p style=\"margin:6px auto;\">�����绰��"+orderphone+"<p style=\"margin:6px auto;\">�ҵ����ԣ�"+message+"</p><p style=\"margin:6px auto;\">״̬��"+agree+button+"</p></div></div></div>" ;
    	         String line=" <hr class=\"style5\">";
    	        
    	         str+=img+chargestr+description+line;
    	     
    	         
    	         System.out.println(str);}
    	         
                } 
            
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // �ر����ݿ�����   
            dbc.close() ;   
        }   
		return str;
		
	}


	@Override
	public String PersonOrdered(int ownerid) throws Exception {
		//���Ҹ��ҷ�����order
		String sql = "select * from reservation where f_user_id_owner=? && date>=current_date()";
		String sql1 = "select * from user where user_id=?";
		
		
		PreparedStatement pstmt = null ;   
		PreparedStatement pstmt1 = null ;  
        DBConnect dbc = null;   
        String str="";
        // ������������ݿ�ľ������   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt1 = dbc.getConnection().prepareStatement(sql1) ; 
            pstmt.setInt(1, ownerid);
           
            System.out.println(pstmt);
            // �������ݿ��ѯ����   
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){   
                // ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��person����   
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
    	        	 button1=" <input type=\"submit\"   style=\"margin-left:20px;background-color:#00B5AD;width:70px;height:25px;font-family:΢���ź� ;color:white;border-width:0px;border-bottom-right-radius:0.3em!important;border-bottom-left-radius:0.3em!important;border-top-right-radius:0.3em!important;border-top-left-radius:0.3em!important;\""
    	    	        	+ "value=\"ͬ��\"id=\""+id+"\"  onclick=\"state3(this.id)\" />";
    	        	 button2=" <input type=\"submit\"   style=\"margin-left:20px;background-color:#00B5AD;width:70px;height:25px;font-family:΢���ź� ;color:white;border-width:0px;border-bottom-right-radius:0.3em!important;border-bottom-left-radius:0.3em!important;border-top-right-radius:0.3em!important;border-top-left-radius:0.3em!important;\""
 	    	        	+ "value=\"�ܾ�\"id=\""+id+"\"  onclick=\"state4(this.id)\" />";
    	        	  agree="δ����";
    	         }
    	         else if(isagree==1){
    	        	 agree="��ͬ��";
    	        	 
    	         }
    	         else if(isagree==2){
    	        
 	        	  agree="�Ѿܾ�";
    	        	 
    	         }
    	         ResultSet orderrs = pstmt1.executeQuery();
    	         if( orderrs.next()){
    	         String ordername=orderrs.getString("user_nickname");
    	         String orderphone=orderrs.getString("phone");
    	         String img="<div class=\"ui center aligned  items\"  >";
    	         String chargestr="<div class=\"content\"><a class=\"header\" style=\"color:#00B5AD ;font-family:΢���ź� ; font-size:22px;margin-left:20px;\">"+date+"</a><span class=\"price\" style=\"color:#00B5AD ;font-family:΢���ź� ; font-size:16px;\">����"+time+"</span>";
    	         String description=" <div class=\"description\" style=\"margin-top:15px;font-family:΢���ź� ;margin-left:20px;\"><p style=\"margin:6px auto;\">ԤԼ�ص㣺"+position+"</p><p style=\"margin:6px auto;\">ԤԼ��ͣ�"+ordername+"</p><p style=\"margin:6px auto;\">��͵绰��"+orderphone+"<p style=\"margin:6px auto;\">ta�����ԣ�"+message+"</p><p style=\"margin:6px auto;\">״̬��"+agree+button1+button2+"</p></div></div></div>" ;
    	         String line=" <hr class=\"style5\">";
    	        
    	         str+=img+chargestr+description+line;
    	     
    	         
    	         System.out.println(str);}
    	         
                } 
            
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // �ر����ݿ�����   
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
        // ������������ݿ�ľ������   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
            pstmt1 = dbc.getConnection().prepareStatement(sql1) ; 
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt.setInt(1, ownerid);
          
            System.out.println(pstmt);
            // �������ݿ��ѯ����   
            ResultSet rs = pstmt.executeQuery();
            
            int num=0;
			while(rs.next()&&num<4){   
                // ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��person����   
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
    	         String chargestr="<div class=\"content\" style=\"width:170px\"><a style=\"color:black;font-size:14px;font-family:΢���ź�\" >"+displaytitle+"</a>";
    	         String button=" <div style=\"display: inline;float:right;\"> <input type=\"submit\"   style=\"background-color:#00B5AD;font-family:΢���ź� ;color:white;height:25px;border-width:0px;border-bottom-right-radius:0.3em!important;border-bottom-left-radius:0.3em!important;border-top-right-radius:0.3em!important;border-top-left-radius:0.3em!important;\""
    	        	+ "\" value=\"��ϸ��Ϣ\"id=\""+title+"\"  onclick=\"state(this.id)\" /></div></div></div>" ;
    	        
    	         
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
            // �ر����ݿ�����   
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
        // ������������ݿ�ľ������   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
            pstmt1 = dbc.getConnection().prepareStatement(sql1) ; 
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt.setInt(1, ownerid);
          
            System.out.println(pstmt);
            // �������ݿ��ѯ����   
            ResultSet rs = pstmt.executeQuery();
            String[] towards={"","����","���� ","����","����"};
    		String[] renttypes={"","����","���� ","����������"};

            int num=0;
			while(rs.next()){   
				int starid = rs.getInt("favorite_id");
                // ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��person����   
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
    	         String chargestr="<div class=\"content\"><a class=\"header\">"+title+"</a><div class=\"meta\"><span class=\"price\" style=\"color:#00B5AD ;font-family:΢���ź� ; font-size:16px font-weight:bold\">"+charge+"</span>"
    	         +"<span class=\"stay\" style=\"color:#00B5AD ;font-family:΢���ź� ; font-size:13px;font-weight:bold\" >Ԫ/��</span></div>";
    	         String description=" <div class=\"description\"><p>"+add+"</p><p>�������ڣ�"+date+"</p><p>¥�㣺"+storey+"��</p></div>";
    	         String extra="<div class=\"extra\" style=\"font-family:΢���ź� ;\" ><div class=\"ui label\">"+to+"</div><div class=\"ui label\" >"+renttype+"</div>";
    	             	             	         
    	         String button=" <input type=\"submit\"   style=\"background-color:#00B5AD;width:70px;height:25px;font-family:΢���ź� ;color:white;"
     	        	+ "\" value=\"��ϸ��Ϣ\"id=\""+title+"\"  onclick=\"state(this.id)\" />" ;
    	         String button2=" <input type=\"submit\"   style=\"background-color:#00B5AD;width:70px;height:25px;font-family:΢���ź� ;color:white;"
      	        	+ "\" value=\"ȡ���ղ�\"id=\""+starid+"\"  onclick=\"state1(this.id)\" /></div></div></div></div>" ;
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
            // �ر����ݿ�����   
            dbc.close() ;   
        }   
        System.out.println("str"+str);
		return str;
		
	}

}
