/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   WeatherProvider.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/11 15:58:31 by svan-nie          #+#    #+#             */
/*   Updated: 2020/08/11 15:58:31 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package weather;

import weather.Coordinates;

public class WeatherProvider{
    private static WeatherProvider weatherProvider = new WeatherProvider(); // make sure its set back to private
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    public WeatherProvider(){
    }

    public static WeatherProvider getProvider() // make sure its set back to private
    {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        int height = coordinates.getHeight();
        if (height > 100)
        {
            height = 100;
        }
        if (height <= 100 && height >= 75)
        return (weather[0]);
        else if (height <= 74 && height >= 50)
        return (weather[1]);
        else if (height <= 49 && height >= 25)
        return (weather[2]);
        else if (height <= 24 && height >= 1) // chance to 0 maybe 0 means the ship must land
        return (weather[3]);
        return ("could not find weather"); // what must it do if it does not find anything
    }
}