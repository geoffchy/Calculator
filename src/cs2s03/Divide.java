package cs2s03;
class Divide extends Expr { // NOT BinaryOp!
  Expr left;
  Expr right;
  Divide(Expr x, Expr y) { left = x; right = y; }
  public String toString() { 
    return betweenParens(left) + "/" + betweenParens(right); }
  public boolean isGround() { return false; }
  
  //should throw not an int
  
  //Eval to Int
  @Override
  public int evalToInt() throws NotAnInteger, NotANumber{
	 //Parses the right and left side to integers 
	try{int li = Integer.parseInt(left.toString());
	int ri = Integer.parseInt(right.toString());
	
	//Parses left and right sides to doubles
	double ld = Double.parseDouble(left.toString());
	double rd = Double.parseDouble(right.toString());
	//Creates doubles of the first two integer values
	double lid = li;
	double rid = ri;
	if (ld != lid || rd != rid){throw new NotAnInteger("divide");}
	
	else{
	if ((li/ri)*ri == li){
		return li/ri;
	}
	else {
		throw new NotANumber("Error, div");
	}
	}
	} catch (NumberFormatException e2){
		try{
		double ld = Double.parseDouble(left.toString());
		double rd = Double.parseDouble(right.toString());
		throw new NotAnInteger("divide");
		}
		catch (NumberFormatException e3){
			Evaluate leftSide = new Evaluate(left.toString(),Mode.INTEGER);
			IntVal newIntVal = new IntVal();
			Value b1 = leftSide.eval();
			newIntVal = (IntVal) b1;
			
			Evaluate rightSide = new Evaluate(right.toString(),Mode.INTEGER);
			IntVal a = new IntVal();
			a = (IntVal) rightSide.eval();
			
			//System.out.println("left.val = " + b.val + " right.val = " + a.val);
			return newIntVal.val/a.val;
		}
	}
  }
  
  //may need to account for 1/0 and infinity, of java may do that anyway like c
  @Override
  public double evalToFloat() throws NotAnInteger, NotANumber{
	  
	  //Parses the left and right side to doubles
	  try{double ld = Double.parseDouble(left.toString());
	  double rd = Double.parseDouble(right.toString());
	  
	  if (rd == 0) throw new NotAnInteger("Not A Number");
	  return ld / rd;}
	  
	  catch (NumberFormatException e){
		  //Evaluates the left side and creates a dblval - double value
		  Evaluate leftSide = new Evaluate(left.toString(),Mode.FLOAT);
			DblVal floatVal = new DblVal();
			Value b = leftSide.eval();
			floatVal = (DblVal) b;
			
			//Evaluates the right side and creates a dblval - double value
			Evaluate rightSide = new Evaluate(right.toString(),Mode.FLOAT);
			DblVal newVal = new DblVal();
			newVal = (DblVal) rightSide.eval();
			
			//returns divided doubles
			
			return floatVal.val/newVal.val;
	  }
  }
}
  

