package com.udl.nemeum.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trainer_event")
public class TrainerEventBO {

    private Integer idTrainerEvent;
    private TrainerUserBO trainerEvent;
    private EventBO event;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
    private Date dateBooking;

    public TrainerEventBO(Integer idTrainerEvent, TrainerUserBO trainerEvent, EventBO event, Date dateBooking) {
        this.idTrainerEvent = idTrainerEvent;
        this.trainerEvent = trainerEvent;
        this.event = event;
        this.dateBooking = dateBooking;
    }

    @Id
    @Column(name = "id_trainer_event")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdTrainerEvent() {
        return idTrainerEvent;
    }

    public void setIdTrainerEvent(Integer idTrainerEvent) {
        this.idTrainerEvent = idTrainerEvent;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_trainer", referencedColumnName = "id_trainer")
    public TrainerUserBO getTrainerEvent() {
        return trainerEvent;
    }

    public void setTrainerEvent(TrainerUserBO trainerEvent) {
        this.trainerEvent = trainerEvent;
    }


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_event", referencedColumnName = "id_event")
    public EventBO getEvent() {
        return event;
    }

    public void setEvent(EventBO event) {
        this.event = event;
    }

    @Column(name = "date_booking")
    public Date getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(Date dateBooking) {
        this.dateBooking = dateBooking;
    }
}
