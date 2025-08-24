public class StoreCache implements Cacher {
    private Frame last;
    
    @Override
    public void cache(Frame frame) {
        this.last = frame;
        System.out.println("Cached last frame? " + (last!=null));
    }
}