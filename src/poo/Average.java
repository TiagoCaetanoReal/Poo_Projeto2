package poo;

import java.util.*;

/*
 * @author Tiago Caetano, ISMAT
 * @author Francisco Vicente, ISMAT
 * @version JDK 11.0.13
 */
public class Average {
	ArrayList<HashMap<String, String>> queryTable = new ArrayList<>();
	Map<String, String> dictionary = new HashMap<String, String>();
	double averageResult;
	String coluna;

	/*
	 * contrutor primario da classe, para caso seja necessario o uso do Filter
	 * 
	 * @param coluna string que contem o coluna pela qual sera feita a media
	 * 
	 * @param filter objeto da classe filter que retorna uma tabela filtrada
	 * 
	 * @param dictionary map com a indicaçao do tipo primitivo da coluna
	 */
	Average(String coluna, Filter filter, Map<String, String> dictionary) {
		this.coluna = coluna;
		this.queryTable = filter.getResultingTable();
		this.dictionary = dictionary;
		averageValue();
	}

	/*
	 * contrutor secundario da classe, para caso não seja necessario usar a classe
	 * Filter
	 * 
	 * @param coluna string que contem o coluna pela qual sera feita a media
	 * 
	 * @param querryTable arrayList de HashMap que contem todo o conteudo do csv
	 * 
	 * @param dictionary map com a indicaçao do tipo primitivo da coluna
	 */
	Average(String coluna, ArrayList<HashMap<String, String>> querryTable, Map<String, String> dictionary) {
		this.coluna = coluna;
		this.queryTable = querryTable;
		this.dictionary = dictionary;
		averageValue();
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

	double getAverageResult() {
		return this.averageResult;
	}

	private void setAverageResult(double averageResult) {
		this.averageResult = averageResult;
	}

	/*
	 * metodo onde será realizada a media de todos os valores pertencetes a uma
	 * coluna da tabela dada, é usada a class sum para somar primeiro esses valores
	 */
	void averageValue() {
		Sum sumValues = new Sum(coluna, queryTable, dictionary);
		setAverageResult(sumValues.getResultadoSoma() / getQueryTable().size());
	}
}
