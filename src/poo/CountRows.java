package poo;

import java.util.*;

public class CountRows {
	ArrayList<HashMap <String , String>> queryTable = new ArrayList<>();
	int numberLines;

	CountRows(ArrayList<HashMap <String , String>> querryTable){
		this.queryTable = querryTable;
		setNumberLines(queryTable.size());
	}

	ArrayList<HashMap <String , String>> getQueryTable() { return this.queryTable;}
	private void setQueryTable(ArrayList<HashMap <String , String>> queryTable) { this.queryTable=queryTable;}
	
	int getNumberLines() { return this.numberLines;}
	private void setNumberLines(int numberLines) { this.numberLines = numberLines;}
}
