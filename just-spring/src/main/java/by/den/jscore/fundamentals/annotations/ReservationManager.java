/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jscore.fundamentals.annotations;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mkonda
 */
public class ReservationManager {
    
    @Autowired
    private ReservationService reservationService = null;

    
    public void reserve() {
        
        System.out.println("Res svs: "+reservationService);
    }
}
