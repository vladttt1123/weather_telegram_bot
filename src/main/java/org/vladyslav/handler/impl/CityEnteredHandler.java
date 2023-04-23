package org.vladyslav.handler.impl;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.vladyslav.enums.ConversationState;
import org.vladyslav.handler.UserRequestHandler;
import org.vladyslav.helper.KeyboardHelper;
import org.vladyslav.model.UserRequest;
import org.vladyslav.model.UserSession;
import org.vladyslav.service.TelegramService;
import org.vladyslav.service.UserSessionService;

import java.util.List;

@Component
public class CityEnteredHandler extends UserRequestHandler {

    public static List<String> days = List.of("Сьогодні", "Завтра", "Післязавтра");

    private final TelegramService telegramService;
    private final KeyboardHelper keyboardHelper;
    private final UserSessionService userSessionService;

    public CityEnteredHandler(TelegramService telegramService, KeyboardHelper keyboardHelper, UserSessionService userSessionService) {
        this.telegramService = telegramService;
        this.keyboardHelper = keyboardHelper;
        this.userSessionService = userSessionService;
    }

    @Override
    public boolean isApplicable(UserRequest userRequest) {
//        return isTextMessage(userRequest.getUpdate())
//        && ConversationState.WAITING_FOR_TEXT.equals(userRequest.getUserSession().getState());
        return isTextMessage(userRequest.getUpdate())
                && ConversationState.WAITING_FOR_CITY.equals(userRequest.getUserSession().getState());
    }

    @Override
    public void handle(UserRequest userRequest) {
        String city = userRequest.getUpdate().getMessage().getText();

        ReplyKeyboardMarkup replyKeyboardMarkup = keyboardHelper.buildDaysMenu(days);

            telegramService.sendMessage(userRequest.getChatId(),
                    "✍️Погоду на який день ви б хотіли дізнатись ? ⤵️",
                    replyKeyboardMarkup);

        UserSession session = userRequest.getUserSession();
        session.setCity(city);
        session.setState(ConversationState.WAITING_FOR_DAY);
        userSessionService.saveSession(userRequest.getChatId(), session);
    }

    @Override
    public boolean isGlobal() {
        return true;
    }

}
