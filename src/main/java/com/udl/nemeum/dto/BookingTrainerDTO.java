package com.udl.nemeum.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.udl.nemeum.models.BookingTrainerBO;

import java.util.Date;

public class BookingTrainerDTO {

    private Integer idBookingTrainer;
    private Integer idUser;
    private Integer idService;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
    private Date dateBooking;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
    private Date endBooking;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
    private Date startBooking;
    private Double price;

    public BookingTrainerDTO(BookingTrainerBO bo) {
        this.idBookingTrainer = bo.getIdBookingTrainer();
        this.idUser = bo.getIdUser().getIdIndividualUser();
        this.idService = bo.getIdService().getIdTrainingServicePost();
        this.dateBooking = bo.getDateBooking();
        this.endBooking = bo.getEndBooking();
        this.startBooking = bo.getStartBooking();
        this.price = bo.getPrice();
    }

    public BookingTrainerDTO(){
        super();
    }

    public Integer getIdBookingTrainer() {
        return idBookingTrainer;
    }

    public void setIdBookingTrainer(Integer idBookingTrainer) {
        this.idBookingTrainer = idBookingTrainer;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public Date getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(Date dateBooking) {
        this.dateBooking = dateBooking;
    }

    public Date getEndBooking() {
        return endBooking;
    }

    public void setEndBooking(Date endBooking) {
        this.endBooking = endBooking;
    }

    public Date getStartBooking() {
        return startBooking;
    }

    public void setStartBooking(Date startBooking) {
        this.startBooking = startBooking;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
