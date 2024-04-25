package com.hellomeritz.member.global.encryption.dto;

public record PasswordMatchRequest(
        char[] inputPassword,
        String savedChatRoomPassword,
        String encodedSalt
) {
}
