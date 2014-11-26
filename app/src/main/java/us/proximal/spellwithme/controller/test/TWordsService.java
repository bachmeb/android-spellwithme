package us.proximal.spellwithme.controller.test;

import java.util.ArrayList;

import us.proximal.spellwithme.controller.def.IWordsService;
import us.proximal.spellwithme.model.dao.WordsDAO;
import us.proximal.spellwithme.model.def.IWordsDAO;
import us.proximal.spellwithme.model.dto.WordDTO;

/**
 * Created by b on 11/24/14.
 */
public class TWordsService implements IWordsService{
    IWordsDAO dao;

    public TWordsService(){

        dao = new WordsDAO();

    }

    @Override
    public WordDTO getRandomWord() {
        WordDTO word = new WordDTO();
        word.setWord("random");
        return word;
    }

    @Override
    public WordDTO getWordById(int wordId) {

        WordDTO word = new WordDTO();
        word.setWord("byid");
        return word;

    }

    @Override
    public WordDTO getWordByText(String text) {

        WordDTO word = new WordDTO();
        word.setWord("bytext");
        return word;
    }

    @Override
    public WordDTO getWordByLength(int length) {

        WordDTO word = new WordDTO();
        word.setWord("bylength");
        return word;
    }

    @Override
    public WordDTO getWordByType(String type) {

        WordDTO word = new WordDTO();
        word.setWord("bytype");
        return word;
    }

    @Override
    public ArrayList<WordDTO> getDolchWords() {

        WordDTO word = new WordDTO();
        word.setWord("dolch");

        ArrayList<WordDTO> words = new ArrayList<WordDTO>();
        words.add(word);

        return words;

    }

    @Override
    public ArrayList<WordDTO> getFryWords() {

        WordDTO word = new WordDTO();
        word.setWord("fry");

        ArrayList<WordDTO> words = new ArrayList<WordDTO>();
        words.add(word);

        return words;
    }
}
