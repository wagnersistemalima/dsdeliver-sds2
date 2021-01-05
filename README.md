# dsdeliver-sds2
🔨 🔧O projeto consiste em um sistema de registro e entrega de pedidos

# Backend:

## Tecnologias:

* Maven Project: Ferramenta de gerenciamento de dependências utilizada para java

* Linguagem: Java 11 / versão LTS (Long Team Suport)  LTS é a versão que você paga para ter um longo período de serviço sem precisar atualizar a plataforma. Ela é ideal para empresas de grande porte e que não desejam ficar atualizando o programa a cada seis meses, quando um novo pacote de mudanças é implementado.

* Spring Boot Version: 2.4.1

## Dependencies:

* Spring Web: Crie aplicativos da web, incluindo RESTful, usando Spring MVC. Usa Apache Tomcat como o contêiner embutido padrão.

* Spring Data JPA: Especificação da biblioteca padrão de persistência de dados no java, baseado no mapeamento objeto relacional (javax.percistence)

* Hibernate: É uma das implementações da especificação JPA mais popular

* H2: Banco de dados em memória, para testes

* PostgreSQL: É um sistema de gerenciamento de banco de dados que é objeto relacional, que permite que programas Java se conectem a um banco de dados PostgreSQL usando código Java padrão independente de banco de dados

* Spring Boot Starter Validation: Iniciador para usar a validação do Java Bean com o Hibernate Validator

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

```

* Spring Security:  É uma estrutura de autenticação e controle de acesso poderosa e altamente personalizável. É o padrão de fato para proteger aplicativos baseados em Spring.

## Configurar banco de dados de teste (H2) H2 database, perfil de teste, JPA

* application.properties
* application-test.properties

## application.properties:

```
spring.profiles.active=test

spring.jpa.open-in-view=false


```
## application-test.properties:

```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

```
## Configurações do banco de dados PostgreSQL:

* application-dev.properties:

```
#spring.jpa.properties.javax.persistence.schema-generation.create-source=metadata
#spring.jpa.properties.javax.persistence.schema-generation.scripts.action=create
#spring.jpa.properties.javax.persistence.schema-generation.scripts.create-target=create.sql
#spring.jpa.properties.hibernate.hbm2ddl.delimiter=;

spring.datasource.url=jdbc:postgresql://localhost:5432/dsdeliver
spring.datasource.username=postgres
spring.datasource.password=1234567

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.hibernate.ddl-auto=none

```
## Configuração da url de configuração do banco de dados remoto que vai estar instalado no heroku

* application-prod.properties:

```
spring.datasource.url=${DATABASE_URL}

```
## Classe de configuração de segurança:

```
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}

		http.cors().and().csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().anyRequest().permitAll();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}

```

