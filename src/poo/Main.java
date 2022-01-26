package poo;

import java.util.*;

/*
 * @author Tiago Caetano, ISMAT
 * @author Francisco Vicente, ISMAT
 * @version JDK 11.0.13
 */
public class Main {
	public static void main(String[] args) {
		Operacao novaQuerry = new Operacao("Customer_Data.csv",
				"CALCULATE(DISTINCTCOUNT(Customer_Data[Geography]), ALL(Customer_Data))");

		// COUNTROWS(FILTER(Customer_Data, Customer_Data[Age]>=18 &&
		// Customer_Data[IsActiveMember]==1))
		// CALCULATE(DISTINCTCOUNT(Customer_Data[Geography]), ALL(Customer_Data))
		// AVERAGE(Customer_Data[Tenure])
		// SUM(Customer_Data[Balance])
	}
}