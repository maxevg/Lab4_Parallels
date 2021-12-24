public class TestMessage {
    private Integer packageId;
    private String jsScript;
    private String functionName;
    private Test test;

    public TestMessage(Integer packageId, String jsScript, String functionName, Test test) {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.test = test;
    }
}
