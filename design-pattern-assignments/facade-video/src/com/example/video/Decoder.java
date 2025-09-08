package com.example.video;
import java.nio.file.Path;

// subsystem that decodes source into frames
public class Decoder {
    public Frame[] decode(Path src) { 
        return new Frame[] { new Frame(1920,1080), new Frame(1920,1080) }; 
    }
}
