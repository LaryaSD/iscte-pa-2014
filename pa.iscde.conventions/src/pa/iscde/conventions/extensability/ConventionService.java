package pa.iscde.conventions.extensability;



public interface ConventionService {
	
	
	/**
	 * Utiliza a conven��o que a equipa deseja atrav�s da classe Cobject.
	 * 
	 * @param name - ID(Nome) do que vai ser verificado.
	 * @param typeof - Tipo de Enumerado definido pelo TypeOf (M�todo, Classe, Constantes, Enumerados).
	 * @return Cobject - Um objecto do tipo de conven��o que recebe um Aviso e uma Conven��o
	 * 
	 * Exemplo:
	 * 
	 * @Override
		public Cobject verificarConvencao(String name, TypeOf typeof) {
		return new Cobject("M�todo cont�m underscore" ,typeof.equals(TypeOf.METHOD) && name.contains("_"));
		}
	 */
	public Cobject verificarConvencao(String name, TypeOf typeof);
	
	
}
