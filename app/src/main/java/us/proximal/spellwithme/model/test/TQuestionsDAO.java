package us.proximal.spellwithme.model.test;

import java.util.ArrayList;

import us.proximal.spellwithme.model.def.IQuestionsDAO;
import us.proximal.spellwithme.model.dto.QuestionDTO;

/**
 * Created by b on 11/26/14.
 */

public class TQuestionsDAO implements IQuestionsDAO {

    @Override
    public boolean create(QuestionDTO q) throws Exception {
        return false;
    }

    @Override
    public QuestionDTO read(int accountId) throws Exception {
        return null;
    }

    @Override
    public QuestionDTO read(String qText) throws Exception {
        return null;
    }

    @Override
    public boolean update(QuestionDTO q) throws Exception {
        return false;
    }

    @Override
    public void delete(QuestionDTO q) throws Exception {

    }

    @Override
    public ArrayList<QuestionDTO> list() {
        return null;
    }

}
