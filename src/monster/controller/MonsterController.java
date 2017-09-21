package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;

public class MonsterController
{

	private MonsterDisplay popup;
	
public MonsterController()
{
	popup = new MonsterDisplay();
}
	
	public void start()
	{
		MarshmallowMonster basic = new MarshmallowMonster();
		System.out.println(basic);
		popup.displayText(basic.toString());
		MarshmallowMonster galactus = new MarshmallowMonster("Scary Galactus Destroyer of Worlds Monster", 7, 3, 6.7, true);
		System.out.println(galactus);
		popup.displayText(galactus.toString());
		System.out.println("I am feeling hungry, I am going to eat one of Galactus' arms");
		popup.displayText("I am feeling hungry, I am going to eat one of Galactus' arms");
		galactus.setArmCount(galactus.getArmCount() - 1);
		System.out.println(galactus);
		galactus.setArmCount(galactus.getArmCount() - 1);
		System.out.println(galactus);
		popup.displayText(galactus.toString());
	
		interactWithMonster(galactus);
	}
	
	private void interactWithMonster(MarshmallowMonster currentMonster)
	{
		Scanner myScanner = new Scanner(System.in);
		System.out.println(currentMonster.getName() + " wants to know how many eyes you want to eat, please type in how many");
		int consumed = myScanner.nextInt();
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
		System.out.println(currentMonster);
		
		System.out.println("How many arms are you interested in eating?, I have " + currentMonster.getArmCount());
		//consumed = myScanner.nextInt();
		int armEat = myScanner.nextInt();
		
		if(armEat == 0)
		{
			System.out.println("Not hungry? oh so sad...");
		}
		else if(armEat < 0)
		{
			System.out.println("Reality is hard for you - it is impossible to eat a negative amount");
		}
		else if(armEat - currentMonster.getArmCount() > 0)
		{
			System.out.println("You are not allowed to eat more than exist on me :/ :X");
		}
		else
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - armEat);
			System.out.println("Ok, now I have this many arms " + currentMonster.getArmCount());
		}
		System.out.println("How many tentacles are you interested in eating?, I have " + currentMonster.getTentacleAmount());
		int tentacleEat = myScanner.nextInt();
		
		if(tentacleEat == 0)
		{
			System.out.println("Not hungry? oh alright...");
		}
		else if(tentacleEat < 0)
		{
			System.out.println("Reality is hard for you - it is impossible to eat a negative amount");
		}
		else if(tentacleEat - currentMonster.getTentacleAmount() > 0)
		{
			System.out.println("You can't eat more than my existing tentacles.");
		}
		else
		{
			currentMonster.setTentacleAmount(currentMonster.getTentacleAmount() - tentacleEat);
			System.out.println("Ok, now I have this many tentacles " + currentMonster.getTentacleAmount());
		}
		
		popup.displayText("Hi there ready to play???");
		String answer = popup.getResponse("What is the air speed of a coconut laden swallow?");
		System.out.println(answer);
		
		myScanner.close();
	}
}
