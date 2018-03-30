/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Travel {
private Date start;
private int duration;
private Hotel hotel;
private BookedFlight outbound;
private BookedFlight returnR;

    public Travel(Date start, int duration) {
        this.start = start;
        this.duration = duration;
    }

    public void addhotel(Hotel hotel){
        this.setHotel(hotel);
    }
    
    public void addOutbound(int flightNumber, Date departure, Date arrival,Airport from, Airport to){
        BookedFlight bookedflight = new BookedFlight(flightNumber,departure,arrival);
        bookedflight.addAirtFrom(from);
        bookedflight.addAirtTo(to);
        this.setOutbound(bookedflight);
    }
    
    public void addReturnR(int flightNumber, Date departure, Date arrival,Airport from, Airport to){
        BookedFlight bookedflight = new BookedFlight(flightNumber,departure,arrival);
        bookedflight.addAirtFrom(from);
        bookedflight.addAirtTo(to);
        this.setReturnR(bookedflight);
    }
    
    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public BookedFlight getOutbound() {
        return outbound;
    }

    public void setOutbound(BookedFlight outbound) {
        this.outbound = outbound;
    }

    public BookedFlight getReturnR() {
        return returnR;
    }

    public void setReturnR(BookedFlight returnR) {
        this.returnR = returnR;
    }
    
}
