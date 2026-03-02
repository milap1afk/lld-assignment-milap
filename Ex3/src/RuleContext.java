import java.util.*;

public class RuleContext {
    public String status = "ELIGIBLE";
    public List<String> reasons = new ArrayList<>();

    public void fail(String reason) {
        status = "NOT_ELIGIBLE";
        reasons.add(reason);
    }
}