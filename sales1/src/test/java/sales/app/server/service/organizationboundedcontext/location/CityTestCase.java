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
import sales.app.server.repository.organizationboundedcontext.location.CityRepository;
import sales.app.shared.organizationboundedcontext.location.City;
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
import sales.app.shared.organizationboundedcontext.location.Country;
import sales.app.server.repository.organizationboundedcontext.location.CountryRepository;
import sales.app.shared.organizationboundedcontext.location.State;
import sales.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CityTestCase extends EntityTestCriteria {

    @Autowired
    private CityRepository<City> cityRepository;

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

    private City createCity() throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCountryCode1("Wh4");
        country.setCountryName("EztJU16ulMgUHtajckXjJDNTabD6YcYeKgcTbjeCmGQRZ3z89U");
        country.setCurrencyName("eGo6vsCqNYlYwMyC0qjDG4fbFLPTpgZumqUtQSLc4Jpv7CPdQH");
        country.setCurrencyCode("agb");
        country.setCapitalLatitude(7);
        country.setCapitalLongitude(1);
        country.setIsoNumeric(11);
        country.setCurrencySymbol("MN27HdNktoStYXIZxGriylw1aCdcbPiD");
        country.setCountryFlag("1PUKkfvqGv2yPIa4xPR9w14AcYFZBEP8LBVvIyjHKHuQkCqmRA");
        country.setCapital("qGIgSxctuVKZDTsaVBBmJkfF5Y0ViRZd");
        country.setCountryCode2("a9c");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        State state = new State();
        state.setStateName("oWX4iSOWaGQNnY7ojFqkO2UEvVjYT9SHXmbRQciSjvVMVAGWvM");
        state.setStateCodeChar3("D2Au27h5zjsMBL5YbXYH80zc56Pt6meU");
        state.setStateName("xti7vcdgTQMOedasZDxJ7jOQ6i0QHpjPQeZPCuj3za0EBtpgp1");
        state.setStateCodeChar3("D3UVGjGqex0gWKIXKEsOnsHs9eLymc6G");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateFlag("bXxrnD8i0jYuRXSjyZkjL4dKv2fh5XNOQRZuBnyWd1mHCSYIbB");
        state.setStateCapital("Kup9Mu3BNPLbRXVLCX59QC8BjRT1sHkD5SyLLMI3i1Jm0Lr7r1");
        state.setStateCapitalLatitude(5);
        state.setStateCode(1);
        state.setStateCapitalLongitude(2);
        state.setStateDescription("14iSEIThTehcaI4ZW1e8R5Y4lIMzWfDfXbzWZrdDw1fHG4JYxi");
        state.setStateCodeChar2("7Hvi69iI7ajSgAbY6rSgguctL47xn3nW");
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        City city = new City();
        city.setCityFlag("ne2nd6OGtshVgmyBYWCazKw5Nx3MHbjgdyABthqSodwfXuTdfU");
        city.setCityLatitude(6);
        city.setCityDescription("8LAas28mLrZGRen8dJH88NwFdYsoRBr4xp7k5zuKPgCSnhS1sn");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setStateId((java.lang.String) StateTest._getPrimarykey());
        city.setCityName("wiveTJoNtihUqp1JOYATQWnW9xfVTfozNVwonzFfPJbQhbTg3z");
        city.setCityCode(3);
        city.setCityCodeChar2("MJTKrAdol5hEfaJH4SZa3NQeUlfxy8Wn");
        city.setCityLongitude(7);
        city.setEntityValidator(entityValidator);
        return city;
    }

    @Test
    public void test1Save() {
        try {
            City city = createCity();
            city.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            city.isValid();
            cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            City city = cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
            city.setCityFlag("rTu60NQfKyKXoLxhoDWtT5Dsb5uUAFCLul3j9s5VXxprTUcHFB");
            city.setCityLatitude(9);
            city.setCityDescription("TDLXsNgrMUPETZJtE2sqzWJ6qp2yI4zHxpv6jocshz9q78NGVK");
            city.setVersionId(1);
            city.setCityName("QNt3DHUyTqXeYGelzpK8EETI6Sish1o0uKWi3mSfI439N4kYX0");
            city.setCityCode(1);
            city.setCityCodeChar2("u12L4VVHW1hIt9jhDHYTk3QaZRE44MYR");
            city.setCityLongitude(11);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<City> listofcountryId = cityRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3findBystateId() {
        try {
            java.util.List<City> listofstateId = cityRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCity(EntityTestCriteria contraints, City city) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            city.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            city.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            cityRepository.save(city);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "cityName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "cityName", "iKcATVG0a7yuQsh6yxfaDxZ5gVOOzEUFxDXORNDN78OEDkwk7ABIasfGTvEIMSaK1x97yvIGxEAMZIAhxtvZVFeDaIERyJBI0e3HRidsnPOWQ2dSPdHaxNMkp2xUDkw6GVup6Es447wz8wv4JK4CfsutGJ6M8WaN16REwY4yXoRseP0NqgxN6nyxvoSvoMz5M5W9G99uuChjLZ9br3LQ76aztv6H9Hey02gCR8jUvPVtdBKYjfTBQ20xz3ddlKVgd"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "cityCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "cityCodeChar2", "fTrJmTnSHTVlgNjgWEAhjwtxsAaXC8A74"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "cityCode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cityCode", 5));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "cityDescription", "9nnSywI6Xfc6YOQg4ZHWwHLkpv9IC3yhalSZ2tXiQxn2rGHDe41rzyPV3GHreNmoHasHcM32c4OO1CUThxAsXXD2jjnMSv63g8452wXoUrI3snFtURZ2QIkDzjj1rNCZL"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "cityFlag", "dp7mdHzymImcYoQOlAELHctIfxVrj6yhA8MpPpIBMQgXKCOPKVNZXZ5Klvq3Yhpf9NcX2SBg27uD77oUYbcQvGzDxzfps9Qh9UMjG6Jnao9hFbHsxwApJTmSitSyM7Yid"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "cityLatitude", 16));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "cityLongitude", 21));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                City city = createCity();
                java.lang.reflect.Field field = city.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 2:
                        city.setCityName(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 4:
                        city.setCityCodeChar2(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(city, null);
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 6:
                        city.setCityCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 7:
                        city.setCityDescription(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 8:
                        city.setCityFlag(contraints.getNegativeValue().toString());
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 9:
                        city.setCityLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
                        failureCount++;
                        break;
                    case 10:
                        city.setCityLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCity(contraints, city);
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
