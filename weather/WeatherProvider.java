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
    private static weatherProvider = new WeatherProvider();
    private static String[] = weather{"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(){

    }

    public static WeatherProvider getProvider()
    {
        return weatherProvider;
    }

    public static String getCurrentWeather(Coordinates coordinates){
        
    }
}