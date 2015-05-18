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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Dasha-RV515
 */
@Entity
@Table(name="pays")
public class Pays  {
    @Id
    @GeneratedValue
    @Column(name = "numPay")
 private int numPay;
      @Column(name = "sumPay")
    private double sumPay;
       @Column(name = "datePay")
    private String datePay;
       
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    @ManyToOne(optional = false)
     private Client client;
  @JoinColumn(name = "numPersAccount", referencedColumnName = "numPersAccount")
    @ManyToOne(optional = false)
          private PersonalAccount persAccount;
    //private Set personalAccount;

    public Pays() {
    }

    public Pays(int numPay, double sumPay, String datePay,Client client,PersonalAccount persAccount) {
       this.numPay=numPay;
        this.sumPay = sumPay;
        this.datePay = datePay;
        this.client = client;
        this.persAccount=persAccount;
    }

    public void setNumPays(int numPay) {
        this.numPay= numPay;
    }

    

    public int getNumPays() {
        return numPay;
    }

   

    public double getSumPay() {
        return sumPay;
    }

    public void setSumPay(double sumPay) {
        this.sumPay = sumPay;
    }

    public String getDatePay() {
        return datePay;
    }

    public void setDatePay(String datePay) {
        this.datePay = datePay;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setPersonalAccount(PersonalAccount persAccount) {
        this.persAccount = persAccount;
    }

    public PersonalAccount getPersonalAccount() {
        return persAccount;
    }

    @Override
    public String toString() {
        return "Pays{" + "sumPay=" + sumPay + ", datePay=" + datePay +  '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.sumPay) ^ (Double.doubleToLongBits(this.sumPay) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.datePay);
      // hash = 59 * hash + this.idClient;
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
        final Pays other = (Pays) obj;
        if (Double.doubleToLongBits(this.sumPay) != Double.doubleToLongBits(other.sumPay)) {
            return false;
        }
        if (!Objects.equals(this.datePay, other.datePay)) {
            return false;
        }
//        if (this.idClient != other.idClient) {
//            return false;
//        }
        return true;
    }

    

}
