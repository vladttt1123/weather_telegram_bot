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

import java.util.List;

import static org.vladyslav.handler.impl.APIRequests.*;

@Slf4j
@Component
public class DayChosenHandler extends UserRequestHandler {
    String anythingElse = "\uD83D\uDE0E Я можу вам ще якось допомогти?";

    public static List<String> yesNo = List.of("Так", "Ні");


    private final TelegramService telegramService;
    private final KeyboardHelper keyboardHelper;
    private final UserSessionService userSessionService;

    public DayChosenHandler(TelegramService telegramService, KeyboardHelper keyboardHelper, UserSessionService userSessionService) {
        this.telegramService = telegramService;
        this.keyboardHelper = keyboardHelper;
        this.userSessionService = userSessionService;
    }

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        return isTextMessage(userRequest.getUpdate())
                && ConversationState.WAITING_FOR_DAY.equals(userRequest.getUserSession().getState());
//        return isTextMessage(userRequest.getUpdate())
//                && ConversationState.WAITING_FOR_DAY_PERIOD.equals(userRequest.getUserSession().getState());
    }

    @Override
    public void handle(UserRequest userRequest) {
        String dayPeriod = userRequest.getUpdate().getMessage().getText();

        UserSession userSession = userRequest.getUserSession();
        String city = userSession.getCity();

        ReplyKeyboardMarkup replyKeyboardMarkup = keyboardHelper.buildYesNoMenu(yesNo);

        String result = city + dayPeriod;
        if(result.contains("ЛуцькЗавтра")){
            telegramService.sendMessage(userRequest.getChatId(), lutskTomorrow());
            telegramService.sendMessage(userRequest.getChatId(),anythingElse, replyKeyboardMarkup);
        }
        else if(result.contains("ЛуцькПіслязавтра")){
            telegramService.sendMessage(userRequest.getChatId(), lutskAfterTomorrow());
            telegramService.sendMessage(userRequest.getChatId(),anythingElse, replyKeyboardMarkup);
        }
        else if(result.contains("ЛуцькСьогодні")){
            telegramService.sendMessage(userRequest.getChatId(), lutskToday());
            telegramService.sendMessage(userRequest.getChatId(),anythingElse, replyKeyboardMarkup);
        }
        else if(result.contains("УсичіСьогодні")){
            telegramService.sendMessage(userRequest.getChatId(), usychiToday());
            telegramService.sendMessage(userRequest.getChatId(),anythingElse,replyKeyboardMarkup);
        }
        else if(result.contains("УсичіЗавтра")){
            telegramService.sendMessage(userRequest.getChatId(), usychiTomorrow());
            telegramService.sendMessage(userRequest.getChatId(),anythingElse, replyKeyboardMarkup);
        }
        else if(result.contains("УсичіПіслязавтра")){
            telegramService.sendMessage(userRequest.getChatId(), usychiAfterTomorrow());
            telegramService.sendMessage(userRequest.getChatId(),anythingElse, replyKeyboardMarkup);
        }
        else if(result.contains("КиївСьогодні")){
            telegramService.sendMessage(userRequest.getChatId(), kyivToday());
            telegramService.sendMessage(userRequest.getChatId(),anythingElse,replyKeyboardMarkup);
        }
        else if(result.contains("КиївЗавтра")){
            telegramService.sendMessage(userRequest.getChatId(), kyivTomorrow());
            telegramService.sendMessage(userRequest.getChatId(),anythingElse, replyKeyboardMarkup);
        }
        else if(result.contains("КиївПіслязавтра")){
            telegramService.sendMessage(userRequest.getChatId(), kyivAfterTomorrow());
            telegramService.sendMessage(userRequest.getChatId(),anythingElse,replyKeyboardMarkup);
        }
        else{
            telegramService.sendMessage(userRequest.getChatId(),"!!!ERROR Unexpected Input!!!");
        }

        userSession.setState(ConversationState.WAITING_YES_NO);
        userSessionService.saveSession(userSession.getChatId(), userSession);
    }

    @Override
    public boolean isGlobal() {
        return true;
    }
}
