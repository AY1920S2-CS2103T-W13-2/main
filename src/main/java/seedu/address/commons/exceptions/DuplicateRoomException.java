package seedu.address.commons.exceptions;

public class DuplicateRoomException extends RuntimeException {
    public DuplicateRoomException() {
        super("Operation would result in duplicate room");
    }
}
