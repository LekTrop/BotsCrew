package ua.zhytariuk.common;

import org.springframework.stereotype.Component;
import ua.zhytariuk.models.response.UniversityResponse;

import static ua.zhytariuk.common.QuestionInputsConstance.CLOSE_SYMBOL;
import static ua.zhytariuk.common.QuestionInputsConstance.CONTINUE_SYMBOL;

/**
 * @author (ozhytary)
 */
@Component
public class MessagePrinter {
    public void printWelcomeMessage() {
        System.out.println("Hello it`s university CLI, what you want to know?");
    }

    public void printCloseMessage() {
        System.out.printf("If you want continue enter %s or if you want close console enter %s%n", CONTINUE_SYMBOL, CLOSE_SYMBOL);
    }

    public void printResponse(final UniversityResponse response) {
        System.out.println(response.toString());
    }

    public void printGoodBye() {
        System.out.println("Good bye");
    }
}
