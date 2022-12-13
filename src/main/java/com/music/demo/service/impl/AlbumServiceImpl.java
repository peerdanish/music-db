package com.music.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.music.demo.entity.Album;
import com.music.demo.exception.ResourceNotFoundException;
import com.music.demo.payload.AlbumDto;
import com.music.demo.repository.AlbumRepository;
import com.music.demo.repository.GenreRepository;
import com.music.demo.service.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService{

	AlbumRepository albumRepository;
	ModelMapper mapper;
	GenreRepository genreRepository;

	Logger logger = LoggerFactory.getLogger(GenreServiceImpl.class);


	// constructor injection
	public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, GenreRepository genreRepository) {
		this.albumRepository = albumRepository;
		this.mapper = modelMapper;
		this.genreRepository = genreRepository;
	}


	@Override
	public AlbumDto saveAlbum(AlbumDto albumDto) {
		// check if genre exists
		genreRepository.findById(albumDto.getGenreId()).orElseThrow(() -> new ResourceNotFoundException("Genre", "id", albumDto.getGenreId()));
		//map and save to db
		Album album = mapAlbum(albumDto);
		albumRepository.save(album);
		return mapDto(album);
	}
	
	@Override
	public List<AlbumDto> getAllAlbums() {
		List<Album> albumList = albumRepository.findAll();

		List<AlbumDto> result = albumList.stream().map( (item) -> mapDto(item)).collect(Collectors.toList());

		return result;
	}



	// map to dto
	private AlbumDto mapDto(Album album)
	{
		AlbumDto albumDto = mapper.map(album, AlbumDto.class);
		return albumDto;
	}

	// map to genre
	private Album mapAlbum(AlbumDto albumDto)
	{
		Album album = mapper.map(albumDto, Album.class);

		return album;
	}


	
}
