package struts2.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {  
	    private final String DBDRIVER = "com.mysql.jdbc.Driver" ;   
	   // private final String DBURL = "jdbc:mysql://localhost:3306/mystruts2db" ;   
	    private final String DBURL = "jdbc:mysql://localhost:3306/rent" ;   
	    private final String DBUSER = "root" ;   
	    private final String DBPASSWORD = "tby314159" ;   
	    private Connection conn = null ;   
	  
	    public DBConnect()   {   
	        try{   
	            Class.forName(DBDRIVER) ;   
	            System.out.println("成功加载MySQL驱动程序");
	            this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;  
	        }catch (Exception e){ 
	        	System.out.println("没连上 烦死了");
	        	System.out.println(e.getMessage());  
	        	}   
	    }   
	  
	    // 取得数据库连接   
	    public Connection getConnection(){   
	        return this.conn ;   
	    }   
	  
	    // 关闭数据库连接   
	    public void close(){   
	        try{   
	            this.conn.close() ;   
	        }catch (Exception e){ }          
	    }   
}  
