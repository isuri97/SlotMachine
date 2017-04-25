/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author isuri
 */
public class Symbol implements ISymbol{
    ImageIcon image;
    int value;

    public Symbol(String path, int value) {
        setImage(path);
        this.value = value;
    }
    
    @Override
    public void setImage(String path) {
        Image img = new ImageIcon(getClass().getResource(path)).getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        this.image = new ImageIcon(img);
    }

    @Override
    public ImageIcon getImage() {
        return this.image;
    }

    @Override
    public void setValue(int v) {
        this.value = v;
    }

    @Override
    public int getValue() {
        return this.value;
    }
    
}
