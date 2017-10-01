public class main {
    public static void main(String[] args) {

        Mazo mazoMinions = new Mazo(4,"Fuerza", "Destreza", "Inteligencia");
        mazoMinions.printCartas();
        System.out.println(mazoMinions.tieneCartasValidas());

        Jugador yo = new Jugador();
        Jugador otro = new Jugador();

        Partida round1 = new Partida(yo,otro,mazoMinions);
        System.out.println(round1.jugarPartida());
        System.out.println(round1.jugarPartidaPorRondas(5));
    }
}
