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
    private static ArrayList<Double> numbers;
    
    

    public static String solve(JsonObject jsonObject){
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
	 * @param meanValue xd
	 * @return retorna la desviacion estandar de un conjunto de numeros
	 * @throws Exception as das
	 */
    public static  String desviacionEstandar(double meanValue) throws Exception {
        double stDeviationValue = 0.0;
		for(int i  = 0 ; i < numbers.size() ; ++i) {
			stDeviationValue += Math.pow(numbers.get(i)-meanValue, 2);
		}
		double sqrt = stDeviationValue/(numbers.size()-1.0);
		return formatter.format(Math.sqrt(sqrt)).replace(",",".");		
    }	
    

	
	/**
     *  
	 *  @return retorna la media de un conjunto de n�meros
	 *  @throws Exception jaofa
	 */
	public static  double media() throws Exception {
		double meanValue = 0.0;
		for(int i  = 0 ; i < numbers.size() ; ++i) {
			meanValue+=numbers.get(i);
		}
		meanValue/=numbers.size();
		return meanValue;	
	}


   
  

  
}