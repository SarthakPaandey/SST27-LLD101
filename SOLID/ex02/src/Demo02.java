public class Demo02 {
    public static void main(String[] args) {    
        Framer framer = new FrameDecoder();
        UIdrawer ui = new DrawUI();
        Cacher cache = new StoreCache();
        new Player(framer, ui, cache).play(new byte[]{1,2,3,4});
    }
}
