package lms.model.entity;
import java.time.LocalDate;

public class Librarian {
		private int id;
		private String username;
		private String password;
		private String nrcno;
		private String phone;
		private LocalDate created_at;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getNrcno() {
			return nrcno;
		}
		public void setNrcno(String nrcno) {
			this.nrcno = nrcno;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public LocalDate getCreated_at() {
			return created_at;
		}
		public void setCreated_at(LocalDate created_at) {
			this.created_at = created_at;
		}
		

}
