package struts2.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modify.db.MyHibernateSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;


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
        User u=new User();//登录的user
        // 下面是针对数据库的具体操作   
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt.setString(1,user.getPhone()) ;  
            System.out.println(pstmt);
            // 进行数据库查询操作   
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){   
                // 查询出内容，之后将查询出的内容赋值给person对象   
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
                	
                	
                	return u;//返回用户i
                } 
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
	@Override
	public int Register(User user) throws Exception {
		// TODO Auto-generated method stub
		
		
		String sql = "INSERT INTO user (user_nickname,phone,password)VALUES(?,?,?);";
		
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
       // User u=new User();//登录的user
        // 下面是针对数据库的具体操作   
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
          //  pstmt.setString(1,user.getPhone()) ;  
            //System.out.println(pstmt);
            // 进行数据库查询操作   
           // ResultSet rs = pstmt.executeQuery();
            if(user.getPassword().equals(user.getRepassword())){   
                // 查询出内容，之后将查询出的内容赋值给person对象   
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
            		  
            		  return 2;//电话重复
            		  
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
            // 关闭数据库连接   
            dbc.close() ;   
        }   
		return 4;
	}
	//根据用户id查询用户资料
	public User queryUserByUid(int userId) {
	
		Transaction tx = null;
		User u = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			u = (User)session.get(User.class, userId);
			
			tx.commit();
			return u;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			tx.commit();
			return u;
		}
		finally {
			if(tx != null) {
				tx = null;
			}
		}
	}

	//修改用户资料
	public boolean updateUser(User u) {
		
		Transaction tx = null;
		System.out.println("update");
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(u);
			tx.commit();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			tx.commit();
			return false;
		}
		finally {
			if(tx != null) {
				tx = null;
			}
		}
	}
	
}
