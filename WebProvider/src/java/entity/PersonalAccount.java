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
import javax.persistence.Table;

/**
 *
 * @author Dasha-RV515
 */
@Entity
@Table(name="personalaccount")
public class PersonalAccount  {
@Id
    @GeneratedValue
    @Column(name = "numPersAccount")
    private int numPersAccount;
@Column(name = "statusPersAccount")
    private String statusPersAccount;
 @Column(name = "sumPersAccount")
    private int sumPersAccount;
   // private Set<Contract> contract;

    public PersonalAccount() {
    }

    public PersonalAccount(int numPersAccount,  String statusPersAccount,int sumPersAccount) {
        this.numPersAccount=numPersAccount;
        this.statusPersAccount = statusPersAccount;
        this.sumPersAccount=sumPersAccount;
        //this.contract = contract;

    }

    public int getNumPersAccount() {
        return numPersAccount;
    }

    public void setNumPersAccount(int numPersAccount) {
        this.numPersAccount = numPersAccount;
    }

    

    public String getStatusPersAccount() {
        return statusPersAccount;
    }

    public void setStatusPersAccount(String statusPersAccount) {
        this.statusPersAccount = statusPersAccount;
    }

    public void setSumPersAccount(int sumPersAccount) {
        this.sumPersAccount = sumPersAccount;
    }

    public int getSumPersAccount() {
        return sumPersAccount;
    }

//    public void setContract(Set contract) {
//        this.contract = contract;
//    }
//
//    public Set getContract() {
//        return contract;
//    }

    @Override
    public String toString() {
        return "PersonalAccount{" + "numPersAccount=" + numPersAccount + ", statusPersAccount=" + statusPersAccount + ", sumPersAccount=" + sumPersAccount + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.statusPersAccount);
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
        final PersonalAccount other = (PersonalAccount) obj;
       
        if (!Objects.equals(this.statusPersAccount, other.statusPersAccount)) {
            return false;
        }
        return true;
    }

}
