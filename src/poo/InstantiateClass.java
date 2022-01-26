package poo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * @author Tiago Caetano, ISMAT
 * @author Francisco Vicente, ISMAT
 * @version JDK 11.0.13
 */
public class InstantiateClass {
	Map<String, String> dictionary = new HashMap<String, String>();
	ArrayList<HashMap <String , String>> table = new ArrayList<>();
	String[] filteredQuery;
	
	/*
	 * contrutor da classe
	 * @param table tabela do ficheiro csv
	 * @param filteredQuery input do utilizador já filtrado
	 * @param dictionary map onde estam listadas todas as colunas do csv e é dito qual o tipo primitivo usado nela
	 */
	public InstantiateClass(ArrayList<HashMap<String, String>> table, String[] filteredQuery, Map<String, String> dictionary) {
		this.table = table;
		this.filteredQuery = filteredQuery;
		this.dictionary = dictionary;
		determineClass();
	}
	/*
	 * getter e setters
	 */
	String[] getFilteredQuery() { return this.filteredQuery;}
	private void serFilteredQuery(String[] filteredQuery) { this.filteredQuery=filteredQuery;}
	
	ArrayList<HashMap <String , String>> getTable() { return this.table;}
	private void setTable(ArrayList<HashMap <String , String>> table) { this.table=table;}
	
	Map <String , String> getDictionary() { return this.dictionary;}
	private void setDictionary(HashMap <String , String> dictionary) { this.dictionary=dictionary;}
	
	/*
	 * metodo usado para instanciar a classe da primeira opcao de filtragem ou agregaçao usada
	 */
	void determineClass() {
		String[] filteration;

		if(getFilteredQuery()[0].equalsIgnoreCase("Filter")) {
			filteration = filterExpression();
			
			Filter filter = new Filter(getTable(),  filteration);
			for(HashMap<String, String> filteredTable : filter.getResultingTable())
				System.out.println(filteredTable);
		}
		else if(getFilteredQuery()[0].equalsIgnoreCase("Calculate")) {
			String[] filterAndAgregate = calculateExpression();
			
			Calculate calculate = new Calculate(filterAndAgregate[0], filterAndAgregate[1], getTable(), getDictionary());
			System.out.println("Output:\n" + calculate.getResultado());
		}
		else if(getFilteredQuery()[0].equalsIgnoreCase("All")){
			All all = new All(getTable());
			System.out.print("Output:\n" + all.getQueryTable());
		}
		else if(getFilteredQuery()[0].equalsIgnoreCase("CountRows")) {
			CountRows countRows;
			
			if(getFilteredQuery()[1].equalsIgnoreCase("Filter")) {
				filteration = filterExpression(); 
				countRows = new CountRows(new Filter(getTable(), filteration));
			}
			else
				countRows = new CountRows(getTable());
			
			System.out.println("Output:\n" + countRows.getNumberLines());
		}
		else if(getFilteredQuery()[0].equalsIgnoreCase("DistinctCount")) {
			DistinctCount distinctCount = new DistinctCount(getFilteredQuery()[2],getTable());
			System.out.println("Output:\n" + distinctCount.getContagemDistinta());
		}
		
		else if(getFilteredQuery()[0].equalsIgnoreCase("Average")) {
			Average average = new Average(getFilteredQuery()[1], getTable(), getDictionary());
			System.out.println("Output:\n" + String.format("%.1f", average.getAverageResult()));	
		}
		
		else {
			Sum sum = new Sum(getFilteredQuery()[1], getTable(), getDictionary());
			System.out.println("Output:\n" + String.format("%.1f", sum.getResultadoSoma()));
		}
	}
	
	/*
	 * metodo para executar um novo polimento no input, porém desta vez, moldando-o para a classe Calculate
	 * 
	 * @return filterAndAgregate que é um array com duas posiçoes primeira para a string da agregacao e a segunda para a filtragem
	 */
	String[] calculateExpression() {
		String filteration = "";
		String agregation = "";
		
		for(int i = 1; i < 3; i++) {
			if(i == 1)
				agregation = agregation.concat(getFilteredQuery()[i] + "(");
			else if(i == 2)
				agregation = agregation.concat(getFilteredQuery()[i] + ")");
			else
				agregation = agregation.concat(getFilteredQuery()[i] + " ");
		}
		
		for(int i = 3; i < getFilteredQuery().length; i++) {
			if(i == 3 && !(getFilteredQuery()[3].equalsIgnoreCase("all")))
				filteration = filteration.concat(getFilteredQuery()[i] + "(");
			else if(i == getFilteredQuery().length-1 && !(getFilteredQuery()[3].equalsIgnoreCase("all")))
				filteration = filteration.concat(getFilteredQuery()[i] + ")");
			else
				filteration = filteration.concat(getFilteredQuery()[i] + " ");
		}
		
		String[] filterAndAgregate = {agregation, filteration};
		return filterAndAgregate;
	}
	/*
	 * metodo para executar um novo polimento no input, porém desta vez, moldando-o para a classe Filter
	 * @return filteration que é um array onde sera colocado todos os elementos de filteredQuery menos o conteudo indesejado
	 */
	String[] filterExpression() {
		ArrayList<String> tempArray = new ArrayList<>();
		String[] filteration = {};
		
		for(int i = 1; i < getFilteredQuery().length; i++)
			if(!(getFilteredQuery()[i].equalsIgnoreCase("Filter")))
				tempArray.add(getFilteredQuery()[i]);
		
		filteration = new String[tempArray.size()];
		filteration = tempArray.toArray(filteration);
		
		return filteration;
	}
}