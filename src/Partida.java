import java.util.ArrayList;

public class Partida {
    public static void main(String[] args) {

        Atributo fuerza = new Atributo("Fuerza", 50);
        Atributo destreza = new Atributo("Destreza", 30);
        Atributo inteligencia = new Atributo("Int");
        ArrayList<Atributo> atributo1 = new ArrayList<Atributo>();
        atributo1.add(fuerza);
        atributo1.add(destreza);
        atributo1.add(inteligencia);

        Carta carta1 = new Carta("prime", atributo1);
        carta1.printAtributos();
        Mazo mazoMinions = new Mazo();
        mazoMinions.crearMazoaPartirDeCarta(carta1,20);
        mazoMinions.printCartas();
    }
}
