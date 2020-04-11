package seedu.address.testutil;

import seedu.address.model.hotel.person.Email;
import seedu.address.model.hotel.person.Name;
import seedu.address.model.hotel.person.Person;
import seedu.address.model.hotel.person.Phone;
import seedu.address.model.hotel.person.Remark;
import seedu.address.model.ids.PersonId;
import seedu.address.model.tag.Tag;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Alice Pauline";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "alice@gmail.com";
    public static final String DEFAULT_ID = "A000000";
    public static final String DEFAULT_REMARK = "She likes aardvarks.";
    public static final String DEFAULT_TAG = "VVIP";

    private Name name;
    private Phone phone;
    private Email email;
    private PersonId personId;
    private Remark remark;
    private Tag tag;

    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        personId = new PersonId(DEFAULT_ID);
        remark = new Remark(DEFAULT_REMARK);
        tag = new Tag(DEFAULT_TAG);
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        personId = personToCopy.getPersonId();
        remark = personToCopy.getRemark();
        tag = personToCopy.getTags();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tag} into a {@code Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String tag) {
        this.tag = new Tag(tag);
        return this;
    }

    /**
     * Sets the {@code PersonId} of the {@code Person} that we are building.
     */
    public PersonBuilder withPersonId(String personId) {
        this.personId = new PersonId(personId);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Remark} of the {@code Person} that we are building.
     */
    public PersonBuilder withRemark(String remark) {
        this.remark = new Remark(remark);
        return this;
    }



    public Person build() {
        return new Person(name, personId, phone, email, remark, tag);
    }

}
