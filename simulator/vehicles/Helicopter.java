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

class public Helicopter{
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates){ // must this be public?
        this.name = name;
        this.coordinates = coordinates;
    }

    public void updateConditions(){ // what goes inside here?
    }
    
    public void registerTower(WeatherTower weatherTower){
        
    }
}