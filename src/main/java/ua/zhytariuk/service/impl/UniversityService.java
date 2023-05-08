package ua.zhytariuk.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.zhytariuk.common.MessagePrinter;
import ua.zhytariuk.exception.DepartmentNotExistException;
import ua.zhytariuk.exception.RequestNotExistException;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

import static ua.zhytariuk.common.QuestionInputsConstance.CLOSE_SYMBOL;

/**
 * @author (ozhytary)
 */
@Service
@RequiredArgsConstructor
public class UniversityService {

    private final MessagePrinter messagePrinter;
    private final MessageMatcher messageMatcher;
    private final UniversityQuestionFacade universityQuestionFacade;

    /**
     * @param scanner
     */
    public void startCommunication() {
        while (true) {
            final Scanner scanner = new Scanner(System.in);

            messagePrinter.printWelcomeMessage();

            try {
                final String request = scanner.nextLine();
                final var matcherPair = messageMatcher.converToPairIfMatch(request);
                final var response = universityQuestionFacade.getResponseByUserRequest(matcherPair);

                messagePrinter.printResponse(response);
            } catch (final NoSuchElementException ex) {
                System.out.println("Please input some request");
            } catch (final RequestNotExistException | DepartmentNotExistException ex) {
                System.out.println(ex.getMessage());
            }

            messagePrinter.printCloseMessage();

            final String closeMessage = scanner.next();

            if (Objects.equals(closeMessage, CLOSE_SYMBOL)) {
                messagePrinter.printGoodBye();
                break;
            }
        }
    }
}
