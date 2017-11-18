import java.util.ArrayList;
import java.util.List;

public abstract class FiltroSimple extends Filtro {
    protected String atributo;
    protected int valorMaximo;

    public FiltroSimple(String atributo, int valorMaximo){
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

}
