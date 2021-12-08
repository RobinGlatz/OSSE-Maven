package de.hfu.residents.repository;
import java.util.List;
import java.util.LinkedList;
import java.util.Date;
import de.hfu.residents.domain.Resident;

public class ResidentRepositoryImplStub implements ResidentRepository{
    private List<Resident> residents;

    public ResidentRepositoryImplStub(){
       Resident a = new Resident("Hans","Peter","Musterstrasse", "Musterstadt",new Date() );
       Resident b = new Resident("Peter","Hans","Musterstrasse","Musterstadt",new Date());
       Resident c = new Resident("Max", "Mustermann", "Musterstrasse", "Musterstadt", new Date());
       residents = new LinkedList<Resident>();
       residents.add(a);
       residents.add(b);
       residents.add(c);
    }

    public List<Resident> getResidents(){
        return residents;
    }

}
