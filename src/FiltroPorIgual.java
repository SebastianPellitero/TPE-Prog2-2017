import java.util.ArrayList;
import java.util.List;

public class FiltroPorIgual extends Filtro {
    private String atributo;
    private int valorMaximo;

    public FiltroPorIgual(String atributo, int valorMaximo){
        super();
        this.atributo = atributo;
        this.valorMaximo = valorMaximo;
    }
    @Override
    public List<String> getAtributoFiltro() {
        List<String> atributos = new ArrayList<>();
        atributos.add(atributo);
        return atributos;
    }

    @Override
    public boolean cumple(Carta carta) {
        return (carta.getValorDeAtributo(this.atributo) == this.valorMaximo);
    }
}