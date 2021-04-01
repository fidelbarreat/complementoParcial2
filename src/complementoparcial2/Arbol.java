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
public class Arbol {
    // A utility function to check if 'c'
    // is an operator
 
    static boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') {
            return true;
        }
        return false;
    }
 
    // Utility function to do inorder traversal
    static void inorder(NodeArbol t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.value + " ");
            inorder(t.right);
        }
    }
    
    public static void Postorden(NodeArbol padre){
        if(padre!=null){
            Postorden(padre.left);
            Postorden(padre.right); 
            System.out.print(padre.value+" ");
        }
    }
 
    // Returns root of constructed tree for given
    // postfix expression
    public static NodeArbol constructTree(char postfix[]) {
        PilaArbol pilaArbol = new PilaArbol();
        NodeArbol t, t1, t2;
 
        // Traverse through every character of
        // input expression
        for (int i = 0; i < postfix.length; i++) {
 
            // If operand, simply push into stack
            if (!isOperator(postfix[i])) {
                t = new NodeArbol(postfix[i]);
                pilaArbol.apilar(t);
            } else // operator
            {
                t = new NodeArbol(postfix[i]);
 
                // Pop two top nodes
                // Store top
                t1 = pilaArbol.cima.info; 
                pilaArbol.desapilar();// Remove top
                t2 = pilaArbol.cima.info;
                pilaArbol.desapilar();
 
                //  make them children
                t.right = t1;
                t.left = t2;
 
                // System.out.println(t1 + "" + t2);
                // Add this subexpression to stack
                pilaArbol.apilar(t);
            }
        }
 
        //  only element will be root of expression
        //  tree
        t = pilaArbol.cima.info;
        pilaArbol.desapilar();
 
        return t;
    }
}
