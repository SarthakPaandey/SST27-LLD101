package com.example.profiles;

import java.util.Objects;

public final class Validation {
    private Validation() {}

    public static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static void requireNonBlank(String val, String name) {
        if (isBlank(val)) throw new IllegalArgumentException(name + " must not be blank");
    }

    public static void requireEmail(String email) {
        Objects.requireNonNull(email, "email");
        if (!email.contains("@")) throw new IllegalArgumentException("invalid email");
    }

    public static void requireMaxLength(String val, String name, int maxLength) {
        if (val != null && val.length() > maxLength) {
            throw new IllegalArgumentException(name + " must not exceed " + maxLength + " characters");
        }
    }

    public static void requireValidId(String id) {
        requireNonBlank(id, "id");
        if (id.length() < 3) {
            throw new IllegalArgumentException("id must be at least 3 characters long");
        }
        if (!id.matches("^[a-zA-Z0-9_-]+$")) {
            throw new IllegalArgumentException("id must contain only alphanumeric characters, hyphens, and underscores");
        }
    }
}
