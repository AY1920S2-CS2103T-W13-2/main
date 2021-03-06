package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.function.Predicate;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.hotel.person.Person;


/**
 * Adds a person to the address book.
 */
public class AddGuestCommand extends Command {

    public static final String COMMAND_WORD = "addguest";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to Morpheus.\n"
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_ID + "ID "
            + PREFIX_PHONE + "PHONE "
            + PREFIX_EMAIL + "EMAIL "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_ID + "J000000 "
            + PREFIX_PHONE + "98765432 "
            + PREFIX_EMAIL + "johnd@example.com "
            + PREFIX_TAG + "VIP ";

    public static final String MESSAGE_SUCCESS = "New person added: %1$s";

    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in Morpheus";
    public static final String MESSAGE_DUPLICATE_PERSON_ID = "There is a person with this id";

    private final Person toAdd;

    /**
     * Creates an AddGuestCommand to add the specified {@code Person}
     */
    public AddGuestCommand(Person person) {
        requireNonNull(person);
        toAdd = person;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasPerson(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }
        if (model.hasPersonId(toAdd.getPersonId())) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON_ID);
        }

        model.addPerson(toAdd);
        Predicate<Person> personPredicate = person -> person.getPersonId().equals(this.toAdd.getPersonId());
        model.updateFilteredPersonList(personPredicate);

        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd), "guest");
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddGuestCommand // instanceof handles nulls
                && toAdd.equals(((AddGuestCommand) other).toAdd));
    }
}
