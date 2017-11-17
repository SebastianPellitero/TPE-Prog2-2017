import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Jugador {
    protected Mazo mazoJugador;
    private Carta cartaSeleccionada;
    private String nombre;

    Jugador(String nombre){
        this.nombre = nombre;
    }

    String getNombre(){
        return nombre;
    }

    public void agregarMazo(ArrayList<Carta> repartido){
        this.mazoJugador = new Mazo(repartido);
    }

    public void seleccionarPrimerCarta(){
        if (!mazoJugador.isMazoEmpty()) {
            cartaSeleccionada = mazoJugador.getCarta(0);
            mazoJugador.removeCarta(0);
        }
    }

    public String elegirAtributo(){
        ArrayList<String> atributosDeCarta = cartaSeleccionada.getListaAtributos();
        Random randomGenerator = new Random();
        return atributosDeCarta.get(randomGenerator.nextInt(atributosDeCarta.size()));
    }

    public int getValorAtributoElegido(String atributoElegido){
        return cartaSeleccionada.getValorDeAtributo(atributoElegido);
    }

    public boolean tieneCartas(){
        return !mazoJugador.isMazoEmpty();
    }

//    public Carta getCartaSeleccionada(){
//        return cartaSeleccionada;
//    }

    public void ganaUnaCarta(Carta nuevaCarta){
        mazoJugador.addCarta(cartaSeleccionada);
        mazoJugador.addCarta(nuevaCarta);
    }

    public void resultaEmpate(){
        mazoJugador.addCarta(cartaSeleccionada);
    }

    public Carta pierdeUnaCarta(){
        return cartaSeleccionada;
    }

    public int contarCartas(){
        return mazoJugador.sizeMazo();
    }

//    public void mostrarTodaslasCartas(){
//        System.out.println("Las cartas del jugador  son: ");
//        for(int i=0; i < mazoJugador.size(); i++){
//            System.out.print("carta" + mazoJugador.get(i).getNombreCarta() + " ");
//            mazoJugador.get(i).printAtributos();
//            System.out.print("\n");
//        }
//    }
}
