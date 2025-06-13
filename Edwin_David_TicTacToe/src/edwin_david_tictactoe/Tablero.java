/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edwin_david_tictactoe;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



/**
 *
 * @author David
 */
public class Tablero {
    private JButton Casillas[][] = new JButton[3][3]; //Almacena botones de acuerdo a posicion
    private String Fichas[][]= new String[3][3];
    private boolean turnos= true; //true = jugador X   false = Jugador 0
    
    
    //Constructor tablero
    public Tablero(){
        //Crea Jframes, JPanels y GridLayout
        JFrame frame= new JFrame();
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(3,3);
        panel.setLayout(grid);
        
        for(int i=0; i<Casillas.length; i++){
            for(int j=0; j<Casillas.length; j++){
                JButton espacio= new JButton("Posicion"+i+j);
                espacio.setSize(100, 100);
                Casillas[i][j]=espacio;
                panel.add(Casillas[i][j]);
            }
        }
        
        //Caracterisiticas de Frame
        frame.add(panel);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        
        
    }
    
    
    
    
    
}
