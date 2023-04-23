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
public class INeedHelpHandler extends UserRequestHandler {

    public static String I_NEED_WEATHER = "\uD83C\uDF24Дізнатись погоду";
    public static List<String> cities = List.of("Луцьк", "Усичі", "Київ");

    private final TelegramService telegramService;
    private final KeyboardHelper keyboardHelper;
    private final UserSessionService userSessionService;

    public INeedHelpHandler(TelegramService telegramService, KeyboardHelper keyboardHelper, UserSessionService userSessionService) {
        this.telegramService = telegramService;
        this.keyboardHelper = keyboardHelper;
        this.userSessionService = userSessionService;
    }

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        return isTextMessage(userRequest.getUpdate(), I_NEED_WEATHER);
    }

    @Override
    public void handle(UserRequest userRequest) {
        String city = userRequest.getUpdate().getMessage().getText();
        ReplyKeyboardMarkup replyKeyboardMarkup = keyboardHelper.buildCitiesMenu(cities);
        telegramService.sendMessage(userRequest.getChatId(),"Оберіть місто⤵️", replyKeyboardMarkup);

        UserSession userSession = userRequest.getUserSession();
        userSession.setState(ConversationState.WAITING_FOR_CITY);
        userSessionService.saveSession(userSession.getChatId(), userSession);

    }

    @Override
    public boolean isGlobal() {
        return true;
    }

}
