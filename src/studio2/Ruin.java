package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Starting amount?");
		double startAmount = in.nextDouble();
		System.out.println("Win chance?");
		double winChance = in.nextDouble();
		System.out.println("Win limit?");
		double winLimit = in.nextDouble();
		System.out.println("Number of days to simulate? ");
		int days = 1;
		double totalSimulations = in.nextDouble();
		int wins = 0;
		double losses = 0;
		double x = Math.random();
		double y = (1-winChance) / winChance;
		double expectedRuin = 0;
		
		if(winChance == 0.5)
		{
		expectedRuin = 1 - (startAmount / winLimit);
		}
		else
		{
		expectedRuin = (Math.pow(y,startAmount) - (Math.pow(y, winLimit))) / (1 - (Math.pow(y, winLimit)));
		}
		
		while (days < totalSimulations)
			{
				days++;
			
		while (startAmount < winLimit && startAmount > 0)
		{
			if (x < winChance)
			{
				startAmount++;
				System.out.println(startAmount);
				x = Math.random();
			}
			else
			{
				startAmount--;
				System.out.println(startAmount);
				losses++;
				x = Math.random();
			}
		}
			}
		//System.out.println("Success; you've won enough!");
		System.out.println("Losses: " + losses);
		System.out.println("Ruin rate from simulation: " + losses / totalSimulations);
		System.out.println("Expected ruin rate: " + expectedRuin);
	
		

	}

}
