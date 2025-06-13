package edwin_david_tictactoe;

public class RegistroInicioSesion {

    private Jugador jugadores[] = new Jugador[50];
    private int cantidadJugadores = 0;

    public boolean registrarJugador(String nombreJugador, String usuario, String contrasenia, int puntos) {
        if (cantidadJugadores >= jugadores.length) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: Debe ingresar unicamente un caracter.");
            return false;
        }

        if (contrasenia.length() != 5) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: La contraseña debe tener exactamente 5 letras.");
            return false;
        }

        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i].getUsuario().equals(usuario)) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error: El nombre de usuario ya existe");
                return false;
            }
        }

        jugadores[cantidadJugadores] = new Jugador(nombreJugador, usuario, contrasenia, puntos);
        cantidadJugadores++;
        javax.swing.JOptionPane.showMessageDialog(null, "Registro de usuario exitoso!");
        return true;
    }

    public boolean inicioSesion(String usuario, String contrasenia) {
        for (Jugador jugador : jugadores) {
            if (jugador != null && jugador.getUsuario().equals(usuario) && jugador.getContrasenia().equals(contrasenia)) {
                javax.swing.JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso!");
                return true;
            }
        }

        javax.swing.JOptionPane.showMessageDialog(null, "Error: Usuario o contraseña incorrecta.");
        return false;
    }

    public Jugador obtenerJugador(int i) {
        if (i >= 0 && i < cantidadJugadores) {
            return jugadores[i];
        }
        return null;
    }
    
    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

}
