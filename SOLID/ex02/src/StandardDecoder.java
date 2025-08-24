public class StandardDecoder implements Decoder {
    @Override
    public Frame decode(byte[] fileBytes) {
        // pretend decoding
        return new Frame(fileBytes);
    }
}
