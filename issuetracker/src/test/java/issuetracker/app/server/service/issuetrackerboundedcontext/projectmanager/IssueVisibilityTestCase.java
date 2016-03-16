package issuetracker.app.server.service.issuetrackerboundedcontext.projectmanager;
import issuetracker.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import issuetracker.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.IssueVisibilityRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.IssueVisibility;
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
public class IssueVisibilityTestCase extends EntityTestCriteria {

    @Autowired
    private IssueVisibilityRepository<IssueVisibility> issuevisibilityRepository;

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

    private IssueVisibility createIssueVisibility() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueVisibility issuevisibility = new IssueVisibility();
        issuevisibility.setIssueVisibilityName("MzvsSsVIebvBgMTspdG1ZP6XdwrkNCH9tqM6h6elquR658xRpb");
        issuevisibility.setIssueVisibilityDesc("6pYnjxlktkq4qCl26XDYlUT6aqT2ajflzbufNM5HZ6TCdWnMrE");
        issuevisibility.setEntityValidator(entityValidator);
        return issuevisibility;
    }

    @Test
    public void test1Save() {
        try {
            IssueVisibility issuevisibility = createIssueVisibility();
            issuevisibility.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issuevisibility.isValid();
            issuevisibilityRepository.save(issuevisibility);
            map.put("IssueVisibilityPrimaryKey", issuevisibility._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueVisibilityPrimaryKey"));
            IssueVisibility issuevisibility = issuevisibilityRepository.findById((java.lang.String) map.get("IssueVisibilityPrimaryKey"));
            issuevisibility.setVersionId(1);
            issuevisibility.setIssueVisibilityName("PCKhN06SGXR7c0RIU6ozHvJDb4CqPuIl8J3xQS39hU9zkuhJ5u");
            issuevisibility.setIssueVisibilityDesc("ogErubXJRIHiFpO9juoTaF0n3hcqUUKymLUJl0EF6msUOVlARC");
            issuevisibility.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issuevisibilityRepository.update(issuevisibility);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueVisibilityPrimaryKey"));
            issuevisibilityRepository.findById((java.lang.String) map.get("IssueVisibilityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueVisibilityPrimaryKey"));
            issuevisibilityRepository.delete((java.lang.String) map.get("IssueVisibilityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueVisibility(EntityTestCriteria contraints, IssueVisibility issuevisibility) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issuevisibility.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issuevisibility.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issuevisibilityRepository.save(issuevisibility);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "issueVisibilityName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "issueVisibilityName", "ou2FLtGEshSApUBbvmwrdghLQwBPSIWeGnmZ5ETWIe74zBRynf4vGwqALBG2hhN0jHS2FK2I40e5cro4C9raGbdn37Pj0Qn00lsT46viHM6LHLrG0bhn7kt3fhkFklQPdAJm1c4edtYZpyiIrnYXQ7Erm2D0R661n7O6b7NObneS7m0k16GsZZo4sfyJW5Mo0DdmhUUMTz6gKhX2DL5fJFEwRKYvdobp8TN5y4v7BmZAHsZLzPMfMQ5vNGzipMaMZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "issueVisibilityDesc", "Z6lNwr7mvEFDnBJQlmTwxNtsjyXkfUFLWoN1AeParMZ4UoSKlVq6AiZz9YNvOYaZvJo5xqNauzNfp8NfoBiIggjXYPfFIoOtcV23rcnqvrEcUxgQ0WfQVUHkX9xJcoEAKuG2MJyGtOEERirt5iER57MzaVJ8wHvDHvXImvsmmxc5mhbGjvKGVrAQhMgRxoLWlVN4sopZfCvQ6sEb2406xmlyxufdpVvX9RBSGSjVsXWNTqiLJrnY69ppbOBDXUkaS3QRjA7DQ0lDhwSzKJjUXhFMb5psgbsAKjoPULdyVqDwFYwBk7sBoeWjltj2EjbWvW4Y6DPyLhsFfqyNgvN7nY9qm6W0ofotjglVcCs35kHpCP0ZyIKxzD4nUzVozBEIpcsL61IRn1ftMTphPIzIEAZ6f58NzrvTiF5dTBznsq28Y2NKMQaG4AavCkSVWKRSW19gvG6cKX4nTK8XqNuSrVSIfL49xfKv9ZtzGa7nc9FVvjHUYhIKDB2fFV6fTsY7Rb5zBjuNHadfxRk4bOB0Qr7iQCH6yBvNVgCoSScstUs4omxIIfVR3kL9dqgWVKPNw60IeIvIPn040UHaBJ9IiHYYd21ciylkKvoOGh79E0HYDLItlEmsnbQ1Gdh3omtkVtvO6vqqzmluM54xt3MuU7VBbHp4NuWB2JSb4GTDtqNXWIcyCOuPfXokPHRIw0O7nDSBP9sXvmFdvfse0AbAF7WVNz0E4TBBbJNB9bJWbEX9oiklS4TmKUJ1IN1BfjndZHrb2aTlK1uEQBRn4mXqaX5Y7T07NC8k1gvqmTcEfgDr3BFKCuwprtwj1VUQLOWAADJLdosP5wmwgGOSWh6EXVYXOFI5EDNhfxV9Rti4PR6b7o9zxkyNg0Ash99aIjyolYX7uZU3zn6jhdSRjxTNLmioDFK32UyXtWqsLIGWcPb9LtX6r5om2zQruFXVd61XiWfBoxhHvmVcIsuwtFAXLazNxC045jn85nRbJ7tQZwFh0bm78tBUWmluQWyBDZDYw"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueVisibility issuevisibility = createIssueVisibility();
                java.lang.reflect.Field field = issuevisibility.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issuevisibility, null);
                        validateIssueVisibility(contraints, issuevisibility);
                        failureCount++;
                        break;
                    case 2:
                        issuevisibility.setIssueVisibilityName(contraints.getNegativeValue().toString());
                        validateIssueVisibility(contraints, issuevisibility);
                        failureCount++;
                        break;
                    case 3:
                        issuevisibility.setIssueVisibilityDesc(contraints.getNegativeValue().toString());
                        validateIssueVisibility(contraints, issuevisibility);
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
