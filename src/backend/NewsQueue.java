package backend;

import java.util.LinkedList;

/**
 * Created by Rene on 19.03.2016.
 */
public class NewsQueue{

    LinkedList<String> newsQueue = new LinkedList<>();

    synchronized public void addNews(String selectedItem, String text) {
        newsQueue.add(selectedItem + " -:- " + text);
//        System.out.println(selectedItem + " -:- " + text);
    }

    synchronized public String getNews(){
        return newsQueue.remove();
    }

    public int newsCounter(){
        return newsQueue.size();
    }
}
