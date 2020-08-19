/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Simulator.java                                     :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/11 15:59:29 by svan-nie          #+#    #+#             */
/*   Updated: 2020/08/11 15:59:29 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package simulator;

import weather.Coordinates;
import simulator.vehicles.Aircraft;
import simulator.WeatherTower;
import weather.WeatherProvider;

public class Simulator{
    public static void main(String[] args){
        System.out.println("hello!!");
        Coordinates cor1 = new Coordinates(6,4,0);
        Aircraft aircraft = new Aircraft("shane", cor1); // wont work stuff is protected
        WeatherProvider weatherProvider = new WeatherProvider();
        WeatherTower weather = new WeatherTower();
        // System.out.println(cor1.longitude);
        int l;
        int lat;
        int h;
        l = cor1.getLongitude();
        lat = cor1.getLatitude();
        h = cor1.getHeight();
        System.out.println(l + " " + "yolo");
        System.out.println(lat + " " + "yolo");
        System.out.println(h + " " + "yolo");
        System.out.println(l + lat + h + " " + "yolo");
        // String weatherstring;
        // weatherstring = weather.getWeather(cor1);
        System.out.println(weather.getWeather(cor1) + " this is the cor");
        System.out.println("\n");
        // aircraft.name = "Shane";
        // String name;
        // int coor
        // coor = aircraft.getCorrdinates();
        // name = aircraft.getname();
        // System.out.println(name);
        // System.out.println(aircraft.getCorrdinates().getHeight());
        System.out.print(cor1 + "\n");
        // System.out.println();
        // System.out.println(aircraft.getName());
        System.out.println(weatherProvider.getProvider() + " yolo");
        System.out.println(weatherProvider.getCurrentWeather(cor1));
    }
}