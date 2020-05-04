package com.example.mihail.info_holiday;

public class FlightInfo {

    private String bookingNumber;


    private int id;

    private String arivalAirport;
    private String dateOfFlight;
    private String destinationHotel;
    private String fromAirport;
    private String idFlight;

    private String startTimeToAirport;
    private String timeOfFlight;





    public FlightInfo(String bookingNumber, int id, String arivalAirport, String dateOfFlight, String destinationHotel,
                      String fromAirport, String idFlight, String startTimeToAirport, String timeOfFlight) {
        super();
        this.bookingNumber = bookingNumber;
        this.id = id;
        this.arivalAirport = arivalAirport;
        this.dateOfFlight = dateOfFlight;
        this.destinationHotel = destinationHotel;
        this.fromAirport = fromAirport;
        this.idFlight = idFlight;
        this.startTimeToAirport = startTimeToAirport;
        this.timeOfFlight = timeOfFlight;
    }


    public FlightInfo() {
        super();
    }




    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getDateOfFlight() {
        return dateOfFlight;
    }


    public void setDateOfFlight(String dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }



    public String getBookingNumber() {
        return bookingNumber;
    }
    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }
    public String getIdFlight() {
        return idFlight;
    }
    public void setIdFlight(String idFlight) {
        this.idFlight = idFlight;
    }
    public String getFromAirport() {
        return fromAirport;
    }
    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }
    public String getArivalAirport() {
        return arivalAirport;
    }
    public void setArivalAirport(String arivalAirport) {
        this.arivalAirport = arivalAirport;
    }
    public String getDestinationHotel() {
        return destinationHotel;
    }
    public void setDestinationHotel(String destinationHotel) {
        this.destinationHotel = destinationHotel;
    }
    public String getStartTimeToAirport() {
        return startTimeToAirport;
    }
    public void setStartTimeToAirport(String startTimeToAirport) {
        this.startTimeToAirport = startTimeToAirport;
    }
    public String getTimeOfFlight() {
        return timeOfFlight;
    }
    public void setTimeOfFlight(String timeOfFlight) {
        this.timeOfFlight = timeOfFlight;
    }




}
