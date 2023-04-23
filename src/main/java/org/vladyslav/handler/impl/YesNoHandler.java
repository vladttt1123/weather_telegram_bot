package org.vladyslav.handler.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.vladyslav.enums.ConversationState;
import org.vladyslav.handler.UserRequestHandler;
import org.vladyslav.helper.KeyboardHelper;
import org.vladyslav.model.UserRequest;
import org.vladyslav.model.UserSession;
import org.vladyslav.service.TelegramService;
import org.vladyslav.service.UserSessionService;

import static org.vladyslav.handler.impl.INeedHelpHandler.cities;

@Slf4j
@Component
public class YesNoHandler extends UserRequestHandler {

    private final TelegramService telegramService;
    private final KeyboardHelper keyboardHelper;
    private final UserSessionService userSessionService;

    public YesNoHandler(TelegramService telegramService, KeyboardHelper keyboardHelper, UserSessionService userSessionService) {
        this.telegramService = telegramService;
        this.keyboardHelper = keyboardHelper;
        this.userSessionService = userSessionService;
    }


    @Override
    public boolean isApplicable(UserRequest userRequest) {
        return isTextMessage(userRequest.getUpdate())
                && ConversationState.WAITING_YES_NO.equals(userRequest.getUserSession().getState());
    }

    @Override
    public void handle(UserRequest userRequest) {

        String answer = userRequest.getUpdate().getMessage().getText();
        UserSession userSession = userRequest.getUserSession();

        ReplyKeyboardMarkup replyKeyboardMarkup = keyboardHelper.buildCitiesMenu(cities);

        if(answer.contains("Ні")){
            telegramService.sendMessage(userRequest.getChatId(),
                    "☀️ Нехай проблеми та негоди не роблять вам в житті погоди! \uD83C\uDF3B"
                            +"Гарного дня, не переживайте через дрібниці і будьте здорові"
                            + "   \n    "+
                            "⌨️Вводьте /start щоб дзінатись погоду знову");
            userSession.setState(ConversationState.FINISHED);
            userSessionService.saveSession(userSession.getChatId(), userSession);
        }
        else if(answer.contains("Так")){
            telegramService.sendMessage(userRequest.getChatId(),
                    "Оберіть місто в якому ви б хотіли дізнатись погоду",replyKeyboardMarkup);
            userSession.setState(ConversationState.WAITING_FOR_CITY);
            userSessionService.saveSession(userSession.getChatId(), userSession);
        }
        else{telegramService.sendMessage(userRequest.getChatId(),"Error, Unexpexted Input");
        }

    }

    @Override
    public boolean isGlobal() {
        return false;
    }
}
