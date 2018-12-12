package com.udl.nemeum.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_event", schema = "nemeum")
public class IndividualEventBO {

    private Integer idUserEvent;
    private IndividualUserBO userEvent;
    private EventBO eventIndividual;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
    private Date dateBooking;

    public IndividualEventBO(Integer idUserEvent, IndividualUserBO userEvent, EventBO eventIndividual, Date dateBooking) {
        this.idUserEvent = idUserEvent;
        this.userEvent = userEvent;
        this.eventIndividual = eventIndividual;
        this.dateBooking = dateBooking;
    }

    @Id
    @Column(name = "id_user_event")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdUserEvent() {
        return idUserEvent;
    }

    public void setIdUserEvent(Integer idUserEvent) {
        this.idUserEvent = idUserEvent;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    public IndividualUserBO getUserEvent() {
        return userEvent;
    }

    public void setUserEvent(IndividualUserBO userEvent) {
        this.userEvent = userEvent;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_event", referencedColumnName = "id_event")
    public EventBO getEventIndividual() {
        return eventIndividual;
    }

    public void setEventIndividual(EventBO eventIndividual) {
        this.eventIndividual = eventIndividual;
    }

    @Column(name = "date_booking")
    public Date getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(Date dateBooking) {
        this.dateBooking = dateBooking;
    }
}
