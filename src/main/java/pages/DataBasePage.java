package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBasePage {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	String columnValue = null;
	
	public String getDataFromDb(String colomnName) {
		
		try {
			
//          setting properties of mysql			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sqlUrl ="jdbc:mysql://localhost:3306/july2022forCucumber";
			String sqlUserName ="root";
			String sqlPassword ="root";
			String sqlQuery ="Select * from users;";
			
//			create connection to local database
			connection = DriverManager.getConnection(sqlUrl, sqlUserName, sqlPassword);
			
//          empowering the connection reference variable to execute queries	
			statement = connection.createStatement();
			
//          delivering the query
			resultSet = statement.executeQuery(sqlQuery);
			
			while(resultSet.next()) {
			   columnValue	= resultSet.getString(colomnName);
			}	
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			if (resultSet !=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection !=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return columnValue;
		
	}
}
