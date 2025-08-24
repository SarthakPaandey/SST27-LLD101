public class Player {
    private Framer framer;
    private UIdrawer ui;
    private Cacher cache;

    public Player(Framer framer, UIdrawer ui, Cacher cache) {
        this.framer = framer;
        this.ui = ui;
        this.cache = cache;
    }
    
    void play(byte[] fileBytes){
        Frame f = framer.decode(fileBytes);
        cache.cache(f);
        ui.draw(f);
    }
}