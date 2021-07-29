package Amazon;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class AmazonProgram 
{

	public static void main(String[] args) throws InterruptedException 
	{
		  
		  System.setProperty("webdriver.chrome.driver", "C:\\Seleniumwebdriver\\chromedriver\\chromedriver.exe");
	      WebDriver driver=new ChromeDriver();
	      driver.get("http://www.amazon.in/");
	      driver.manage().window().maximize();
		  System.out.println("Amazon Webpage Opened Successfully");
		  
		  
		//SIGNIN  
		  WebElement element = driver.findElement(By.xpath("//a[@id='nav-link-accountList']")) ;
	      Actions act = new Actions(driver);
	      act.moveToElement(element).build().perform();
	      Thread.sleep(5000);
	      System.out.println("Mouse Over Done for Accounts & Lists");
	      
		  driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[@id='nav-flyout-accountList']/div[2]/div[1]/div[1]/div[1]/a[1]/span[1]")).click();
		  driver.findElement(By.name("email")).sendKeys("anugangadevi1612@gmail.com");
		  driver.findElement(By.id("continue")).click();
		  driver.findElement(By.name("password")).sendKeys("Sweety@16");
		  driver.findElement(By.id("signInSubmit")).click();
		  System.out.println("Signed in successfully");
		  
		//URL PAGE
		  driver.getCurrentUrl();
		  System.out.println("Current URL IS:" + driver.getCurrentUrl());
		   
		  
		//ICON CHECK
		  driver.findElement(By.id("nav-logo-sprites"));
		  System.out.println("Icon displayed"); 
		  
		  
		//SCROLL CHECK
		  JavascriptExecutor js = (JavascriptExecutor)driver;
	      js.executeScript("window.scrollBy(0,1000)");    //Scrolling down
	      System.out.println("Scroll Down");
	      Thread.sleep(3000);
	      
	      js.executeScript("window.scrollBy(0,-1000)");   //scrolling up
	      System.out.println("Scroll Up");
	      Thread.sleep(3000);
	      
	      js.executeScript("window.scrollBy(1000,0)");    //Scrolling right
	      System.out.println("Scroll right");
	      Thread.sleep(3000);
	      
	      
	    //DROPDOWN LIST CHECK
		  Select drp = new Select(driver.findElement(By.id("searchDropdownBox")));
		  drp.selectByValue("search-alias=appliances");
		  Thread.sleep(1000);
		  System.out.println("SelectByValue Done");
		  
		  Select drp1 = new Select(driver.findElement(By.id("searchDropdownBox")));
		  drp1.selectByVisibleText("Electronics");
		  Thread.sleep(1000);
		  System.out.println("selectByVisibleText Done");
		  
		  Select drp2 = new Select(driver.findElement(By.id("searchDropdownBox")));
		  drp2.selectByIndex(2);
		  Thread.sleep(1000);
		  System.out.println("selectByVisibleText Done");
		  
	     
	    //RADIOBUTTON
		  driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[1]/span[1]/span[2]")).click();
	      WebElement radio1 = driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='customer-preferences']/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/label[1]/i[1]"));
	      radio1.click();
	      radio1.isSelected();
		  System.out.println("Radio button option selected");
		  
		  
		  
		 //TITLE LENGTH
		   String title = driver.getTitle();  //Storing title name in the string variable
		   int titleLength = driver.getTitle().length();  //storing title length in the int variable
		   System.out.println("Title of the page is :" +title);  //printing title and title length in the console
		   System.out.println("Length of the title is :" +titleLength);
		   Thread.sleep(2000);
		   
			
		 //TITLE CHECK
		    String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
			String actualTitle = "";
			//get the actual value of the title
			actualTitle = driver.getTitle();
			if (actualTitle.contentEquals(expectedTitle))
			{
			  System.out.println("Title Check Passed");  
			}
			else
			{
			  System.out.println("Title check Failed");
			}
			
			
			 
		 //SEARCHBAR
			 WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		     search.sendKeys("electronics");
		     driver.findElement(By.id("nav-search-submit-button")).click();
		     System.out.println("Search Bar Done");
		     
		     
			 
		   //-----------------------ADDING ITEMS TO CART IN AMAZON WEBPAGE--------------------//
		     
			 WebElement element1 = driver.findElement(By.linkText("Mobiles"));
			 element1.click();
			 
		  //MOUSE OVER
			 WebElement element2 = driver.findElement(By.xpath("//span[contains(text(),'Laptops & Accessories')]")) ;
			 Actions act1 = new Actions(driver);
			 act1.moveToElement(element2).build().perform();
			 Thread.sleep(3000);
			 System.out.println("Mouse Over Done for Laptop Accessories");
			 
		  //LINKTEXT
			 WebElement tab = driver.findElement(By.linkText("Tablets")) ;
			 tab.click();
			 System.out.println("Linktext Done");
			 
		  //XPATH 
			 WebElement gb = driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]/div[2]/div[2]/div[1]/div[1]/div[4]/ul[1]/li[4]/span[1]/a[1]/div[1]/label[1]/i[1]")) ;
			 gb.click();
			 System.out.println("Xpath Done");
			 
		  //CHECKBOX
			 WebElement brand = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/span[1]/div[1]/div[1]/div[3]/ul[1]/li[2]/span[1]/a[1]/div[1]/label[1]/i[1]"));
			 brand.click();
			 System.out.println("Checkbox Button Option selected");

			 
			 WebElement img = driver.findElement(By.className("s-image")) ;
			 img.click();
			 String MainWindow=driver.getWindowHandle();
		   //To handle all new opened window
		      Set<String> s1=driver.getWindowHandles();
		      Iterator<String> i1=s1.iterator();
		      while(i1.hasNext())
		      {
		    	  String ChildWindow=i1.next();
		    	  if(!MainWindow.equalsIgnoreCase(ChildWindow))
		    	  {
		    		  driver.switchTo().window(ChildWindow);
		    		  driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		    		  Thread.sleep(3000);
		    		  System.out.println("Items Added to cart");
		    		
		    	  }
		    		
		      }	
		      
		      WebElement cart = driver.findElement(By.linkText("Cart")) ;
			  cart.click();	
		      
		     
		    //SIGNOUT
		      WebElement element3 = driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[2]/span[1]"));
		      Actions act2 = new Actions(driver);
		      act2.moveToElement(element3).build().perform();
		      driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]")).click();
			  Thread.sleep(5000);
			  System.out.println("Signed Out successfully");
			  
		    
			//Terminates the program
		      driver.close();
		      driver.quit();
		      System.out.println("Amazon Webpage closed successfully");
	}

}
