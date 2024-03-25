package com.batch.model;

public class PostMember {

		private String name, usn, sem;
		private float sgpa;  

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUsn() {
			return usn;
		}

		public void setUsn(String usn) {
			this.usn = usn;
		}

		public String getSem() {
			return sem;
		}

		public void setSem(String sem) {
			this.sem = sem;
		}

		public float getSgpa() {
			return sgpa;
		}

		public void setSgpa(float sgpa) {
			this.sgpa = sgpa;
		}

		public PostMember(String name, String usn, String sem, float sgpa) {
			super();
			this.name = name;
			this.usn = usn;
			this.sem = sem;
			this.sgpa = sgpa;
		}

				
}
