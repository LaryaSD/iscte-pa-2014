package pa.iscde.umldiagram.utils;
import java.util.ArrayList;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.ConstructorInvocation;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.Initializer;
import org.eclipse.jdt.core.dom.MethodDeclaration;
public class UmlVisitor extends ASTVisitor{

	private ArrayList<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();
	private ArrayList<FieldDeclaration> fields = new ArrayList<FieldDeclaration>();
	
	@Override
	public boolean visit(MethodDeclaration m) {
		methods.add(m);
		return false;
	}



	@Override
	public boolean visit(FieldDeclaration f) {
		fields.add(f);
		return false;
	}

	public ArrayList<MethodDeclaration> getMethods(){
		return methods;
	}
	
	public ArrayList<FieldDeclaration> getFields(){
		return fields;
	}
}