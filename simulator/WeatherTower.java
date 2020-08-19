/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   WeatherTower.java                                  :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/11 15:59:37 by svan-nie          #+#    #+#             */
/*   Updated: 2020/08/11 15:59:37 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package simulator;

import weather.*;

public class WeatherTower{ 
    // get weather is going to be useing the WeatherProvider;
    public String getWeather(Coordinates coordinates) // what string does this return is it the weather type of the cor?
    {
        System.out.println("inside getweather");
        System.out.println(coordinates.getHeight());
        String fullString;
        fullString = coordinates.getLongitude() + " " + coordinates.getLatitude() + " " + coordinates.getHeight();
        // String toString();
        return fullString;
    }

    private void changeWeather(){
        
    }
}