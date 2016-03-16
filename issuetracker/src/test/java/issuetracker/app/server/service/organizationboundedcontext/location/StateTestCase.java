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
import issuetracker.app.server.repository.organizationboundedcontext.location.StateRepository;
import issuetracker.app.shared.organizationboundedcontext.location.State;
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
        country.setCountryName("syCmrr2QyQ8OgD6lmd5YHIYqyxTNTgXwR7KddXbSKI6KTIb7Xo");
        country.setCountryCode1("gmB");
        country.setCapitalLongitude(6);
        country.setCurrencyName("2N0t0t344u4IxZuHoJf5rcqwtNJbe3hn19gYFb3xZZO396Fn2I");
        country.setCurrencyCode("8tH");
        country.setCountryFlag("DuVVovcfWKULSgrc4UCoQLmve7FsIlplvtytNtbK0rr7EJ9NfC");
        country.setIsoNumeric(1);
        country.setCapitalLatitude(6);
        country.setCapital("Hbe0hoaA8F0BTQTxK6ceF8WcW6VbHEBl");
        country.setCountryCode2("FIb");
        country.setCurrencySymbol("gvZlUvwabRFlTBwCgUNiX54ZDbm7dmm2");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        State state = new State();
        state.setStateCodeChar2("I8ZMHWyhb29Wa335WYy1x1AKGjffWfCP");
        state.setStateCapitalLongitude(10);
        state.setStateCodeChar3("NvodWAuhMvgcIO7osthnatGbsMMe5gWw");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateName("yAAojQf9jkVYIj5N620n4HsGFbhvI3g2WLSGlveTg5S5tXxSTM");
        state.setStateFlag("DrZPfuhaLHsTC9jlId5sry5RPPFUCxoTLNBzAbsd7MFA1NEsds");
        state.setStateCapital("5oQN1W1HqqfMfMR8IZVZa4Ck0a4QmDIjzy48LGGiBTHxbpwTKn");
        state.setStateCapitalLatitude(10);
        state.setStateDescription("8QyyEclX0WOoB5ZIYUcO4bWxG2YW6hAg9GS4wfQUnpxFiUPqwn");
        state.setStateCode(1);
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
            state.setStateCodeChar2("R54JF9O7Y2m5zHjX4sD7fVHFRcCjNgQ5");
            state.setStateCapitalLongitude(4);
            state.setStateCodeChar3("mW4t5QR0f2fuXCwB1GsdKxEeNNwS4TOg");
            state.setStateName("CVG2ROh9wzzy9jwxj9lvCHlugQrvuCOlEOMZDQnIhPfMlvyRlU");
            state.setStateFlag("pipSI6Fa4fBd7UqWcuqSJWm0ue1COIfbJPDNhRNUzLM4TqvCcm");
            state.setStateCapital("0mBFGDL7Ka8jetxfyzvfSp2ioimknOgFC7OmAcSju5BeZVS1OO");
            state.setVersionId(1);
            state.setStateCapitalLatitude(1);
            state.setStateDescription("6p9BYVRQZKcigmCPevGwh3iJh0UjpSYoyYn8fR0yyRN7yXXDa1");
            state.setStateCode(2);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "LclfV2uWSHuhq8ZGekjRFkhy9sinUpOuKCekrarqGEuvGneA3aUdZ0DZEZmtNVeZlFwM8is23lGp4tAOY11hgPnUW7RoE40lSxbOPRnaek81KkC8m6L6nIyHdb7TsNQuHZIXYKuUmCVKrscsZahUnNS6kTkpKs5QAD401mo6yBqo14cOmdZ0kUUeKb1VQNw11Ycwuss4MzK6nByy0rOycW6UJQXIHrxTVzosp0ffJcrCknjaNg5JREHcB1k7KSqcz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 4));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "mproAxocQ4dbk2wG349BoLlmShvhMfafI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "oOEzVxtFuSFbemgtCdXsCCjohzxuw9Djl"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "EleqvNebsMiXsyZGYXufbNYbMyzOZmZ5x7BWWlYKRxNFK13GHL7krKuIRpBJVGTPU0oNBo2aPApGfrJLYXw78O2Yk1AqGeK7DywJMdcpnpn4zlHcXarSC6VBsJFHKZF65EfEmtc2mhNWFVxLiOkkU8eelb2007y3YWHFnvtePCJTLRN99Banud3i6M1tYZPH3qN9HBw77pGvIfSjTjxb1mzqjWMOEc4qlSeCeG54C8DkUtgWFadx1JsVVP1XxZvEj"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "SS3ip646JAGmQwg4lqfQ51HDTM65lUb7f9NR7Cv4eFxpwtEDf2I8lpdmoZsJBeE5P0rNl2W42Bo9GhThwzWRSutRleMtMFdYJzdGZAULh6hO3DX8xRkKXCcTEn4N0Aytu"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "7xGGv2L8ciUQTBvNKbfHABffmU9cGA7ZstNZIk3vOA1TrlDuEYvv1wQSJxZLl4N1mcIjBlvozjBhFUJFdTWPzJpZlkFkVbjGEgbDCcsuvPESrndY9IkOZmmVm1XJju77j"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 14));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 13));
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
