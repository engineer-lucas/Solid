package OCP_APLICADO;

public class Pedido {
    private String id;
    private double valorBruto;
    private int quantidadeItens;

    public Pedido(String id, double valorBruto, int quantidadeItens) {
        this.id = id;
        this.valorBruto = valorBruto;
        this.quantidadeItens = quantidadeItens;
    }
    // Getters e Setters
    public String getId() { return id; }
    public double getValorBruto() { return valorBruto; }
    public int getQuantidadeItens() { return quantidadeItens; }
    public void setValorBruto(double valorBruto) { this.valorBruto = valorBruto;          }

}
