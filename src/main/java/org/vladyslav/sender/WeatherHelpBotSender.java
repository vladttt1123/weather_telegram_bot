package org.vladyslav.sender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Slf4j
@Component
public class WeatherHelpBotSender extends DefaultAbsSender {

//    @Value("${bot.token}")
//    private String botToken;

    protected WeatherHelpBotSender() {
        super(new DefaultBotOptions());
    }

    @Override
    public String getBotToken() {
        return "6095175191:AAFvyjQ013d4uqiv3gHVBFQaIvgbyCZ8JME";
    }
}