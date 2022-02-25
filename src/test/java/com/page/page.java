package com.page;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.models.models;

public class page {


	WebDriver driver;	
	models ConsultaClaseMetodosDeConsulta;
	
	
	// Se usa el driver de chrome y se abre el sitio de la prueba
	@Before
	public void setUp() throws Exception {

		ConsultaClaseMetodosDeConsulta = new models(driver);
		driver = ConsultaClaseMetodosDeConsulta.chromeDriverConnection();
		driver.manage().window().maximize();
		driver.get("https://www.latamairlines.com/co/es");
		Thread.sleep(2000);
	}

	// Se genera la ejecución del test
	@Test
	public void test_consultar_vuelo() throws InterruptedException {
		
		//Se declaran variables de consulta
		String desde ="bogota";
		String hacia ="cartagena";
		int fechainicial=12;
		int mes =3;
		int fecharegreso =18;		
			
		//Se ejecutan los métodos de la clase Métodos de consulta
		ConsultaClaseMetodosDeConsulta.OrigenDestino(driver, desde, hacia);
		Thread.sleep(2000);
		ConsultaClaseMetodosDeConsulta.FechasDeseadas(driver,fechainicial, mes, fecharegreso);											
		ConsultaClaseMetodosDeConsulta.SeleccionYBusquedaVuelos(driver);
		assertTrue(ConsultaClaseMetodosDeConsulta.ValidacionHora(driver));	
		assertTrue(ConsultaClaseMetodosDeConsulta.ValidarPrecio(driver));
		assertTrue(ConsultaClaseMetodosDeConsulta.TotalResultados(driver));
		ConsultaClaseMetodosDeConsulta.MetodoVueloSelec(driver);
		
	}

	
}
