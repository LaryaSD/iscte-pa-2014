package pa.iscde.formulas;


public class NewFormula extends Formula{

	private String name;
	private String[] inputs;
	private String algorithm;
	private String javacode;
	
	public NewFormula(String name, String[] inputs, String algorithm,
			String javacode) {
		this.name = name;
		this.inputs = inputs;
		this.algorithm = algorithm;
		this.javacode = javacode;
	}
	
	
	@Override
	public String[] inputs() {
		return inputs;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public String result(String[] inputs) {
		return algorithm;
	}
	
	@Override
	public String methodCode() {
		return javacode;
	}
	

}
