package SRP_APLICADO;
// 1. Classe Entidade: Apenas mantém o estado (dados).
public class Funcionario {
    private String nome;
    private double salarioBase;
    private String cargo;

    public Funcionario(String nome, double salarioBase, String cargo) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.cargo = cargo;
    }
    // Apenas getters e setters para acesso aos dados
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // ...
}
