package cs2s03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cs2s03.DblVal;
import cs2s03.Divide;
import cs2s03.Evaluate;
import cs2s03.Expr;
import cs2s03.IntVal;
import cs2s03.Integer2;
import cs2s03.Minus;
import cs2s03.Mode;
import cs2s03.NotAnInteger;
import cs2s03.Plus;
import cs2s03.Times;
import cs2s03.UnaryMinus;

public class A5Testing {


	@Test
	public void test0() throws NotAnInteger, NotANumber {
		Expr test1 = new Plus(new Integer2(1), new Integer2(2));
		assertEquals(test1.evalToInt(),3);
		assertEquals(test1.evalToFloat(),3.0,0);
	}
	
	@Test 
	public void test1() throws NotAnInteger,  NotANumber{
		Expr test = new Minus(new Integer2(3), new Integer2(2));
		assertEquals(test.evalToInt(),1);
		assertEquals(test.evalToFloat(),1.0,0);
	}
	
	@Test
	public void test2() throws NotAnInteger,  NotANumber{
		Expr test = new Times(new Integer2(4), new Integer2(4));
		assertEquals(test.evalToInt(),16);
		assertEquals(test.evalToFloat(),16.0,0);
	}
	
	@Test
	public void test3() throws NotAnInteger,  NotANumber{
		Expr test = new Divide(new Integer2(4), new Integer2(4));
		assertEquals(test.evalToInt(),1);
		assertEquals(test.evalToFloat(),1.0,0);
	}
	
	@Test 
	public void test4() throws NotAnInteger, NotANumber{
		Expr test = new UnaryMinus(new Integer2(5));
		assertEquals(test.evalToInt(),-5);
		assertEquals(test.evalToFloat(),-5.0,0);
	}
	
	@Test (expected = NotANumber.class)
	public void test7() throws NotAnInteger,  NotANumber {
		Expr test = new Divide (new Integer2(1),new Integer2(2));
		assertEquals(test.evalToInt(),5);		
	}
	
	@Test  
	public void test8() throws NotAnInteger,  NotANumber{
		Expr test = new Times (new Integer2(3),new Integer2(2));
		assertEquals(test.evalToFloat(),6.0,0);	
	}
	@Test 
	public void test9() throws NotAnInteger, NotANumber{
		Expr test = new Minus (new Integer2(1),new Divide(new Integer2(3),new Integer2(2)));//,new Integer2(2));
		assertEquals(test.evalToFloat(),-0.5,0);
	}
	
	@Test (expected = NullPointerException.class)
	public void test10() throws NotAnInteger,  NotANumber{		
		Evaluate a = new Evaluate("adsfadsf",Mode.INTEGER);
		IntVal b = new IntVal();
		b = (IntVal) a.eval();
		assertEquals(b.val,-2);
	}
	
	@Test
	public void test11() throws NotAnInteger,  NotANumber{
		Evaluate test1 = new Evaluate("2+4",Mode.INTEGER);
		IntVal result = new IntVal();
		result = (IntVal) test1.eval();
		assertEquals(result.val, 6);
	}
	@Test
	public void test12() throws NotAnInteger,  NotANumber{
		Evaluate test1 = new Evaluate("2+4",Mode.FLOAT);
		DblVal result = new DblVal();
		result = (DblVal) test1.eval();
		assertEquals(result.val, 6.0,0);
	}
	
	@Test
	public void test13() throws NotAnInteger,  NotANumber{
		Evaluate test = new Evaluate("(2+4)*2",Mode.INTEGER);
		IntVal result = new IntVal();
		result = (IntVal) test.eval();
		assertEquals(result.val,12);
	}
	
	@Test
	public void test14() throws NotAnInteger,  NotANumber{
		Evaluate test = new Evaluate("(4-(-2))/2",Mode.INTEGER);
		IntVal result = new IntVal();
		result = (IntVal) test.eval();
		assertEquals(result.val,3);
	}
	
	@Test 
	public void test15() throws NotAnInteger,  NotANumber{		
		Evaluate a = new Evaluate("1+2)",Mode.INTEGER);
		IntVal b = new IntVal();
		b = (IntVal) a.eval();
		assertEquals(b.val,3);
	}
}
