package us.proximal.spellwithme.model.dao;

import java.util.ArrayList;

import us.proximal.spellwithme.controller.test.TWordsService;
import us.proximal.spellwithme.model.dto.PersonDTO;
import us.proximal.spellwithme.model.dto.WordDTO;

/**
 * Created by b on 11/24/14.
 */
public class VocabularyDAO {
    ArrayList<WordDTO> words;
    PersonDTO speller;
    TWordsService service;

    public VocabularyDAO(PersonDTO person){
        service = new TWordsService();
        //words = service.getVocabulary(person);

    }

}
