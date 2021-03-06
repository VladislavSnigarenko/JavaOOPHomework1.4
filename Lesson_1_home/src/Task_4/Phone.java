package Task_4;

import java.util.ArrayList;

public class Phone {

	private String number;

	public Phone(String number) {
		this.number = number;
	}

	public Phone() {
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Phone [number = " + number + "]";
	}

	public void registerInWetwork(Network network) {
		network.registerOneNumber(number);
	}
	
	public void call(Network network, String number) {

		if (network.getAllNumbersNetwork().isEmpty())
			System.out.println("Error : Network : " + network.getName() + " is empty !");
		else if (network.getAllNumbersNetwork().contains(number) && number == this.number)
			System.out.println("Error : Network : " + network.getName() + " exist number : (" + number + "), but call is forbidden to myself (" + this.number + ")");
		else if (network.getAllNumbersNetwork().contains(number))
		{
			System.out.println("Network : " + network.getName() + " exist number : (" + number + "), calling from : (" + this.number + ") to : (" + number + ")");
			new Phone(number).incomingCall(this.number);
		}
		else 
			System.out.println("Error : Network : " + network.getName() + " not exist number : (" + number + ")");
	}
	
	public void incomingCall(String incomingNumber) {
		System.out.println("Incoming Call : from incoming number : ("
				+ incomingNumber + "), to number (" + number + ")");
	}

}
