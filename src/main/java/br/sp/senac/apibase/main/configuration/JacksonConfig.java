package br.sp.senac.apibase.main.configuration;

import java.text.SimpleDateFormat;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author Joaquim Neto
 * Github joaquimsn
 */
@Provider
public class JacksonConfig implements ContextResolver<ObjectMapper> {
	private ObjectMapper objectMapper;
	
	public JacksonConfig() {
		this.objectMapper = new ObjectMapper();
		// objectMapper.registerModule(Jdk8DateConverter());
		// objectMapper.registerModule(new ParameterNamesModule());
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
		objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
		objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
		objectMapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	@Override
	public ObjectMapper getContext(Class<?> type) {
		return objectMapper;
	}
	
	// public SimpleModule Jdk8DateConverter() {
	// SimpleModule simpleModule = new SimpleModule("JDK8DateConverter");
	// simpleModule.addSerializer(LocalDateTime.class, new
	// LocalDateTimeSerializer());
	// simpleModule.addDeserializer(LocalDateTime.class, new
	// LocalDateTimeDeserializer());
	// simpleModule.addSerializer(LocalDate.class, new LocalDateSerializer());
	// simpleModule.addDeserializer(LocalDate.class, new
	// LocalDateDeserializer());
	// simpleModule.addSerializer(LocalTime.class, new LocalTimeSerializer());
	// simpleModule.addDeserializer(LocalTime.class, new
	// LocalTimeDeserializer());
	// return simpleModule;
	// }
}