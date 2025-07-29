package model;

import java.time.LocalDate;

public class Movie {
    private int id;
    private String title;
    private String genre;
    private int duration;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public Movie(int id, String title, String genre, int duration, String description, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Movie(String title, String genre, int duration, String description, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
