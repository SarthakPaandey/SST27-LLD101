public class FrameDecoder implements Framer {
    @Override
    public Frame decode(byte[] fileBytes) {
        return new Frame(fileBytes);
    }
}
