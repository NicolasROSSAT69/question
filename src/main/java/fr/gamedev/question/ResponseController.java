package fr.gamedev.question;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.gamedev.question.data.Answer;
import fr.gamedev.question.data.UserAnswer;
import fr.gamedev.question.repository.UserAnswerRepository;

/**
 * @author nicolas
 *
 */
@RestController
public class ResponseController {

    /* private Integer pointsTotal = 0; */

    /** point pour une réponse juste. */
    private static final Integer POINT_JUSTE = 1;

    /** point pour une réponse fausse. */
    private static final Integer POINT_FAUX = 0;

    /** Réponse utilisateur. */
    @Autowired
    private UserAnswerRepository userAnswerRepository;

    /**
     * Recupération des réponses d'un utilisateur pour une question défini.
     *
     * @param idUserAnswer
     * @param answer
     * @return point
     */
    @PostMapping(value = "/response", produces = "application/hal+json")
    public UserAnswer answer(@RequestParam
    final long idUserAnswer, @RequestParam
    final Boolean answer) {

        UserAnswer response = null;

        Optional<UserAnswer> askedQuestion = userAnswerRepository.findById(idUserAnswer);

        Answer expectedAnswer = askedQuestion.get().getAnswer();

        if (expectedAnswer.getCorrectAnswer() == answer) {

            askedQuestion.get().setPoints(POINT_JUSTE);

        } else {

            askedQuestion.get().setPoints(POINT_FAUX);

        }

        response = userAnswerRepository.save(askedQuestion.get());

        return response;
    }

}
