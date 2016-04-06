package backend;

import gui.Main;

import java.util.ArrayList;

/**
 * Created by Rene on 19.03.2016.
 */
public class ThreadHandler{
    ArrayList<NewsThread> newsThreads;
    NewsGrabber newsGrabber;


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
        if(!newsThreads.isEmpty()){
            for (NewsThread nt : newsThreads){
                nt.setRunning(false);
            }
        }
    }

    public void wakeTheThreadsUpPlz() {
        if(!newsThreads.isEmpty()){
            for (NewsThread nt : newsThreads){
                nt.setRunning(true);
                nt.run();
            }
        }
    }
    public void stopThreads() {
        if(!newsThreads.isEmpty()){
            wakeTheThreadsUpPlz();
            newsGrabber.setRunning(false);
            for(NewsThread nt : newsThreads){
                nt.setRunning(false);
            }
        }
    }
}
