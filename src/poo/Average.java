package poo;

import java.util.*;

public class Average {
	String coluna;
	ArrayList<HashMap <String , String>> queryTable = new ArrayList<>();
	double averageResult;
	Map<String, String> dictionary = new HashMap<String, String>();
	
	Average(String coluna, ArrayList<HashMap <String , String>> querryTable, Map<String, String> dictionary){
		this.coluna = coluna;
		this.queryTable = querryTable;
		this.dictionary = dictionary;
		averageValue();
	}
	
	String getColuna() { return this.coluna;}
	private void setColuna(String coluna) { this.coluna = coluna;}
	
	ArrayList<HashMap <String , String>> getQueryTable() { return this.queryTable;}
	private void setQueryTable(ArrayList<HashMap <String , String>> queryTable) { this.queryTable=queryTable;}
	
	double getAverageResult() { return this.averageResult;}
	private void setAverageResult(double averageResult) { this.averageResult = averageResult;}
	
	void averageValue(){
		Sum sum = new Sum(coluna, queryTable, dictionary);
		setAverageResult(sum.getResultadoSoma()/getQueryTable().size());
		
	}
}	
