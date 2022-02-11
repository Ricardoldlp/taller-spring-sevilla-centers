package org.springframework.samples.petclinic.owner;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
    @Column(name = "username")
    @NotEmpty
    private String username;

    @Column(name = "password")
    @NotEmpty
    private String password;
    

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private Date fecha_creacion;


    @OneToOne(fetch = FetchType.LAZY)
    private Owner owner;
    
    public Owner getOwner() {
    return owner;
    }
    
    public void setOwner(Owner owner) {
    this.owner = owner;
    }

	public User() { }
}
