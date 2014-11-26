package us.proximal.spellwithme.model.dao;

import java.util.ArrayList;

import us.proximal.spellwithme.controller.WordServiceStub;
import us.proximal.spellwithme.model.dto.PersonDTO;
import us.proximal.spellwithme.model.dto.WordDTO;

/**
 * Created by b on 11/24/14.
 */
public class VocabularyDAO {
    ArrayList<WordDTO> words;
    PersonDTO speller;
    WordServiceStub service;

    public VocabularyDAO(PersonDTO person){
        service = new WordServiceStub();
        words = service.getVocabulary(person);

    }

}
