package com.example.video;

import java.nio.file.Path;
import java.util.Objects;

public class VideoPipelineFacade {
    private final Decoder decoder;
    private final FilterEngine filters;
    private final Encoder encoder;
    private final SharpenAdapter sharpen;

    public VideoPipelineFacade(Decoder decoder, FilterEngine filters, Encoder encoder, SharpenAdapter sharpen) {
        this.decoder = Objects.requireNonNull(decoder, "decoder");
        this.filters = Objects.requireNonNull(filters, "filters");
        this.encoder = Objects.requireNonNull(encoder, "encoder");
        this.sharpen = Objects.requireNonNull(sharpen, "sharpen");
    }

    public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
        Objects.requireNonNull(src, "src");
        Objects.requireNonNull(out, "out");
        Frame[] frames = decoder.decode(src);
        if (gray) frames = filters.grayscale(frames);
        if (scale != null) frames = filters.scale(frames, scale.doubleValue());
        if (sharpenStrength != null) frames = sharpen.apply(frames, sharpenStrength.intValue());
        return encoder.encode(frames, out);
    }
}


