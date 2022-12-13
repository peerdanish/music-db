package com.music.demo.service;

import java.util.List;

import com.music.demo.payload.AlbumDto;


public interface AlbumService {
	AlbumDto saveAlbum(AlbumDto albumDto);
	List<AlbumDto> getAllAlbums();
}
