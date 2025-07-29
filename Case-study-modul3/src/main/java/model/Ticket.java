package model;

import java.sql.Timestamp;
import java.util.Date;

public class Ticket {
    private int id;
    private int userId;
    private int movieId;
    private Date showDate;
    private Timestamp bookingTime;

    public Ticket() {}

    public Ticket(int userId, int movieId, Date showDate) {
        this.userId = userId;
        this.movieId = movieId;
        this.showDate = showDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public Timestamp getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Timestamp bookingTime) {
        this.bookingTime = bookingTime;
    }
}
