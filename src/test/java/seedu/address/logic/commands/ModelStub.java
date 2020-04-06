package seedu.address.logic.commands;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyHotel;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.hotel.bill.AvailableService;
import seedu.address.model.hotel.bill.RoomCost;
import seedu.address.model.hotel.booking.Booking;
import seedu.address.model.hotel.person.Person;
import seedu.address.model.hotel.room.Room;
import seedu.address.model.hotel.room.Tier;
import seedu.address.model.ids.AvailableServiceId;
import seedu.address.model.ids.PersonId;
import seedu.address.model.ids.RoomId;
import seedu.address.model.timeframe.TimeFrame;

/**
 * Model stub for testing
 */
public class ModelStub implements Model {
    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public GuiSettings getGuiSettings() {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public Path getAddressBookFilePath() {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public Path getHotelFilePath() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setAddressBookFilePath(Path addressBookFilePath) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public void setAddressBook(ReadOnlyAddressBook addressBook) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public ReadOnlyHotel getHotel() {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public boolean hasPerson(Person person) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public boolean hasPersonId(PersonId personId) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public Optional<Person> findPersonWithId(PersonId personId) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public void deletePerson(Person target) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public void addPerson(Person person) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public void setPerson(Person target, Person editedPerson) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public ObservableList<Person> getFilteredPersonList() {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public void updateFilteredPersonList(Predicate<Person> predicate) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public ObservableList<Room> getRoomList() {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public ObservableList<Booking> getBookingList() {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public Optional<Booking> getCurrentStay(Room room) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public Optional<Room> findRoom(RoomId roomNum) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public boolean isRoomFree(Room room, TimeFrame duration) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public boolean hasGuestBooked(Person person, Room room) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public void bookRoom(Booking booking) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public void checkIn(Booking booking) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public boolean checkOut(Room room) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public void deleteBooking(Booking booking) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public void fetchBillList(Person person) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public void fetchBill(Person person, RoomId roomId) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public void addRoom(String roomName) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public boolean hasRoom(String roomName) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public boolean hasBooking(Booking booking) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public boolean hasTier(Tier tier) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public void addTier(Tier tier, ArrayList<String> roomNums) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public void setRoomCost(Room room, RoomCost roomCost) {
        throw new AssertionError("This method should not be called");
    }

    @Override
    public void addAvailableService(AvailableService service) {
        throw new AssertionError("This method should not be called");
    }

    @Override
<<<<<<< HEAD
    public Optional<AvailableService> findService(AvailableServiceId service) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void chargeService(PersonId personId, RoomId roomId, AvailableService service) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void deleteRoom(String roomNum) {
        throw new AssertionError("This method should not be called.");
    }
}
