import java.util.ArrayList;

public class Jugador {
    String nombre;
    ArrayList<Carta> monton = new ArrayList<>();
    Carta cartaSeleccionada;

    Jugador(){

    }

    Jugador(String nombre){
        this.nombre = nombre;
    }

    String getNombre(){
        return nombre;
    }

    Jugador(String nombre, ArrayList<Carta> repartido){
        this.nombre = nombre;
        this.monton = new ArrayList<>(repartido);
    }

    void recibirCartas(ArrayList<Carta> repartido){
        this.monton = new ArrayList<>(repartido);
    }

    void seleccionarCarta(){
        if (!monton.isEmpty()) {
            cartaSeleccionada = monton.get(0);
            monton.remove(0);
        }
    }

    String elegirAtributo(){
        return (cartaSeleccionada.selectRandomAtributo().getNombre());
    }

    int decirValorDeCarta(String atributoElegido){
        return (cartaSeleccionada.getValorDeAtributo(atributoElegido));
    }

    void mostrarTodaslasCartas(){
        System.out.println("Las cartas del jugador "+nombre+ " son: ");
        for(int i=0; i < monton.size(); i++){
            System.out.print(monton.get(i).getNombreCarta() + " ");
            monton.get(i).printAtributos();
            System.out.print("\n");
        }
    }
    boolean tieneCartas(){
        if (monton.isEmpty())
            return false;
        return true;
    }

    Carta getCartaSeleccionada(){
        return(cartaSeleccionada);
    }

    void ganaUnaCarta(Carta nuevaCarta){
        monton.add(cartaSeleccionada);
        monton.add(nuevaCarta);
    }

    void resultaEmpate(){
        monton.add(cartaSeleccionada);
    }

    Carta pierdeUnaCarta(){
        return(cartaSeleccionada);
    }

    int contarCartas(){
        return(monton.size());
    }

}
