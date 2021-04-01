/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complementoparcial2;

public class Lista {
    static Node head;
    static Node tail;
    static int in;
    
    
    
    static void insertar(String info){
        
        if(head == null){
                        in=in+1;
                        head = new Node(info);
                        tail = new Node(info);

                    }else{
                        if(in==1){
                            in=in+1;
                            tail = new Node(info);    
                            head.next = tail;
                           

                        }else{
                            in=in+1;
                            tail.next = new Node(info); 
                            tail = tail.next;
                        }
                    
                    }
        
        }
    
    
}
