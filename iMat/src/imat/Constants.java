/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imat;

import java.awt.Color;

/**
 *
 * @author mats
 */
public final class Constants {
    public static final Color DEFAULT_COLOR = Color.white;
    public static final Color HOVER_COLOR = new Color(246, 246, 246);
    public static final Color PRESSED_COLOR = new Color(237, 237, 237);
    
    public static final Color HIGHLIGHT_COLOR = new Color(255, 251, 10);
    public static final Color HIGHLIGHT_HOVER_COLOR = new Color(255, 238, 5);
    public static final Color HIGHLIGHT_PRESSED_COLOR = new Color(255, 219, 15);
    
    private Constants() {
        throw new AssertionError();
    }
}
