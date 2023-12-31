
package tn.esprit.spring.service;

 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

		@Autowired
		IUserService us; 
	/*
		@Test
		public void testRetrieveAllUsers() {
			List<User> listUsers = us.retrieveAllUsers(); 
			// if there are 15 users in DB : 
			Assert.assertEquals(15, listUsers.size());
		} */
		
		
		@Test
		public void testAddUser() throws ParseException {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			User u = new User("Mayssa3", "Mayssa3", d, Role.INGENIEUR); 
			User userAdded = us.addUser(u); 
			Assert.assertEquals(u.getLastName(), userAdded.getLastName());
		}
	 
		@Test
		public void testModifyUser() throws ParseException   {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			User u = new User(5L, "Maysaaa3333", "Mayssa", d, Role.INGENIEUR); 
			User userUpdated  = us.updateUser(u); 
			Assert.assertEquals(u.getLastName(), userUpdated.getLastName());
		}
	
		@Test
		public void testRetrieveUser() {
			User userRetrieved = us.retrieveUser("1"); 
			Assert.assertEquals(2L, userRetrieved.getId().longValue());
		}
		
		@Test
		public void testDeleteUser() {
			us.deleteUser("1");
			Assert.assertNull(us.retrieveUser("1"));
		}
		
		// 5 tests unitaires  
 
}





