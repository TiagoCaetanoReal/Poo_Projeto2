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
		System.out.println(diferenciado);
		int a=1;
		
		for(int i =0 ; i < getQueryTable().size();i++) {
			//System.out.println(getQueryTable().get(i).get(coluna));
			
			if(diferenciado.get(coluna)==null) {
				
				diferenciado.put(getQueryTable().get(i).get(coluna),a);	
				
			}else if(diferenciado.get(coluna)>=1){
				
				diferenciado.put(getQueryTable().get(i).get(coluna),diferenciado.get(getQueryTable().get(i).get(coluna))+ 1);	
				
			}
			for (HashMap.Entry<String, Integer> entry : diferenciado.entrySet()) {
		        String k = entry.getKey();
		        int v = entry.getValue();
		        System.out.println("Key: " + k + ", Value: " + v);
		    
			}
			
			
		}
	}
	
}
