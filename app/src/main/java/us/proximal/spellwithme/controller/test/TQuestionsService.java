package us.proximal.spellwithme.controller.test;

import us.proximal.spellwithme.controller.def.IQuestionsService;
import us.proximal.spellwithme.controller.def.IWordsService;
import us.proximal.spellwithme.model.def.IQuestionsDAO;
import us.proximal.spellwithme.model.dto.AnswerDTO;
import us.proximal.spellwithme.model.dto.QuestionDTO;
import us.proximal.spellwithme.model.spo.SQuestionsDAO;

/**
 * Created by b on 11/26/14.
 */
public class TQuestionsService implements IQuestionsService {
    IQuestionsDAO dao = new SQuestionsDAO();
    IWordsService service = new TWordsService();

    @Override
    public QuestionDTO ask(int studentId, int mkoId) throws Exception {
        QuestionDTO q = new QuestionDTO();

        q.setQuestionId(0);
        q.setText("What time is it?");
        q.setWordId(0);
        q.setDescription("This is a question about time");
        q.setWord(service.getWordById(0).getWord());

        return q;
    }

    @Override
    public QuestionDTO ask(int studentId, int mkoId, int questionId) throws Exception {
        return null;
    }

    @Override
    public void answer(AnswerDTO answer) throws Exception {

    }


}
