package poo;

import java.util.ArrayList;

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
	
	/*
	 * metodo para filtrar o input do user
	 */
	void filtering() {
		ArrayList<String> tempArray = new ArrayList<>();
		String[] array1 = getInput().split("\\(");
		
		if(array1.length == 2) {
			String betweenBracket = array1[1].substring(array1[1].indexOf("[") + 1, array1[1].indexOf("]"));
			array1[1] = betweenBracket;
			setFilteredInput(array1); 	
		}
		else if(array1.length == 3){
			tempArray.add(array1[0]);
			tempArray.add(array1[1]);
			
			tempArray.add(array1[2].substring(array1[2].indexOf("(") + 1, array1[2].indexOf(")")));
			tempArray.add(tempArray.get(2).substring(tempArray.get(2).indexOf("[")));
			tempArray.remove(2);
			
			tempArray.add(tempArray.get(2).substring(tempArray.get(2).indexOf("[") + 1, tempArray.get(2).indexOf("]")));
			tempArray.add(tempArray.get(2).substring(tempArray.get(2).indexOf("]")+1, tempArray.get(2).indexOf("]") + 3));
			tempArray.add(tempArray.get(2).substring(tempArray.get(2).indexOf("]")+3, tempArray.get(2).indexOf(" ")));
			tempArray.add(tempArray.get(2).substring(tempArray.get(2).indexOf(" ")+1));
			tempArray.remove(2);
			
			tempArray.add(tempArray.get(5).substring(0, tempArray.get(5).indexOf(" ")));
			tempArray.add(tempArray.get(5).substring(tempArray.get(5).indexOf("[") + 1, tempArray.get(5).indexOf("]")));
			tempArray.add(tempArray.get(5).substring(tempArray.get(5).indexOf("]") + 1, tempArray.get(5).indexOf("]")+3));
			tempArray.add(tempArray.get(5).substring(tempArray.get(5).indexOf("]") + 3));
			tempArray.remove(5);

			String[] arr = new String[tempArray.size()];
		    arr = tempArray.toArray(arr);
			setFilteredInput(arr);
		}
		else if(array1.length == 4){
			tempArray.add(array1[0]);
			tempArray.add(array1[1]);
			
			tempArray.add(array1[2].substring(array1[2].indexOf("(") + 1, array1[2].indexOf(")")));
			tempArray.add(tempArray.get(2).substring(tempArray.get(2).indexOf("[")+1, tempArray.get(2).indexOf("]")));
			tempArray.remove(2);

			tempArray.add(array1[2].substring(array1[2].indexOf(" ")+1));
		
			if(tempArray.get(3).equalsIgnoreCase("Filter")) {
				
				tempArray.add(array1[3].substring(array1[3].indexOf("[") + 1, array1[3].indexOf("]")));
				tempArray.add(array1[3].substring(array1[3].indexOf("]")+1, array1[3].indexOf("]") + 3));
				tempArray.add(array1[3].substring(array1[3].indexOf("]")));
				
				tempArray.add(tempArray.get(6).substring(tempArray.get(6).indexOf("]")+3, tempArray.get(6).indexOf(" ")));
				tempArray.add(tempArray.get(6).substring(tempArray.get(6).indexOf(" ")+1, tempArray.get(6).indexOf(" ")+3));
				tempArray.add(tempArray.get(6).substring(tempArray.get(6).indexOf("[")));
				tempArray.remove(6);
				
				tempArray.add(tempArray.get(8).substring(tempArray.get(8).indexOf("[")+1, tempArray.get(8).indexOf("]")));
				tempArray.add(tempArray.get(8).substring(tempArray.get(8).indexOf("]")+1, tempArray.get(8).indexOf("]")+3));
				tempArray.add(tempArray.get(8).substring(tempArray.get(8).indexOf("]")+3, tempArray.get(8).indexOf(")")));	
				tempArray.remove(8);			
			}
			String[] arr = new String[tempArray.size()];
		    arr = tempArray.toArray(arr);
			setFilteredInput(arr);
		}
	}
}
