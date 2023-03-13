import java.util.ArrayList;
import java.util.Locale;

public class VigenereCipher{
    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String key;

    public VigenereCipher(String key){
        this.key = key.toLowerCase(Locale.ROOT);
    }

    public String cyclicKey(String word, String key){
        int x = word.length();
        int i = 0;

        while(i < x){
            if(x == i){
                i = 0;
            }
            if(x == key.length()){
                break;
            }
            key += key.charAt(i);
            i++;
        }

        return key;
    }

    public String encode(String word){
        int x;
        word = word.toLowerCase();
        String newKey = cyclicKey(word, key);
        String encodedMessage = "";

        for(int i = 0; i < word.length(); i++){
            if(alphabet.contains(String.valueOf(word.charAt(i)))){
                x = (alphabet.indexOf(word.charAt(i)) + alphabet.indexOf(newKey.charAt(i))) % 26;
                encodedMessage = encodedMessage + alphabet.charAt(x);
            }
            else{
                encodedMessage = encodedMessage + word.charAt(i);
            }
        }

        return encodedMessage.toLowerCase();
    }

    public String decode(String word){
        int x;
        word = word.toLowerCase();
        String newKey = cyclicKey(word, key);
        String decodedMessage = "";

        for(int i = 0; i < word.length(); i++){
            if(alphabet.contains(String.valueOf(word.charAt(i)))){
                x = (alphabet.indexOf(word.charAt(i)) - alphabet.indexOf(newKey.charAt(i))) + 26;
                decodedMessage = decodedMessage + alphabet.charAt(x);
            }
            else{
                decodedMessage = decodedMessage + word.charAt(i);
            }
        }

        return decodedMessage.toLowerCase();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }
}
