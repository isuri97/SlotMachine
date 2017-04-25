/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.ImageIcon;

/**
 *
 * @author isuri
 */
public interface ISymbol {
    void setImage(String path);
    ImageIcon getImage();
    void setValue(int v);
    int getValue();
}
