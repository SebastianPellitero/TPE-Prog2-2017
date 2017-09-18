import java.util.ArrayList;

public class Carta {
    String nombreCarta;
    ArrayList<Atributo> atributos;

    Carta(String nombreCarta, ArrayList<Atributo> atributos){
        this.nombreCarta = nombreCarta;
        this.atributos = new ArrayList<Atributo>(atributos);
    }

    public String getNombreCarta(){
        return nombreCarta;
    }

    public ArrayList<Atributo> getAtributos() {
        return atributos;
    }

    public void printAtributos(){
        for(int i=0; i < atributos.size(); i++){
            System.out.print(atributos.get(i).getNombre() + " ");
            System.out.println(atributos.get(i).getValor());
        }
    }
}
