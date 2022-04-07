package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.sun.net.httpserver.Authenticator.Result;

public class main {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		base de datos a la que entraremos
		String bd="sakila";
		
//		usuario
		String login="root";
		
//		contra
		String pass="";
		
//		donde esta la base de datos ip
		String host="localhost";
		
		String url="";
		

		Connection con=null;
		
//		construimos la direccion donde nos conectamos 
		try {
//			conectarnos: 
//			primero generamos la url que se va a concetar     
			url="jdbc:mysql://"+host+"/"+bd+"?useSSL=false";
//			 							    que no use una conecsion segura
//			mira que este exista 
			Class.forName("org.mariadb.jdbc.Driver");
			
//			conectarse con la clase drivermanagar user  pass
			con=DriverManager.getConnection(url, login, pass);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		/*
//		HACER CONSULTA      
 
// 		hay que importar la sql 
		PreparedStatement stm;
		
//		objeto que recoja los resultados
		ResultSet res;
		
//		consulta
		// asi para pillar todo que se le dira que cojer luego
		String consulta="Select * from film order by title desc limit 10";
		// String consulta="Select title, length duracion from film"; habria que ponerlo abajo tmbn
		
		try {       //metodo para enviar consulta
			stm=con.prepareStatement(consulta);
			
//			ejecutar consulta y la guarda en res
			res=stm.executeQuery();
			
//			mientras haya un next seguira 
			while (res.next()) {               // muestras solo el titulo puedes ponerlo en el select
				System.out.println(res.getString("title")+" - "+(res.getInt("length")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		/*
//		MODIFICAR DATOS
		PreparedStatement stm;
//								   siempres se pondra la palabra set
		String update="Update film set title='ZORRO BLANCO' where film_id=1000";
		try {       
			stm=con.prepareStatement(update);
			
//			ejecutar el update y la guarda  no tengo que guardar ningun dato
			stm.executeUpdate();
			
			System.out.println("Datos actualizados");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		*/
		
//		asi te hackean
		/*System.out.println("NOMBRE DE LA NUEVA PELÍCULA");
		String titulo=sc.nextLine();
		PreparedStatement stm;
		String update="Update film set title='"+titulo+"' where film_id=1000";
		try {       
			stm=con.prepareStatement(update);
			stm.executeUpdate();
			System.out.println("Datos actualizados");
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		/*//hacer asi
		System.out.println("NOMBRE DE LA NUEVA PELÍCULA");
		String titulo=sc.nextLine();
		System.out.println("Film_id de la pelicula a modificar:");
		int fid=Integer.parseInt(sc.nextLine());
		PreparedStatement stm;
		String update="Update film set title=? where film_id=?";
		try {       
			stm=con.prepareStatement(update);
//			lo pondra el primer interrogante
			stm.setString(1, titulo);
			stm.setInt(2, fid);
//			asi se ejecutara solo el titulo
			stm.executeUpdate();
			
			System.out.println("Datos actualizados");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
//		METER DATOS NUEVOS
		/*
		System.out.println("Nueva categoría:");
		String cat=sc.nextLine();
		
		PreparedStatement stm;
//		cuando hago un insert recogere la PK
		ResultSet res;
		
		String insert="insert into category (name) values (?)";
		
		try {                      //        hacer que me devuelva la PK
			stm=con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			
			stm.setString(1, cat);
	
			stm.executeUpdate();
//			recojer id
			res=stm.getGeneratedKeys();
			
//			me pongo en la primera fila
			res.next();
			
//																recoje la PK obtenida
			System.out.println("Categoría insetada con el ID: "+res.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
//		ELIMINAR
//		id
		/*
		System.out.println("Id de la categoría a eliminar");
		int idc=Integer.parseInt(sc.nextLine());
		
		PreparedStatement stm;
		ResultSet res;
		
		String delete="delete from category where category_id=?";
		
		try {                      //        hacer que me devuelva la PK
			stm=con.prepareStatement(delete);
			
			stm.setInt(1, idc);
	
			stm.executeUpdate();
			
			System.out.println("Categoría eliminada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		/*
		System.out.println("Nombre de la categoría a eliminar");
		String nom=sc.nextLine();
		
		PreparedStatement stm;
		ResultSet res;
		
		String delete="delete from category where name=?";
		
		try {                     
			stm=con.prepareStatement(delete);
			
			stm.setString(1, nom);
	
			stm.executeUpdate();
			
			System.out.println("Categoría eliminada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
	}
}/*
lista que tiene que tener un id un producto y una cantidad 
tiene que poder ver los productos poder aladir productios modificar la cantidad consultar
*/