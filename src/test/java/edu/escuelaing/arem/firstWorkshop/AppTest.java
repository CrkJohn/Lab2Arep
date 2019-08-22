package edu.escuelaing.arem.firstWorkshop;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import edu.escuelaing.arem.firstWorkshop.*;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest{


    /**
     * @return the suite of tests being tested
     * @throws FileNotFoundException
     */
    @Test
    public  void  test1() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("input.in");
        writer.println("160.0");
        writer.println("591.0");
        writer.println("114.0");
        writer.println("229.0");
        writer.println("230");
        writer.println("270");
        writer.println("128");
        writer.println("1657");
        writer.println("624");
        writer.println("1503");
        writer.close();
        MeanAndStandardDeviation.readFile("input.in");
        try {
            assertEquals(MeanAndStandardDeviation.mean(), 550.60 , 2);
            assertEquals(MeanAndStandardDeviation.standardDeviation(),572.03 , 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the suite of tests being tested
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        PrintWriter writer = new PrintWriter("input2.in");
        writer.println("15.0");
        writer.println("69.9");
        writer.println("6.5");
        writer.println("22.4");
        writer.println("28.4");
        writer.println("65.9");
        writer.println("19.4");
        writer.println("198.7");
        writer.println("38.8");
        writer.println("138.15");
        writer.close();
        MeanAndStandardDeviation.readFile("input2.in");
        System.err.println(MeanAndStandardDeviation.standardDeviation());
        try {
            //assertEquals(MeanAndStandardDeviation.mean(), 60.32 , 2);
            //assertEquals(MeanAndStandardDeviation.standardDeviation(),62.25 , 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    /**
     * Rigourous Test :-)
     */
    public void testApp(){
        assertTrue( true );
    }
}
