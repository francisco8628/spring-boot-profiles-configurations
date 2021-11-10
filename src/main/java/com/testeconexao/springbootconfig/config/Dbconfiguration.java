package com.testeconexao.springbootconfig.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
/*
 * quando subir o spring vai procurar toas as classe marcadas como Configuraation
 * e vai puxas dos arquivos properties com a marcaçao spring.datasource * 
 * 
 * */


@Configuration
@ConfigurationProperties("spring.datasource")

public class Dbconfiguration {
	
	private String driverClassName;
	private String url;
	private String userName;
	private String passWord;
	
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
	
	@Profile("dev")
	@Bean
	public String testDataBaseConnection() {
		
		System.out.println("DB connectio fot DEv - h2");
		System.out.println(driverClassName);
		System.out.println(url);
	  
      return "DB conecção para o h2";		
	}
	
	
	@Profile("prod")
	@Bean
	public String ProdDataBaseConnection() {
		
		System.out.println("DB connectio fot DEv - Mysql");
		System.out.println(driverClassName);
		System.out.println(url);
	  
      return "DB conecção para o Mysql";		
	}
}//configuration
