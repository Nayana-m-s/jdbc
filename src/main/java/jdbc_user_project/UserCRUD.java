package jdbc_user_project;

import java.io.FileInputStream;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class UserCRUD {
	
	public Connection getConnection() throws Exception
	{
		//Class.forName("com.mysql.cj.jdbc.Driver"); -> this is the loading process loading process can done implicitly
		//register can done in explicitly by the programmer using Driver class
	      Driver driver =new Driver();
	      DriverManager.registerDriver(driver);
		FileInputStream fileinputstream=new FileInputStream("dbconfig.properties");
		Properties properties=new Properties();
		properties.load(fileinputstream);
		
		Connection connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
		
		
		
		return connection;
	}
	
	public int signUp(User user) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedstatement =connection.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?,?)");
		preparedstatement.setInt(1,user.getId());
		preparedstatement.setString(2,user.getUsername());
		preparedstatement.setString(3, user.getPassword());
		preparedstatement.setString(4, user.getEmail());
		preparedstatement.setLong(5, user.getContactno());
		preparedstatement.setString(6,user.getFacebookpassword());
		preparedstatement.setString(7,user.getInstagrampassword());
		preparedstatement.setString(8,user.getSnapchatpassword());
		preparedstatement.setString(9,user.getTwitterpassword());
		preparedstatement.setString(10,user.getWhtasappassword());
		int sign=preparedstatement.executeUpdate();
		connection.close();
		
		return sign;
	}
	
	public boolean loginUser(User user) throws Exception
	{
		String query="select*from user where username=?";
		Connection connection=getConnection();
		PreparedStatement preparedstatement=connection.prepareStatement(query);
		preparedstatement.setString(1,user.getUsername());
		ResultSet resultset=preparedstatement.executeQuery();
		
		String password=null;
		while(resultset.next())
		{
			password= resultset.getString("password");
		}
		if(user.getPassword().equals(password))
		{
			return true;
		}
		return false;
	}
	public void displayFbPassword(User user) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedstatement =connection.prepareStatement("select facebookpassword from user where email=?");
		preparedstatement.setString(1,user.getEmail());
		ResultSet resultset=preparedstatement.executeQuery();
		while(resultset.next())
		{
			System.out.println("facebook password: ");
			System.out.println(resultset.getString("facebookpassword"));
		}
		connection.close();
		
	}
	public int facebookPassword(User user) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedstatement =connection.prepareStatement("update user set facebookpassword=? where email=?");
		preparedstatement.setString(1, user.getFacebookpassword());
		preparedstatement.setString(2, user.getEmail());
		int fbpassword=preparedstatement.executeUpdate();
		connection.close();
		
	
		return fbpassword;
	
		
	}
	public int instagramPassword(User user) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedstatement =connection.prepareStatement("update user set instagrampassword=? where email=?");
		preparedstatement.setString(1, user.getInstagrampassword());
		preparedstatement.setString(2, user.getEmail());
		int instapassword=preparedstatement.executeUpdate();
		connection.close();
	
	
		return instapassword;
		
	}
	public void displayInstaPassword(User user) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedstatement =connection.prepareStatement("select instagrampassword from user where email=?");
		preparedstatement.setString(1,user.getEmail());
		ResultSet resultset=preparedstatement.executeQuery();
		while(resultset.next())
		{
			System.out.println("instagram password: ");
			System.out.println(resultset.getString("instagrampassword"));
		}
		connection.close();
		
	}
	public int snapchatPassword(User user) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedstatement =connection.prepareStatement("update user set snapchatpassword=? where email=?");
		preparedstatement.setString(1, user.getSnapchatpassword());
		preparedstatement.setString(2, user.getEmail());
		int snappassword=preparedstatement.executeUpdate();
		connection.close();
	
	
		return snappassword;
	}
	public void displaySnapPassword(User user) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedstatement =connection.prepareStatement("select snapchatpassword from user where email=?");
		preparedstatement.setString(1,user.getEmail());
		ResultSet resultset=preparedstatement.executeQuery();
		while(resultset.next())
		{
			System.out.println("snapchat password: ");
			System.out.println(resultset.getString("snapchatpassword"));
		}
		connection.close();
		
	}
	
	
	public int TwitterPassword(User user) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedstatement =connection.prepareStatement("update user set twitterpassword=? where email=?");
		preparedstatement.setString(1, user.getTwitterpassword());
		preparedstatement.setString(2, user.getEmail());
		int twitpassword=preparedstatement.executeUpdate();
		connection.close();
		
	
		return twitpassword;
	}
	public void displayTwitPassword(User user) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedstatement =connection.prepareStatement("select twitterpassword from user where email=?");
		preparedstatement.setString(1,user.getEmail());
		ResultSet resultset=preparedstatement.executeQuery();
		while(resultset.next())
		{
			System.out.println("twitter password: ");
			System.out.println(resultset.getString("twitterpassword"));
		}
		connection.close();
		
	}
	public int whatsAppPassword(User user) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedstatement =connection.prepareStatement("update user set whtasappassword=? where email=?");
		preparedstatement.setString(1, user.getWhtasappassword());
		preparedstatement.setString(2, user.getEmail());
		int twitpassword=preparedstatement.executeUpdate();
		connection.close();
		
	
		return twitpassword;
	}
	
	public void displayWhatsPassword(User user) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedstatement =connection.prepareStatement("select whtasappassword from user where email=?");
		preparedstatement.setString(1,user.getEmail());
		ResultSet resultset=preparedstatement.executeQuery();
		while(resultset.next())
		{
			System.out.println("whatsapp password: ");
			System.out.println(resultset.getString("whtasappassword"));
		}
		connection.close();
		
	}
	
	public void updateUser(User user) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedstatement =connection.prepareStatement("update user set username=? where id=?");
		preparedstatement.setString(1,user.getUsername());
		preparedstatement.setInt(2, user.getId());
		preparedstatement.execute();
		connection.close();
		System.out.println("updated");
	}
	
	public void deleteUser(User user) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedstatement =connection.prepareStatement("delete from user where id=?");
		preparedstatement.setInt(1, user.getId());
		preparedstatement.execute();
		connection.close();
		System.out.println("deleted");
	}
	
	public void getAllUser() throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedstatement =connection.prepareStatement("select * from user");
		ResultSet resultset=preparedstatement.executeQuery();
		while(resultset.next())
		{
			System.out.println(resultset.getString(1));
			System.out.println(resultset.getString(2));
			System.out.println(resultset.getLong(3));
			System.out.println(resultset.getString(4));
			System.out.println(resultset.getInt(5));
			System.out.println("========================");
		}
	
		connection.close();
	
		
	}

}
