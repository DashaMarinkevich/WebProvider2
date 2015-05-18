/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
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
@Table(name="contract")
public class Contract  {
    @Id
    @GeneratedValue
    @Column(name = "numContract")
private int numContract;
    @Column(name = "dateContract")
    private String dateContract;
        @Column(name = "statusContract")
    private String statusContract;
        @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    @ManyToOne(optional = false)
     private Client client;
  @JoinColumn(name = "numPersAccount", referencedColumnName = "numPersAccount")
    @ManyToOne(optional = false)
          private PersonalAccount persAccount;
   @JoinColumn(name = "idTarif", referencedColumnName = "idTarif")
    @ManyToOne(optional = false)
          private TarifPlan tarifPlan;
           
         //  private Set<Service> service = new HashSet();
//    private int numPersAccount;
//    private int idClient;
//    private int idTarif;

    public Contract() {
        
    }

    public Contract(int numContract, String dateContract, String statusContract,Client client,PersonalAccount persAccount,TarifPlan tarifPlan) {
      this.numContract=numContract;
        this.dateContract = dateContract;
        this.statusContract = statusContract;
          this.client = client;
          this.persAccount=persAccount;
          this.tarifPlan=tarifPlan;
//        this.numPersAccount = numPersAccount;
//        this.idClient = idClient;
//        this.idTarif= idTarif;
    }

    public void setNumContract(int numContract) {
        this.numContract = numContract;
    }

  

    public int getNumContract() {
        return numContract;
    }

   

    public String getDateContract() {
        return dateContract;
    }

    public void setDateContract(String dateContract) {
  
        this.dateContract = dateContract;
    }

    public String getStatusContract() {
        return statusContract;
    }

    public void setStatusContract(String statusContract) {
        this.statusContract = statusContract;
    }
 public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public TarifPlan getTarifPlan() {
        return tarifPlan;
    }

    public void setTarifPlan(TarifPlan tarifPlan) {
        this.tarifPlan = tarifPlan;
    }
    public void setPersonalAccount(PersonalAccount persAccount) {
        this.persAccount = persAccount;
    }

    public PersonalAccount getPersonalAccount() {
        return persAccount;
    }
//public void setService(Set service) {
//        this.service = service;
//    }
//
//    public Set getService() {
//        return service;
//    }
//    public int getNumPersAccount() {
//        return numPersAccount;
//    }
//
//    public void setNumPersAccount(int numPersAccount) {
//        this.numPersAccount = numPersAccount;
//    }
// public int getIdClient() {
//        return idClient;
//    }
//
//    public void setIdClient(int idClient) {
//        this.idClient = idClient;
//    }
//     public int getIdTarif() {
//        return idTarif;
//    }
//
//    public void setIdTarif(int idTarif) {
//        this.idTarif = idTarif;
//    }
    @Override
    public String toString() {
        return "Contract{" + "dateContract=" + dateContract + ", statusContract=" + statusContract + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.dateContract);
        hash = 61 * hash + Objects.hashCode(this.statusContract);
//        hash = 61 * hash + this.numPersAccount;
//        hash = 61 * hash + this.idClient;
//        hash = 61 * hash + this.idTarif;
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
        final Contract other = (Contract) obj;
        if (!Objects.equals(this.dateContract, other.dateContract)) {
            return false;
        }
        if (!Objects.equals(this.statusContract, other.statusContract)) {
            return false;
        }
//        if (this.numPersAccount != other.numPersAccount) {
//            return false;
//        }
//        if (this.idClient != other.idClient) {
//            return false;
//        }
//        if (this.idTarif != other.idTarif) {
//            return false;
//        }
        return true;
    }

}
