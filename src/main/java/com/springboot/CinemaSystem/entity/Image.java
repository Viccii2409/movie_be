package com.springboot.CinemaSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "imageID")
	private long ID;
	private String link;
	private boolean type;

	@ManyToOne
	@JoinColumn(name = "movieID")
	private Movie movie;

}