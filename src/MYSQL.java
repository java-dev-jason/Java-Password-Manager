import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MYSQL {
	private static String url = "jdbc:mysql://";
	private static String host = "127.0.0.1";
	private static int port = 3306;
	private static String database = "passmanager";
	private String errormessage;
	private String benutzername = "root";
	private String password = "1111";
	private Connection con;
	
	public MYSQL( String host,int port,String database) {
		this.url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?allowPublicKeyRetrieval=true&useSSL=false";
		this.host = host;
		this.port = port;
		this.database = database;
		this.errormessage = null;
		
		
		
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection(this.url, benutzername, password);
		    System.out.println("Verbindung erfolgreich!");
		} catch (ClassNotFoundException e) {
		    System.err.println("Fehler: MySQL JDBC-Treiber nicht gefunden!");
		    e.printStackTrace();
		} catch (SQLException e) {
		    System.err.println("Fehler: Verbindung zur Datenbank fehlgeschlagen!");
		    e.printStackTrace();
		}
	}
	
	public void executeQuery(String query) {
		try {
			Statement statement = con.createStatement();
			boolean hasResultSet = statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getPassword() {
	    ArrayList<String> Daten = new ArrayList<>();
	    try (Statement statement = con.createStatement();
	         ResultSet rs = statement.executeQuery("select password from login")) {

	        while (rs.next()) {
	            Daten.add(rs.getString("password"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    String data = "";
	    if(Daten.isEmpty()) {
	    	data = "NoPassword";
	    }else {
		    data = Daten.get(0);
	
	    }	    
	    
	    return data;
	}
	
	public ArrayList<String> seePasswords() {
	    ArrayList<String> Daten = new ArrayList<>();
	    try (Statement statement = con.createStatement();
	         ResultSet rs = statement.executeQuery("select password from passwords")) {

	        while (rs.next()) {
	            Daten.add(rs.getString("password"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }    
	    return Daten;
	}
	
	public ArrayList<String> seePasswordsID() {
	    ArrayList<String> Daten = new ArrayList<>();
	    try (Statement statement = con.createStatement();
	         ResultSet rs = statement.executeQuery("select idPassword from passwords")) {

	        while (rs.next()) {
	            Daten.add(rs.getString("idPassword"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }    
	    return Daten;
	}
	
	public void close() {
	    if (con != null) {
	        try {
	            con.close();
	            System.out.println("Datenbankverbindung geschlossen.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
}


