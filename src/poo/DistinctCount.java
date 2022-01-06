package poo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DistinctCount {
	String coluna;
	ArrayList<HashMap <String , String>> queryTable = new ArrayList<>();
	int contagemDistinta;
	
	DistinctCount(String coluna, ArrayList<HashMap <String , String>> querryTable){
		this.coluna = coluna;
		this.queryTable = querryTable;
		distinctCount();
		System.out.println(contagemDistinta);
	}
	
	String getColuna() { return this.coluna;}
	private void setColuna(String coluna) { this.coluna = coluna;}
	
	ArrayList<HashMap <String , String>> getQueryTable() { return this.queryTable;}
	private void setQueryTable(ArrayList<HashMap <String , String>> queryTable) { this.queryTable=queryTable;}
	
	int getContagemDistinta() { return this.contagemDistinta;}
	private void setContagemDistinta(int contagemDistinta) { this.contagemDistinta = contagemDistinta;}
	
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
