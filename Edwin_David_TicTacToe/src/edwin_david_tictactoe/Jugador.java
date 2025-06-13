package edwin_david_tictactoe;

public class Jugador {

    private String nombreJugador;
    private String usuario;
    private String contrasenia;
    private int puntos;

    public Jugador(String nombreJugador, String usuario, String contrasenia, int puntos) {
        this.nombreJugador = nombreJugador;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombreJugador;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = this.puntos + puntos;
    }
}
