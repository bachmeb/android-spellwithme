package us.proximal.spellwithme.controller.svc;

import android.content.Context;

import us.proximal.spellwithme.controller.def.IAnswersService;
import us.proximal.spellwithme.model.dao.AnswersDAO;
import us.proximal.spellwithme.model.def.IAnswersDAO;
import us.proximal.spellwithme.model.dto.AnswerDTO;

/**
 * Created by b on 11/27/14.
 */
public class AnswersService implements IAnswersService{

    IAnswersDAO daoAnswers;

    /*
    Constructor
    */
    public AnswersService(Context ctx){
        daoAnswers = new AnswersDAO(ctx);
    }

    @Override
    public void saveAnswer(AnswerDTO answer) {
        try {
            daoAnswers.create(answer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
