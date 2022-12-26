package com.music.demo.payload;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data

public class GenreDto {
	private Long id;
	@NotBlank(message = "Name is required")
	private String name;
}
