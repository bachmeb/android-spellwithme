package us.proximal.spellwithme.model.dao;

import us.proximal.spellwithme.model.def.IWordsDAO;
import us.proximal.spellwithme.model.dto.WordDTO;

/**
 * Created by b on 11/24/14.
 */
public class WordsDAO implements IWordsDAO {

    @Override
    public void create(WordDTO word) {

    }

    @Override
    public WordDTO read(int wordId) {
        return null;
    }

    @Override
    public void update(WordDTO word) {

    }

    @Override
    public void delete(WordDTO word) {

    }

    @Override
    public WordDTO[] list() {
        return new WordDTO[0];
    }

    @Override
    public WordDTO random() {
        return null;
    }

}
