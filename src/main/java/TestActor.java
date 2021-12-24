import akka.actor.AbstractActor;
import akka.actor.ActorSelection;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;

public class TestActor extends AbstractActor {
    private ActorSelection storeActor = getContext().actorSelection("/user/storeActor");
    private final String SCRIPT_BY_NAME = "nashorn";

    private ArrayList<Test> runTest(String jsScript, String functionName, String testName,
                                    String expectedResult, ArrayList<Integer> params) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName(SCRIPT_BY_NAME);
        engine.eval(jsScript);
        Invocable invocable = (Invocable) engine;
        String result = invocable.invokeFunction(functionName, params.toArray()).toString();


    }
}
