package com.example.domain;

import lombok.NoArgsConstructor;

import lombok.ToString;

import lombok.Setter;
import lombok.AccessLevel;
import lombok.Getter;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserVO {
	/* 아이디 */
	private String id;
	/* 비밀번호 */
	private String password;
	/* 이름 */
	private String name;
	/* 전화번호 */
	private String phone;
	/* 이메일 */
	private String email;
	/* 우편 번호 */
	private String zipcode;
	/* 주소 */
	private String address;
	/* 상세 주소 */
	private String addressDetail;
	/* 참고 항목 */
	private String addressEtc;
	/* 권한 */
	private Role userRole;
}
