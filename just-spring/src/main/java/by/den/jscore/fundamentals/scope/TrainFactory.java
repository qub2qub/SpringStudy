/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jscore.fundamentals.scope;

/**
 *
 * @author mkonda
 */
public class TrainFactory {

    public int getInstance() {
        return this.hashCode();
    }
}
