package us.proximal.spellwithme;

import java.util.ArrayList;

/**
 * Created by b on 11/24/14.
 */
public class Vocabulary {
    ArrayList<WordDTO> words;
    PersonDTO speller;
    WordServiceStub service;

    public Vocabulary(PersonDTO person){
        service = new WordServiceStub();
        words = service.getVocabulary(person);

    }

}
