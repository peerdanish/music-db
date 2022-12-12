package com.music.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.demo.payload.AlbumDto;
import com.music.demo.service.AlbumService;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {
	private AlbumService albumService;

	public AlbumController(AlbumService albumService) {
		this.albumService = albumService;
	}

	@PostMapping
	public ResponseEntity<AlbumDto> saveAlbum(@RequestBody AlbumDto albumDto) {
		
		return new ResponseEntity<>(albumService.saveAlbum(albumDto), HttpStatus.CREATED);
	}
	
	
}
