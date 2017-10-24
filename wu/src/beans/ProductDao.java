package beans;

import java.util.ArrayList;
import java.sql.*;

public class ProductDao {
	//获取商品信息列表
	public ArrayList<Product> getProducts() {
		ArrayList<Product> list=new ArrayList<Product>();
		Connection conn=Conn.getConn();
		String sql="select * from product";
		try {
		 	PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Product p=new Product();
				p.setId(rs.getInt("id"));
				p.setType(rs.getString("type"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getFloat("price"));
				p.setQuantity(rs.getInt("quantity"));
				p.setImg(rs.getString("img"));
				p.setDesc(rs.getString("description"));
				list.add(p);
			}
			
			rs.close();pst.close();conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
	}
	//根据商品名称进行查询

	public ArrayList<Product> searchProducts(String name) {
		ArrayList<Product> list=new ArrayList<Product>();
		Connection conn=Conn.getConn();
		String sql="select * from product where name like ?";
		try {
			
			PreparedStatement  pst=conn.prepareStatement(sql);
			pst.setString(1, "%" +name+ "%");
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Product p=new Product();
				p.setId(rs.getInt("id"));
				p.setType(rs.getString("type"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getFloat("price"));
				p.setQuantity(rs.getInt("quantity"));
				p.setImg(rs.getString("img"));
				p.setDesc(rs.getString("description"));
				list.add(p);
				
			}
			rs.close();pst.close();conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;

	
	}
	
	public Product getProduct(String id){
		Connection conn= Conn.getConn();
		Product p=new Product();
		String sql="select * from product where id=?";
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1,Integer.parseInt(id));
			ResultSet rs=pst.executeQuery();
			if(rs.next()){			
				p.setId(rs.getInt("id"));
				p.setType(rs.getString("type"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getFloat("price"));
				p.setQuantity(rs.getInt("quantity"));
				p.setDesc(rs.getString("description"));
				p.setImg(rs.getString("img"));
				
			}
			rs.close();pst.close();conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
		
	}
	
	
	
	
	public int addProduct(Product product){
		Connection conn=Conn.getConn();
		int flag=0;
		String sql="insert into product (name,type,price,quantity,img,description) values(?,?,?,?,?,?)";
		try {
			PreparedStatement  pst=conn.prepareStatement(sql);
			pst.setString(1, product.getName());
			pst.setString(2, product.getType());
			pst.setFloat(3, product.getPrice());
			pst.setInt(4, product.getQuantity());
			pst.setString(5, product.getImg());
			pst.setString(6,product.getDesc());
			flag=pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
		
	}
	
	public int editProduct(Product product){
		Connection conn=null;
		int flag=0;
		try{
	conn=(Connection) Conn.getConn();
	String sql="update product set name=?,type=?,price=?,quantity=?,img=?,description=? where id=?";
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
		ps.setString(1,product.getName());
		ps.setString(2,product.getType());
		ps.setFloat(3,product.getPrice());
		ps.setInt(4,product.getQuantity());
		ps.setString(5,product.getImg());
		ps.setString(6,product.getDesc());
		ps.setInt(7,product.getId());
		flag=ps.executeUpdate();
		if(conn!=null) conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	return flag;
	}
	
	
	
	public int deleteProduct(Product product){
		Connection conn=null;
		int flag=0;
		try {
			conn=Conn.getConn();
			String sql="delete from product where name=?";		
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1,product.getName());			
				flag=ps.executeUpdate();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
	}

	
	
}
