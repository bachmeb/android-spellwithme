package us.proximal.spellwithme;

/**
 * Created by b on 11/24/14.
 */
public interface IWordDAO {

    public void create(WordDTO word);

    public WordDTO read(int wordId);

    public void update(WordDTO word);

    public void delete(WordDTO word);

    public WordDTO [] list();

    public WordDTO random();

}
