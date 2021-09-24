package umm2101;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// The two students who worked on this file are Daniel and Connor
// There will be at least 20 assertions in this file

public class TestPolynomial {
  private static final Logger logger = Logger.getLogger(TestPolynomial.class.getName());
  
  // You might want to have some polynomials you use in multiple tests
  Polynomial a;
  Polynomial b;
  Polynomial c;
  Polynomial d;

  @BeforeEach
  public void setUp() {
    a = new Polynomial(1,1); //might look like this, for example
    b = new Polynomial(2,1);
    c = new Polynomial(3,3);
    d = new Polynomial(4,0);
  }
   
  @DisplayName("Test adding polynomials")
  @Test
  public void testPlus() {
    /********* Test Plus *********/
    //add two polys that are one node each and have the same power
    int[] arrayAB = {0,3}; 
    Polynomial ab = new Polynomial(arrayAB); // polynomial with array parameter forms i[0]^0, i[1]^1, i[2]^2, etc.
    assertTrue(ab.equals(a.plus(b)));

    //add two polys that are one node each and have different powers, first is higher degree
    int[] arrayAC = {0,1,0,3};
    Polynomial ac = new Polynomial(arrayAC);
    assertTrue(ac.equals(c.plus(a)));

    //add two polys that are one node each and have different powers, first is lower degree
    int[] arrayBD = {4,2};
    Polynomial bd = new Polynomial(arrayBD);
    assertTrue(bd.equals(d.plus(b)));

    //add two polys that include a diff # of nodes where first poly is shorter and higher degree
    int[] arrayCBD = {4,2,0,3};
    Polynomial cbd = new Polynomial(arrayCBD);
    assertTrue(cbd.equals(c.plus(bd)));

    //add two polys that include a diff # of nodes where first poly is shorter and lower degree
    int[] arrayDAC = {4,1,0,3};
    Polynomial dac = new Polynomial(arrayDAC);
    assertTrue(dac.equals(d.plus(ac)));

    //add two polys that include a diff # of nodes where first poly is longer and higher degree
    int[] arrayACB = {0,2,0,3};
    Polynomial acb = new Polynomial(arrayACB);
    assertTrue(acb.equals(ac.plus(b)));

    //add two polys that include a diff # of nodes where first poly is longer and lower degree
    assertTrue(cbd.equals(bd.plus(c)));
  }
  
  @DisplayName("Test subtracting polynomials")
  @Test
  public void testMinus() {
    /********* Test Minus *********/
    //a minus b, one node each and have the same power
    
    //a minus b, one node each and have different powers, first poly (a) is higher degree
    
    //a minus b, one node each and have different powers, first poly (a) is lower degree
    
    //a minus b, include a diff # of nodes where first poly is shorter and higher degree

    //a minus b, include a diff # of nodes where first poly is shorter and lower degree
    
    //a minus b, include a diff # of nodes where first poly is longer and higher degree

    //a minus b, include a diff # of nodes where first poly is longer and lower degree
  }
    
  @DisplayName("Test multiplying polynomials")
  @Test
  public void testTimes() {
    /********* Test Times *********/
    // replace this comment with whatever you are testing (what is your first case)
    
    // replace this comment with whatever you are testing (what is your second case)
  }
  
  @Test
  public void testEvaluate() {
    // replace this comment with whatever you are testing (what is your first case)
    int[] array123 = {1,2,3};
    Polynomial pArray123 = new Polynomial(array123);
    assertEquals(6, pArray123.evaluate(1)); // Check that polynomial with any amount of nodes evaluates correctly
    
    // replace this comment with whatever you are testing (what is your second case)
    assertEquals(1, a.evaluate(0)); // check that degree of 0 evaluates node to be 1
  }
  
  @Test
  public void testEquals() {
    Polynomial p1   = new Polynomial(4, 3);
    Polynomial p2   = new Polynomial(3, 2);
    Polynomial p3   = new Polynomial(1, 0);
    Polynomial p4   = new Polynomial(2, 1);
    Polynomial p    = p1.plus(p2).plus(p3).plus(p4);   // + 4x^3 + 3x^2 + 2x^1 + 1x^0

    int[] tArray = {1, 2, 3, 4};
    Polynomial t = new Polynomial(tArray);    // + 4x^3 + 3x^2 + 2x^1 + 1x^0
    
    // This test should pass once you have implemented the equals method for Node
    assertTrue(p.equals(t));
    // note: assertEquals does not work here yet 
    // because polynomial will always say false for the equals() method
        
  }
    
  
}
