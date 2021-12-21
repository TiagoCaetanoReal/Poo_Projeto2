package poo;


import java.io.*;
import java.util.HashMap;

public class Operacao {
	 
	String nomeFicheiro;
	HashMap <String , String> tabela;
	String[] conteudoColuna;
	String query;
	
	Operacao(String nomeFicheiro){
		this.nomeFicheiro = nomeFicheiro;	
	}
	
	String getNomeFicheiro() { return this.nomeFicheiro;}
	
	void lerFicheiro(){
		try{
			
			FileReader ficheiro = new FileReader(System.getProperty("user.dir") + "/src/" + nomeFicheiro); 
			BufferedReader buffer = new BufferedReader(ficheiro);
			
			
			
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		  catch(IOException e){
		    e.printStackTrace();
		  }
	 }
}
