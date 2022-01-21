package poo;

import java.io.*;
import java.util.*;

public class Operacao {
	String nomeFicheiro;
	ArrayList<HashMap <String , String>> tabela = new ArrayList<>();
	ArrayList<HashMap <String , String>> tabelaModificada = new ArrayList<>();
	String[] conteudoColuna;
	Map<String, String> dataTypeDictionary = new HashMap<String, String>();
	String query;
	
	Operacao(String nomeFicheiro){
		this.nomeFicheiro = nomeFicheiro;
		lerFicheiro();
		variableType();
		operacoes();
	}
	
	String getNomeFicheiro() { return this.nomeFicheiro;}
	private void setNomeFicheiro(String nomeFicheiro) { this.nomeFicheiro=nomeFicheiro;}
	
	ArrayList<HashMap <String , String>> getTabela() { return this.tabela;}
	private void setTable(ArrayList<HashMap <String , String>> tabela) { this.tabela=tabela;}
	
	String[] getConteudoColuna() { return this.conteudoColuna;}
	private void setConteudoColuna(String[] conteudoColuna) { this.conteudoColuna=conteudoColuna;}
	
	String getQuery() { return this.query;}
	private void setQuery(String query) { this.query=query;}
	
	ArrayList<HashMap <String , String>> getTabelaModificada() { return this.tabelaModificada;}
	private void setTabelaModificada(ArrayList<HashMap <String , String>> tabelaModificada) { this.tabelaModificada=tabelaModificada;}
	
	void lerFicheiro(){
		try{
			FileReader ficheiro = new FileReader(System.getProperty("user.dir")+"/src/" + nomeFicheiro);
			Scanner myReader = new Scanner(ficheiro);
			
			String[] colunas = myReader.nextLine().split(",");
			setConteudoColuna(colunas);
			
			/*for(String a : conteudoColuna) {
				System.out.print(a + " | ");
			}*/
			
			while(myReader.hasNextLine()){
				String[] linha = myReader.nextLine().split(",");
				HashMap<String , String> data = new HashMap<>();
				
				for(int i = 0; i < linha.length; i++) {
					data.put(conteudoColuna[i],linha[i]);
					//System.out.println(conteudoColuna[i] + " " + linha[i]);
					//System.out.println(i);
				}
				tabela.add(data);
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
			
			 for(int i = 0; i < getTabela().size(); i++){
				String x = getTabela().get(i).get(conteudoColuna[b]);
				
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
			 
			 //System.out.println(temp);
			
			if(tempDictionary.get("INT") > tempDictionary.get("DOUBLE") && tempDictionary.get("INT") > tempDictionary.get("STRING")) {		
				int g = 0;
				
				for(int a = 0; a < getTabela().size(); a++){
					String x = getTabela().get(a).get(conteudoColuna[b]);
					int j = Integer.parseInt(x);
					
					 if (j == 1 || j == 0)
				            g++;
				    }
				
				if(g == getTabela().size())
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
	 
	 void operacoes(){
		//System.out.print(tabela.get(1));
			//System.out.println(tabela.get(1).get("IsActiveMember").equals(tabela.get(0).get("IsActiveMember")));
			
			//DistinctCount a = new DistinctCount(conteudoColuna[4],tabela);
			//int d = a.getContagemDistinta();
			//System.out.print(d);
			
			/*Sum a = new Sum(conteudoColuna[6],tabela, dataTypeDictionary);
			double d = a.getResultadoSoma();
			System.out.println(String.format("%.1f", d));*/
			
		 	/*Average h = new Average(conteudoColuna[7],tabela, dataTypeDictionary);
			int b = h.getAverageResult();
			System.out.println(b);*/
			
			//CountRows a = new CountRows(tabela);
			//int d = a.getNumbLines();
			//System.out.print(d);
		 
		  	/*All a = new All(tabela);
		  	tabela = a.getQueryTable();
			System.out.print(tabela.get(0));*/
			
		 	String[] array = {"IsActiveMember", "==", "1", "&&", "Gender", "==", "Female"};
			Filter f = new Filter(tabela, array);
			setTabelaModificada(f.resultingTable);
	
			for(int i = 0 ; i < getTabelaModificada().size();i++) {
				System.out.println(getTabelaModificada().get(i));
			}
	 }
}

