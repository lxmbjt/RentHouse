package struts2.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import struts2.dao.OrderDAO;
import struts2.db.DBConnect;

public class OrderDAOImpl implements OrderDAO  {


	@Override
	public void CancelOrder(int orderid) throws Exception {
		String sql = "delete from reservation where reverse_id=?";
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt.setInt(1, orderid) ;  
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

	@Override
	public void SetOrder(int type, int orderid) throws Exception {
		String sql = "UPDATE reservation SET isagree = ? WHERE reverse_id = ?";
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
           // pstmt.setString(1,user.getUsername()) ;  
            pstmt.setInt(1, type) ;  
            pstmt.setInt(2, orderid) ; 
            System.out.println(pstmt);
            // �������ݿ��ѯ����   
            pstmt.executeUpdate();
            pstmt.close() ;  
            System.out.println("change already");   
            
            
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
