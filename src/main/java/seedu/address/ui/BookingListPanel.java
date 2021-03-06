package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.hotel.booking.Booking;

/**Booking list Ui*/
public class BookingListPanel extends UiPart<Region> {
    private static final String FXML = "BookingListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(BookingListPanel.class);

    @FXML
    private ListView<Booking> bookingListView;

    public BookingListPanel(ObservableList<Booking> bookingList) {
        super(FXML);
        bookingListView.setItems(bookingList);
        bookingListView.setCellFactory(listView -> new BookingListPanel.BookingListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class BookingListViewCell extends ListCell<Booking> {
        @Override
        protected void updateItem(Booking booking, boolean empty) {
            super.updateItem(booking, empty);

            if (empty || booking == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new BookingCard(booking).getRoot());
            }
        }
    }
}
