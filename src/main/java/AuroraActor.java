import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;


public class AuroraActor extends UntypedActor {

    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    private ActorRef childActor;

    @Override
    public void preStart() throws Exception {
        super.preStart();
        //instanciando o ator filho ao iniciar o ator
        childActor = getContext().actorOf(Props.create(ChildActor.class), "childOfAurora");

    }

    @Override
    public void onReceive(Object msg) throws Exception {
        if(msg instanceof HelloMessage){
            log.info("Mensagem recebida: " + msg);
            //Repasa a mensagem recebida para o ator filho
            childActor.tell(msg, getSelf());
        }else{
            //informa o ActorSystem que este ator não processa este tipo de menssagem
            unhandled(msg);
        }
    }
}
