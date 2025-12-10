package OCP_APLICADO;

public class DescontoSazonal implements EstrategiaDeDesconto{
    @Override
    public double aplicarDesconto(Pedido pedido) {
        double valor = pedido.getValorBruto();
        // Regra: 5%
        double novoValor = valor * 0.95;
        System.out.println("-> Desconto SAZONAL (5%) aplicado: R$" + (valor - novoValor));
        return novoValor;
    }
}
