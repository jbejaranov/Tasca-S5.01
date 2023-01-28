package S05T01N01.MYSQL.model.domain;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;
@Entity // Entitat amb la que tractarem
@Table(name = "Sucursals") // Definim nom de la taula
@Getter
@Setter
public class Sucursal {

	@Id // Definim quina serà la primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indiquem que l'Id serà incrementable
	@Column(name = "ID")
	private Integer pk_SucursalID;

	@Column(name = "Nom")
	private String nomSucursal;

	@Column(name = "Pais")
	private String paisSucursal;

	public Sucursal() {
		super();

	}

	public Sucursal(String nomSucursal, String paisSucursal) {
		super();
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
	}
}