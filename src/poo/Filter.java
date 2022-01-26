package poo;

import java.util.*;

/*
 * @author Tiago Caetano, ISMAT
 * @author Francisco Vicente, ISMAT
 * @version JDK 11.0.13
 */
public class Filter implements Cloneable {
	ArrayList<HashMap <String , String>> resultingTable = new ArrayList<>();
	ArrayList<HashMap <String , String>> queryTable = new ArrayList<>();
	String[] expression;
	
	/*
	 * contrutor da classe
	 * @param queryTable arrayList com toda a tabela a ser usada
	 * @param expression String array que contem a operacao logica ou relacional a ser estudada
	 */
	Filter(ArrayList<HashMap <String , String>> querryTable, String[] expression){
		this.queryTable = querryTable;
		this.expression = expression;
		filtrar();
	}
	
	/*
	 * getters e setters
	 */
	ArrayList<HashMap <String , String>> getResultingTable() { return this.resultingTable;}
	private void setResultingTable(ArrayList<HashMap <String , String>> resultingTable) { this.resultingTable=resultingTable;}
	
	ArrayList<HashMap <String , String>> getQueryTable() { return this.queryTable;}
	private void setQueryTable(ArrayList<HashMap <String , String>> queryTable) { this.queryTable=queryTable;}
	
	String[] getExpression() { return this.expression;}
	private void setExpression(String[] expression) { this.expression = expression;}
	
	/*
	 * metodo para determinar o numero de condições
	 */
	void filtrar(){
		if(getExpression().length == 3){
			relational(getExpression()[1], 1);
		}
		else if(getExpression().length == 7){
			logical();
		}
	}
	
	/*
	 * metodo para determinar a operação a realizar
	 */
	void relational(String expression, int index){
		switch(expression) {
		case "==":
			equal(index);
			break;
		case "!=":
			notEqual(index);
		    break;
		case "<":
			minor(index);
			break;
		case ">":
			bigger(index);
			break;
		case "<=":
			minorEqual(index);
			break;
		case ">=":
			biggerEqual(index);
			break;
		}
	}
	
	/*
	 * metodo para realizar a união ou interseção das arrayList na arrayList resultingTable.
	 */
	void logical() {
		HashSet<String> distinctRows = new HashSet<>();

		
		relational(getExpression()[1], 1);
		ArrayList<HashMap <String , String>>  helpingTable = (ArrayList<HashMap <String , String>>)getResultingTable().clone();
		resultingTable.clear();

		relational(getExpression()[5], 5);
		ArrayList<HashMap <String , String>>  helpingTable2 = (ArrayList<HashMap <String , String>>)getResultingTable().clone();	
		resultingTable.clear();
		
		if(getExpression()[3].equals("||")) {
			for (HashMap<String, String> element : helpingTable)
				if (!resultingTable.contains(element)) 
					resultingTable.add(element);
		
			for (HashMap<String, String> element : helpingTable2)
				if (!resultingTable.contains(element)) 
					resultingTable.add(element);
		}
		else if(getExpression()[3].equals("&&")) {
			for(int i = 0; i < helpingTable2.size(); i++) {
				for(int j = 0; j < helpingTable.size(); j++) {
					if(helpingTable2.get(i).get("RowNumber").equals(helpingTable.get(j).get("RowNumber"))) {
						resultingTable.add(helpingTable2.get(i));
						continue;
					}
				}
			}
		}
	}
	
	/*
	 * metodo para verificar se cada linha da tabela é igual ao valor indicado
	 * @param index da posicao do operador relacional
	 */
	void equal(int index) {
		for(int i = 0 ; i < getQueryTable().size();i++) 
			if(getQueryTable().get(i).get(getExpression()[index-1]).equals(getExpression()[index+1]))
				resultingTable.add(getQueryTable().get(i));
	}
	
	/*
	 * metodo para verificar se cada linha da tabela é menor ao valor indicado
	 * @param index da posicao do operador relacional
	 */
	void minor(int index){
		for(int i = 0 ; i < getQueryTable().size();i++)
			if(Double.parseDouble(getQueryTable().get(i).get(getExpression()[index-1])) < Double.parseDouble(getExpression()[index+1]))
				resultingTable.add(getQueryTable().get(i));
	}
	
	/*
	 * metodo para verificar se cada linha da tabela é maior ao valor indicado
	 * @param index da posicao do operador relacional
	 */
	void bigger(int index){
		for(int i = 0 ; i < getQueryTable().size();i++)
			if(Double.parseDouble(getQueryTable().get(i).get(getExpression()[index-1])) > Double.parseDouble(getExpression()[index+1]))
				resultingTable.add(getQueryTable().get(i));
	}
	
	/*
	 * metodo para verificar se cada linha da tabela não é igual ao valor indicado
	 * @param index da posicao do operador relacional
	 */
	void notEqual(int index){
		for(int i = 0 ; i < getQueryTable().size();i++) 
			if(!(getQueryTable().get(i).get(getExpression()[index-1]).equals(getExpression()[index+1])))
				resultingTable.add(getQueryTable().get(i));
	}
	
	/*
	 * metodo para verificar se cada linha da tabela é menor ou igual ao valor indicado
	 * @param index da posicao do operador relacional
	 */
	void minorEqual(int index){
		for(int i = 0 ; i < getQueryTable().size();i++)
			if(Double.parseDouble(getQueryTable().get(i).get(getExpression()[index-1])) <= Double.parseDouble(getExpression()[index+1]))
				resultingTable.add(getQueryTable().get(i));
	}
	
	/*
	 * metodo para verificar se cada linha da tabela é maior ou igual ao valor indicado
	 * @param index da posicao do operador relacional
	 */
	void biggerEqual(int index){
		for(int i = 0 ; i < getQueryTable().size();i++)
			if(Double.parseDouble(getQueryTable().get(i).get(getExpression()[index-1])) >= Double.parseDouble(getExpression()[index+1]))
				resultingTable.add(getQueryTable().get(i));
	}
}
