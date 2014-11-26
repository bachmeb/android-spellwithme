package us.proximal.spellwithme.controller.def;

import java.util.ArrayList;

import us.proximal.spellwithme.model.dto.WordDTO;

/**
 * Created by b on 11/26/14.
 */
public interface IWordsService {

    WordDTO getRandomWord();
    WordDTO getWordById(int wordId);
    WordDTO getWordByText(String text);
    WordDTO getWordByLength(int length);
    WordDTO getWordByType(String type);

    ArrayList<WordDTO> getDolchWords();
    ArrayList<WordDTO> getFryWords();


}
