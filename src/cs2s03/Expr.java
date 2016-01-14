package cs2s03;
/* 
 * - The expression class represnts the concept of a mathematical expression
 * - Since it is abstract it cannot be instantiated as an object
 * - Note that it can have functionality on it's own
 *  - In other words abstract classes can actually have methods with functionality
 *  - This is unlike interfaces, which cannot have their own functionality
 *
 * - Note that mathematically an expression can be composed of other expressions
*/

abstract class Expr {
  // Any class that extends Expr must implement these abstract methods
  abstract public String toString();
  abstract public boolean isGround();

  // Notice that Expr actually has methods that do something, it's because they aren't
  // abstract
  static void print(Expr e) { System.out.println(e.toString()); }

  // This prints the value of Expr, with parentheses about it.

  // betweenParens will keep going until it finally hits ground terms. It does this by continually
  // calling toString, which then calls betweenParens again, but this time being closer to ground terms.
  // Since each time a binaryOp calls bewteenParens it's on the left and right side, you will eventually reach
  // Ground terms.
  static String betweenParens(final Expr e) {
    return (e.isGround()) ? e.toString() : "(" + e.toString() + ")"; }

  public static void main(String[] args) {
    String s1 = "2+(3*7)*(5/3)-2";
    Parser p = new Parser(s1);
    CalculatorFrame x = new CalculatorFrame();
    try {
      // It is important to note that expr e5 could be an integer or binaryOp as well, since they extend 
      // Expr.
      Expr e5 = p.parse();
      print(e5);
    } catch (ParseError e) {
      System.out.println(e);
    }
  }
  
  abstract public int evalToInt() throws NotAnInteger, NotANumber;
  
  abstract public double evalToFloat() throws NotAnInteger, NotANumber;
  
}
