package de.hfu.osse;
import de.hfu.residents.domain.Resident;
import de.hfu.residents.service.BaseResidentService;
import java.util.List;
import de.hfu.residents.service.ResidentServiceException;
import static org.junit.Assert.*;
import java.util.Date;

import org.junit.Test;

public class ResidentServiceTest {
    
    @Test
    public void shouldAnswerWithTrue(){

        //Testing getUniqueResident
        Resident a = new Resident("Hans", "","","",new Date());
        BaseResidentService service = new BaseResidentService();
        try{
        Resident b = service.getUniqueResident(a);
        //b should be Hans Peter
        assertTrue(b.getGivenName().equals("Hans"));
        assertTrue(b.getFamilyName().equals("Peter"));
        a = new Resident(null, "Peter", null,null,null);
        b = service.getUniqueResident(a);
        //b should be Peter Hans
        assertTrue(b.getGivenName().equals("Hans"));
        assertTrue(b.getFamilyName().equals("Peter"));
        }catch(ResidentServiceException e){}


        //Testing getFilteredResidentsList
            a = new Resident("*",null,null,null,null);
           List<Resident> testList =  service.getFilteredResidentsList(a);
           assertTrue(testList.size() == 3);

 

            //b should be "Peter Hans"
            a = new Resident("Pet*",null,null,null,null);
            testList = service.getFilteredResidentsList(a);
            Resident b = testList.get(0);
            assertTrue(b.getGivenName().equals("Peter"));
            assertTrue(b.getFamilyName().equals("Hans"));

            //b should be "Hans Peter"
            a = new Resident("Ha*",null,null,null,null);
            testList = service.getFilteredResidentsList(a);
            b = testList.get(0);
            assertTrue(b.getGivenName().equals("Hans"));
            assertTrue(b.getFamilyName().equals("Peter"));

       
    }

    @Test
    public void shouldAnswerWithFalse(){

    }

    @Test
    public void shouldThrowException(){

    }
}
