package br.com.danielhlima.meunegocioauth.domain.enums;

public enum UserProfile {

	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENT"),
	SHOPKEEPER_FREE(3, "ROLE_SHOPKEEPER_FREE"),
	SHOPKEEPER_PRO(4, "ROLE_SHOPKEEPER_PRO");
	
	private int cod;
	private String description;
	
	private UserProfile(int cod, String descricao) {
		this.cod = cod;
		this.description = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescription () {
		return description;
	}
	
	public static UserProfile toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (UserProfile x : UserProfile.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
