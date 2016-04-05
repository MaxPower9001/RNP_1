package backend;

import gui.Main;

import java.util.ArrayList;

/**
 * Created by Rene on 19.03.2016.
 */
public class ThreadHandler{
    ArrayList<NewsThread> newsThreads;
    Thread newsGrabber;


    public ThreadHandler(int threadCounter, NewsQueue newsQueue, Main parent) {
        newsGrabber = new NewsGrabber(parent,newsQueue);
        newsThreads = new ArrayList<>();

        for (int i = 0; i < threadCounter; i++) {
            newsThreads.add(new NewsThread(newsQueue,i+1));
            newsThreads.get(i).start();
        }
        newsGrabber.start();
    }

    public void sleepTheThreadsPlz(){
        for (NewsThread nt : newsThreads){
            nt.setPaused(true);
        }
    }

    public void wakeTheThreadsUpPlz() {
        for (NewsThread nt : newsThreads){
            nt.setPaused(false);
        }
    }
}
