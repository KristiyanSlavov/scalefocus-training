package com.scalefocus.training.designpatterns.behavioral.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * This class is a concrete implementation of Subject.
 * It contains footballNews, tennisNews properties and list of Observers
 * and also provides:
 * register method - adds new observer to the list
 * unregister method - delete an observer from the list
 * notifyObservers method - update all of the observers
 * +getters/setters of the fields.
 *
 * @author Kristiyan SLavov
 */
public class SportNews implements Subject {

    private String footballNews;

    private String tennisNews;

    private List<Observer> observers;

    public SportNews() {
        observers = new LinkedList<>();
    }

    /**
     * Concrete implementation of the register method that adds a new observer to the list of observers.
     *
     * @param newObserver - the new observer to be added
     */
    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    /**
     * Concrete implementation of the unregister method that removes observer from the list of observers.
     *
     * @param observer - the observer to be removed
     */
    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Concrete implementation of the notifyObservers method that updates all of the observers.
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * This method sets the football news.
     *
     * @param footballNews - the new football news
     */
    public void setFootballNews(String footballNews) {
        this.footballNews = footballNews;
        notifyObservers();
    }

    /**
     * This method sets the tennis news.
     *
     * @param tennisNews - the new tennis news
     */
    public void setTennisNews(String tennisNews) {
        this.tennisNews = tennisNews;
        notifyObservers();
    }

    /**
     * This method returns the football news.
     *
     * @return - the football news
     */
    protected String getFootballNews() {
        return footballNews;
    }

    /**
     * This method returns the tennis news.
     *
     * @return - the tennis news
     */
    protected String getTennisNews() {
        return tennisNews;
    }
}
