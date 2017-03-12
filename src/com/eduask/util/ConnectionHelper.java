package com.eduask.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionHelper {
	
	private static ConnectionHelper connHelper;
	
	private Properties properties = new Properties();
	
	private ConnectionHelper(){
		
		InputStream is = this.getClass().getResourceAsStream("/data.properties");
		
		try {
			properties.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			if(is!=null){
				
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static ConnectionHelper newInstance(){
		
		if(connHelper==null){
			connHelper = new ConnectionHelper();
		}
		return connHelper;
	}
	
	public String getString(String key){
		
		
		return properties.getProperty(key);
	}

}
