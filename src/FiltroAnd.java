import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FiltroAnd extends FiltroCompuesto {

    public FiltroAnd(Filtro f1, Filtro f2){
        super(f1,f2);
    }

    @Override
    public boolean cumple(Carta carta) {
        return (filtro1.cumple(carta) && filtro2.cumple(carta));
    }
}
