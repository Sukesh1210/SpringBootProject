package com.tyss.jspiders.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "financials")
public class Financial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer financialId;
	private Double budget;
	private Double revenue;
	private String unit;
	private String currency;

	@OneToOne(mappedBy = "financial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Movie movie;
}
