package us.proximal.spellwithme.controller.def;

import us.proximal.spellwithme.model.dto.AnswerDTO;
import us.proximal.spellwithme.model.dto.QuestionDTO;

/**
 * Created by b on 11/26/14.
 */
public interface IQuestionsService {

    public QuestionDTO ask(int studentId, int mkoId) throws Exception;

    public void answer(int studentId, int mkoId, AnswerDTO answer) throws Exception;


}
