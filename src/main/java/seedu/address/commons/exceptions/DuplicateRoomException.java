package seedu.address.commons.exceptions;

/**
 * Exception for duplicate room ID during room creation.
 */
public class DuplicateRoomException extends RuntimeException {
    public DuplicateRoomException() {
        super("Operation would result in duplicate room");
    }
}
