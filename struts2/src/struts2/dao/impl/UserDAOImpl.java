package struts2.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import struts2.dao.UserDAO;
import struts2.db.DBConnect;
import struts2.vo.User;

public class UserDAOImpl implements UserDAO  {

	@Override
	public User Login(User user) throws Exception {
		// TODO Auto-generated method stub
		
		//String sql = "select * from userinfo where username=?";
		String sql = "select * from user where phone=?";
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
        User u=new User();//��¼��user
        // ������������ݿ�ľ������   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt.setString(1,user.getPhone()) ;  
            System.out.println(pstmt);
            // �������ݿ��ѯ����   
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){   
                // ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��person����   
                if(rs.getString("password").equals(user.getPassword())){
                	//System.out.println(rs.getObject(1));
                	u.setE_mail(rs.getString("e_mail"));
                	System.out.println(rs);
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
	@Override
	public int Register(User user) throws Exception {
		// TODO Auto-generated method stub
		
		
		String sql = "INSERT INTO user (user_nickname,phone,password)VALUES(?,?,?);";
		
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
       // User u=new User();//��¼��user
        // ������������ݿ�ľ������   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
          //  pstmt.setString(1,user.getPhone()) ;  
            //System.out.println(pstmt);
            // �������ݿ��ѯ����   
           // ResultSet rs = pstmt.executeQuery();
            if(user.getPassword().equals(user.getRepassword())){   
                // ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��person����   
                if
        		(user.getPassword().isEmpty()||user.getUser_nickname().isEmpty()||user.getPhone().isEmpty()){
                	
                	return 4;
                }
                
                System.out.println(user.getPassword());
                System.out.println(user.getPhone());
            	pstmt.setString(1,user.getUser_nickname());
            	pstmt.setString(2,user.getPhone());
            	pstmt.setString(3,user.getPassword());
            	
            try{
            	System.out.println(pstmt);
            	pstmt.executeUpdate();
            }
            catch (SQLException e) {
            	System.out.println(e.getErrorCode());
            	  if (e.getErrorCode() == 1062 ){
            		  
            		  return 2;//�绰�ظ�
            		  
            	  }else{
            		  System.out.println(e.getMessage());
            		  
            		  return 4;
            	  }
            }
            }   
            else{return 3;}
           // rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // �ر����ݿ�����   
            dbc.close() ;   
        }   
		return 1;
	}
	
	
}
