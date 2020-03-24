package seedu.address.model.hotel.bill;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Cost {
    public static final String MESSAGE_CONSTRAINTS =
            "Cost should only contain numbers, and it should have a maximum of 2 decimal places";
    public static final String VALIDATION_REGEX = "[\\d\\.\\d{2}]";

    public final double cost;

    /**
     * Constructs a {@code Cost}.
     *
     * @param cost A valid cost.
     */
    public Cost(String cost) {
        requireNonNull(cost);
        checkArgument(isValidCost(cost), MESSAGE_CONSTRAINTS);
        this.cost = Double.valueOf(cost);
    }

    /**
     * Returns true if a given string is a valid cost.
     */
    public static boolean isValidCost(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return String.format("%.2f", cost);
    }
}
