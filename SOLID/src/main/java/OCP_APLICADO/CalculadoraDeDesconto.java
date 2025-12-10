package OCP_APLICADO;
/**
 * A classe está FECHADA PARA MODIFICAÇÃO.
 * Ela orquestra o processo, delegando a regra de negócio para a interface.
 */

public class CalculadoraDeDesconto {
    // O método recebe a estratégia de desconto a ser aplicada.
    public double calcular(Pedido pedido, EstrategiaDeDesconto estrategia) {

        System.out.println("--- Aplicando Estratégia ---");

        // Delega o cálculo do desconto à estratégia específica
        double valorAposDesconto = estrategia.aplicarDesconto(pedido);

        System.out.println("Valor Bruto: R$" + pedido.getValorBruto());
        System.out.println("Valor Final: R$" + valorAposDesconto);

        return valorAposDesconto;

    }
}