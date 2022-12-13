package com.music.demo.payload;

import java.util.ArrayList;
import java.util.List;

import com.music.demo.entity.Album;

import lombok.Data;

@Data
public class ArtistDto {
	private Long id;
	private String name;
	private List<Album> albums = new ArrayList<Album>();
	// private Long albumId; 
}
