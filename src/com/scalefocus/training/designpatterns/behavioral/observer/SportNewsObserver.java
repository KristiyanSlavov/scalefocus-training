package com.scalefocus.training.designpatterns.behavioral.observer;

/**
 * Concrete implementation of Observer.
 * It contains footballNews and tennisNews properties also like SportNews class.
 * Also it wraps a sportNews reference and provides:
 * update method - updates football news and tennis news
 * + getters of the footballNews and tennisNews
 *
 * @author Kristiyan SLavov
 */
public class SportNewsObserver implements Observer {

    private String footballNews;

    private String tennisNews;

    private SportNews sportNews;

    private static int observerIDTracker = 0;

    private int observerID;

    public SportNewsObserver(SportNews sportNews) {
        this.observerID = ++observerIDTracker;
        this.sportNews = sportNews;
        this.sportNews.register(this);
    }

    /**
     * Concrete implementation of update method that updates the footballNews and the tennisNews.
     */
    @Override
    public void update() {
        if (sportNews.getFootballNews() != null && !sportNews.getFootballNews().equals(footballNews)) {
            footballNews = sportNews.getFootballNews();
            System.out.println("Football news: " + footballNews + " for observer: " + observerID);
        }
        if (sportNews.getTennisNews() != null && !sportNews.getTennisNews().equals(tennisNews)) {
            tennisNews = sportNews.getTennisNews();
            System.out.println("Tennis news: " + tennisNews + " for observer: " + observerID);
        }
    }

    /**
     * This method returns the footballNews.
     *
     * @return - the footballNews
     */
    public String getFootballNews() {
        return footballNews;
    }

    /**
     * This method returns the tennisNews.
     *
     * @return - the tennisNews
     */
    public String getTennisNews() {
        return tennisNews;
    }
}
