/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edwin_david_tictactoe;

/**
 *
 * @author David
 */
public class GlobalData {
    public Jugador jugadorInciado;
    public Jugador jugadorContricante;
    
    
    public void setJugadorIniciado(Jugador player1){
        this.jugadorInciado= player1;
    }
    
    public void setJugadorContricante(Jugador player2){
        this.jugadorContricante=player2;
    }
    
    public Jugador getJugadorIniciado(){
        return jugadorInciado;
    }
    
    public Jugador getJugadorContricante(){
        return jugadorContricante;
    }
    
    
    
    
    
    
    
}
