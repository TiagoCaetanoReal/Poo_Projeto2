package poo;

import java.util.*;

/*
 * @author Tiago Caetano, ISMAT
 * @author Francisco Vicente, ISMAT
 * @version JDK 11.0.13
 */
public class DistinctCount {
	ArrayList<HashMap <String , String>> queryTable = new ArrayList<>();
	int contagemDistinta;
	String coluna;
	
	/*
	 * contrutor primario da classe, no qual não é necessario o uso do dicionario
	 * @param agregation string que contem o operador de agregacao a ser usado 
	 * @param filtration string que contem o operador de filtragem a ser usado 
	 * @param queryTable arrayList com toda a tabela a ser usada
	 */
	DistinctCount(String coluna, Filter filter){
		this.coluna = coluna;
		this.queryTable = filter.getResultingTable();
		distinctCount();
	}
	
	DistinctCount(String coluna, ArrayList<HashMap <String , String>> querryTable){
		this.queryTable = querryTable;
		this.coluna = coluna;
		distinctCount();
	}
	
	/*
	 * getters e setters
	 */
	String getColuna() { return this.coluna;}
	private void setColuna(String coluna) { this.coluna = coluna;}
	
	ArrayList<HashMap <String , String>> getQueryTable() { return this.queryTable;}
	private void setQueryTable(ArrayList<HashMap <String , String>> queryTable) { this.queryTable=queryTable;}
	
	int getContagemDistinta() { return this.contagemDistinta;}
	private void setContagemDistinta(int contagemDistinta) { this.contagemDistinta = contagemDistinta;}
	
	
	/*
	 * metodo para 
	 */
	void distinctCount(){
		Collection<String> tabela = new ArrayList<String>(); 
		Set<String> distinct = new HashSet<String>();
		
		for(int i = 0 ; i < getQueryTable().size();i++) {
			tabela.add(getQueryTable().get(i).get(coluna));
		}
		
		for(String tabelinha: tabela) {
			if(!distinct.add(tabelinha));
		}
		setContagemDistinta(distinct.size());
	}
}	

