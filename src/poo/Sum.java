package poo;

import java.util.*;

public class Sum{
	ArrayList<HashMap <String , String>> queryTable = new ArrayList<>();
	Map<String, String> dictionary = new HashMap<String, String>();
	double resultadoSoma;
	String coluna;
	
	Sum(String coluna, Filter filter, Map<String, String> dictionary){
		this.queryTable = filter.getResultingTable();
		this.dictionary = dictionary;
		this.coluna = coluna;
		sumValues();
	}
	
	Sum(String coluna, ArrayList<HashMap <String , String>> querryTable, Map<String, String> dictionary){
		this.queryTable = querryTable;
		this.dictionary = dictionary;
		this.coluna = coluna;
		sumValues();
	}
	
	String getColuna() { return this.coluna;}
	private void setColuna(String coluna) { this.coluna = coluna;}
	
	ArrayList<HashMap <String , String>> getQueryTable() { return this.queryTable;}
	private void setQueryTable(ArrayList<HashMap <String , String>> queryTable) { this.queryTable=queryTable;}
	
	double getResultadoSoma() { return this.resultadoSoma;}
	private void setResultadoSoma(double resultadoSoma) { this.resultadoSoma = resultadoSoma;}
	
	Map<String, String> getDictionary() { return this.dictionary;}
	private void setDictionary(Map<String, String> dictionary) { this.dictionary=dictionary;}
	
	void sumValues() {
		if(getDictionary().get(coluna) == "INT" || getDictionary().get(coluna) == "DOUBLE") {
			for(int i = 0 ; i < getQueryTable().size();i++) {
				setResultadoSoma(getResultadoSoma()+Double.parseDouble(getQueryTable().get(i).get(coluna)));
			}
		}
		else
			System.out.println("Can't calculate this type of data");
	}
}	
