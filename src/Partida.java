import java.util.ArrayList;

public class Partida {
    Jugador jugador1;
    Jugador jugador2;
    Mazo mazoDeCartas;

    Partida(Jugador jugador1, Jugador jugador2, Mazo mazoDeCartas ){
        this.jugador1 = new Jugador();
        this.jugador1=jugador1;
        this.jugador2 = new Jugador();
        this.jugador2=jugador2;
        this.mazoDeCartas = new Mazo();
        this.mazoDeCartas=mazoDeCartas;
    }

    void repartirCartas(){
        jugador1.recibirCartas(mazoDeCartas.repartirCartas());
        jugador1.mostrarTodaslasCartas();
        jugador2.recibirCartas(mazoDeCartas.repartirCartas());
        jugador2.mostrarTodaslasCartas();
    }

    void jugar(){
        while (jugador1.tieneCartas() && jugador2.tieneCartas()){
            jugador1.seleccionarCarta();
            jugador2.seleccionarCarta();
            String atributoElegido = jugador1.elegirAtributo();
            if(jugador1.decirValorDeCarta(atributoElegido) > jugador2.decirValorDeCarta(atributoElegido)){
                jugador1.ganaUnaCarta(jugador2.pierdeUnaCarta());
            }else{
                jugador2.ganaUnaCarta(jugador1.pierdeUnaCarta());
            }
        }
        if (jugador1.tieneCartas())
            System.out.println("Gano el Jugador " + jugador1.getNombre());
        else if(jugador2.tieneCartas())
            System.out.println("GANO EL JUGADOR " + jugador2.getNombre());
    }

}
