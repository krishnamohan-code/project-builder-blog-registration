package businesslogic;
import java.util.regex.*;
public class RegistrationValidation
{
	public boolean checkUserDetails(String email,String password,String confirmPassword)
	{
		    if(validPassword(password,confirmPassword) && validEmail(email))
		    {
		    	return true;
		    }
		    else
		    	return false;
	}
	//password validation 
	   private boolean validPassword(String password,String confirmPassword)
	   {          String regex = "^(?=.*[0-9])"
				+ "(?=.*[a-z])(?=.*[A-Z])"
				+ "(?=.*[@#$%^&+=])"
				+ "(?=\\S+$).{8,20}$";
	     Pattern   p = Pattern.compile(regex);
	     if( !password.equals(confirmPassword)|| password==null) {
	    	 return false;
	     }
	     Matcher m =p.matcher(password);
	     return m.matches();
	   }
	   ///Email validation
	   private boolean validEmail(String email)
	   {
		   String a_z="abcdefghijklmnopqrstuvxyz";
		    String numbers="0123456789";
		    String specialChar="_-,@.,";
		    if(email !=" ")
		    {
		    	 if(Check(email,a_z) && Check(email,numbers)&& Check(email,specialChar)) {
					   return true;
				}
		    }
		    return false;
	   }
	   private boolean Check(String i,String k)
	   {
		   for(int a=0;a<i.length();a++) 
		   {
			   for(int b=0;b<k.length();b++)
			   {
				   if(i.charAt(a)==k.charAt(b))
				   {
					   return true;
				   }
			   }
		   }
		   return false;
	   }
}