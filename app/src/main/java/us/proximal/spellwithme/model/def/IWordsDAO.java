package us.proximal.spellwithme.model.def;

import us.proximal.spellwithme.model.dto.WordDTO;

/**
 * Created by b on 11/24/14.
 */
public interface IWordsDAO {

    public void create(WordDTO word);

    public WordDTO read(int wordId);

    public void update(WordDTO word);

    public void delete(WordDTO word);

    public WordDTO [] list();

    public WordDTO random();

}
