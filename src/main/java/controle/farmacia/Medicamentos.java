
package controle.farmacia;

import javax.swing.JOptionPane;

public class Medicamentos extends Produto {

    @Override
    public float gerarPrecoDeVenda(){
        return (super.getPrecoDeCompra() + super.getPrecoDeCompra() * super.getPercentualDeLucro() / 100);
    }

    @Override
    public void definirPercentualDeLucro() {
        super.setPercentualDeLucro(Float.parseFloat(JOptionPane.showInputDialog("Digite o percentual de lucro do produto: ")));
    }
}
