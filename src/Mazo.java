import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

public class Mazo {
     ArrayList<Carta> conjCartas = new ArrayList<Carta>();
     int mitad;

     Mazo(){
         ArrayList<Carta> conjCartas = new ArrayList<Carta>();
     }

     Mazo(ArrayList<Carta> newMazo){
         ArrayList<Carta> conjCartas = new ArrayList<Carta>(newMazo);
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
        mitad = cantidad/2;
    }

    void printCartas(){
        for(int i=0; i < conjCartas.size(); i++){
            System.out.print(conjCartas.get(i).getNombreCarta()+" ");
            conjCartas.get(i).printAtributos();
            System.out.print("\n");
        }
    }

    ArrayList<Carta> repartirCartas(){
        ArrayList<Carta> newMazo = new ArrayList<>(conjCartas.subList(0,mitad));
        conjCartas.subList(0, mitad).clear(); //conjCartas.removeRange(0,mitad);
        return newMazo;
    }

    Boolean tieneCartasValidas(){
        if (!conjCartas.isEmpty()) {
            Carta comparadora = conjCartas.get(0);
            for (int i = 1; i < conjCartas.size(); i++) {
                if (conjCartas.get(i).getAtributos().size() == comparadora.getAtributos().size()) {
                    for (int j = 0; j < conjCartas.get(i).getAtributos().size(); j++) {
                        for (int m = 0; m < comparadora.getAtributos().size(); m++) {
                            if (conjCartas.get(i).getAtributos().get(j).getNombre() != comparadora.getAtributos().get(m).getNombre())
                                return (false);
                        }
                    }
                }else{
                    return (false);
                }
            }
            re
            turn (true);
        }
        return (false);
    }

}
