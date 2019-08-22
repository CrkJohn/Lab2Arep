package edu.escuelaing.arem.firstWorkshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
/**
 * clase que representa el calculo de la media y la desviacion estandar de un conjunto de numeros.
 * 
 * @author CrkJohn
 * 
 */
public class MeanAndStandardDeviation{
	
	public static LinkedList<Double> numbers;
	public static double amountNumbers , meanValue ;
	private static NumberFormat formatter = new DecimalFormat("#0.00");     

	
	
	/**
	 * 
	 * @return retorna la desviacion estandar de un conjunto de n�meros
	 */
	
	public static double standardDeviation() throws Exception {
		double stDeviationValue = 0.0;
		for(int i  = 0 ; i < amountNumbers ; ++i) {
			stDeviationValue += Math.pow(numbers.getNode(i)-meanValue, 2);
		}
		double sqrt = stDeviationValue/(amountNumbers-1.0);
		return Double.valueOf(formatter.format(Math.sqrt(sqrt)).replace(",",".")) ;		
	}	
	
	/**
	 *  @return retorna la media de un conjunto de n�meros
	 */
	public static double mean() throws Exception {
		meanValue = 0.0;
		for(int i  = 0 ; i < amountNumbers ; ++i) {
			meanValue+=numbers.getNode(i);
		}
		meanValue/=amountNumbers;
		return Double.valueOf(formatter.format(meanValue).replace(",","."));	
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
	
	public static void main(String args[]) throws Exception {
			readFile("input2.in");
			
		  System.out.println("The value of mean is "+ mean());
		  System.out.println("The value of standard deviation is "+ standardDeviation());		
	}

}
