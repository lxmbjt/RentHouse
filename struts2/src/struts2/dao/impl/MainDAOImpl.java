
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
		
		
		String[] towards={"","朝南","朝北 ","朝东","朝西"};
		String[] renttypes={"","整租","合租 ","整租合租均可"};
		String[] decorations={"","精装修","简装修 ","未装修"};
		String[] provinces={"","北京市","天津市","上海市","重庆市","河北省","山西省","辽宁省","吉林省","黑龙江省","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","海南省","四川省","贵州省","云南省","陕西省","甘肃省","青海省","内蒙古","广西","西藏","宁夏","新疆","香港","澳门","台湾"};
		String[] charge_types={"","押一付一" ,"押一付三 ","押一付二 ","押三付三 ","押三付六 ","年付"};
		PreparedStatement pstmt = null ;   
		String distitle="";
        DBConnect dbc = null;   
        String str="";
        // 下面是针对数据库的具体操作   
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            
            System.out.println(pstmt);
            System.out.println(pstmt);
            // 进行数据库查询操作   
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){   
                // 查询出内容，之后将查询出的内容赋值给person对象   
            	 int id = rs.getInt("house_id");//id
    	         String title = rs.getString("housetitle");//title
    	         if(title.length()>18){
        	        distitle = title.substring(0,18)+"...";
        	         }  else{
        	        	 distitle=title;
        	         }
    	         String area=rs.getInt("area")+" 平方米";
    	         String storey=rs.getInt("storey")+" 层";
    	         
    	         String city=rs.getString("city");
    	         int charge=rs.getInt("charge");
    	         String to=towards[rs.getInt("towards")];
    	         String renttype=renttypes[rs.getInt("rent_type")];
    	         String decoration=decorations[rs.getInt("decoration")];
    	         String province=provinces[rs.getInt("province")];
    	         String room_number=rs.getInt("room_number")+" 室";  
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
				" <li><i class=\"lnr lnr-tag\"></i>城市："+province+city+"</li>"+
				" <li><i class=\"lnr lnr-tag\"></i>楼层："+storey+"</li>"+
				" <li><i class=\"lnr lnr-tag\"></i>房间："+room_number+"</li>"+
				" <li><i class=\"lnr lnr-tag\"></i>朝向："+to+"</li>"+"<li></li>"+
				" <li><i class=\"lnr lnr-tag\"></i>付款："+charge_type+"</li>"+"</ul>";
				 String button="<a  class=\"contact\" id=\""+title+"\" onclick=\"state(this.id)\" style=\"margin-right:20px ;font-weight:bold\">详细信息<i class=\"lnr lnr-arrow-right\"></i></a>";
    	       String money=	"<h3 >&yen;"+charge+"</h3></div></div></div>";
    	         str=str+head+picstr+content+ info+button+money;
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
		// TODO Auto-generated method stub
		
		//String sql = "select * from userinfo where username=?";
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
	
}
