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
    private WeatherTower weatherTower = new WeatherTower();

    public Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = this.weatherTower.getWeather(this.coordinates);
        Boolean thisCoordinatesTrue = this.coordinates.getHeight() > 0;
        String baloonMessage = "Baloon#"+this.name+"("+this.id;
        String landingMessage = "Baloon#"+this.name+"("+this.id+") landing."+ "\n"+"Tower says: Baloon#"+this.name+"("+this.id+") unregistered from weather tower.";
        String rainMessage = ") Mayday mayday not looking good this rain is making it hard to control";
        String fogMessage = ") Oh dear we in fog everyone start praying we dont hit a skyscraper!!";
        String sunMessage = ") what a breeze today is going to be a great day nice and sunny!";
        String snowMessage = ") This snow is making this hard to fly, hope we dont crash!";

        switch(weather)
        {
            case "RAIN":
            {
                if (thisCoordinatesTrue)
                {
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
                System.out.println(baloonMessage + rainMessage);
                }
                break;
            }
            case "FOG":
            {
                if (thisCoordinatesTrue)
                {
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
                System.out.println(baloonMessage + fogMessage);
                }
                break;
            }
            case "SUN":
            {
                if (thisCoordinatesTrue)
                {
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
                System.out.println(baloonMessage + sunMessage);
                }
                break;
            }
            case "SNOW":
            {
                if (thisCoordinatesTrue)
                {
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
                System.out.println(baloonMessage + snowMessage);
                }
                break;
            }
        }
        if (this.coordinates.getHeight() <= 0)
        {
            System.out.println(landingMessage);
            this.weatherTower.unregister(this);
        }
    }
	public void registerTower(WeatherTower weatherTower) {
        String registerToTowerMessage = "Tower says: Baloon#"+this.name+"("+this.id+") register to weather tower.";
		this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println(registerToTowerMessage);
	}
}