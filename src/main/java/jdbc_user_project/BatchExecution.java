package jdbc_user_project;sxz

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class BatchExecution {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "root");
		
		
	     User user1 =new User();
	     user1.setUsername("nayana");
		 user1.setPassword("123");
		 user1.setContactno(234567892);
		 user1.setEmailid("nayana@123");
		  user1.setId(5);
		  
		  User user2=new User();
		  user2.setUsername("bhoomi");
			 user2.setPassword("456");
			 user2.setContactno(234567894);
			 user2.setEmailid("bhoomi@123");
			  user2.setId(2);
			  
			  User user3=new User();
			  user3.setUsername("hitha");
				 user3.setPassword("789");
				 user3.setContactno(232567894);
				 user3.setEmailid("hitha@123");
				  user3.setId(3);
				  
				  List<User> list=new ArrayList<User>();
				   list.add(user1);
				   list.add(user2);
				   list.add(user3);
				   
				   PreparedStatement preparedstatement= connection.prepareStatement("insert into user values(?,?,?,?,?)");
				   for(User u:list)
				   {
					    preparedstatement.setString(1,u.getUsername());
						preparedstatement.setString(2, u.getPassword());
						preparedstatement.setLong(3, u.getContactno());
						preparedstatement.setString(4, u.getEmailid());
						preparedstatement.setInt(5,u.getId());
						preparedstatement.addBatch();
						System.out.println("saved in batch"+u.getUsername());
				   }
				   
				   preparedstatement.executeBatch();
				   System.out.println("saved to database");
				   connection.close();
		  
		  
		  
	     
	     
	}

}
