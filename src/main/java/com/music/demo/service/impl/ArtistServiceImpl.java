package com.music.demo.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.music.demo.entity.Album;
import com.music.demo.entity.Artist;
import com.music.demo.payload.ArtistDto;
import com.music.demo.repository.AlbumRepository;
import com.music.demo.repository.ArtistRepository;
import com.music.demo.service.ArtistService;


@Service
public class ArtistServiceImpl implements ArtistService{


	private ArtistRepository artistRepository;
	private AlbumRepository albumRepository;
	private ModelMapper mapper;

	// constructor injection
	public ArtistServiceImpl(ArtistRepository artistRepository, AlbumRepository albumRepository, ModelMapper mapper) {
		this.artistRepository = artistRepository;
		this.albumRepository = albumRepository;
		this.mapper = mapper;
	}


	@Override
	public ArtistDto saveArtist(Long albumId, ArtistDto artistDto) {
		// if albumId is null, then create new artist accordingly
		if(albumId == null){
			Artist artist = mapArtist(artistDto);
			artistRepository.save(artist);
			return mapDto(artist);
		}

		// when albumId is not null, then create new artist and add the album
		Album album = albumRepository.findById(albumId).orElseThrow(() -> new RuntimeException("Album not found"));
		album = albumRepository.findById(albumId).get();

		Artist artist = mapArtist(artistDto);
		artist.getAlbums().add(album);

		artistRepository.save(artist);
		
		return mapDto(artist);
	}

	@Override
	public ArtistDto getArtist(Long id) {
		Artist artist = artistRepository.findById(id).orElseThrow(() -> new RuntimeException("Artist not found"));
		return mapDto(artist);
	}

	
	@Override
	public List<ArtistDto> getAllArtist() {
		List<Artist> artistList = artistRepository.findAll();
		List<ArtistDto> result = artistList.stream().map( (item) -> mapDto(item)).collect(Collectors.toList());
		return result;
	}
	

	@Override
	public ArtistDto addAlbumToArtist(Long artistId, Long albumId) {
		Artist artist = artistRepository.findById(artistId).orElseThrow(() -> new RuntimeException("Artist not found"));
		Album album = albumRepository.findById(albumId).orElseThrow(() -> new RuntimeException("Album not found"));
		artist.getAlbums().add(album);
		Artist result = artistRepository.save(artist);
		return mapDto(result);
	}

	@Override
	public ArtistDto artistByMaxAlbum() {
		List<Artist> artistList = artistRepository.findAll();
		Artist artist = artistList.stream().max((a1, a2) -> a1.getAlbums().size() - a2.getAlbums().size()).get();
		return mapDto(artist);
	}


	// map to dto
	private ArtistDto mapDto(Artist artist)
	{
		ArtistDto artistDto = mapper.map(artist, ArtistDto.class);
		return artistDto;
	}

	// map to genre
	private Artist mapArtist(ArtistDto artistDto)
	{
		Artist artist = mapper.map(artistDto, Artist.class);
		return artist;
	}

}

