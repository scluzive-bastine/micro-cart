package com.pm.analyticsservice.kafka;

import client.events.ClientEvent;
import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics="client", groupId = "analytics-service")
    public void ConsumeEvent(byte[] event) {
        try {
            ClientEvent clientEvent = ClientEvent.parseFrom(event);

            // ... perform any analytics here
            log.info("Received Client Event: [ClientId={}, ClientName={}, " + "ClientEmail={} ]",
                    clientEvent.getClientId(),
                    clientEvent.getName(),
                    clientEvent.getEmail());
        } catch (InvalidProtocolBufferException e) {
            log.error("Error deserializing event {}", e.getMessage());
        }

    }
}
