package testlayer;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import externaldata.*;
import pompackage.PomLogin;

public class LoginPage extends BaseHRMClass {
	PomLogin log;
public LoginPage() {
	super();
	 
}
   @BeforeMethod
public void setup() {
	   initiation();
	   log=new PomLogin();
	   screenshots("login");
}
  

   @Test(priority=1)
   public void VerifyTitle() {
	  String actual=log.verify();
	  System.out.println(actual);
	   Assert.assertEquals(actual, "OrangeHRM");
	   
   }
   @DataProvider
   public Object[][] Details(){
	   Object result[][]=ExcelSheet.readdata("Sheet1");
	return result;
	   
   }
 

    @Test(priority=2, dataProvider="Details")
    public void Login(String name, String password) {
    	log.typeusername(name);
    	log.typepassword(password);
    	//log.clickbutton();
    }

  }
   

