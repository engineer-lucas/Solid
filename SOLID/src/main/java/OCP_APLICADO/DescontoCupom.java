package OCP_APLICADO;

public class DescontoCupom implements EstrategiaDeDesconto{
    @Override
    public double aplicarDesconto(Pedido pedido) {
        double valor = pedido.getValorBruto();
        // Regra: 10%
        double novoValor = valor * 0.90;
        System.out.println("-> Desconto CUPOM (10%) aplicado: R$" + (valor - novoValor));
        return novoValor;

    }
}
