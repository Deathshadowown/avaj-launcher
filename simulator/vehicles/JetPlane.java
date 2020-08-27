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

    public JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    public void updateConditions(){
        String weather = this.weatherTower.getWeather(this.coordinates);
        Boolean thisCoordinatesTrue = this.coordinates.getHeight() > 0;
        String JetPlaneMessage = "JetPlane#"+this.name+"("+this.id;
        String landingMessage = "JetPlane#"+this.name+"("+this.id+") landing."+ "\n"+"Tower says: JetPlane#"+this.name+"("+this.id+") unregistered from weather tower.";
        String rainMessage = ") A little bit of rain nevr bothered me, what's a whole lot going to do!";
        String fogMessage = ") So what if there is fog i can fly high!";
        String sunMessage = ") Sun this is amazing view to have!!";
        String snowMessage = ") Oh no our Turbines could freeze up!";

        switch(weather)
        {
            case "RAIN":
            {
                if (thisCoordinatesTrue)
                {
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
                System.out.println(JetPlaneMessage + rainMessage);
                }
                break;
            }
            case "FOG":
            {
                if (thisCoordinatesTrue)
                {
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
                System.out.println(JetPlaneMessage + fogMessage);
                }
                break;
            }
            case "SUN":
            {
                if (thisCoordinatesTrue)
                {
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
                System.out.println(JetPlaneMessage + sunMessage);
                }
                break;
            }
            case "SNOW":
            {
                if (thisCoordinatesTrue)
                {
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
                System.out.println(JetPlaneMessage + snowMessage);
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
        String registerToTowerMessage = "Tower says: JetPlane#"+this.name+"("+this.id+") register to weather tower.";
		this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println(registerToTowerMessage);
	}
}