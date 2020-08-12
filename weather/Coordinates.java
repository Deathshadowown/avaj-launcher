/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Coordinates.java                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/11 15:58:55 by svan-nie          #+#    #+#             */
/*   Updated: 2020/08/11 15:58:55 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package weather;

public class Coordinates{
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height)
    {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude(){
        return this.longitude;
    }
    public int getLatitude(){
        return this.latitude;
    }
    public int getHeight(){
        return this.height;
    }
}