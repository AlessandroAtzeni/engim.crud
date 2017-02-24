package engim.crud.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
public static Connection getConnection(){
		
		Properties pr  = new Properties();
		
		InputStream is = null;
		
		try {
			
			is = new FileInputStream("Config.properties");
			pr.load(is);
			 
			Connection connection;
			
		connection = 
					DriverManager.getConnection
					("jdbc:mariadb://localhost:"+pr.getProperty("DB_HOST_PORT")+"/"+pr.getProperty("DB_VALUE")+"?user=root");
			return connection;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
