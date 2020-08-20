/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Ballon.java                                        :+:      :+:    :+:   */
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


public class Ballon extends Aircraft{
    private WeatherTower weatherTower;

    public Ballon(String name, Coordinates coordinates){ // must this be public?
        super(name, coordinates); // useing the name and corrdinates from super class ie Aircraft
        // this.name = name;
        // this.coordinates = coordinates;
    }

    public void updateConditions(){ // what goes inside here?
        String weather = this.weatherTower.getWeather(this.coordinates);
        if (weather.equalsIgnoreCase("RAIN") && this.coordinates.getHeight() > 0)
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
            // simulator.printWrite.println("Ballon#"+this.name+(this.id));
            System.out.println("Ballon#"+this.name+(this.id));
        }
        else if (weather.equalsIgnoreCase("FOG") && this.coordinates.getHeight() > 0)
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
            // simulator.printWrite.println("Ballon#"+this.name+(this.id));
            System.out.println("Ballon#"+this.name+(this.id));
        }
        else if (weather.equalsIgnoreCase("SUN") && this.coordinates.getHeight() > 0)
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
            // simulator.printWrite.println("Ballon#"+this.name+(this.id));
            System.out.println("Ballon#"+this.name+(this.id));
        }
        else if (weather.equalsIgnoreCase("SNOW") && this.coordinates.getHeight() > 0)
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
            // simulator.printWrite.println("Ballon#"+this.name+(this.id));
            System.out.println("Ballon#"+this.name+(this.id));
        }
    }
    
    public void registerTower(WeatherTower weatherTower){ // how to register

    }
}