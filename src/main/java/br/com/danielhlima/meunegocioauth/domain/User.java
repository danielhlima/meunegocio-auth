package br.com.danielhlima.meunegocioauth.domain;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import br.com.danielhlima.meunegocioauth.domain.enums.UserProfile;

import java.io.Serializable;
import java.util.HashSet;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 3, message="Name should have at least 3 characters")
	private String name;
	
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	private String validationCode;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PROFILES")
	private Set<Integer> profiles = new HashSet<>();
	
	@ElementCollection
	@CollectionTable(name="PHONES")
	private Set<String> phones = new HashSet<>();
	
	

	public User() {
		super();
	}

	public User(Integer id, String name, String email, String validationCode, Set<String> phones, UserProfile profile) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.validationCode = validationCode;
		this.phones = phones;
		addProfile(profile);
	}
	
	public void addProfile(UserProfile profile) {
		profiles.add(profile.getCod());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getValidationCode() {
		return validationCode;
	}

	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}

	public Set<Integer> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<Integer> profiles) {
		this.profiles = profiles;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phones == null) ? 0 : phones.hashCode());
		result = prime * result + ((profiles == null) ? 0 : profiles.hashCode());
		result = prime * result + ((validationCode == null) ? 0 : validationCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phones == null) {
			if (other.phones != null)
				return false;
		} else if (!phones.equals(other.phones))
			return false;
		if (profiles == null) {
			if (other.profiles != null)
				return false;
		} else if (!profiles.equals(other.profiles))
			return false;
		if (validationCode == null) {
			if (other.validationCode != null)
				return false;
		} else if (!validationCode.equals(other.validationCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", validationCode=" + validationCode
				+ ", profiles=" + profiles + ", phones=" + phones + "]";
	}
	
	
}
