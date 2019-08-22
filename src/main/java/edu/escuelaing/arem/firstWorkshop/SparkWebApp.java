package edu.escuelaing.arem.firstWorkshop;

import static spark.Spark.*;
import java.util.*;


import com.google.gson.JsonObject;

import static spark.Spark.*;
import java.util.*;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.text.*;
public class SparkWebApp {

	private static NumberFormat formatter = new DecimalFormat("#0.00");     

    	
	public static LinkedList<Double> numbers;
	public static double amountNumbers , meanValue ; 


    public static String solve(JsonObject jsonObject){
        String[] ans = jsonObject.get("num").getAsString().split(" ");
        amountNumbers = 0;
		meanValue = 0;
		numbers = new LinkedList<Double>();
        for(String n : ans){
            numbers.add(Double.parseDouble(n));
            amountNumbers++;
        }
        StringBuilder builder  = new StringBuilder();
        try {
            String mediaValue = media();
            builder.append("Su media es :");
            builder.append(mediaValue);
            String desviacion = desviacionEstandar();
            builder.append(" y su desviacion es " );
            builder.append(desviacion);

        } catch (Exception e) {
            builder.append("ERROR AL ENCONTRAR LA MEDIA Y LA DESVIACION VERIFIQUE SUS NUMEROS");
        }
        return builder.toString();
    }


	/**
	 * 
	 * @return retorna la desviacion estandar de un conjunto de numeros
	 * @throws Exception as das
	 */
    public static String desviacionEstandar() throws Exception {
		double stDeviationValue = 0.0;
		for(int i  = 0 ; i < amountNumbers ; ++i) {
			stDeviationValue += Math.pow(numbers.getNode(i)-meanValue, 2);
		}
		double sqrt = stDeviationValue/(amountNumbers-1.0);
		return formatter.format(Math.sqrt(sqrt)).replace(",",".");		
	}	
	


	/**
     *  
	 *  @return retorna la media de un conjunto de n�meros
	 *  @throws Exception jaofa
	 */
    public static String media() throws Exception {
		meanValue = 0.0;
		for(int i  = 0 ; i < amountNumbers ; ++i) {
			meanValue+=numbers.getNode(i);
		}
		meanValue/=amountNumbers;
		return formatter.format(meanValue).replace(",",".");	
	}

    
	public static void readFile(String file){
		amountNumbers = 0;
		meanValue = 0;
		numbers = new LinkedList<Double>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
		    String strCurrentLine;
		    amountNumbers = 0;
		    while ((strCurrentLine = br.readLine()) != null){
		    	numbers.add(Double.parseDouble(strCurrentLine));
		    	amountNumbers++;
				}    
				System.err.println(numbers.ToString());
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
	}
}