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

public class JetPlane extends Aircraft{
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates){ // must this be public?
        super(name, coordinates) // useing the name and corrdinates from super class ie Aircraft
        // this.name = name;
        // this.coordinates = coordinates;
    }

    public void updateConditions(){ // what goes inside here?
        String weather = this.WeatherTower.getWeather(this.coordinates);
        if (weather.equalsIgnoreCase("RAIN") && this.coordinates > 0)
        {
            this.coordinates = new Coordinates(this.getLongitude(), this.getLatitude() + 5, this.getHeight());
        }
        else if (weather.equalsIgnoreCase("FOG") && this.coordinates > 0)
        {
            this.coordinates = new Coordinates(this.getLongitude(), this.getLatitude() + 1, this.getHeight());
        }
        else if (weather.equalsIgnoreCase("SUN") && this.coordinates > 0)
        {
            this.coordinates = new Coordinates(this.getLongitude(), this.getLatitude() + 10, this.getHeight() + 2);
        }
        else if (weather.equalsIgnoreCase("SNOW") && this.coordinates > 0)
        {
            this.coordinates = new Coordinates(this.getLongitude(), this.getLatitude(), this.getHeight() - 7);
        }
    }
    
    public void registerTower(WeatherTower weatherTower){
        
    }
}