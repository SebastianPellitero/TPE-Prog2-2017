import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FiltroOr extends Filtro {
    private Filtro filtro1;
    private Filtro filtro2;

    public FiltroOr(Filtro f1, Filtro f2){
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

    @Override
    public boolean cumple(Carta carta) {
        return (filtro1.cumple(carta) || filtro2.cumple(carta));
    }
}
