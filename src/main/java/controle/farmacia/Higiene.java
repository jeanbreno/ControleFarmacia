
package controle.farmacia;

public class Higiene extends Produto {

    @Override
    public float gerarPrecoDeVenda(){
        return (super.getPrecoDeCompra() + super.getPrecoDeCompra() * 30 / 100);
    }

    @Override
    public void definirPercentualDeLucro() {
        super.setPercentualDeLucro(30);
    }
}
