package com.music.demo.payload;

import java.util.Set;

import com.music.demo.entity.Artist;

import lombok.Data;

@Data
public class AlbumDto {
	private Long id;
	private String name;
	private Long genreId;
	private Set<Artist> artists ;
	
}
