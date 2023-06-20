package com.example.apiproject.access;

import com.example.delombok.access.Gender;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.jetbrains.annotations.NotNull;

@Converter
public class GenderConverter implements AttributeConverter<com.example.delombok.access.Gender, Integer> {
    @Override
    public Integer convertToDatabaseColumn(@NotNull com.example.delombok.access.Gender g) {
        return g.code;
    }

    @Override
    public com.example.delombok.access.Gender convertToEntityAttribute(@NotNull Integer code) {
        return switch (code) {
            case 1 -> com.example.delombok.access.Gender.Male;
            case 2 -> com.example.delombok.access.Gender.Female;
            default -> Gender.Unknown;
        };
    }
}
