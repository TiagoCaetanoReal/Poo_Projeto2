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
	
	String[] getConteudoColuna() { return this.conteudoColuna;}
	private void setConteudoColuna(String[] conteudoColuna) { this.conteudoColuna=conteudoColuna;}
	
	void lerFicheiro(){
		try{
			FileReader ficheiro = new FileReader(System.getProperty("user.dir") + "/src/" + nomeFicheiro); 
			//BufferedReader buffer = new BufferedReader(ficheiro);
			Scanner myReader = new Scanner(ficheiro);
			
			String[] colunas = myReader.nextLine().split(",");
			setConteudoColuna(colunas);
			
			for(String a : conteudoColuna) {
				System.out.print(a + " | ");
			}
			
			int j = 0;
			while(myReader.hasNextLine()){
				String[] linha = myReader.nextLine().split(",");
				HashMap<String , String> data = new HashMap<>();
				
				for(int i = 0; i < linha.length; i++) {
					data.put(conteudoColuna[i],linha[i]);
					System.out.println(conteudoColuna[i] + " " + linha[i]);
					System.out.println(i);
				}
				tabela.add(data);
				j++;
				break;
			}
			System.out.println("\n" + tabela.get(0));
		
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
		    e.printStackTrace();
		  }
		
	 }
}
