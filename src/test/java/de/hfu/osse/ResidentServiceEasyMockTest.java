package de.hfu.osse;
import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import java.util.List;
import java.util.*;
import org.junit.Test;
import static org.easymock.EasyMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class ResidentServiceEasyMockTest {
    @Test
    public void test(){
        List<Resident> residents = new LinkedList<Resident>();
        Resident a = new Resident("Hans","Peter","Musterstrasse", "Musterstadt",new Date() );
       Resident b = new Resident("Peter","Hans","Musterstrasse","Musterstadt",new Date());
       Resident c = new Resident("Max", "Mustermann", "Musterstrasse", "Musterstadt", new Date());
       residents.add(a);
       residents.add(b);
       residents.add(c);

        ResidentRepository repositoryMock = createMock(ResidentRepository.class);
        expect(repositoryMock.getResidents()).andReturn(residents);

        replay(repositoryMock);

        BaseResidentService service = new BaseResidentService();
        service.setResidentRepository(repositoryMock);
        try{
        b = service.getUniqueResident(a);
        }catch(Exception e){}
        verify(repositoryMock);
        assertThat(b.getGivenName(), equalTo(a.getGivenName()));
    }
}
