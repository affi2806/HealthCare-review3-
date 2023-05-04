package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Patient {

		@Id
		private int bedno;
		private String medicine;
		private String food;
		private String chechdate;
		public int getBedno() {
			return bedno;
		}
		public void setBedno(int bedno) {
			this.bedno = bedno;
		}
		public String getMedicine() {
			return medicine;
		}
		public void setMedicine(String medicine) {
			this.medicine = medicine;
		}
		public String getFood() {
			return food;
		}
		public void setFood(String food) {
			this.food = food;
		}
		public String getChechdate() {
			return chechdate;
		}
		public void setChechdate(String chechdate) {
			this.chechdate = chechdate;
		}
		

}
