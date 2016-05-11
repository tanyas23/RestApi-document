import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Json {

	
	public static void main(String[] args) throws JSONException, SQLException, ClassNotFoundException {
		Statement stmt;
		Connection con;
		String jsonData = "";
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader("C:/Users/tanyas/Documents/Crunchify_JSON.txt"));
			while ((line = br.readLine()) != null) {
				jsonData += line + "\n";
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		Class.forName("com.mysql.jdbc.Driver");
		 System.out.println("Connecting to a selected database...");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/location","root","root"); 
		System.out.println("Connected database successfully...");
		System.out.println("Inserting records into the table...");
		 stmt=con.createStatement();  
		
	
	
		
		JSONObject jsnobject = new JSONObject(jsonData);
		System.out.println(jsnobject);
		JSONArray jsonArray = jsnobject.getJSONArray("locations");
	    for (int i = 0; i < jsonArray.length(); i++) {
	        JSONObject explrObject = jsonArray.getJSONObject(i);
	        System.out.println("city: " + explrObject.getString("city"));
	        System.out.println("state: " + explrObject.getString("state"));
	        System.out.println("phonenumber: " + explrObject.getString("phonenumber"));
	        String x=explrObject.getString("city");
	        String y=explrObject.getString("state");
	        String z=explrObject.getString("phonenumber");
	        String sql = "insert into location values ('" + x +"','" + y + "','" + z + "')";
	        stmt.executeUpdate(sql);
			System.out.println("Inserted records into the table...");
			
			}
	    con.close();
		 System.out.println("connection closed");
	        
	
	
		
	}

}
