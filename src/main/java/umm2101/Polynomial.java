package umm2101;

// The two students who worked on this file are Daniel and Connor
// Students will implement equals for Node & minus and evaluate for Polynomial
/******************************************************************************
  * 
  * http://introcs.cs.princeton.edu/java/92symbolic/LinkedPolynomial.java.html
  * Which I will rename as Polynomial. I also removed some functionality that I 
  * won't require you to look at or implement. -KK
  * 
  *  Compilation:  javac Polynomial.java
  *  Execution:    java Polynomial
  *
  *  A polynomial with integer coefficients and exponents, implemented
  *  using an approach similar to a linked list.
  *
  *  % java Polynomial
  *  zero(x) =     0x^0
  *  p(x) =        4x^3 + 3x^2 + 2x^1 + 1x^0
  *  q(x) =        3x^2 + 5x^0
  *  p(x) + q(x) = 4x^3 + 6x^2 + 2x^1 + 6x^0
  *  p(x) * q(x) = 12x^5 + 9x^4 + 26x^3 + 18x^2 + 10x^1 + 5x^0
  *  0 - p(x)    = -4x^3 - 3x^2 - 2x^1 - 1x^0
  *  p(3)        = 142
  *
 ******************************************************************************/

public class Polynomial {
    private Node first = new Node(0, 0);  // sentinel
    private Node last  = first;

    private static class Node {
        int coef;
        int exp;
        Node next;
        Node(int coef, int exp) {
            this.coef = coef;
            this.exp  = exp;
        }
        boolean equals(Node other) {
          //***************implement equals for nodes***************
          if(this.coef == other.coef | this.exp == other.exp){
            return true;
          }
          return false;
          }
          //return false; //this is here so that something happens
        }
    

    // 0    
    //this just gives each thing its default value, so no need to actually assign values
    private Polynomial() { }

    // a * x^b
    public Polynomial(int coef, int exp) {
        last.next = new Node(coef, exp);
        last = last.next;
    }
    
    // an array of coef is given
    // for example, {23, 5, 6, 0, 2}, and the coefficients are for x^arrayindex
    // so, 2x^4 + 6x^2 + 5x^1 + 23x^0
    public Polynomial(int[] coef) {
      for (int exp=coef.length-1; exp>=0; exp--) {
        if (coef[exp] != 0) {
          last.next = new Node(coef[exp], exp);
          last = last.next;
        }
      }
    }

    // return c = a + b
    public Polynomial plus(Polynomial b) {
        Polynomial a = this;
        Polynomial c = new Polynomial();
        Node x = a.first.next;
        Node y = b.first.next;
        while (x != null || y != null) {
            Node t = null;
            if      (x == null)     { t = new Node(y.coef, y.exp);  y = y.next; }
            else if (y == null)     { t = new Node(x.coef, x.exp);  x = x.next; }
            else if (x.exp > y.exp) { t = new Node(x.coef, x.exp);  x = x.next; } 
            else if (x.exp < y.exp) { t = new Node(y.coef, y.exp);  y = y.next; } 

            else {
                int coef = x.coef + y.coef;
                int exp  = x.exp;
                x = x.next;
                y = y.next;
                if (coef == 0) continue;
                t = new Node(coef, exp);
            }
        
            c.last.next = t;
            c.last = c.last.next;
        }
        return c;
    }

    // return c = a * b
    public Polynomial times(Polynomial b) {
        Polynomial a = this;
        Polynomial c = new Polynomial();
        for (Node x = a.first.next; x!= null; x = x.next) {
            Polynomial temp = new Polynomial();
            for (Node y = b.first.next; y!= null; y = y.next) {
                temp.last.next = new Node(x.coef * y.coef, x.exp + y.exp);
                temp.last = temp.last.next;
            }
            c = c.plus(temp);
        }
        return c;
    }
    
    // return c = a - b
    //************You will implement minus - please try to use test-driven development***
    public Polynomial minus(Polynomial b) {
        Polynomial a = this;
        Polynomial c = new Polynomial();
        return c;
    }
    
    // evaluate the polynomial for a specific x value
    //************You will implement evaluate - please try to use test-driven development***
    public int evaluate(int num) {
      int total = 0;
      for (int i = this.exp; i >= 0; i--)
          total = i.coef + (num * total);
      return total;
    }

    public boolean equals(Polynomial other) {
      Node x = this.first.next;
      Node y = other.first.next;
      while (x != null || y != null) {
        if (!x.equals(y)){
          return false;
        }
        if (x == null || y == null) {
          return false;
        }
        x = x.next;
        y = y.next;
      }
      return true;
    }
    
    // convert to string representation
    public String toString() {
        String s = "";
        for (Node x = first.next; x != null; x = x.next) {
            if      (x.coef > 0) s = s + " + " +   x.coef  + "x^" + x.exp;
            else if (x.coef < 0) s = s + " - " + (-x.coef) + "x^" + x.exp;
        }
        return s;
    }

    // ******This may help you write your tests, but you should remove the main method
    // the provided test client
    public static void main(String[] args) { 
        Polynomial zero = new Polynomial(0, 0);

        Polynomial p1   = new Polynomial(4, 3);
        Polynomial p2   = new Polynomial(3, 2);
        Polynomial p3   = new Polynomial(1, 0);
        Polynomial p4   = new Polynomial(2, 1);
        Polynomial p    = p1.plus(p2).plus(p3).plus(p4);   // + 4x^3 + 3x^2 + 2x^1 + 1x^0
        
        int[] parray = {1, 2, 3, 4};
        Polynomial pOther = new Polynomial(parray);        // + 4x^3 + 3x^2 + 2x^1 + 1x^0

        Polynomial q1   = new Polynomial(3, 2);
        Polynomial q2   = new Polynomial(5, 0);
        Polynomial q    = q1.plus(q2);                     // + 3x^2 + 5x^0

        Polynomial r    = p.plus(q);
        Polynomial s    = p.times(q);
        System.out.println("zero(x) =     " + zero);
        System.out.println("p(x) =        " + p);
        System.out.println("p(x) =        " + pOther);
        System.out.println("q(x) =        " + q);
        System.out.println("p(x) + q(x) = " + r);
        System.out.println("p(x) * q(x) = " + s);
        System.out.println("0 - p(x)    = " + zero.minus(p));
        System.out.println("p(3)        = " + p.evaluate(3));
   }

}
