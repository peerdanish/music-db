package com.music.demo.service;

import java.util.List;

import com.music.demo.payload.GenreDto;

public interface GenreService {
	List<GenreDto> getAllGenre();
	GenreDto getGenreById(Long id);

}
