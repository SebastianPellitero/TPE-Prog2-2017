import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        Mazo mazoMinions = new Mazo(4,"Fuerza", "Destreza", "Inteligencia");
//      mazoMinions.printCartas();
        System.out.println(mazoMinions.tieneCartasValidas());

        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Robinson");

        Partida round1 = new Partida(jugador1,jugador2,mazoMinions);
        System.out.println(round1.jugarPartida());

        Mazo mazoTransformers = new Mazo(10,"Fuerza", "Liderazgo", "Ternura");
        System.out.println(mazoTransformers.tieneCartasValidas());

        Jugador jugador3 = new Jugador("Pamela");
        Jugador jugador4 = new Jugador("Veronica");

        PartidaPorRondas partidaRondas = new PartidaPorRondas(jugador3,jugador4,mazoTransformers,5);
        System.out.println(partidaRondas.jugarPartida());

        FiltroPorMayor fuerza = new FiltroPorMayor("Fuerza", 10);
        FiltroPorMayor liderazgo = new FiltroPorMayor("Liderazgo", 30);
        FiltroPorMenor pelegasg = new FiltroPorMenor("PeleasGanadas", 10);
        FiltroPorIgual velocidad = new FiltroPorIgual("Velocidad", 35);
        FiltroPorMenor valentia = new FiltroPorMenor("Valentia",29);
        FiltroPorMayor fuerzaAnd = new FiltroPorMayor("Fuerza",15);
        FiltroPorMenor alturaAnd = new FiltroPorMenor("Altura",13);
        FiltroAnd filtroAnd = new FiltroAnd(fuerzaAnd, alturaAnd);


        ArrayList<Mazo> mazosVarios = new ArrayList<>();
        mazosVarios.add(mazoMinions);
        mazosVarios.add(mazoTransformers);

        ArrayList<Carta> resultado = new ArrayList<>();

        System.out.println("Filtro simple");
        for ( Mazo mazoActual: mazosVarios ) {
            mazoActual.printCartas();
            resultado = mazoActual.buscarCartas(fuerza);
        }

        for (Carta carta: resultado){
            carta.printAtributos();
        }
        System.out.println("Filtro doble");

        for ( Mazo mazoActual: mazosVarios ) {
            mazoActual.printCartas();
            resultado = mazoActual.buscarCartas(filtroAnd);
        }

        for (Carta carta: resultado){
            carta.printAtributos();
        }


}


    }

