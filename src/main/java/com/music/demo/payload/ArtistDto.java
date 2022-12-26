package com.music.demo.payload;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.music.demo.entity.Album;

import lombok.Data;

@Data
public class ArtistDto {
	private Long id;
	@NotBlank(message = "Name is required")
	private String name;
	private List<Album> albums;
	// private Long albumId; 
}
