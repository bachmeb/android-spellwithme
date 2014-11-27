package us.proximal.spellwithme.controller.svc;

import us.proximal.spellwithme.controller.def.IAnswersService;
import us.proximal.spellwithme.model.dao.AnswersDAO;
import us.proximal.spellwithme.model.def.IAnswersDAO;

/**
 * Created by b on 11/27/14.
 */
public class AnswersService implements IAnswersService{

    IAnswersDAO daoAnswers;

    @Override
    public void create() {
        daoAnswers = new AnswersDAO();

    }

}
