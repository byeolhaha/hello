package com.hellomeritz.chat.repository.chatroom;

import com.hellomeritz.chat.domain.ChatRoom;
import com.hellomeritz.chat.repository.chatroom.dto.ChatRoomPasswordInfo;
import com.hellomeritz.chat.repository.chatroom.dto.ChatRoomUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ChatRoomJpaRepository extends JpaRepository<ChatRoom, Long> {

    Optional<ChatRoom> findChatRoomByFcIdAndUserId(long fcId, long userId);


    @Query("select cr.userId as userId , cr.fcId as fcId from ChatRoom as cr where cr.chatRoomId =:chatRoomId")
    Optional<ChatRoomUserInfo> findChatRoomUserInfo(@Param(value = "chatRoomId") Long chatRoomId);

    @Query("select cr.chatRoomPassword as chatRoomPassword , cr.salt as salt from ChatRoom as cr where cr.chatRoomId =:chatRoomId")
    Optional<ChatRoomPasswordInfo> findChatRoomEnterInfo(@Param(value = "chatRoomId") Long chatRoomId);

}
