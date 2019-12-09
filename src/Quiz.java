import java.util.Iterator;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Quiz {

    public static boolean askQuestion(ResourceBundle rb) {
        Scanner s = new Scanner(System.in);

        int q = new Random().nextInt(10);
        q++;

        System.out.println(rb.getString("q"+q));
        for(char i='a'; i<='d'; i++) {
            System.out.println(i+". "+rb.getString("a"+q+""+i));
        }
        String userAnswer = s.nextLine();
        String correctAnswer = rb.getString("q"+q+"a");
        if(userAnswer.equals(correctAnswer)) {
            System.out.println("Cool! The answer ist correct!");
        } else {
            System.out.println("Sorry! the answer is wrong!");
        }
        return userAnswer.equals(correctAnswer);
    }

    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("QuizNov");

        int correctAnswers=0;
        int totalAnwers=0;
        boolean askMore;
        Scanner s = new Scanner(System.in);

        do {
            boolean answer = askQuestion(rb);
            totalAnwers++;
            if(answer) correctAnswers++;
            System.out.println("Do you want to answer another question (y/n)?");
            askMore = "y".equals(s.nextLine());
        } while(askMore);

        System.out.println("You answered "+correctAnswers+" of "+totalAnwers+" questions correctly.");
/*        Iterator<String> iter = rb.getKeys().asIterator();
        while (iter.hasNext()) {
            String key = iter.next();
            String value = rb.getString(key);
            System.out.println("key: " + key + "; value: " + value);

            int q = new Random().nextInt(10);
            q++;
            System.out.println(q);
        }*/


    }
}



