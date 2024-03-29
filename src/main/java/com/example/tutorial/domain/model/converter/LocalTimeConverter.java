package com.example.tutorial.domain.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Time;
import java.time.LocalTime;

@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, Time> {
    @Override
    public Time convertToDatabaseColumn(LocalTime time) {
        return time == null ? null : Time.valueOf(time);
    }

    @Override
    public LocalTime convertToEntityAttribute(Time value) {
        return value == null ? null : value.toLocalTime();
    }
}