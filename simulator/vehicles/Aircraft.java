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

package simulator.vehicles;

import weather.Coordinates;

//must be made abstract class
public class Aircraft{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    public Aircraft(String name, Coordinates coordinates){//, Coordinates coordinates
        id = idCounter;
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextld(){
        ++idCounter;
        return this.id;
    }
}