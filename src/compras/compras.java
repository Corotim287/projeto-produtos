package compras;

public class compras {
    private String nomeDoProduto;
    private Double preçoDoProduto;

    public compras(String nomeDoProduto, Double preçoDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
        this.preçoDoProduto = preçoDoProduto;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public Double getPreçoDoProduto() {
        return preçoDoProduto;
    }

    @Override
    public String toString() {
        return "Compras{" +
                "nomeDoProduto='" + nomeDoProduto + '\'' +
                ", preçoDoProduto=" + preçoDoProduto +
                '}';
    }
}

