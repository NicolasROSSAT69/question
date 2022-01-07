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

    //TODO grp6 by DJE : JavaDoc : Il est possible d'écrire les commentaire JavaDoc sur une seul ligne lorsqu'il n'y a pas de paramètres (@author, @param,...)
    /** total des points. */
    //TODO grp6 by DJE : JavaDoc : Eclipse vous indique que cette varaible n'est jamais utilisé. C'est bien que vous ne l'utilisiez pas, vous risqueriez d'avoir des problemes de "ThreadSafe" si vous l'utilisiez. Supprimer cette attribut.
    private Integer pointsTotal = 0;

    /** point pour une réponse juste. */
    private static final Integer POINT_JUSTE = 1;

    /** point pour une réponse fausse. */
    private static final Integer POINT_FAUX = 0;

    //TODO grp6 by DJE : POO : cameCase !
    /** Réponse utilisateur. */
    @Autowired
    private UserAnswerRepository useranswerrepository;

    /**
     * Recupération des réponses d'un utilisateur pour une question défini.
     *
     * @param iduseranswer
     * @param answer
     * @return point
     */
    //TODO grp6 by DJE : POO : Attention au Majuscule (camelCase) pour que le nomage de vos varaible soit plus claire (idUserAnswer)
    @PostMapping(value = "/response", produces = "application/hal+json")
    public UserAnswer answer(@RequestParam final long iduseranswer, @RequestParam final Boolean answer) {

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
