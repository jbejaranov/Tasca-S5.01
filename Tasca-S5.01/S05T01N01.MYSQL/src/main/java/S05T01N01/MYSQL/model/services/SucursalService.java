package S05T01N01.MYSQL.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import S05T01N01.MYSQL.model.domain.Sucursal;
import S05T01N01.MYSQL.model.dto.SucursalDTO;
import S05T01N01.MYSQL.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalService {

	@Autowired
	private SucursalRepository sucursalRepository;

	public List<SucursalDTO> mostraSucursals() {

		List<SucursalDTO> sucursalsDTO = new ArrayList<>();

		for (Sucursal sucursal : sucursalRepository.findAll()) {
			sucursalsDTO.add(CanviaASucursalDTO(sucursal));
		}
		return sucursalsDTO;
	}

	public SucursalDTO desaSucursal(SucursalDTO sucursalDTO) {
		Sucursal sucursal = canviaASucursal(sucursalDTO);
		return CanviaASucursalDTO(sucursalRepository.save(sucursal));
	}

	public SucursalDTO mostraSucursal(Integer id) {
		Optional<Sucursal> optionalSucursal = sucursalRepository.findById(id);
		Sucursal sucursal;
		sucursal = optionalSucursal.get();
		SucursalDTO sucursalDTO = CanviaASucursalDTO(sucursal);

		return sucursalDTO;
	}

	public void eliminaSucursal(Integer id) {
		sucursalRepository.deleteById(id);
	}

	// Metodes per canviar de entitat
	public Sucursal canviaASucursal(SucursalDTO sucursalDTO) {
		Sucursal sucursal = new Sucursal();
		sucursal.setPk_SucursalID(sucursalDTO.getPk_SucursalID());
		sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
		sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
		return sucursal;
	}

	public SucursalDTO CanviaASucursalDTO(Sucursal sucursal) {
		SucursalDTO sucursalDTO = new SucursalDTO();
		sucursalDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
		sucursalDTO.setNomSucursal(sucursal.getNomSucursal());
		sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());
		sucursalDTO.setTipusSucursal(sucursal.getPaisSucursal());
		return sucursalDTO;
	}
}
