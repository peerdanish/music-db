package com.music.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.music.demo.entity.Genre;
import com.music.demo.exception.ResourceNotFoundException;
import com.music.demo.payload.GenreDto;
import com.music.demo.repository.GenreRepository;
import com.music.demo.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService{
	private GenreRepository genreRepository;
	private ModelMapper mapper;

	Logger logger = LoggerFactory.getLogger(GenreServiceImpl.class);


	public GenreServiceImpl(GenreRepository genreRepository, ModelMapper mapper) {
		this.genreRepository = genreRepository;
		this.mapper = mapper;
	}

	@Override
	public List<GenreDto> getAllGenre() {
		List<Genre> genreList = genreRepository.findAll();
		List<GenreDto> result = genreList.stream().map( (item) -> mapDto(item)).collect(Collectors.toList());
		return result;
	}
	

	@Override
	public GenreDto getGenreById(Long id) {
		Genre genre = genreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre", "id", id));

		GenreDto genreDto = mapDto(genre);
		return genreDto;
	}



	// map to dto
	private GenreDto mapDto(Genre genre)
	{
		GenreDto genreDto = mapper.map(genre, GenreDto.class);
		return genreDto;
	}

	// map to genre
	// private Genre mapGenre(GenreDto genreDto)
	// {
	// 	Genre genre = mapper.map(genreDto, Genre.class);

	// 	return genre;
	// }

	
}
