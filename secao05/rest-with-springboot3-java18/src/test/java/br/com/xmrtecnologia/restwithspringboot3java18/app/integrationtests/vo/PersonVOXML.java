package br.com.xmrtecnologia.restwithspringboot3java18.app.integrationtests.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonVOXML implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String gender;
//    private Date birthDay;
	
	public PersonVOXML() {}

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

//    public Date getBirthDay() {
//        return birthDay;
//    }
//
//    public void setBirthDay(Date birthDay) {
//        this.birthDay = birthDay;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(address, firstName, gender, id, lastName);
//        return Objects.hash(address, birthDay, firstName, gender, id, lastName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PersonVOXML other = (PersonVOXML) obj;
        return Objects.equals(address, other.address) && Objects.equals(firstName, other.firstName) && 
                Objects.equals(gender, other.gender)
                && Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName);
//        return Objects.equals(address, other.address) && Objects.equals(birthDay, other.birthDay)
//                && Objects.equals(firstName, other.firstName) && Objects.equals(gender, other.gender)
//                && Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName);
    }

    @Override
    public String toString() {
        return "PersonVOXML [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
                + ", gender=" + gender + "]";
    }

}