import java.util.ArrayList;
import java.util.List;

public class FiltroPorMenor extends FiltroSimple {

    public FiltroPorMenor(String atributo, int valorMaximo){
        super(atributo,valorMaximo);
    }
    @Override
    public boolean cumple(Carta carta) {
        return (carta.getValorDeAtributo(this.atributo) < this.valorMaximo);
    }
}
