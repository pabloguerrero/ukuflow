package de.tudarmstadt.dvs.ukuflow.script.eventbasescript.expression;

import de.tudarmstadt.dvs.ukuflow.script.UkuConstants;
import de.tudarmstadt.dvs.ukuflow.script.eventbasescript.visitor.EventBaseVisitor;

public class EComplexFilterUnaryExpression extends EComplexFilterExpression{
	private int operator = -1;
	private EEvaluableExpression exp;
	private String op =null;
	public EComplexFilterUnaryExpression(String op,EEvaluableExpression exp){
		this.operator = UkuConstants.getConstantWithName(op);
		this.exp = exp;
		this.op = op;
	}
	public int getOperator(){
		return operator;
	}
	
	@Override
	public void accept(EventBaseVisitor visitor) {
		// TODO Auto-generated method stub
		
	}
	public String toString(){
		return (op + exp);
	}
	
}
