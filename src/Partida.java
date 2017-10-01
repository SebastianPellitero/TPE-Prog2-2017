public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorDeTurno;
    private Mazo mazoDeCartas;

    Partida(Jugador jugador1, Jugador jugador2, Mazo mazoDeCartas ){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugadorDeTurno = jugador1;
        this.mazoDeCartas = mazoDeCartas;
    }

    public void jugarRonda(){
        jugador1.mostrarTodaslasCartas();
        jugador2.mostrarTodaslasCartas();
        jugador1.seleccionarPrimerCarta();
        jugador2.seleccionarPrimerCarta();
        String atributoElegido = jugadorDeTurno.elegirAtributo();
        System.out.println("atrib" + atributoElegido);
        if(jugador1.getValorAtributoElegido(atributoElegido) > jugador2.getValorAtributoElegido(atributoElegido)){
            jugador1.ganaUnaCarta(jugador2.pierdeUnaCarta());
            jugadorDeTurno = jugador1;
        }else if(jugador1.getValorAtributoElegido(atributoElegido) < jugador2.getValorAtributoElegido(atributoElegido)) {
            jugador2.ganaUnaCarta(jugador1.pierdeUnaCarta());
            jugadorDeTurno = jugador2;
        }else{
            jugador1.resultaEmpate();
            jugador2.resultaEmpate();
        }
    }

    public String jugarPartida(){
        mazoDeCartas.repartirCartas(jugador1, jugador2);
        while (jugador1.tieneCartas() && jugador2.tieneCartas()){
           jugarRonda();
        }
        if (jugador1.tieneCartas()){
            return "Gano el Jugador 1";
        } else if(jugador2.tieneCartas()){
            return "GANO EL JUGADOR 2";
        }
        return "La partida termino";
    }


    public String jugarPartidaPorRondas(int cantRondas){
        mazoDeCartas.repartirCartas(jugador1, jugador2);
        for (int i=0; i < cantRondas; i++){
            System.out.println("ronda num" + i);
            if (jugador1.tieneCartas() && jugador2.tieneCartas()){
                jugarRonda();
            }
        }
        int cartasJ1 = jugador1.contarCartas();
        int cartasJ2 = jugador2.contarCartas();
        if (jugador1.tieneCartas()){
            if (jugador2.tieneCartas()) {
                if ( cartasJ1 > cartasJ2 ){
                    return "Gano el Jugador 1 Por maxima cantidad de cartas";
                }
                else if(cartasJ1 < cartasJ2) {
                    return  "Gano el Jugador 2 Por maxima cantidad de cartas";
                }
                else {
                    return "EMPATE";
                }
            }
            return "Gano el Jugador1";
        }
        return "Gano el Jugador2";
    }
}