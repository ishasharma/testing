package issuetracker.app.server.service.organizationboundedcontext.location;
import issuetracker.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import issuetracker.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import issuetracker.app.server.repository.organizationboundedcontext.location.AddressRepository;
import issuetracker.app.shared.organizationboundedcontext.location.Address;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import issuetracker.app.shared.organizationboundedcontext.location.Country;
import issuetracker.app.server.repository.organizationboundedcontext.location.CountryRepository;
import issuetracker.app.shared.organizationboundedcontext.location.City;
import issuetracker.app.server.repository.organizationboundedcontext.location.CityRepository;
import issuetracker.app.shared.organizationboundedcontext.location.State;
import issuetracker.app.server.repository.organizationboundedcontext.location.StateRepository;
import issuetracker.app.shared.organizationboundedcontext.location.AddressType;
import issuetracker.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase extends EntityTestCriteria {

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
    }

    private Address createAddress() throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCountryName("w5QQDV9dILZZO2eLcrINRJ9aT4KD7a3HhsVodBZxdThKFYSpMJ");
        country.setCountryCode1("bm3");
        country.setCapitalLongitude(6);
        country.setCurrencyName("dUg4H2du652d4RzwEdcrQmQHJ8ISZNJX8zzEagHn93lECMAhem");
        country.setCurrencyCode("4X9");
        country.setCountryFlag("mXSPcLnLFWNjwP6YqFSFbSyJrf2gkohOcbYR5oz0ip70ZheWHh");
        country.setIsoNumeric(8);
        country.setCapitalLatitude(2);
        country.setCapital("evzUr3YElMyjd7FjmBM8pdHWcxqjh8am");
        country.setCountryCode2("PEL");
        country.setCurrencySymbol("PxRI4LqV23TKW31D4RaGLiD8Y6PKihnL");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        City city = new City();
        city.setCityFlag("XFrWFQtsRhQ3WfC3P2r5IGd5zklE8GAnMxgTmzOFmgRbHAagpY");
        city.setCityLongitude(4);
        city.setCityLatitude(4);
        city.setCityDescription("Vf7zyfvb4iCQ5IkYJwH9jneYIOD7UOW9x9HeElSNzxoGgenp3r");
        city.setCityCode(1);
        city.setCityName("2NM8ixvVTLy7eeyaEolxwOVMP8JfzsQOwKny0MDGYigJFelAGd");
        State state = new State();
        state.setStateCodeChar2("Z1RVD1rVFv0PBgR5jNL1xVWnTIiDI2CW");
        state.setStateCapitalLongitude(2);
        state.setStateCodeChar3("sVbH1S52ljB1CbK8nHaMXPJek5SnlezQ");
        state.setStateCodeChar2("WTmJ9DzN1a3h5rH9AHT030xJFMWx1hFm");
        state.setStateCapitalLongitude(8);
        state.setStateCodeChar3("dI9dn2NwudQNEMRxjlWizIoGyocbHNQU");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("a5gNUD5LUD4OT3HGoyXowbhPTNd9gxvEOGF5o8PZ6VItRQmbOh");
        state.setStateFlag("sYoZco3OrL2l0Bx7rirHpZhCCKuKPPEtV1ouAJN7TOZu4Aw3TC");
        state.setStateCapital("QEQs3041qHIgGGhBWGxG84udXQeKqEdVPIMctuWLG0kdjoMVa2");
        state.setStateCapitalLatitude(1);
        state.setStateDescription("9u3a5aI8ZLZKQSazcJyIAdmTmop6gmeHVm8NBagC9L2cc6GwRE");
        state.setStateCode(2);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        city.setCityFlag("stF5jf7I61TBXRQHLoLFi0HhEBi1V3HKOIXgGyZwzRDBUQixun");
        city.setCityLongitude(5);
        city.setCityLatitude(4);
        city.setCityDescription("tbvKb6bodwHGLvtHpIH7sYrwJ6NrP5u5sM1oSEdZed0mSSQsNL");
        city.setCityCode(1);
        city.setCityName("OLO7sYqtsr4EZunKLZEvrLQKonv0hbqJU6w3mHkwxQ1dNtIjBw");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("A5kNnEE2GpjXAA0KhIPajuBpd9tsbXO1");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("EvOj2FVT1zvFoZn1hDCrJBh1UyKZ9LsdmbAXlJA9wYHFLrlhPc");
        addresstype.setAddressTypeDesc("TxyuTYjV4dV1QFtjnrjz5fdmj5tFOmdYarjfN36jps8KjvvfpM");
        addresstype.setAddressType("SmPElMJG1wlNiQDLkOBMYp8P0xqXB6UxbxY06JD3DEuO1sg2AD");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        Address address = new Address();
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("z4m8k3Dz4xEcwHvWqPeed8K7ap4rHnMhFT9zwF18NHaOcuYEJG");
        address.setAddress1("4v4C4KazhUP0z3UZmwFhW08CTXkTiKpFbqAyJ9TYTXwkUnMeFK");
        address.setLatitude("NwRJSnNe70vcuZr53x8QFKzXwJpG3eeOu4U10uQaJlaJoULnJo");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("AXx1r9");
        address.setAddress2("QJEoykfM8yUrhb1XD4vmMoLoxqUq2EgqrkEY7SfVV53TfYFioK");
        address.setStateId((java.lang.String) StateTest._getPrimarykey());
        address.setAddressLabel("MycNPX5DqKO");
        address.setAddress3("x0UdPVwyZes8OdaYfqNwMIoaC2g1M2k1ByYo1tu0kbICD1kCYo");
        address.setEntityValidator(entityValidator);
        return address;
    }

    @Test
    public void test1Save() {
        try {
            Address address = createAddress();
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setLongitude("tH4crsQQyFDqHyh2dIKDncouifpr4Gozb7gsHJ1TnpkTSaQvp3");
            address.setVersionId(1);
            address.setAddress1("KMCcA0Ofl0gIrvXnuWs82Lpa2Z7q3gWI7VfxZ73xFfzSguLJOP");
            address.setLatitude("lv8bZ8ctG7jV4Gld9Goqnp4EWeTwrV63HBkLjzsJ9NFbkSf3sH");
            address.setZipcode("KsMM64");
            address.setAddress2("xZH7bYu5JbubkOZfDYtShso54NZVfYc7fmfqu0d2N9a9Gjfn3J");
            address.setAddressLabel("6dvUkKI32Ja");
            address.setAddress3("Boxw44LWnrsTePHFKtUi5kvQgOLNBRtkhjHKlN66K1g1PQ7qpx");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAddress(EntityTestCriteria contraints, Address address) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            address.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            address.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            addressRepository.save(address);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "mYf8Va7JM8SN"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "AtKVQd2FmWBFtdAio9DIohqixMSFXXh4E1hIUHYZdCyCwp0SU1yeBtWPI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "rWnZsxZkFO2bKoam3s88cwajzGxC27can9TkByIdQA9HPCDtTDmQy725r"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "IF3CO8j9txha6vXSz9h3A8Y3tH7QlTAXGqL6WPjz2TnNZLNFn8OGc1N9g"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "9H7uiHf"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "oMGESpKBXkJPaFpYF4AYOTPPVBRNecKQHJ4VjTtOKq5SHowNfzf9PyS1NWmbOXrxp"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "HpKZgs6laIFmxYBf9NDqytpZQmRaSIGyodLD9Pmvu6l8PpsX0Fy1d8PRRKn6Tdbft"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Address address = createAddress();
                java.lang.reflect.Field field = address.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        address.setAddressLabel(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 2:
                        address.setAddress1(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 3:
                        address.setAddress2(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 4:
                        address.setAddress3(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(address, null);
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 6:
                        address.setZipcode(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 7:
                        address.setLatitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 8:
                        address.setLongitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                }
            } catch (SpartanIncorrectDataException e) {
                e.printStackTrace();
            } catch (SpartanConstraintViolationException e) {
                e.printStackTrace();
            } catch (SpartanPersistenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
