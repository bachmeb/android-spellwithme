package us.proximal.spellwithme.controller.svc;

import us.proximal.spellwithme.model.dao.WordsDAO;
import us.proximal.spellwithme.model.def.IWordsDAO;
import us.proximal.spellwithme.model.dto.WordDTO;

/**
 * Created by b on 11/24/14.
 */
public class WordsService implements us.proximal.spellwithme.controller.def.IWordsService {
    private IWordsDAO dao;

    public WordsService(){

        dao = new WordsDAO();
    }

    @Override
    public WordDTO getRandomWord() {
        return null;
    }

    @Override
    public WordDTO getWordById(int wordId) {
        return null;
    }

    @Override
    public WordDTO getWordByText(String text) {
        return null;
    }

    @Override
    public WordDTO getWordByLength(int length) {
        return null;
    }

    @Override
    public WordDTO getWordByType(String type) {
        return null;
    }
}
