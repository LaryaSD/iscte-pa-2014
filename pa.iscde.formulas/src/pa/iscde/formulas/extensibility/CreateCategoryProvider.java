package pa.iscde.formulas.extensibility;

/**
 * Interface that is used by the extension point createCategory to require the category name.
 * @author Gon�alo Horta & Tiago Saraiva
 *
 */
public interface CreateCategoryProvider {
	
	public String setName();

}
