package com.example.tutorial.domain.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.sql.Timestamp;

@Converter(autoApply = true)
public class LocalDateTimeConverter
        implements AttributeConverter<LocalDateTime, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime dateTime) {
        return dateTime == null ? null : Timestamp.valueOf(dateTime);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp value) {
        return value == null ? null : value.toLocalDateTime();
    }
}
