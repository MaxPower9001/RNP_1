package backend;

import util.NewsCategory;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rene on 19.03.2016.
 */
public class NewsThread extends Thread {

    private boolean cancelled = false;
    private boolean paused = false;

    private Integer number;

    ArrayList<NewsCategory> categories = new ArrayList<>();
    Random rngesus = new Random();
    NewsCategory category;
    NewsQueue newsQueue;

    public NewsThread(NewsQueue newsQueue,Integer number){
        this.number = number;
        this.newsQueue = newsQueue;

        categories.add(NewsCategory.CORR);
        categories.add(NewsCategory.WARN);
        categories.add(NewsCategory.INFO);

        System.out.println("Ich bin ein neuer Thread und meine Nummer ist: " + number);
    }
    @Override
    public void run() {
        while(!cancelled && !paused){
            try{
                sleep((rngesus.nextInt(5)+1)*1000);
            } catch (InterruptedException e){

            }

            this.category = categories.get(rngesus.nextInt(NewsCategory.values().length));

            newsQueue.addNews(this.category.toString(),this.category.getNews(rngesus.nextInt(this.category.getNewsCounter())));
        }
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }
}
