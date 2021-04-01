/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complementoparcial2;


public class Pila {
    static Node cima;
    static int en;
    
    public Pila() {
        cima = null;
        en = 0;
    }
    
    static void apilar(String num){
        Node pNew = new Node(num);
        pNew.next = cima;
        cima=pNew;
        en=en+1;
        
               
        
    }
    static void desapilar(){
        Node ptemp=cima;
        cima = cima.next;
        en=en-1;
    }
    
}
