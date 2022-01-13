package poo;

import java.io.*;
import java.util.*;

public class Operacao {
	String nomeFicheiro;
	ArrayList<HashMap <String , String>> tabela = new ArrayList<>();
	String[] conteudoColuna;
	Map<String, String> dataTypeDictionary = new HashMap<String, String>();
	String query;
	
	Operacao(String nomeFicheiro){
		this.nomeFicheiro = nomeFicheiro;
		lerFicheiro();
		variableType();
	}
	
	String getNomeFicheiro() { return this.nomeFicheiro;}
	private void setNomeFicheiro(String nomeFicheiro) { this.nomeFicheiro=nomeFicheiro;}
	
	ArrayList<HashMap <String , String>> getTabela() { return this.tabela;}
	private void setTable(ArrayList<HashMap <String , String>> tabela) { this.tabela=tabela;}
	
	String[] getConteudoColuna() { return this.conteudoColuna;}
	private void setConteudoColuna(String[] conteudoColuna) { this.conteudoColuna=conteudoColuna;}
	
	String getQuery() { return this.query;}
	private void setQuery(String query) { this.query=query;}
	
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
			        //System.out.println("It's an integer: " + j);
			       // System.out.println(conteudoColuna[b]);
			       // dataType.put(conteudoColuna[b], "INT");
			        
			        tempDictionary.put("INT", tempDictionary.get("INT") + 1);
			        
		    	} catch (NumberFormatException e) {
			        try {
			            double d = Double.parseDouble(x);
			            //System.out.println("It's a double: " + d);
			           // dataType.put(conteudoColuna[b], "DOUBLE");
			            
			            tempDictionary.put("DOUBLE", tempDictionary.get("DOUBLE") + 1);
			            
			        } catch (NumberFormatException e2) {
			            //System.out.println("It's a String: " + x);
			          // dataType.put(conteudoColuna[b], "STRING");
			        	
			        	tempDictionary.put("STRING", tempDictionary.get("STRING") + 1);
			        }
		    	}
	    	}
			 
			 //System.out.println(temp);
			
			if(tempDictionary.get("INT") > tempDictionary.get("DOUBLE") && tempDictionary.get("INT") > tempDictionary.get("STRING")) {		
				dataTypeDictionary.put(conteudoColuna[b], "INT");
				System.out.println(conteudoColuna[b] + " " + dataTypeDictionary.get(conteudoColuna[b]));
			}
			else if(tempDictionary.get("DOUBLE") > tempDictionary.get("INT") && tempDictionary.get("DOUBLE") > tempDictionary.get("STRING")) {
				dataTypeDictionary.put(conteudoColuna[b], "DOUBLE");
				System.out.println(conteudoColuna[b] + " " + dataTypeDictionary.get(conteudoColuna[b]));
				
			}
			else {
				dataTypeDictionary.put(conteudoColuna[b], "STRING");
				System.out.println(conteudoColuna[b] + " " + dataTypeDictionary.get(conteudoColuna[b]));
				
			}
	    }
		//System.out.println(dataType.get("Geography"));
	    
	    /*
	     * https://stackoverflow.com/questions/13543457/how-do-you-create-a-dictionary-in-java
	     * https://codereview.stackexchange.com/questions/159457/determine-if-an-input-is-an-integer-a-double-or-a-string
	     * https://stackoverflow.com/questions/12361492/how-to-determine-the-primitive-type-of-a-primitive-variable
	     */
	}
	 
	 void operacoes(){
		//System.out.print(tabela.get(1));
			//System.out.println(tabela.get(1).get("IsActiveMember").equals(tabela.get(0).get("IsActiveMember")));
			
			//DistinctCount a = new DistinctCount(conteudoColuna[4],tabela);
			//int d = a.getContagemDistinta();
			//System.out.print(d);
			
			//Sum a = new Sum(conteudoColuna[4],tabela);
			//int d = a.getResultadoSoma();
			//System.out.print(d);
			
			//CountRows a = new CountRows(tabela);
			//int d = a.getNumbLines();
			//System.out.print(d);
	 }
}
