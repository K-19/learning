package uninstantiation;

// Неинстанцируемый служебный класс
public class UtilityClass {
    private UtilityClass() {
        throw new AssertionError();
    }
}
