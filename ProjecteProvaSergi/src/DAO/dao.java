package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import POJO.Acceso;
//import POJO.EstadoParking;
//import POJO.PermisoAcceso;
//import POJO.Plaza;
//import POJO.PuertaAcceso;
//import POJO.TipoAcceso;
//import utils.DataUtils;

public class dao {
	
	public static void initDao() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver") ; 
	}
	
//	public static List<Plaza> getListaPlazas() throws SQLException {
//		ResultSet rs = query("SELECT * FROM plaza"); //
//		List<Plaza> plazas = new ArrayList<>();
//		while(rs.next()) {
//			Plaza plaza = parsePlazaFromResultSet(rs);
//			plazas.add(plaza);
//	    }
//		st.close(); // hay que hacer el s.t close despues del resutset. get data
//		conn.close();
//		return plazas;
//	}
//	
//	public static EstadoParking getUltimoEstadoParking() throws SQLException {
//		ResultSet rs = query("SELECT * FROM estadoparking WHERE segundo = (SELECT MAX(segundo) FROM estadoparking)"); //
//		EstadoParking listaAccesos = null;
//		if(rs==null)
//			return null;
//		if(rs.next()) {
//	        listaAccesos = parseEstadoParkingFromResultSet(rs);
//	      }
//		st.close(); // hay que hacer el s.t close despues del resutset. get data
//		conn.close();
//		return listaAccesos;
//	}
//	
//	public static List<Acceso> getUltimos5AccesosListPorPuerta(PuertaAcceso puerta) throws SQLException {
//		int puertaInt = mapPuertaToDBInteger(puerta);
//		ResultSet rs = query("SELECT * FROM acceso WHERE puerta = "+puertaInt+" ORDER BY hora DESC"); //
//		List<Acceso> listaAccesos = new ArrayList<>();
////		if(rs==null)
////			return listaAccesos;
//		int tope = 5;
//		int itope = 0;
//		while (rs.next() && itope < tope) {
//	        listaAccesos.add(getAccesoFromResultSet(rs));
//	        itope++;
//	      }
//		st.close(); // hay que hacer el s.t close despues del resutset. get data
//		conn.close();
//		return listaAccesos;
//	}
//	
//	public static int mapPuertaToDBInteger(PuertaAcceso puerta) {
//		int index = 0;
//		PuertaAcceso[] values = PuertaAcceso.values();
//		for(PuertaAcceso PA : values) {
//			if(PA.equals(puerta))
//				return index;
//			else index++;
//		}
//		return -1;
//	}
//	
//	public static List<Acceso> getUltimos3AccesosList() throws SQLException {
//		ResultSet rs = query("SELECT * FROM acceso ORDER BY hora DESC"); //
//		List<Acceso> listaAccesos = new ArrayList<>();
//		if(rs==null)
//			return listaAccesos;
//		int tope = 3;
//		int itope = 0;
//		while (rs.next() && itope < tope) {
//	        listaAccesos.add(getAccesoFromResultSet(rs));
//	        itope++;
//	      }
//		st.close(); // hay que hacer el s.t close despues del resutset. get data
//		conn.close();
//		return listaAccesos;
//	}
//	
//	public static Acceso getUltimoAcceso() throws SQLException {
//		ResultSet rs = query("SELECT * FROM acceso WHERE hora = (SELECT MAX(hora) FROM acceso)"); //
//		Acceso acceso = null;
//		if(rs==null)
//			return null;
//		if (rs.next()) {
//			acceso = getAccesoFromResultSet(rs);
//	    }
//		st.close(); // hay que hacer el s.t close despues del resutset. get data
//	    conn.close();
//		return acceso;
//	}
//	
//	public static List<Acceso> getTodosAccesos() throws SQLException {
//		ResultSet rs = query("Select * from Acceso ORDER BY hora DESC");
//		List<Acceso> listaAccesos = new ArrayList<>();
//		if(rs==null)
//			return listaAccesos;
//		while (rs.next()) {
//	        listaAccesos.add(getAccesoFromResultSet(rs));
//	      }
//		st.close(); // hay que hacer el s.t close despues del resutset. get data
//		conn.close();
//		return listaAccesos;
//	}
//	
//	public static Plaza parsePlazaFromResultSet(ResultSet rs) throws SQLException {
//
//        int plazaid = rs.getInt("idplaza");
//        int estado = rs.getInt("estadoplaza");
//        
//        return new Plaza(plazaid, estado);
//	}
//	
//	public static EstadoParking parseEstadoParkingFromResultSet(ResultSet rs) throws SQLException {
//
//        int puertas = rs.getInt("estadoPuertas");
//        java.util.Date dateHora = new java.util.Date( rs.getTimestamp("segundo").getTime() );
//        int barreras = rs.getInt("estadoBarreras");
//        int fotos = rs.getInt("estadoFotoCelulas");
//        
//        EstadoParking estado = new EstadoParking(puertas, barreras, fotos, dateHora);
//        return estado;
//	}
//	
//	public static Acceso getAccesoFromResultSet(ResultSet rs) throws SQLException {
////		int id = rs.getInt("id");
//        int codigoLlave = rs.getInt("codigoLlave");
//        java.util.Date dateHora = new java.util.Date( rs.getTimestamp("hora").getTime() );
//        int puerta = rs.getInt("puerta");
//        int tipo = rs.getInt("tipo");
//        int permiso = rs.getInt("permiso");
//        
//        PuertaAcceso puertaAcceso = PuertaAcceso.values()[puerta];
//        TipoAcceso tipoAcceso = TipoAcceso.values()[tipo];
//        PermisoAcceso permisoAcceso = PermisoAcceso.values()[permiso];
////        java.util.Date dateHora = new java.util.Date(date.getTime());
//        Acceso acceso = new Acceso(codigoLlave, dateHora, puertaAcceso, tipoAcceso, permisoAcceso);
//        return acceso;
//	}
//	
//	public static ResultSet query(String query) throws SQLException {
//		try {
//	      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/localdb", "root", "") ;
//	      st = conn.createStatement();
//	      ResultSet rs = st.executeQuery(query);
//	      
//	      return rs;
//	    }
//		catch (Exception e) {
//	      System.err.println("Got an exception! ");
//	      System.err.println(e.getMessage());
//	      e.printStackTrace();
//	      throw e;
//	    }
//	}
//
////	public static void sampleDB() {
////		try
////	    {
//////	      Class.forName(myDriver);
//////	      Connection conn = DriverManager.getConnection(myURL, "root", "");
////	      
////	      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/localdb", "root", "") ;
////	      
////	      // our SQL SELECT query. 
////	      // if you only need a few columns, specify them by name instead of using "*"
////	      String query = "SELECT * FROM Acceso";
////
////	      // create the java statement
////	      Statement st = conn.createStatement();
////	      
////	      // execute the query, and get a java resultset
////	      ResultSet rs = st.executeQuery(query);
////	      
//////	      // iterate through the java resultset
//////	      while (rs.next())
//////	      {
//////	        int id = rs.getInt("id");
//////	        String firstName = rs.getString("first_name");
//////	        String lastName = rs.getString("last_name");
//////	        Date dateCreated = rs.getDate("date_created");
//////	        boolean isAdmin = rs.getBoolean("is_admin");
//////	        int numPoints = rs.getInt("num_points");
//////	        
//////	        // print the results
//////	        System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
//////	      }
////	      st.close();
////	    }
////	    catch (Exception e)
////	    {
////	      System.err.println("Got an exception! ");
////	      System.err.println(e.getMessage());
//////	      System.err.println(e.getStackTrace().toString());
////	      e.printStackTrace();
////	    }
////	}
//
//	public static boolean saveDoorOpenning(String door, String user, String IP) {
//		String insert = "INSERT INTO `localdb`.`accionremota` "+
//				"(`tipoaccion`,`usuario`,`hora`,`ejecutada`,`ip`) VALUES "+
//				"("+int_from_actionType("Abrir Puerta "+door)+",'"+user+"','"+getTimestampToString()+"',false,'"+IP+"');";
//		try {
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/localdb", "root", "") ;
//		    st = conn.createStatement();
//		    st.execute(insert);
//		    int updateCount = st.getUpdateCount();
//		    
//		    st.close();
//		    conn.close();
//		    
//		    return updateCount > 0;
//		} catch (Exception e) {
//		    System.err.println("Got an exception! ");
//		    System.err.println(e.getMessage());
//		    e.printStackTrace();
//		    return false;
//		}
//	}
//	
//	private static int int_from_actionType(String action) {
//		switch(action) {
//		case "Abrir Puerta A": return 56;
//		case "Abrir Puerta B": return 7;
//		case "Abrir Puerta WC": return 28672;
//		case "Abrir Puerta Escalera": return 3584;
//		case "Abrir Puerta Peatonal": return 448;
//
//		default: return 999;
//		}
//	}
//	
//	private static String getTimestampToString() {
//		return (new Timestamp(new Date().getTime())).toString();
//	}
//	
//	public static boolean saveWebAction(String webAction, String IP, String user, String pass) {
//		if(webAction.equals("Get Login Page")) {
//			return saveWebActionLoadLoginPage(IP);
//		} else {
//			return saveGenericWebAction(webAction, IP, user, pass);
//		}
//	}
//	
//	public static boolean saveGenericWebAction(String webAction, String IP, String user, String pass) {
//		String insert = "INSERT INTO `localdb`.`accionweb` "+
//				"(`accion`,`usuario`,`hora`,`pass`,`ip`) VALUES "+
//				"('"+webAction+"','"+user+"','"+getTimestampToString()+"','"+pass+"','"+IP+"');";
//		try {
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/localdb", "root", "") ;
//		    st = conn.createStatement();
//		    st.execute(insert);
//		    int updateCount = st.getUpdateCount();
//		    
//		    st.close();
//		    conn.close();
//		    
//		    return updateCount > 0;
//		} catch (Exception e) {
//		    System.err.println("Got an exception! ");
//		    System.err.println(e.getMessage());
//		    e.printStackTrace();
//		    return false;
//		}
//	}
//	
//	public static boolean saveWebActionLoadLoginPage(String IP) {
//		String insert = "INSERT INTO localdb.accionweb "+
//				"(`accion`,`hora`,`ip`) VALUES "+
//				"('Get Login Page','"+getTimestampToString()+"','"+IP+"');";
//		//System.out.println(insert);
//		try {
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/localdb", "root", "") ;
//		    st = conn.createStatement();
//		    st.execute(insert);
//		    int updateCount = st.getUpdateCount();
//		    return updateCount > 0;
//		} catch (Exception e) {
//		    System.err.println("Got an exception! ");
//		    System.err.println(e.getMessage());
//		    e.printStackTrace();
//		    return false;
//		}
//	}
}
