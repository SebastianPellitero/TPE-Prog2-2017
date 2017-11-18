import java.util.ArrayList;
import java.util.List;

public class FiltroPorMayor extends FiltroSimple {

    public FiltroPorMayor(String atributo, int valorMaximo){
        super(atributo,valorMaximo);
    }

    @Override
    public boolean cumple(Carta carta) {
        return (carta.getValorDeAtributo(this.atributo) > this.valorMaximo);
    }
}
