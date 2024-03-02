package br.com.xmrtecnologia.restwithspringboot3java18.app.model;

import java.io.Serializable;
//import java.util.Date;
import java.util.Objects;

import br.com.xmrtecnologia.restwithspringboot3java18.app.config.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;

@Generated  // Utilizada para não fazer parte dos testes coverage jacoco
@Entity
@Table(name = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "first_name", nullable = false, length = 80)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;
    
    @Column(nullable = false, length = 100)
    private String address;
    
    @Column(nullable = false, length = 6)
    private String gender;

    @Column(nullable = false)
    private Boolean enabled;

//    @Column(name = "birth_day", nullable = true)
//    @Temporal(TemporalType.DATE)
//    private Date birthDay;
    
    public Person() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, enabled, firstName, gender, id, lastName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        return Objects.equals(address, other.address) && Objects.equals(enabled, other.enabled)
                && Objects.equals(firstName, other.firstName) && Objects.equals(gender, other.gender)
                && Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName);
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
                + ", gender=" + gender + ", enabled=" + enabled + "]";
    }

}