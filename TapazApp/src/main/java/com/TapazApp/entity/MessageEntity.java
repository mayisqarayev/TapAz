package com.TapazApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String messageText;
    Boolean messageStatus;

    String fkSenderUserId;
    String fkReceiverAccountId;

    public MessageEntity() {
    }

    public MessageEntity(String id, String messageText, Boolean messageStatus, String fkSenderUserId, String fkReceiverAccountId) {
        this.id = id;
        this.messageText = messageText;
        this.messageStatus = messageStatus;
        this.fkSenderUserId = fkSenderUserId;
        this.fkReceiverAccountId = fkReceiverAccountId;
    }
}
