package cs2s03;
class Plus extends BinaryOp {
  Plus(Expr x, Expr y) { left = x; right = y; }
  public String toString() { 
    // we are the context
    return super.toString(this, "+"); }
  public boolean isSame(Expr e) { return e instanceof Plus; }
  
@Override
//Evaluate to integer returns plus
public int evalToInt() throws NotAnInteger,NotANumber {
	return super.evalToInt(this, "+");
}

@Override
//Evaluate to Float returns plus
public double evalToFloat() throws NotAnInteger,NotANumber {
	return super.evalToFloat(this, "+");
}
}
