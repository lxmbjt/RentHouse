package struts2.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import struts2.dao.FavoriteDAO;
import struts2.db.DBConnect;

public class FavoriteDAOImpl implements FavoriteDAO {


	@SuppressWarnings("resource")
	@Override
	public int addFavorite(int house_id,int user_id) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null ;   
	    DBConnect dbc = null;   
	    int result=0;
	    String sql1="select * from favorite where f_user_id=? and f_house_id=?;";
	    try{
	    	dbc=new DBConnect();
			//Ԥ����sql���
			pstmt=dbc.getConnection().prepareStatement(sql1);
			pstmt.setInt(1, user_id);
			pstmt.setInt(2, house_id);
			ResultSet rs_query=pstmt.executeQuery();
			if(rs_query.next()){
				//���ݿ����м�¼��˵�����ղأ���ʱ��������¼�����ݿ���ɾ��
				String sql3="delete from favorite where f_user_id=? and f_house_id=?;";
				pstmt=dbc.getConnection().prepareStatement(sql3);
				pstmt.setInt(1, user_id);
				pstmt.setInt(2, house_id);
				int rs_delete=pstmt.executeUpdate();
				if(rs_delete!=0){
					//System.out.println("ɾ���ɹ�1");
					result=0;
					return result;//ɾ���ɹ�
				}
			}else{
				//���ݿ����޸����¼������ü�¼
				String sql2="insert into favorite (f_user_id,f_house_id) VALUES (?,?);";
				pstmt=dbc.getConnection().prepareStatement(sql2);
				pstmt.setInt(1, user_id);
				pstmt.setInt(2, house_id);
				int rs_insert=pstmt.executeUpdate();
				
				if(rs_insert!=0){
					//System.out.println("��ӳɹ�2");
					result=1;
					return result;//��ӳɹ�
				}
			}
			rs_query.close();
			
	         pstmt.close() ;   
	    }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // �ر����ݿ�����   
            dbc.close() ;   
        }   
	    System.out.println("����ʧ��0");
	    result=-1;
		return result;//����ʧ��
	}

	@Override
	public int ifInFavorite(int house_id, int user_id) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null ;   
	    DBConnect dbc = null;   
	    int result=0;
	    String sql1="select * from favorite where f_user_id=? and f_house_id=?;";
	    try{
	    	dbc=new DBConnect();
			//Ԥ����sql���
			pstmt=dbc.getConnection().prepareStatement(sql1);
			pstmt.setInt(1, user_id);
			pstmt.setInt(2, house_id);
			ResultSet rs_query=pstmt.executeQuery();
			if(rs_query.next()){
				result=1;
				return result;//���ݿ��и�����¼
			}
			}catch (SQLException e){   
	            System.out.println(e.getMessage());   
	        }finally{   
	            // �ر����ݿ�����   
	            dbc.close() ;   
	        }   
		return 0;
	}
	
	

}
