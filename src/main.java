public class main {
    public static void main(String[] args) {

        Mazo mazoMinions = new Mazo(4,"Fuerza", "Destreza", "Inteligencia");
//      mazoMinions.printCartas();
        System.out.println(mazoMinions.tieneCartasValidas());

        Jugador jugadror1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Partida round1 = new Partida(jugadror1,jugador2,mazoMinions);
        System.out.println(round1.jugarPartida());
        System.out.println(round1.jugarPartidaPorRondas(5));
    }
}
