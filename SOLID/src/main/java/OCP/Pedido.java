package OCP;

// A única classe pública que corresponde ao nome do arquivo (Pedido.java)
public class Pedido {
    private String id;
    private double valorBruto;
    private int quantidadeItens;
    private boolean isPago;
    private String emailCliente;
    private TipoDesconto tipoDesconto; // Tipo de desconto a ser aplicado

    public Pedido(String id, double valorBruto, int quantidadeItens, String emailCliente, TipoDesconto tipoDesconto) {
        this.id = id;
        this.valorBruto = valorBruto;
        this.quantidadeItens = quantidadeItens;
        this.isPago = false;
        this.emailCliente = emailCliente;
        this.tipoDesconto = tipoDesconto;
    }

    // --- GETTERS ---
    public String getId() { return id; }
    public double getValorBruto() { return valorBruto; }
    public int getQuantidadeItens() { return quantidadeItens; }
    public boolean isPago() { return isPago; }
    public String getEmailCliente() { return emailCliente; }
    public TipoDesconto getTipoDesconto() { return tipoDesconto; }

    // --- SETTERS ---
    public void setValorBruto(double valorBruto) { this.valorBruto = valorBruto; }
    public void setQuantidadeItens(int quantidadeItens) { this.quantidadeItens = quantidadeItens; }
    public void setPago(boolean pago) { isPago = pago; }
    public void setTipoDesconto(TipoDesconto tipoDesconto) { this.tipoDesconto = tipoDesconto; }
}

// Enum agora tem visibilidade default (package-private), resolvendo a compilação
enum TipoDesconto {
    CUPOM, VIP, SAZONAL, ANIVERSARIO
}

// CLASSE QUE VIOLA O OCP
// A visibilidade foi alterada de 'public' para default (package-private), resolvendo a compilação.
class CalculadoraDeDesconto {

    public double aplicarDesconto(Pedido pedido) {
        double valor = pedido.getValorBruto();
        TipoDesconto tipo = pedido.getTipoDesconto();

        if (tipo == TipoDesconto.CUPOM) {
            // Lógica para CUPOM: 10%
            return valor * 0.90;
        } else if (tipo == TipoDesconto.VIP) {
            // Lógica para VIP: 15%
            return valor * 0.85;
        } else if (tipo == TipoDesconto.SAZONAL) {
            // Lógica para Sazonal: 5%
            return valor * 0.95;
        }
        // AQUI ESTÁ A VIOLAÇÃO (INCLUÍDA):
        else if (tipo == TipoDesconto.ANIVERSARIO) {
            // Lógica para Aniversário: 20%
            return valor * 0.80; // Novo desconto
        }

        return valor;
    }
}