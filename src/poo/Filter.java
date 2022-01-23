package poo;

import java.util.*;

public class Filter implements Cloneable {
	ArrayList<HashMap <String , String>> resultingTable = new ArrayList<>();
	ArrayList<HashMap <String , String>> queryTable = new ArrayList<>();
	String[] expression;
	
	
	Filter(ArrayList<HashMap <String , String>> querryTable, String[] expression){
		this.queryTable = querryTable;
		this.expression = expression;
		filtrar();
			
		for(int i = 0 ; i < resultingTable.size();i++)
			System.out.println(resultingTable.get(i));
	}
	
	
	ArrayList<HashMap <String , String>> getResultingTable() { return this.resultingTable;}
	private void setResultingTable(ArrayList<HashMap <String , String>> resultingTable) { this.resultingTable=resultingTable;}
	
	ArrayList<HashMap <String , String>> getQueryTable() { return this.queryTable;}
	private void setQueryTable(ArrayList<HashMap <String , String>> queryTable) { this.queryTable=queryTable;}
	
	String[] getExpression() { return this.expression;}
	private void setExpression(String[] expression) { this.expression = expression;}
	
	
	void filtrar(){
		if(getExpression().length == 3){
			conditions(getExpression()[1], 1);
		}
		else if(getExpression().length == 7){
			andOr();
		}
	}
	
	
	void conditions(String expression, int index){
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
	void andOr() {
		HashSet<String> distinctRows = new HashSet<>();
		
		conditions(getExpression()[1], 1);
		ArrayList<HashMap <String , String>>  helpingTable = (ArrayList<HashMap <String , String>>)getResultingTable().clone();
		resultingTable.clear();

		conditions(getExpression()[5], 5);
		ArrayList<HashMap <String , String>>  helpingTable2 = (ArrayList<HashMap <String , String>>)getResultingTable().clone();	
		resultingTable.clear();
		
		if(getExpression()[3].equals("||")) {
			ArrayList<HashMap <String , String>> helpingTable3 = new ArrayList<>();
			for(int i = 0; i < getQueryTable().size(); i++) {
				if(!(helpingTable2.get(i).get("RowNumber").equals(helpingTable.get(i).get("RowNumber")))) {
					resultingTable.add(helpingTable2.get(i));
					resultingTable.add(helpingTable.get(i));
					
					distinctRows.add(helpingTable2.get(i).get("RowNumber"));
					distinctRows.add(helpingTable.get(i).get("RowNumber"));
					//for (String element : distinctRows) {
						//if(!(resultingTable.get(i).get("RowNumber").equals(element))) {
							
							//System.out.println(helpingTable2.get(i).get("RowNumber")+" "+(helpingTable.get(i).get("RowNumber")));
						//}
					//}
					//}//for(int g = 0; g < resultingTable.size(); g++) {
					
					//System.out.println(helpingTable2.get(i).get("RowNumber")+" "+(helpingTable.get(i).get("RowNumber")));
					//System.out.println(resultingTable.get(i));
				}
				else if((helpingTable2.get(i).get("RowNumber").equals(helpingTable.get(i).get("RowNumber")))) {
					//System.out.println(helpingTable2.get(i).get("RowNumber")+" "+(helpingTable.get(i).get("RowNumber")));
					distinctRows.add(helpingTable.get(i).get("RowNumber"));
					resultingTable.add(helpingTable2.get(i));
				}
			}
			
			for (String element : distinctRows) {
				for(int i = 0; i < getQueryTable().size(); i++){
					if(!(getResultingTable().get(i).containsValue(element))) {
							//.get("RowNumber").equals(element))) {
						//System.out.println(helpingTable2.get(i).get("RowNumber")+" "+(helpingTable.get(i).get("RowNumber")));
						helpingTable3.add(getResultingTable().get(i));
					}
				}
			}
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
	
	void equal(int index) {
		for(int i = 0 ; i < getQueryTable().size();i++) 
			if(getQueryTable().get(i).get(getExpression()[index-1]).equals(getExpression()[index+1]))
				resultingTable.add(getQueryTable().get(i));
	}
	void minor(int index){
		for(int i = 0 ; i < getQueryTable().size();i++)
			if(Double.parseDouble(getQueryTable().get(i).get(getExpression()[index-1])) < Double.parseDouble(getExpression()[index+1]))
				resultingTable.add(getQueryTable().get(i));
	}
	void bigger(int index){
		for(int i = 0 ; i < getQueryTable().size();i++)
			if(Double.parseDouble(getQueryTable().get(i).get(getExpression()[index-1])) > Double.parseDouble(getExpression()[index+1]))
				resultingTable.add(getQueryTable().get(i));
	}
	void notEqual(int index){
		for(int i = 0 ; i < getQueryTable().size();i++) 
			if(!(getQueryTable().get(i).get(getExpression()[index-1]).equals(getExpression()[index+1])))
				resultingTable.add(getQueryTable().get(i));
	}
	void minorEqual(int index){
		for(int i = 0 ; i < getQueryTable().size();i++)
			if(Double.parseDouble(getQueryTable().get(i).get(getExpression()[index-1])) <= Double.parseDouble(getExpression()[index+1]))
				resultingTable.add(getQueryTable().get(i));
	}
	void biggerEqual(int index){
		for(int i = 0 ; i < getQueryTable().size();i++)
			if(Double.parseDouble(getQueryTable().get(i).get(getExpression()[index-1])) >= Double.parseDouble(getExpression()[index+1]))
				resultingTable.add(getQueryTable().get(i));
	}
	
	
}
