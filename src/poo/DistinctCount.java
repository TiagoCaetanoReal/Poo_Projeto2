package poo;

import java.util.*;

/*
 * @author Tiago Caetano, ISMAT
 * @author Francisco Vicente, ISMAT
 * @version JDK 11.0.13
 */
public class DistinctCount {
	ArrayList<HashMap<String, String>> queryTable = new ArrayList<>();
	int contagemDistinta;
	String coluna;

	/*
	 * contrutor primario da classe, para caso seja necessario o uso do Filter
	 * 
	 * @param coluna string que contem o coluna pela qual sera feita a contagem
	 * distinta
	 * 
	 * @param filter objeto da classe filter que retorna uma tabela filtrada
	 */
	DistinctCount(String coluna, Filter filter) {
		this.coluna = coluna;
		this.queryTable = filter.getResultingTable();
		distinctCount();
	}

	/*
	 * contrutor secundario da classe, para caso não seja necessario usar a classe
	 * Filter
	 * 
	 * @param coluna string que contem o coluna pela qual sera feita a contagem
	 * distinta
	 * 
	 * @param querryTable arrayList de HashMap que contem todo o conteudo do csv
	 */
	DistinctCount(String coluna, ArrayList<HashMap<String, String>> querryTable) {
		this.queryTable = querryTable;
		this.coluna = coluna;
		distinctCount();
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

	int getContagemDistinta() {
		return this.contagemDistinta;
	}

	private void setContagemDistinta(int contagemDistinta) {
		this.contagemDistinta = contagemDistinta;
	}

	/*
	 * metodo para contar o numero de valores distintos existentes numa coluna
	 * expecifica da tabela
	 */
	void distinctCount() {
		Collection<String> tabela = new ArrayList<String>();
		Set<String> distinct = new HashSet<String>();

		for (int i = 0; i < getQueryTable().size(); i++) {
			tabela.add(getQueryTable().get(i).get(coluna));
		}

		for (String tabelinha : tabela) {
			if (!distinct.add(tabelinha))
				;
		}
		setContagemDistinta(distinct.size());
	}
}
