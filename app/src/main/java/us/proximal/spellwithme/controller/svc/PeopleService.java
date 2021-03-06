package us.proximal.spellwithme.controller.svc;

import android.app.Activity;

import java.util.ArrayList;

import us.proximal.spellwithme.controller.def.IPeopleService;
import us.proximal.spellwithme.model.dao.PeopleDAO;
import us.proximal.spellwithme.model.dao.RelationshipsDAO;
import us.proximal.spellwithme.model.def.IPeopleDAO;
import us.proximal.spellwithme.model.dto.PersonDTO;

/**
 * Created by b on 11/29/14.
 */
public class PeopleService implements IPeopleService {

    IPeopleDAO daoPeople;
    ArrayList<PersonDTO> people;

    public PeopleService(Activity act) {
        daoPeople = new PeopleDAO(act);
        try {
            people = daoPeople.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public long addPerson(PersonDTO dto) throws Exception  {
        //
        long result = 0;
        //
        try {
            result = daoPeople.create(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //
        return result;
    }

    @Override
    public long deletePerson(PersonDTO dto) throws Exception  {
        return 0;
    }

    @Override
    public long updatePerson(PersonDTO dto) throws Exception  {

        long result = 0;

        try {
            result = daoPeople.update(dto);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

    @Override
    public ArrayList<PersonDTO> getListOfPeople() throws Exception  {
        try {
            people = daoPeople.list();
            return people;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<PersonDTO> getListOfMyStudents() throws Exception  {
        ArrayList<PersonDTO> students;

        String[] select;
        String[] from;
        String[][] where;

        select = new String[4];
        from = new String[2];
        where = new String[2][2];

        //SELECT
        select[0] = PeopleDAO.PRIMARY_KEY;
        select[1] = PeopleDAO.FIRST_NAME;
        select[2] = PeopleDAO.LAST_NAME;
        select[3] = PeopleDAO.BIRTH_DATE;

        //FROM
        from[0] = PeopleDAO.TABLE_NAME;
        from[1] = RelationshipsDAO.TABLE_NAME;

        //WHERE
        where[0][0] = PeopleDAO.TABLE_NAME + "." + PeopleDAO.PRIMARY_KEY;
        where[0][1] = String.valueOf(getMyPersonObject().getPersonId());

        //AND
        where[1][0] = RelationshipsDAO.TABLE_NAME + "." + RelationshipsDAO.TYPE;
        where[1][1] = "MKO";

        students = daoPeople.list(select, from, where);

        return students;
    }

    @Override
    public PersonDTO getOnePersonObject(int key) throws Exception {
        //
        PersonDTO person;
            //
            try {
                person = daoPeople.read(key);
                return person;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

    }

    @Override
    public PersonDTO getMyPersonObject() throws Exception {
        PersonDTO me;

        me = new PersonDTO();

//        me.setPersonId(999);
//        me.setFirstName("Testing");
//        me.setLastName("123");
//        me.setBirthDate("Jan 1, 1970");


        int count = people.size();

        if (count > 0){
            for (PersonDTO p : people){
                int id = p.getPersonId();
                me = p;
                break;
            }
        }


//        try {
//            me = daoPeople.read(0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return me;

    }
}
