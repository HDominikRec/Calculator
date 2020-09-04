public enum Operation {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,
    APPLY;

    double calculate(double x, double y){
        return switch (this) {
            case ADD -> x + y;
            case SUBTRACT -> x - y;
            case MULTIPLY -> x * y;
            case DIVIDE -> x / y;
            default -> throw new AssertionError("Unknown operations " + this);
        };
    }
}
