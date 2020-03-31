package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.hotel.room.Room;

/**
 * An UI component that displays information of a {@code Room}.
 */
public class RoomCard extends UiPart<Region> {
    private static final String FXML = "RoomCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Room room;

    @FXML
    private HBox cardPane;
    @FXML
    private Label tier;
    @FXML
    private Label roomNum;

    public RoomCard(Room room, int displayedIndex) {
        super(FXML);
        this.room = room;
        if (tier == null) {
            tier = new Label();
        }
        tier.setText(room.getTier().toString());
        roomNum.setText(room.getRoomNum());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof RoomCard)) {
            return false;
        }

        // state check
        RoomCard card = (RoomCard) other;
        return roomNum.getText().equals(card.roomNum.getText())
                && room.equals(card.room);
    }

}
