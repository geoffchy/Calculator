package cs2s03;
class Times extends BinaryOp {
  Times(Expr x, Expr y) { left = x; right = y; }
  public String toString() { 
    // we are the context
    return super.toString(this, "*"); }

  // instanceof returns true if e is an instance of Times 
  public boolean isSame(Expr e) { return e instanceof Times; }

  @Override
  // Evaluate to Integer returns multiplication symbol
public int evalToInt() throws NotAnInteger,NotANumber {
	return super.evalToInt(this, "*");
}

  @Override
  // Evaluate to Float returns multiplication symbol
public double evalToFloat() throws NotAnInteger,NotANumber {
	return super.evalToFloat(this,"*");
}
}
