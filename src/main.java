public class main {
    public static void main(String[] args) {

        Mazo mazoMinions = new Mazo(4,"Fuerza", "Destreza", "Inteligencia");
//      mazoMinions.printCartas();
        System.out.println(mazoMinions.tieneCartasValidas());

        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Robinson");

        Partida round1 = new Partida(jugador1,jugador2,mazoMinions);
        System.out.println(round1.jugarPartida());

        Mazo mazoTransformers = new Mazo(10,"Valentia", "Liderazgo", "Ternura");
        System.out.println(mazoTransformers.tieneCartasValidas());

        Jugador jugador3 = new Jugador("Pamela");
        Jugador jugador4 = new Jugador("Veronica");

        PartidaPorRondas partidaRondas = new PartidaPorRondas(jugador3,jugador4,mazoTransformers,5);
        System.out.println(partidaRondas.jugarPartida());
    }
}
