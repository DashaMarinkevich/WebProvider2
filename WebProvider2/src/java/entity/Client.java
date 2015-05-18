/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Dasha-RV515
 */
@Entity
@Table(name="client")
public class Client  {
    @Id
    @GeneratedValue
    @Column(name = "idClient")
private int idClient;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "seriaPassport")
    private String seriaPassport;
    @Column(name = "numPassport")
    private int numPassport;
    @Column(name = "adress")
    private String adress;
     @Column(name = "email")
    private String email;
      @Column(name = "login")
     private String login;
           @Column(name = "password") 
    private String password;
   // private Set<Pays> pays = new HashSet();
    //private Set<Contract> contract = new HashSet();

    public Client() {
    }
//public Client(int id, String fullName, String seriaPassport, int numPassport, String adress, String email,String login,int password,Set contract) {
//        super(id);
//        this.fullName = fullName;
//        this.seriaPassport = seriaPassport;
//        this.numPassport = numPassport;
//        this.adress = adress;
//        this.email = email;
//        this.login=login;
//        this.password=password;
//        this.contract = contract;
//    }
    public Client(int idClient, String fullName, String seriaPassport, int numPassport, String adress, String email,String login,String password) {
   this.idClient=idClient;
        this.fullName = fullName;
        this.seriaPassport = seriaPassport;
        this.numPassport = numPassport;
        this.adress = adress;
        this.email = email;
        this.password=password;
         this.login=login;
        this.password=password;
        //this.contract = contract;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSeriaPassport() {
        return seriaPassport;
    }

    public void setSeriaPassport(String seriaPassport) {
        this.seriaPassport = seriaPassport;
    }
 public int getNumPassport() {
        return numPassport;
    }

    public void setNumPassport(int numPassport) {
        this.numPassport = numPassport;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public void setPays(Set pays) {
//        this.pays = pays;
//    }
public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
//    public Set getPays() {
//        return pays;
//    }
//
//    public void setContract(Set contract) {
//        this.contract = contract;
//    }
//
//    public Set getContract() {
//        return contract;
//    }

    @Override
    public String toString() {
        return "Client{" + "fullName=" + fullName + ", seriaPassport=" + seriaPassport + ", numPassport=" + numPassport + ", adress=" + adress + ", email=" + email + ", login=" + login + ", password=" + password + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.fullName);
        hash = 37 * hash + Objects.hashCode(this.seriaPassport);
        hash = 37 * hash + this.numPassport;
        hash = 37 * hash + Objects.hashCode(this.adress);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Objects.hashCode(this.login);
 
//        hash = 37 * hash + Objects.hashCode(this.pays);
//        hash = 37 * hash + Objects.hashCode(this.contract);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
        }
        if (!Objects.equals(this.seriaPassport, other.seriaPassport)) {
            return false;
        }
        if (this.numPassport != other.numPassport) {
            return false;
        }
        if (!Objects.equals(this.adress, other.adress)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        
        return true;
    }

   
   

}
