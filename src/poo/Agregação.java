package poo;

import java.util.*;

public class Agregação {
	String coluna;
	ArrayList<HashMap <String , String>> queryTable = new ArrayList<>();
	
	Agregação(String coluna, ArrayList<HashMap <String , String>> querryTable){
		this.coluna = coluna;
		this.queryTable = querryTable;
	}
	
	String getColuna() { return this.coluna;}
	private void setColuna(String coluna) { this.coluna = coluna;}
	
	ArrayList<HashMap <String , String>> getQueryTable() { return this.queryTable;}
	private void setQueryTable(ArrayList<HashMap <String , String>> queryTable) { this.queryTable=queryTable;}
	
	void distinctCount(){
		HashMap <String , Integer> diferenciado = new HashMap<>();
		
		for(int i =0 ; i < getQueryTable().size();i++) {
			if(diferenciado.containsKey(getQueryTable().get(i).get(coluna)) == false){
				diferenciado.put(getQueryTable().get(i).get(coluna), 1);
			}
			else{
				diferenciado.put(getQueryTable().get(i).get(coluna), diferenciado.get(getQueryTable().get(i).get(coluna))+ 1);	
			}
			
		}
		
		/*for (HashMap.Entry<String, Integer> entry : diferenciado.entrySet()) {
		        String k = entry.getKey();
		        int v = entry.getValue();
		        if(entry.getKey().equals("15584532"))
		        	System.out.println("Key: " + k + ", Value: " + v);
		}*/
		System.out.println(diferenciado);
		
	}
}
