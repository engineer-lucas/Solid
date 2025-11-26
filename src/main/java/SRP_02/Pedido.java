package SRP_02;

public class Pedido {
    private String id;
    private double valorTotal;
    private int quantidadeItens;
    private boolean isPago;
    private String emailCliente;

    public Pedido(String id, double valorTotal, int quantidadeItens, String emailCliente) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.quantidadeItens = quantidadeItens;
        this.isPago = false;
        this.emailCliente = emailCliente;
    }

    // --- GETTERS ---
    public String getId() {
        return id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public boolean isPago() {
        return isPago;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    // --- SETTERS ---
    public void setId(String id) {
        this.id = id;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setQuantidadeItens(int quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public void setPago(boolean pago) {
        isPago = pago;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
}

// A CLASSE ABAIXO FOI ALTERADA (REMOÇÃO DO 'public')
// Isso resolve o erro de compilação, mantendo as classes unidas para o exemplo didático da violação do SRP.
class ProcessadorDePedido {

    // RESPONSABILIDADE 1 & 2: Validação e Cálculo de Domínio
    public double processar(Pedido pedido) throws Exception {

        // 1. Lógica de Validação de Estoque (RESPONSABILIDADE 1)
        if (pedido.getQuantidadeItens() > 100) {
            throw new Exception("Estoque insuficiente para a quantidade solicitada.");
        }

        // 2. Lógica de Cálculo de Frete e Impostos (RESPONSABILIDADE 2)
        double frete = 0.0;
        if (pedido.getValorTotal() < 500.00) {
            frete = 50.00;
        } else {
            frete = 0.0; // Frete grátis
        }

        double impostos = pedido.getValorTotal() * 0.15; // 15% de imposto fixo
        double valorFinal = pedido.getValorTotal() + frete + impostos;

        // Simulação de pagamento e atualização de status
        pedido.setPago(true);

        // 3. Lógica de Persistência (RESPONSABILIDADE 3)
        salvarNoBancoDeDados(pedido, valorFinal);

        // 4. Lógica de Notificação (RESPONSABILIDADE 4)
        enviarConfirmacaoPorEmail(pedido.getEmailCliente(), pedido.getId());

        return valorFinal;
    }

    // Lógica de Persistência (RESPONSABILIDADE 3)
    private void salvarNoBancoDeDados(Pedido pedido, double valorFinal) {
        // Esta classe mudará se trocarmos de MySQL para NoSQL.
        System.out.println("Pedido " + pedido.getId() + " finalizado (Valor: R$" + valorFinal + ") e salvo no BD.");
        // ... (código JDBC/JPA)
    }

    // Lógica de Notificação (RESPONSABILIDADE 4)
    private void enviarConfirmacaoPorEmail(String email, String idPedido) {
        // Esta classe mudará se trocarmos o serviço de e-mail (ex: de SendGrid para Mailgun).
        System.out.println("Email de confirmação enviado para: " + email + " | Pedido: " + idPedido);
        // ... (código de integração de API de e-mail)
    }

    public static void main(String[] args) {
        ProcessadorDePedido processador = new ProcessadorDePedido();
        Pedido pedido1 = new Pedido("PED-123", 600.00, 5, "cliente@email.com");

        try {
            double total = processador.processar(pedido1);
            System.out.println("Resultado final: Pedido processado com sucesso! Total: R$" + total);
        } catch (Exception e) {
            System.out.println("Erro ao processar pedido: " + e.getMessage());
        }
    }
}
