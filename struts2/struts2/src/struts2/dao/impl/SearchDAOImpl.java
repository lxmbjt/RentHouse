package struts2.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import struts2.dao.SearchDAO;
import struts2.db.DBConnect;

public class SearchDAOImpl implements SearchDAO  {

	@Override
	public String Search(int province,String search,int pageNow) throws Exception{
		// TODO Auto-generated method stub
		
		//String sql = "select * from userinfo where username=?";
		String sql = "select * from house where province=? && housetitle like ?limit "+(pageNow*10-10)+","+10  ;
		
		System.out.println(province);
		System.out.println(search);
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
            pstmt.setInt(1, province);
            pstmt.setString(2,  '%'+search+'%');
            System.out.println(pstmt);
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
    	         String img="<div class=\"ui center aligned divided items\"  ><div class=\"item\"><div class=\"image\" style=\"width:220px; height:100px;\" ><img style=\"width:220px; height:160px;\" src=\""+pic+"\"></div>";
    	         String chargestr="<div class=\"content\"><a class=\"header\">"+title+"</a><div class=\"meta\"><span class=\"price\" style=\"color:#00B5AD ;font-family:΢���ź� ; font-size:16px font-weight:bold\">"+charge+"</span>"
    	         +"<span class=\"stay\" style=\"color:#00B5AD ;font-family:΢���ź� ; font-size:13px;font-weight:bold\" >Ԫ/��</span></div>";
    	         String description=" <div class=\"description\"><p>"+add+"</p><p>�������ڣ�"+date+"</p><p>¥�㣺"+storey+"��</p></div>";
    	         String extra="<div class=\"extra\" style=\"font-family:΢���ź� ;\" ><div class=\"ui label\">"+to+"</div><div class=\"ui label\" >"+renttype+"</div>";
    	         String button=" <input  type=\"submit\"   style=\"background-color:#00B5AD;width:70px;height:25px;font-family:΢���ź� ;color:white;border-top-right-radius:0.3em!important;"
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

	public String Pic(int house_id) throws Exception{
		// TODO Auto-generated method stub
		
		//String sql = "select * from userinfo where username=?";
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
	public String SearchByTag(int charg,String roomnum,String rent_type,String housetype,String toward,String chargetype,String province, String search) throws Exception{
		
        String sql = "select * from house where charge between ? and ? && room_number  like ? &&rent_type like ? && " +
        		"room_type like ? && towards like ? && charge_type like ?&&province=? && housetitle like ?";
		
		String[] towards={"","����","���� ","����","����"};
		String[] renttypes={"","����","���� ","����������"};
		int[][] chargepair={{0,50000},{0,500},{500,1000},{1000,1500},{1500,2000},{2000,3000},{3000,100000}};
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
        String str="";
        // ������������ݿ�ľ������   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt.setInt(1, chargepair[charg][0]);
            pstmt.setInt(2, chargepair[charg][1]);
            pstmt.setString(3,'%'+roomnum+'%');
            pstmt.setString(4,'%'+rent_type+'%');
            pstmt.setString(5,'%'+housetype+'%');
            pstmt.setString(6,'%'+toward+'%');
            pstmt.setString(7,'%'+chargetype+'%');
            pstmt.setInt(8, Integer.parseInt(province));
            pstmt.setString(9,  '%'+search+'%');
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
    	         String img="<div class=\"ui center aligned divided items\"  ><div class=\"item\"><div class=\"image\" style=\"width:230px; \"><img  src=\""+pic+"\"></div>";
    	         String chargestr="<div class=\"content\"><a class=\"header\">"+title+"</a><div class=\"meta\"><span class=\"price\" style=\"color:#00B5AD ;font-family:΢���ź� ; font-size:16px font-weight:bold\">"+charge+"</span>"
    	         +"<span class=\"stay\" style=\"color:#00B5AD ;font-family:΢���ź� ; font-size:13px;font-weight:bold\" >Ԫ/��</span></div>";
    	         String description=" <div class=\"description\"><p>"+add+"</p><p>�������ڣ�"+date+"</p><p>¥�㣺"+storey+"��</p></div>";
    	         String extra="<div class=\"extra\" style=\"font-family:΢���ź� ;\" ><div class=\"ui label\">"+to+"</div><div class=\"ui label\" >"+renttype+"</div>";
    	         String button=" <input type=\"submit\"   style=\"background-color:#00B5AD;width:70px;height:25px;font-family:΢���ź� ;color:white;border-top-right-radius:0.3em!important;"
    	        	+ "border-bottom-right-radius:0.3em!important;\" value=\"��ϸ��Ϣ\"id=\""+title+"\"  onclick=\"state(this.id)\" /></div></div></div></div>" ;
    	        	
    	         
    	         str+=img+chargestr+description+extra+button;
    	     
    	         
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
      
}
