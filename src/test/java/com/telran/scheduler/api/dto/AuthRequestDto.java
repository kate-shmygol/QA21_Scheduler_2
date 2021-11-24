package com.telran.scheduler.api.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString

public class AuthRequestDto {

	String email;
	String password;
}
