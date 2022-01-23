package poo;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir") + "/" + "Customer_Data.csv");
		Operacao novaQuerry = new Operacao("Customer_Data.csv");
		}
}