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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
public class CardDetails implements Serializable {

	public CardDetails(){
		super();
	}
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "card_id")
	int cardId=0;
	String cardType;
	String cardName;
	String status;
	int cvv;
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, targetEntity=UserDetails.class)
	@JoinTable(name="USER_CARD",joinColumns=@JoinColumn(name="card_id"),inverseJoinColumns=@JoinColumn(name="user_id"))
//	@JsonIgnoreProperties("cardDetails")
	Set<UserDetails> userDetails  = new HashSet<>();
	@Override
	public String toString() {
		return "CardDetails [cardId=" + cardId + ", cardType=" + cardType + ", cardName=" + cardName + ", status="
				+ status + ", cvv=" + cvv + ", userDetails=" + userDetails + "]";
	}
	
}
