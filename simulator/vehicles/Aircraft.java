/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Aircraft.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/11 15:59:47 by svan-nie          #+#    #+#             */
/*   Updated: 2020/08/11 15:59:47 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package avaj-launcher.simulator.vehicles;

public class Aircraft{
    private static long count = 0;
    protected long id;
    protected String name;
    protected coordinates:Coordinates

    protected Aircraft(name : String, coordinates : Coordinates){
        this.name = name;
        this.coordinates = coordinates:Coordinates;
    }
    
    private nextld(){
        id = ++count;
    }
}