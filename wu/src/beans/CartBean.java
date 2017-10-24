package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class CartBean {
public ArrayList<Product> getProducts(){
	ArrayList<Product> list=new ArrayList<Product>();
	Connection conn=Conn.getConn();
	String sql="select * from product";
	PreparedStatement pst;
	try {
		pst = conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			Product p=new Product();
			p.setId(rs.getInt("id"));
			p.setType(rs.getString("type"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getFloat("price"));
			p.setQuantity(rs.getInt("quantity"));
			list.add(p);
		}
		rs.close();
		pst.close();
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}


public Vector<CartProduct> addCart(Vector<CartProduct> cart,String id){
	//如果id所标识的商品已经在购物车中，则只需要将数量加1，如果不在，则将商品信息添加进去
	     boolean f=true;//商品是否存在
	     for(int i=0;i<cart.size();i++){
	         CartProduct cp=cart.get(i);
	         if(cp.getId().equals(id)){//商品存在
	            cp.setNumber(cp.getNumber()+1);
	            cart.set(i, cp);
	            f=false;
	            break;
	         }
	     }
	      if(f){//商品不存在
	           Connection conn=Conn.getConn();  
	           String sql="select * from product where id=?";
	           try {   
	               PreparedStatement ps = conn.prepareStatement(sql);
	                 ps.setString(1,id);
	                 ResultSet rs=ps.executeQuery();
	                 if(rs.next()){
	                      CartProduct cp=new CartProduct();  
	                      cp.setId(id);
	                      cp.setNumber(1);//购买数量设置为1
	                      cp.setPrice(rs.getFloat("price"));
	                      cp.setName(rs.getString("name"));
	                      cart.add(cp);
	                  }
	                  conn.close();
	              } catch (SQLException e) {e.printStackTrace();
	         }
	    }
	    return cart;
	}

	     
	     
	     
public Vector<CartProduct> delCart(Vector<CartProduct> cart,String id){
	 for(int i=0;i<cart.size();i++){
         if(cart.get(i).getId().equals(id)){
                 cart.remove(i);
                 break;
          }
   }
	return cart;
	
}
public Vector<CartProduct> modifyCart(Vector<CartProduct> cart,String id,int number){
	for(int i=0;i<cart.size();i++){
		CartProduct cp=cart.get(i);
		if(cp.getId().equals(id)){
			cp.setNumber(number);
			cart.set(i, cp);
			break;
		}
	}

	return cart;
	
}
}
