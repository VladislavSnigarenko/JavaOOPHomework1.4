package Task_4;

/*
 * Teacher - Alexander Ts 
 * Student - Snigarenko Vlad
 * 10 02 2018 ã.
 * 
 */

public class Main {

	public static void main(String[] args) {

		// 1. MTS
		Network networkMTS = new Network("MTS");
		System.out.println("Work with network : " + networkMTS.getName());

		System.out.println();
		
		Phone firsrPhoneMTS = new Phone("095 805 85 10");
		System.out.println(firsrPhoneMTS);
		firsrPhoneMTS.registerInWetwork(networkMTS);
		firsrPhoneMTS.registerInWetwork(networkMTS); // incorrect - already registered
		
		System.out.println();
		
		Phone secondPhoneMTS = new Phone("050 111 15 12");
		System.out.println(secondPhoneMTS);
		secondPhoneMTS.registerInWetwork(networkMTS);

		System.out.println();
		
		Phone thirdPhoneMTS = new Phone("050 909 11 22");
		System.out.println(thirdPhoneMTS);
		thirdPhoneMTS.registerInWetwork(networkMTS);

		System.out.println();

		Phone fourthPhoneMTS = new Phone();
		fourthPhoneMTS.setNumber("050 096 04 11");
		System.out.println(fourthPhoneMTS);
		fourthPhoneMTS.registerInWetwork(networkMTS);

		System.out.println();
		System.out.println("Test calling...");
		System.out.println();

		// Calling from MTS to MTS
		
		fourthPhoneMTS.call(networkMTS, thirdPhoneMTS.getNumber()); // good
		fourthPhoneMTS.call(networkMTS, fourthPhoneMTS.getNumber()); // bad - call to myself
		fourthPhoneMTS.call(networkMTS, "111-222-33-44"); // bad - not exist number in network MTS

		System.out.println();
				
		// 2. Life
		Network networkLife = new Network("Life");
		System.out.println("Work with network : " + networkLife.getName());

		System.out.println();
		
		Phone firsrPhoneLife = new Phone("093 805 85 10");
		System.out.println(firsrPhoneLife);

		System.out.println();
		
		Phone secondPhoneLife = new Phone("093 111 15 12");
		System.out.println(secondPhoneLife);

		System.out.println();
		System.out.println("Test calling...");
		System.out.println();
		
		// Calling from Life to Life

		firsrPhoneLife.call(networkLife, secondPhoneLife.getNumber()); // bad - networkLife empty 
		
		firsrPhoneLife.registerInWetwork(networkLife);
		secondPhoneLife.registerInWetwork(networkLife);

		firsrPhoneLife.call(networkLife, secondPhoneLife.getNumber()); // good 
		firsrPhoneLife.call(networkLife, "000-111-22-333"); // bad - number not exist in network Life 

		System.out.println();
		
		// 3. MTS + Life
		System.out.println("Work with network : " + networkMTS.getName() + " + " + networkLife.getName());

		System.out.println();
		System.out.println("Test calling...");
		System.out.println();
		
		firsrPhoneMTS.call(networkLife, secondPhoneLife.getNumber()); // good - call from MTS to LIFE 
		secondPhoneLife.call(networkMTS, fourthPhoneMTS.getNumber()); // good - call from LIFE to MTS 
		
		firsrPhoneMTS.call(networkLife, "222-000-11-333"); // bad - number not exist in network Life  
		secondPhoneLife.call(networkMTS, "444-000-55-888"); // bad - number not exist in network MTS 
		secondPhoneLife.call(networkMTS, "095 805 85 10"); // good - call from LIFE to MTS 
		
	}

}
