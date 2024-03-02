package br.com.xmrtecnologia.restwithspringboot3java18.app.mapper.custom;

import org.springframework.stereotype.Service;

import br.com.xmrtecnologia.restwithspringboot3java18.app.data.vo.v2.PersonVOV2;
import br.com.xmrtecnologia.restwithspringboot3java18.app.model.Person;

@Service
public class PersonMapper {
	
	public PersonVOV2 convertEntityToVo(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
//		vo.setBirthDay(person.getBirthDay());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		return vo;
	}
	
	
	public Person convertVoTOEntity(PersonVOV2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setAddress(person.getAddress());
//		entity.setBirthDay(person.getBirthDay());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		return entity;
	}

}
