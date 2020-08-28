/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Simulator.java                                     :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/11 15:59:29 by svan-nie          #+#    #+#             */
/*   Updated: 2020/08/11 15:59:29 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package simulator;

import java.io.*;
import java.util.*;
import simulator.*;
import simulator.vehicles.*;

public class Simulator {
	private static WeatherTower weatherTower = new WeatherTower();
	private static List<Flyable> flyables = new ArrayList<Flyable>();
	public static PrintWriter printwriter = null;
	public static void main(String[] arg) throws FileNotFoundException {
		if (arg.length > 1)
			throw new FileNotFoundException();
			try {
			File file = new File(arg[0]);
			boolean exists = file.exists();
			File simulation = new File("simulation.txt");
			printwriter = new PrintWriter("simulation.txt");
			if (!exists)
			{
				System.out.println("Error: Missing file " + arg[0]);
				System.exit(2);
			}
			Scanner scan = new Scanner(file);
			int count = 0;
			String checkString;
			int count2 = 0;
			int track = 0;
			int passEmptySpace = 0;
			int simulations = 0;
			String[] fileInput;
			while (scan.hasNextLine())
			{
				checkString = scan.nextLine();
				if (checkString.length() == 0)
				continue;
				if (track == 0)
				{
					simulations = Integer.parseInt(checkString);
					if (simulations <= 0)
					{
						System.out.println("you cant have a negative or 0 as number");
						System.exit(2);
					}
					track++;
					continue;
				}
				while (count < checkString.length())
				{
					if (checkString.charAt(count) == ' ')
					count2++;
					count++;
				}
				if (count2 >= 5 || count2 <= 3)
				{
					System.out.println("Somthing is wrong with your scenarioFile");
					System.exit(2);
					throw new FileNotFoundException();
				}
				if (count2 == 4)
				{
					fileInput = checkString.split(" ");
					Flyable flyable = AircraftFactory.newAircraft(fileInput[0], fileInput[1],
					Integer.parseInt(fileInput[2]), Integer.parseInt(fileInput[3]),
					Integer.parseInt(fileInput[4]));
					if (flyable != null)
						flyables.add(flyable);
				}
				count = 0;
				count2 = 0;
			}
				for (Flyable flyable : flyables) {
					flyable.registerTower(weatherTower);
				}
				for (int i = simulations; i >= 1; i--) {
					weatherTower.changeWeather();
				}
				Simulator.printwriter.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error: Missing file " + arg[0]);
			} catch (NumberFormatException e) {
				System.out.println("Height, lat and long must be a number base please");
			} catch (Exception e){
				System.out.println("Error: Region unknown please contact support for help!");
			}
	}
}