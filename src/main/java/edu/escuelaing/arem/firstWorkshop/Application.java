package edu.escuelaing.arem.firstWorkshop;

import static spark.Spark.*;
import java.util.*;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.text.*;

public class Application{


    public static void main(String[] args)  throws IOException  { 
        port(getPort());
        String first  =  getFileFromResources("index.html");
        get("/", (req, res) -> first);    
        post("calculo" , (req,res) -> {
            JsonObject jsonObject = new JsonParser().parse(req.body()).getAsJsonObject();
            System.out.print("obj");
            String ans  = SparkWebApp.solve(jsonObject);
            return ans;    
        });
    }   
    

    static int getPort() {   
        if (System.getenv("PORT") != null) { 
            return Integer.parseInt(System.getenv("PORT"));  
        }        
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)   
    }

    static String getFileFromResources(String fileName)  throws IOException  {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));
        String html = "";
        while(bf.ready()){
            html+=bf.readLine();
        }
        return html;

    }


}