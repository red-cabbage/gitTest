package beans;
import java.sql.*;
import java.util.ResourceBundle;
public class Conn {
	public static Connection getConn(){
        Connection conn=null;
         try {
ResourceBundle rb=ResourceBundle.getBundle("beans.conndata");//读取资源配置文件
String driver=rb.getString("driver");
String url=rb.getString("url");
String user=rb.getString("user");
String pass=rb.getString("pass");
Class.forName(driver);			
conn=DriverManager.getConnection(url,user,pass);
if(conn!=null)
	System.out.println("Conn连接成功！");
else
	System.out.println("Conn连接失败！");
} catch (Exception e) {
e.printStackTrace();			
}		
return conn;         
}
public static void main(String args[]){
	getConn();
}
}
