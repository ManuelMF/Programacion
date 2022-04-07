package a14ListaBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Producto {
	
	private int id;
	private String producto;
	private int cantidad;
	
	private Producto (int i, String p, int c) {
		this.id=i;
		this.producto=p;
		this.cantidad=c;
	}
	
	
	public int update(){
		PreparedStatement stm;
		
		String update="Update lista set producto=?, cantidad=? where id=?";
		
		Conexion.open();
		
		try {
			stm=Conexion.con.prepareStatement(update);
			stm.setString(1, this.producto);
			stm.setInt(2, this.cantidad);
			stm.setInt(3, this.id);
			
			stm.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
		return 0;
		
	}
	
	public int delete() {
		PreparedStatement stm;
		ResultSet res;
		
		String delete="delete from lista where id=?";
		Conexion.open();
		
		try {
			stm=Conexion.con.prepareStatement(delete);
			stm.setInt(1, this.getId());
			
			stm.executeUpdate();

		} catch (SQLException e) {
			return -1;
		}
		return 0;
	}
	
	public static LinkedList<Producto> find (String p, Integer c){
		
		LinkedList<Producto> lista=new LinkedList<Producto>();
		
		PreparedStatement stm;
		ResultSet res;
		
		String consulta="Select * from lista where 1=1 ";
		if (p!=null) consulta+=" and producto like ? ";
		if (c!=null) consulta+=" and cantidad = ? ";
		
		Conexion.open();
		try {
			stm=Conexion.con.prepareStatement(consulta);
			int x=1;
			if (p!=null) stm.setString(x++, p);
			if (c!=null) stm.setInt(x++, c);
			
			res=stm.executeQuery();
			
			while (res.next()) {
				lista.add(new Producto( res.getInt("id"), 
										res.getString("producto"), 
										res.getInt("cantidad")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	public static Producto create(String p, int c) {
		
		Conexion.open();
		
		PreparedStatement stm;
		ResultSet res;
		
		String insert="insert into lista (producto, cantidad) values (?,?)";
		
		
		try {
			stm=Conexion.con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, p);
			stm.setInt(2, c);
			
			stm.executeUpdate();
			
			res=stm.getGeneratedKeys();
			res.next();
			
			Producto pr=new Producto(res.getInt(1), p, c);
			
			return pr;
			
			
		} catch (SQLException e) {
			System.out.println("Error insertando Producto!!");
		}
		
		return null;
		
	}

	public int getId() {
		return id;
	}

	public String getProducto() {
		return producto;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int c) {
		this.cantidad=c;
	}

}