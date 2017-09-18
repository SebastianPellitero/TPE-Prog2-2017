import java.util.ArrayList;
import java.util.Iterator;

public class Mazo {
     private ArrayList<Carta> conjCartas = new ArrayList<Carta>();

     Mazo(){
         //ArrayList<Carta> conjCartas = ;
     }

     void agregarCarta(Carta carta){
         conjCartas.add(carta);
     }

    void crearMazoaPartirDeCarta(Carta carta, int cantidad){

        for (int j=0; j < cantidad; j++){ //cantidad de cartas
            ArrayList<Atributo> atributos = carta.getAtributos();
            ArrayList<Atributo> atributosCarta = new ArrayList<Atributo>();
            for(int i=0; i < atributos.size(); i++) { //cantidad de atributos de la carta
                Atributo atributo1 = new Atributo(atributos.get(i).getNombre());
                atributosCarta.add(atributo1);
            }
            String nombredecarta = "carta "+j;
            Carta cartaAux = new Carta(nombredecarta,atributosCarta);
            conjCartas.add(cartaAux);
        }
    }

    void printCartas(){
        for(int i=0; i < conjCartas.size(); i++){
            System.out.println(conjCartas.get(i).getNombreCarta());
            conjCartas.get(i).printAtributos();
        }
    }
}
