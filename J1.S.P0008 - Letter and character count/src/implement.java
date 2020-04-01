import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class implement {

    private final Map<Character, Integer> charCount
            = new HashMap<Character, Integer>();

    private final Map<String, Integer> wordCount
            = new HashMap<String, Integer>();

    public void analyze(String content) {
        for (char ch : content.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                continue;
            }
            if (!charCount.containsKey(ch)) {
                charCount.put(ch, 1);
            } else {
                charCount.put(ch, ((int) charCount.get(ch)) + 1);
            }
        }
        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordCount.containsKey(token)) {
                wordCount.put(token, 1);
            } else {
                wordCount.put(token, ((int) wordCount.get(token)) + 1);
            }
        }
    }

    public void display() {
        System.out.println(wordCount);
        System.out.println(charCount);
        //total words but not duplex
        System.out.println("Total words: " + wordCount.size());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        implement implement = new implement();
        
        System.out.println("Enter your content: ");
        String content = scanner.nextLine();
        
        implement.analyze(content);
        implement.display();
    }

}
