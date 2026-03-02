public class DisciplinaryRule implements EligibilityRule {

    @Override
    public void apply(StudentProfile s, RuleContext ctx) {
        if (s.disciplinaryFlag != LegacyFlags.NONE) {
            ctx.fail("disciplinary flag present");
        }
    }
}