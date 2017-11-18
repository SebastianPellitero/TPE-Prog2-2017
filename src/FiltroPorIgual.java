import java.util.ArrayList;
import java.util.List;

public class FiltroPorIgual extends FiltroSimple {

    public FiltroPorIgual(String atributo, int valorMaximo){
        super(atributo,valorMaximo);
    }

    @Override
    public boolean cumple(Carta carta) {
        return (carta.getValorDeAtributo(this.atributo) == this.valorMaximo);
    }
}