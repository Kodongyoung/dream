package com.example.demo.chat.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "chats")
public class Chat {
		
	
	@Id
	@GeneratedValue
	@Column(name = "board_no")
	private long boardNo; // 특정언어 Key  

	@Column(name ="message") // 
	private String message;

	@Column(name = "keyboard") // 대답    
	private String keyboard;

	@Column(name = "regdate") // 시간, 날짜 
	private Date regdate;

		
	@Builder
	public Chat(Date regdate, String message, String keyboard, long boardNo) {
		this.boardNo = boardNo;
		this.regdate = regdate;
		this.message = message;
		this.keyboard = keyboard;

	}
}

