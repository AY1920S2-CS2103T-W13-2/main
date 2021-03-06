package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_PERSONS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BENSON;
import static seedu.address.testutil.TypicalPersons.CARL;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.hotel.person.Name;
import seedu.address.model.hotel.person.Person;
import seedu.address.model.ids.PersonId;

/**
 * Contains integration tests (interaction with the Model) for {@code FindGuestCommand}.
 */
public class FindGuestCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        HashSet<Name> nameList = new HashSet<>(List.of(new Name("Alice")));
        HashSet<PersonId> personIdList = new HashSet<>(List.of(new PersonId("A0")));

        FindGuestCommand findFirstCommand = new FindGuestCommand(nameList, new HashSet<>());
        FindGuestCommand findSecondCommand = new FindGuestCommand(new HashSet<>(), personIdList);

        // same object -> returns true
        assertTrue(findFirstCommand.equals(findFirstCommand));

        // same values -> returns true
        FindGuestCommand findFirstCommandCopy = new FindGuestCommand(nameList, new HashSet<>());
        assertTrue(findFirstCommand.equals(findFirstCommandCopy));

        // different types -> returns false
        assertFalse(findFirstCommand.equals(1));

        // null -> returns false
        assertFalse(findFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(findFirstCommand.equals(findSecondCommand));
    }


    @Test
    public void execute_multipleKeywords_multiplePersonsFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 3);

        List<Name> nameList = List.of(ALICE.getName(), BENSON.getName());
        List<PersonId> personIdList = List.of(CARL.getPersonId());


        Predicate<Person> predicate = preparePredicate(nameList, personIdList);
        FindGuestCommand command = prepareCommand(nameList, personIdList);
        expectedModel.updateFilteredPersonList(predicate);

        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(ALICE, BENSON, CARL), model.getFilteredPersonList());

    }

    private Predicate<Person> preparePredicate(List<Name> nameList, List<PersonId> personIdList) {
        return u -> nameList.contains(u.getName())
            || personIdList.contains(u.getPersonId());
    }
    private FindGuestCommand prepareCommand(List<Name> nameList, List<PersonId> personIdList) {
        return new FindGuestCommand(new HashSet<>(nameList), new HashSet<>(personIdList));
    }
}
