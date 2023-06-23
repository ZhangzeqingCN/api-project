package com.example.apiproject.access;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.jetbrains.annotations.NotNull;

@Converter
public class GenderConverter implements AttributeConverter<com.example.apiproject.access.Gender, Integer> {
    @Override
    public Integer convertToDatabaseColumn(@NotNull com.example.apiproject.access.Gender g) {
        return g.getCode();
    }

    @Override
    public com.example.apiproject.access.Gender convertToEntityAttribute(@NotNull Integer code) {
        return switch (code) {
            case 1 -> com.example.apiproject.access.Gender.Male;
            case 2 -> com.example.apiproject.access.Gender.Female;
            default -> Gender.Unknown;
        };
    }
}
