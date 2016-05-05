/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.db.entities;

// Import log4j class
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.log4j.Logger;

/**
 *
 * @author Sam
 */
@Entity
@Table(name = "appointment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a"),
    @NamedQuery(name = "Appointment.findById", query = "SELECT a FROM Appointment a WHERE a.id = :id"),
    @NamedQuery(name = "Appointment.findByFirstName", query = "SELECT a FROM Appointment a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "Appointment.findByLastName", query = "SELECT a FROM Appointment a WHERE a.lastName = :lastName"),
    @NamedQuery(name = "Appointment.findByEmail", query = "SELECT a FROM Appointment a WHERE a.email = :email"),
    @NamedQuery(name = "Appointment.findByPhone", query = "SELECT a FROM Appointment a WHERE a.phone = :phone"),
    @NamedQuery(name = "Appointment.findByBestCallTime", query = "SELECT a FROM Appointment a WHERE a.bestCallTime = :bestCallTime"),
    @NamedQuery(name = "Appointment.findByAppointmentDate", query = "SELECT a FROM Appointment a WHERE a.appointmentDate = :appointmentDate"),
    @NamedQuery(name = "Appointment.findByAppointmentTime", query = "SELECT a FROM Appointment a WHERE a.appointmentTime = :appointmentTime"),
    @NamedQuery(name = "Appointment.findByComments", query = "SELECT a FROM Appointment a WHERE a.comments = :comments")})
public class Appointment implements Serializable {

    @JoinColumn(name = "service", referencedColumnName = "id")
    @ManyToOne
    private Services service;

    @JoinColumn(name = "location", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Location location;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "last_name")
    private String lastName;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "best_call_time")
    private String bestCallTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "appointment_date")
    @Temporal(TemporalType.DATE)
    private Date appointmentDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "appointment_time")
    @Temporal(TemporalType.TIME)
    private Date appointmentTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "comments")
    private String comments;

    private static final Logger logger = Logger.getLogger(Appointment.class.getName());

    public Appointment() {
    }

    public Appointment(Integer id) {
        this.id = id;
    }

    public Appointment(Integer id, String firstName, String lastName, String email, String phone, String bestCallTime, Date appointmentDate, Date appointmentTime, String comments, String address1, String city, String state, String zip) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.bestCallTime = bestCallTime;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBestCallTime() {
        return bestCallTime;
    }

    public void setBestCallTime(String bestCallTime) {
        this.bestCallTime = bestCallTime;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fairhaven.db.entities.Appointment[ id=" + id + " ]";
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

}
