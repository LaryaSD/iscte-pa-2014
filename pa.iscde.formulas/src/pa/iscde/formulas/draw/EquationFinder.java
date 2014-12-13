package pa.iscde.formulas.draw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import pa.iscde.formulas.extensibility.DrawEquationsProvider;
import pa.iscde.formulas.util.ConstantsUtil;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;


/**
 * Class that analyses each line, and identifies the mathematical equations
 * 
 * @author Gon�alo Horta & Tiago Saraiva
 *
 */

public class EquationFinder {
	
	char aux1 = '"';
	char aux2 = '+';
	
	private Multimap<String,Integer> equations = ArrayListMultimap.create();
	private ArrayList<JavaToLatexFormat> newLatexOperations;
	private ArrayList<FormulaAnnotation> annotations = new ArrayList<FormulaAnnotation>();
	
	/**
	 * @param javaeditor 
	 * @param file, represents the open class
	 * @throws FileNotFoundException
	 */
	public EquationFinder(File file) throws FileNotFoundException {
		newLatexOperations = new ArrayList<JavaToLatexFormat>();
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		for(IExtension ext : reg.getExtensionPoint("pa.iscde.formulas.newEquationToDraw").getExtensions()) {
			for(IConfigurationElement newEquationToDraw : ext.getConfigurationElements()) {
				try {
					DrawEquationsProvider drawProviders = (DrawEquationsProvider) newEquationToDraw.createExecutableExtension("newOperation");
					newLatexOperations.add(new JavaToLatexFormat(drawProviders.setJavaOperation(), drawProviders.setOperationLatexFormat()));
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
		analyseFile(file);
	}
	
	
	private void equationAnalyse(File file) throws FileNotFoundException{
		int lines = 1;
		Scanner s = new Scanner(file);
		while(s.hasNext()){
			String line = s.nextLine();
			for (JavaToLatexFormat javaToLatexFormat : newLatexOperations) {
				if(line.contains(javaToLatexFormat.getJavaOperation())){
					String line_without_java = removeJavaPrefixs(line);
					System.out.println(line_without_java);
					equations.put(line_without_java,lines);
				}
			}
			lines++;
		}
	}
	
	

	private String removeJavaPrefixs(String line) {
		String aux ="";
		for (String javaprefix : ConstantsUtil.getJavaPrefixs()) {
			aux = line.replace(javaprefix, "");
		}
		return aux;
	}


	private void analyseFile(File file) throws FileNotFoundException {
		int lines = 1;
		int offset=0;
		int i=0;
		Scanner s = new Scanner(file);
		while(s.hasNext()){
			String line = s.nextLine();
			for (JavaToLatexFormat javaToLatexFormat : newLatexOperations) {
				if(line.contains(javaToLatexFormat.getJavaOperation())){
					equations.put(transformJavaLatext(delimitateLine(removeA(frac(line))),javaToLatexFormat.getJavaOperation(),javaToLatexFormat.getOperationLatexFormat()),lines);
					i++;
				}
			}
			
			
//			if(line.contains("/") || line.contains("Math.sqrt") || line.contains("Math.pow") || line.contains("*")){
//				equations.put(delimitateLine(removeA(frac(line))),lines);
//				annotations.add(new FormulaAnnotation("Formula "+i,offset,line.length()));
//			}
			
			
			offset+=(line.length()+1);
			lines++;
		}
		s.close();
	}
	
	public ArrayList<FormulaAnnotation> getAnnotations(){
		return annotations;
	}
	
	private String removeA(String str){
		String aux = str;
		aux = aux.replace(" ", "");

		boolean copy = false;
		String finalStr = "";

		for (int i = 0; i < aux.length()-1; i++) {
			char currentChar = aux.charAt(i);
			char nextChar = aux.charAt(i+1);

			if(currentChar == '+' && nextChar == '"'){
				copy = false;
			} else if(currentChar == '"' && nextChar == '+'){
				copy = false;
			} else {
				if(copy){
					finalStr += currentChar;
				}

				if(!copy){
					copy = true;
				}
			}
		}
		return finalStr;
	}

	private String delimitateLine(String line) {
		//x = (-b+(Math.sqrt(root)))/(2*a); ----> x = \\frac{-b+\\sqrt{root}}{2*a}
		String result = line.replace("(", "{").replace(")","}").replace("String", "").replace("int", "").replace(Character.toString(aux1), "").replace(";","").replace("return", "").replace("and", "").replace("Math.PI", "\\pi");
		return convertMath(result);
	}
	
	private String convertMath(String line) {
		String result = line;
		if(line.contains("Math.sqrt")){
			result = result.replace("Math.sqrt", "\\sqrt");
		}
		if(line.contains("Math.pow")){
			result = convertPow(line);
		}
		return result;
	}
	
	private String transformJavaLatext(String line, String java , String latex){
		return line.replace(java, latex);
	}

	private String convertPow(String line) {
		String aux = line.replace("Math.pow", "");
		String result = aux.split(",")[0]+"^"+aux.split(",")[1];
		return result;
	}

	public Multimap<String,Integer> getEquations(){
		return equations;
	}
	
	private static String frac(String str) {
		if(!str.contains("/"))
			return str;
		
		

		int indexOfDiv = str.indexOf("/");
		int counter = 0;
		boolean foundParenteses = false;
		int indexBeginFrac = -1;

		// Encontra inicio
		for (int i = indexOfDiv; i > 0; i--) {
			if(str.charAt(i) == ')'){
				counter++;
				foundParenteses = true;
			}

			if(str.charAt(i) == '(')
				counter--;

			if(foundParenteses && counter == 0){
				indexBeginFrac = i;
				return str.substring(0, indexBeginFrac) + "\\frac" + str.substring(indexBeginFrac, indexOfDiv) + str.substring(indexOfDiv + 1, str.length());
			}
			
			
		}
		return str;
			
	}
	

}