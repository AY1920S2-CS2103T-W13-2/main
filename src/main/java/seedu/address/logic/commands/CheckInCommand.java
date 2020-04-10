package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ROOMNUMBER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TODATE;

import java.time.LocalDateTime;
import java.util.Optional;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.hotel.Stay;
import seedu.address.model.hotel.bill.Bill;
import seedu.address.model.hotel.person.Person;
import seedu.address.model.hotel.room.Room;
import seedu.address.model.ids.PersonId;
import seedu.address.model.ids.RoomId;
import seedu.address.model.timeframe.TimeFrame;

/**
 * Checks in a guest to the hotel.
 */
public class CheckInCommand extends Command {

    public static final String COMMAND_WORD = "checkin";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Checks in a guest to the hotel.\n"
        + "Parameters: "
        + PREFIX_ID + "ID "
        + PREFIX_ROOMNUMBER + "ROOMNUMBER "
        + PREFIX_TODATE + "TODATE\n"
        + "Example: " + COMMAND_WORD + " "
        + PREFIX_ID + "G1231231U "
        + PREFIX_ROOMNUMBER + "101 "
        + PREFIX_TODATE + "2020-03-14";

    public static final String MESSAGE_SUCCESS = "Room %1$s is booked by %2$s";
    public static final String MESSAGE_ROOM_OCCUPIED = "Room %1$s is occupied";
    public static final String MESSAGE_ROOM_NOT_EXISTS = "Room %1$s does not exist.";
    public static final String MESSAGE_PERSON_NOT_EXISTS = "Guest (ID: %1$s) does not exist.";
    public static final String MESSAGE_DATE_PASSED = "%1$s has passed";

    private final PersonId personId;
    private final RoomId roomId;
    private final LocalDateTime toDate;

    /**
     * Creates a CheckInCommand from current date until {@code toDate}
     * @param personId the ID of the Person who wants to check in.
     * @param roomId the ID of the Room that is going to be checked in.
     * @param toDate the end Date of the stay.
     */
    public CheckInCommand(PersonId personId, RoomId roomId, LocalDateTime toDate) {
        requireNonNull(personId);
        requireNonNull(roomId);
        requireNonNull(toDate);
        this.personId = personId;
        this.roomId = roomId;
        this.toDate = toDate;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        Optional<Person> person = model.findPersonWithId(personId);
        Optional<Room> room = model.findRoom(roomId);

        if (person.isEmpty()) {
            throw new CommandException(String.format(MESSAGE_PERSON_NOT_EXISTS, personId));
        }
        if (room.isEmpty()) {
            throw new CommandException(String.format(MESSAGE_ROOM_NOT_EXISTS, roomId));
        }
        if (!(toDate.isAfter(LocalDateTime.now()))) {
            throw new CommandException(String.format(MESSAGE_DATE_PASSED, toDate));
        }

        TimeFrame stayTimeFrame = new TimeFrame(LocalDateTime.now(), toDate);
        if (!(model.isRoomFree(person.get(), room.get(), stayTimeFrame))) {
            throw new CommandException(String.format(MESSAGE_ROOM_OCCUPIED, roomId));
        }

        Stay stay = new Stay(person.get(), room.get(), LocalDateTime.now(), toDate, "");
        model.checkIn(stay);
        model.addBill(new Bill(personId, roomId));
        model.chargeService(roomId, room.get().getRoomCost());

        return new CommandResult(String.format(MESSAGE_SUCCESS, roomId, personId));
    }
}
