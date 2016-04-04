/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fairhaven.db.entities;



// Import log4j class
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.apache.log4j.Logger;

/**
 *
 * @author Sam
 */
@Entity
@Table(name = "faq")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faq.findAll", query = "SELECT f FROM Faq f"),
    @NamedQuery(name = "Faq.findById", query = "SELECT f FROM Faq f WHERE f.id = :id"),
    @NamedQuery(name = "Faq.findByQuestion", query = "SELECT f FROM Faq f WHERE f.question = :question"),
    @NamedQuery(name = "Faq.findByAnswer", query = "SELECT f FROM Faq f WHERE f.answer = :answer")})
public class Faq implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "question")
    private String question;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2500)
    @Column(name = "answer")
    private String answer;
    @JoinTable(name = "faq_links", joinColumns = {
        @JoinColumn(name = "faq_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "link_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Link> linkCollection;

    private static final Logger logger = Logger.getLogger(Faq.class.getName());

    /**
     *
     */
    public Faq() {
    }

    /**
     *
     * @param id
     */
    public Faq(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param question
     * @param answer
     */
    public Faq(Integer id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getQuestion() {
        return question;
    }

    /**
     *
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     *
     * @return
     */
    public String getAnswer() {
        return answer;
    }

    /**
     *
     * @param answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Link> getLinkCollection() {
        return linkCollection;
    }

    /**
     *
     * @param linkCollection
     */
    public void setLinkCollection(Collection<Link> linkCollection) {
        this.linkCollection = linkCollection;
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
        if (!(object instanceof Faq)) {
            return false;
        }
        Faq other = (Faq) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fairhaven.db.entities.Faq[ id=" + id + " ]";
    }

}
