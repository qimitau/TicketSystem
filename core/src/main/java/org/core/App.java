package org.core;

import org.jpa.Benutzer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        UserServiceImpl userServiceImpl = new UserServiceImpl();
          
//        Benutzer benutzer = userServiceImpl.findById(1L);
//        benutzer.setDepartment("IT");
//        benutzer.setPassword("a");
//        userServiceImpl.update(benutzer);
        
        
  //      userServiceImpl.delete(4L);
        
//      Benutzer benutzer = new Benutzer();
//      benutzer.setName("Adams");
//      benutzer.setDepartment("IT");
//      benutzer.setEmail("helena.adam@persis.de");
//      benutzer.setPassword("eins");
//      userServiceImpl.insert(benutzer);
//      userServiceImpl = new UserServiceImpl();
//      benutzer = new Benutzer();
//      benutzer.setName("Frank");
//      benutzer.setDepartment("office");
//      benutzer.setEmail("frank@anne.de");
//      benutzer.setPassword("zwei");
//      userServiceImpl.insert(benutzer);
       
        Benutzer b = userServiceImpl.findByEmail("frank@anne.de");
        System.out.println(b.getName());
        
    }
}
