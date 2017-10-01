import java.util.ArrayList;

public class Jugador {
    private ArrayList<Carta> monton = new ArrayList<Carta>();
    private Carta cartaSeleccionada;

    Jugador(){}

    public void agregarMazo(ArrayList<Carta> repartido){
        this.monton = new ArrayList<>(repartido);
    }

    public void seleccionarPrimerCarta(){
        if (!monton.isEmpty()) {
            cartaSeleccionada = monton.get(0);
            monton.remove(0);
        }
    }

    public String elegirAtributo(){
        return cartaSeleccionada.selectRandomAtributo();
    }

    public int getValorAtributoElegido(String atributoElegido){
        return cartaSeleccionada.getValorDeAtributo(atributoElegido);
    }

    public boolean tieneCartas(){
        return !monton.isEmpty();
    }

    public Carta getCartaSeleccionada(){
        return cartaSeleccionada;
    }

    public void ganaUnaCarta(Carta nuevaCarta){
        monton.add(cartaSeleccionada);
        monton.add(nuevaCarta);
    }

    public void resultaEmpate(){
        monton.add(cartaSeleccionada);
    }

    public Carta pierdeUnaCarta(){
        return cartaSeleccionada;
    }

    public int contarCartas(){
        return monton.size();
    }

//    public void mostrarTodaslasCartas(){
//        System.out.println("Las cartas del jugador  son: ");
//        for(int i=0; i < monton.size(); i++){
//            System.out.print("carta" + monton.get(i).getNombreCarta() + " ");
//            monton.get(i).printAtributos();
//            System.out.print("\n");
//        }
//    }
}
