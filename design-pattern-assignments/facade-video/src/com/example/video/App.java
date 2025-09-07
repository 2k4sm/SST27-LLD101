package com.example.video;

import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        Decoder decoder = new Decoder();
        FilterEngine filterEngine = new FilterEngine();
        Encoder encoder = new Encoder();
        SharpenAdapter sharpenAdapter = new SharpenAdapter(new LegacySharpen());

        VideoPipelineFacade facade = new VideoPipelineFacade(
                decoder, filterEngine, encoder, sharpenAdapter);

        Path out = facade.process(
                Path.of("in.mp4"),
                Path.of("out.mp4"),
                true,
                0.5,
                5);

        System.out.println("Wrote " + out);
    }
}
