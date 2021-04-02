/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complementoparcial2;

import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;

public class Arbol {
 
    static NodeArbol pRoot;
    static boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') {
            return true;
        }
        return false;
    }
 
    // Utility function to do inorder traversal
    static String inorder(NodeArbol t, String acm) {
        if (t != null) {
            acm = inorder(t.left, acm);
            acm += t.value;
            acm = inorder(t.right, acm);
        }
        return acm;
    }
    
    public static String Preorden(NodeArbol padre, String acm){
        if(padre!=null){
            acm += padre.value;
            acm = Postorden(padre.left, acm);
            acm = Postorden(padre.right, acm); 
        }
        return acm;
    }
    
    public static String Postorden(NodeArbol padre, String acm){
        if(padre!=null){
            acm = Postorden(padre.left, acm);
            acm = Postorden(padre.right, acm); 
            acm += padre.value;
        }
        return acm;
    }
 
    public static NodeArbol constructTree(char postfix[]) {
        PilaArbol pilaArbol = new PilaArbol();
        NodeArbol t, t1, t2;
 
        for (int i = 0; i < postfix.length; i++) {
 
            if (!isOperator(postfix[i])) {
                t = new NodeArbol(postfix[i]);
                pilaArbol.apilar(t);
            } else
            {
                t = new NodeArbol(postfix[i]);
 
                t1 = pilaArbol.cima.info; 
                pilaArbol.desapilar();
                t2 = pilaArbol.cima.info;
                pilaArbol.desapilar();
 
                t.right = t1;
                t.left = t2;
 
                pilaArbol.apilar(t);
            }
        }

        t = pRoot = pilaArbol.cima.info;
        pilaArbol.desapilar();
 
        return t;
    }
    
    public static void draw(NodeArbol root, MultiGraph imp) {
        
        if (root != null) {
            
            Node tmp = imp.getNode(""+root.value);
            
            if(tmp == null){
                imp.addNode(""+root.value);
                tmp = imp.getNode(""+root.value);
            }
            
            tmp.setAttribute("ui.style", "shape:circle;fill-color: #008f39;size: 35px; text-alignment: center;");
            tmp.setAttribute("ui.label", ""+root.value);
            if(root.left != null){
                imp.addNode( ""+root.left.value );
                imp.addEdge(""+root.value+":"+root.left.value, ""+root.value, ""+root.left.value);
            }
            
            if(root.right != null){
                imp.addNode( ""+root.right.value );
                imp.addEdge(""+root.value+":"+root.right.value, ""+root.value, ""+root.right.value);
            }
            
            draw(root.left,imp);
            draw(root.right,imp);
            
        }
    }
}
