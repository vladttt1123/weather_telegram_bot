//package org.vladyslav.handler.impl;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.vladyslav.enums.ConversationState;
//import org.vladyslav.handler.UserRequestHandler;
//import org.vladyslav.helper.KeyboardHelper;
//import org.vladyslav.model.UserRequest;
//import org.vladyslav.model.UserSession;
//import org.vladyslav.service.TelegramService;
//import org.vladyslav.service.UserSessionService;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.vladyslav.handler.impl.APIRequests.lutskTomorrow;
//
////import static org.vladyslav.handler.impl.APIRequests.lutskTomorrowMorning;
//
//@Slf4j
//@Component
//public class WeatherAnnounceHandler extends UserRequestHandler {
//
////    public static List<String> tests = List.of("Test1", "Test2", "Test3");
//
//    private final TelegramService telegramService;
//    private final KeyboardHelper keyboardHelper;
//    private final UserSessionService userSessionService;
//
//    private Map<Long, String> userInputMap = new HashMap<>();
//
//    public WeatherAnnounceHandler(TelegramService telegramService, KeyboardHelper keyboardHelper, UserSessionService userSessionService) {
//        this.telegramService = telegramService;
//        this.keyboardHelper = keyboardHelper;
//        this.userSessionService = userSessionService;
//    }
//
//
//    @Override
//    public boolean isApplicable(UserRequest userRequest) {
//        return isTextMessage(userRequest.getUpdate())
//                && ConversationState.WAITING_FOR_DAY_PERIOD.equals(userRequest.getUserSession().getState());
//
//    }
//    @Override
//    public void handle(UserRequest userRequest) {
//        String dayTime = userRequest.getUpdate().getMessage().getText();
//
//
////       ReplyKeyboardMarkup replyKeyboardMarkup = keyboardHelper.buildTest(tests);
////        telegramService.sendMessage(userRequest.getChatId(),"you reached the end, cognrats ⤵️");
//
//        UserSession userSession = userRequest.getUserSession();
//        System.out.println();
//        String city = userSession.getCity();
//        String dayPeriod = userSession.getDayPeriod();
//
//
//        String result = city + dayPeriod + dayTime;
//        if(result.contains("ЛуцькЗавтраРанок")){
//            telegramService.sendMessage(userRequest.getChatId(), lutskTomorrow());
//
//        }
//        else{
//            telegramService.sendMessage(userRequest.getChatId(),"ERRORRRRRRR");
//        }
//
//        userSession.setState(ConversationState.FINISHED);
//        userSessionService.saveSession(userSession.getChatId(), userSession);
//    }
//
//    @Override
//    public boolean isGlobal() {
//        return true;
//    }
//}
