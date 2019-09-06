package android.hady.fragmentscommunicationonthesamehostingactivity;

public interface Observer {
     //since in this example the main activity will get notified
     //by multiple fragments, so its mandatory to know which is notifying
     void getNotified(Subject sbj,String msg);
}
