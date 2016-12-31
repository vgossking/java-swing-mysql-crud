/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author vu vuong
 */
public class Phim {
    private int Id;
    private String name;
    private String actor;
    private String genre;
    private int namSanXuat;
    private String director;
    private String description;
    private String country;

    public Phim() {
    }

    public Phim(int Id, String name, String actor, String genre, int namSanXuat, String director, String description, String country) {
        this.Id = Id;
        this.name = name;
        this.actor = actor;
        this.genre = genre;
        this.namSanXuat = namSanXuat;
        this.director = director;
        this.description = description;
        this.country = country;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    

 

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

   

    public String getDirector() {
        return director;
    }

    public String getDescription() {
        return description;
    }

    public String getCountry() {
        return country;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }


    public void setDirector(String director) {
        this.director = director;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
}
