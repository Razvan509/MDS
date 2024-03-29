/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.List;
import javafx.scene.text.Text;
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
 * 
 */
@Entity
public class Material implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false)
    private String nume;
    
    @Column(nullable = false)
    private String capitol;
    
    @Column(nullable = false,length = 60000)
    private String text;
    
    @ManyToOne
    @JoinColumn(nullable = true)
    private Clasa idClasa;
    
    @OneToMany(mappedBy = "material",cascade = CascadeType.ALL)
    private List<Exercitiu> exercitii;
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCapitol() {
        return capitol;
    }

    public void setCapitol(String capitol) {
        this.capitol = capitol;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Clasa getIdClasa() {
        return idClasa;
    }

    public void setIdClasa(Clasa idClasa) {
        this.idClasa = idClasa;
    }

    public List<Exercitiu> getExercitii() {
        return exercitii;
    }

    public void setExercitii(List<Exercitiu> exercitii) {
        this.exercitii = exercitii;
    }

    @Override
    public String toString() {
        return nume + " " + capitol;
    }
    
    
    
}
