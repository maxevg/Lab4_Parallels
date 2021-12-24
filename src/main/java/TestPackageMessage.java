import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class TestPackageMessage {
    private final String PACKAGE_ID = "packageId";
    private final String JS_SCRIPT = "jsScript";
    private final String FUNCTION_NAME = "functionName";
    private final String TESTS = "tests";

    @JsonProperty(PACKAGE_ID)
    private Integer packageId;

    @JsonProperty(PACKAGE_ID)
    private String jsScript;

    @JsonProperty(PACKAGE_ID)
    private String functionName;

    @JsonProperty(TESTS)
    private ArrayList<Test> tests;

    @JsonCreator
    TestPackageMessage(@JsonProperty(PACKAGE_ID) int packageId, @JsonProperty(JS_SCRIPT) String jsScript,
                       @JsonProperty(FUNCTION_NAME) String functionName, @JsonProperty(TESTS) ArrayList<Test> tests) {
        
    }
}
