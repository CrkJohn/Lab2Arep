package edu.escuelaing.arem.designprimer;

import static spark.Spark.*;
import java.util.*;
import java.io.*;
import java.text.*;


public class SparkWebApp {

	private static NumberFormat formatter = new DecimalFormat("#0.00");     
    
    public static void main(String[] args)  throws IOException  { 
        port(getPort());
        String first  =  getFileFromResources("index.html");
        get("/hello", (req, res) -> first);    
        get("/desviacion" , (req,res) -> 
                "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>"
                +"<meta charset=\"utf-8\">"
                +"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">"
                +"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">"
                +"<title>AREM</title>"
                +"</head>"
                + "<body>\n"
                + "<h1>Calculadora de medias y desviaciones estandar</h1>\n" 
                + "<form action=\"/hello\">\n"
                + "  la media es "
                +    media(req.queryParams("numeros"))
                + "  y "
                + "  la desviacion es "
                +    desviacionEstandar(req.queryParams("numeros"))
                + "  <br><br>\n"
                + "  <button class=\"btn btn-primary\" >Volver</button>"    
                + "</form> \n"
                + "\n"
                + "\n"
                + "</body>\n"
                + "</html>"
                + "\n");
 
    }   

    

	/**
	 * @param numerosString xd
	 * @return retorna la desviacion estandar de un conjunto de numeros
	 * @throws Exception
	 */
    public static String desviacionEstandar(String numerosString) throws Exception {
        String[] ans = numerosString.split(" ");
        ArrayList<Double> numbers = new ArrayList<Double>(); 
        for(String n : ans){
            numbers.add(Double.parseDouble(n));
        }
        Double meanValue = Double.parseDouble(media(numerosString));
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
	public static String media(String numerosString) throws Exception {
        String[] ans = numerosString.split(" ");
        ArrayList<Double> numbers = new ArrayList<Double>(); 
        for(String n : ans){
            numbers.add(Double.parseDouble(n));
        }
		double meanValue = 0.0;
		for(int i  = 0 ; i < numbers.size() ; ++i) {
			meanValue+=numbers.get(i);
		}
		meanValue/=numbers.size();
		return formatter.format(meanValue).replace(",",".");	
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