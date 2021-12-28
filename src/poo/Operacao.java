package poo;

import java.io.*;
import java.util.*;

public class Operacao {
	String nomeFicheiro;
	ArrayList<HashMap <String , String>> tabela = new ArrayList<>();
	String[] conteudoColuna;
	String query;
	
	Operacao(String nomeFicheiro){
		this.nomeFicheiro = nomeFicheiro;
		lerFicheiro();
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
			FileReader ficheiro = new FileReader(System.getProperty("user.dir") + "/src/" + nomeFicheiro);
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
				//break;
			}
			//System.out.print(tabela.get(1));
	
			//System.out.println(tabela.get(1).get("IsActiveMember").equals(tabela.get(0).get("IsActiveMember")));
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
		    e.printStackTrace();
		  }
		
	 }
}
