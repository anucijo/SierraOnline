package com.sierra.model.search;

public class SearchResponseModel {
	private String videoName;
	private String videoBytes;
	private int item_id;
	private double price;
	
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoBytes() {
		return videoBytes;
	}
	public void setVideoBytes(String videoBytes) {
		this.videoBytes = videoBytes;
	}

}
