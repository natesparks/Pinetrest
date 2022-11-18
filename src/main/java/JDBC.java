import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class JDBC {
	
	private static String JDBC_URL = "jdbc:mysql://localhost/Pinetrest?user=root&password="; 
	private static String SQL_PASSWORD = "password"; 
	
	
	public static User loginUser(String username, String password) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		}catch(ClassNotFoundException e) {
			System.out.println("Error in loginUser" + e.getMessage()); 
		}
		
		Connection conn = null; 
		Statement st = null; 
		
		try {
			conn = DriverManager.getConnection(JDBC_URL+ SQL_PASSWORD); 
			st = conn.createStatement(); 
			
		}catch(SQLException e) {
			System.out.println("SQLException in loginUser" + e.getMessage()); 
		}finally {
			try {
				if(st != null) {st.close(); }
				if(conn != null) {conn.close(); }
			}catch(SQLException e) {
				System.out.println("Closing SQLException in loginUser" + e.getMessage()); 
			}
		}
		
		
		
	}
	
	public static int registerUser(String username, String password, String email) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		}catch(ClassNotFoundException e) {
			System.out.println("Error in loginUser" + e.getMessage()); 
		}
		
		Connection conn = null; 
		Statement st = null; 
		
		try {
			conn = DriverManager.getConnection(JDBC_URL+ SQL_PASSWORD); 
			st = conn.createStatement(); 
			
		}catch(SQLException e) {
			System.out.println("SQLException in registerUser" + e.getMessage()); 
		}finally {
			try {
				if(st != null) {st.close(); }
				if(conn != null) {conn.close(); }
			}catch(SQLException e) {
				System.out.println("Closing SQLException in registerUser" + e.getMessage()); 
			}
		}
		
	}
	
	public static Vector<String> getCollection(String userID, String collectionName){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		}catch(ClassNotFoundException e) {
			System.out.println("Error in loginUser" + e.getMessage()); 
		}
		
		Connection conn = null; 
		Statement st = null; 
		
		try {
			conn = DriverManager.getConnection(JDBC_URL+ SQL_PASSWORD); 
			st = conn.createStatement(); 
			
		}catch(SQLException e) {
			System.out.println("SQLException in assembleCollection" + e.getMessage()); 
		}finally {
			try {
				if(st != null) {st.close(); }
				if(conn != null) {conn.close(); }
			}catch(SQLException e) {
				System.out.println("Closing SQLException in assembleCollection" + e.getMessage()); 
			}
		}
		
	}
	
	public static Vector<String> insertCollection(String userID, String collectionName, String img_path){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		}catch(ClassNotFoundException e) {
			System.out.println("Error in loginUser" + e.getMessage()); 
		}
		
		Connection conn = null; 
		Statement st = null; 
		
		try {
			conn = DriverManager.getConnection(JDBC_URL+ SQL_PASSWORD); 
			st = conn.createStatement(); 
			
		}catch(SQLException e) {
			System.out.println("SQLException in assembleCollection" + e.getMessage()); 
		}finally {
			try {
				if(st != null) {st.close(); }
				if(conn != null) {conn.close(); }
			}catch(SQLException e) {
				System.out.println("Closing SQLException in assembleCollection" + e.getMessage()); 
			}
		}
		
	}
	

}
