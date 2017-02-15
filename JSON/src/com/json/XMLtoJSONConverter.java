package com.json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;
import org.json.XML; 

public class XMLtoJSONConverter {
	
	static String line="",str="";
	
	public static void main(String[] args) throws  IOException {
        String link = "C:\\Users\\njai49\\Documents\\Json\\sampleXml.xml";
        BufferedReader br = new BufferedReader(new FileReader(link));
        while ((line = br.readLine()) != null) 
        {   
            str+=line;  
        }
        JSONObject jsondata = XML.toJSONObject(str);
        System.out.println(jsondata);
        br.close();
	}

}
