package cs2s03;
class Minus extends Expr { // NOT BinaryOp!
  Expr left;
  Expr right;

  // Since minus is not commutative, this is an expression, not a binaryOp. Order definitely matters
  // when it comes to subtraction.

  Minus(Expr x, Expr y) { left = x; right = y; }
  public String toString() { 
    return betweenParens(left) + "-" + betweenParens(right); }
  
  
  
  public boolean isGround() { return false; }

  @Override
  //Evaluate to Integer
public int evalToInt() throws NotAnInteger,NotANumber{
	try{
		//Parses both left and right side of the operation to an integer
	int l = Integer.parseInt(left.toString());
	int r = Integer.parseInt(right.toString());
	
	//Creates doubles of the left and right side of operation
	double leftSide = Double.parseDouble(left.toString());
	double rightSide = Double.parseDouble(right.toString());
	double lid = l;
	double rid = r;
	//Error catch
	if (leftSide != lid || rightSide != rid){throw new NotAnInteger("Error, minus");}
	//Returns subtracted values
	else return l - r;
	
	} catch (NumberFormatException e) {
		try{
			//Creates parsed doubles
		double ld = Double.parseDouble(left.toString());
		double rd = Double.parseDouble(right.toString());
		throw new NotAnInteger("Error, minus");
			
		//Switches the mode to integer and creates a new intval - IntegerValue of both left and right side
		}catch (NumberFormatException e1){
			Evaluate leftEval = new Evaluate(left.toString(),Mode.INTEGER);
			IntVal newIntVal = new IntVal();
			Value valLeft = leftEval.eval();
			newIntVal = (IntVal) valLeft;
			
			Evaluate rightEval = new Evaluate(right.toString(),Mode.INTEGER);
			IntVal rightVal = new IntVal();
			rightVal = (IntVal) rightEval.eval();
			//returns subtracted value
			return newIntVal.val-rightVal.val;
		} 
	}
}

  @Override
  //Evaluate to Float
public double evalToFloat() throws NotAnInteger, NotANumber {
	  //Parses left and right side of operation to doubles
	  try{double ld = Double.parseDouble(left.toString());
	  double rd = Double.parseDouble(right.toString());
	  return ld - rd;}
	  
	  catch (NumberFormatException e){
		  
		  //Switches mode to float and parses left and right double
		  Evaluate leftEval = new Evaluate(left.toString(),Mode.FLOAT);
			DblVal newVal1 = new DblVal();
			Value newVal2 = leftEval.eval();
			newVal1 = (DblVal) newVal2;
			
			Evaluate rightEval = new Evaluate(right.toString(),Mode.FLOAT);
			DblVal newVal3 = new DblVal();
			newVal3 = (DblVal) rightEval.eval();
			
			//returns subtracted value
			return newVal1.val-newVal3.val;
	  }
}
}
