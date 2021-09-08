package com.example.F1.Api.RaceDetails;



import org.apache.tomcat.jni.Time;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.Period;
import java.util.Date;

@Entity
@Table
public class Race {

    @Id
    @SequenceGenerator(
            name = "race_sequence",
            sequenceName = "race_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "race_sequence"
    )
    private Long id;
    private String firstRace;
    private String countryName;
    //@Transient set here but not in constructor , you return in get method
    @Transient
    private LocalTime time;

    public Race(Long id, String firstRace, String countryName) {
        this.id = id;
        this.firstRace = firstRace;
        this.countryName = countryName;
    }

    public Race(String firstRace, String countryName) {
        this.firstRace = firstRace;
        this.countryName = countryName;
    }

    public Race() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstRace() {
        return firstRace;
    }

    public void setFirstRace(String firstRace) {
        this.firstRace = firstRace;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public LocalTime getDate() {
        return LocalTime.now();
    }



    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", firstRace='" + firstRace + '\'' +
                ", countryName='" + countryName + '\'' +
                time +

                '}';
    }
}
