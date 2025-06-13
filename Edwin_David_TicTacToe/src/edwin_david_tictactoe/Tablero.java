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
           Fichas[i][j]="X";
           setTurno(false);
           revisionCasillas();
           mostradorTurnos(getTurno());
           
          }else{
              //Logica para jugador 0
            ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/cero.png"));
            Casillas[i][j].setIcon(icono);
            Casillas[i][j].setText(null);
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
        
        //Revisa el contenido de cada una de las fichas

        //Case 1
        String casillasRevisadas[] = new String[3]; //Arreglo que guarda la informacin de cada una de las casillas
        for(int i=0; i<Fichas.length; i++){
            
            casillasRevisadas[i]=Fichas[0][i];
        }
        try{

        //Revisar que coincidan con la primera fila
        for(int i=0; i<Fichas.length; i++){
            //Verificador en caso que la casilla esté vacia
            if(Fichas[0][i]==null){
                casillasRevisadas[i]="null";
            }else{
                casillasRevisadas[i]=Fichas[0][i];
            }

        }
        
        if(casillasRevisadas[0].equals(casillasRevisadas[1]) && casillasRevisadas[1].equals(casillasRevisadas[2])){
            JOptionPane.showMessageDialog(null, "Ha ganado el jugador "+casillasRevisadas[0]);
        }else{
            //Revisar que coincidan con segunda fila
            for(int i=0; i<Fichas.length; i++){
            
                //Verificador en caso que la casilla esté vacia
                if(Fichas[1][i]==null){
                    casillasRevisadas[i]="null";
                }else{
                    casillasRevisadas[i]=Fichas[1][i];
                }
            }
            
            if(casillasRevisadas[0].equals(casillasRevisadas[1]) && casillasRevisadas[1].equals(casillasRevisadas[2])){
                JOptionPane.showMessageDialog(null, "Ha ganado el jugador "+casillasRevisadas[0]);
            }else{
                //Revisar que coinidan con la tercera fila
                for(int i=0; i<Fichas.length; i++){
                    if(Fichas[2][i]==null){
                        casillasRevisadas[i]="null";
                    }else{
                        casillasRevisadas[i]=Fichas[2][i];
                    } 
                }
                
                if(casillasRevisadas[0].equals(casillasRevisadas[1]) && casillasRevisadas[1].equals(casillasRevisadas[2])){
                    JOptionPane.showMessageDialog(null, "Ha ganado el jugador "+casillasRevisadas[0]);
                }else{
                    
                    //Revisar que coinidan la primera columna
                    for(int i=0; i<Fichas.length; i++){
                        if(Fichas[i][0]==null){
                        casillasRevisadas[i]="null";
                        }else{
                            casillasRevisadas[i]=Fichas[i][0];
                        }
                    }
                    
                    if(casillasRevisadas[0].equals(casillasRevisadas[1]) && casillasRevisadas[1].equals(casillasRevisadas[2])){
                        JOptionPane.showMessageDialog(null, "Ha ganado el jugador "+casillasRevisadas[0]);
                    }else{
                        
                       //Revisar que coincidan la segunda columna
                        for(int i=0; i<Fichas.length; i++){
                            if(Fichas[i][1]==null){
                                casillasRevisadas[i]="null";
                            }else{
                                casillasRevisadas[i]=Fichas[i][1];
                            }
                        }
                        
                        if(casillasRevisadas[0].equals(casillasRevisadas[1]) && casillasRevisadas[1].equals(casillasRevisadas[2])){
                            JOptionPane.showMessageDialog(null, "Ha ganado el jugador "+casillasRevisadas[0]);
                        }else{
                           
                            //Revisar que coincidan la tercera columna
                            for(int i=0; i<Fichas.length; i++){
                                if(Fichas[i][1]==null){
                                    casillasRevisadas[i]="null";
                                }else{
                                    casillasRevisadas[i]=Fichas[i][1];
                                }
                            }
                            
                            if(casillasRevisadas[0].equals(casillasRevisadas[1]) && casillasRevisadas[1].equals(casillasRevisadas[2])){
                                JOptionPane.showMessageDialog(null, "Ha ganado el jugador "+casillasRevisadas[0]);
                            }else{
                                
                               //Revisar que coincidan la primera diagonal
                               casillasRevisadas[0]=Fichas[0][0];
                               casillasRevisadas[0]=Fichas[1][1];
                               casillasRevisadas[0]=Fichas[2][2];
                               
                               if(casillasRevisadas[0].equals(casillasRevisadas[1]) && casillasRevisadas[1].equals(casillasRevisadas[2])){
                                    JOptionPane.showMessageDialog(null, "Ha ganado el jugador "+casillasRevisadas[0]);
                               }else{
                                   
                                   //Revisar que coincidan la segunda diagonal
                                    casillasRevisadas[0]=Fichas[0][2];
                                    casillasRevisadas[0]=Fichas[1][1];
                                    casillasRevisadas[0]=Fichas[2][0];
                                     if(casillasRevisadas[0].equals(casillasRevisadas[1]) && casillasRevisadas[1].equals(casillasRevisadas[2])){
                                        JOptionPane.showMessageDialog(null, "Ha ganado el jugador "+casillasRevisadas[0]);
                                    }else{
                                        System.out.println("Aun no se ha determinado el ganador");
                                    }
                               }
                               
                              
                               
 
                            }    
                        }    
                    }        
                }     
            }                 
        }
                
                
            }catch(NullPointerException e){
            System.out.println("No se determina aun ganador");
        }
        
    }//Cierre de metodo
        

    }


    
    
    
    
    

