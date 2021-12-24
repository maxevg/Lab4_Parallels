import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StoreActor extends AbstractActor {
    private Map<Integer, ArrayList<Test>> store = new HashMap<Integer, ArrayList<Test>>();

    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match()
    }
}
