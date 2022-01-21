package poo;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir") + "/" + "Customer_Data.csv");
		Operacao novaQuerry = new Operacao("Customer_Data.csv");
		
		//System.out.println(novaQuerry.getTabela().get(1));
		//System.out.println(novaQuerry.getTabela().get(1).get("IsActiveMember").equals(novaQuerry.getTabela().get(0).get("IsActiveMember")));
	}
}




