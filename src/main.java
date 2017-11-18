import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        //creacion de mazos
        Mazo mazoMinions = new Mazo(15,"Valentia", "Liderazgo", "Inteligencia");
        Mazo mazoMinionsReloaded = new Mazo(15, "Valentia", "Altura","Velocidad","Liderazgo");
        Mazo mazoTransformers = new Mazo(20,"Fuerza", "Peso", "Altura", "PeleasGanadas","Velocidad","Valentia","Liderazgo");

        //Creacion de jugadores
        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Robinson");

        Partida roundMinions = new Partida(jugador1,jugador2,mazoMinions);
        //System.out.println(roundMinions.jugarPartida());

        Jugador jugador3 = new Jugador("Pamela");
        Jugador jugador4 = new Jugador("Veronica");

        PartidaPorRondas partidaRondas = new PartidaPorRondas(jugador3,jugador4,mazoTransformers,5);
       // System.out.println(partidaRondas.jugarPartida());

        //Creacion de filtros
        FiltroPorMayor fuerza = new FiltroPorMayor("Fuerza", 10);
        FiltroPorMayor liderazgo = new FiltroPorMayor("Liderazgo", 30);
        FiltroPorMenor pelegasg = new FiltroPorMenor("PeleasGanadas", 10);
        FiltroPorIgual velocidad = new FiltroPorIgual("Velocidad", 35);
        FiltroPorMenor valentia = new FiltroPorMenor("Valentia",29);
        FiltroPorMayor fuerzaAnd = new FiltroPorMayor("Fuerza",15);
        FiltroPorMenor alturaAnd = new FiltroPorMenor("Altura",13);
        FiltroAnd filtroAnd = new FiltroAnd(fuerzaAnd, alturaAnd);

        roundMinions.agregarNuevoMazo(mazoMinionsReloaded);

        /*for (Carta carta: roundMinions.buscarPorFiltro(valentia)){
            System.out.println(carta.getNombreCarta());
            //carta.printAtributos();
            System.out.println(" ");
        }*/

        Partida roundMix = new Partida(jugador1,jugador2,mazoTransformers);
        roundMix.agregarNuevoMazo(mazoMinions);
        roundMix.agregarNuevoMazo(mazoMinionsReloaded);

        for (Carta carta: roundMix.buscarPorFiltro(filtroAnd)){
            System.out.println(carta.getNombreCarta());
            //carta.printAtributos();
            System.out.println(" ");
        }

    }
}

