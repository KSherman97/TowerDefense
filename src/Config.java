import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {

	public static void load(FileInputStream fis2)  throws FileNotFoundException, IOException{
        //Reading properties file in Java example
        Config props = new Config();
        FileInputStream fis = new FileInputStream("config/config.properties");
      
        //loading properties from properties file
        props.load(fis);

        //reading property
       /**
        String user = "user";
        if(props.getProperty("user").equals("root")) {
        System.out.println("username: " + user);
        } else {
        	 System.out.println("User is not root");
        }
        **/
        String user = props.getProperty("user", "watchan(default)");
        String mode = props.getProperty("mode", "0");
        if(props.getProperty("mode", mode).equals("1")) {
            Screen.isDebug = true;
        }
        // System.out.println("mode: " + mode);
	}

	private String getProperty(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
}