package poo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Calculate {
	ArrayList<HashMap <String , String>> queryTable = new ArrayList<>();
	String filtragem;
	String agregacao;
	int resultado;

	
	Calculate(String agregacao, String filtragem, ArrayList<HashMap <String , String>> queryTable){
		this.agregacao = agregacao;
		this.filtragem = filtragem;
		this.queryTable = queryTable;
		determineFiltration();
		determineAgregation();
	}
	
	ArrayList<HashMap <String , String>> getQueryTable() { return this.queryTable;}
	private void setQueryTable(ArrayList<HashMap <String , String>> queryTable) { this.queryTable=queryTable;}
	
	
	String getAgregacao() {return this.agregacao;}
	void setAgregacao(String agregacao) {this.agregacao = agregacao;}
	

	String getFiltragem() {return this.filtragem;}
	void setFiltragem(String filtragem) {this.filtragem = filtragem;}

	int getResultado() {return this.resultado;}
	void setResultado(int resultado) {this.resultado = resultado;}
	
	void determineFiltration() {
		All all = null; 
		
		if(getFiltragem().equalsIgnoreCase("All"))
			all = new All(getQueryTable());
			setQueryTable(all.getQueryTable());
	}
	
	void determineAgregation() {
		//antes -> DISTINCTCOUNT(Geography)
		String[] n = getAgregacao().split("\\(");
		n[n.length-1] =  n[n.length-1].substring (0, n[n.length-1].length() - 1);
		//depois -> n[0] = DISTINCTCOUNT , n[1] = Geography
		
		DistinctCount distinctCount = null;
		
		if(n[0].equalsIgnoreCase("DistinctCount")) {
			distinctCount = new DistinctCount(n[1], getQueryTable());
			setResultado(distinctCount.getContagemDistinta());
		}	
		else if(n[0].equalsIgnoreCase("DistinctCount")) {
			distinctCount = new DistinctCount(n[1], getQueryTable());
			setResultado(distinctCount.getContagemDistinta());
		}
	}

}
