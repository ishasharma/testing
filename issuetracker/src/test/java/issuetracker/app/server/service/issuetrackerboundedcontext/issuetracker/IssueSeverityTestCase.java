package issuetracker.app.server.service.issuetrackerboundedcontext.issuetracker;
import issuetracker.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import issuetracker.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueSeverityRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueSeverity;
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
public class IssueSeverityTestCase extends EntityTestCriteria {

    @Autowired
    private IssueSeverityRepository<IssueSeverity> issueseverityRepository;

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

    private IssueSeverity createIssueSeverity() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueSeverity issueseverity = new IssueSeverity();
        issueseverity.setIssueSeverityName("obQygJ8IN0ngDsn2ek970h1hRF6BitRHxeCFVrS5H9ZbxWvL1b");
        issueseverity.setIssueSeverityDesc("BkgQsJmkYWB281WbuGlDUIW0aIC6jJRq6FfdO1hLw8CvToBIMK");
        issueseverity.setEntityValidator(entityValidator);
        return issueseverity;
    }

    @Test
    public void test1Save() {
        try {
            IssueSeverity issueseverity = createIssueSeverity();
            issueseverity.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issueseverity.isValid();
            issueseverityRepository.save(issueseverity);
            map.put("IssueSeverityPrimaryKey", issueseverity._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueSeverityPrimaryKey"));
            IssueSeverity issueseverity = issueseverityRepository.findById((java.lang.String) map.get("IssueSeverityPrimaryKey"));
            issueseverity.setIssueSeverityName("qaakFCpmHztRv8zuwHtsEglFQ8AGFyDpiUedwqm1M1NlpN7JrW");
            issueseverity.setVersionId(1);
            issueseverity.setIssueSeverityDesc("S6N0u4OiZqIG3oiT2v7KoL9ZlXReP5gUwid0kJwKQAFY7p5zS5");
            issueseverity.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issueseverityRepository.update(issueseverity);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueSeverityPrimaryKey"));
            issueseverityRepository.findById((java.lang.String) map.get("IssueSeverityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueSeverityPrimaryKey"));
            issueseverityRepository.delete((java.lang.String) map.get("IssueSeverityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueSeverity(EntityTestCriteria contraints, IssueSeverity issueseverity) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issueseverity.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issueseverity.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issueseverityRepository.save(issueseverity);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "issueSeverityName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "issueSeverityName", "mpBiNZq06IOiwhTkhQQycNDVPB7lTpqJhQaiUOD6vMDgRAHOTTXsmvXq062r6ZIG23LKwuEMmIDChATUBg2PNF5q42rn3900G51GqjckQ3vAxdQAX9i7V0xMIT3u2u0cVbgGF0wfGiCTA16TBBUUemGGZqGVNoM3YVj0mdKoaxjcyGwTLhdCYXIdNmoOagmZm0LmsOHNaRMzrohJSRlA7jrk1T8D1kpN1LNsB3VzV100WonU4cdrdQ8BX0BRy1ZwU"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "issueSeverityDesc", "kslrTAtgfRC2UhQ0xhz1htbOshrDYjdCEDz2qyCrMf7UelwP2jvdX3wzdcbgOTdtKlkykN3TlpzLL8NFUkXtgW64SDApxSbJA0IKcNwdqBWGV8InGQUWxiwhoFWwRcSpRN3OYe2luNEfCYoNblsjx95FY7I3HNkSGkQN2edZCarkNew6FqkidZpvUvABBBMYG8NTpHPqRXfFC09zNSbPXMgHaKLqLwrXyKo2PnEL9lLcXqx5g8rS5TOUya4wUYpIIwXnG2Mgnz93HU3xGhOIHYaH1SP0ZBDqIr6mDcMZq0XkAIynes1gWeBmhwwlpxZZ7lLYiBOLYDyKQSiZVOyCo9R3o1kBFExiCUfBJ2JVawM3pU0PdDB893UbJOTeIGMEcf0Brd4NgPWZogqsXK0TKvRLx2LYDPLPeRYb4TiejROLWrCyOfPLlnidjxWQfuEOWvQysi6xGmAUONDOaPWMqi22WXQBe4lRUMdCuXwe16Kccf45WizQSpunsyJn0BygtRBRqqbaAuRZkRLpvLLfdCQ4judG9Oktill20xGfmmvdUsYysGWfn1N9KS35Hrc04NFPqcmrJZRRtCfNt00mp2c9En3z5g8380ehOn0ovIhS4W5bddQkzQmrK6tqTtWD25Qjp8gmlWNwo3P0NojZTCCzx2kCDRmb71cm6rvficYdfzrHFSZhfhLX7Un7aKPBWKl7JWEiUja4ngR1hYh0aiBgpwW0WVCTbxd1cHya0C5IKsYOoF9fRpPhMH4QIsnBzcK9XkaN7ybUOLc6SGicfMCPunlbIPcbRPoQodAbgSMj0j1Ojo2f8F9cx0lnY6qLJzBZuljMzJc0EYBLpa0XTvlGyZjZO4NOsQsioyqCOg33OgZ5WFxR3weK3uhvcTrc3iVyXbCZVF0ZVnTX035XkXxXs1zD1eKkOSG39K6kR0ZGlKAz31OtU03uJ3NtG9xfuhLfC8GAikOGNa1zv7FQXCNxct9JLkiFiev3YNRd6thP737LbCLSZR6wNiTvAU2LI"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueSeverity issueseverity = createIssueSeverity();
                java.lang.reflect.Field field = issueseverity.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issueseverity, null);
                        validateIssueSeverity(contraints, issueseverity);
                        failureCount++;
                        break;
                    case 2:
                        issueseverity.setIssueSeverityName(contraints.getNegativeValue().toString());
                        validateIssueSeverity(contraints, issueseverity);
                        failureCount++;
                        break;
                    case 3:
                        issueseverity.setIssueSeverityDesc(contraints.getNegativeValue().toString());
                        validateIssueSeverity(contraints, issueseverity);
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
