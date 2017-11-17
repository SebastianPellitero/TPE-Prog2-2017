import java.util.List;

public abstract class Filtro {
    public abstract List<String> getAtributoFiltro();
    public abstract boolean cumple (Carta a);
}
