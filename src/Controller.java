import java.sql.*;

public class Controller {
	
	private static Connection con = null;
	private static ResultSet rs = null;
	
	public static void main(String[] args) {
		
		String conURL = "jdbc:sqlserver://localhost;" +
                "databaseName=ms_test;user=username;password=password"; //TODO change to our sql server once it is set up
		
		System.out.println("hello");
	}
	
	private static void runInsertQuery(String cURL, String table, String[] values)
		throws SQLException {
		
		try {
			//TODO Fix query logic to a more automated state without having to rely on many pre-written strings
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(cURL);
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement("INSERT INTO table VALUES (?,?)");
			
			for(int i = 1; i < values.length; i++){ //iterate through values in values[] and fill them in the statement
													// needs to be modified to be smarter to work with any data type
				ps.setString(i, values[i-1]);
				
			}
			ps.executeUpdate();
		con.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			con.close();
			con.setAutoCommit(true);
		}
		
		
	}
}
