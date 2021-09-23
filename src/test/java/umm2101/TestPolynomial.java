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

  @BeforeEach
  public void setUp() {
    a = new Polynomial(1,1); //might look like this, for example
    b = new Polynomial(5,1);
  }
   
  @DisplayName("Test adding polynomials")
  @Test
  public void testPlus() {
    /********* Test Plus *********/
    Polynomial t = new Polynomial(6,1);
    //add two polys that are one node each and have the same power
    assertTrue(t.equals(a.plus(b)));
    //add two polys that are one node each and have different powers, first is higher degree
    int[] p1array = {1,3};
    Polynomial p1 = new Polynomial(p1array);
    Polynomial p1a = (1,0);
    Polynomial p1b = (3,2);
    assertTrue(p1.equals(p1b.plus(p1a)));
    //add two polys that are one node each and have different powers, first is lower degree
    assertTrue(p1.equals(p1a.plus(p1b)));
    //add two polys that include a diff # of nodes where first poly is shorter and higher degree
    int[] lowparray = {1,2,2};
    Polynomial low = new Polynomial(lowparray);
    int[] combarray = {3,2,2,1,1};
    Polynomial plowcomb = new Polynomial(combarray);
    assertTrue(plowcomb.equals(p1.plus(low)));
    //add two polys that include a diff # of nodes where first poly is shorter and lower degree
    int[] longArray = {3,2,2,1,1,1,2,2};
    Polynomial bigP = new Polynomial(longArray);
    assertTrue(bigP.equals(low.plus(plowcomb)));
    //add two polys that include a diff # of nodes where first poly is longer and higher degree
    asssertTrue(bigP.equals(plowcomb.plus(low)));
    //add two polys that include a diff # of nodes where first poly is longer and lower degree
    assertTrue(plowcomb.equals(low.plus(p1)));
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
