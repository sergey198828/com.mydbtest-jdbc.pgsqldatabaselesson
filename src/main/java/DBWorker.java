import org.postgresql.*;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBWorker {
	
private final String URL = "jdbc:postgresql://localhost:5432/mydbtest";
private final String USERNAME ="postgres";
private final String PASSWORD = "sergey88";

private Connection connection;

public DBWorker(){
	try {
		connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
	} catch(SQLException e) {
		e.printStackTrace();
	}
}
public Connection getConnection(){
	return this.connection;
}
}
