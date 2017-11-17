import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FiltroOr extends FiltroCompuesto {

    public FiltroAnd(Filtro f1, Filtro f2){
        super(f1,f2);
    }

    @Override
    public boolean cumple(Carta carta) {
        return (getFiltro1().cumple(carta) || getFiltro2().cumple(carta));
    }
}
