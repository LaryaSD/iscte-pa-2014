package pa.iscde.conventions.extensability;

import pa.iscde.conventions.Cobject;


public interface ConventionService {
	
	
	/**
	 * Utiliza a conven��o que a equipa deseja.
	 * 
	 * @param name - ID(Nome) do que vai ser verificado.
	 * @param to - Tipo de Enumerado definido pelo TyeOf (M�todo, Classe, Constantes, Enumerados).
	 * @return Cobject - Um objecto do tipo de conven��o que recebe um Aviso e uma Conven��o
	 */
	public Cobject verificarConvencao(String name, TypeOf to);
	
	
}
