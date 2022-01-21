package poo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Filter {
	ArrayList<HashMap <String , String>> resultingTable = new ArrayList<>();
	ArrayList<HashMap <String , String>> queryTable = new ArrayList<>();
	String[] expression;
	
	
	Filter(ArrayList<HashMap <String , String>> querryTable, String[] expression){
		this.queryTable = querryTable;
		this.expression = expression;
		conditions(getExpression()[1]);
	}
		ArrayList<HashMap <String , String>> getResultingTable() { return this.resultingTable;}
	private void setResultingTable(ArrayList<HashMap <String , String>> resultingTable) { this.resultingTable=resultingTable;}
	
	ArrayList<HashMap <String , String>> getQueryTable() { return this.queryTable;}
	private void setQueryTable(ArrayList<HashMap <String , String>> queryTable) { this.queryTable=queryTable;}
	
	String[] getExpression() { return this.expression;}
	private void setExpression(String[] expression) { this.expression = expression;}
	
	void conditions(String expression){
		switch(expression) {
		case "==":
			equal();
			break;
		case "!=":
			notEqual();
		    break;
		case "<":
			minor();
			break;
		case ">":
			bigger();
			break;
		case "<=":
			minorEqual();
			break;
		case ">=":
			biggerEqual();
			break;
		}
	}
	
	void equal() {
		for(int i = 0 ; i < getQueryTable().size();i++) {
			if(getQueryTable().get(i).get(getExpression()[0]).equals(getExpression()[2]))
				resultingTable.add(getQueryTable().get(i));
		}
	}
	void minor(){
		for(int i = 0 ; i < getQueryTable().size();i++){
			if(Double.parseDouble(getQueryTable().get(i).get(getExpression()[0])) < Double.parseDouble(getExpression()[2]))
				resultingTable.add(getQueryTable().get(i));
		}
	}
	void bigger(){
		for(int i = 0 ; i < getQueryTable().size();i++){
			if(Double.parseDouble(getQueryTable().get(i).get(getExpression()[0])) > Double.parseDouble(getExpression()[2]))
				resultingTable.add(getQueryTable().get(i));
		}
	}
	void notEqual() {
		for(int i = 0 ; i < getQueryTable().size();i++) {
			if(!(getQueryTable().get(i).get(getExpression()[0]).equals(getExpression()[2])))
				resultingTable.add(getQueryTable().get(i));
		}
	}
	void minorEqual(){
		for(int i = 0 ; i < getQueryTable().size();i++){
			if(Double.parseDouble(getQueryTable().get(i).get(getExpression()[0])) <= Double.parseDouble(getExpression()[2]))
				resultingTable.add(getQueryTable().get(i));
		}
	}
	void biggerEqual(){
		for(int i = 0 ; i < getQueryTable().size();i++){
			if(Double.parseDouble(getQueryTable().get(i).get(getExpression()[0])) >= Double.parseDouble(getExpression()[2]))
				resultingTable.add(getQueryTable().get(i));
		}
	}
}
