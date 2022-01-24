package poo;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		//Operacao novaQuerry = new Operacao("Customer_Data.csv", "SUM(Customer_Data[Balance])");
		
		InputFilter i= new InputFilter("DISTINCTCOUNT(FILTER(Customer_Data, Customer_Data[Age]>=18 && Customer_Data[IsActiveMember]==1))");
		
		InputFilter f= new InputFilter("SUM(Customer_Data[Balance])");
		
	}
}