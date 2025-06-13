/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edwin_david_tictactoe;

import java.awt.Color;
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
    private String Fichas[][]= new String[3][3]; //Almacena que tipo de ficha es en cada casilla
    private boolean turnos= true; //true = jugador X   false = Jugador 0
    private JFrame frameGamePlay; //Guarda el frame de juego para uso en distintos metodos
    
    //Constructor tablero
    public Tablero(){
        //Crea Jframes, JPanels y GridLayout
        JFrame frame= new JFrame();
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(3,3);
        panel.setLayout(grid);
        
        for(int i=0; i<Casillas.length; i++){
            for(int j=0; j<Casillas.length; j++){
                JButton espacio= new JButton();
                espacio.setBackground(Color.white);
                espacio.setSize(100, 100);
                Casillas[i][j]=espacio;
                asignarFichas(i, j);
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
        frameGamePlay=frame;
        
    }
    
    //Desarrollo de asignacion de fichas
    private void asignarFichas(int i, int j){
        
        System.out.println(turnos);
        
        
        Casillas[i][j].addActionListener(e ->{
          if(turnos ==true){
           //Logica para jugador X
           ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/equis.png"));
           Casillas[i][j].setIcon(icono);
           Casillas[i][j].setText(null);
           Casillas[i][j].setEnabled(false);
           Casillas[i][j].setOpaque(true);
           Casillas[i][j].setForeground(Color.white);
           Casillas[i][j].setDisabledIcon(icono);
           
           Fichas[i][j]="X";
           setTurno(false);
           revisionCasillas();
           mostradorTurnos(getTurno());
           
          }else{
              //Logica para jugador 0
            ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/cero.png"));
            Casillas[i][j].setIcon(icono);
            Casillas[i][j].setText(null);
            Casillas[i][j].setEnabled(false);
            Casillas[i][j].setOpaque(true);
            Casillas[i][j].setForeground(Color.white);
            Casillas[i][j].setDisabledIcon(icono);
            Fichas[i][j]="O";
            setTurno(true);
            revisionCasillas();
            mostradorTurnos(getTurno());
          }  
        });
        
        
    }
    
    //Set de turno
    public boolean setTurno(boolean eleccion){
        turnos=eleccion;
        return turnos;
    }
    
    //Get de turno
    public boolean getTurno(){
        return turnos;
    }
    
    //Crea metodo para mostrar que jugador tiene el turno (Test)
    public void mostradorTurnos(boolean turno){
        if(turno==true){
            System.out.println("Es el turno del jugador 1 (Bando de X)");
        }else{
            System.out.println("Es el turno del jugador 2 (Bando de 0)");
        }
    }
    
    public void revisionCasillas(){
        //Revision de filas y columnas
        for(int i= 0; i<3; i++){
            //Revisar filas
            if(areaGanadora(Fichas[i][0], Fichas[i][1], Fichas[i][2])){
                JOptionPane.showMessageDialog(null, "Ha ganado el jugador "+Fichas[i][0]);
                frameGamePlay.setVisible(false);
                return;
            }
            
            //Revisar columnas
            if(areaGanadora(Fichas[0][i], Fichas[1][i], Fichas[2][i])){
                JOptionPane.showMessageDialog(null, "Ha ganado el jugador "+Fichas[0][i]);
                frameGamePlay.setVisible(false);
                return;
            }  
        }
        
        //Revision de diagonal A
        if(areaGanadora(Fichas[0][0],Fichas[1][1], Fichas[2][2])){
            JOptionPane.showMessageDialog(null, "Ha ganado el jugador "+Fichas[0][0]);
            frameGamePlay.setVisible(false);
            return;
        }
        
        //Revision de diagonal B
        if(areaGanadora(Fichas[0][2], Fichas[1][1], Fichas[2][0])){
            JOptionPane.showMessageDialog(null, "Ha ganado el jugador "+Fichas[0][2]);
            frameGamePlay.setVisible(false);
            return;
        }
        
        //Ver si estan todas las casillas llenas
        //Se asume que no hubo ganador y es un empate
        decisionEmpate();
        System.out.println("Aun no hay ganador");
        
        
        
        
        
        
    }//Cierre de metodo
    
    //Creacion de metodo que determina el empate
    private void decisionEmpate(){
        boolean filas[] = new boolean[3];
        
        for(int i=0; i<3; i++){
            if(Fichas[i][1]!=null && Fichas[i][1] != null && Fichas[i][2] !=null){
                filas[i]=true;
            }
        }
        
        if(filas[0]==true && filas[1]== true && filas[2]==true){
           JOptionPane.showMessageDialog(null, "Es un empate" );
           frameGamePlay.setVisible(false);
           return; 
        }
        
        return;
   
    }
            
    
    
    //Metodo que valida si tres fichas son iguales
    private boolean areaGanadora(String a, String b, String c){
        return a != null && a.equals(b) && a.equals(c);
    }
            
    
        

    }


    
    
    
    
    

