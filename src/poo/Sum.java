package poo;

import java.util.*;

/*
 * @author Tiago Caetano, ISMAT
 * @author Francisco Vicente, ISMAT
 * @version JDK 11.0.13
 */
public class Sum{
	ArrayList<HashMap <String , String>> queryTable = new ArrayList<>();
	Map<String, String> dictionary = new HashMap<String, String>();
	double resultadoSoma;
	String coluna;
	
	/*
	 * contrutor primario da classe, no qual não é necessario o uso do dicionario
	 * @param agregation string que contem o operador de agregacao a ser usado 
	 * @param filtration string que contem o operador de filtragem a ser usado 
	 * @param queryTable arrayList com toda a tabela a ser usada
	 */
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
	
	/*
	 * getters e setters
	 */
	String getColuna() { return this.coluna;}
	private void setColuna(String coluna) { this.coluna = coluna;}
	
	ArrayList<HashMap <String , String>> getQueryTable() { return this.queryTable;}
	private void setQueryTable(ArrayList<HashMap <String , String>> queryTable) { this.queryTable=queryTable;}
	
	double getResultadoSoma() { return this.resultadoSoma;}
	private void setResultadoSoma(double resultadoSoma) { this.resultadoSoma = resultadoSoma;}
	
	Map<String, String> getDictionary() { return this.dictionary;}
	private void setDictionary(Map<String, String> dictionary) { this.dictionary=dictionary;}
	
	/*
	 * metodo onde será realizada a soma de todos os valores pertencetes a uma coluna da tabela dada, somentes valores do tipo int ou double são somadoss
	 */
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
