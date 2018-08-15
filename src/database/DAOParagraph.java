/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author osboxes
 */
@Entity
@Table(name = "paragraph")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DAOParagraph.findAll", query = "SELECT d FROM DAOParagraph d"),
    @NamedQuery(name = "DAOParagraph.findByParagraphid", query = "SELECT d FROM DAOParagraph d WHERE d.paragraphid = :paragraphid"),
    @NamedQuery(name = "DAOParagraph.findByParagraphorder", query = "SELECT d FROM DAOParagraph d WHERE d.paragraphorder = :paragraphorder")})
public class DAOParagraph implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PARAGRAPHID")
    private Integer paragraphid;
    @Column(name = "PARAGRAPHORDER")
    private String paragraphorder;

    public DAOParagraph() {
    }

    public DAOParagraph(Integer paragraphid) {
        this.paragraphid = paragraphid;
    }

    public Integer getParagraphid() {
        return paragraphid;
    }

    public void setParagraphid(Integer paragraphid) {
        this.paragraphid = paragraphid;
    }

    public String getParagraphorder() {
        return paragraphorder;
    }

    public void setParagraphorder(String paragraphorder) {
        this.paragraphorder = paragraphorder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paragraphid != null ? paragraphid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DAOParagraph)) {
            return false;
        }
        DAOParagraph other = (DAOParagraph) object;
        if ((this.paragraphid == null && other.paragraphid != null) || (this.paragraphid != null && !this.paragraphid.equals(other.paragraphid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.DAOParagraph[ paragraphid=" + paragraphid + " ]";
    }
    
}
