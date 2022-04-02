package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;



public class PomLogin extends BaseHRMClass {

	
	@FindBy(id="txtUsername")
	WebElement username;
	@FindBy(id="txtPassword")
	WebElement password;
	@FindBy(id="btnLogin")
	WebElement loginbtn;
	@FindBy(id="forgotPasswordLink")
	WebElement Forgotpassword;

	
	public PomLogin() {
		PageFactory.initElements(driver, this);
	}
public void typeusername(String name) {
	username.sendKeys(name);
}
	public void typepassword(String Password) {
		password.sendKeys(Password);
	}
	public void clickbutton() {
		loginbtn.click();
	}
	public void forgotpassword() {
		Forgotpassword.click();
	}
	public String verify() {
		return driver.getTitle();
		
		
	}
}
