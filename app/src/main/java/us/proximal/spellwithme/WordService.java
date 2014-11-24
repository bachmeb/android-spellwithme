package us.proximal.spellwithme;

/**
 * Created by b on 11/24/14.
 */
public class WordService {
    IWordDAO dao;

    public WordService(){
        dao = new WordDAO();
    }

    public WordDTO getNewWord(){
        WordDTO word;

        word = dao.random();

        return word;
    }

    public WordDTO getNewWord(int level){
        WordDTO word;

        word = dao.random();

        return word;

    }
}
