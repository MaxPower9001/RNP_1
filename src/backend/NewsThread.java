package backend;

import util.NewsCategory;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rene on 19.03.2016.
 */
public class NewsThread implements Runnable {

    private Thread t;
    private String threadName;
    private ThreadHandler parent;
    private boolean cancelled = false;
    private boolean paused = false;

    ArrayList<NewsCategory> categories = new ArrayList<>();
    Random rngesus = new Random();
    NewsCategory category;
    public NewsThread(String name){
        this.threadName = name;
        categories.add(NewsCategory.CORR);
        categories.add(NewsCategory.WARN);
        categories.add(NewsCategory.INFO);
    }
    @Override
    public void run() {
        while(!cancelled){
            while(paused){

            }
            try {
                Thread.sleep((rngesus.nextInt(5)+1)*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.category = categories.get(rngesus.nextInt(NewsCategory.values().length));

            parent.getNewsQueue().addNews(this.category.toString(),this.category.getNews(rngesus.nextInt(this.category.getNewsCounter())));
        }
    }

    public void start ()
    {
//        System.out.println("Starting " +  threadName );
        if (t == null)
        {
            t = new Thread (this, threadName);
            t.start();
        }
    }

    public void setParent(ThreadHandler threadHandler) {
        this.parent = threadHandler;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }
}
