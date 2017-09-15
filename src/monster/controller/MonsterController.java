package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;

public class MonsterController
{
	
	public void start()
	{
		MarshmallowMonster basic = new MarshmallowMonster();
		System.out.println(basic);
		MarshmallowMonster galactus = new MarshmallowMonster("Scary Galactus Destroyer of Worlds Monster", 7, 3, 6.7, true);
		System.out.println(galactus);
		System.out.println("I am feeling hungry, I am going to eat one of Galactus' arms");
		galactus.setArmCount(galactus.getArmCount() - 1);
		System.out.println(galactus);
		galactus.setArmCount(galactus.getArmCount() - 1);
		System.out.println(galactus);
	
		interactWithMonster(galactus);
	}
	
	private void interactWithMonster(MarshmallowMonster currentMonster)
	{
		Scanner myScanner = new Scanner(System.in);
		System.out.println(currentMonster.getName() + " wants to know how many eyes you want to eat, please type in how many");
		int consumed = myScanner.nextInt();
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
		System.out.println(currentMonster);
		
		myScanner.close();
	}
}
