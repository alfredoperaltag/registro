package com.example.registro.implementaciones;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.registro.entidades.Registro;
import com.example.registro.repositorios.RegistroRepository;
import com.example.registro.servicios.RegistroService;

@Service("RegistroService")
public class RegistroServiceImpl implements RegistroService {
private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier ("RegistroRepository")
	private RegistroRepository registroRepository;
	
	@Override
	public boolean agregarRegistro(Registro registro) {
		String k0="";
		String k1="0";
		String resultado = "";
		try{
			String cuenta = registro.getCuenta();
			String[] grupos = cuenta.split("-");
			String[]limites = new String[grupos.length];
			int[]limiteInt = new int[grupos.length];
			
			for (int i = 0; i < grupos.length; i++) {
				limites[i]="";
				for(int j = 0;j<grupos[i].length();j++) {
					limites[i] += "9";	
				}
				limiteInt[i]= Integer.parseInt(limites[i]);
				if(i!=0) {
					for(int k=0;k<limiteInt[i]+1;k++) {
							k0=Integer.toString(k);
							log.info(k0);
					}
					resultado=k0;
				}else {
					for(int k=1;k<limiteInt[i]+1;k++) {
						k1=Integer.toString(k);
						resultado=k1;
						
					}
				}
				resultado+=resultado;
			}
			
			return true;
        }catch (Exception ex){
            log.error("ERROR: "+ex.getMessage());
            return false;
        }
	}
}