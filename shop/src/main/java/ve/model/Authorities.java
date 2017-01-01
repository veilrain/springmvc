
package ve.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Authorities {
	
	@Id
	@GeneratedValue
	private int authoritiesId;
	private String username;
	private String authority;
	/**
	 * @return the authoritiesId
	 */
	public int getAuthoritiesId() {
		return authoritiesId;
	}
	/**
	 * @param authoritiesId the authoritiesId to set
	 */
	public void setAuthoritiesId(int authoritiesId) {
		this.authoritiesId = authoritiesId;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}
	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}
