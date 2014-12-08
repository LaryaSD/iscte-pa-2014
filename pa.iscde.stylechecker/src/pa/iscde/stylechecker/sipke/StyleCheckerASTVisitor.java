package pa.iscde.stylechecker.sipke;

import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

public class StyleCheckerASTVisitor extends ASTVisitor {

	private List<ImportDeclaration> importDeclarations;
	private List<TryStatement> tryStatements;
	private List<VariableDeclarationStatement> vriableDeclarationStatements;

	@Override
	public boolean visit(ImportDeclaration node) {
		importDeclarations.add(node);
		return super.visit(node);
	}

	@Override
	public boolean visit(TryStatement node) {
		tryStatements.add(node);
		return super.visit(node);
	}
	
	@Override
	public boolean visit(VariableDeclarationStatement node) {
		vriableDeclarationStatements.add(node);
		return super.visit(node);
	}

	public List<ImportDeclaration> getImportDeclarations() {
		return importDeclarations;
	}

	public List<TryStatement> getTryStatements() {
		return tryStatements;
	}

	public List<VariableDeclarationStatement> getVriableDeclarationStatements() {
		return vriableDeclarationStatements;
	}

}