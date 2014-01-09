/*
 * Copyright (c) 2011, Hien Quoc Dang, TU Darmstadt, dangquochien@gmail.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the University nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDER(s) AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT HOLDER(s) OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *
 */
package de.tudarmstadt.dvs.ukuflow.script.eventbasescript.expression.sef;

import de.tudarmstadt.dvs.ukuflow.script.UkuConstants;
import de.tudarmstadt.dvs.ukuflow.script.eventbasescript.visitor.EventBaseVisitor;

/**
 * @author Dang Quoc Hien
 *
 */
public abstract class sef_binary_exp extends sef_expression{
	private sef_expression left, right;
	
	public abstract byte getOperator();
	
	public sef_binary_exp(){
		// nothing
	}
	public sef_binary_exp(sef_expression l, sef_expression r){
		this.left = l;
		this.right = r;
	}
	/**
	 * @return the left
	 */
	public sef_expression getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(sef_expression left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public sef_expression getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(sef_expression right) {
		this.right = right;
	}
	public void accept(EventBaseVisitor visitor){
		visitor.visit(this);
	}
	
	public String toString(){
		String st = "";
		st += " " + left.toString();
		switch (getOperator()) {
			case UkuConstants.OperatorConstants.OPERATOR_ADD: st += " +";break;
			case UkuConstants.OperatorConstants.OPERATOR_DIV: st += " /";break;
			case UkuConstants.OperatorConstants.OPERATOR_MOD: st += " %";break;
			case UkuConstants.OperatorConstants.OPERATOR_MULT: st += " *";break;
			case UkuConstants.OperatorConstants.OPERATOR_SUB: st += " -";break;
			case UkuConstants.OperatorConstants.OPERATOR_AND: st += " &&";break;
			case UkuConstants.OperatorConstants.OPERATOR_OR: st += " ||";break;
			case UkuConstants.OperatorConstants.PREDICATE_EQ: st += " ==";break;
			case UkuConstants.OperatorConstants.PREDICATE_GET: st += " >=";break;
			case UkuConstants.OperatorConstants.PREDICATE_GT: st += " >";break;
			case UkuConstants.OperatorConstants.PREDICATE_LET: st += " <=";break;
			case UkuConstants.OperatorConstants.PREDICATE_LT: st += " <";break;
			case UkuConstants.OperatorConstants.PREDICATE_NEQ: st += " !=";break;
		}
		st += " "+right.toString();
		return st;
	}
}
