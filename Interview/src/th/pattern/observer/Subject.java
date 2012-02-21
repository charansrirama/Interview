package th.pattern.observer;
/**
 * shijinliang
 * Feb 21, 2012
 * Interview
 **/
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
