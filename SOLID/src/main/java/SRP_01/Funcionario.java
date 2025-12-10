package SRP_01;

class Funcionario {
    private String nome;
    private double salarioBase;
    private String cargo;

    public Funcionario(String nome, double salarioBase, String cargo) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.cargo = cargo;
    }

    // RESPONSABILIDADE 1: Cálculo de Regra de Negócio
    public double calcularSalarioLiquido() {
// Lógica de negócio complexa:
// 10% de imposto se o salário for acima de 5000, senão 5%.
        if (salarioBase > 5000.00) {
            return salarioBase * 0.90; // 10% de imposto
        } else {
            return salarioBase * 0.95; // 5% de imposto
        }
    }

    // RESPONSABILIDADE 2: Gestão de Dados (Persistência)
    public void salvarNoBancoDeDados() {
// Simula a lógica de conexão e escrita no banco
        System.out.println("Funcionario " + nome + " salvo no banco de dados.");
// ... (código JDBC ou JPA aqui)
    }

    // RESPONSABILIDADE 3: Apresentação (Formatação de Relatório)
    public void imprimirRelatorio() {
// Lógica de formatação para impressão ou exportação
        System.out.println("--- Relatório de Funcionário ---");
        System.out.println("Nome: " + nome);
        System.out.println("Salário Base: R$ " + salarioBase);
        System.out.println("Salário Líquido Calculado: R$ " + calcularSalarioLiquido());
        System.out.println("--------------------------------");
    }
}
// Getters e Setters (omitidos para simplificar)}