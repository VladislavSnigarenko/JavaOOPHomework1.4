package Task_4;

import java.util.ArrayList;
import java.util.Arrays;

public class Network {

	private ArrayList<String> numbers = new ArrayList<String>();
	private String name;

	public Network(String name) {
		this.name = name;
	}

	public Network() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getAllNumbersNetwork() {
		return numbers;
	}

	public void registerOneNember(String number) {
		if (numbers != null && numbers.contains(number))
			System.out.println("Error : Number : (" + number + ") already exists on the network : " + name);
		else
		{
			numbers.add(number);
			System.out.println("Number : (" + number + ") registered on the network : " + name);
		}
	}

}
