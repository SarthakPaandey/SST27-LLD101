package com.example.video;

import java.util.Arrays;
import java.util.Objects;

// adapter that bridges legacy handle-based sharpen api to frame arrays
public class SharpenAdapter {
    private final LegacySharpen legacy;

    // inject legacy dependency
    public SharpenAdapter(LegacySharpen legacy) {
        this.legacy = Objects.requireNonNull(legacy, "legacy");
    }

    // apply sharpen to frames using legacy handle round-trip
    public Frame[] apply(Frame[] frames, int strength) {
        Objects.requireNonNull(frames, "frames");
        String handle = toHandle(frames);
        String outHandle = legacy.applySharpen(handle, strength);
        return fromHandle(outHandle, frames);
    }

    // convert frames to a synthetic handle
    private String toHandle(Frame[] frames) {
        return "HANDLE:" + frames.length;
    }

    // convert back to frames (no-op for demo)
    private Frame[] fromHandle(String handle, Frame[] template) {
        return Arrays.copyOf(template, template.length);
    }
}


