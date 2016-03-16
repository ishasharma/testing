package sales.app.server.service.organizationboundedcontext.location;
import sales.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.organizationboundedcontext.location.AddressRepository;
import sales.app.shared.organizationboundedcontext.location.Address;
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
import sales.app.shared.organizationboundedcontext.location.City;
import sales.app.server.repository.organizationboundedcontext.location.CityRepository;
import sales.app.shared.organizationboundedcontext.location.Country;
import sales.app.server.repository.organizationboundedcontext.location.CountryRepository;
import sales.app.shared.organizationboundedcontext.location.State;
import sales.app.server.repository.organizationboundedcontext.location.StateRepository;
import sales.app.shared.organizationboundedcontext.location.AddressType;
import sales.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
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
        City city = new City();
        city.setCityFlag("XmhCBoFSMn7R8k1zPRqQU5gmVz5eFGTPJVgNEwqZQy8qpe1eLC");
        city.setCityLatitude(4);
        city.setCityDescription("vDCqqkz3MXIbpV4NR9ysymhbFHfstMmhjDNQkfi6YTnrSioNPS");
        Country country = new Country();
        country.setCountryCode1("4Sa");
        country.setCountryName("kPYAMg6ZYOwJnyrhrvvDIHDR27LE7w5wKrzbCrl4HlWhgyq1ag");
        country.setCurrencyName("QW7JElJwuJeMjdMQJMkO7ST5HGSwdUN5zosI8N4XBrmFxbvLCR");
        country.setCurrencyCode("0CG");
        country.setCapitalLatitude(5);
        country.setCapitalLongitude(6);
        country.setIsoNumeric(1);
        country.setCurrencySymbol("9ehjccW5KkzSI3HCbkK0M1pN2qYw1EOG");
        country.setCountryFlag("MA9rrICoYUAh2yZnMuCrYd5akcjIvUq6EMqCzWeGpv0dUPoyU5");
        country.setCapital("hzHQINFqeYS1PqP40kneMVI44I37Unvy");
        country.setCountryCode2("raE");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        State state = new State();
        state.setStateName("6jOpjAyaUGH6ZPjvkiCfRLkRhvkiSMzwblcaIXD8NVM0EuEl0n");
        state.setStateCodeChar3("6ju3DOb6FyWrGvxgxYKOCVlDhV8FiEB8");
        state.setStateName("2piVp7ycFMO2J16HVZQ25VOeUYahKGxP6SfTk06ZZqoVhgI2FF");
        state.setStateCodeChar3("PQUgPsYOpBthLwQc7Kt5NrgttkEiOrcm");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateFlag("3NrOCdkJ8EKMDIOVL2ys6rAcNXbokyXy9VHzkThagBzfbnqLci");
        state.setStateCapital("Bin1bx5pTW7hMkuXFGFDrSOSriGmYgj54j3evJasAExnHFdBrA");
        state.setStateCapitalLatitude(9);
        state.setStateCode(1);
        state.setStateCapitalLongitude(7);
        state.setStateDescription("DnaHd0kWoy3HFbKLCRSToZuFneMFYJ7x0OvYAfyzejl9AEa3OW");
        state.setStateCodeChar2("UoQdr7FrRxWtQAaZDIS1Prv8ziBB25f6");
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        city.setCityFlag("Z93ZY6QKZm6YLPifJpBzneUdMiRNLEKIxJ9N0gu2pbc8U7S4Qv");
        city.setCityLatitude(3);
        city.setCityDescription("CPLrqGStEIaEtSrDOuz8sTGBxsWU8xvDxF9RctwR3J6n98vV3X");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("8yaZKAdvahF8PchDOBeseTF9YFcAJJ5S8jhWIrd02KSS4gXLM8");
        city.setCityCode(3);
        city.setCityCodeChar2("mH0X6UmUmVvi6rlCmsXiV79x6XhugVdk");
        city.setCityLongitude(9);
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("ZUJnAm0Sxs8SAYcXG8X51AmL2DeuOGFlXvRJxCAY23RX4knm20");
        addresstype.setAddressTypeIcon("kDPREMlaiOP5MmjSv9DMKjVyIgqmV9VybGf99PmxGj1fH0ffET");
        addresstype.setAddressTypeDesc("E3y2JvU7dKQX2JBo17tnynENZ9n6qH4dYmM5sDqSXRWZPIA9rj");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        Address address = new Address();
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("b4fcUyF9wvrf9eHQqEBqecuqBeVnuwX6qJY3JVMiehRVOheejK");
        address.setAddress2("vWGdRLLmMRWuvB8HRfQs5qHsjaRNMPYCdrMlY1gEBo1gjFqnl2");
        address.setStateId((java.lang.String) StateTest._getPrimarykey());
        address.setZipcode("fLCrfR");
        address.setAddressLabel("AXK7J5o14xZ");
        address.setLongitude("90kczeJrwSZzfuNU1krK1N0oEo51EPxj1SWlFSIyZIEZzbhDaY");
        address.setAddress1("W5FFUq3DiH3pBMb881BzIkkeud6aavKW5s8hsSjRV7zn7wxsTv");
        address.setAddress3("U4A8hTGpfi43g40mYQUsLS3rrg3LH6RvdH4n8D1zdPVtQ2CYjb");
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
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setLatitude("YJFdEMXQUvkqGm0x2dynivBCPZywcEufwXBUt7T1O3ZAWxxnxo");
            address.setVersionId(1);
            address.setAddress2("N849byDt6eu73reZGznwoSy5AUc0YSsdZM5FAyJslSZ2kjXtsG");
            address.setZipcode("HmMRHn");
            address.setAddressLabel("BAp1LNXpG3w");
            address.setLongitude("ovpZ1IOOtrgTfgtwBD9mQe6xLZpTWoxH8UARKk22WlTys0eI5t");
            address.setAddress1("LGs7XOdt7HkecOSiAQwrlAi3Jc4krKzaDhpjyv15wXb4i13UsE");
            address.setAddress3("bi8dg2cBMg4iYke0vYJuCS7gwqBqdGV8nE54iepqjwPSdV67ic");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "pBMCAcsD2avZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "B1hTrtGuutlDM4mpyCmCkHoUWSPpuvMsv0Zh0PvBM4e84qxOpVl2MaZXX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "jH1ZqojDGM4IJIjGLaz1tqAkfKdsNFGy2p7q0tXOXUMAaX7RkY4aNXVcK"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "8NyKn8PlxxdNijw6lCaRfyG6NLVPYMojo6biDN3TBOP0kKOHoCHopadL5"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "CX2KhTr"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "h7xiZWmcqEi2lCXGIr561ksNsAy094Lf2icukN9KNz9e2LgZvFE63VSS2T5kSY8WZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "NelP1g1e5OdZBZvtMUIuIjSUO1lUgduRK32zhYzNsfckjSsXHpX1nVWlhycLs8M4n"));
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
