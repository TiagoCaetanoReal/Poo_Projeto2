package poo;

import java.util.*;

public class All {
	ArrayList<HashMap <String , String>> queryTable = new ArrayList<>();
	
	All(ArrayList<HashMap <String , String>> querryTable){
		this.queryTable = querryTable;
		allValues();
	}
	
	ArrayList<HashMap <String , String>> getQueryTable() { return this.queryTable;}
	private void setQueryTable(ArrayList<HashMap <String , String>> queryTable) { this.queryTable=queryTable;}
	
	void allValues() {
		getQueryTable();
	}
}
