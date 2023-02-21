package com.web.util;

public record RequestParameter(String field, String value) {

    public RequestParameter {
        if (isFieldNotValid(field)) {
            throw new IllegalArgumentException(
                "Field must contain only lowercase characters and digits"
            );
        }
    }

    private boolean isFieldNotValid(String field) {
        return !field.matches("[a-z0-9]+");
    }
}
