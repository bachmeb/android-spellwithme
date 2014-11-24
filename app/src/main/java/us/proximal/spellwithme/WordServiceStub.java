package us.proximal.spellwithme;

import java.util.ArrayList;

/**
 * Created by b on 11/24/14.
 */
public class WordServiceStub {
    IWordDAO dao;

    WordDTO [] words;

    ArrayList<WordDTO> vocabulary;
    ArrayList<WordDTO> dictionary;


    public WordServiceStub(){

        dao = new WordDAO();
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
