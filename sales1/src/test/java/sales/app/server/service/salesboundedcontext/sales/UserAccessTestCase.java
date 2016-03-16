package sales.app.server.service.salesboundedcontext.sales;
import sales.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.salesboundedcontext.sales.UserAccessRepository;
import sales.app.shared.salesboundedcontext.sales.UserAccess;
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
import sales.app.shared.aaaboundedcontext.authentication.User;
import sales.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import sales.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import sales.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import sales.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import sales.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import sales.app.shared.aaaboundedcontext.authentication.PassRecovery;
import sales.app.shared.aaaboundedcontext.authentication.Question;
import sales.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import sales.app.shared.aaaboundedcontext.authentication.UserData;
import sales.app.shared.salesboundedcontext.sales.SalesRegion;
import sales.app.server.repository.salesboundedcontext.sales.SalesRegionRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserAccessTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessRepository<UserAccess> useraccessRepository;

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

    private UserAccess createUserAccess() throws SpartanPersistenceException, SpartanConstraintViolationException {
        User user = new User();
        user.setMultiFactorAuthEnabled(1);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("THE1Z5T7JrqSPAHhmaRWIyt6OSYgwtHh7WLBN28Uzg14bWRV1r");
        useraccessdomain.setDomainHelp("rLAGFWMMBFieLFdFNQ6nXmTdir4YoH0IeolqPOeejfMojudWqo");
        useraccessdomain.setDomainName("6LxKIGWqX8qvpTdLtPbKLxirOWtMWN7P0qKEqFg0m9RHGcVyF0");
        useraccessdomain.setDomainDescription("CCy1ZURJ5vAykAnlWkcSRBknpYFGvc4iCfeAZpFCtAvcETPgt9");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
        map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("yxsB6nr8JVwrslKTAnx8anb3JjaIbbOEGYFL8l3znNcfnaGi15");
        useraccesslevel.setLevelIcon("saLm9vdKsnlBRG6Jj1ZV8xRmF3CWHX5Rr6kSfj9Z0XToBN2Urd");
        useraccesslevel.setLevelHelp("z7AJ5U6HR3ICGIZLRmbfIgT2pIlECiyhuwlH3ZxHejZRHoPgCO");
        useraccesslevel.setLevelDescription("UKYYnh10PUGuSWd7Dwhfzs9VIPcf94Yiga84p2KCbFeaM4stNa");
        UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
        map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        user.setMultiFactorAuthEnabled(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setAllowMultipleLogin(1);
        user.setIsLocked(1);
        user.setPasswordAlgo("MtrSM3AEgq1oBC93qIXj6oJ0oasXHEvmOk5i29pRwyy2UjOEWp");
        user.setPasswordExpiryDate(new java.sql.Timestamp(1458129762332l));
        user.setIsDeleted(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setGenTempOneTimePassword(1);
        user.setUserAccessCode(25387);
        user.setChangePasswordNextLogin(1);
        user.setSessionTimeout(2073);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1458129762353l));
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setLevelid(1);
        question.setQuestionDetails("xNb2aHVDTR");
        question.setQuestion("E0qdlIMGO5WplqpXYKn2m0hhdSJ8HgoSDheoO7J5FmNmXaqdKJ");
        question.setQuestionIcon("Y6PRYhCOPZG4JlfBDqmOlmdLql4qAnujtpysdXGIE5ipdAsHS5");
        Question QuestionTest = questionRepository.save(question);
        map.put("QuestionPrimaryKey", question._getPrimarykey());
        passrecovery.setUser(user);
        passrecovery.setAnswer("ueuVnGhkfuSEToFFpQXmMaAsV6aSXT5RySCQgqgbSg7LPLg9rT");
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setUser(user);
        userdata.setPassword("z1nAUQ5hBddUaCgz22fllKHcoLniFl1vToUCvGIY7Qm1SoesgM");
        userdata.setOneTimePassword("miOc330H08TMUuo1amq2eCjIpuKO8Acs");
        userdata.setOneTimePasswordExpiry(3);
        userdata.setLast5Passwords("T1BeWeYy3CnDTmnDE1rwRXCvGQyiHhZg5cqO2DD8waoJHedPp6");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1458129762488l));
        user.setUserData(userdata);
        User UserTest = userRepository.save(user);
        map.put("UserPrimaryKey", user._getPrimarykey());
        SalesRegion salesregion = new SalesRegion();
        salesregion.setRegionname("88pd6nK5RdpcJXOH4nv54bP7sASack42Tbytw1mNnIC98YkLsZ");
        SalesRegion SalesRegionTest = salesregionRepository.save(salesregion);
        map.put("SalesRegionPrimaryKey", salesregion._getPrimarykey());
        UserAccess useraccess = new UserAccess();
        useraccess.setUserId((java.lang.String) UserTest._getPrimarykey()); /* ******Adding refrenced table data */
        useraccess.setRegion((java.lang.String) SalesRegionTest._getPrimarykey());
        useraccess.setEntityValidator(entityValidator);
        return useraccess;
    }

    @Test
    public void test1Save() {
        try {
            UserAccess useraccess = createUserAccess();
            useraccess.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccess.isValid();
            useraccessRepository.save(useraccess);
            map.put("UserAccessPrimaryKey", useraccess._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private SalesRegionRepository<SalesRegion> salesregionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessPrimaryKey"));
            UserAccess useraccess = useraccessRepository.findById((java.lang.Integer) map.get("UserAccessPrimaryKey"));
            useraccess.setVersionId(1);
            useraccess.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessRepository.update(useraccess);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessPrimaryKey"));
            useraccessRepository.findById((java.lang.Integer) map.get("UserAccessPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<UserAccess> listofuserId = useraccessRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
            if (listofuserId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregion() {
        try {
            java.util.List<UserAccess> listofregion = useraccessRepository.findByRegion((java.lang.String) map.get("SalesRegionPrimaryKey"));
            if (listofregion.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("UserAccessPrimaryKey"));
            useraccessRepository.delete((java.lang.Integer) map.get("UserAccessPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccess(EntityTestCriteria contraints, UserAccess useraccess) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccess.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccess.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessRepository.save(useraccess);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
    }
}
