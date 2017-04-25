/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;

/**
 *
 * @author isuri
 */
public class Reel {

    ArrayList<Symbol> symbols = new ArrayList<Symbol>();

    public Reel() {
        Object[][] ary = {{"redseven", 7}, {"bell", 6}, {"watermelon", 5}, {"plum", 4}, {"lemon", 3}, {"cherry", 2}};
        for (Object[] objects : ary) {
            symbols.add(new Symbol("/images/"+objects[0].toString()+".png", (int) objects[1]));
        }
        Collections.shuffle(symbols);
    }

    public ArrayList<Symbol> spin() {
        Collections.shuffle(symbols);
        return this.symbols;
    }
}
