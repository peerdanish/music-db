package com.music.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.demo.payload.GenreDto;
import com.music.demo.service.GenreService;

@RestController
@RequestMapping("/api/genre")
public class GenreController {
	
	private GenreService genreService;

	public GenreController(GenreService genreService) {
		this.genreService = genreService;
	}

	@GetMapping
	public List<GenreDto> getAllGenre(){
		return genreService.getAllGenre();
	}

	@GetMapping("/{id}")
	public GenreDto getGenreById(@PathVariable Long id) {
		return genreService.getGenreById(id);
	}
	
}
