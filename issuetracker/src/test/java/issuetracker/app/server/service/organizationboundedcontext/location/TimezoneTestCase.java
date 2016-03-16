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
import issuetracker.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import issuetracker.app.shared.organizationboundedcontext.location.Timezone;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TimezoneTestCase extends EntityTestCriteria {

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

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

    private Timezone createTimezone() throws SpartanPersistenceException, SpartanConstraintViolationException {
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("FOLyr8n0n7QRhxSOf7Zc5qH1guJ8ksrAoKLiaIFBxuBe0ZGKNF");
        timezone.setTimeZoneLabel("2JkAGMJ7l7KEdpj3zVVO9pRunA3TJ44XLI4mQooYjXGFWbZGke");
        timezone.setCountry("nplGGZ8ByZX78N4DOr2ByJ5i0igsmNZJAvg0kMBsdgge4Hci23");
        timezone.setCities("7KI8c0K3hFdMHEuaen4u17iLvk1Xf1ohM6lo93kPtNW6pOtT8A");
        timezone.setUtcdifference(9);
        timezone.setEntityValidator(entityValidator);
        return timezone;
    }

    @Test
    public void test1Save() {
        try {
            Timezone timezone = createTimezone();
            timezone.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            timezone.isValid();
            timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            Timezone timezone = timezoneRepository.findById((java.lang.String) map.get("TimezonePrimaryKey"));
            timezone.setGmtLabel("FDWfRCfFAUbLI8cm5bgNSldva6gtAAQSIumECAd4HRp8ObpOh1");
            timezone.setTimeZoneLabel("Pj86YhME3BgWj8mR8C3XNOv4iFUX3bDqpe5h2MbZx35JOuW9EE");
            timezone.setVersionId(1);
            timezone.setCountry("Kft7wle60OUecOpuGMdLajM79uNjxaQZekg3cCfbmX5LgsXAlk");
            timezone.setCities("T6B7JD1MryPX7GI8xhokGyS9VZI8TPzqegPVY68BsP0Dso8WGV");
            timezone.setUtcdifference(6);
            timezone.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            timezoneRepository.update(timezone);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            timezoneRepository.findById((java.lang.String) map.get("TimezonePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TimezonePrimaryKey"));
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTimezone(EntityTestCriteria contraints, Timezone timezone) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            timezone.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            timezone.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            timezoneRepository.save(timezone);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "utcdifference", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "utcdifference", 21));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "gmtLabel", "AJehuxdnBkLURDun4ihA22Q7lO5yf6FtEANvaq7lGy6vBg2wht3TgmKXyUSDhJrdHx5F0VvUSKh8wiZyR23btSfCtkBg8QlzWWyzBvfZEE8Ve9HCXxDBDj0ixBvMV0wRkKDj1ytKXr5fvg0XTVhndE3PyrRgQAkhSb5JfXFaWLvPreABmKe55NGHrlp3oWDnFoGB77eSY2K8klXInmskm1uYj5p4J7YMwzEKWkE9yKCsCr5djLBq8dsL5wKe7wyaz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "timeZoneLabel", "ehCcROUTDAgznjmiLaLYI1RXoFf8Qrn9JWUF1N3tidfRF1RO4cYsDPijCWdcg7i2Lo0nNL0Xt5RkmIGGJnxkA0nYvB3BQ00f2Z0a6piLi2GMhFof490WI9Qtt2R2zupgdS3KhF0KVPYhAAEYnmE6oT0GE6HnojS2SJ1lzbHmQMtjQgfu0hBSLu6JFiWZqU0vLEgpAj3mKag0btlj9b1umsZ7KQFOw4KUpAmMDTRgbAFTFLTtnmj48U6DvcZ8kDmZ2"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "country", "Z7SXDGqkqXeTCafWAnqj5PcalqmbLH7wWW1RewpSY20460iiOzfIvUQfOBu6kM9JPi8a3showm2AlsF3983YvkUU75pisHsbQ3eC3pImlE4OahG7JAZkWHe7icykXFTu2HfWekOtHAfRQvygWNXR0v5FhVReOjFuMuutodFFeqaSQzg2ZdiVbI9AzrQbnrDM4uNsDY6hEoNiWINo4qaL2pHWjtRRzq3AcmiEs2ZA37oEi89F9dK0wnZEVzUmPfhwj"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cities", "1p3WbOUn1XEN8AiDzntv9LQb77YPQGTV0FY4TyCRWq5j1BdyCtDAd85faAnEMEaRJoqvWEfDxbqFiIhFu66iK7zIYngFUPZFP3k7NJb1SEG0ZfaDHKNXllZNhszaTENdbkXcnVQKnwUKIayWJ1t7QfayDhpnf9SiXTJ8H5Riqu2IrfpiDTntgx00sOV917xi75nMlSffIsjG9FHJGMEyIlktg6sqQpsimGYVY9OrETiNG4UgFku2IMRJPF0rc0WPs"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Timezone timezone = createTimezone();
                java.lang.reflect.Field field = timezone.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(timezone, null);
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 2:
                        timezone.setUtcdifference(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 3:
                        timezone.setGmtLabel(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 4:
                        timezone.setTimeZoneLabel(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 5:
                        timezone.setCountry(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
                        failureCount++;
                        break;
                    case 6:
                        timezone.setCities(contraints.getNegativeValue().toString());
                        validateTimezone(contraints, timezone);
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
