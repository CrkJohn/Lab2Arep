package edu.escuelaing.arem.designprimer;

import static spark.Spark.*;
import java.util.*;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.text.*;


public class SparkWebApp {

	private static NumberFormat formatter = new DecimalFormat("#0.00");     
    private static ArrayList<Double> numbers;
    
    public static void main(String[] args)  throws IOException  { 
        port(getPort());
        String first  =  getFileFromResources("index.html");
        get("/", (req, res) -> first);    
        post("calculo" , (req,res) -> {
            JsonObject jsonObject = new JsonParser().parse(req.body()).getAsJsonObject();
            System.out.print("obj");
            String ans  = solve(jsonObject);
            return ans;    
        });
    }   

    static String solve(JsonObject jsonObject){
        String[] ans = jsonObject.get("num").getAsString().split(" ");
        numbers = new ArrayList<Double>(); 
        for(String n : ans){
            numbers.add(Double.parseDouble(n));
        }
        StringBuilder builder  = new StringBuilder();
        try {
            double mediaValue = media();
            builder.append("Su media es :");
            builder.append(mediaValue);
            String desviacion = desviacionEstandar(mediaValue);
            builder.append(" y su desviacion es " );
            builder.append(desviacion);

        } catch (Exception e) {
            builder.append("ERROR AL ENCONTRAR LA MEDIA Y LA DESVIACION VERIFIQUE SUS NUMEROS");
        }
        return builder.toString();
    }


	/**
	 * @param numerosString xd
	 * @return retorna la desviacion estandar de un conjunto de numeros
	 * @throws Exception
	 */
    public static String desviacionEstandar(double meanValue) throws Exception {
        double stDeviationValue = 0.0;
		for(int i  = 0 ; i < numbers.size() ; ++i) {
			stDeviationValue += Math.pow(numbers.get(i)-meanValue, 2);
		}
		double sqrt = stDeviationValue/(numbers.size()-1.0);
		return formatter.format(Math.sqrt(sqrt)).replace(",",".");		
    }	
    

	
	/**
     *  @param xd
	 *  @return retorna la media de un conjunto de n�meros
	 *  @throws Exception
	 */
	public static double media() throws Exception {
		double meanValue = 0.0;
		for(int i  = 0 ; i < numbers.size() ; ++i) {
			meanValue+=numbers.get(i);
		}
		meanValue/=numbers.size();
		return meanValue;	
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

    static int getPort() {   
        if (System.getenv("PORT") != null) { 
            return Integer.parseInt(System.getenv("PORT"));  
        }        
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)   
    }
}