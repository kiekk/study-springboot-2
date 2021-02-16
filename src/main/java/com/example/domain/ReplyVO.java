package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReplyVO {
	/* ±×·ì ¹øÈ£ */
	private int groupNo;
	/* ±×·ì Á¤·Ä ¼ø¼­ */
	private int groupOrd;
	/* ±íÀÌ */
	private int depth;
	/* ´ñ±Û ¹øÈ£ */
	private Long rno;
	/* °Ô½Ã±Û ¹øÈ£ */
	private Long bno;
	/* ´ñ±Û ³»¿ë */
	private String reply;
	/* ´ñ±Û ÀÛ¼ºÀÚ */
	private String replyer;
	/* ´ñ±Û ÀÛ¼ºÀÏ */
	private String regDate;
	/* ºÎ¸ð´ñ±Û */
	private Long parentRno;
}
