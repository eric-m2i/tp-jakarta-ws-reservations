package com.demo.api.dao;

import com.demo.api.model.Reservation;
import com.demo.api.model.Spectacle;

import java.util.ArrayList;
import java.util.List;

public class ResvervationDAO {

    /***************** SINGLETON **************************/
    private static ResvervationDAO instance;

    // constructeur private ce qui empeche d'instancier cette classe de l'exterieur
    private ResvervationDAO(){
    }

    public static ResvervationDAO getInstance(){
        if(instance == null)
            instance = new ResvervationDAO();

        return instance;
    }
    /*******************************************/



    private ArrayList<Reservation> reservations = new ArrayList<>();
    private int idCount = 0;


    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation){
        idCount++;
        reservation.setId(idCount);
        reservations.add(reservation);
    }

    public boolean annulationReservation(Integer id) {
        for (Reservation r : reservations){
            // attention : on ne peut supprimer une resa deja confrmée !
            if(r.getId().equals(id) && !r.isConfirme()){
                reservations.remove(r);
                return true;
            }
        }
        return false;
    }

    public Reservation findById(Integer id){
        for (Reservation r : reservations)
            if(r.getId().equals(id))
                return r;
        return null;
    }

    public boolean confirme(Reservation confirmation) {
        Reservation reservation = findById(confirmation.getId());
        if(reservation == null)
            return false;
        if(!reservation.getPseudo().equals(confirmation.getPseudo()))
            return false;

        reservation.setConfirme(true);
        return true;
    }

    public List<Reservation> getReservationsConfirmees(Integer id) {
        List<Reservation> result = new ArrayList<>();
        for(Reservation resa : reservations){
            if(resa.getId().equals(id) && resa.isConfirme())
                result.add(resa);
        }
        return result;
    }
}
