package pa.iscde.formulas.extensibility;

/**
 * Interface used by the extension point.
 * @author Gon�alo Horta & Tiago Saraiva
 *
 */
public interface DrawEquationsProvider {
	
	public void newEquationToDraw(String javaOperation, String operationLatexFormat);

}
