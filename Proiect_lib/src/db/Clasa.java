/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Razvan
 */
@Entity
public class Clasa implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Profesor profesor;
    
    @OneToMany(mappedBy = "clasa",cascade = CascadeType.ALL)
    private List<Elev> elevi;
    
    @Column(nullable = false)
    private int limitaElevi;
    
    @Column(nullable = false)
    private String nume;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Elev> getElevi() {
        return elevi;
    }

    public void setElevi(List<Elev> elevi) {
        this.elevi = elevi;
    }

    public int getLimitaElevi() {
        return limitaElevi;
    }

    public void setLimitaElevi(int limitaElevi) {
        this.limitaElevi = limitaElevi;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
    
    
    
    
}
