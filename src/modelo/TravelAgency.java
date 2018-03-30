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
public class TravelAgency {
private String nombre;
private Hotel[] knownHotels;
private Travel[] offeredTravels;
private Airport[] airports;

    public TravelAgency(String nombre) {
        this.nombre = nombre;
        this.knownHotels = new Hotel[5];
        this.offeredTravels = new Travel[10];
        this.airports = new Airport[4];
    }
    public boolean comprobarHotel(String name, String address){
        boolean r = true;
        for(int i=0;i <= 4 ;i++){
        if(this.knownHotels[i] != null){
            if(this.knownHotels[i].getName().equals(name) && this.knownHotels[i].getAddress().equals(address)){
                r = false;
            }
    }
    }
        return r;
    }
    public boolean addKnownHotel(String name, String address){
    boolean r = false;
    for(int i=0;i <= 4;i++){
    if(this.knownHotels[i] == null){
       
        this.knownHotels[i] = new Hotel(name, address);
        r = true;
        break;
    }   
     
    
    }
    return r;
    }
    
     public boolean removeHotel(String name,String address){
        boolean r = false;
       for(int i = 0; i <= 4; i++){
           if(this.knownHotels[i].getName().equals(name) && this.knownHotels[i].getAddress().equals(address)){
            this.knownHotels[i] = null;
            r = true;
            break;
           }
       }
    return r;
    }
    
     public int tamañoHotel(){
       int r = -1;
       for(int i = 0;i <= 4;i++){
        if(this.knownHotels[i] != null){
            r++;
        }
       }
        return r;
        }   
     
     
     public int buscaHotel(String name){
         int r = -1;
         for(int i = 0; i <= this.tamañoHotel(); i++){
           if(this.knownHotels[i].getName().equals(name)){
             r = i;
            break;
     }
         }
         return r;
     }
   
     public Hotel tomarHotel(int i) {
      String n = this.knownHotels[i].getName();
      String a = this.knownHotels[i].getAddress();
      Hotel hotel = new Hotel(n,a);
      return hotel;
     }
     
    public boolean comprobarAirport(String description){
        boolean r = true;
        for(int i=0;i <= 3;i++){
        if(this.airports[i] != null){
            if(this.airports[i].getDescripcion().equals(description)){
                r = false;
            }
    }
    }
        return r;
    }
    
    public boolean addAirport(String description){ 
    boolean r = false;   
    for(int i=0;i <= 3;i++){
    if(this.airports[i] == null){
        this.airports[i] = new Airport(description);
        r = true;
        break;
    }   
     
    }
    return r;
    }

     public boolean removeAirport(String description){
        boolean r = false;
       for(int i = 0; i <= 3; i++){
           if(this.airports[i].getDescripcion().equals(description)){
            this.airports[i] = null;
            r = true;
            break;
           }
       }
    return r;
    }
    
     public int tamañoairports(){
       int r = -1;
       for(int i = 0;i <= 3;i++){
        if(this.airports[i] != null){
            r++;
        }
       }
        return r;
        }   
     
     public int buscaAirport(String name){
         int r = -1;
         for(int i = 0; i <= this.tamañoairports(); i++){
           if(this.airports[i].getDescripcion().equals(name)){
             r = i;
            break;
     }
         }
         return r;
     }
     
     public Airport tomarAeropuerto(int i) {
      String d = this.airports[i].getDescripcion();
      
      Airport airport = new Airport(d);
      return airport;
     }
    
     public boolean comprobarOfferedTravel(Date start, int duration, Hotel hotel, 
            int flightNumber, Date departure, Date arrival, Airport airportF, Airport airportT,
            int flightNumber2, Date departure2, Date arrival2, Airport airportF2, Airport airportT2){
        boolean r = true;
        for(int i=0;i <= 9;i++){
        if(offeredTravels[i] != null){
            if(this.offeredTravels[i].getStart().equals(start) && this.offeredTravels[i].getDuration() == duration 
                    && this.offeredTravels[i].getHotel().equals(hotel) && this.offeredTravels[i].getOutbound().getFlightNumber() == flightNumber
                    && this.offeredTravels[i].getOutbound().getDeparture().equals(departure) && this.offeredTravels[i].getOutbound().getArrival()
                    .equals(arrival) && this.offeredTravels[i].getOutbound().getFrom().equals(airportF) && this.offeredTravels[i].getOutbound()
                    .getTo().equals(airportT) && this.offeredTravels[i].getReturnR().getFlightNumber() == flightNumber2
                    && this.offeredTravels[i].getReturnR().getDeparture().equals(departure2)&& this.offeredTravels[i].getReturnR()
                    .getArrival().equals(arrival2)&& this.offeredTravels[i].getReturnR().getFrom().equals(airportF2)&& this.offeredTravels[i].getReturnR()
                    .getTo().equals(airportT2)){
                r = false;
            }
    }
    }
        return r;
    }
    
    
    public boolean addOfferedTravel(Date start, int duration, Hotel hotel, 
            int flightNumber, Date departure, Date arrival, Airport airportF, Airport airportT,
            int flightNumber2, Date departure2, Date arrival2, Airport airportF2, Airport airportT2){ 
        boolean r = false;
    for(int i=0;i <= 9;i++){
    if(offeredTravels[i] == null){
        r= true;
        this.offeredTravels[i] = new Travel(start, duration);
        this.offeredTravels[i].setHotel(hotel);
        this.offeredTravels[i].addOutbound(flightNumber, departure, arrival, airportT, airportT);
        this.offeredTravels[i].addReturnR(flightNumber2, departure2, arrival2, airportT2, airportT2);
        break;
    }   
     
    }
    return r;
    }
    
    public Travel tomarVuelos(int i) {
        Travel travel = this.offeredTravels[i];
        
      return travel;
    }
    
    public int tamañoVuelo(){
       int r = -1;
       for(int i = 0;i <= 9;i++){
        if(this.offeredTravels[i] != null){
            r++;
        }
       }
        return r;
        }
    
    public int menorDuracion(){
        int r = this.offeredTravels[0].getDuration();
        for (int i = 0; i <= this.tamañoVuelo();i++){
         if(this.offeredTravels[i].getDuration() <= r){
             r = i;
         }
    }
        return r;
    }
    
      public int mayorDuracion(){
        int r = this.offeredTravels[0].getDuration();
        for (int i = 0; i <= this.tamañoVuelo();i++){
         if(this.offeredTravels[i].getDuration() >= r){
             r = i;
         }
    }
        return r;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Hotel[] getKnownHotels() {
        return knownHotels;
    }

    public void setKnownHotels(Hotel[] knownHotels) {
        this.knownHotels = knownHotels;
    }

    public Travel[] getOfferedTravels() {
        return offeredTravels;
    }

    public void setOfferedTravels(Travel[] offeredTravels) {
        this.offeredTravels = offeredTravels;
    }

    public Airport[] getAirports() {
        return airports;
    }

    public void setAirports(Airport[] airports) {
        this.airports = airports;
    }

}
