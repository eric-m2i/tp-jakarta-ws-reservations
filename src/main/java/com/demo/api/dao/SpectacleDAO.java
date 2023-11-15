package com.demo.api.dao;

import com.demo.api.model.Spectacle;

import java.util.ArrayList;

public class SpectacleDAO {

    /***************** SINGLETON **************************/
    private static SpectacleDAO instance;

    // constructeur private ce qui empeche d'instancier cette classe de l'exterieur
    private SpectacleDAO(){
    }

    public static SpectacleDAO getInstance(){
        if(instance == null)
            instance = new SpectacleDAO();

        return instance;
    }
    /*******************************************/



    private ArrayList<Spectacle> spectacles = new ArrayList<>();
    private int idCount = 0;


    public ArrayList<Spectacle> getSpectacles() {
        return spectacles;
    }

    public void setSpectacles(ArrayList<Spectacle> spectacles) {
        this.spectacles = spectacles;
    }

    public void addSpectacle(Spectacle spectacle){
        idCount++;
        spectacle.setId(idCount);
        spectacles.add(spectacle);
    }

    public Spectacle findById(Integer id){
        for(Spectacle s : spectacles)
            if(s.getId().equals(id))
                return s;
        return null;
    }

    public boolean exist(Integer spectacleId) {
        return findById(spectacleId) != null;
    }
}
