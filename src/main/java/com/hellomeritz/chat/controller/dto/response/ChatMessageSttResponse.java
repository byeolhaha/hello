package com.hellomeritz.chat.controller.dto.response;

import com.hellomeritz.chat.service.dto.result.ChatMessageSttResult;

public record ChatMessageSttResponse(
    String textBySpeech,
    String createdAt,
    String sttProvider
) {
    public static ChatMessageSttResponse to(ChatMessageSttResult result) {
        return new ChatMessageSttResponse(
            result.textBySpeech(),
            result.createdAt(),
            result.sttProvider()
        );
    }
}
