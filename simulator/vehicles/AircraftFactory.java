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
public abstract class AircraftFactory{
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        // Flyable newAircraft;
        switch (type) {
            case "Helicopter":
            return (new Helicopter(name, coordinates));
            case "JetPlane":
            return (new JetPlane(name, coordinates));
            case "Baloon":
            return (new Baloon(name, coordinates));
            default: // if any error or not an AirCraft
            return null;
        }
    }
}