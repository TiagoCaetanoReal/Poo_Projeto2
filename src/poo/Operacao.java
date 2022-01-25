package poo;

import java.io.*;
import java.util.*;

public class Operacao {
	ArrayList<HashMap <String , String>> tabelaModificada = new ArrayList<>();
	Map<String, String> dataTypeDictionary = new HashMap<String, String>();
	ArrayList<HashMap <String , String>> table = new ArrayList<>();
	String[] conteudoColuna;
	String nomeFicheiro;
	String query;
	
	Operacao(String nomeFicheiro, String query){
		this.nomeFicheiro = nomeFicheiro;
		this.query = query;
		lerFicheiro();
		variableType();
		operation();
	}
	
	String getQuery() { return this.query;}
	private void setQuery(String query) { this.query=query;}
	
	String getNomeFicheiro() { return this.nomeFicheiro;}
	private void setNomeFicheiro(String nomeFicheiro) { this.nomeFicheiro=nomeFicheiro;}
	
	ArrayList<HashMap <String , String>> getTable() { return this.table;}
	private void setTable(ArrayList<HashMap <String , String>> tabela) { this.table=table;}
	
	String[] getConteudoColuna() { return this.conteudoColuna;}
	private void setConteudoColuna(String[] conteudoColuna) { this.conteudoColuna=conteudoColuna;}
	
	ArrayList<HashMap <String , String>> getTabelaModificada() { return this.tabelaModificada;}
	private void setTabelaModificada(ArrayList<HashMap <String , String>> tabelaModificada) { this.tabelaModificada=tabelaModificada;}
	
	Map <String , String> getDataTypeDictionary() { return this.dataTypeDictionary;}
	private void setDataTypeDictionary(Map <String , String> dataTypeDictionary) { this.dataTypeDictionary=dataTypeDictionary;}
	
	
	void lerFicheiro(){
		try{
			FileReader ficheiro = new FileReader(System.getProperty("user.dir")+"/src/" + nomeFicheiro);
			Scanner myReader = new Scanner(ficheiro);
			
			String[] colunas = myReader.nextLine().split(",");
			setConteudoColuna(colunas);
			
			while(myReader.hasNextLine()){
				String[] linha = myReader.nextLine().split(",");
				HashMap<String , String> data = new HashMap<>();
				
				for(int i = 0; i < linha.length; i++) {
					data.put(conteudoColuna[i],linha[i]);
				}
				table.add(data);
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
		    e.printStackTrace();
		  }
		
	}
	
	void variableType() { 
		Map <String , Integer> tempDictionary = new HashMap<>();
		
		for(int b = 0; b < conteudoColuna.length; b++){
			tempDictionary.put("INT", 0);
			tempDictionary.put("DOUBLE", 0);
			tempDictionary.put("STRING", 0);
			tempDictionary.put("BOOLEAN", 0);
			
			 for(int i = 0; i < getTable().size(); i++){
				String x = getTable().get(i).get(conteudoColuna[b]);
				
				try {
			        int j = Integer.parseInt(x);
			        tempDictionary.put("INT", tempDictionary.get("INT") + 1);
			        
		    	} catch (NumberFormatException e) {
			        try {
			            double d = Double.parseDouble(x);
			            tempDictionary.put("DOUBLE", tempDictionary.get("DOUBLE") + 1);
			            
			        } catch (NumberFormatException e2) {
			        	tempDictionary.put("STRING", tempDictionary.get("STRING") + 1);
			        }
		    	}
	    	}
			
			if(tempDictionary.get("INT") > tempDictionary.get("DOUBLE") && tempDictionary.get("INT") > tempDictionary.get("STRING")) {		
				int contador = 0;
				
				for(int a = 0; a < getTable().size(); a++){
					String x = getTable().get(a).get(conteudoColuna[b]);
					int j = Integer.parseInt(x);
					
					 if (j == 1 || j == 0)
						 contador++;
				    }
				
				if(contador == getTable().size())
					dataTypeDictionary.put(conteudoColuna[b], "BOOLEAN");
				
				else
					dataTypeDictionary.put(conteudoColuna[b], "INT");
			}
			else if(tempDictionary.get("DOUBLE") > tempDictionary.get("INT") && tempDictionary.get("DOUBLE") > tempDictionary.get("STRING")) {
				dataTypeDictionary.put(conteudoColuna[b], "DOUBLE");
			}
			else {
				dataTypeDictionary.put(conteudoColuna[b], "STRING");
			}
	    }
	}
	 
	
	void operation(){
		InputFilter input = new InputFilter(getQuery());
		
		//for(String g: input.getFilteredInput())
			//System.out.println(g);
		
		InstantiateClass newClass = new InstantiateClass(getTable(), input.getFilteredInput(), getDataTypeDictionary());
	}
}

