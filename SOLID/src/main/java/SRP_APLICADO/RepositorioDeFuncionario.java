package SRP_APLICADO;
// 3. Classe de Persistência: Responsável APENAS pela comunicação com o BD.
public class RepositorioDeFuncionario {
    public void salvar(Funcionario funcionario) {
        // Lógica de persistência:
        // Esta classe muda SOMENTE se a tecnologia de persistência (BD) mudar.
        System.out.println("Funcionario " + funcionario.getNome() + " salvo no banco de dados.");
    }
}
