package com.ATM.demo.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="bank")
public class BankEntity extends BaseEntity implements Serializable{
	
	@Id
    @Column(name = "id",nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name="user_name")
	String userName;
	
	@Column(name="password")
	String password;
	
	

}
