package beans;
import java.sql.*;
public class UserDao {
	public boolean check_login (UserBean user){
	     boolean flag=false;
	     Connection conn=null;
	     try {
	          conn=Conn.getConn();//注意获取连接的方式
	         String sql="select * from user where name=? and pass=?";	    
	          PreparedStatement pst=conn.prepareStatement(sql); 
	          pst.setString(1, user.getName());
	          pst.setString(2,user.getPass());
	          ResultSet rs=pst.executeQuery();
	          if(rs.next()){
	               flag=true;
	          }
	          if(conn!=null) conn.close();
	     } catch (SQLException e) {
	          e.printStackTrace();
	     }	     
	     return flag;
	}//本方法进行用户名验证
	public boolean checkUser (UserBean user){
	     boolean flag=false;
	     Connection conn=null;
	     try {
	          conn=Conn.getConn();//注意获取连接的方式
	          if(conn!=null)
	        	  System.out.println("connected!");
	         String sql="select * from user where name=?";
	          PreparedStatement pst=conn.prepareStatement(sql);
	          pst.setString(1,user.getName());
	          ResultSet rs=pst.executeQuery();
	          if(rs.next()){
	               flag=true;
	          }
	          if(conn!=null) conn.close();
	     } catch (SQLException e) {
	          e.printStackTrace();
	     }	     
	     return flag;
	}
//本方法用于进行用户信息的添加
public int regUser(UserBean user){
	 Connection conn=null;
    int flag=0;
    try {
       conn=Conn.getConn();	        
       String sql="insert into user(name,pass,email,tel,address)  values(?,?,?,?,?)";
              PreparedStatement ps=conn.prepareStatement(sql);
              ps.setString(1,user.getName());
              ps.setString(2,user.getPass());	              
              ps.setString(3,user.getEmail());
              ps.setString(4,user.getTel());
              ps.setString(5,user.getAddress());
              flag=ps.executeUpdate();  
              if(conn!=null) conn.close();
         } catch (SQLException e) {
       	  e.printStackTrace();
         }	     
    return flag;
}
	
}
