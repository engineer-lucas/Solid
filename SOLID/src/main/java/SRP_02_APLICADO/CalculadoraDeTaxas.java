package SRP_02_APLICADO;

//3. Cálculo de Domínio: `CalculadoraDeTaxas` (Responsabilidade 2)
//Responsável **APENAS** pela lógica financeira complexa (frete, impostos, descontos, etc.).

// 2. Responsabilidade: Apenas calcular o custo final do pedido.

public class CalculadoraDeTaxas {
    public double calcularValorFinal(Pedido pedido) {
        double valor = pedido.getValorBruto();
        double frete = calcularFrete(valor);
        double impostos = valor * 0.15; // 15% de imposto fixo

        double valorFinal = valor + frete + impostos;

        System.out.println("-> Frete (R$" + frete + ") e Impostos (R$" + impostos + ") calculados.");

        // Esta classe muda SOMENTE se as regras fiscais ou de frete mudarem.
        return valorFinal;
    }

    private double calcularFrete(double valor) {
        if (valor < 500.00) {
            return 50.00;
        }
        return 0.0;
    }

}
