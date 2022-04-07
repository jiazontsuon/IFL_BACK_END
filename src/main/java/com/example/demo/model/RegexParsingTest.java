package com.example.demo.model;


public class RegexParsingTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String relationRegex = Model.EnumerateElemRegex(Model.relationMappings.keySet());
		String universalRegex = Model.EnumerateElemRegex(Model.universalList);
		RegexParser RP = new RegexParser(relationRegex,universalRegex);
		// test 1 
		String testStr1 = "A(x/) E(y/x) P(x,4) V R(y,3)";
		ExprStructure es1 = RP.Parse(testStr1);
		System.out.println(es1);
		
		String testStr2 = " E(y/x,y,z) P(x,4) V R(y,3)";
		ExprStructure es2 = RP.Parse(testStr2);
		System.out.println(es2);
		
		String testStr3 = "P(x,4) V ¬R(y,3)";
		ExprStructure es3 = RP.Parse(testStr3);
		System.out.println(es3);
		
		String testStr4 = "¬Equal(1,2)";
		ExprStructure es4 = RP.Parse(testStr4);
		System.out.println(es4);
		
		String testStr5 = "P(x,4) V A(y/q,w,e) R(y,3)";
		ExprStructure es5= RP.Parse(testStr5);
		System.out.println(es5);
		
		String testStr6 = "P(x,4) V (R(1,2) V R(y,3))";
		ExprStructure es6= RP.Parse(testStr6);
		System.out.println(es6);
		
		String testStr7 = "P(x,4) V R(1,2)V R(1,2)V R(1,2)V R(1,2)V R(1,2)&R(y,3)";
		ExprStructure es7= RP.Parse(testStr7);
		System.out.println(es7);
		
		String testStr8 = "P(x,4) V R(1,2)V R(1,2)V (E(x/t,y)R(1,2))V (R(1,2)V R(1,2)&R(y,3))";
		ExprStructure es8= RP.Parse(testStr8);
		System.out.println(es8);
		
		String testStr9 = "P(x,4) V R(1,2)V R(1,2)V (E(x/t,y)R(1,2))";
		ExprStructure es9= RP.Parse(testStr9);
		System.out.println(es9);
		
		String testStr10 = " A(x/)R(1,2)V R(1,2)V (E(x/t,y)R(1,2))";
		ExprStructure es10= RP.Parse(testStr10);
		System.out.println(es10);
		
		String testStr11 = "((P(u) & Q(w)) > (Q(v) & P(x) & ((Equal(u,x) > Equal(v,w)) & (Equal(v,w) > Equal(u,x)))))";
		ExprStructure es11= RP.Parse(testStr11);
		System.out.println(es11);
		
		String testStr12 = "¬((Equal(x,y)) > (  A(x/) Equal(u,v)))";
		ExprStructure es12= RP.Parse(testStr12);
		System.out.println(es12);
		
		String testStr13 = " (E(y/x) Equal(x,y)) V (E(z/x) Equal(x,z)) V (E(e/x) Equal(x,e))";
		ExprStructure es13= RP.Parse(testStr13);
		System.out.println(es13);
	}

}