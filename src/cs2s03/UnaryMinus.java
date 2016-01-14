package cs2s03;
class UnaryMinus extends Expr {
  Expr e;

  UnaryMinus(Expr x) { e = x; }
  public String toString() { return "-" + e.toString(); }
  public boolean isGround() { return false; }
  
@Override

//Evaluate to Integer
public int evalToInt() throws NotAnInteger, NotANumber{
	try{
		//Takes the value, parses it to an integer and returns the negative
		int li = Integer.parseInt(e.toString());
		return -1*li;
	} catch (NumberFormatException f){
		try{
			double rd = Double.parseDouble(e.toString());
			throw new NotAnInteger("minus");
			
		}catch (NumberFormatException f1){
			Evaluate leftEval = new Evaluate(e.toString(),Mode.INTEGER);
			IntVal newIntVal = new IntVal();
			Value b1 = leftEval.eval();
			newIntVal = (IntVal) b1;
			
			return -newIntVal.val;
		} 
	}
}

@Override
// Takes the input, changes it to a double and returns the negative
public double evalToFloat() {
	double leftSide = Double.parseDouble(e.toString());
	return leftSide*-1.0;
}

}
