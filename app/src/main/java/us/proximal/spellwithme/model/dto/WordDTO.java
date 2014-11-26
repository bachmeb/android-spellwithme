package us.proximal.spellwithme.model.dto;

/**
 * Created by b on 11/24/14.
 */
public class WordDTO {

    String letters[];
    int length;
    String begins;
    String ends;
    String word;
    private String category;

    /*
        Noun
        Verb
        Adjective
        Adverb
        Pronoun
        Preposition
        Conjunction
        Determiner
        Exclamation
    */

    private String language;
    private boolean dolch;
    private boolean fry;
    private boolean gensvc;
    private boolean swadesh;


    private boolean leipzig;
    private String vowel;


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

    public String getVowel() {
        return vowel;
    }

    public void setVowel(String vowel) {
        this.vowel = vowel;
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

    public String getBegins() {
        return begins;
    }

    public void setBegins(String begins) {
        this.begins = begins;
    }

    public String getEnds() {
        return ends;
    }

    public void setEnds(String ends) {
        this.ends = ends;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
