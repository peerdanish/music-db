package com.music.demo.payload;

import java.util.List;

import com.music.demo.entity.Album;

import lombok.Data;

@Data
public class ArtistDto {
	private Long id;
	private String name;
	private List<Album> albums;
	// private Long albumId; 
}
