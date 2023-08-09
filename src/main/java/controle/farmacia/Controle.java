
package controle.farmacia;

import javax.swing.JOptionPane;

public class Controle {

    public static void main(String[] args) {
        Produto produto[] = new Produto[15];
        int opcao, contador = 0;
        
        do {
            opcao = menu();
            switch (opcao) {
                case 1: 
                    if (contador == produto.length){
                        JOptionPane.showMessageDialog(null, "Estoque cheio!");
                    } else {
                        contador = cadastrarProduto(produto, contador);
                    }
                    break;
                case 2:
                    if (contador == 0){
                        JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!");
                    } else {
                        mostrarMaisCaro(produto, contador);
                    }
                    break;
                case 3:
                    if (contador == 0){
                        JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!");
                    } else {
                        mostrarProdutosEmEstoque(produto, contador);
                    }
                    break;
                case 4:
                    if (contador == 0){
                        JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!");
                    } else {
                        alterarDadosDeUmProduto(produto, contador);
                    }
                    break;
            }
        } while (opcao != 5);
    }
    
    public static int menu() {
        int opcao;
        String mensagem;
        
        mensagem = " 1 - Cadastrar produto\n";
        mensagem += "2 - Mostrar detalhes do produto mais caro\n";
        mensagem += "3 - Mostrar produtos em estaque\n";
        mensagem += "4 - Alterar dados de um produto\n";
        mensagem += "5 - Finalizar programa\n";
        opcao = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
        
        return opcao;
    }
    
    public static int cadastrarProduto(Produto p[], int c){
        int tipo;
        
        do {
            tipo = Integer.parseInt(JOptionPane.showInputDialog("1- para cadastrar Medicamento ou 2- para cadastrar produto de Higiene"));
        } while (tipo != 1 && tipo != 2);
        
        if (tipo == 1) {
            Medicamentos auxiliar = new Medicamentos();
            auxiliar.setCodigo(c+1);
            auxiliar.setDescricao(JOptionPane.showInputDialog("Digite a descrição do produto"));
            auxiliar.setPrecoDeCompra(Float.parseFloat(JOptionPane.showInputDialog("Digite o preço de compra do produto")));
            auxiliar.definirPercentualDeLucro();
            JOptionPane.showMessageDialog(null, "Preço de venda = " + auxiliar.gerarPrecoDeVenda());
            
            p[c] = auxiliar;
        } else {
            Higiene auxiliar = new Higiene();
            auxiliar.setCodigo(c+1);
            auxiliar.setDescricao(JOptionPane.showInputDialog("Digite a descrição do produto"));
            auxiliar.setPrecoDeCompra(Float.parseFloat(JOptionPane.showInputDialog("Digite o preço de compra do produto")));
            auxiliar.setPercentualDeLucro(30);
            JOptionPane.showMessageDialog(null, "Preço de venda = " + auxiliar.gerarPrecoDeVenda());
            
            p[c] = auxiliar;
        }
        
        c++;
        return c;
    }
    
    public static void alterarDadosDeUmProduto(Produto p[], int c){
        int codigo;
        codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto para alteração"));
        if (codigo < 1 || codigo-1 >= c){
            JOptionPane.showMessageDialog(null, "Produto inexistente!");
        } else {
            p[codigo-1].setDescricao(JOptionPane.showInputDialog("Digite a nova descrição"));
            p[codigo-1].setPrecoDeCompra(Float.parseFloat(JOptionPane.showInputDialog("Digite o novo preço de compra")));
            p[codigo-1].definirPercentualDeLucro();
            JOptionPane.showMessageDialog(null, "Novo lucro = " + p[codigo-1].gerarPrecoDeVenda());
        }
    }
    
    public static void mostrarProdutosEmEstoque(Produto p[], int c){
        int cont;
        String msg = "";
        
        for (cont = 0; cont < c; cont++){
            msg = msg + "\nCodigo: " + p[cont].getCodigo();
            msg = msg + "\nDescrição: " + p[cont].getDescricao();
            msg = msg + "\nPreço de compra: " + p[cont].getPrecoDeCompra();
            msg = msg + "\n% de lucro: " + p[cont].getPercentualDeLucro();
            msg = msg + "\nPreço de venda: " + p[cont].gerarPrecoDeVenda();
            JOptionPane.showMessageDialog(null, msg);
            msg = "";
        }
    }

    public static void mostrarMaisCaro(Produto p[], int c){
        int cont, indiceDoMaior;
        float maiorPreco;
        String msg = "";
        maiorPreco = p[0].getPrecoDeCompra();
        indiceDoMaior = 0;

        for (cont = 1; cont < c; cont++){
            if (p[cont].getPrecoDeCompra() > maiorPreco){
                maiorPreco = p[cont].getPrecoDeCompra();
                indiceDoMaior = cont;
            }
        }
        
        msg = msg + "\nCodigo: " + p[indiceDoMaior].getCodigo();
        msg = msg + "\nDescrição: " + p[indiceDoMaior].getDescricao();
        msg = msg + "\nPreço de compra: " + p[indiceDoMaior].getPrecoDeCompra();
        msg = msg + "\n% de lucro: " + p[indiceDoMaior].getPercentualDeLucro();
        msg = msg + "\nPreço de venda: " + p[indiceDoMaior].gerarPrecoDeVenda();
        JOptionPane.showMessageDialog(null, msg);
        msg = "";
    }
}