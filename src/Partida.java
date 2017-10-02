public class Partida {
    protected Jugador jugador1;
    protected Jugador jugador2;
    protected Jugador jugadorDeTurno;
    protected Mazo mazoDeCartas;

    Partida(Jugador jugador1, Jugador jugador2, Mazo mazoDeCartas ){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugadorDeTurno = jugador1;
        this.mazoDeCartas = mazoDeCartas;
    }

    public void jugarRonda(){
        jugador1.seleccionarPrimerCarta();
        jugador2.seleccionarPrimerCarta();
        String atributoElegido = jugadorDeTurno.elegirAtributo();
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

    public Boolean condicionDeCorte(){
       return (jugador1.tieneCartas() && jugador2.tieneCartas());
    }

    public String validarResultado(){
        if (jugador1.tieneCartas()){
            return "Gano " + jugador1.getNombre();
        } else if(jugador2.tieneCartas()){
            return "Gano " + jugador2.getNombre();
        }
        return "La partida termino";
    }

    public String jugarPartida(){
        mazoDeCartas.repartirCartas(jugador1, jugador2);
        while (condicionDeCorte()){
           jugarRonda();
        }
        return validarResultado();
    }
}