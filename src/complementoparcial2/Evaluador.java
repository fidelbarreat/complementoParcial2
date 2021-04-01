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
public class Evaluador {

    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public static String infija_postfija(String infija) {
        String postfija = new String();
        Pila pila = new Pila();

        for (int i = 0; i < infija.length(); ++i) {

            char c = infija.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                postfija += c;
            } else if (c == '(') {
                pila.apilar(Character.toString(c));
            } else if (c == ')') {
                while (pila.cima != null && pila.cima.info.charAt(0) != '(') {
                    Node aux = pila.cima;
                    postfija += aux.info;
                    pila.desapilar();
                }
            } else {
                while (pila.cima != null && Prec(c) <= Prec(pila.cima.info.charAt(0))) {
                    Node aux = pila.cima;
                    postfija += aux.info;
                    pila.desapilar();

                }
                pila.apilar(Character.toString(c));
            }
        }
        while (pila.cima != null) {

            Node aux = pila.cima;
            pila.desapilar();
            if (aux.info.charAt(0) != '(') {
                postfija += aux.info;
            }
        }
        return postfija;
    }

    public static String prefija_postfija(String prefija) {
        Pila pila = new Pila();

        for (int i = prefija.length() - 1; i >= 0; i--) {
            char c = prefija.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                String o1 = "";
                String o2 = "";

                o1 = pila.cima.info;
                pila.desapilar();

                o2 = pila.cima.info;
                pila.desapilar();

                pila.apilar(o1 + o2 + c);
            } else {
                pila.apilar(Character.toString(c));
            }
        }
        return pila.cima.info;
    }

    public static String checkTypeOfExpression(String expression) {
        int sizeOfExpression = expression.length();
        char first = expression.charAt(0);
        char last = expression.charAt(sizeOfExpression - 1);
        String type = "";
        Character.isDigit(first);
        if ((expression.contains("(") && expression.contains(")")) || (Character.isDigit(first) && Character.isDigit(last)) || (Character.isLetter(first) && Character.isLetter(last))) {
            type = typeOfExpression(1, expression);
            return type;
        } else if ((first == '*' || first == '/' || first == '+' || first == '-' || first == '^') && !(last == '*' || last == '/' || last == '+' || last == '-' || last == '^')) {
            type = typeOfExpression(2, expression);
            return type;
        } else if ((last == '*' || last == '/' || last == '+' || last == '-' || last == '^') && !(first == '*' || first == '/' || first == '+' || first == '-' || first == '^')) {
            type = typeOfExpression(3, expression);
            return type;
        }
        type = typeOfExpression(-1, expression);
        return type;
    }

    public static String typeOfExpression(int num, String expression) {
        switch (num) {
            case 1:
                System.out.println("infija");
                return infija_postfija(expression);
            case 2:
                System.out.println("prefija");
                return prefija_postfija(expression);
            case 3:
                System.out.println("postfija");
                return expression;
            default:
                return "ERR";
        }
    }
}
