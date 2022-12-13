package com.music.demo.service;

import java.util.List;

import com.music.demo.payload.ArtistDto;

public interface ArtistService {
	ArtistDto saveArtist(Long albumId, ArtistDto artistDto);
	ArtistDto getArtist(Long id);
	List<ArtistDto> getAllArtist();
	ArtistDto addAlbumToArtist(Long artistId, Long albumId);
	ArtistDto artistByMaxAlbum();
}
