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
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueStageRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueStage;
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
public class IssueStageTestCase extends EntityTestCriteria {

    @Autowired
    private IssueStageRepository<IssueStage> issuestageRepository;

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

    private IssueStage createIssueStage() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueStage issuestage = new IssueStage();
        issuestage.setIssueStageName("mb1iopNnyYf7GrpQEOhpW5UMkx50tKh80A8lWWm3Wbd2xIdIzw");
        issuestage.setIssueStageId("n1xTMf3SLTRoXKWZl10wsKrH6NHznnT4wBxEETempBVdeeUjqk");
        issuestage.setIssueStageDesc("2Qf0yrwTKykI9V5fFOp10wbCtuaERAJOClgfOd3ZH8f3r7cJho");
        issuestage.setEntityValidator(entityValidator);
        return issuestage;
    }

    @Test
    public void test1Save() {
        try {
            IssueStage issuestage = createIssueStage();
            issuestage.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issuestage.isValid();
            issuestageRepository.save(issuestage);
            map.put("IssueStagePrimaryKey", issuestage._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueStagePrimaryKey"));
            IssueStage issuestage = issuestageRepository.findById((java.lang.String) map.get("IssueStagePrimaryKey"));
            issuestage.setVersionId(1);
            issuestage.setIssueStageName("B3DIhvQLlj991JAA6o6IWpISSVbMnTTTzO2oXwSn6Ctx5rYL5m");
            issuestage.setIssueStageId("hfEcHUPyWyWSHhNcDUGpIYsWIl5ny1J6MIVHaWBJTsiiluKQ36");
            issuestage.setIssueStageDesc("U4BQlc3vbleXBrhBNJiW7x7MuF1UNv3MjN5KyUL2IIC5iLbt6i");
            issuestage.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issuestageRepository.update(issuestage);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueStagePrimaryKey"));
            issuestageRepository.findById((java.lang.String) map.get("IssueStagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueStagePrimaryKey"));
            issuestageRepository.delete((java.lang.String) map.get("IssueStagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueStage(EntityTestCriteria contraints, IssueStage issuestage) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issuestage.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issuestage.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issuestageRepository.save(issuestage);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "issueStageId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "issueStageId", "FZ92sPmqL2QboYOnQiYJJqes4oLBCMp8QW3qtTUPp9DNBHLFAVvg4XRT2jUUR89zx"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "issueStageName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "issueStageName", "7sVE6DSTfF4Nt8zFlXLjh20ORp4qfMKwmFT8HYM0uVJfwjSzDZPBDIZDVRe0bSnSMZ07honHeJckD672C2BhZNUEuhQLGQGPr6yKESFSa6tzCpLUKq7Iatr3vxFZFqaI42XytRJKXN8yaAgD24WzgLGdMzMxCg192MfkwPH9vamAUj8OZMTrdh0CsIzwXnj4ll6Nu1TxwD33ueaQgmawi64ek52LQO9BIFC8VF1lLVjyKpM9CEejb7482AljlF7RG"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "issueStageDesc", "5RU4V2BanHh7qyuzcQxLnkEnSoRPixM40gwotOioLXfxY2Xss5XFHOJlU1yUgen7yxfrGDk0ZFtePIwxCz9wS0PNQdueUazqRIM1VWB68HcUzbMkQAiD15OvJ83fMT0kisIBYbTL78ktVWlAiiWuLNY9TkKx0sxP2ABZSweI9lbDiTOkBSWmBOfEKQoStzTOtcAoVegQqbqIagh2lAxZ3P7aYTSDRyksvF9J9DXEs8qvJVWFN4OfAgrmDjyc2PIdvYh95951NZeI6kRs01s8P0JsjNbHtYnUYiYlBhDoB4tvbEOs84cMfN2mVCgFhTv7OqhFSRxRU89voUdSJMrCCDQRGfULQ8ECGYukxH2nrYCoaYvfme5QYK1XWKXTOOuJ5iD0cxAT4CpLormbK8duN28VTuJCliiuBHBJDysXIqL2EaNLKyRATOjjq6XSY3nqqeld6GyEqktjcYCMqtMKNrz6Qkq5eQbPTumq6DleUkH6rxTx6cUjv9xvchhvVWdgzOjRDAkfMogWTfT3re2twWZyQC5ZxwPQlSPKLbviDquZd66k2Gc4S4MCW2OfTjF6tZzrAr0wSZPe3rzlbMLEpNFCxxupmSInrKh8g0nnVOwz9ufDYNvVMimTizYJqPCDi1tYtoiVpfzGATqD18TExxnet3B3xYABd5ChYhVeRFuAVdLOQX6L7RbM5UWUjSkYeAO6fZwrtgSj4InaDDPKxI1wqjz4dzihFhomAvfTz1WjhA8eBVpnp2Zyq5f5mA49vfQVKmUAm19eh4kjVlV8fINZrc2VEdozZYFjXeCuLWKqkEPMPAQD1vrWJppyF8uLiMdNVf6bo5dHHiBqV9162SUDE3asaxAYqDnB2VSCKRIHkBbzq6jUiQCNy6MeFACddVE3GYlI2RQ7FX8sRWKdOi4WpnI0SgHEm6PpB1pXAMBZlu6frq7fXHMIXx7QFUDx6xC9vu9J4URzGiIqqQuTeqvlLuam6OT5TexfJIFzNzZlzsZTIDozOS13rhwq58nuQ"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueStage issuestage = createIssueStage();
                java.lang.reflect.Field field = issuestage.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issuestage, null);
                        validateIssueStage(contraints, issuestage);
                        failureCount++;
                        break;
                    case 2:
                        issuestage.setIssueStageId(contraints.getNegativeValue().toString());
                        validateIssueStage(contraints, issuestage);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(issuestage, null);
                        validateIssueStage(contraints, issuestage);
                        failureCount++;
                        break;
                    case 4:
                        issuestage.setIssueStageName(contraints.getNegativeValue().toString());
                        validateIssueStage(contraints, issuestage);
                        failureCount++;
                        break;
                    case 5:
                        issuestage.setIssueStageDesc(contraints.getNegativeValue().toString());
                        validateIssueStage(contraints, issuestage);
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
