package com.example.tutorial.domain.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.sql.Date;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {
    @Override
    public Date convertToDatabaseColumn(LocalDate date) {
        return date == null ? null : Date.valueOf(date);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date value) {
        return value == null ? null : value.toLocalDate();
    }
}