package us.proximal.spellwithme.controller.test;

import java.util.ArrayList;

import us.proximal.spellwithme.model.dao.WordsDAO;
import us.proximal.spellwithme.model.def.IWordsDAO;
import us.proximal.spellwithme.model.dto.PersonDTO;
import us.proximal.spellwithme.model.dto.WordDTO;

/**
 * Created by b on 11/24/14.
 */
public class TWordsService {
    IWordsDAO dao;

    WordDTO[] words;

    ArrayList<WordDTO> vocabulary;
    ArrayList<WordDTO> dictionary;


    public TWordsService(){

        dao = new WordsDAO();
        words = makeWords();
    }

    private WordDTO[] makeWords() {
        WordDTO single;
        WordDTO[] set = new WordDTO[1000];

        single = new WordDTO();

        single.setWord("apple");
        set[0]=single;

        single = new WordDTO();
        single.setWord("banana");
        set[1]=single;

        single = new WordDTO();
        single.setWord("cherry");
        set[2]=single;

        single = new WordDTO();
        single.setWord("dog");
        set[3]=single;


        return set;
    }

    public WordDTO getNewWord(){
        WordDTO word;

        int rand = (int) (4 * Math.random());

        //word = dao.random();

        word = words[rand];

        return word;
    }

    public ArrayList<WordDTO> getVocabulary(PersonDTO person) {
        return null;
    }

    public ArrayList<WordDTO> getDictionary() {
        //dictionary =
        //return dictionary;
        return null;
    }
}
