package com.music.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.demo.payload.ArtistDto;
import com.music.demo.service.ArtistService;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {
	
	private ArtistService artistService;


	public ArtistController(ArtistService artistService) {
		this.artistService = artistService;
	}
	// post request for artist with albumId
	@PostMapping("/album/{albumId}")
	public ResponseEntity<ArtistDto> saveArtist(@PathVariable Long albumId, @RequestBody ArtistDto artistDto) {
		return new ResponseEntity<>(artistService.saveArtist(albumId,artistDto), HttpStatus.CREATED);
	}

	// post request for artist without albumId
	@PostMapping()
	public ResponseEntity<ArtistDto> saveArtist(@RequestBody ArtistDto artistDto) {
		return new ResponseEntity<>(artistService.saveArtist(null,artistDto), HttpStatus.CREATED);
	}
	// get single artist
	@GetMapping("/{id}")
	public ResponseEntity<ArtistDto> getArtist(@PathVariable Long id) {
		return new ResponseEntity<>(artistService.getArtist(id), HttpStatus.OK);
	}
	// get all artists
	@GetMapping
	public ResponseEntity<?> getAllArtist() {

		return new ResponseEntity<>(artistService.getAllArtist(), HttpStatus.OK);
	}

	// map album to artist
	@PostMapping("/{artistId}/albums/{albumId}")
	public ResponseEntity<?> addAlbumToArtist(@PathVariable Long artistId, @PathVariable Long albumId) {
		return new ResponseEntity<>(artistService.addAlbumToArtist(artistId, albumId), HttpStatus.OK);
	}

	// get artist with max albums
	@GetMapping("/max")
	public ResponseEntity<?> artistByMaxAlbum() {
		return new ResponseEntity<>(artistService.artistByMaxAlbum(), HttpStatus.OK);
	}

}
