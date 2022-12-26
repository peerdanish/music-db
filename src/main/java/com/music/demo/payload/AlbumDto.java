package com.music.demo.payload;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.music.demo.entity.Artist;

import lombok.Data;

@Data
public class AlbumDto {
	private Long id;

	@NotBlank(message = "Name is mandatory")
	private String name;
	@NotNull(message = "GenreId is mandatory")
	private Long genreId;
	private Set<Artist> artists ;
	
}
