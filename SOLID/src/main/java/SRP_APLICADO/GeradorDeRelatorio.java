package SRP_APLICADO;
// 4. Classe de Apresentação: Responsável APENAS pela saída formatada.
public class GeradorDeRelatorio {
    public void imprimir(Funcionario funcionario, CalculadoraDeSalario calculadora) {
        // Lógica de formatação:
        // Esta classe muda SOMENTE se o formato do relatório mudar.
        double salarioLiquido = calculadora.calcularSalarioLiquido(funcionario);

        System.out.println("--- Relatório de Funcionário ---");
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Salário Base: R$ " + funcionario.getSalarioBase());
        System.out.println("Salário Líquido Calculado: R$ " + salarioLiquido);
        System.out.println("--------------------------------");
    }
}
