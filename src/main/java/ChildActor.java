import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class ChildActor extends UntypedActor {

    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object msg) throws Exception {
        if (msg instanceof HelloMessage) {
            log.info("Mensagem do ator filho: " + msg);
        } else {
            unhandled(msg);
        }
    }
}
