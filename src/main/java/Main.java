import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Main {
	private static final String DELETE_OLD = "DELETE FROM users WHERE id=?";
	private static final String SELECT_ALL = "SELECT * FROM users";
	public static void main(String[] args){
		try{
			DBWorker dbworker = new DBWorker();
			Statement statement = dbworker.getConnection().createStatement();
			statement.addBatch("insert into users(username, password) values('test', 'test')");
			statement.addBatch("insert into users(username, password) values('test1', 'test1')");
			statement.executeBatch();
			ResultSet res = statement.executeQuery("Select * from users");
			while(res.next()){
				User user =new User(res.getInt("id"), res.getString("username"), res.getString("password"));
				System.out.println(user);
			}
			System.out.println("End of statement");
		} catch (SQLException e){
			e.printStackTrace();
	    } 
		try{
			DBWorker dbworker = new DBWorker();
			PreparedStatement preparedStatement = dbworker.getConnection().prepareStatement(DELETE_OLD);
			preparedStatement.setInt(1, 2);
			preparedStatement.execute();
			preparedStatement = dbworker.getConnection().prepareStatement(SELECT_ALL);
			ResultSet res = preparedStatement.executeQuery();
			while(res.next()){
				User user =new User(res.getInt("id"), res.getString("username"), res.getString("password"));
				System.out.println(user);
			}
			System.out.println("End of prepared statement");
		} catch (SQLException e){
			e.printStackTrace();
	} 
	}

}
