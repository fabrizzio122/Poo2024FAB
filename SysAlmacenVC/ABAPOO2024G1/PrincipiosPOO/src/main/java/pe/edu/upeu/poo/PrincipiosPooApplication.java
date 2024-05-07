package pe.edu.upeu.poo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.upeu.poo.cobjeto.Persona;

@SpringBootApplication
public class PrincipiosPooApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrincipiosPooApplication.class, args);
                Persona person=new Persona(); //aplicando Objetos //para usar sus atributos y acciones
                person.setNombre("Belen");
                person.edad=20;
                person.setEdad(19);
                System.out.println("Yo soy " + person.getNombre()
                + " y tengo " + person.getEdad() + " años");
                person.saludo();
	}

}
