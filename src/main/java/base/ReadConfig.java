package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
	public class ReadConfig {
	    private Properties properties;
	    private final String propertyFilePath= "./config//config.properties";
 
	    public ReadConfig() {
	        try {
	            FileInputStream inputStream = new FileInputStream(propertyFilePath);
	            properties = new Properties();
	            properties.load(inputStream);
	            inputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace(); 
	        }
	    }

	    public String getBrowser() {
	        String browser = properties.getProperty("browser");
	        if(browser!=null) return browser;
	        else throw new RuntimeException("Browser name not specified in the config.properties file.");
	    }

	    public String get_chrome_key() {
	        String chromeKey = properties.getProperty("chrome_key");
	        if(chromeKey!=null) return chromeKey;
	        else throw new RuntimeException("Driver path not specified in the config.properties file.");
	    }
	    public String get_edge_key() {
	        String edgeKey = properties.getProperty("edge_key");
	        if(edgeKey!=null) return edgeKey;
	        else throw new RuntimeException("Driver path not specified in the config.properties file.");
	    }
	    public String get_chrome_path() {
	        String chromePath = properties.getProperty("chrome_path");
	        if(chromePath!=null) return chromePath;
	        else throw new RuntimeException("Driver path not specified in the config.properties file.");
	    }
	    public String get_edge_path() {
	        String edgePath = properties.getProperty("edge_path");
	        if(edgePath!=null) return edgePath;
	        else throw new RuntimeException("Driver path not specified in the config.properties file.");
	    }
	    public String getApplicationUrl() {
	        String url = properties.getProperty("url");
	        if(url!=null) return url;
	        else throw new RuntimeException("Application URL not specified in the config.properties file.");
	    }
	    public String getUsername() {
	        String username = properties.getProperty("username");
	        if(username!=null) return username;
	        else throw new RuntimeException("username not specified in the config.properties file.");
	    }
	    public String getPassword() {
	        String password = properties.getProperty("password");
	        if(password!=null) return password;
	        else throw new RuntimeException("Password not specified in the config.properties file.");
	    }
	}
