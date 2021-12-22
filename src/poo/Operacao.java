package poo;


import java.io.*;
import java.util.*;

public class Operacao {
	 
	String nomeFicheiro;
	ArrayList<HashMap <String , String>> tabela = new ArrayList<HashMap<String, String>>();
	String[] conteudoColuna;
	String query;
	
	Operacao(String nomeFicheiro){
		this.nomeFicheiro = nomeFicheiro;
		lerFicheiro();
	}
	
	String getNomeFicheiro() { return this.nomeFicheiro;}
	void setNomeFicheiro(String nomeFicheiro) { this.nomeFicheiro=nomeFicheiro;}
	
	String[] getConteudoColuna() { return this.conteudoColuna;}
	void setConteudoColuna(String[] conteudoColuna) { this.conteudoColuna=conteudoColuna;}
	
	void lerFicheiro(){
		try{
			
			FileReader ficheiro = new FileReader(System.getProperty("user.dir") + "/src/" + nomeFicheiro); 
			BufferedReader buffer = new BufferedReader(ficheiro);
			
			String[] colunas = buffer.readLine().split(";");
			setConteudoColuna(colunas);
			
			for(String a : conteudoColuna) {
				System.out.println(a);
			}
			
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		  catch(IOException e){
		    e.printStackTrace();
		  }
	 }
}
