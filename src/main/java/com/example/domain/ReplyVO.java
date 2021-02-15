package com.example.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReplyVO {
	/* 그룹 번호 */
	private int groupNo;
	/* 그룹 정렬 순서 */
	private int groupOrd;
	/* 깊이 */
	private int depth;
	/* 댓글 번호 */
	private Long rno;
	/* 게시글 번호 */
	private Long bno;
	/* 댓글 내용 */
	private String reply;
	/* 댓글 작성자 */
	private String replyer;
	/* 댓글 작성일 */
	private String regDate;
}
