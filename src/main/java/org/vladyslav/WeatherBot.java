package org.vladyslav;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.vladyslav.model.UserRequest;
import org.vladyslav.model.UserSession;
import org.vladyslav.service.UserSessionService;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class WeatherBot extends TelegramLongPollingBot {

    @Value("${bot.token}")
    private String botToken;

    @Value("${bot.username}")
    private String botUsername;

    private final Dispatcher dispatcher;
    private final UserSessionService userSessionService;
    private Map<Long, String> userInputMap = new HashMap<>();
//    StringBuilder userInput = new StringBuilder();




    public WeatherBot(Dispatcher dispatcher, UserSessionService userSessionService) {
        this.dispatcher = dispatcher;
        this.userSessionService = userSessionService;
    }

    /**
     * This is an entry point for any messages, or updates received from user<br>
     * Docs for "Update object: https://core.telegram.org/bots/api#update
     */
    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String textFromUser = update.getMessage().getText();

            Long userId = update.getMessage().getFrom().getId();
            String userFirstName = update.getMessage().getFrom().getFirstName();

            log.info("[{}, {}] : {}", userId, userFirstName, textFromUser);

            Long chatId = update.getMessage().getChatId();
            UserSession session = userSessionService.getSession(chatId);
            session.incrementStepCount();

            // Check if this is the third question
            boolean isThirdQuestion = session.getStepCount() % 5 == 0;

            // Check if all three questions have been asked
            boolean allQuestionsAsked = session.getStepCount() == 5;

            // If this is the third question, or all questions have been asked,
            // then clear the user input map
            if (isThirdQuestion || allQuestionsAsked) {
                userInputMap.remove(chatId);
            }

            String previousInput = userInputMap.getOrDefault(chatId, "");
            userInputMap.put(chatId, previousInput + textFromUser);
            String userInputs = userInputMap.get(chatId);


//            System.out.println(userInputs);

            UserRequest userRequest = UserRequest
                    .builder()
                    .update(update)
                    .userSession(session)
                    .chatId(chatId)
                    .build();

            boolean dispatched = dispatcher.dispatch(userRequest);

            if (!dispatched) {
                log.warn("Unexpected update from user");
            }
        } else {
            log.warn("Unexpected update from user");
        }
    }


    @Override
    public String getBotUsername() {
        // username which you give to your bot bia BotFather (without @)
        return "@weather_wwbot";
    }

    @Override
    public String getBotToken() {
        return "6095175191:AAFvyjQ013d4uqiv3gHVBFQaIvgbyCZ8JME";
    }
}