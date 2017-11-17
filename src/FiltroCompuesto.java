import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class FiltroCompuesto extends Filtro {
    private Filtro filtro1;
    private Filtro filtro2;

    public FiltroCompuesto(Filtro f1, Filtro f2){
        super();
        this.filtro1 = f1;
        this.filtro2 = f2;
    }

    public Filtro getFiltro1() {
        return filtro1;
    }

    public Filtro getFiltro2() {
        return filtro2;
    }

    @Override
    public List<String> getAtributoFiltro() {
        HashSet<String> atributosConFiltros = new HashSet<>();
        atributosConFiltros.addAll(filtro1.getAtributoFiltro());
        atributosConFiltros.addAll(filtro2.getAtributoFiltro());
        return new ArrayList<>(atributosConFiltros);
    }

}
