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
import sales.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import sales.app.shared.organizationboundedcontext.location.Timezone;
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
        timezone.setTimeZoneLabel("Kf06B4AHm1Yd5hnxbY2FDXXpUKJFoZY1ZGd0YGw0LWPryYDbXZ");
        timezone.setGmtLabel("jcQlaJwC3bv8WP9w0H5rPVOAzMOWntV2o9lL8bOl5UCDLtfpAY");
        timezone.setCountry("oNnhIlO3yHVOcadHUpDAoz6x8BnYXss6koqKTpdnkCnjt2owEr");
        timezone.setCities("nOHWOUDOsD4Hf0dFyl38NJQBDiJElfmr3oRVAPHU4Ch7lhiQyC");
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
            timezone.setTimeZoneLabel("NRdIiVmDpi2EMaFRYnJpoA0rr59uqtpTZnrQ9gWWdrbUwG59JA");
            timezone.setGmtLabel("RoKkEKptc3CIGEq96ar0DHINTCZz6l3diwkXPj8Y65kNLnoQf0");
            timezone.setCountry("pYeKzhxBEEAs8Ds2i0dU3ItwPoqKl2Ol4hdlzQ1shZ9IRWjXmB");
            timezone.setVersionId(1);
            timezone.setCities("IdaSw5PoZhzZoxav83dqsSX4ph3iIYuajZaxbkotbcRR7BnQMN");
            timezone.setUtcdifference(11);
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "utcdifference", 19));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "gmtLabel", "9YEwSUhHBa8CdzeFInsgA7PdLDI52f3zumYpvkI48hW5LlVp4051DRgAYwnybETovHtMaGE3anUIZDKMdnkzcdWPzZCCY0n8RhohIonv2RzbG5bQH9Bb9VtgvurCD93IbawVGnHuDQyxxfjMgKUOYQZ363HzeDlmziZU4Swp44KXBZRurBRnn7YrB2JAV3j7S4nRMTbTQnvcMGdzVCWvO8fGLtberriFmWl6X2kGKeTONTZBaU7riBlhtUIqqwMgZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "timeZoneLabel", "oaYNob3BKOQWs9M9EY6fD8iWIFTexv256HZEPTGF1lDj9XchAZwBZYCnrcrmM6bCF7NU90JHj0Aq9A3VwYd0rR7Pampfjv1BESDTzwCIPdogFiJWxzoafb7IuOHz8cC0cebhWgNYa1OBzlsXC3Y00N0z1TA9KO6A7WTLs8rqv3odxOkMnASAwzHPqD85CX7w14UP3qqb2jogvBLsTgiphZ1yN7etu9zQpSfp2vxaRkMUsPpeTgF2uK1XiQmL4HO1g"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "country", "UIFJTVWl5kstirZjrMWSCgCDkby2fDHJ8Z780QwrLXNcgjEPLuEL5W1Cgr4zzOcKqD0Awn9MT8HN5o2Urv0L0pnvxd98bSWFaMSAOSbEramDBS9xiVJcD7XLdCZnoVzzrSzgxvBdwbyVBCK23N9lKvBfLfKSi8slWmpokaodO0qMCOOo5e0N0Ar067DuPbftGUSNZ45ZSdUfUHd2SN1wp8Vk2NC6y7tXFfCdExJzB9t5fC5Sc3Ae1a03O6rQfBniE"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "cities", "fRhriaDZY5KVb9AQ1aIzuR7lpQMxzu9kbsdZt1xnnAfsspNeA2jhKOFcLTfiJzA23epFX9uEx8qtDsOiqSTDpvEtYgBO3YkuqEKKqdeZHzlQCPzQRcqiXW5l4tm9HwU8N6XkE0qs5iy0Hyylax6wbI9tSFB570iAbVgHNc6Qb5oTIa6uJPctXauZeyqX99YDb5ZjpsnqAiElbPE83WRBDykARkeAIG1PI2VSWT6ozzc3UJh1sSBPBiXr82sGfj8kD"));
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
