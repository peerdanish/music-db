package com.music.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.demo.entity.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long>{
	
}
