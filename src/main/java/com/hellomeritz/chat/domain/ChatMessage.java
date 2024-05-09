package com.hellomeritz.chat.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Getter
@Document
public class ChatMessage {

    private static final int CONTENTS_MAX_LENGTH = 100;
    private static final int USER_ID_MIN_VALUE = 1;
    private static final int ROOM_ID_MIN_VALUE = 1;

    @Id
    private String id;
    private String contents;
    private Long userId;
    private Boolean isFC;
    private String messageType;
    private Long chatRoomId;
    private LocalDateTime createdAt;
    private Boolean readOrNot;

    private ChatMessage () {

    }

    private ChatMessage(
        String contents,
        String messageType,
        Long userId,
        Boolean isFC,
        Long chatRoomId,
        Boolean readOrNot
    ) {
        Assert.hasLength(messageType, "messageType은 필수값입니다.");
        Assert.hasLength(contents, "contents은 필수값입니다.");
        Assert.isTrue(contents.length() <= CONTENTS_MAX_LENGTH,
            String.format("contents는 %d의 자리수를 넘을 수 없습니다.", CONTENTS_MAX_LENGTH));
        Assert.isTrue(userId >= USER_ID_MIN_VALUE, "userId는 음수이거나 0일 수 없습니다.");
        Assert.isTrue(chatRoomId >= ROOM_ID_MIN_VALUE, "chatRoomId는 음수이거나 0일 수 없습니다.");
        Assert.notNull(readOrNot, "readOrNot은 null일 수 없습니다.");

        this.contents = contents;
        this.messageType = messageType;
        this.userId = userId;
        this.isFC = isFC;
        this.chatRoomId = chatRoomId;
        this.createdAt = LocalDateTime.now();
        this.readOrNot = readOrNot;
    }

    public static ChatMessage of(
        String contents,
        String messageType,
        Long userId,
        Boolean isFC,
        Long chatRoomId,
        Boolean readOrNot
    ) {
        return new ChatMessage(
            contents,
            messageType,
            userId,
            isFC,
            chatRoomId,
            readOrNot);
    }

}
