package com.example.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LikeVO {
	/* 게시글 번호 */
	private Long bno;
	/* 사용자 아이디 */
	/* 왜 writer로 했지..? */
	private String writer;
}
