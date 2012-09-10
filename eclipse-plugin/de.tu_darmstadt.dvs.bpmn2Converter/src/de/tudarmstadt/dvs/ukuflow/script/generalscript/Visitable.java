package de.tudarmstadt.dvs.ukuflow.script.generalscript;

import de.tudarmstadt.dvs.ukuflow.script.generalscript.visitor.ScriptVisitor;

/**
 * 
 * @author Hien Quoc Dang
 *
 */
public interface Visitable {
	public void accept(ScriptVisitor visitor);
	
}