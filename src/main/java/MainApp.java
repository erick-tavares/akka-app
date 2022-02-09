import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class MainApp {
    public static void main(String[] args) {
        //Criando o ActorSytem que gerencia os atores
        ActorSystem system = ActorSystem.create("HelloSystem");

        //Criando um ator Aurora, utilizando o props de uma maneira simples e nomeando o ator
        ActorRef auroraActor = system.actorOf(Props.create(AuroraActor.class),"aurora");

        //o método noSender retorna uma constante para identificar o ActorSystem, já que
        //a mensagem está sendo enviada direto do System e não de um outro ator
        auroraActor.tell("Olá mundo de atores", ActorRef.noSender());
    }
}
