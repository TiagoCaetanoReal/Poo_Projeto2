package poo;


public class InputFilter {
	String input;
	String[] filteredInput;
	
	InputFilter(String input){
		this.input = input;
		filtering();
	}
	
	String getInput() { return this.input;}
	private void setInput(String input) { this.input = input;}
	
	String[] getFilteredInput() { return this.filteredInput;}
	private void setFilteredInput(String[] filteredInput) { this.filteredInput = filteredInput;}
	
	
	void filtering() {
		String[] array1 = getInput().split("\\(");
		
		if(array1.length == 2) {
			String array2 = array1[1].substring(array1[1].indexOf("[") + 1, array1[1].indexOf("]"));
			
			System.out.println(array2);
		}
		else if(array1.length == 3){
					String array2 = array1[2].substring(array1[2].indexOf("[") + 1, array1[2].indexOf("]"));
		}
		
		//for(String f : array1)
			//System.out.println(f);
			
	}
	
	
	//SUM(Customer_Data[Balance])
	//DISTINCTCOUNT(FILTER(Customer_Data, Customer_Data[Age]>=18 && Customer_Data[IsActiveMember]==1))
	//CALCULATE(DISTINCTCOUNT(Customer_Data[Geography]), ALL(Customer_Data))
	
	
	   /* 
	    void filtragem () {
	        String[] arroz = teste.split("\\(");
	        
	        for(int i =0 ; i<arroz.length; i++) {
	            System.out.println(arroz[i]);
	        }
	    }
	    

	    String[] getFilter(String input ) {
	        
	        
	    var splited =input.split("\\(");
	        
	        return splited;
	        
	    }
	*/
}
