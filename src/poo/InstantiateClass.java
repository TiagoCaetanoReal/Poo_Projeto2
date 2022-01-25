package poo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InstantiateClass {
	Map<String, String> dictionary = new HashMap<String, String>();
	ArrayList<HashMap <String , String>> table = new ArrayList<>();
	String[] filteredQuery;
	

	public InstantiateClass(ArrayList<HashMap<String, String>> table, String[] filteredQuery, Map<String, String> dictionary) {
		this.table = table;
		this.filteredQuery = filteredQuery;
		this.dictionary = dictionary;
		determineClass();
	}

	
	String[] getFilteredQuery() { return this.filteredQuery;}
	private void serFilteredQuery(String[] filteredQuery) { this.filteredQuery=filteredQuery;}
	
	ArrayList<HashMap <String , String>> getTable() { return this.table;}
	private void setTable(ArrayList<HashMap <String , String>> table) { this.table=table;}
	
	Map <String , String> getDictionary() { return this.dictionary;}
	private void setDictionary(HashMap <String , String> dictionary) { this.dictionary=dictionary;}
	
	
	void determineClass() {
		if(getFilteredQuery()[0].equalsIgnoreCase("Filter")) {
			
			//Filter f = new Filter(tabela, array);
			//setTabelaModificada(f.resultingTable);
			
			/*for(int i = 0 ; i < getTabelaModificada().size();i++) {
				System.out.println(getTabelaModificada().get(i));
			}*/		
			
			Filter filter = new Filter(getTable(),  getFilteredQuery());
		}
		else if(getFilteredQuery()[0].equalsIgnoreCase("Calculate")) {
			String filteration = "";
			String agregation = "";
			
			//for(String g:  getFilteredQuery())
				//System.out.println(g);
			
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

			//System.out.println(agregation + " " + filteration);
			
			Calculate cal = new Calculate(agregation, filteration, getTable());
			//Calculate cal = new Calculate("DISTINCTCOUNT(Geography)", "Filter(Age == 18 && IsActiveMember == 1)", tabela);
			
			//Calculate calculate = new Calculate(getTable(),  getFilteredQuery());
		}
		else if(getFilteredQuery()[0].equalsIgnoreCase("All")) {
			
			 
		  	/*All a = new All(tabela);
			tabela = a.getQueryTable();
			System.out.print(tabela.get(0));*/
			
			//All filter = new All(getTable();
		}
		else if(getFilteredQuery()[0].equalsIgnoreCase("CountRows")) {
			/*CountRows r = new CountRows(new Filter(tabela, array));
			int b = r.getNumberLines();
			System.out.print(b);*/

			//CountRows a = new CountRows(tabela);
			//int d = a.getNumberaLines();
			//System.out.print(d);
			
			//CountRows filter = new CountRows(getTable(),  getFilteredQuery());
		}
		else if(getFilteredQuery()[0].equalsIgnoreCase("Average")) {
			
			/*Average h = new Average("Tenure", tabela, dataTypeDictionary);
			int b = h.getAverageResult();
			System.out.println(b);*/
			
			//Average filter = new Average(getTable(),  getFilteredQuery());
		}
		else if(getFilteredQuery()[0].equalsIgnoreCase("DistinctCount")) {
			//DistinctCount a = new DistinctCount(conteudoColuna[4],tabela);
			//int d = a.getContagemDistinta();
			//System.out.print(d);
			
			//DistinctCount filter = new DistinctCount(getTable(),  getFilteredQuery());
		}
		else {
			

			/*Sum a = new Sum("Balance", tabela, dataTypeDictionary);
			double d = a.getResultadoSoma();
			System.out.println(String.format("%.1f", d));*/
			
			Sum filter = new Sum(getFilteredQuery()[1], getTable(), getDictionary());
		}
	}
}
