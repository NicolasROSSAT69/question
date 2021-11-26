package fr.gamedev.question.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author djer1
 *
 */
@Entity
public class User {
    /**
     * id.
     */
    @GeneratedValue(generator = "seq_gen_user")
    @GenericGenerator(name = "seq_gen_user", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "seq_user"), @Parameter(name = "initial_value", value = "0"),
            @Parameter(name = "increment_size", value = "1") })
    @Id
    private long id;
    /**
     * User id.
     */
    private String login;
    /**
     * User lastName.
     */
    private String lastName;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param theid the id to set
     */
    public void setId(final long theid) {
        this.id = theid;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param thelogin the login to set
     */
    public void setLogin(final String thelogin) {
        this.login = thelogin;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param thelastName the lastName to set
     */
    public void setLastName(final String thelastName) {
        this.lastName = thelastName;
    }

}
