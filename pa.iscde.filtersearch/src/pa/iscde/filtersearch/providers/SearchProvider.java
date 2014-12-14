package pa.iscde.filtersearch.providers;

import java.util.List;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Image;

public interface SearchProvider {
	
	/**
	 * Consoante o texto introduzida no campo de pesquisa (a String text), ser�o devolvidos os
	 * resultados pretendidos em forma de uma lista de objectos. Esses resultados ser�o definidos
	 * pela classe que implementa a interface.
	 * @param text
	 * @return lista de resultados definidos pela classe que implementa a interface
	 */
	List<Object> getResults(String text);
	
	/**
	 * Define o �cone (do tipo Image) de um Object recebido como argumento (object). Essa atribui��o 
	 * est� a cargo da classe que implementa a interface. O �cone relativo ao projecto n�o � definido 
	 * aqui, este deve ser atribu�da aquando da extens�o ao ponto de extens�o no campo "iconName".
	 * @param object
	 * @return do icon do tipo Image referente ao object
	 */
	Image setImage(Object object);
	
	/**
	 * M�todo onde � definida ac��o a executar aquando um duplo clique no object (tipo Object) de uma
	 * referida �rvore (Treeviewer tree), ambos passados como argumentos. 
	 * @param tree
	 * @param object
	 */
	void doubleClickAction(TreeViewer tree, Object object); 
}
