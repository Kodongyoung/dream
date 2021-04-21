package com.example.demo.chat.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;



@Component
@Data
public class ChatDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private long boardNo;
	private String message;
	private String keyboard;
	private Date regdate;
}