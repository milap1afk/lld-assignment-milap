import java.util.*;

public class OnboardingService {

    private final StudentRepository db;
    private final StudentParser parser;
    private final StudentValidator validator;
    private final RegistrationPrint printer;

    public OnboardingService(StudentRepository db) {
        this.db = db;
        this.parser = new StudentParser();
        this.validator = new StudentValidator();
        this.printer = new RegistrationPrint();
    }

    public void registerFromRawInput(String raw) {

        printer.printInput(raw);

        Map<String,String> kv = parser.parse(raw);

        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        List<String> errors = validator.validate(name, email, phone, program);

        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        db.save(rec);

        printer.printSuccess(id, db.count(), rec);
    }
}