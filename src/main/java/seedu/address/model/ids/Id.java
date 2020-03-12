package seedu.address.model.ids;

/**
 * Id in the system
 */
public abstract class Id {
    private String serializedId;

    protected Id(String serializedId) {
        this.serializedId = serializedId;
    }

    public String getId() {
        return this.serializedId;
    }
}
