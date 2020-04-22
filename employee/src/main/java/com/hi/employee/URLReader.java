package com.hi.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import com.hi.employee.employee.EmployeeVO;


public class URLReader {
	
	
public URLReader() {

	System.out.println("url 만들어짐 ");

}
	
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		  System.out.println("readJsonFromUrl");
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	  }

	 
	  public JSONObject getFingerEnroll(EmployeeVO employee) throws JSONException, IOException {
		  int id = employee.getEmId();
		  System.out.println("지문등록 시작");
		  JSONObject json=readJsonFromUrl("http://192.168.1.17:8888/api/finger/enroll/?id="+id);
		  System.out.println(json.toString());
		  System.out.println("result 값은 : "+json.get("result"));
		  return json;
	  }
	  
	  public JSONObject getFingerVerify() throws JSONException, IOException {

		  System.out.println("지문등록 시작");
		  JSONObject json=readJsonFromUrl("http://192.168.1.17:8888/api/finger/verify/");
		  System.out.println(json.toString());
		  System.out.println("id 값은 : "+json.get("uid"));
		  return json;
	  }
	  
	  
	  public JSONObject getFingerUpdate(EmployeeVO employee) throws JSONException, IOException {
		  int id=employee.getEmId();

		  System.out.println("지문등록 시작");
		  JSONObject json = readJsonFromUrl("http://192.168.1.17:8888/api/finger/update/?id="+id);
		  System.out.println(json.toString());
		  System.out.println("result 값은 : "+json.get("result"));
		  return json;
	  }
}
