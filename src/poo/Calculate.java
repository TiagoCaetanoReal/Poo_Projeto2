package poo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * @author Tiago Caetano, ISMAT
 * @author Francisco Vicente, ISMAT
 * @version JDK 11.0.13
 */
public class Calculate {
	ArrayList<HashMap<String, String>> queryTable = new ArrayList<>();
	Map<String, String> dictionary = new HashMap<String, String>();
	String filtration;
	String agregation;
	double resultado;

	/*
	 * contrutor primario da classe, no qual não é necessario o uso do dicionario
	 * 
	 * @param agregation string que contem o operador de agregacao a ser usado
	 * 
	 * @param filtration string que contem o operador de filtragem a ser usado
	 * 
	 * @param queryTable arrayList com toda a tabela a ser usada
	 */
	Calculate(String agregation, String filtration, ArrayList<HashMap<String, String>> queryTable) {
		this.queryTable = queryTable;
		this.agregation = agregation;
		this.filtration = filtration;
		determineFiltration();
		determineAgregation();
	}

	/*
	 * contrutor secundario da classe, para o caso de ser necessario o uso do
	 * dicionario
	 * 
	 * @param agregation string que contem o operador de agregacao a ser usado
	 * 
	 * @param filtration string que contem o operador de filtragem a ser usado
	 * 
	 * @param queryTable arrayList com toda a tabela a ser usada
	 * 
	 * @param dictionary map com a indicaçao do tipo primitivo de cada coluna
	 */
	Calculate(String agregation, String filtration, ArrayList<HashMap<String, String>> queryTable,
			Map<String, String> dictionary) {
		this.queryTable = queryTable;
		this.dictionary = dictionary;
		this.agregation = agregation;
		this.filtration = filtration;
		determineFiltration();
		determineAgregation();
	}

	/*
	 * getter e setters
	 */
	ArrayList<HashMap<String, String>> getQueryTable() {
		return this.queryTable;
	}

	private void setQueryTable(ArrayList<HashMap<String, String>> queryTable) {
		this.queryTable = queryTable;
	}

	Map<String, String> getDictionary() {
		return this.dictionary;
	}

	private void setDictionary(Map<String, String> dictionary) {
		this.dictionary = dictionary;
	}

	String getAgregation() {
		return this.agregation;
	}

	void setAgregation(String agregation) {
		this.agregation = agregation;
	}

	String getFiltration() {
		return this.filtration;
	}

	void setFiltration(String filtration) {
		this.filtration = filtration;
	}

	double getResultado() {
		return this.resultado;
	}

	void setResultado(double resultado) {
		this.resultado = resultado;
	}

	/*
	 * metodo para identificar qual o operador de filtragem que será usado, e de
	 * seguida instância-lo
	 */
	void determineFiltration() {
		String[] expressionFiltration = getFiltration().split("\\(");

		All all = null;
		Filter filter = null;

		if (expressionFiltration[0].equalsIgnoreCase("All")) {
			all = new All(getQueryTable());
			setQueryTable(all.getQueryTable());
		} else if (expressionFiltration[0].equalsIgnoreCase("Filter")) {
			expressionFiltration[expressionFiltration.length
					- 1] = expressionFiltration[expressionFiltration.length - 1].substring(0,
							expressionFiltration[expressionFiltration.length - 1].length() - 1);

			String[] expression = expressionFiltration[1].split(" ");

			filter = new Filter(getQueryTable(), expression);
			setQueryTable(filter.getResultingTable());
		}
	}

	/*
	 * metodo para identificar qual o operador de agregaçao que será usado, e de
	 * seguida instância-lo
	 */
	void determineAgregation() {
		String[] expressionAgregation = getAgregation().split("\\(");
		expressionAgregation[expressionAgregation.length - 1] = expressionAgregation[expressionAgregation.length - 1]
				.substring(0, expressionAgregation[expressionAgregation.length - 1].length() - 1);

		if (expressionAgregation[0].equalsIgnoreCase("Average")) {
			Average average = null;
			average = new Average(expressionAgregation[1], getQueryTable(), getDictionary());
			setResultado(average.getAverageResult());
		} else if (expressionAgregation[0].equalsIgnoreCase("DistinctCount")) {
			DistinctCount distinctCount = null;
			distinctCount = new DistinctCount(expressionAgregation[1], getQueryTable());
			setResultado(distinctCount.getContagemDistinta());
		} else if (expressionAgregation[0].equalsIgnoreCase("CountRows")) {
			CountRows countRows = null;
			countRows = new CountRows(getQueryTable());
			setResultado(countRows.getNumberLines());
		} else if (expressionAgregation[0].equalsIgnoreCase("Sum")) {
			Sum sum = null;
			sum = new Sum(expressionAgregation[1], getQueryTable(), getDictionary());
			setResultado(sum.getResultadoSoma());
		}
	}
}
