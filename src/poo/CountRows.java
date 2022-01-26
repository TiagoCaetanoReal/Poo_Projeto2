package poo;

import java.util.*;

/*
 * @author Tiago Caetano, ISMAT
 * @author Francisco Vicente, ISMAT
 * @version JDK 11.0.13
 */
public class CountRows {
	ArrayList<HashMap<String, String>> queryTable = new ArrayList<>();
	int numberLines;

	/*
	 * contrutor primario da classe, para caso seja necessario o uso do Filter
	 * 
	 * @param filter objeto da classe filter que retorna uma tabela
	 */
	CountRows(Filter filter) {
		this.queryTable = filter.getResultingTable();
		setNumberLines(queryTable.size());
	}

	/*
	 * contrutor secundario da classe, para caso não seja necessario usar a classe
	 * Filter
	 * 
	 * @param queryTable arrayList com toda a tabela a ser usada
	 */
	CountRows(ArrayList<HashMap<String, String>> querryTable) {
		this.queryTable = querryTable;
		setNumberLines(queryTable.size());
	}

	/*
	 * getters e setters
	 */
	ArrayList<HashMap<String, String>> getQueryTable() {
		return this.queryTable;
	}

	private void setQueryTable(ArrayList<HashMap<String, String>> queryTable) {
		this.queryTable = queryTable;
	}

	int getNumberLines() {
		return this.numberLines;
	}

	private void setNumberLines(int numberLines) {
		this.numberLines = numberLines;
	}
}
