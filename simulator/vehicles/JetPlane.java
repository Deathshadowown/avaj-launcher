/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   JetPlane.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/11 16:00:34 by svan-nie          #+#    #+#             */
/*   Updated: 2020/08/11 16:00:34 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package simulator.vehicles;

import simulator.WeatherTower;
import weather.Coordinates;

public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates){ // must this be public?
        super(name, coordinates); // useing the name and corrdinates from super class ie Aircraft
        // this.name = name;
        // this.coordinates = coordinates;
    }
    public void updateConditions(){ // what goes inside here?
        String weather = this.weatherTower.getWeather(this.coordinates);
        if (weather == "RAIN" && this.coordinates.getHeight() > 0)
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
            System.out.println("JetPlane#"+this.name+"("+this.id+") A little bit of rain nevr bothered me, what's a whole lot going to do!");
        }
        else if (weather == "FOG" && this.coordinates.getHeight() > 0)
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
            System.out.println("JetPlane#"+this.name+"("+this.id+") So what if there is fog i can fly high!");
        }
        else if (weather == "SUN" && this.coordinates.getHeight() > 0)
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
            System.out.println("JetPlane#"+this.name+"("+this.id+") Sun this is amazing view to have!!");
        }
        else if (weather == "SNOW" && this.coordinates.getHeight() > 0)
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
            System.out.println("JetPlane#"+this.name+"("+this.id+") Oh no our Turbines could freeze up!");
        }
        if (this.coordinates.getHeight() <= 0)
        {
            System.out.println("JetPlane#"+this.name+"("+this.id+") landing.");
            this.weatherTower.unregister(this);
            System.out.println("Tower says: JetPlane#"+this.name+"("+this.id+") unregistered from weather tower.");
        }
    }
    
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: JetPlane#"+this.name+"("+this.id+") register to weather tower.");
	}
}