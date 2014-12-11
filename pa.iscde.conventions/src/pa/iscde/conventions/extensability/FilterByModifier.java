package pa.iscde.conventions.extensability;

import org.eclipse.jdt.core.dom.Modifier;


public interface FilterByModifier {

	/**	Utiliza a class Modifier do java para filtrar os m�todos a que o utilizador quer verificar
	 * 	para tal � necess�rio utilizar mesmo o Modifier do java pois com este � que conseguimos filtar por
	 * 	private, public, protected, synchronized,etc.
	 * @param modifier- representa o modificador de m�todo que o utilizador vai escolher
	 * 
	 * Exemplo
	 * public class testeMetodo implements FilterByModifier{

		@Override
		public int verificarModificadorMetodo() {
		return Modifier.PRIVATE;
			}
		}
	 * 
	 */


	public int verificarModificadorMetodo();



}
