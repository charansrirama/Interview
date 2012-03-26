package th.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDemo {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public void readDataBase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/iweather?user=root&password=root");
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from zipcode where state = \'NY\'");
			printMetaData(resultSet);
			printResultSet(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	private void printMetaData(ResultSet resultSet) throws SQLException {
		System.out.println("The Columns in the table are: ");
		
		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
		}
		System.out.println("*********************");
	}
	
	private void printResultSet(ResultSet resultSet) throws SQLException {
		while(resultSet.next()) {
			System.out.println("Zipcode: " + resultSet.getString("zip"));
			System.out.println("State: " + resultSet.getString("state"));
			System.out.println("City: " + resultSet.getString("city"));
			System.out.println("=====================");
		}
	}
	
	private void close() {
		try {
			if(resultSet != null) {
				resultSet.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(connect != null) {
				connect.close(); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SQLDemo demo = new SQLDemo();
		demo.readDataBase();
	}

}
