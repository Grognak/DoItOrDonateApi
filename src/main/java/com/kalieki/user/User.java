package com.kalieki.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kalieki.donation.DonationCriteria;
import com.kalieki.steps.Steps;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kalieki on 9/24/16.
 */

@Entity
public class User {


    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column()
    private String email;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(referencedColumnName = "id")
    private DonationCriteria donationCriteria;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy="user", fetch = FetchType.EAGER, targetEntity = Steps.class)
    @JsonManagedReference
    private List<Steps> steps;

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username != null ? username.toLowerCase() : null;
    }

    public void setUsername(String username) {
        this.username = username != null ? username.toLowerCase() : null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public List<Steps> getSteps() {
        return steps;
    }

    public void setSteps(List<Steps> steps) {
        this.steps = steps;
    }

    public DonationCriteria getDonationCriteria() {
        return donationCriteria;
    }

    public void setDonationCriteria(DonationCriteria donationCriteria) {
        this.donationCriteria = donationCriteria;
    }
}
