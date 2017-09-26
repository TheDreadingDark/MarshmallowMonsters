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
		int count = 0;
		// while(count < 10)
		// {
		// popup.displayText("Am I not the coolest??!");
		// count +=2;
		// }

		// for(int loop = 0; loop < 10; loop += 1)
		// {
		// popup.displayText("This is loop # " + (loop + 1) + " of ten");
		// }

		// Creates a Monster
		MarshmallowMonster basic = new MarshmallowMonster();
		// System.out.println(basic);
		popup.displayText(basic.toString());
		MarshmallowMonster galactus = new MarshmallowMonster("Scary Galactus Destroyer of Worlds Monster", 7, 3, 6.7, true);
		// System.out.println(galactus);
		popup.displayText(galactus.toString());
		// System.out.println("I am feeling hungry, I am going to eat one of Galactus' arms");
		popup.displayText("I am feeling hungry, I am going to eat one of Galactus' arms");
		galactus.setArmCount(galactus.getArmCount() - 1);
		// System.out.println(galactus);
		galactus.setArmCount(galactus.getArmCount() - 1);
		// System.out.println(galactus);
		popup.displayText(galactus.toString());

		interactWithMonster(galactus);
	}

	private void interactWithMonster(MarshmallowMonster currentMonster)
	{
		// Asks how many eyes of the monster's current amount you'd like to eat
		Scanner myScanner = new Scanner(System.in);
		// System.out.println(currentMonster.getName() + " wants to know how many eyes you want to eat,
		// please type in how many");
		int consumed = 0;
		String response = popup.getResponse(currentMonster.getName() + " wants to know how many eyes yoou want to eat, please type in how many");

		while (!isValidInteger(response))
		{
			popup.displayText("grrr type in a better answer next time");
			response = popup.getResponse("Type in a integer value!");
		}

		// if(isValidInteger(response))
		// {
		consumed = Integer.parseInt(response);
		// }

		// int consumed = myScanner.nextInt();
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
		System.out.println(currentMonster);

		// Asks how many arms of the monsters you'd like to eat
		System.out.println("How many arms are you interested in eating?, I have " + currentMonster.getArmCount());
		// consumed = myScanner.nextInt();
		int armEat = myScanner.nextInt();

		if (armEat == 0)
		{
			System.out.println("Not hungry? oh so sad...");
		}
		else if (armEat < 0)
		{
			System.out.println("Reality is hard for you - it is impossible to eat a negative amount");
		}
		else if (armEat - currentMonster.getArmCount() > 0)
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

		// Asks how many of the monsters current tentacles you'd like to eat
		double food = 0.0;
		String tentacleResponse = popup.getResponse("How many tentacles do you want to eat? I have " + currentMonster.getTentacleAmount());
		if (isValidDouble(tentacleResponse))
		{
			food = Double.parseDouble(tentacleResponse);
		}

		if (food == currentMonster.getTentacleAmount())

			if (tentacleEat == 0)
			{
				System.out.println("Not hungry? oh alright...");
			}
			else if (tentacleEat < 0)
			{
				System.out.println("Reality is hard for you - it is impossible to eat a negative amount");
			}
			else if (tentacleEat - currentMonster.getTentacleAmount() > 0)
			{
				System.out.println("You can't eat more than my existing tentacles.");
			}
			else
			{
				currentMonster.setTentacleAmount(currentMonster.getTentacleAmount() - tentacleEat);
				System.out.println("Ok, now I have this many tentacles " + currentMonster.getTentacleAmount());
			}

		// Asks you the question, "Hi there ready to play???"
		popup.displayText("Hi there ready to play???");
		String answer = popup.getResponse("What is the air speed of a coconut laden swallow?");
		System.out.println(answer);

		myScanner.close();
	}

	// Helper methods
	private boolean isValidInteger(String sample)
	{
		boolean valid = false;

		try
		{
			Integer.parseInt(sample);
			valid = true;
		}
		catch (NumberFormatException error)
		{
			popup.displayText("You need to input an int, " + sample + " is not valid.");
		}

		return valid;
	}

	private boolean isValidDouble(String sampleDouble)
	{
		boolean valid = false;

		try
		{
			Double.parseDouble(sampleDouble);
			valid = true;
		}
		catch (NumberFormatException error)
		{
			popup.displayText("You need to type in a double - " + sampleDouble + " is not a valid answer.");
		}

		return valid;
	}

	private boolean isValidBoolean(String sampleBoolean)
	{
		boolean valid = false;

		try
		{
			Boolean.parseBoolean(sampleBoolean);
			valid = true;
		}
		catch (NumberFormatException error)
		{
			popup.displayText("Type in a boolean value" + sampleBoolean + " does not count.");
		}

		return valid;
	}
}
