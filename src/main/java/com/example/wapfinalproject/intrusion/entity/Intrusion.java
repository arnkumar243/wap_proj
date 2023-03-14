package com.example.wapfinalproject.intrusion.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "intrusion")
public class Intrusion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id")
    private String id;

    @Lob
    @Column(name="image")
    private byte[] image;

    @Column(name="date")
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
