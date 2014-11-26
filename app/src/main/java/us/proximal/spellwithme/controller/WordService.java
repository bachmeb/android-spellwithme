package us.proximal.spellwithme.controller;

import us.proximal.spellwithme.model.dao.WordsDAO;
import us.proximal.spellwithme.model.def.IWordsDAO;
import us.proximal.spellwithme.model.dto.WordDTO;

/**
 * Created by b on 11/24/14.
 */
public class WordService {
    IWordsDAO dao;

    public WordService(){
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
