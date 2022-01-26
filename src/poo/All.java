package poo;

import java.util.*;

/*
 * @author Tiago Caetano, ISMAT
 * @author Francisco Vicente, ISMAT
 * @version JDK 11.0.13
 */
public class All {
	ArrayList<HashMap<String, String>> queryTable = new ArrayList<>();

	/*
	 * contrutor da classe
	 * 
	 * @param queryTable arrayList com toda a tabela a ser usada, nest operaçao
	 */
	All(ArrayList<HashMap<String, String>> querryTable) {
		this.queryTable = querryTable;
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

}
