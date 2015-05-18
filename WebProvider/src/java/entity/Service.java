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
@Table(name="service")
public class Service  {
     @Id
    @GeneratedValue
    @Column(name = "idService")
private int idSevice;
         @Column(name = "descripService")
    private String descripService;
          @Column(name = "priceService")
    private double priceService;
            @Column(name = "note") 
    private String note;
  //private Set<Contract> contract = new HashSet();
    public Service() {
    }

    public Service(int idService, String descripService, double priceService, String note) {
       this.idSevice=idService;
        this.descripService = descripService;
        this.priceService= priceService;
        this. note=  note;
    }

    public int getIdSevice() {
        return idSevice;
    }

    public void setIdSevice(int idSevice) {
        this.idSevice = idSevice;
    }

    public String getDescripService() {
        return descripService;
    }

    public void setDescripService(String descripService) {
      
        this.descripService = descripService;
    }

    public double getPriceService() {
        return  priceService;
    }

    public void setPriceService(double priceService) {
           System.out.println(priceService);
        this. priceService =  priceService;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idSevice;
        hash = 67 * hash + (this.descripService != null ? this.descripService.hashCode() : 0);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.priceService) ^ (Double.doubleToLongBits(this.priceService) >>> 32));
        hash = 67 * hash + (this.note != null ? this.note.hashCode() : 0);
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
        final Service other = (Service) obj;
        if (this.idSevice != other.idSevice) {
            return false;
        }
        if ((this.descripService == null) ? (other.descripService != null) : !this.descripService.equals(other.descripService)) {
            return false;
        }
        if (Double.doubleToLongBits(this.priceService) != Double.doubleToLongBits(other.priceService)) {
            return false;
        }
        if ((this.note == null) ? (other.note != null) : !this.note.equals(other.note)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service{" + "idSevice=" + idSevice + ", descripService=" + descripService + ", priceService=" + priceService + ", note=" + note + '}';
    }

   
}
