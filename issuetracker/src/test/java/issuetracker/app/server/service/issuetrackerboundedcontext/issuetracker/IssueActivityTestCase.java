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
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueActivityRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueActivity;
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
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueStage;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueStageRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueStatus;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueStatusRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class IssueActivityTestCase extends EntityTestCriteria {

    @Autowired
    private IssueActivityRepository<IssueActivity> issueactivityRepository;

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

    private IssueActivity createIssueActivity() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueStage issuestage = new IssueStage();
        issuestage.setIssueStageName("NKkqLuymR3MfirE85wCLGVhFnURR4Wyx7FDvEC2hw2GP3Uizjr");
        issuestage.setIssueStageId("tn8pWeeJBmzYMOHveYugh1H0kKZyrXFBM3Yje0MQSVXMivju0q");
        issuestage.setIssueStageDesc("zhYpkhMSpHg162Z2CygzqKrczLdWAWUXoX3MkhjyrwNqsKb9IN");
        IssueStage IssueStageTest = issuestageRepository.save(issuestage);
        map.put("IssueStagePrimaryKey", issuestage._getPrimarykey());
        IssueStatus issuestatus = new IssueStatus();
        issuestatus.setIssueStatusDesc("pE6tmu9Hy4BAXlAVgzUF0C0LruioslhuHSTCd3wUDwAAcOlERs");
        issuestatus.setIssueStatusId(valueGenerator.randomValueGenerate("String", 64, 0));
        issuestatus.setIssueStatusName("wF9YdOcaygj9BUCfROnPhPSFz7wmUlcFcHMaqzQ37GyEvAJsfe");
        issuestatus.setIssueStatusDesc("FXcaQL5AaoFZPX3FJujfHpuGl7WOTQSvxffowKoOLEAcNCEpRR");
        issuestatus.setIssueStatusId(valueGenerator.randomValueGenerate("String", 64, 0));
        issuestatus.setIssueStatusName("O8zTMK5nkcOiHr1diWYjOSLsJ3n8WYPABDUEbw5yEqdA3ZKuVq");
        issuestatus.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        IssueStatus IssueStatusTest = issuestatusRepository.save(issuestatus);
        map.put("IssueStatusPrimaryKey", issuestatus._getPrimarykey());
        IssueActivity issueactivity = new IssueActivity();
        issueactivity.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueactivity.setIssueStatusCode((java.lang.String) IssueStatusTest._getPrimarykey());
        issueactivity.setIssueActivityDesc("WBQCVb4H1lDs1TEKN79kdGjaX3DbG6GLBJQP2DlTf9MTn6pP7G");
        issueactivity.setIssueActivityName("x3hH7ieOWXrXVlIQLjVJ4SrSf3kHFtqnK5UxSxwXrznJXKygze");
        issueactivity.setIssueActivityId(valueGenerator.randomValueGenerate("String", 64, 0));
        issueactivity.setEntityValidator(entityValidator);
        return issueactivity;
    }

    @Test
    public void test1Save() {
        try {
            IssueActivity issueactivity = createIssueActivity();
            issueactivity.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issueactivity.isValid();
            issueactivityRepository.save(issueactivity);
            map.put("IssueActivityPrimaryKey", issueactivity._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private IssueStageRepository<IssueStage> issuestageRepository;

    @Autowired
    private IssueStatusRepository<IssueStatus> issuestatusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueActivityPrimaryKey"));
            IssueActivity issueactivity = issueactivityRepository.findById((java.lang.String) map.get("IssueActivityPrimaryKey"));
            issueactivity.setIssueActivityDesc("wrb91ET2zyLOeeC6gxEsW3nFEMnAp0Jel7Q67YajOodpLEXHmS");
            issueactivity.setIssueActivityName("9nDPn805HJNHzPYkZ2EbbgBWIIpxwoofgEVVYmxtYQZPE2XRc8");
            issueactivity.setIssueActivityId("cAl9WrIG4TIGaySwdGpJlSyVypVn99BO8qN4w9icPl2ShrTxbP");
            issueactivity.setVersionId(1);
            issueactivity.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issueactivityRepository.update(issueactivity);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueStageCode() {
        try {
            java.util.List<IssueActivity> listofissueStageCode = issueactivityRepository.findByIssueStageCode((java.lang.String) map.get("IssueStagePrimaryKey"));
            if (listofissueStageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueStatusCode() {
        try {
            java.util.List<IssueActivity> listofissueStatusCode = issueactivityRepository.findByIssueStatusCode((java.lang.String) map.get("IssueStatusPrimaryKey"));
            if (listofissueStatusCode.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("IssueActivityPrimaryKey"));
            issueactivityRepository.findById((java.lang.String) map.get("IssueActivityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueActivityPrimaryKey"));
            issueactivityRepository.delete((java.lang.String) map.get("IssueActivityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueActivity(EntityTestCriteria contraints, IssueActivity issueactivity) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issueactivity.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issueactivity.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issueactivityRepository.save(issueactivity);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "issueActivityId", null));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 2, "issueActivityId", ""));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "issueActivityId", "HcWkSTpiDOGFOq1jwx8AEmVG2i54eypcA84tSBmS9nJciZB7ZG8Yf1yZ7IzyoSLIb"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "issueActivityName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "issueActivityName", "RzdTgTE60Oh31vaJu4AZeE5XNu6lZjqwCUppxvdLwx8ktuEd3HHEIIWtHmfaml6lThMsUeHzTXnpwcy0z3qQMXCpItTNsXbpsAEaybfJdOHn6TJRYitfOi0KMRe02b0ilO4RIr2AgfTu0o7BQKuHVpkvfhqJDF8GJvbtnAKzcrx6sqbS2b7s1yWLNYRVawS0uLsywB6EhhWD0dl9ObucmYg5a4koA82Lqc9M5YjEkCDsUlUqEgM3C2zOp9eFfsmIz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "issueActivityDesc", "ugzxqcTDJTqa5hec2ObNIGJ6DBqcpLYPtDlp0TMigGj5KjFSZWaMPAxdBJCKRSqnMDrY0RTAzwVpWpoRX49T5N1tKqjQBcTOxwDbqx1aIvDha7JHCsKRaIM2KU4KzHRAwGmUlp7UBkM6THg0TcI34itfTEr1rWZkkGYOkA4xy9ovZ8yaURrKlBmysKInfCNfxQaKRpXD980TjhlnJRm7HQI9mGrSvXeDL0wH9SnsXszgL7XMJMTYpGfU138S3w2fNhHyCufoSJhpX98JrxjoipOId92UYsEwcPihmgceS5lLfXKQlmjKX6HhORDoJOEEgg5VhUlmCwzhRsK9bip2mgDSXDiFMqDF9nammdf80F9qPTUgTfvX19ZXfT61NVFtoqj0A4JUGJO6kU496DXPlKMMeHLqkAxeEPsvYgrGioCMfP1GTELRWY2KeFXLRZq1P2pzjZGBoXansReu0gf7nMBjCGMOOwXAVgCrVb8VC162vMwT1M73HWM1V9KkgMhzJSljvjEW9rMaWc9d1MIQqQOUdof5GF1yLjSSVj4Aj8exVB4FvJvSrehAA95iMlqAVVcDOrJtmZY0CH8rJde6AHhJQQAwesT1stgQrRRJmhieAsampmOeajhvEZiJyohSpCI06vqNeqRIDOg47lXLn8c3djbGeJkM8mfpOfPJD4LN8jADA8OC9bP7hwZemc9uZlLaPrZrjz1WYhTlNnnjSFunMzfohqe5SPQrvnfd3Pn4H8K3msnrnJk3TCVPbpijkOGimt2PnxDvGkAZ1gIfailturIsRKjB0f68yx3iLa0CYsqETRKWJo24f3Sbm5ONyHoNPTHaWyMi3aA0GXlrkbjULPGpwXbFquBzW9EBQh6LXqetE9nOiKhhNW2vO3MzR1FfQFYhiXxo13Po2RA8GAX1ZZ6q0ZIQu3g4KBeKDUVUgeoDzSYXnWUoj7cnpWA8D3c62EdUrhoAs5eO38JbxVFDEJ4qmbBrUZuL8Iym0Myt9lrXeT7K8jnG2kSAUZ0fl"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueActivity issueactivity = createIssueActivity();
                java.lang.reflect.Field field = issueactivity.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issueactivity, null);
                        validateIssueActivity(contraints, issueactivity);
                        failureCount++;
                        break;
                    case 2:
                        IssueActivity issueactivityUnique = issueactivityRepository.findById((java.lang.String) map.get("IssueActivityPrimaryKey"));
                        issueactivity.setIssueActivityId(issueactivityUnique.getIssueActivityId());
                        validateIssueActivity(contraints, issueactivity);
                        failureCount++;
                        break;
                    case 3:
                        issueactivity.setIssueActivityId(contraints.getNegativeValue().toString());
                        validateIssueActivity(contraints, issueactivity);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(issueactivity, null);
                        validateIssueActivity(contraints, issueactivity);
                        failureCount++;
                        break;
                    case 5:
                        issueactivity.setIssueActivityName(contraints.getNegativeValue().toString());
                        validateIssueActivity(contraints, issueactivity);
                        failureCount++;
                        break;
                    case 6:
                        issueactivity.setIssueActivityDesc(contraints.getNegativeValue().toString());
                        validateIssueActivity(contraints, issueactivity);
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
