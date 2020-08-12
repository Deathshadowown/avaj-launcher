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

public class Simulator{
    public static void main(String[] args){
        System.out.println("hello!!");
        Aircraft aircraft = new Aircraft("shane", 5); // wont work stuff is protected
        // aircraft.name = "Shane";
        // System.out.println(aircraft.getName());
    }
}