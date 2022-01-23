package poo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Calculate {
	ArrayList<HashMap <String , String>> queryTable = new ArrayList<>();
	Map<String, String> dictionary = new HashMap<String, String>();
	String filtration;
	String agregation;
	double resultado;
	
	Calculate(String agregation, String filtration, ArrayList<HashMap <String , String>> queryTable){
		this.queryTable = queryTable;
		this.agregation = agregation;
		this.filtration = filtration;
		determineFiltration();
		determineAgregation();
	}
	
	Calculate(String agregation, String filtration, ArrayList<HashMap <String , String>> queryTable, Map<String, String> dictionary){
		this.queryTable = queryTable;
		this.dictionary = dictionary;
		this.agregation = agregation;
		this.filtration = filtration;
		determineFiltration();
		determineAgregation();
	}
	
	ArrayList<HashMap <String , String>> getQueryTable() { return this.queryTable;}
	private void setQueryTable(ArrayList<HashMap <String , String>> queryTable) { this.queryTable=queryTable;}

	Map<String, String> getDictionary() { return this.dictionary;}
	private void setDictionary(Map<String, String> dictionary) { this.dictionary=dictionary;}
	
	String getAgregation() {return this.agregation;}
	void setAgregation(String agregation) {this.agregation = agregation;}
	

	String getFiltration() {return this.filtration;}
	void setFiltration(String filtration) {this.filtration = filtration;}

	double getResultado() {return this.resultado;}
	void setResultado(double resultado) {this.resultado = resultado;}
	
	void determineFiltration() {
		String[] expressionFiltration = getFiltration().split("\\(");
		
		All all = null; 
		Filter filter = null;
		
		if(expressionFiltration[0].equalsIgnoreCase("All")) {
			all = new All(getQueryTable());
			setQueryTable(all.getQueryTable());
		}
		else if(expressionFiltration[0].equalsIgnoreCase("Filter")) {
			expressionFiltration[expressionFiltration.length-1] = 
					expressionFiltration[expressionFiltration.length-1].substring (0, expressionFiltration[expressionFiltration.length-1].length() - 1);
			
			String[] expression = expressionFiltration[1].split(" ");
			
			filter = new Filter(getQueryTable(), expression);
			setQueryTable(filter.getResultingTable());
		}
	}
	
	void determineAgregation() {
		//antes -> DISTINCTCOUNT(Geography)
		String[] expressionAgregation = getAgregation().split("\\(");
		expressionAgregation[expressionAgregation.length-1] =  
				expressionAgregation[expressionAgregation.length-1].substring (0, expressionAgregation[expressionAgregation.length-1].length() - 1);
		//depois -> n[0] = DISTINCTCOUNT , n[1] = Geography
		
		DistinctCount distinctCount = null;
		CountRows countRows = null;
		Average average = null;
		Sum sum = null;
		
		if(expressionAgregation[0].equalsIgnoreCase("Average")) {
			average = new Average(expressionAgregation[1], getQueryTable(), getDictionary());
			setResultado(average.getAverageResult());
		}	
		else if(expressionAgregation[0].equalsIgnoreCase("DistinctCount")) {
			distinctCount = new DistinctCount(expressionAgregation[1], getQueryTable());
			setResultado(distinctCount.getContagemDistinta());
		}
		else if(expressionAgregation[0].equalsIgnoreCase("CountRows")) {
			countRows = new CountRows(getQueryTable());
			setResultado(countRows.getNumberLines());
		}
		else if(expressionAgregation[0].equalsIgnoreCase("Sum")) {
			sum = new Sum(expressionAgregation[1], getQueryTable(), getDictionary());
			setResultado(sum.getResultadoSoma());
		}
	}

}
