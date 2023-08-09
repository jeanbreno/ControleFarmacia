
package controle.farmacia;

public abstract class Produto {
    
    private int codigo;
    private String descricao;
    private float precoDeCompra;
    private float percentualDeLucro;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPrecoDeCompra() {
        return precoDeCompra;
    }

    public void setPrecoDeCompra(float precoDeCompra) {
        this.precoDeCompra = precoDeCompra;
    }

    public float getPercentualDeLucro() {
        return percentualDeLucro;
    }

    public void setPercentualDeLucro(float percentualDeLucro) {
        this.percentualDeLucro = percentualDeLucro;
    }
    
    public abstract float gerarPrecoDeVenda();
    
    public abstract void definirPercentualDeLucro();
    
}
