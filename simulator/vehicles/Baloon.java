/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Baloon.java                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/11 16:00:25 by svan-nie          #+#    #+#             */
/*   Updated: 2020/08/11 16:00:25 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package simulator.vehicles;

import simulator.WeatherTower;
import weather.Coordinates;


public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates){ // must this be public?
        super(name, coordinates); // useing the name and corrdinates from super class ie Aircraft
        // this.name = name;
        // this.coordinates = coordinates;
    }

    public void updateConditions(){ // what goes inside here?
        String weather = this.weatherTower.getWeather(this.coordinates);
        if (weather == "RAIN" && this.coordinates.getHeight() > 0)
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
            System.out.println("Baloon#"+this.name+"("+this.id+") Mayday mayday not looking good this rain is making it hard to control");
        }
        else if (weather == "FOG" && this.coordinates.getHeight() > 0)
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
            System.out.println("Baloon#"+this.name+"("+this.id+") Oh dear we in fog everyone start praying we dont hit a skyscraper!!");
        }
        else if (weather == "SUN"  && this.coordinates.getHeight() > 0)
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
            System.out.println("Baloon#"+this.name+"("+this.id+") what a breeze today is going to be a great day nice and sunny!");
        }
        else if (weather == "SNOW" && this.coordinates.getHeight() > 0)
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
            System.out.println("Baloon#"+this.name+"("+this.id+") This snow is making this hard to fly hope we dont crash!");
        }
        if (this.coordinates.getHeight() <= 0)
        {
            System.out.println("Baloon#"+this.name+"("+this.id+") landing.");
            this.weatherTower.unregister(this);
            System.out.println("Tower says: Baloon#"+this.name+"("+this.id+") unregistered from weather tower.");
        }
    }
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: Baloon#"+this.name+"("+this.id+") register to weather tower.");
	}
}