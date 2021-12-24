import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class WebServer {
    private ActorRef storeActor;
    private final String STORE_ACTOR = "storeActor";

    private ActorRef testPerformerActor;
    private final String TEST_PERFORMER_ACTOR = "testPerformerActor";

    private ActorRef testPackageActor;
    private final String TEST_PACKAGE_ACTOR = "testPackageActor";

    private static final String SERVER = "localhost";
    private static final Integer PORT = 8080;
    private static final Integer NUMBER_OF_POOLS = 5;
    private static final Integer TIME_OUT_MILLIS = 5000;

    private WebServer(final ActorSystem system) {
        storeActor = system.actorOf(Props.create(StoreActor.class), STORE_ACTOR);
    }

}
