package jdbc_user_project;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		boolean repeat=true;
		do {
			   System.out.println("1.signup\n 2.login\n 3.exit");
			   System.out.println("enter choice");
			   int choice=scanner.nextInt();
			   switch(choice)
			   {
			   case 1: {
				          System.out.println("enter id: ");
					      int id=scanner.nextInt();
					      System.out.println("enter username");
						  String username=scanner.next();
						  System.out.println("enter password");
						  String password=scanner.next();
						  System.out.println("enter email");
						  String email=scanner.next();
						  System.out.println("enter phone no");
						  long contactno=scanner.nextLong();
						   User user=new User();
						    user.setId(id);
							user.setUsername(username);
							user.setPassword(password);
							user.setEmail(email);
							user.setContactno(contactno);
							UserCRUD crud=new UserCRUD();
							int save=crud.signUp(user);
							if(save==1)
							{
								System.out.println("inserted successfully");
							}
							else
								System.out.println("not inserted");
							
			   }break;
			   case 2:
			   {
				      System.out.println("enter username");
					  String username=scanner.next();
					  System.out.println("enter password");
					  String password=scanner.next();
					  User user=new User();
					  user.setUsername(username);
					  user.setPassword(password);
					  UserCRUD crud=new UserCRUD();
					  boolean save=crud.loginUser(user);
					  if(save==true)
					  {
					  	System.out.println("login successfull");
					  	System.out.println("do u wanto display password or set/reset password");
					  	System.out.println("1.facebook password\n 2.instagram password\n 3.snapchat password\n 4.twitter password\n 5.whatsapp password ");
					  	System.out.println("enter choice");
					  	int choice1=scanner.nextInt();
					  	switch(choice1)
					  	{
					  	case 1:
					  	{
					  		
					  			boolean flag=true;
					  			do {
					  				  System.out.println("1.display password\n 2.set or reset password 3.exit");
					  				  System.out.println("enter choice");
					  				  int choice2=scanner.nextInt();
					  				  switch(choice2)
					  				  {
					  				  
					  				  case 1:
					  				  {
					  					  System.out.println("enter the email");
					  					  String email=scanner.next();
					  					   user.setEmail(email);
					  					  crud.displayFbPassword(user);
					  				  }break;
					  				case 2:
					  				  {
					  					System.out.println("enter the email");
					  					String email=scanner.next();
					  		            System.out.println("enter the new password");
								  		String fbresetpassword=scanner.next();
								  		user.setEmail(email);
								  		user.setFacebookpassword(fbresetpassword);
								  		int rfb=crud.facebookPassword(user);
								  		if(rfb==1)
								  		{
								  			System.out.println("password reset successfully");
								  		}
								  		else
								  			System.out.println("password not reset");
								  	    
					  					  
					  				  }break;
					  				case 3: {
					  					      flag=false;
					  				}break;
					  				  }
					  				  
					  				  
					  			}while(flag);
					  	
					  	        }break;
					  
					  	case 2:
					  	{
					  		boolean flag=true;
				  			do {
				  				  System.out.println("1.display password\n 2.set or reset password \n 3.exit");
				  				  System.out.println("enter choice");
				  				  int choice2=scanner.nextInt();
				  				  switch(choice2)
				  				  {
				  				  
				  				  case 1:
				  				  {
				  					  System.out.println("enter the email");
				  					  String email=scanner.next();
				  					   user.setEmail(email);
				  					  crud.displayInstaPassword(user);
				  				  }break;
				  				case 2:
				  				  {
				  					System.out.println("enter the email");
				  					String email=scanner.next();
				  		            System.out.println("enter the new password");
							  		String instaresetpassword=scanner.next();
							  		user.setEmail(email);
							  		user.setInstagrampassword(instaresetpassword);
							  		int rin=crud.instagramPassword(user);
							  		if(rin==1)
							  		{
							  			System.out.println("password reset successfully");
							  		}
							  		else
							  			System.out.println("password not reset");
							  	    
				  					  
				  				  }break;
				  				case 3: {
			  					      flag=false;
			  				}break;
				  				  }
				  				  
				  				  
				  			}while(flag);
				  	
					  		
					  	}break;
					  	case 3:
					  	{
					  		boolean flag=true;
				  			do {
				  				  System.out.println("1.display password\n 2.set or reset password\n 3.exit");
				  				  System.out.println("enter choice");
				  				  int choice2=scanner.nextInt();
				  				  switch(choice2)
				  				  {
				  				  
				  				  case 1:
				  				  {
				  					  System.out.println("enter the email");
				  					  String email=scanner.next();
				  					   user.setEmail(email);
				  					  crud.displaySnapPassword(user);
				  				  }break;
				  				case 2:
				  				  {
				  					System.out.println("enter the email");
				  					String email=scanner.next();
				  		            System.out.println("enter the new password");
							  		String snapresetpassword=scanner.next();
							  		user.setEmail(email);
							  		user.setSnapchatpassword(snapresetpassword);
							  		int rsn=crud.snapchatPassword(user);
							  		if(rsn==1)
							  		{
							  			System.out.println("password reset successfully");
							  		}
							  		else
							  			System.out.println("password not reset");
							  	    
				  					  
				  				  }break;
				  				case 3: {
			  					      flag=false;
			  				}break;
				  				  }
				  				  
				  				  
				  			}while(flag);
				  	
					  		
					  		
					  	}break;
					  	case 4:
					  	{ 
					  		boolean flag=true;
				  			do {
				  				  System.out.println("1.display password\n 2.set or reset password \n 3.exit");
				  				  System.out.println("enter choice");
				  				  int choice2=scanner.nextInt();
				  				  switch(choice2)
				  				  {
				  				  
				  				  case 1:
				  				  {
				  					  System.out.println("enter the email");
				  					  String email=scanner.next();
				  					   user.setEmail(email);
				  					  crud.displayTwitPassword(user);
				  				  }break;
				  				case 2:
				  				  {
				  					System.out.println("enter the email");
				  					String email=scanner.next();
				  		            System.out.println("enter the new password");
							  		String twitterresetpassword=scanner.next();
							  		user.setEmail(email);
							  		user.setTwitterpassword(twitterresetpassword);
							  		int rtw=crud.TwitterPassword(user);
							  		if(rtw==1)
							  		{
							  			System.out.println("password reset successfully");
							  		}
							  		else
							  			System.out.println("password not reset");
							  	    
				  					  
				  				  }break;
				  				case 3: {
			  					      flag=false;
			  				}break;
				  				  }
				  				  
				  				  
				  			}while(flag);
				  	
					  		
					  	}break;
					  	case 5:
					  	{

					  		boolean flag=true;
				  			do {
				  				  System.out.println("1.display password\n 2.set or reset password \n 3.exit");
				  				  System.out.println("enter choice");
				  				  int choice2=scanner.nextInt();
				  				  switch(choice2)
				  				  {
				  				  
				  				  case 1:
				  				  {
				  					  System.out.println("enter the email");
				  					  String email=scanner.next();
				  					   user.setEmail(email);
				  					  crud.displayWhatsPassword(user);
				  				  }break;
				  				case 2:
				  				  {
				  					System.out.println("enter the email");
				  					String email=scanner.next();
				  		            System.out.println("enter the new password");
							  		String whatsresetpassword=scanner.next();
							  		user.setEmail(email);
							  		user.setWhtasappassword(whatsresetpassword);
							  		int rwh=crud.whatsAppPassword(user);
							  		if(rwh==1)
							  		{
							  			System.out.println("password reset successfully");
							  		}
							  		else
							  			System.out.println("password not reset");
							  	    
				  					  
				  				  }break;
				  				case 3: {
			  					      flag=false;
			  				}break;
				  				  }
				  				  
				  				  
				  			}while(flag);
					  	}break;
					  	default: System.out.println("enter valid choice");
					  	}
					  	
					  }
					  else
					  {
					  	System.out.println("enter valid password");
					  } 
					  
				    }break;
			   case 3:
			   {
				   repeat=false;
			   }break;
			   default: System.out.println("enter valid choice");
			   }
			 
			
		}while(repeat);

	}

}

        
