
package struts2.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import struts2.dao.MainDAO;
import struts2.dao.SearchDAO;
import struts2.db.DBConnect;

public class MainDAOImpl implements MainDAO  {

	@Override
	public String show9() throws Exception{
		// TODO Auto-generated method stub
		
		//String sql = "select * from userinfo where username=?";
		String sql = "select * from house where status=0 limit 9" ;
		
		
		String[] towards={"","����","���� ","����","����"};
		String[] renttypes={"","����","���� ","����������"};
		String[] decorations={"","��װ��","��װ�� ","δװ��"};
		String[] provinces={"","������","�����","�Ϻ���","������","�ӱ�ʡ","ɽ��ʡ","����ʡ","����ʡ","������ʡ","����ʡ","�㽭ʡ","����ʡ","����ʡ","����ʡ","ɽ��ʡ","����ʡ","����ʡ","����ʡ","�㶫ʡ","����ʡ","�Ĵ�ʡ","����ʡ","����ʡ","����ʡ","����ʡ","�ຣʡ","���ɹ�","����","����","����","�½�","���","����","̨��"};
		String[] charge_types={"","Ѻһ��һ" ,"Ѻһ���� ","Ѻһ���� ","Ѻ������ ","Ѻ������ ","�긶"};
		PreparedStatement pstmt = null ;   
		String distitle="";
        DBConnect dbc = null;   
        String str="";
        // ������������ݿ�ľ������   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            
            System.out.println(pstmt);
            System.out.println(pstmt);
            // �������ݿ��ѯ����   
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){   
                // ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��person����   
            	 int id = rs.getInt("house_id");//id
    	         String title = rs.getString("housetitle");//title
    	         if(title.length()>18){
        	        distitle = title.substring(0,18)+"...";
        	         }  else{
        	        	 distitle=title;
        	         }
    	         String area=rs.getInt("area")+" ƽ����";
    	         String storey=rs.getInt("storey")+" ��";
    	         
    	         String city=rs.getString("city");
    	         int charge=rs.getInt("charge");
    	         String to=towards[rs.getInt("towards")];
    	         String renttype=renttypes[rs.getInt("rent_type")];
    	         String decoration=decorations[rs.getInt("decoration")];
    	         String province=provinces[rs.getInt("province")];
    	         String room_number=rs.getInt("room_number")+" ��";  
    	         String charge_type= charge_types[rs.getInt("charge_type")];
    	         String pic=Pic(id);
    	         System.out.println(pic);
    	         String head="<div class=\"item\"><div class=\"ready_flat\">";
				 String picstr="<img src=\""+pic+"\" style=\"height:250px\">";
				 String content="<div class=\"content-area\"><h4>"+distitle+"</h4>"
				 +"<a   class=\"btn-flat activ left\" style=\"margin-right:10px;font-weight:bold\">"+renttype+"</a>"
				 +"<a    class=\"btn-flat activ\" style=\"margin-right:10px;font-weight:bold\">"+area+"</a>"
				 +"<a  class=\"btn-flat activ\" style=\"font-weight:bold\">"+decoration+"</a>"; 
				 String info="<ul class=\"info\">"+
				" <li><i class=\"lnr lnr-tag\"></i>���У�"+province+city+"</li>"+
				" <li><i class=\"lnr lnr-tag\"></i>¥�㣺"+storey+"</li>"+
				" <li><i class=\"lnr lnr-tag\"></i>���䣺"+room_number+"</li>"+
				" <li><i class=\"lnr lnr-tag\"></i>����"+to+"</li>"+"<li></li>"+
				" <li><i class=\"lnr lnr-tag\"></i>���"+charge_type+"</li>"+"</ul>";
				 String button="<a  class=\"contact\" id=\""+title+"\" onclick=\"state(this.id)\" style=\"margin-right:20px ;font-weight:bold\">��ϸ��Ϣ<i class=\"lnr lnr-arrow-right\"></i></a>";
    	       String money=	"<h3 >&yen;"+charge+"</h3></div></div></div>";
    	         str=str+head+picstr+content+ info+button+money;
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
	
}
