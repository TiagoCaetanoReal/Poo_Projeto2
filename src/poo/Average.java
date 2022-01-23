package poo;

import java.util.*;

public class Average {
	ArrayList<HashMap <String , String>> queryTable = new ArrayList<>();
	Map<String, String> dictionary = new HashMap<String, String>();
	double averageResult;
	String coluna;
	
	Average(String coluna, Filter filter, Map<String, String> dictionary){
		this.coluna = coluna;
		this.queryTable = filter.getResultingTable();
		this.dictionary = dictionary;
		averageValue();
	}
	
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
		Sum sumValues = new Sum(coluna, queryTable, dictionary);
		setAverageResult(sumValues.getResultadoSoma()/getQueryTable().size());
		
	}
}	
