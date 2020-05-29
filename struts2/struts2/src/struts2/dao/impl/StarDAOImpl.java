package struts2.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import struts2.dao.StarDAO;
import struts2.db.DBConnect;

public class StarDAOImpl implements StarDAO  {


	
	@Override
	public void Deletestar(int starid) throws Exception {
		String sql = "delete from favorite where favorite_id=?";
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt.setInt(1, starid) ;  
            System.out.println(pstmt);
            // �������ݿ��ѯ����   
            pstmt.executeUpdate();
            pstmt.close() ;  
            System.out.println("delete already");   
            } 
       
          
           
         catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // �ر����ݿ�����   
            dbc.close() ;   
        }   
		return ;
		
	}
	
	
}
