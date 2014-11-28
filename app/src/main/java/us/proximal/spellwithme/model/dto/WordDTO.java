package us.proximal.spellwithme.model.dto;

/**
 * Created by b on 11/24/14.
 */
public class WordDTO {

    int wordId;
    String word;
    String letters[];
    int length;
    String beginsWith;
    String endsWith;
    private String category; /* Noun, Verb, Adjective, Adverb, Pronoun, Preposition, Conjunction, Determiner, Exclamation */
    private String language; /* English */
    private boolean dolch;
    private boolean fry;
    private boolean gensvc;
    private boolean swadesh;
    private boolean leipzig;
    private String vowelSound;


    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isDolch() {
        return dolch;
    }

    public void setDolch(boolean dolch) {
        this.dolch = dolch;
    }

    public boolean isFry() {
        return fry;
    }

    public void setFry(boolean fry) {
        this.fry = fry;
    }

    public boolean isGensvc() {
        return gensvc;
    }

    public void setGensvc(boolean gensvc) {
        this.gensvc = gensvc;
    }

    public boolean isSwadesh() {
        return swadesh;
    }

    public void setSwadesh(boolean swadesh) {
        this.swadesh = swadesh;
    }

    public boolean isLeipzig() {
        return leipzig;
    }

    public void setLeipzig(boolean leipzig) {
        this.leipzig = leipzig;
    }

    public String getVowelSound() {
        return vowelSound;
    }

    public void setVowelSound(String vowelSound) {
        this.vowelSound = vowelSound;
    }

    public String[] getLetters() {
        return letters;
    }

    public void setLetters(String[] letters) {
        this.letters = letters;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getBeginsWith() {
        return beginsWith;
    }

    public void setBeginsWith(String beginsWith) {
        this.beginsWith = beginsWith;
    }

    public String getEndsWith() {
        return endsWith;
    }

    public void setEndsWith(String endsWith) {
        this.endsWith = endsWith;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
