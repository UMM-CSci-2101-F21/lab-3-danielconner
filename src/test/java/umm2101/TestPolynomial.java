package umm2101;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// The two students who worked on this file are ***REPLACE*** and ***REPLACE***
// There will be at least 20 assertions in this file

public class TestPolynomial {
  private static final Logger logger = Logger.getLogger(TestPolynomial.class.getName());
  
  // You might want to have some polynomials you use in multiple tests
  Polynomial a;
  Polynomial b;

  @BeforeEach
  public void setUp() {
    a = new Polynomial(1,1); //might look like this, for example
  }
   
  @DisplayName("Test adding polynomials")
  @Test
  public void testPlus() {
    /********* Test Plus *********/
    //add two polys that are one node each and have the same power
    
    //add two polys that are one node each and have different powers, first is higher degree
    
    //add two polys that are one node each and have different powers, first is lower degree
    
    //add two polys that include a diff # of nodes where first poly is shorter and higher degree

    //add two polys that include a diff # of nodes where first poly is shorter and lower degree
    
    //add two polys that include a diff # of nodes where first poly is longer and higher degree
    
    //add two polys that include a diff # of nodes where first poly is longer and lower degree
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
    
    // replace this comment with whatever you are testing (what is your second case)
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
