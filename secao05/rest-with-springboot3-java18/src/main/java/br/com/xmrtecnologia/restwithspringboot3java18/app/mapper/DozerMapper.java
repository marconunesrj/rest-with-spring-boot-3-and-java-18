package br.com.xmrtecnologia.restwithspringboot3java18.app.mapper;

import java.util.ArrayList;
import java.util.List;

// import org.modelmapper.ModelMapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import br.com.xmrtecnologia.restwithspringboot3java18.app.config.Generated;

@Generated  // Utilizada para não fazer parte dos testes coverage jacoco
public class DozerMapper {
	
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	// private static ModelMapper mapper = new ModelMapper();
	
	public static <O, D> D parseObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}
	
	public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
		List<D> destinationObjects = new ArrayList<D>();
		for (O o : origin) {
			destinationObjects.add(mapper.map(o, destination));
		}
		return destinationObjects;
	}

}
