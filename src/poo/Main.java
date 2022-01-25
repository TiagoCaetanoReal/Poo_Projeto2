package poo;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//SUM(Customer_Data[Balance])
		//AVERAGE(Customer_Data[Tenure])
		//DISTINCTCOUNT(FILTER(Customer_Data, Customer_Data[Age]>=18 && Customer_Data[IsActiveMember]==1))
		//CALCULATE(DISTINCTCOUNT(Customer_Data[Geography]), ALL(Customer_Data))
		
		Operacao novaQuerry = new Operacao("Customer_Data.csv", "CALCULATE(DISTINCTCOUNT(Customer_Data[Geography]), ALL(Customer_Data))");
	}
}