package poo;

import java.util.*;

public class CountRows {
	ArrayList<HashMap <String , String>> queryTable = new ArrayList<>();
	int numbLines;

	CountRows(ArrayList<HashMap <String , String>> querryTable){
		this.queryTable = querryTable;
		numbRows();
	}

	ArrayList<HashMap <String , String>> getQueryTable() { return this.queryTable;}
	private void setQueryTable(ArrayList<HashMap <String , String>> queryTable) { this.queryTable=queryTable;}
	
	int getNumbLines() { return this.numbLines;}
	private void setNumbLines(int numbLines) { this.numbLines = numbLines;}
	
	void numbRows() {
		//numbLines = queryTable.size();
		setNumbLines(queryTable.size());
	}
}
