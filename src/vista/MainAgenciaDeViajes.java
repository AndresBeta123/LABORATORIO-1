package vista;
import modelo.Airport;
import modelo.BookedFlight;
import modelo.Date;
import modelo.Hotel;
import modelo.Travel;
import modelo.TravelAgency;
import java.util.Scanner;


public class MainAgenciaDeViajes {
    public static int PreMenu(){
        Scanner op = new Scanner(System.in); 
        int opcion = -1;
        System.out.println("1.Agregar un nuevo hotel.\n2.Agregar un nuevo aeropuerto.\n"
                + "3.Agregar una oferta de viaje nueva ( Hotel y aereopuertos requeridos).\n"
                + "4.Lista de viajes ofrecidos por la agencia.\n"
                + "5.Viaje de menor y mayor duracion.\n"
                + "6.Salir");
        opcion = op.nextInt();
        return opcion;
    }


public static void main(String[] args) {
    int numhot = -1;
    int numaiF = -1;
    int numaiT = -1;
    int numaiF2 = -1;
    int numaiT2 = -1;
    int viajeañoI;
    int viajediaI;
    int viajemesI;
    int viajediaR;
    int viajemesR;
    int viajeañoR;
    int viajediaI2;
    int viajemesI2;
    int viajeañoI2;
    int viajediaR2;
    int viajemesR2;
    int viajeañoR2;
    int duration;
    
    Scanner selecc = new Scanner(System.in).useDelimiter("/n");  
    Scanner selecc1 = new Scanner(System.in);
 
    System.out.println("Ingrese el nombre de la agencia de viajes : ");
    String nomAgencia = selecc.nextLine();
    TravelAgency travelagency = new TravelAgency(nomAgencia);
    int opcion2 = 0;
    do{
        opcion2 = PreMenu();
        switch(opcion2){
            case 1 :
                 System.out.println("\nIngrese el hotel asociado con su agencia de viajes : ");
    String nomHotel = selecc.nextLine();
    System.out.println("\nIngrese la direccion de ese hotel : ");
    String hotelDir = selecc.nextLine();
    if(travelagency.comprobarHotel(nomHotel, hotelDir) == false){
        System.out.println("\nEste hotel ya se encuentra registrado, no se pudo terminar la agregacion a la lista. ");
        break;
    }
    if(travelagency.addKnownHotel(nomHotel, hotelDir) == false){
        System.out.println("\nLa lista de hoteles esta llena, no se pudo agregar a la lista. ");
        break;
    }else{
        System.out.println("Se ha agregado exitosamente el hotel al sistema");
    }
                break;
   
            case 2 :
                System.out.println("\nIngrese el nombre del areopuerto : ");
    String airportP = selecc.nextLine();
    if(travelagency.comprobarAirport(airportP) == false){
        System.out.println("\nEste aereopuerto ya se encuntra registrado, no se pudo agregar  a la lista. ");
        break;
    }
    if(travelagency.addAirport(airportP) == false){
        System.out.println("\nLa lista de aereopuertos esta llena, no se pudo agregar a la lista. ");
       }else{
        System.out.println("Se ha agregado exitosamente el aeropuerto al sistema");
    }
                break;
                
            case 3 :
                System.out.println("\n*******************Datos del vuelo de ida : ********************");
                System.out.println("Ingrese la fecha del vuelo ( Solo superiores al 30 / 3 / 2018): ");
                do{
    System.out.println("\naño : ");
    viajeañoI = selecc1.nextInt();
                }while(viajeañoI < 2018 );
                do{
                do{
    System.out.println("\nmes : ");
     viajemesI = selecc1.nextInt();
                }while(viajemesI < 1);}while(viajemesI > 12);
                do{
                do{
                System.out.println("\ndia : ");
     viajediaI = selecc1.nextInt();
                }while(viajediaI < 1);}while(viajediaI > 31);
    Date start = new Date(viajediaI, viajemesI, viajeañoI);
    do{
    System.out.println("\nIngrese la duracion del viaje en minutos ( Superior a 30 minutos): ");
    duration = selecc1.nextInt();
    }while(duration < 30);
    System.out.println("\nIngrese el nombre del hotel donde se hospedara (Registrado en nuestro sistema) : ");
    String nomH = selecc.nextLine();
    if(travelagency.buscaHotel(nomH) == -1){
        System.out.println("\nNo existe ningun hotel con ese nombre registrado en nuestro sistema, suspendiendo agregacion de oferta de viaje.");
        break;
    }else{
        numhot = travelagency.buscaHotel(nomH);
    }
    System.out.println("\nIngrese el numero del vuelo : ");
    int flightNumber = selecc1.nextInt();
    System.out.println("\nIngrese la fecha en el que el vuelo llegara a su destino( Solo superiores al 30 / 3 / 2018) : ");
    do{
    System.out.println("\naño : ");
    viajeañoR = selecc1.nextInt();
    }while(viajeañoR < 2018);
    do{
    do{
    
    System.out.println("\nmes : ");
    viajemesR = selecc1.nextInt();
    }while(viajemesR < 1);}while( viajemesR > 12);
    do{
    do{
    System.out.println("\ndia : ");
    viajediaR = selecc1.nextInt();
    }while(viajediaR < 1);}while(viajediaR > 31);
    Date arrival = new Date(viajediaR, viajemesR, viajeañoR);
    System.out.println("\nIngrese el  nombre del aeropuerto de donde saldra el vuelo inicial (Registrado en nuestro sistema)  : ");
    String nomAF = selecc.nextLine();
    if(travelagency.buscaAirport(nomAF) == -1){
        System.out.println("\nNo existe ningun aeropuerto con ese nombre registrado en nuestro sistema, suspendiendo agregacion de oferta de viaje.");
        break;
    }else{
    numaiF = travelagency.buscaAirport(nomAF);
    }
    
    System.out.println("\nIngrese el nombre del aeropuerto donde el avion aterrizara (Registrado en nuestro sistema) : ");
    String nomAT = selecc.nextLine();
    if(travelagency.buscaAirport(nomAT) == -1){
        System.out.println("\nNo existe ningun aeropuerto con ese nombre registrado en nuestro sistema, suspendiendo agregacion de oferta de viaje.");
        break;
    }else{
    numaiT = travelagency.buscaAirport(nomAT);
    }
        System.out.println("\n***************Datos del vuelo de regreso :********************* ");
                System.out.println("Ingrese la fecha del vuelo de regreso ( Solo superiores al 30 / 3 / 2018): ");
    do{
                System.out.println("\naño : ");
    viajeañoI2 = selecc1.nextInt();
    }while(viajeañoI2 < 2018);
    do{
    do{
    System.out.println("\nmes : ");
    viajemesI2 = selecc1.nextInt();
    }while(viajemesI2 < 1);}while( viajemesI2 > 12);
    do{
    do{
    System.out.println("\ndia : ");
     viajediaI2 = selecc1.nextInt();
    }while(viajediaI2 < 1);}while(viajediaI2 > 31);
    Date start2 = new Date(viajediaI2, viajemesI2, viajeañoI2);
    
    System.out.println("\nIngrese el numero del vuelo : ");
    int flightNumber2 = selecc1.nextInt();
    System.out.println("\nIngrese la fecha de cuando el vuelo de regreso llegue a su destino( Solo superiores al 30 / 3 / 2018) : ");
   do{
    System.out.println("\naño : ");
    viajeañoR2 = selecc1.nextInt();
    }while(viajeañoR2 < 2018);
   do{
   do{
    System.out.println("\nmes : ");
    viajemesR2 = selecc1.nextInt();
   }while(viajemesR2 < 1);}while( viajemesR2 > 12);
   do{
   do{
    System.out.println("\ndia : ");
    viajediaR2 = selecc1.nextInt();
   }while(viajediaR2 < 1);}while( viajediaR2 > 31);
    Date arrival2 = new Date(viajediaR2, viajemesR2, viajeañoR2);
    System.out.println("\nIngrese el  nombre del aeropuerto de donde saldra el vuelo de regreso (Registrado en nuestro sistema)  : ");
    String nomAF2 = selecc.nextLine();
    if(travelagency.buscaAirport(nomAF2) == -1){
        System.out.println("\nNo existe ningun aeropuerto con ese nombre registrado en nuestro sistema, suspendiendo agregacion de oferta de viaje.");
        break;
    }else{
    numaiF2 = travelagency.buscaAirport(nomAF);
    }
    
    System.out.println("\nIngrese el nombre del aeropuerto donde el avion de regreso aterrizara (Registrado en nuestro sistema) : ");
    String nomAT2 = selecc.nextLine();
    if(travelagency.buscaAirport(nomAT2) == -1){
        System.out.println("\nNo existe ningun aeropuerto con ese nombre registrado en nuestro sistema, suspendiendo agregacion de oferta de viaje.");
        break;
    }else{
    numaiT2 = travelagency.buscaAirport(nomAT);
    }
    
    if(travelagency.comprobarOfferedTravel(start, duration, travelagency.tomarHotel(numhot), flightNumber, start, arrival,travelagency.tomarAeropuerto(numaiF), travelagency.tomarAeropuerto(numaiT), 
            flightNumber2, start2, arrival2, travelagency.tomarAeropuerto(numaiF2), travelagency.tomarAeropuerto(numaiT2)) == false){
        System.out.println("\nEsta oferta de viaje ya se encuentra registrado, no se pudo terminar la agregacion a la lista. ");
        break;
    }
    if(travelagency.addOfferedTravel(start, duration, travelagency.tomarHotel(numhot), flightNumber, start, arrival,travelagency.tomarAeropuerto(numaiF), travelagency.tomarAeropuerto(numaiT), 
            flightNumber2, start2, arrival2, travelagency.tomarAeropuerto(numaiF2), travelagency.tomarAeropuerto(numaiT2)) == false){
              System.out.println("\nLa lista de ofertas de viajes esta llena, no se pudo agregar a la lista.");  
              break;
            }else{
        System.out.println("\nSe agrego la oferta de viaje con exito a la lista. ");
    }
    
    

                break;
    
                case 4 :
            
                if(travelagency.tamañoVuelo() == -1){
                    System.out.println("\nNo hay vuelos disponibles por el momento .");
                }else{
                System.out.println("Vuelos disponibles : ");
                for (int i = 0;i <= travelagency.tamañoVuelo() ;i++){
                    Travel travel =travelagency.tomarVuelos(i);
                    System.out.println("\n"+(i+1) +"." +"\n" + "Inicia : " + travel.getStart().getDia()+ "/" + travel.getStart().getMes()
                            + "/" + travel.getStart().getAño()+"\n"
                    + "Duracion en minutos : " + travel.getDuration() + "\n" +
                    "Nombre del hotel : " + travel.getHotel().getName() +"        Direccion del hotel : " +
                            travel.getHotel().getAddress()+ "\n" + 
                                    "********************VUELO DE IDA********************" + "\n"+
                    " Numero del vuelo :" + travel.getOutbound().getFlightNumber() + "\n" +
                            " Fecha de salida del vuelo :" + travel.getOutbound().getDeparture().getDia()+ "/"+
                            travel.getOutbound().getDeparture().getMes()+"/"+travel.getOutbound().getDeparture().getAño()  + "\n" +
                    " Fecha de llegada del vuelo :" + travel.getOutbound().getArrival().getDia()+"/"+travel.getOutbound().getArrival().getMes() 
                            +"/"+travel.getOutbound().getArrival().getAño()+ "\n" +
                            " Aeropuerto desde donde sale el avion :" + travel.getOutbound().getFrom().getDescripcion()+ "\n" +
                             " Aeropuerto donde aterriza el avion :" + travel.getOutbound().getTo().getDescripcion()+ "\n" +
                            " ********************VUELO DE REGRESO******************** " + "\n" +
                    " Numero del vuelo :" + travel.getReturnR().getFlightNumber() + "\n" +
                            " Fecha de salida del vuelo :" + travel.getReturnR().getDeparture().getDia()+"/"+travel.getReturnR().getDeparture().getMes()
                            +"/"+travel.getReturnR().getDeparture().getAño()+ "\n" +
                    " Fecha de llegada del vuelo :" + travel.getReturnR().getArrival().getDia()+"/"+travel.getReturnR().getArrival().getMes()+"/"+travel.getReturnR().getArrival().getAño()+ "\n" +
                            " Aeropuerto desde donde sale el avion :" + travel.getReturnR().getFrom().getDescripcion()+ "\n" +
                             " Aeropuerto donde aterriza el avion :" + travel.getReturnR().getTo().getDescripcion()+ "\n\n"
                            ); 
                }
                }
                
                break;
                
            case 5 :
                if(travelagency.tamañoVuelo() == -1){
                    System.out.println("\nNo hay vuelos  para comparar por el momento .");
                }else{
                    System.out.println("El vuelo de menor duracion en minutos : ");
                    Travel travel2 =travelagency.tomarVuelos(travelagency.menorDuracion());
                    System.out.println("\n"+ "Inicia : " + travel2.getStart().getDia()+"/"+travel2.getStart().getMes()+"/"+travel2.getStart().getAño() + "\n" +
                            "Duracion en minutos:" + travel2.getDuration() + "\n" +
                            "nombre del hotel : " + travel2.getHotel().getName() + "              Direccion del hotel : "+travel2.getHotel().getAddress()+"\n" + 
                            "********************VUELO DE IDA********************" + "\n"+
                    " Numero del vuelo :" + travel2.getOutbound().getFlightNumber() + "\n" +
                            " Fecha de salida del vuelo :" + travel2.getOutbound().getDeparture().getDia()+"/"+travel2.getOutbound().getDeparture().getMes() +
                            "/"+travel2.getOutbound().getDeparture().getAño()+"\n" +
                    " Fecha de llegada del vuelo :" + travel2.getOutbound().getArrival().getDia()+"/"+travel2.getOutbound().getArrival().getMes()+"/"+
                            travel2.getOutbound().getArrival().getAño()+"\n" +
                            " Aeropuerto desde donde sale el avion :" + travel2.getOutbound().getFrom().getDescripcion()+ "\n" +
                             " Aeropuerto donde aterriza el avion :" + travel2.getOutbound().getTo().getDescripcion()+ "\n" +
                         " ********************VUELO DE REGRESO******************** " + "\n" +
                    " Numero del vuelo :" + travel2.getReturnR().getFlightNumber() + "\n" +
                            " Fecha de salida del vuelo :" + travel2.getReturnR().getDeparture().getDia()+"/" +travel2.getReturnR().getDeparture().getMes()
                            +"/"+travel2.getReturnR().getDeparture().getAño()+ "\n" +
                    " Fecha de llegada del vuelo :" + travel2.getReturnR().getArrival().getDia()+"/"+travel2.getReturnR().getArrival().getMes()+"/"
                            +travel2.getReturnR().getArrival().getAño()+"\n" +
                            " Aeropuerto desde donde sale el avion :" + travel2.getReturnR().getFrom().getDescripcion()+ "\n" +
                             " Aeropuerto donde aterriza el avion :" + travel2.getReturnR().getTo().getDescripcion()+ "\n\n"
                            ); 
                    System.out.println("El vuelo de mayor duracion en minutos: ");
                    Travel travel3 =travelagency.tomarVuelos(travelagency.mayorDuracion());
                    System.out.println("\n"+ "Inicia : " + travel3.getStart().getDia() + "/"+travel3.getStart().getMes()+ "/" +travel3.getStart().getAño()+ "\n"
                    +"Duracion en minutos:" + travel3.getDuration() + "\n" +
                    "Nombre del hotel : " + travel3.getHotel().getName()+"                  Direccion del hotel : " +travel3.getHotel().getAddress() +"\n" + 
                           "********************VUELO DE IDA********************" + "\n"+
                    " Numero del vuelo :" + travel3.getOutbound().getFlightNumber() + "\n" +
                            " Fecha de salida del vuelo :" + travel3.getOutbound().getDeparture().getDia()+"/"+travel3.getOutbound().getDeparture().getMes() +"/"
                                    + travel3.getOutbound().getDeparture().getAño()+ "\n" +
                    " Fecha de llegada del vuelo :" + travel3.getOutbound().getArrival().getDia()+"/"+travel3.getOutbound().getArrival().getMes()+"/"+travel3.getOutbound().getArrival().getAño()+
                            "\n" +
                            " Aeropuerto desde donde sale el avion :" + travel3.getOutbound().getFrom().getDescripcion()+ "\n" +
                             " Aeropuerto donde aterriza el avion :" + travel3.getOutbound().getTo().getDescripcion()+ "\n" +
                             " ********************VUELO DE REGRESO******************** " + "\n" +
                    " Numero del vuelo :" + travel3.getReturnR().getFlightNumber() + "\n" +
                            " Fecha de salida del vuelo :" + travel3.getReturnR().getDeparture().getDia()+"/"+travel3.getReturnR().getDeparture().getMes() + "/"
                                    +travel3.getReturnR().getDeparture().getAño()+"\n" +
                    " Fecha de llegada del vuelo :" + travel3.getReturnR().getArrival().getDia()+"/"+travel3.getReturnR().getArrival().getMes()+"/" +
                            travel3.getReturnR().getArrival().getAño()+"\n" +
                            " Aeropuerto desde donde sale el avion :" + travel3.getReturnR().getFrom().getDescripcion()+ "\n" +
                             " Aeropuerto donde aterriza el avion :" + travel3.getReturnR().getTo().getDescripcion()+ "\n\n"
                            ); 
                }
                
                
                break;
                
            default:
                break;

                        
                        
        }
    
    }while(opcion2 != 6);
    
    
    
    
    

        
    
    
    


}
}


    
    
   