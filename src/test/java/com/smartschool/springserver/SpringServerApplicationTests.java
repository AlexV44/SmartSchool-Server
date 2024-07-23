package com.smartschool.springserver;

import com.smartschool.springserver.model.Product;
import com.smartschool.springserver.model.School;
import com.smartschool.springserver.model.Smember;
import com.smartschool.springserver.service.SchoolService;
import com.smartschool.springserver.service.SmemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringServerApplicationTests {

	@Autowired
	private SmemberService service;
	@Autowired
	private SchoolService schoolService;


	@Test
	void addMemberTest() {
		Product product = new Product();
		School school = new School();
		school.setName("asdf");
		school.setIdentifier("sdfsadf123123");
		product.setDescription("sdfsdf");
		product.setPic("pop_1");
		product.setPrice(12.);
		product.setTitle("sdafasdfasd");

	}

	//@Test
	void getAllSchools() {
		List<School> schools = schoolService.getAllSchools();
		for(School school : schools) {
			List<Smember> member = school.getMembers();
			System.out.println(school.getName() + member.get(0).getName());
		}
	}
}
