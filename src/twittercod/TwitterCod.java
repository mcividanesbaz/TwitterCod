/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twittercod;

import javax.swing.JOptionPane;
import twitter4j.TwitterException;

/**
 *
 * @author Marcos
 */
public class TwitterCod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TwitterException {
     
        String busqueda;
        String tweet;
        int opcion;
        
        MetodosTwitter obj = new MetodosTwitter();
        
        
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("opciones: \n1 --> TimeLine\n2 --> Buscar\n3 --> Tweettear\n4 --> Exit"));
            switch (opcion) {
                case 1:
                    obj.TimeLine();
                    break;
                case 2:
                    busqueda = JOptionPane.showInputDialog("Introduzca la palabra por la que desee buscar");
                    obj.ShowString(busqueda);
                    break;
                case 3:
                    tweet = JOptionPane.showInputDialog("Introduzca lo que desee twittear");
                    obj.Twittear(tweet);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.exit(0);
            }
        } while (opcion != 0 && opcion != 4);
    }
        
        
        
    }
    
}
