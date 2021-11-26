package fr.gamedev.question.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author djer1
 *
 */
@Entity
public class UserAnswer {
	/**
	 * id.
	 */
	@GeneratedValue(generator = "seq_gen_userAnswer")
	@GenericGenerator(name = "seq_gen_userAnswer", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	parameters = {
			@Parameter(name = "sequence_name", value = "seq_answerUser"),
			@Parameter(name = "initial_value", value = "0"),
			@Parameter(name = "increment_size", value = "1") })
	@Id
	private long id;
	/**
	 * User user.
	 */
	@ManyToOne
	private User user;
	/**
	 * Answer answer.
	 */
	@ManyToOne
	private Answer answer;
	/**
	 * UserAnswer points.
	 */
	private long points;

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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param theuser the user to set
	 */
	public void setUser(final User theuser) {
		this.user = theuser;
	}

	/**
	 * @return the points
	 */
	public long getPoints() {
		return points;
	}

	/**
	 * @param thepoints the points to set
	 */
	public void setPoints(final long thepoints) {
		this.points = thepoints;
	}

	/**
	 * @return the answer
	 */
	public Answer getAnswer() {
		return answer;
	}

	/**
	 * @param theanswer the answer to set
	 */
	public void setAnswer(final Answer theanswer) {
		this.answer = theanswer;
	}

}
