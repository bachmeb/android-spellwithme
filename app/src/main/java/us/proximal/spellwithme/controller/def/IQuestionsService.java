package us.proximal.spellwithme.controller.def;

import us.proximal.spellwithme.model.dto.AnswerDTO;
import us.proximal.spellwithme.model.dto.QuestionDTO;

/**
 * Created by b on 11/26/14.
 */
public interface IQuestionsService {

    /*
    Ask a random question
     */
    public QuestionDTO ask(int studentId, int mkoId) throws Exception;

    /*
    Ask a specific question
     */
    public QuestionDTO ask(int studentId, int mkoId, int questionId) throws Exception;

    /*
    Answer a question
     */
    public void answer(AnswerDTO answer) throws Exception;


}
