public class Sentence
{
    private String sentence = "";

    public void addWord(Word word) {
        sentence  = sentence + " " + word.getWord();
    }

    public String getSentence()
    {
        return sentence;
    }
}
