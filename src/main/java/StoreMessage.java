import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class StoreMessage {
    private final String PACKAGE_ID = "packageId";
    private final String TEST = "test";

    @JsonProperty(PACKAGE_ID)
    private Integer packageId;

    @JsonProperty(TEST)
    private ArrayList<Test> test;
}
