package dados;

public class Produto {
    private String nome;
    private String codigoBarras;
    private double precoUnitario;
    private int quantidadeEstoque;
    private String categoria;

    public Produto(String nome, String codigoBarras, double precoUnitario, int quantidadeEstoque, String categoria) {
        this.nome = nome;
        this.codigoBarras = codigoBarras;
        this.precoUnitario = precoUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCodigoBarras() {
        return this.codigoBarras;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidadeEstoque() {
        return this.quantidadeEstoque;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto: " + nome +
                " | Código: " + codigoBarras +
                " | Preço: R$" + precoUnitario +
                " | Quantidade: " + quantidadeEstoque +
                " | Categoria: " + categoria;
    }

}
