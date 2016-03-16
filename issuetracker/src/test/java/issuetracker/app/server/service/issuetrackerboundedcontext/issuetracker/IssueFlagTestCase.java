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
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueFlagRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueFlag;
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
public class IssueFlagTestCase extends EntityTestCriteria {

    @Autowired
    private IssueFlagRepository<IssueFlag> issueflagRepository;

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

    private IssueFlag createIssueFlag() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueFlag issueflag = new IssueFlag();
        issueflag.setIssueFlagDesc("QTuflDcXkJ1ETqtvDmLNLytJ0IRlsOOut55Eq93glhDTRL67tH");
        issueflag.setIssueFlagName("daRwsGKGCeVizwaNB5THX79K3zEMIRe4nYe7RGr1IH7f4SBOLu");
        issueflag.setEntityValidator(entityValidator);
        return issueflag;
    }

    @Test
    public void test1Save() {
        try {
            IssueFlag issueflag = createIssueFlag();
            issueflag.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issueflag.isValid();
            issueflagRepository.save(issueflag);
            map.put("IssueFlagPrimaryKey", issueflag._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueFlagPrimaryKey"));
            IssueFlag issueflag = issueflagRepository.findById((java.lang.String) map.get("IssueFlagPrimaryKey"));
            issueflag.setIssueFlagDesc("wrUCZGuqihNkq50FIIFm9ivgIDaLniaBtanKFYCmjXyDBAUzHP");
            issueflag.setVersionId(1);
            issueflag.setIssueFlagName("89oqBuUu7YppdiFK2Ex5zfUEm9ssmt0mGcPBDI02kkdRLNyXP7");
            issueflag.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issueflagRepository.update(issueflag);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueFlagPrimaryKey"));
            issueflagRepository.findById((java.lang.String) map.get("IssueFlagPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueFlagPrimaryKey"));
            issueflagRepository.delete((java.lang.String) map.get("IssueFlagPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueFlag(EntityTestCriteria contraints, IssueFlag issueflag) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issueflag.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issueflag.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issueflagRepository.save(issueflag);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "issueFlagName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "issueFlagName", "GU6btRBcQUwl4RPFSX6OlllQaXzhGQqIzDMeQon9nMvp7cRHUR1nhays8haerxm7AcY8Hv8JtDj1d85nsfhoOapnG3b4jSrFy5ke2X64T07VdgFR6R1BwMWUjSvTeNfzGVvdEaZLaanDSRK2hVkEkdJsvhPNTByICKMSqC3GAyKjUXuRTEWXTCEwL3CF6mMfAGyHhJIPWUOadUxLeJvg70zDtjzlF2Ek5efPSXi5VIoaAY054NAg4O8dfNFdoa0ww"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "issueFlagDesc", "5lOrhELt51NHYbeNW2TVKSFTHgt6u9RRAnaKIb3R7CGUDndPTM5ZEbMzsNfgg4TRC4RsyLw36oYYqfCHpEmy7Cnblqawdj6w1VDRh5JdgyXcl9E4yfzMtlHuJgQV5Rs5zlhb3Iz5s3Q240SnnXG7uLypPVLBQFGtxA5PEs7xx6tY9dVALMpuL0NU7sjsNR0gMektxucN6qEyVKInIjGiA1BdGEQtod5PPWVhUwyQxzcT2dDrFWpZjrPitEJLl9ieNNd1F6gjVMp2AWVQjVul5ecp6GkwWpnVsmIFXIg27XcpI9VFHBxpmya24g3kK7fHFrrL28gLxx4QUJKz5dloepkUwlmY5f5lF3KHHOcM2igCOP5Mek4aif3EsaTyNAUZMY68yskRclvkpDaBJZYHE48gdZeCvjp4gxiDDkjuI2trf0seMmCl8IEcg8cf5WB7cWctdUvmiYJsejmaEN6J7Nh0dqbKmmFeca7DMS8xYjd21EnVTnPCPHUMLaBZWFd4G4Yg2SkkCgjNeoYKMimgMJtu9Piw30wJ0VRUVXOmHeB2dbn8icPjCyI91LcllfdnYMksbZwRmOYRMTF968s66wNRarkxsxd4mCMAjxzg3nMCEZJaHkyVDEGxBPmLRWvM6kcuCLcCFOPLnfAXBhPgqguQyMQx0UhrgnuRvEsth2ZDPod6v2Bi7ojOiIqTGraa3SRjOkL91fabXkPETsAaBjISwSoG9xLWJlBj1GS5Uv6fJDtsIh6O5NQnVp8D5Ug0ynju87rMtN9utVZxlNxCZ5zbp6tAZmkGJCZJ0HiaLxW4Km2dSTeT3NU2EOdBzbHSRF6be8mnENpzW9JK8k99dtN320eUn7iwsA15X8eghqOcPA6zmzrFbbiS8XL6naDfT4uHLTcw1Waj26IBFlRyYduCcODIsxD4XHbdQrt9OMPnRp0Zzg4r8fsoSWIgmGr8j2tvIE8Kff8n2DRxFMojaB0o3fByVAVkFhMVwRgAj8SrbL4lUSjFokfhmTOjU5YMA"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueFlag issueflag = createIssueFlag();
                java.lang.reflect.Field field = issueflag.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issueflag, null);
                        validateIssueFlag(contraints, issueflag);
                        failureCount++;
                        break;
                    case 2:
                        issueflag.setIssueFlagName(contraints.getNegativeValue().toString());
                        validateIssueFlag(contraints, issueflag);
                        failureCount++;
                        break;
                    case 3:
                        issueflag.setIssueFlagDesc(contraints.getNegativeValue().toString());
                        validateIssueFlag(contraints, issueflag);
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
