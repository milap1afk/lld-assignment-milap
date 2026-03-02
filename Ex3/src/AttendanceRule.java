public class AttendanceRule implements EligibilityRule {
    @Override
    public void apply(StudentProfile s, RuleContext ctx) {
        if (s.attendancePct < 75) {
            ctx.fail("attendance below 75");
        }
    }
}