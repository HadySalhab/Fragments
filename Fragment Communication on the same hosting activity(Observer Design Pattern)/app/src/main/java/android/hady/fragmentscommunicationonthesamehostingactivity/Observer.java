package android.hady.fragmentscommunicationonthesamehostingactivity;

public interface Observer {
     //since in this example the main activity will get notified
     //by multiple fragments, so its mandatory to know which is notifying

     void update(Subject sbj);  //pulling method
}
