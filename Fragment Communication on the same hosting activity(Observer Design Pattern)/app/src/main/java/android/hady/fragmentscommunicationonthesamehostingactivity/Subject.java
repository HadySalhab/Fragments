package android.hady.fragmentscommunicationonthesamehostingactivity;

public interface Subject {
     void registerObserver(Observer obj);
     void unregisterObserver(Observer obj);
     void notifyObservers();
}
