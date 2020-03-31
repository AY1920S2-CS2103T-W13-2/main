package seedu.address.model.hotel.bill;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a service that a guest has requested for.
 */
public class Service implements Chargeable {

    public static final String DESC_MESSAGE_CONSTRAINTS =
            "Description should only contain alphanumeric characters and spaces, and it should not be blank";
    public static final String DESC_VALIDATION_REGEX = "[\\p{Alnum}]*";

    private String description;
    private Cost cost;

    /**
     * Creates a {@code service} that has a {@code cost}.
     *
     * @param desc a valid description
     * @param cost a valid cost
     */
    public Service(String desc, Cost cost) {
        requireNonNull(desc);
        checkArgument(isValidDescription(desc), DESC_MESSAGE_CONSTRAINTS);

        this.description = desc;
        this.cost = cost;
    }

    /**
     * Returns true if a given string is a valid description.
     */
    public static boolean isValidDescription(String test) {
        return test.matches(DESC_VALIDATION_REGEX);
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public Cost getCost() {
        return this.cost;
    }
}