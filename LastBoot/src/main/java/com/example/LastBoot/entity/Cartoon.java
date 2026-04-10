package com.example.LastBoot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cartoon {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String cartoonName;
	private String channelName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCartoonName() {
		return cartoonName;
	}
	public void setCartoonName(String cartoonName) {
		this.cartoonName = cartoonName;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	
}
