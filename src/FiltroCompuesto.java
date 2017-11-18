import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class FiltroCompuesto extends Filtro {
    protected Filtro filtro1;
    protected Filtro filtro2;

    public FiltroCompuesto(Filtro f1, Filtro f2){
        super();
        this.filtro1 = f1;
        this.filtro2 = f2;
    }

    @Override
    public List<String> getAtributoFiltro() {
        HashSet<String> atributosConFiltros = new HashSet<>();
        atributosConFiltros.addAll(filtro1.getAtributoFiltro());
        atributosConFiltros.addAll(filtro2.getAtributoFiltro());
        return new ArrayList<>(atributosConFiltros);
    }

}
