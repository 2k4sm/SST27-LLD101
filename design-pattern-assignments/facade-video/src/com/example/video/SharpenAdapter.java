package com.example.video;

import java.util.Objects;

public class SharpenAdapter {
    private final LegacySharpen legacySharpen;

    public SharpenAdapter(LegacySharpen legacySharpen) {
        this.legacySharpen = Objects.requireNonNull(legacySharpen, "legacySharpen cannot be null");
    }

    public Frame[] sharpen(Frame[] frames, int strength) {
        Objects.requireNonNull(frames, "frames cannot be null");
        if (strength <= 0) {
            return frames;
        }

        String framesHandle = convertFramesToHandle(frames);
   
        String resultHandle = legacySharpen.applySharpen(framesHandle, strength);

        return convertHandleToFrames(resultHandle, frames);
    }

    private String convertFramesToHandle(Frame[] frames) {
        return "HANDLE:" + frames.length;
    }

    private Frame[] convertHandleToFrames(String handle, Frame[] originalFrames) {
        return originalFrames;
    }
}
