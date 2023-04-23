package org.vladyslav.model;

import lombok.Builder;
import lombok.Data;
import org.vladyslav.enums.ConversationState;

@Data
@Builder
public class UserSession {
    private Long chatId;
    private ConversationState state;
    private String city;
    private String dayPeriod;
    private String dayTime;
    private String answer;
    private String text;
    private int stepCount;

    public int getStepCount() {
        return stepCount;
    }

    public void incrementStepCount() {
        stepCount++;
    }
}
