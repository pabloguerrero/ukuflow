package de.tudarmstadt.dvs.ukuflow.script.expression;

import de.tudarmstadt.dvs.ukuflow.script.function.ComputationalFunction;
import de.tudarmstadt.dvs.ukuflow.script.function.LocalFunction;
import de.tudarmstadt.dvs.ukuflow.script.function.ScopeFunction;

public class ukuFlowBase64Visitor implements ScriptVisitor{
	
	public static void main(String[] args) {
		String s = "hien";
		for(Byte b : s.getBytes()){
			System.out.println(b);
		}
	}
	
	@Override
	public void visit(Constant uConstant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(UkuString uString) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(Variable uVariable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(UnaryNumericalExpression uNumExp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BinaryNumericalExpression bNumExp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ComparisonExpression compExp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BinaryLogicalExpression bLogicExp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(UnaryLogicalExpression uLogicExp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LocalFunction localF) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ScopeFunction scopeF) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ComputationalFunction computationalF) {
		// TODO Auto-generated method stub
		
	}

}
