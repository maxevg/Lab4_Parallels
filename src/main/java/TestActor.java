import akka.actor.AbstractActor;
import akka.actor.ActorSelection;

public class TestActor extends AbstractActor {
    private ActorSelection storeActor = getContext().actorSelection("/user/storeActor");
    private final String SCRIPT_BY_NAME = "nashorn";
}
