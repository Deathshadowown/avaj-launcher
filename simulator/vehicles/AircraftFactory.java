/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   AircraftFactory.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/18 15:08:32 by svan-nie          #+#    #+#             */
/*   Updated: 2020/08/18 15:08:32 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package simulator.vehicles;

import simulator.vehicles.Flyable;
import weather.*;
// must be made abstract class
public class AircraftFactory{
    public static Flyable(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        Flyable newAircraft;
        switch (type) {
            case "Helicopter":
            newAircraft = new Helicopter(name, coordinates);
            return newAircraft;
            case "jetPlane":
            newAircraft = new jetPlane(name, coordinates);
            return newAircraft;
            clase "Ballon"
            newAircraft = new Ballon(name, coordinates);
            return newAircraft;
            default: // if any error
            System.out.println("could not find any Aircraft?!!");
            return NULL;
                // break;
        }
    }
}