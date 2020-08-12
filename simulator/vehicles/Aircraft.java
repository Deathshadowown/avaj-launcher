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

public class Aircraft{
    private static long count = 0;
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    public Aircraft(String name, Coordinates coordinates){//, Coordinates coordinates
        this.name = name;
        this.coordinates = coordinates;
    }
    
    private long nextld(){
        id = ++count;
        return this.id;
    }
}