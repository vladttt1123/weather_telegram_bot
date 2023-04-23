package org.vladyslav.handler.impl;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.vladyslav.handler.UserRequestHandler;
import org.vladyslav.helper.KeyboardHelper;
import org.vladyslav.model.UserRequest;
import org.vladyslav.model.UserSession;
import org.vladyslav.service.TelegramService;

@Component
public class StartCommandHandler extends UserRequestHandler {

    private static String command = "/start";

    private final TelegramService telegramService;
    private final KeyboardHelper keyboardHelper;

    public StartCommandHandler(TelegramService telegramService, KeyboardHelper keyboardHelper) {
        this.telegramService = telegramService;
        this.keyboardHelper = keyboardHelper;
    }

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        return isCommand(userRequest.getUpdate(), command);
    }

    @Override
    public void handle(UserRequest request) {
//        UserSession userSession = request.getUserSession();
//        if(userSession == null){
//            telegramService.sendMessage(request.getChatId(), "Вводь /start");
//        }
//
        ReplyKeyboard replyKeyboard = keyboardHelper.buildMainMenu();

        telegramService.sendMessage(request.getChatId(),
                "\uD83D\uDC4BВітаю Тетяна Петрівна! За допомогою цього чат-бота ви зможете дізнатись погоду!",
                replyKeyboard);
        telegramService.sendMessage(request.getChatId(),
                "Обирайте з меню нижче ⤵️");
    }

    @Override
    public boolean isGlobal() {
        return true;
    }
}
