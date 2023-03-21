package movies.bean;

import java.util.Date;

public class Movie {
    private String id;
    private String name;
    private String actor;
    private Double score;
    private Double time;
    private Double price;
    private Integer number;
    private Date start_time;

    public Movie() {
    }

    public Movie(String id, String name, String actor, Double score, Double time, Double price, Integer number, Date start_time) {
        this.id = id;
        this.name = name;
        this.actor = actor;
        this.score = score;
        this.time = time;
        this.price = price;
        this.number = number;
        this.start_time = start_time;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", actor='" + actor + '\'' +
                ", score=" + score +
                ", time=" + time +
                ", price=" + price +
                ", number=" + number +
                ", start_time=" + start_time +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }
}
