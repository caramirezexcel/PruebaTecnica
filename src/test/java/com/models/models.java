package com.models;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.baseTest.baseTest;

public class models extends baseTest {

	//Metodo driver navegador
	public models(WebDriver driver) {
		
		super(driver);
	}
	
		
	// Localización de elementos desde hasta del vuelo
	By TextoOrigen = By.id("txtInputOrigin_field");
	By TextoDestino = By.id("txtInputDestination_field");
	By listaTexto= By.xpath("//button[starts-with(@id,'btnItemAutoComplete')]");
	
	
	// Metodo de ingreso de datos de Origen y destino de vuelo
	public void OrigenDestino(WebDriver driver,String destino,String lugar) throws InterruptedException {
     	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(TextoOrigen));
		// escribe en el campo de origen de vuelo
		DarEnter(TextoOrigen);
		Escribir(destino, TextoOrigen);
		DarEnter(listaTexto);
	
				
		// escribe en el campo de destino de vuelo
		Thread.sleep(2000);
		Escribir(lugar, TextoDestino);
		Thread.sleep(2000);
		DarEnter(listaTexto);
		}

	// Localizo los elementos de fechas
		By Calendario = By.id("departureDate");
		By MesSiguiente = By.id("arrivalDate");
		
	
	// Metodo para seleccionar la fecha de vuelo mas regreso	
	  public void FechasDeseadas(WebDriver driver,int dia,int mes, int diaregreso) throws InterruptedException {
		  
		  Thread.sleep(2000);
		  DarClic(Calendario);
		  Escribir("//*[@id=\"calendarContainer\"]/div/div/div/div/div[2]/div[2]/div/div[3]/div/table/tbody/tr[4]/td[2]", Calendario);
		  
		  
		 /*
		  Thread.sleep(2000);
		  DarClic(MesSiguiente);
		  By diasalida = By.xpath("//td[contains(@aria-label,'Elija martes, 1 de marzo de 2022 como su fecha de ida. Está disponible')]");                                                                                                            
		  List<WebElement> elementsalida = driver.findElements(diasalida);
		  elementsalida.get(0).click();	
		  int i=1;
		  while(i!=mes) {
			 			  
			  Thread.sleep(1000);
			  DarClic(MesSiguiente);
			  i++;
		  }
		  Thread.sleep(1000);
		  By diallegada =By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div[2]/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[2]/fieldset/div/div/div[2]/div/div[1]/div[12]/div[3]/div["+(diaregreso+1)+"]"); 
		  List<WebElement> elementsregreso = driver.findElements(diallegada);
		  elementsregreso.get(0).click();	  */
	  }
	  
		
	  	// Localización de elemento la cantidad de pasajeros
		By AgregarPasajeros = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[3]/fieldset/div/div[1]/div[1]/label/div/span/i");
		By ContinuarPasajeros = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[3]/fieldset/div/div[1]/div[2]/button");
		By BotonBusquedaVuelos = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div/div/section/div[3]/div[4]/div[1]/div/form/div/div[2]/div/div/div[3]/fieldset/div/div[4]/button");

	  //Metodo para seleccionar pasajeros y buscar opción de vuelos
	  public void SeleccionYBusquedaVuelos(WebDriver driver) throws InterruptedException {
		  
		  DarClic(AgregarPasajeros);
		  Thread.sleep(1000);		 
		  DarClic(ContinuarPasajeros);
		  DarClic(BotonBusquedaVuelos);	  
	  }

		// Localización de elementos pasarela de Avianca
		By FiltrarPorHora = By.xpath("/html/body/app-root/main/div/avail-page/div/avail-cont/avail-pres/div[1]/avail-header-pres/fixed-card-element/div[1]/div/div/div/button[1]");
		By FiltrarPorPrecio = By.xpath("/html/body/app-root/main/div/avail-page/div/avail-cont/avail-pres/div[1]/avail-header-pres/fixed-card-element/div[1]/div/div/div/button[2]");
		
	  //Metodo para validar que esta presenta la hora del vuelo
      public boolean ValidacionHora(WebDriver driver) throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, 20);
  		wait.until(ExpectedConditions.visibilityOfElementLocated(FiltrarPorHora));  	  
	      return EstaPresente(FiltrarPorHora);
	  }
	  
      public boolean ValidarPrecio(WebDriver driver) throws InterruptedException {
     	  
	      return EstaPresente(FiltrarPorPrecio);
	  }
      
      //Metodo de validación para la cantidad de resultados y la cantidad de detalles
      public boolean TotalResultados (WebDriver driver) throws InterruptedException {
    	 
    	  //Se ingresa a una lista, la cantidad de elementos web para saber su total
    	  List<WebElement> resultados = driver.findElements(By.xpath("//*[starts-with(@class,'select-cabin-button')]"));	  	  
    	  List<WebElement> detalle = driver.findElements(By.xpath("//*[starts-with(@class,'flight-detail-link')]"));	  
    	  HacerScroll(driver,FiltrarPorPrecio);
    	  if((resultados.size()>=detalle.size())) {
    		  System.out.println("total resultado: "+resultados.size()+" total detalles: "+detalle.size());
    		  return true;
    	  }   	  
    	  else
    		  return false;
      }
      
 
            
      //localizador de vueloseleccionado
      By VueloSelec = By.xpath("/html/body/app-root/main/div/avail-page/div/avail-cont/avail-pres/div[1]/avail-list-pres/expander-elem[1]/div/div[1]/div/div/div[2]/div[1]/button");
      By BotonVueloSelec = By.xpath("/html/body/app-root/main/div/avail-page/div/avail-cont/avail-pres/div[1]/avail-list-pres/expander-elem[1]/div[2]/div/cabin-choice-cont/cabin-choice-pres/div/div[1]/fare-comparison-table-cont/fare-comparison-table-pres/div/div[1]/div/div[3]/button");
      By prueba	=By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/upsell-switch-fare-selected-lightbox-cont/upsell-switch-fare-selected-lightbox-pres/div/div/button");
      
    //Metodo para vueloseleccionado
	  public void MetodoVueloSelec(WebDriver driver) throws InterruptedException {
		  
		  DarClic(VueloSelec);
		  Thread.sleep(2000);
		  DarClic(BotonVueloSelec);
		  Thread.sleep(2000);
		  DarClic(prueba);
		  Thread.sleep(2000);
	  }
      
}
