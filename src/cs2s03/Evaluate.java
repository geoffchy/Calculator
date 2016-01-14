package cs2s03;

public class Evaluate {
	private Expr e;
	private Mode m;
	
	Evaluate (String s, Mode m){
		Parser p = new Parser(s);
	    try {
	      e = p.parse();
	    } catch (ParseError e) {
	      System.out.println(e);
	    }
	    
	    this.m = m;
	}
	
	public Value eval() throws NotAnInteger, NotANumber{
		//Switches of cases Integer and Float
		switch (m) {
			case INTEGER:
				IntVal res = new IntVal();
				res.val = e.evalToInt();
				res.m = m;
				return res;
			
			case FLOAT:
				DblVal result = new DblVal();
				result.val = e.evalToFloat();
				return result;
		}
		return null;
        }
	
}
