package com.example.video;

import java.nio.file.Path;
import java.util.Objects;

/**
 * Facade for video processing pipeline.
 * Coordinates the use of Decoder, FilterEngine, SharpenAdapter, and Encoder
 * to simplify video processing operations.
 */
public class VideoPipelineFacade {
    private final Decoder decoder;
    private final FilterEngine filterEngine;
    private final Encoder encoder;
    private final SharpenAdapter sharpenAdapter;

    /**
     * Create a new video pipeline facade with all required components
     */
    public VideoPipelineFacade(Decoder decoder, FilterEngine filterEngine,
                              Encoder encoder, SharpenAdapter sharpenAdapter) {
        this.decoder = Objects.requireNonNull(decoder, "decoder cannot be null");
        this.filterEngine = Objects.requireNonNull(filterEngine, "filterEngine cannot be null");
        this.encoder = Objects.requireNonNull(encoder, "encoder cannot be null");
        this.sharpenAdapter = Objects.requireNonNull(sharpenAdapter, "sharpenAdapter cannot be null");
    }

    /**
     * Process a video by applying optional filters and encoding it.
     *
     * @param src Path to source video file
     * @param out Path for output video file
     * @param gray Whether to apply grayscale filter
     * @param scale Optional scaling factor, null to skip scaling
     * @param sharpenStrength Optional sharpening strength, null to skip sharpening
     * @return Path to the processed output file
     */
    public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
        Objects.requireNonNull(src, "source path cannot be null");
        Objects.requireNonNull(out, "output path cannot be null");

        // Step 1: Decode the source video
        Frame[] frames = decoder.decode(src);

        // Step 2: Apply grayscale if requested
        if (gray) {
            frames = filterEngine.grayscale(frames);
        }

        // Step 3: Apply scaling if provided
        if (scale != null) {
            frames = filterEngine.scale(frames, scale);
        }

        // Step 4: Apply sharpening if strength provided
        if (sharpenStrength != null && sharpenStrength > 0) {
            frames = sharpenAdapter.sharpen(frames, sharpenStrength);
        }

        // Step 5: Encode and return output file path
        return encoder.encode(frames, out);
    }
}
