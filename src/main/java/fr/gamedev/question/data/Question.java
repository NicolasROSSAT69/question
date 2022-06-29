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
public class Question {
    // TODO grp6 by DJE : JavaDoc : le commentaire Javadoc s'applique sur lattribut
    // "id", c'est lui qu'il faut documenter. Les annotations ont déja leur
    // ducomentation.

    @GeneratedValue(generator = "seq_gen_question")
    @GenericGenerator(name = "seq_gen_question", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "seq_question"), @Parameter(name = "initial_value", value = "0"),
            @Parameter(name = "increment_size", value = "1") })
    @Id
    private long id;
    /**
     * Question content.
     */
    private String content;

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
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param thecontent the content to set
     */
    public void setContent(final String thecontent) {
        this.content = thecontent;
    }

}
