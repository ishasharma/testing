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
import sales.app.server.repository.organizationboundedcontext.location.StateRepository;
import sales.app.shared.organizationboundedcontext.location.State;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase extends EntityTestCriteria {

    @Autowired
    private StateRepository<State> stateRepository;

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

    private State createState() throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCountryCode1("M8v");
        country.setCountryName("GgTMk9ARwENHMxlQUsf1mExFYVxMiGqMRgB5CZSV8B3KiD2E4a");
        country.setCurrencyName("HL4OunOEbJ06YoHsesaEMYR6XC7SWVjZq99wsFo8UrTVghmAVX");
        country.setCurrencyCode("0d2");
        country.setCapitalLatitude(6);
        country.setCapitalLongitude(3);
        country.setIsoNumeric(5);
        country.setCurrencySymbol("HMlfJpK4nMV4eFl4Fhmg0jf0z80jAzNs");
        country.setCountryFlag("LHEd0nstWF3vdlq8z8nvZ97AUQQEzhGNb5bzN0V2NHpfb5m4La");
        country.setCapital("UWoJGCg91YFMv6SqpZSYBL6cxnqKMN5w");
        country.setCountryCode2("3Uz");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        State state = new State();
        state.setStateName("c7vhm4HB3F11XhvTCQhmuKamkZcGUXxH71B0NAG8igt69hdhX0");
        state.setStateCodeChar3("FVNzqbEZxnm9R5aCPbRTrw0GfQJMMbGq");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateFlag("u76KjPL3UvZsbNyOGzIbhFd4kke7UbHdCx3m8uxOjgFTUncrGW");
        state.setStateCapital("GtKbjvRhJB0cNuqblylInAFYS6y1Hd4li1OFmLNEqvf2vmXub3");
        state.setStateCapitalLatitude(7);
        state.setStateCode(2);
        state.setStateCapitalLongitude(8);
        state.setStateDescription("015ywoiUKdSIwxZvh5YWuY2nl5zxn8g2LQ3F0uRgD06u9jzO6q");
        state.setStateCodeChar2("JocIcaaQl6RCyb3TW9NfFNYCBI3O0Z8Y");
        state.setEntityValidator(entityValidator);
        return state;
    }

    @Test
    public void test1Save() {
        try {
            State state = createState();
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateName("3AT0M8DTgRcny9QS7obSArUsXhpOX1oTWcV3774WDg8XkLT126");
            state.setStateCodeChar3("aPkxkqhWruJFfjgSdcS8gLgWX3WEUepz");
            state.setStateFlag("c37upuxNMjKRRAOtDMVM5erLUnUFssFMTMfqktJqw9AzarK2cq");
            state.setStateCapital("szVoJRk54uZT6PaQr8mIo1oDO8d2qwSs8ybcmdlqeBE3wTVqpn");
            state.setStateCapitalLatitude(7);
            state.setVersionId(1);
            state.setStateCode(1);
            state.setStateCapitalLongitude(11);
            state.setStateDescription("QBbYw3bVSZXF0bWe1AHBPLnTueoQLNgRcJcJoH1bzsfo0Kgibr");
            state.setStateCodeChar2("3BkqWV8qzkKNxL12dussjHNJuc7GDroU");
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateState(EntityTestCriteria contraints, State state) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            state.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            state.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            stateRepository.save(state);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "stateName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "XKjHcohwfknbswftDcypk1G7JBMwn1hbg2wabl4YWceo1eXO63JMWPRqdw7dLCIfz3MQjkEuTwnbf4jM9TF3GQ06XIhFklVfPO5C4UCQ8g07RRME4lvEqkQ3YKtTcUNXtb4g9cxCUgNvmV2QV7acYvRHWQF8Y7k5Cav0pSF2QhSvgVJ8v1Ww6boz9mX2OQWR4keqpyRYFu7QByKXrW3wide5xJfxEyEJkNJdK1Zb07qrCCoGFMvYaEyF4hz03S2mk"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 3));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "h0OYhUvMErB6a6JZVqvJ1hrl0sDORJYEC"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "PfzwmsWTkhT7LPQiO7X0iLe6pZXzV9NFg"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "UhK2lxofN18BO47xajaWthvwBrXXJQAB2h78ykWT0IV6T2KF2AUzjrRWqRgbSpxMLkTZkrKwQSzZOuGiK8gXyRGTxvGSDwrJ1jshpV1LtRDvAwHcm67jiPNcUyA5IqwqgGiRZW3sPUnbCPdrFDetxvJvgSlp7nW3VlJQOMeO8VcbjDmeuvhJiFATaXp3shUHY4ez5mgBrlt6aDzlgk5ipiWWCX30TDaeE92TibuzU18CHU5jH9Xu03w8lK6Rj4OJO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "gBBcHlydfg2jYHi6hYslqR7Z4UTmiRlbU6yfgiyEiUqylL7XIi9MEVPa6grAL52EzvKfhvsAxINUzYsEUQcft2YD75qdIIFRW10DoqzzC1at3BlnGNF836CFeJPVpKfJK"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "DCbftgmJe8dbm4MRxqg7F3CrTwb8QGN3OX3hy2ohCejexRgwdAZzoDGoYEtf5qqQ4E5VGnYLRdBvu4xVZOF4pyhPkBeCgTzPP9FdiDTHSu9Nb3Q8WzMKqokR2iJaXr2yJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 12));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                State state = createState();
                java.lang.reflect.Field field = state.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 2:
                        state.setStateName(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 3:
                        state.setStateCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 5:
                        state.setStateCodeChar2(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 6:
                        state.setStateCodeChar3(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 7:
                        state.setStateDescription(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 8:
                        state.setStateFlag(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 9:
                        state.setStateCapital(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 10:
                        state.setStateCapitalLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 11:
                        state.setStateCapitalLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
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
