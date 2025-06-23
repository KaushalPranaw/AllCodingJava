package Java8Practice.DynamicValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
/*Implement a dynamic validation system for user input using `Predicate` and `Function`.
The system should allow different validation rules to be applied to a string (e.g., email, password, username).

Requirements:
     - Create a `Predicate<String>` for common validation checks (e.g., length check, character check).
     - Create a `Function<String, Boolean>` to perform a series of validation steps on the input.
     - Use `Predicate.and()`, `Predicate.or()`, and `Predicate.negate()` to combine various validation rules.
     - Allow dynamic input from the user and validate it using the rules.

Implement custom exceptions that provide detailed feedback when validation fails.*/
public class DynamicValidationSystem {

    private static final Predicate<String> IS_NOT_NULL_OR_EMPTY = input -> input != null && !input.isEmpty();
    private static final Predicate<String> HAS_MIN_LENGTH = input -> input.length() >= 8;
    private static final Predicate<String> HAS_UPPERCASE = input -> input.chars().anyMatch(Character::isUpperCase);
    private static final Predicate<String> HAS_DIGIT = input -> input.chars().anyMatch(Character::isDigit);
    private static final Predicate<String> IS_VALID_EMAIL = input -> input.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");

    // Combine validation rules dynamically
    public static Function<String, Boolean> createValidator(List<Predicate<String>> rules) {
        return input -> {
            List<String> errors = new ArrayList<>();
            for (Predicate<String> rule : rules) {
                try {
                    if (!rule.test(input)) {
                        errors.add("Validation failed for rule: " + rule);
                    }
                } catch (Exception e) {
                    errors.add("Exception occurred during validation: " + e.getMessage());
                }
            }

            if (!errors.isEmpty()) {
                throw new ValidationException(String.join("\n", errors));
            }
            return true;
        };
    }


    public static void main(String[] args) {
        List<Predicate<String>> rulesToApply = new ArrayList<>();
        rulesToApply.add(IS_NOT_NULL_OR_EMPTY);
        rulesToApply.add(HAS_MIN_LENGTH);
        rulesToApply.add(HAS_UPPERCASE);
        rulesToApply.add(HAS_DIGIT);
        rulesToApply.add(IS_VALID_EMAIL);

        // Create a validator using the rules
        Function<String, Boolean> validator = createValidator(rulesToApply);

        // Validate user input
        String userInput = "Test";
        try {
            if (validator.apply(userInput)) {
                System.out.println("Validation successful!");
            }
        } catch (ValidationException ex) {
            System.out.println("Validation failed:\n" + ex.getMessage());
        }

    }
}
