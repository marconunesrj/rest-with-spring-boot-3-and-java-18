package br.com.xmrtecnologia.restwithspringboot3java18.app.integrationtests.controller.withxml.mapper;

import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;

import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;

public class XMLMapper implements ObjectMapper {

    private Logger logger = Logger.getLogger(XMLMapper.class.getName());

//    private com.fasterxml.jackson.databind.ObjectMapper objectMapper;
    private com.fasterxml.jackson.databind.ObjectMapper objectMapper;
    protected TypeFactory typeFactory;
    
    public XMLMapper() {
        objectMapper = new com.fasterxml.jackson.databind.ObjectMapper(new XmlFactory());
//        objectMapper = (ObjectMapper) new XmlMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        typeFactory = TypeFactory.defaultInstance();
    }

    @Override
    public Object deserialize(ObjectMapperDeserializationContext context) {
        String content = context.getDataToDeserialize().asString();
        Class<?> objectClass = (Class<?>) context.getType();
        // Implemente a lógica para converter XML para um objeto Java
        // Use uma biblioteca, como Jackson, para realizar a conversão
        // Exemplo com Jackson:
//         XmlMapper xmlMapper = new XmlMapper();
         try {
            return objectMapper.readValue(content, objectClass);
         } catch (JsonMappingException e) {
             logger.severe("Error deserializing object");
             e.printStackTrace();
         } catch (JsonProcessingException e) {
             logger.severe("Error deserializing object");
             e.printStackTrace();
         }

        // Aqui, estamos apenas retornando null para fins de demonstração
        return null;
    }

    @Override
    public Object serialize(ObjectMapperSerializationContext context) {
        Object object = context.getObjectToSerialize();
        
        // Implemente a lógica para converter um objeto Java para XML
        // Use uma biblioteca, como Jackson, para realizar a conversão
        // Exemplo com Jackson:
//         XmlMapper xmlMapper = new XmlMapper();
         try {
            return objectMapper.writeValueAsString(object);
         } catch (JsonProcessingException e) {
             e.printStackTrace();
         }

        // Aqui, estamos apenas retornando null para fins de demonstração
        return null;
    }
}

//import java.util.logging.Logger;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.JsonMappingException;
////import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.databind.type.TypeFactory;
//import com.fasterxml.jackson.dataformat.xml.XmlFactory;
//
//import io.restassured.mapper.ObjectMapper;
//import io.restassured.mapper.ObjectMapperDeserializationContext;
//import io.restassured.mapper.ObjectMapperSerializationContext;
//
//public class XMLMapper implements ObjectMapper{
//    
//    private Logger logger = Logger.getLogger(XMLMapper.class.getName());
//    
//    private com.fasterxml.jackson.databind.ObjectMapper objectMapper;
//    protected TypeFactory typeFactory;
//
//    public XMLMapper() {
//        objectMapper = new com.fasterxml.jackson.databind.ObjectMapper(new XmlFactory());
//        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
////        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
//        typeFactory = TypeFactory.defaultInstance();
//    }
//
//    @SuppressWarnings("rawtypes")
//    @Override
//    public Object deserialize(ObjectMapperDeserializationContext context) {
//        try {
//            String dataToDeserialize = context.getDataToDeserialize().asString();
//            Class type = (Class)context.getType();
//            
//            logger.info("Trying deserialize object of type" + type);
//
//            return objectMapper.readValue(dataToDeserialize, typeFactory.constructType(type));
//        } catch (JsonMappingException e) {
//            logger.severe("Error deserializing object");
//            e.printStackTrace();
//        } catch (JsonProcessingException e) {
//            logger.severe("Error deserializing object");
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public Object serialize(ObjectMapperSerializationContext context) {
//        try {
//            return objectMapper.writeValueAsString(context.getObjectToSerialize());
////            return objectMapper.writeValueAsString(context);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//}
