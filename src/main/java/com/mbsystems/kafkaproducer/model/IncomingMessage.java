package com.mbsystems.kafkaproducer.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
public class IncomingMessage {

    private final String topic;
    private final String key;
    private final String value;
}
