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
			String betweenBracket = "";
			
			if(array1[0].equalsIgnoreCase("Filter")) {
				tempArray.add(array1[0]);
				caseFilter(tempArray, array1, array1.length-1);
			}
			else {
				betweenBracket = array1[1].substring(array1[1].indexOf("[") + 1, array1[1].indexOf("]"));
				array1[1] = betweenBracket;
				setFilteredInput(array1);
			}
				
		}
		else if(array1.length == 3){
			tempArray.add(array1[0]);
			tempArray.add(array1[1]);
			tempArray.add(array1[2].substring(array1[2].indexOf("(") + 1, array1[2].indexOf(")")));
			tempArray.add(tempArray.get(2).substring(tempArray.get(2).indexOf("[")));
			tempArray.remove(2);
			
			if(array1[1].equalsIgnoreCase("Filter")) {
				caseFilter(tempArray, array1, array1.length-1);
				tempArray.remove(2);
			}
			else if(array1[1].equalsIgnoreCase("Calculate")) {
				caseCalculate(tempArray, array1, array1.length-1);
			}
			
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
				caseFilter(tempArray, array1, array1.length-1);	
			}
			
			String[] arr = new String[tempArray.size()];
			arr = tempArray.toArray(arr);
			setFilteredInput(arr);
		}
		
		
	}
	
	ArrayList<String> caseFilter(ArrayList<String> tempArr, String[] arr, int lastElement) {
		ArrayList<String> tempArray = new ArrayList<>();
		
		tempArray.add(arr[lastElement].substring(arr[lastElement].indexOf("[") + 1, arr[lastElement].indexOf("]")));
		tempArray.add(arr[lastElement].substring(arr[lastElement].indexOf("]")+1, arr[lastElement].indexOf("]") + 3));
		tempArray.add(arr[lastElement].substring(arr[lastElement].indexOf("]")));
		
		
		tempArray.add(tempArray.get(2).substring(tempArray.get(2).indexOf("]")+3, tempArray.get(2).indexOf(" ")));
		tempArray.add(tempArray.get(2).substring(tempArray.get(2).indexOf(" ")+1, tempArray.get(2).indexOf(" ")+3));
		tempArray.add(tempArray.get(2).substring(tempArray.get(2).indexOf("[")));
		tempArray.remove(2);
		
			
		tempArray.add(tempArray.get(4).substring(tempArray.get(4).indexOf("[")+1, tempArray.get(4).indexOf("]")));
		tempArray.add(tempArray.get(4).substring(tempArray.get(4).indexOf("]")+1, tempArray.get(4).indexOf("]")+3));
		tempArray.add(tempArray.get(4).substring(tempArray.get(4).indexOf("]")+3, tempArray.get(4).indexOf(")")));
		tempArray.remove(4);
		
		tempArr.addAll(tempArray);
		
		return tempArr;
	}
	
	ArrayList<String> caseCalculate(ArrayList<String> tempArr, String[] arr, int lastElement) {
		ArrayList<String> tempArray = new ArrayList<>();
		
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
		
		tempArr.addAll(tempArray);
		
		return tempArr;
	}
}
