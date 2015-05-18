/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;
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
@Table(name="contract_service")
public class Contract_Service {
    @Id
    @GeneratedValue
    @Column(name = "idcontract_service")
private int idcontract_service;
    @JoinColumn(name = "numContract", referencedColumnName = "numContract")
    @ManyToOne(optional = false)
    private Contract contract;
    @JoinColumn(name = "idService", referencedColumnName = "idService")
    @ManyToOne(optional = false)
          private Service service;
    public Contract_Service() {
    }

    public int getIdcontract_service() {
        return idcontract_service;
    }

    public void setIdcontract_service(int idcontract_service) {
        this.idcontract_service = idcontract_service;
    }

    public Contract_Service( int idcontract_service,Contract contract,Service service) {
       this.idcontract_service=idcontract_service;
       this.contract=contract;
        this.service =  service;
  
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.contract != null ? this.contract.hashCode() : 0);
        hash = 97 * hash + (this.service != null ? this.service.hashCode() : 0);
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
        final Contract_Service other = (Contract_Service) obj;
        if (this.contract != other.contract && (this.contract == null || !this.contract.equals(other.contract))) {
            return false;
        }
        if (this.service != other.service && (this.service == null || !this.service.equals(other.service))) {
            return false;
        }
        return true;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Contract getContract() {
        return contract;
    }

    public Service getService() {
        return service;
    }

    
}
