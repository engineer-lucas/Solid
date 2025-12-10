package OCP_APLICADO;
/**
 * Interface que define o contrato para o OCP.
 * Aberta para extensão, implementada por novas classes.
 */

public interface EstrategiaDeDesconto {
    /**
     * Aplica o desconto específico e retorna o novo valor final.
     * @param pedido O pedido a ser processado.
     * @return O valor do pedido após o desconto.
     */
    double aplicarDesconto(Pedido pedido);

}
