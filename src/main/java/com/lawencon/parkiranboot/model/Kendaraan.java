package com.lawencon.parkiranboot.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "kendaraan_uk", columnNames = { "noPol", "tglin" }) })
public class Kendaraan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String noPol;
	private String jenisKendaraan;
	private LocalDate tglIn;
	private LocalDate tglOut;
	private String status;

	public String getNoPol() {
		return noPol;
	}

	public void setNoPol(String noPol) {
		this.noPol = noPol;
	}

	public String getJenisKendaraan() {
		return jenisKendaraan;
	}

	public void setJenisKendaraan(String jenisKendaraan) {
		this.jenisKendaraan = jenisKendaraan;
	}

	public LocalDate getTglIn() {
		return tglIn;
	}

	public void setTglIn(LocalDate tglIn) {
		this.tglIn = tglIn;
	}

	public LocalDate getTglOut() {
		return tglOut;
	}

	public void setTglOut(LocalDate tglOut) {
		this.tglOut = tglOut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
