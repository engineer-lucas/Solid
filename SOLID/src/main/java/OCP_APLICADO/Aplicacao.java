package OCP_APLICADO;

public class Aplicacao {
    public static void main(String[] args) {
        CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();

        // Pedidos de exemplo
        Pedido pedido1 = new Pedido("PED-001", 1000.00, 3); // VIP (Existente)
        Pedido pedido2 = new Pedido("PED-002", 500.00, 1);  // ANIVERSARIO (Novo)


        // A) Usando o Desconto VIP (Estratégia Existente)
        System.out.println("============================================");
        System.out.println("PROCESSANDO PEDIDO VIP (ESTRATÉGIA EXISTENTE)");

        EstrategiaDeDesconto estrategiaVIP = new DescontoVIP();
        calculadora.calcular(pedido1, estrategiaVIP);


        // B) Usando o Desconto Aniversário (NOVA Estratégia - EXTENSÃO)
        System.out.println("\n============================================");
        System.out.println("PROCESSANDO PEDIDO ANIVERSÁRIO (NOVA EXTENSÃO)");

        // Instancia a nova regra de desconto (Aberto para Extensão!)
        EstrategiaDeDesconto estrategiaAniversario = new DescontoAniversario();

        // A CalculadoraDeDesconto não foi modificada! (Fechada para Modificação!)
        calculadora.calcular(pedido2, estrategiaAniversario);

        System.out.println("============================================");
    }
}
