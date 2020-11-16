package org.example.demo.ticket.webapp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.example.demo.ticket.business.manager.ManagerFactory;
import org.example.demo.ticket.business.manager.ProjetManager;
import org.example.demo.ticket.business.manager.TicketManager;
import org.example.demo.ticket.webapp.rest.resource.AbstractResource;

public class DependencyInjectionListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// creation de l'instance de ManagerFactory
		ManagerFactory vManagerFactory = new ManagerFactory();
	
		// On ajoute l'injection des Manager dans la ManagerFactory
		vManagerFactory.setProjetManager(new ProjetManager());
		vManagerFactory.setTicketManager(new TicketManager());
		// Injection de l"instance de managerFactory dans la classe AbstractResource
		AbstractResource.setManagerFactory (vManagerFactory);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
