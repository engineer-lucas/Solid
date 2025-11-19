package SRP_APLICADO;
// 2. Classe de Regra de Negócio: Responsável APENAS pelo cálculo.
public class CalculadoraDeSalario {
    public double calcularSalarioLiquido(Funcionario funcionario) {
        double salarioBase = funcionario.getSalarioBase();

        // Lógica de negócio:
        // Esta classe muda SOMENTE se a regra de cálculo mudar.
        if (salarioBase > 5000.00) {
            return salarioBase * 0.90;
        } else {
            return salarioBase * 0.95;
        }
    }
}
