package backend;

import java.util.LinkedList;

/**
 * Created by Rene on 19.03.2016.
 */
public class NewsQueue{

    LinkedList<String> newsQueue = new LinkedList<>();
    private boolean available = false;

    synchronized public void addNews(String selectedItem, String text) {
        newsQueue.add(selectedItem + " -:- " + text);
        System.out.println(selectedItem + " -:- " + text);
        available = true;
        notifyAll();
    }

    synchronized public String getNews(){
        while (available == false) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        available = false;
        notifyAll();
        return newsQueue.remove();
    }

    public int newsCounter(){
        return newsQueue.size();
    }
}
