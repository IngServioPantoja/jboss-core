package test;


import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.com.sp.domain.Persona;
import co.com.sp.service.PersonaServiceRemote;

public class ClientePersonaService {

	public static void main(String[] args) {

		try {
			System.out.println("Iniciando llamada al EJB desde el cliente\n");
			Context jndi = new InitialContext();

			//PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/jboss-core/personaService!co.com.sp.service.PersonaService");

			PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/jboss-core/personaService!co.com.sp.service.PersonaService");

			List<Persona> personas = personaService.listarPersonas();

			for (Persona persona : personas) {
				System.out.println(persona);
			}
			System.out.println("\nFin llamada al EJB desde el cliente");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
