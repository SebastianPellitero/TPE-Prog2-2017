import java.util.ArrayList;

public class Partida {
    Jugador jugador1;
    Jugador jugador2;
    Mazo mazoDeCartas;

    Partida(Jugador jugador1, Jugador jugador2, Mazo mazoDeCartas ){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.mazoDeCartas = mazoDeCartas;
    }

    void repartirCartas(){
        jugador1.recibirCartas(mazoDeCartas.repartirCartas());
        jugador2.recibirCartas(mazoDeCartas.repartirCartas());
    }

    Jugador jugarRonda(Jugador turno){
        jugador1.seleccionarCarta();
        jugador2.seleccionarCarta();
        String atributoElegido = turno.elegirAtributo();
        if(jugador1.decirValorDeCarta(atributoElegido) > jugador2.decirValorDeCarta(atributoElegido)){
            jugador1.ganaUnaCarta(jugador2.pierdeUnaCarta());
            return(jugador1);
        }else{
            if(jugador2.decirValorDeCarta(atributoElegido) > jugador1.decirValorDeCarta(atributoElegido)) {
                jugador2.ganaUnaCarta(jugador1.pierdeUnaCarta());
                return(jugador2);
            }else{
                jugador1.resultaEmpate();
                jugador2.resultaEmpate();
                return(turno);
            }
        }
    }

    String jugarPartida(){
        Jugador turno = jugador1;
        while (jugador1.tieneCartas() && jugador2.tieneCartas()){
            turno = jugarRonda(turno);
        }
        if (jugador1.tieneCartas())
            return("Gano el Jugador " + jugador1.getNombre());
        else if(jugador2.tieneCartas())
            return("GANO EL JUGADOR " + jugador2.getNombre());
        return("La partida termino");
    }


    String jugarPartidaPorRondas(int cantRondas){
        int iteracion = 0;
        Jugador turno = jugador1;
        while (jugador1.tieneCartas() && jugador2.tieneCartas() && iteracion < cantRondas){
            turno = jugarRonda(turno);
            iteracion++;
        }
        if (jugador1.tieneCartas()){
            if (jugador2.tieneCartas()) {
                if (jugador1.contarCartas() > jugador2.contarCartas()){
                    return("Gano el Jugador " + jugador1.getNombre() + " Por maxima cantidad de cartas");
                }
                else{
                    if(jugador1.contarCartas() < jugador2.contarCartas()) {
                        return ("Gano el Jugador " + jugador2.getNombre() + " Por maxima cantidad de cartas");
                    }
                    else{
                        if (jugador1.contarCartas() == jugador2.contarCartas())
                            return ("EMPATE");
                        }
                }
            }
            return("Gano el Jugador" + jugador1.getNombre());
        }
        return("Gano el Jugador" + jugador2.getNombre());
    }
}

 /*String jugarPartida(){
        Jugador turno = jugador1;
        while (jugador1.tieneCartas() && jugador2.tieneCartas()){
            jugador1.seleccionarCarta();
            jugador2.seleccionarCarta();
            String atributoElegido = turno.elegirAtributo();
            if(jugador1.decirValorDeCarta(atributoElegido) > jugador2.decirValorDeCarta(atributoElegido)){
                jugador1.ganaUnaCarta(jugador2.pierdeUnaCarta());
                turno = jugador1;
            }else{
                if(jugador2.decirValorDeCarta(atributoElegido) > jugador1.decirValorDeCarta(atributoElegido)) {
                    jugador2.ganaUnaCarta(jugador1.pierdeUnaCarta());
                    turno = jugador2;
                }else{
                    jugador1.resultaEmpate();
                    jugador2.resultaEmpate();
                }
            }
        }
        if (jugador1.tieneCartas())
            return("Gano el Jugador " + jugador1.getNombre());
        else if(jugador2.tieneCartas())
            return("GANO EL JUGADOR " + jugador2.getNombre());
        return("La partida termino");
    } */
