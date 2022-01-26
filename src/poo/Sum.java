package poo;

import java.util.*;

/*
 * @author Tiago Caetano, ISMAT
 * @author Francisco Vicente, ISMAT
 * @version JDK 11.0.13
 */
public class Sum {
	ArrayList<HashMap<String, String>> queryTable = new ArrayList<>();
	Map<String, String> dictionary = new HashMap<String, String>();
	double resultadoSoma;
	String coluna;

	/*
	 * contrutor primario da classe, para caso seja necessario o uso do Filter
	 * 
	 * @param coluna string que contem o coluna pela qual sera feita a soma
	 * 
	 * @param filter objeto da classe filter que retorna uma tabela filtrada
	 * 
	 * @param dictionary map com a indicaçao do tipo primitivo da coluna
	 */
	Sum(String coluna, Filter filter, Map<String, String> dictionary) {
		this.queryTable = filter.getResultingTable();
		this.dictionary = dictionary;
		this.coluna = coluna;
		sumValues();
	}

	/*
	 * contrutor secundario da classe, para caso não seja necessario usar a classe
	 * Filter
	 * 
	 * @param coluna string que contem o coluna pela qual sera feita a soma
	 * 
	 * @param querryTable arrayList de HashMap que contem todo o conteudo do csv
	 * 
	 * @param dictionary map com a indicaçao do tipo primitivo da coluna
	 */
	Sum(String coluna, ArrayList<HashMap<String, String>> querryTable, Map<String, String> dictionary) {
		this.queryTable = querryTable;
		this.dictionary = dictionary;
		this.coluna = coluna;
		sumValues();
	}

	/*
	 * getters e setters
	 */
	String getColuna() {
		return this.coluna;
	}

	private void setColuna(String coluna) {
		this.coluna = coluna;
	}

	ArrayList<HashMap<String, String>> getQueryTable() {
		return this.queryTable;
	}

	private void setQueryTable(ArrayList<HashMap<String, String>> queryTable) {
		this.queryTable = queryTable;
	}

	double getResultadoSoma() {
		return this.resultadoSoma;
	}

	private void setResultadoSoma(double resultadoSoma) {
		this.resultadoSoma = resultadoSoma;
	}

	Map<String, String> getDictionary() {
		return this.dictionary;
	}

	private void setDictionary(Map<String, String> dictionary) {
		this.dictionary = dictionary;
	}

	/*
	 * metodo onde será realizada a soma de todos os valores pertencetes a uma
	 * coluna da tabela dada, somentes valores do tipo int ou double são somadoss
	 */
	void sumValues() {
		if (getDictionary().get(coluna) == "INT" || getDictionary().get(coluna) == "DOUBLE") {
			for (int i = 0; i < getQueryTable().size(); i++) {
				setResultadoSoma(getResultadoSoma() + Double.parseDouble(getQueryTable().get(i).get(coluna)));
			}
		} else
			System.out.println("Can't calculate this type of data");
	}
}
