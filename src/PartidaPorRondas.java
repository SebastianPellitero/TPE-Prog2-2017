public class PartidaPorRondas extends Partida {
    private int cantRondas;

    PartidaPorRondas(Jugador jugador1, Jugador jugador2, Mazo mazoDeCartas,int cantRondas){
        super(jugador1,jugador2,mazoDeCartas);
        this.cantRondas = cantRondas;
    }

    @Override
    public Boolean condicionDeCorte(){
        return ((jugador1.tieneCartas() && jugador2.tieneCartas()) &&(cantRondas != 0));
    }

    @Override
    public String validarResultado(){
        int cartasJ1 = jugador1.contarCartas();
        int cartasJ2 = jugador2.contarCartas();
        if (jugador1.tieneCartas()){
            if (jugador2.tieneCartas()) {
                if ( cartasJ1 > cartasJ2 ){
                    return "Gano " + jugador1.getNombre() + " Por maxima cantidad de cartas";
                }
                else if(cartasJ1 < cartasJ2) {
                    return  "Gano " + jugador2.getNombre() + " Por maxima cantidad de cartas";
                }
                else {
                    return "EMPATE";
                }
            }
            return "Gano " + jugador1.getNombre();
        }
        return "Gano " + jugador2.getNombre();
    }
}
