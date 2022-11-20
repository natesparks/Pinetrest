import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class JDBC {
	
	private static String JDBC_URL = "jdbc:mysql://localhost/Pinetrest?user=root&password="; 
	private static String SQL_PASSWORD = "password"; 
	
	
//	public static User loginUser(String username, String password) {
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver"); 
//		}catch(ClassNotFoundException e) {
//			System.out.println("Error in loginUser" + e.getMessage()); 
//		}
//		
//		Connection conn = null; 
//		Statement st = null; 
//		
//		try {
//			conn = DriverManager.getConnection(JDBC_URL+ SQL_PASSWORD); 
//			st = conn.createStatement(); 
//			
//		}catch(SQLException e) {
//			System.out.println("SQLException in loginUser" + e.getMessage()); 
//		}finally {
//			try {
//				if(st != null) {st.close(); }
//				if(conn != null) {conn.close(); }
//			}catch(SQLException e) {
//				System.out.println("Closing SQLException in loginUser" + e.getMessage()); 
//			}
//		}
//		
//		
//		
//	}
//	
//	public static int registerUser(String username, String password, String email) {
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver"); 
//		}catch(ClassNotFoundException e) {
//			System.out.println("Error in loginUser" + e.getMessage()); 
//		}
//		
//		Connection conn = null; 
//		Statement st = null; 
//		
//		try {
//			conn = DriverManager.getConnection(JDBC_URL+ SQL_PASSWORD); 
//			st = conn.createStatement(); 
//			
//		}catch(SQLException e) {
//			System.out.println("SQLException in registerUser" + e.getMessage()); 
//		}finally {
//			try {
//				if(st != null) {st.close(); }
//				if(conn != null) {conn.close(); }
//			}catch(SQLException e) {
//				System.out.println("Closing SQLException in registerUser" + e.getMessage()); 
//			}
//		}
//		
//	}
	
	public static Vector<String> getCollection(String userID, String collectionName){
		
		
		Vector<String> res = new Vector<String>();  
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
			String query = "SELECT image_path FROM Collections WHERE userID=" + userID + " AND collection_name=" + collectionName; 
			ResultSet rs = st.executeQuery(query); 
			while(rs.next()) {
				String imgPath = rs.getString(0); 
				res.add(imgPath); 
			}
			
			
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
		
		return res; 
		
	}
	
	public static boolean insertCollection(String userID, String collectionName, String img_path){
		
		
		
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
			String query = "INERT INTO Collections(userID, collection_name, image_path) VALUES("+userID+", " +collectionName+", "
						+img_path+")"; 
			st.execute(query); 
			
			
		}catch(SQLException e) {
			System.out.println("SQLException in assembleCollection" + e.getMessage()); 
			return false; 
		}finally {
			try {
				if(st != null) {st.close(); }
				if(conn != null) {conn.close(); }
			}catch(SQLException e) {
				System.out.println("Closing SQLException in assembleCollection" + e.getMessage()); 
				return false; 
			}
		} 
		return true; 
		
	}
	
	public static boolean deleteCollection(String userID, String collectionName){
		
		if(userID == null || collectionName == null) {
			System.out.println("Error in delete Collection: cannot delete null values"); 
			return false; 
		}
		else if(userID.equals("") || collectionName.equals("")) {
			System.out.println("Error in delete Collection: cannot delete blank values"); 
			return false; 
		}
		
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
			String query = "DELETE FROM COLLECTION WHERE userID= " + userID + " AND collection_name="  + collectionName; 
			st.execute(query); 
			
		}catch(SQLException e) {
			System.out.println("SQLException in assembleCollection" + e.getMessage()); 
			return false; 
		}finally {
			try {
				if(st != null) {st.close(); }
				if(conn != null) {conn.close(); }
			}catch(SQLException e) {
				System.out.println("Closing SQLException in assembleCollection" + e.getMessage()); 
				return false; 
			}
		}
		return true; 
		
	}
	
	public static boolean deleteFromCollection(String userID, String collectionName, String img_path){
		
		if(userID == null || collectionName == null || img_path == null) {
			
			System.out.println("Cannot delete null values");
			return false; 
		}
		else if (userID.equals("")  || collectionName.equals("") || img_path.equals("")) {
			System.out.println("Cannot delete blank value");
			return false; 
		}
		
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
			String query = "DELETE FROM Collection WHERE userID= " + userID +
					" AND collection_name="+collectionName+ " AND image_path=" + img_path; 
			st.execute(query); 
		}catch(SQLException e) {
			System.out.println("SQLException in assembleCollection" + e.getMessage()); 
			return false; 
		}finally {
			try {
				if(st != null) {st.close(); }
				if(conn != null) {conn.close(); }
			}catch(SQLException e) {
				System.out.println("Closing SQLException in assembleCollection" + e.getMessage()); 
				return false; 
			}
		}
		return true; 
		
	}
	

}
