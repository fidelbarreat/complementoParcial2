/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complementoparcial2;

/**
 *
 * @author fidel
 */
public class NodeArbol {
    char value;
    NodeArbol left, right;
 
    NodeArbol(char item) {
        value = item;
        left = right = null;
    }
}
