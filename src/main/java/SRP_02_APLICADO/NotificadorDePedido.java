package SRP_02_APLICADO;
 //5. Comunicação Externa: `NotificadorDePedido` (Responsabilidade 4)
//Responsável **APENAS** pela comunicação com sistemas externos (e-mail, SMS, Webhook, etc.).

// 4. Responsabilidade: Apenas enviar notificações ou comunicar APIs externas.

public class NotificadorDePedido {
    public void enviarConfirmacao(Pedido pedido) {
        // Esta classe muda SOMENTE se o serviço de notificação (e-mail, SMS) mudar.
        if (pedido.isPago()) {
            System.out.println("-> Notificação: Email de confirmação enviado para: " + pedido.getEmailCliente());
        }
    }
}
