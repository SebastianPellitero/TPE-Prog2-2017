import java.util.ArrayList;

public class Partida {
    protected Jugador jugador1;
    protected Jugador jugador2;
    protected Jugador jugadorDeTurno;
    protected Mazo mazoDeCartas;
    protected ArrayList<Mazo> mazoMultiple = new ArrayList<>();

    Partida(Jugador jugador1, Jugador jugador2, Mazo mazoDeCartas ){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugadorDeTurno = jugador1;
        this.mazoDeCartas = mazoDeCartas;
        this.mazoMultiple.add(mazoDeCartas);
    }

    public void agregarNuevoMazo(Mazo nuevoMazo){
        this.mazoMultiple.add(nuevoMazo);
    }

    public ArrayList<Carta> buscarPorFiltro(Filtro f){
        ArrayList<Carta> resultado = new ArrayList<>();
        for ( Mazo mazoActual: mazoMultiple ) {
            resultado.addAll(mazoActual.buscarCartas(f));
        }
        return resultado;
    }

    protected void jugarRonda(){
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

    protected Boolean condicionDeCorte(){
       return (jugador1.tieneCartas() && jugador2.tieneCartas());
    }

    protected String validarResultado(){
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