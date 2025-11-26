package SRP_02_APLICADO;
//7. Classe de Execução (Main)
public class Aplicacao {
    public static void main(String[] args) {
        // Instanciação das classes especializadas
        ValidadorDeEstoque validador = new ValidadorDeEstoque();
        CalculadoraDeTaxas calculadora = new CalculadoraDeTaxas();
        RepositorioDePedido repositorio = new RepositorioDePedido();
        NotificadorDePedido notificador = new NotificadorDePedido();

        // Instanciação do serviço de coordenação
        ServicoDeProcessamentoDePedido servico = new ServicoDeProcessamentoDePedido(
                validador, calculadora, repositorio, notificador
        );
        // Pedido de exemplo
        Pedido pedido1 = new Pedido("PED-789", 450.00, 2, "lucas.ecom@techstore.com");

        System.out.println("--- INICIANDO PROCESSAMENTO DO PEDIDO ---");

        try {
            Pedido pedidoProcessado = servico.processar(pedido1);

            System.out.println("\n--- RESULTADO FINAL ---");
            System.out.println("Status do Pedido " + pedidoProcessado.getId() + ": PAGO");
            System.out.println("Valor Bruto: R$" + pedidoProcessado.getValorBruto());
            System.out.println("Valor Final (com taxas): R$" + pedidoProcessado.getValorFinal());

        } catch (Exception e) {
            System.out.println("Falha no processamento: " + e.getMessage());
        }
    }
}
