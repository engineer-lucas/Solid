package OCP_APLICADO;

public class DescontoAniversario implements EstrategiaDeDesconto{
    @Override
    public double aplicarDesconto(Pedido pedido) {
        double valor = pedido.getValorBruto();
        // Regra: Desconto de 20% para aniversariantes
        double novoValor = valor * 0.80;
        System.out.println("Desconto ANIVERSÁRIO (20%) aplicado: R$" + (valor - novoValor));
        return novoValor;
    }
}
