package cs2s03;

// Notice that BinaryOp extends expression, even though you would think it's an operation
// BinaryOp still returns an expression at the end of the day
abstract class BinaryOp extends Expr {

  // Since Binary Operations require two Expressions, we need 2 fields
  Expr left;
  Expr right;
  /* this is different: it asks for a context, and an op */
  // Also, this toString is not the same as the abstract one from Expr. See how the Plus
  // class uses it.
  // Also note that the ? operator works as follows if isSame() is true do left.toString() otherwise do
  // betweenParens
  public String toString(BinaryOp b, String op) { 
  	// This line checks to see if the expression on the left is of type Times, and will call toString()
  	// if it is, otherwise call betweenParens.
    String l = (b.isSame(left)) ? left.toString() : betweenParens(left);
    String r = (b.isSame(right)) ? right.toString() : betweenParens(right);
    return l + op + r; }
  
  //EvalToInt takes in an operation and string 
  public int evalToInt(BinaryOp b, String op) throws NotAnInteger, NotANumber{
	  try{
	  String l = (b.isSame(left)) ? left.toString() : betweenParens(left);
	  String r = (b.isSame(right)) ? right.toString() : betweenParens(right);  
	  
	  //Parses the left side of the operation and the right side of the operation
	  int leftSide = Integer.parseInt(l);
	  int rightSide = Integer.parseInt(r);
	  
	  	//Plus Operation
	    if (op == "+") return leftSide + rightSide;
	    
	    //Multiplication Operation
	    else if (op == "*") return leftSide * rightSide;
	    else return (Integer) null;

	    //Catching for Number Format Exception and evaluates the left/right side
	  } catch (NumberFormatException d){
		  Evaluate left1 = new Evaluate(left.toString(),Mode.INTEGER);
			IntVal newInt = new IntVal();
			Value leftVal = left1.eval();
			newInt = (IntVal) leftVal;
			
			Evaluate rightVal = new Evaluate(right.toString(),Mode.INTEGER);
			IntVal a = new IntVal();
			a = (IntVal) rightVal.eval();
			
			if (op == "+") return newInt.val + a.val;
		    else if (op == "*") return newInt.val * a.val;
		    else return (Integer) null;
	  }
  }
  
  //EvalTo Float
  public double evalToFloat(BinaryOp b, String op) throws NotAnInteger, NotANumber{
	  try{
	  String k = (b.isSame(left)) ? left.toString() : betweenParens(left);
	  String r = (b.isSame(right)) ? right.toString() : betweenParens(right);  
	  
	  //Parses the left/right side
	  double li = Double.parseDouble(k);
	  double lr = Double.parseDouble(r);
	  
	  //Plus Operation
	  if (op == "+") return li + lr;
	  
	  //Multiplication Operation
	  else if (op == "*") return li *lr;
	  else return (Double) null;}
	  
	  
	  catch (NumberFormatException e){
		  
		  //Takes the left side and creates a new double value
		  Evaluate leftSide = new Evaluate(left.toString(),Mode.FLOAT);
			DblVal newDouble = new DblVal();
			Value b1 = leftSide.eval();
			newDouble = (DblVal) b1;
			
			// Takes the right side and creates a new "DblVal"
			Evaluate rightSide = new Evaluate(right.toString(),Mode.FLOAT);
			DblVal a = new DblVal();
			a = (DblVal) rightSide.eval();
			
			// Plus Operation
			if (op == "+") return newDouble.val + a.val;
			
			//Multiplication Operation
			  else if (op == "*") return newDouble.val *a.val;
			  else return (Double) null;
	  }
  }
	
  
  public boolean isGround() { return false; }
  abstract public boolean isSame(Expr e);
}
