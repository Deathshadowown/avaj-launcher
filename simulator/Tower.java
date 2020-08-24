/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Tower.java                                         :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: svan-nie <marvin@42.fr>                    +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/11 15:59:33 by svan-nie          #+#    #+#             */
/*   Updated: 2020/08/11 15:59:33 by svan-nie         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package simulator;

import simulator.vehicles.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

public class Tower{
    private CopyOnWriteArrayList<Flyable> observers = new CopyOnWriteArrayList<Flyable>();
    

    public void register(Flyable flyable){
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    protected void conditionsChanged(){
        if (observers.size() >= 0) {
			for (Flyable flyable : observers) {
				flyable.updateConditions();
			}
		}
    }
}