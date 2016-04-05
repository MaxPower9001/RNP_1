package backend;

import gui.Main;

import java.util.NoSuchElementException;

/**
 * Created by Rene on 03.04.2016.
 */
public class NewsGrabber extends Thread{
    private Main parent;
    private NewsQueue newsQueue;

    public NewsGrabber(Main parent, NewsQueue newsQueue) {
        this.newsQueue = newsQueue;
        this.parent = parent;
        System.out.println("Ich bin der News Grabber-Thread!");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                parent.setNews(newsQueue.getNews());
                parent.setNewsCounter("Füllstand: " + newsQueue.newsCounter());

            } catch (NoSuchElementException e) {
                // Wir wissen was wir tun.
            }
        }
    }
}
