package com.example.demo.uce.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.repository.IVueloRepository;
import com.example.demo.uce.repository.modelo.Vuelo;
import com.example.demo.uce.service.to.Asiento;
import com.example.demo.uce.service.to.vueloTo;


@Service
public class VueloServiceImpl implements IVueloService {
	@Autowired
	private IVueloRepository vueloRepository;

	@Override
	public void crearVuelo(Vuelo vuelo) {
		vueloRepository.crearVuelo(vuelo);
		
	}

	@Override
	public List<vueloTo> buscarVuelos(String origen,String destino, String fecha){

				
		return vueloRepository.buscarVuelos().stream().filter(x->x.getOrigen().equalsIgnoreCase(origen)&&x.getDestino().equalsIgnoreCase(destino)&&x.getFechaVuelo().equalsIgnoreCase(fecha)).map(x->new vueloTo(x.getNumero(),x.getValorAsiento(),x.getOrigen(),x.getDestino(),x.getCategoria(),x.getAvion().getNombreAvion())).collect(Collectors.toList());

	}

	@Override
	public Asiento buscarVuelo(Integer numeroVuelo) {
		Asiento as= new Asiento();
		Vuelo v=vueloRepository.buscarVueloDisponible(numeroVuelo);
		if(v==null) {
			as=null;
			return as;
		}else {
			as.setAsientoDisponible(v.getAsientosDisponibles());
			as.setAsientoOcupado(v.getAvion().getCapacidadAsientos()-v.getAsientosDisponibles());
			return as;
		}
		
	}

	@Override
	public Vuelo buscarVuelo2(Integer numeroVuelo) {
		
		return vueloRepository.buscarVueloDisponible(numeroVuelo);
	}

	@Override
	public void actualizarVuelo(Vuelo v) {
		vueloRepository.actualizarVuelo(v);
		
	}

	

}
