package SRP_02_APLICADO;

//4. Persistência: `RepositorioDePedido` (Responsabilidade 3)
//Responsável **APENAS** pela comunicação com o banco de dados.

// 3. Responsabilidade: Apenas lidar com operações de BD.

public class RepositorioDePedido {
    public void salvar(Pedido pedido) {
        // Esta classe muda SOMENTE se a tecnologia de persistência mudar (ex: de SQL para JPA).
        System.out.println("-> Persistência: Pedido " + pedido.getId() + " salvo no banco de dados.");
    }
}
