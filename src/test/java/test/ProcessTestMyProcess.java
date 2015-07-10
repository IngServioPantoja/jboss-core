package test;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Persistence;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.activiti.engine.ProcessEngine;

import co.com.sp.service.PersonaService;

public class ProcessTestMyProcess {

	private String filename = "B:/Desarrollo Java/Proyectos/jboss-core/src/main/resources/diagrams/SimpleLeaveProcess.bpmn";

	
	@Test  
	public void startProcess() throws Exception {
		
		// Bootstrap
		
		/* Configuración con base de datos */
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

//		ProcessEngine processEngine = ProcessEngineConfiguration
//				.createStandaloneProcessEngineConfiguration()
//				.setJdbcDriver("com.mysql.jdbc.Driver")
//				.setJdbcUrl("jdbc:mysql://localhost:3306/activity")
//				.setJdbcPassword("desarrollo").setJdbcUsername("desarrollo")
//				.setDatabaseSchemaUpdate("true")
//				.buildProcessEngine();

		PersonaService personaService = (PersonaService) context.getBean("personaService");
		personaService.listarPersonas();
		
		ProcessEngine processEngine = context.getBean(ProcessEngine.class);
		

		RepositoryService repositoryService = processEngine.getRepositoryService();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		
		repositoryService.createDeployment().addInputStream("SimpleLeaveProcess.bpmn20.xml", new FileInputStream(filename)).deploy();    
		
		Map<String, Object> variableMap = new HashMap<String, Object>();    
		variableMap.put("Empname", "Irshad");    
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess", variableMap);    
		assertNotNull(processInstance.getId());    
		System.out.println("id " + processInstance.getId() + " "      + processInstance.getProcessDefinitionId());  
	} 
}