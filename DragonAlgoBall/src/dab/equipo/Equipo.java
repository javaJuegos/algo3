package dab.equipo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import dab.personajes.Personaje;

public class Equipo {
	/*contiene a los personajes, y a su vez,  podria ser que los personajes contengan al equipo.
	 * asi por ejemplo para la habilidad de picollo y gohan podemos acceder a los personajes del equipo de
	 * forma rapida
	 */
	Map<String, Personaje> integrantes;
	private int cantidadEsferasDelDragon;
	private String nombreEquipo;
	
	public Equipo(String nombre){
		this.nombreEquipo = nombre;
		this.integrantes = new HashMap<String, Personaje>();
	}
	
	public String getNombreEquipo(){
		return this.nombreEquipo;
	}
	
	public int cantidadParticipantes(){
		return this.integrantes.size();
	}
	
	public void agregarParticipante(Personaje personaje){
		this.integrantes.put(personaje.getNombre(), personaje);
	}
	
	public void borrarParticipante(Personaje personaje){
		this.integrantes.remove(personaje.getNombre());
	}
	
	public int cantidadEsferasDelDragon(){
		return this.cantidadEsferasDelDragon;
	}
	
	public void agregarEsferaDelDragon(){
		this.cantidadEsferasDelDragon += 1;
	}
	
	public Collection<Personaje> obtenerPersonajes(){
		return this.integrantes.values();
	}
	
	public boolean existePersonajeEnEquipo(Personaje personaje){
		return this.integrantes.containsValue(personaje);
	}
	
	public Personaje obtenerPersonaje(String nombre){ //metodo para pruebas mas que nada
		Personaje personaje = this.integrantes.get(nombre);
		if(personaje == null) throw new RuntimeException("nombre incorrecto en obtener personaje" + nombre);
		return personaje;
	}	
}
