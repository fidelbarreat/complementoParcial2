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
public class PilaArbol {
    static NodePilaArbol cima;
    static int en;
    
    public PilaArbol() {
        cima = null;
        en = 0;
    }
    
    static void apilar(NodeArbol c){
        NodePilaArbol pNew = new NodePilaArbol(c);
        pNew.next = cima;
        cima=pNew;
        en=en+1;
        
               
        
    }
    static void desapilar(){
        NodePilaArbol ptemp=cima;
        cima = cima.next;
        en=en-1;
    }
}
