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

    /**
     * total des points.
     */
    private Integer pointsTotal = 0;

    /**
     * point pour une réponse juste.
     */
    private static final Integer POINT_JUSTE = 1;

    /**
     * point pour une réponse fausse.
     */
    private static final Integer POINT_FAUX = 0;

    /**
     * Réponse utilisateur.
     */
    @Autowired
    private UserAnswerRepository useranswerrepository;

    /**
     * Recupération des réponses d'un utilisateur pour une question défini.
     * 
     * @param iduseranswer
     * @param answer
     * @return point
     */
    @PostMapping(value = "/response", produces = "application/hal+json")
    public UserAnswer answer(@RequestParam
    final long iduseranswer, @RequestParam
    final Boolean answer) {

        UserAnswer response = null;

        Optional<UserAnswer> askedQuestion = useranswerrepository.findById(iduseranswer);

        Answer expectedAnswer = askedQuestion.get().getAnswer();

        if (expectedAnswer.getCorrectAnswer() == answer) {

            askedQuestion.get().setPoints(POINT_JUSTE);

        } else {

            askedQuestion.get().setPoints(POINT_FAUX);

        }

        response = useranswerrepository.save(askedQuestion.get());

        return response;
    }

}
