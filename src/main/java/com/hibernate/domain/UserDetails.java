package com.hibernate.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
public class UserDetails implements Serializable {
	
	public UserDetails(){
		super();
	}
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	int userId=0;
	String userName;
	String password;
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER,targetEntity=CardDetails.class)
	@JoinTable(name="USER_CARD",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="card_id"))
	@JsonIgnoreProperties("userDetails")
	Set<CardDetails> cardDetails = new HashSet<>();

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", password=" + password + ", cardDetails="
				+ cardDetails + "]";
	}
	
}
