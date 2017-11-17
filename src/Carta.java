import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Carta {
    private String nombreCarta;
    private Map<String, Integer> atributos = new HashMap<String, Integer>();

    Carta(String nombreCarta){
        this.nombreCarta = nombreCarta;
    }

    public String getNombreCarta(){
        return nombreCarta;
    }

    public void setAtributo(String nombre, Integer valor){
        atributos.put(nombre, valor);
    }

    public Map<String, Integer> getAtributos(){
        return this.atributos;
    }

    public ArrayList<String> getListaAtributos(){
        ArrayList<String> atrib = new ArrayList<String>();
        for ( String key : atributos.keySet() ) {
            atrib.add(key);
        }
        return atrib;
    }
    /* Fix: jugador responsability
    public String selectRandomAtributo(){
        Random randomGenerator = new Random();
        ArrayList<String> atribs = this.getListaAtributos();
        return atribs.get(randomGenerator.nextInt(atributos.size()));
    }*/

    public int getValorDeAtributo(String atrib){
        return this.atributos.get(atrib);
    }

    public Carta buscar(Filtro f) {
        if (f.cumple(this))
            return this;
        else
            return null;
    }

    public void printAtributos(){
        for (String key : atributos.keySet()) {
            System.out.println(key + " " + atributos.get(key));
        }
    }
}
