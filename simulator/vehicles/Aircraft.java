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

    protected Aircraft(String name, Coordinates coordinates){//, Coordinates coordinates // must be made protected at the end its public for testing
        idCounter = nextId();
        this.id = idCounter;
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId(){
        ++idCounter;
        return idCounter;
    }
}