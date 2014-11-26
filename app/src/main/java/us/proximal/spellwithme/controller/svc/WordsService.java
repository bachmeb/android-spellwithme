package us.proximal.spellwithme.controller.svc;

import us.proximal.spellwithme.model.dao.WordsDAO;
import us.proximal.spellwithme.model.def.IWordsDAO;
import us.proximal.spellwithme.model.dto.WordDTO;

/**
 * Created by b on 11/24/14.
 */
public class WordsService {
    IWordsDAO dao;

    public WordsService(){
        dao = new WordsDAO();
    }

    public WordDTO getNewWord(){
        WordDTO word;

        word = dao.random();

        return word;
    }

    public WordDTO getNewWord(int level){
        WordDTO word;

        word = dao.random();

        return word;

    }
}
