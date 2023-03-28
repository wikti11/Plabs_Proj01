public class Dictionary {

    private String language;
    private String[] words;

    public Dictionary(String[] words,String language) {
        this.words = words;
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }
}
