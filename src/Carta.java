import java.util.ArrayList;
import java.util.Random;

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

    public int getValorDeAtributo(String seleccionado){
        for (int i=0; i < atributos.size(); i++){
            if (seleccionado == atributos.get(i).getNombre()) {
                return atributos.get(i).getValor();
            }
        }
        return 0;
    }

    public Atributo selectRandomAtributo(){
        Random randomGenerator = new Random();
        return(atributos.get(randomGenerator.nextInt(atributos.size())));
    }

    public void printAtributos(){
        for(int i=0; i < atributos.size(); i++){
            System.out.print(atributos.get(i).getNombre() + " ");
            System.out.print(atributos.get(i).getValor()+ " ");
        }
    }
}
