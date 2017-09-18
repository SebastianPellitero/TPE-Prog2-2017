import java.util.Random;

public class Atributo {
    private String nombre;
    private int valor;

    Atributo(String nombre){
        Random randomGenerator = new Random();
        this.nombre = nombre;
        valor = randomGenerator.nextInt(100);
    }

    Atributo(String nombre, int valor){
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }
}
