import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mazo {
    private ArrayList<Carta> conjCartas = new ArrayList<Carta>();

    Mazo(ArrayList<Carta> mazoPredefinido){
        this.conjCartas = new ArrayList<Carta>(mazoPredefinido);
    }

    Mazo(int cantidad, String... atributos){
        ArrayList<String> atributosCarta = new ArrayList<String>();
        for (String atrib: atributos) {
            atributosCarta.add(atrib);
        }
        Random randomGenerator = new Random();
        for (int j=0; j < cantidad; j++){ //cantidad de cartas
            Carta cartaNueva = new Carta("carta "+j);
            for(int i=0; i < atributosCarta.size(); i++) { //cantidad de atributos de la carta
                cartaNueva.setAtributo(atributosCarta.get(i), randomGenerator.nextInt(100));
            }
            conjCartas.add(cartaNueva);
        }
    }

    public boolean isMazoEmpty(){
        return conjCartas.isEmpty();
    }

    public Carta getCarta(int index){
        return conjCartas.get(index);
    }

    public ArrayList<Carta> getCartas() { return conjCartas; }

    public void removeCarta(int index){
        conjCartas.remove(index);
    }

    public void addCarta(Carta cartaAgregar){
        conjCartas.add(cartaAgregar);
    }

    public int sizeMazo(){
        return conjCartas.size();
    }

    public void repartirCartas(Jugador... jugadores){
        int cantCartasParaCada = conjCartas.size() / jugadores.length;
        int inicio = 0;
        for (Jugador jug: jugadores){
            jug.agregarMazo(new ArrayList<Carta> (conjCartas.subList(inicio,cantCartasParaCada)));
            inicio += cantCartasParaCada;
            cantCartasParaCada += cantCartasParaCada;
        }
    }

    public String tieneCartasValidas(){
        if (!conjCartas.isEmpty()) {
            Carta comparadora = conjCartas.get(0);
            boolean result = false;
            
            for (int index = 1; index < conjCartas.size(); index++) { //por cada carta del mazo
                result = esMismoTipoCarta(conjCartas.get(index), comparadora);
            }
            if (result) {
                return "Las cartas son validas";
            }
            return "Las cartas no son validas";
        }
        return "El mazo esta vacio";
    }

    private boolean esMismoTipoCarta(Carta cartaPrueba, Carta cartaOriginal){
        ArrayList<String> atribsOriginales = cartaOriginal.getListaAtributos();
        ArrayList<String> atribsCartaAux = cartaPrueba.getListaAtributos();

        if ( atribsCartaAux.size() == atribsOriginales.size()) { //si tienen la misma cant de atribs
            if (atribsCartaAux.containsAll(atribsOriginales)){
                return true;
            }
        }
        return false; 
    }

    public ArrayList<Carta> buscarCartas (Filtro f) {
        if (contieneAtributos(f)){
            ArrayList<Carta> resultado = new ArrayList<>();
            for (Carta carta1 : this.conjCartas) {
                Carta buscada = carta1.buscar(f);
                if (buscada != null) {
                    resultado.add(buscada);
                }
            }
            return resultado;
        }
        return new ArrayList<>();
    }

    private boolean contieneAtributos(Filtro f){
        if (this.conjCartas.get(0).getListaAtributos().containsAll(f.getAtributoFiltro())){
            return true;
        }
        return false;
    }
    /*
    public void printCartas(){
        for(int i=0; i < conjCartas.size(); i++){
            System.out.print(conjCartas.get(i).getNombreCarta()+" ");
            conjCartas.get(i).printAtributos();
            System.out.print("\n");
        }
    }*/
}
