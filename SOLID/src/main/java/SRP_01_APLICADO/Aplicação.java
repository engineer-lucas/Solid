package SRP_APLICADO;

public class Aplicação {
    public static void main(String[] args) {
        // 1. Instanciação inicial
        Funcionario lucas = new Funcionario("Lucas Santos", 5000.00, "Especialista de Ensino");

        CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
        RepositorioDeFuncionario repositorio = new RepositorioDeFuncionario();
        GeradorDeRelatorio relatorio = new GeradorDeRelatorio();

        System.out.println("--- CÁLCULO INICIAL ---");

        // Uso das classes especializadas
        double salarioLiquidoInicial = calculadora.calcularSalarioLiquido(lucas);
        System.out.println("Salário Base Inicial de Lucas: R$" + lucas.getSalarioBase());
        System.out.println("Salário Líquido Inicial (Imposto 5%): R$" + salarioLiquidoInicial);

        // 2. USO DO SETTER: Aumento de Salário
        System.out.println("\n--- APLICAÇÃO DE AUMENTO SALARIAL ---");

        // Lucas recebe um aumento, passando o salário base a R$ 6000,00
        lucas.setSalarioBase(6000.00);

        System.out.println("Salário Base Pós-Aumento: R$" + lucas.getSalarioBase());

        // 3. Recálculo e Persistência
        double salarioLiquidoAposAumento = calculadora.calcularSalarioLiquido(lucas);
        System.out.println("Salário Líquido Após Aumento (Imposto 10%): R$" + salarioLiquidoAposAumento);

        // Persistência: salva a mudança no 'banco de dados' (lista em memória)
        repositorio.salvar(lucas);

        // Relatório final, usando o novo estado do objeto 'lucas'
        System.out.println("\n--- RELATÓRIO FINAL ---");
        relatorio.imprimir(lucas, calculadora);
    }
}