package com.example.domain;

import lombok.NoArgsConstructor;

import lombok.ToString;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FilesVO {
	private Long bno;
	private String fileName;
	private String filePath;
}
