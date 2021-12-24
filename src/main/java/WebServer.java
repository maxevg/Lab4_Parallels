import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.server.Route;
import akka.pattern.PatternsCS;
import akka.routing.RoundRobinPool;

import java.util.concurrent.CompletionStage;

import static akka.http.javadsl.server.Directives.*;

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
        testPackageActor = system.actorOf(Props.create(TestPackageActor.class), TEST_PACKAGE_ACTOR);
        testPerformerActor = system.actorOf(new RoundRobinPool(NUMBER_OF_POOLS).props(Props.create(TestActor.class)), TEST_PERFORMER_ACTOR);
    }

    private Route createRoute() {
        return route(
                get(() ->
                        parameter("packageId", (packageId) -> {
                            CompletionStage<Object> result = PatternsCS.ask(
                                    storeActor,
                                    new GetMessage(Integer.parseInt(packageId)),
                                    TIME_OUT_MILLIS);
                            )
                        }))
        )
    }

}
