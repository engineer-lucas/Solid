package OCP_APLICADO;

public class DescontoVIP implements EstrategiaDeDesconto{
    @Override
    public double aplicarDesconto(Pedido pedido) {
        double valor = pedido.getValorBruto();
        // Regra: 15%
        double novoValor = valor * 0.85;
        System.out.println("Desconto VIP (15%) aplicado: R$" + (valor - novoValor));
        return novoValor;
    }
}
