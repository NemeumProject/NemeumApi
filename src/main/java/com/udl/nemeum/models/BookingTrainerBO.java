package com.udl.nemeum.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.udl.nemeum.repository.TrainerSportRepository;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking_trainer")
public class BookingTrainerBO {

    private Integer idBookingTrainer;
    private IndividualUserBO idUser;
    private TrainerSportBO idService;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
    private Date dateBooking;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
    private Date endBooking;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
    private Date startBooking;
    private Double price;

    public BookingTrainerBO(Integer idBookingTrainer, IndividualUserBO idUser, TrainerSportBO idService, Date dateBooking, Date endBooking, Date startBooking, Double price) {
        this.idBookingTrainer = idBookingTrainer;
        this.idUser = idUser;
        this.idService = idService;
        this.dateBooking = dateBooking;
        this.endBooking = endBooking;
        this.startBooking = startBooking;
        this.price = price;
    }

    public BookingTrainerBO(){
        super();
    }

    @Id
    @Column(name = "id_booking_trainer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdBookingTrainer() {
        return idBookingTrainer;
    }

    public void setIdBookingTrainer(Integer idBookingTrainer) {
        this.idBookingTrainer = idBookingTrainer;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    public IndividualUserBO getIdUser() {
        return idUser;
    }

    public void setIdUser(IndividualUserBO idUser) {
        this.idUser = idUser;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_service", referencedColumnName = "id_training_service_post")
    public TrainerSportBO getIdService() {
        return idService;
    }

    public void setIdService(TrainerSportBO idService) {
        this.idService = idService;
    }
    @Column(name = "date_booking")
    public Date getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(Date dateBooking) {
        this.dateBooking = dateBooking;
    }

    @Column(name = "end_service")
    public Date getEndBooking() {
        return endBooking;
    }

    public void setEndBooking(Date endBooking) {
        this.endBooking = endBooking;
    }

    @Column(name = "start_service")
    public Date getStartBooking() {
        return startBooking;
    }

    public void setStartBooking(Date startBooking) {
        this.startBooking = startBooking;
    }

    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
