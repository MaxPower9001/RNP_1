package backend;

import java.util.ArrayList;

/**
 * Created by Rene on 19.03.2016.
 */
public class ThreadHandler{
    ArrayList<NewsThread> newsThreads = new ArrayList<>();

    public NewsQueue getNewsQueue() {
        return newsQueue;
    }

    private NewsQueue newsQueue;

    public ThreadHandler(int threadCounter, NewsQueue newsQueue) {

        this.newsQueue = newsQueue;
        //
        for (int i = 0; i < threadCounter; i++) {
            newsThreads.add(new NewsThread("Thread " + i+1));
            newsThreads.get(i).start();
        }
        for (NewsThread nt:newsThreads) {
            nt.setParent(this);
        }
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
