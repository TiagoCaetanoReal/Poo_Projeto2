package poo;

import java.util.ArrayList;
import java.util.HashMap;

public class Average {
	String coluna;
	ArrayList<HashMap <String , String>> queryTable = new ArrayList<>();
	int resultadoSoma;
	
	Average(String coluna, ArrayList<HashMap <String , String>> querryTable){
		this.coluna = coluna;
		this.queryTable = querryTable;
		sumValues();
	}
	
	String getColuna() { return this.coluna;}
	private void setColuna(String coluna) { this.coluna = coluna;}
	
	ArrayList<HashMap <String , String>> getQueryTable() { return this.queryTable;}
	private void setQueryTable(ArrayList<HashMap <String , String>> queryTable) { this.queryTable=queryTable;}
	
	int getResultadoSoma() { return this.resultadoSoma;}
	private void setResultadoSoma(int resultadoSoma) { this.resultadoSoma = resultadoSoma;}
	
	void sumValues(){
		
		for(int i = 0 ; i < getQueryTable().size();i++) {
			//System.out.println(Integer.parseInt(getQueryTable().get(i).get(coluna)));
			setResultadoSoma(getResultadoSoma()+Integer.parseInt(getQueryTable().get(i).get(coluna)));
		}

	}
}	
