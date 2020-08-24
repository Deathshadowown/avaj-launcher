/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Helicopter.java                                    :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/11 16:00:31 by svan-nie          #+#    #+#             */
/*   Updated: 2020/08/11 16:00:31 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package simulator.vehicles;

import simulator.WeatherTower;
import weather.Coordinates;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates){ // must this be public?
        super(name, coordinates); // useing the name and corrdinates from super class ie Aircraft
        // this.name = name;
        // this.coordinates = coordinates;
    }

    public void updateConditions(){ // what goes inside here?
        String weather = this.weatherTower.getWeather(this.coordinates);
        if (weather == "RAIN" && this.coordinates.getHeight() > 0)
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
            System.out.println("Helicopter#"+this.name+"("+this.id+") Rain so nice aren't you happy you did not take the baloon look at them struggling to stay a float");
        }
        else if (weather == "FOG" && this.coordinates.getHeight() > 0)
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
            System.out.println("Helicopter#"+this.name+"("+this.id+") Oh no Fog Keep an eye out for King kong oh noo this is bad!!!");
        }
        else if (weather == "SUN" && this.coordinates.getHeight() > 0)
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
            System.out.println("Helicopter#"+this.name+"("+this.id+") Nice sunny day view is perfect if you look to the right you can see the amazing mountens if you look to your left you can see the stranded people in the life boat, aren't you happy to be here oh well!");
        }
        else if (weather == "SNOW" && this.coordinates.getHeight() > 0)
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
            System.out.println("Helicopter#"+this.name+"("+this.id+") Snow is here hope the rotor blades dont freeze!");
        }
        if (this.coordinates.getHeight() <= 0)
        {
            System.out.println("Helicopter#"+this.name+"("+this.id+") landing.");
            this.weatherTower.unregister(this);
            System.out.println("Tower says: Helicopter#"+this.name+"("+this.id+") unregistered from weather tower.");
        }
    }
    
    //Registers to the weather tower and extends through tower to use the register functions through inheritance
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: Helicopter#"+this.name+"("+this.id+") register to weather tower.");
	}
}