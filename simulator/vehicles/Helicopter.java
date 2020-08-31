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
import simulator.*;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = this.weatherTower.getWeather(this.coordinates);
        Boolean thisCoordinatesTrue = this.coordinates.getHeight() > 0;
        String helicopterMessage = "Helicopter#"+this.name+"("+this.id;
        String landingMessage = "Helicopter#"+this.name+"("+this.id+") landing."+ "\n"+"Tower says: Helicopter#"+this.name+"("+this.id+") unregistered from weather tower.";
        String rainMessage = ") Rain so nice aren't you happy you did not take the baloon look at them struggling to stay a float";
        String fogMessage = ") Oh no Fog Keep an eye out for King kong oh noo this is bad!!!";
        String sunMessage = ") Nice sunny day view is perfect if you look to the right you can see the amazing mountens if you look to your left you can see the stranded people in the life boat, aren't you happy to be here oh well!";
        String snowMessage = ") Snow is here hope the rotor blades dont freeze!";

        switch(weather)
        {
            case "RAIN":
            {
                if (thisCoordinatesTrue)
                {
                    this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
                    Simulator.printwriter.println(helicopterMessage + rainMessage);
                }
                break;
            }
            case "FOG":
            {
                if (thisCoordinatesTrue)
                {
                    this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
                    Simulator.printwriter.println(helicopterMessage + fogMessage);
                }
                break;
            }
            case "SUN":
            {
                if (thisCoordinatesTrue)
                {
                    this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
                    Simulator.printwriter.println(helicopterMessage + sunMessage);
                }
                break;
            }
            case "SNOW":
            {
                if (thisCoordinatesTrue)
                {
                    this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
                    Simulator.printwriter.println(helicopterMessage + snowMessage);
                }
                break;
            }
        }
        if (this.coordinates.getHeight() <= 0)
        {
            Simulator.printwriter.println(landingMessage);
            this.weatherTower.unregister(this);
        }
    }
    
	public void registerTower(WeatherTower weatherTower) {
        String registerToTowerMessage = "Tower says: Helicopter#"+this.name+"("+this.id+") register to weather tower.";
		this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.printwriter.println(registerToTowerMessage);
	}
}