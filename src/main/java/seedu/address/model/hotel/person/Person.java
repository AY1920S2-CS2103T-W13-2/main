package seedu.address.model.hotel.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Objects;

import seedu.address.model.hotel.bill.AvailableService;
import seedu.address.model.hotel.bill.Bill;
import seedu.address.model.ids.PersonId;
import seedu.address.model.ids.RoomId;
import seedu.address.model.tag.Tag;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;
    private final PersonId personId;

    // Data fields
    //private final Address address;
    private final Remark remark;
    private Tag tag;
    private ArrayList<Bill> bills = new ArrayList<>();

    /**
     * Old constructor
     */
    public Person(Name name, Phone phone, Email email, Remark remark, Tag tag) {
        requireAllNonNull(name, phone, email, tag);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.personId = new PersonId("A000000");
        this.remark = remark;
        this.tag = tag;
    }
    /**
     * Every field must be present and not null.
     */
    public Person(Name name, PersonId personId, Phone phone, Email email, Remark remark, Tag tag) {
        requireAllNonNull(name, personId, phone, email, tag);
        this.name = name;
        this.personId = personId;
        this.phone = phone;
        this.email = email;
        this.remark = remark;
        this.tag = tag;
    }


    /**
     * Simplify person with no personal details.
     */
    public Person(Name name, PersonId personId) {
        requireAllNonNull(name, personId);
        this.name = name;
        this.personId = personId;

        this.phone = new Phone("99999999");
        this.email = new Email("default@mail");
        this.remark = new Remark("default");
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public PersonId getPersonId() {
        return personId;
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public Remark getRemark() {
        return remark;
    }

    public Tag getTags() {
        return tag;
    }

    /**
     * Returns true if both persons of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName())
                && (otherPerson.getPhone().equals(getPhone()) || otherPerson.getEmail().equals(getEmail()));
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return otherPerson.getPersonId().equals(getPersonId())
            && otherPerson.getName().equals(getName())
            && otherPerson.getEmail().equals(getEmail())
            && otherPerson.getPhone().equals(getPhone())
            && otherPerson.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, personId, phone, email, tag);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" PersonId: ")
                .append(getPersonId())
                .append(" Phone: ")
                .append(getPhone())
                .append(" Email: ")
                .append(getEmail())
                .append(" Remark: ")
                .append(getRemark())
                .append(" Tags: ")
                .append(getTags());
        return builder.toString();
    }

}
