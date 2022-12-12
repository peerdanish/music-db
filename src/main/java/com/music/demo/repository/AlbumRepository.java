package com.music.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.demo.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{
	
}
