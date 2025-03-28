package com.sample.spring.boot.SpringBootJWT.payload.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {

	private Long id;
	private String username;
	private String email;
	private List<String> roles;
}
