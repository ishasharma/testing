package sales.app.server.service.aaaboundedcontext.authorization;
import sales.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.aaaboundedcontext.authorization.UserRoleBridgeRepository;
import sales.app.shared.aaaboundedcontext.authorization.UserRoleBridge;
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
import sales.app.shared.aaaboundedcontext.authorization.Roles;
import sales.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserRoleBridgeTestCase extends EntityTestCriteria {

    @Autowired
    private UserRoleBridgeRepository<UserRoleBridge> userrolebridgeRepository;

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

    private UserRoleBridge createUserRoleBridge() throws SpartanPersistenceException, SpartanConstraintViolationException {
        Roles roles = new Roles();
        roles.setRoleIcon("szq62NL9BXIOnC6sDFf8gMkoiE0CEkTGllHL8PDhRqrxvzdPzY");
        roles.setRoleDescription("l8f2RUsnWevC7uL0HLThALHAwvzv0fc6Dz8qmIEM0FDuL3iQle");
        roles.setRoleHelp("VOhNTybTPRHEt01m5cajyU0wxBS7ywf8s2X3A79Hg3rkD7w6Nh");
        roles.setRoleName("H09dor59wnXs0mF5joASARl2XG8GyHUftVFuzON7ciDnomd9jC");
        Roles RolesTest = rolesRepository.save(roles);
        map.put("RolesPrimaryKey", roles._getPrimarykey());
        User user = new User();
        user.setMultiFactorAuthEnabled(1);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("hiEozWy98iHj08aq5jV2mxuSnPTssGGomH1fMGnCjlH7YgcMDp");
        useraccessdomain.setDomainHelp("4qY1INntRvPqpnKjLmEv0da14nM500GVmOt3G2zcZjLrHDbTSZ");
        useraccessdomain.setDomainName("ITim1Hpf7JY7D8RAGMqO2xsynPzJSOM5ClSuYz0iZyjLGRm5LY");
        useraccessdomain.setDomainDescription("jO3fmOJerH0FKmAsrui7vvZugciZR4g6fU5TxT1I6Gv0K2dcop");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
        map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("G54LHuiK87uiLqvsd7aVonXluOXZFQl35N2jJ9uZmnwUgdD72C");
        useraccesslevel.setLevelIcon("pXAz9hSXArNpmcSLzn9NzX5m3f49W0CsTULL6jHHLRCOH6DhGq");
        useraccesslevel.setLevelHelp("QvfMtAsf1QmcxCWt9iYb3flj5Ztm6ARmtpUXGWuSiKgMXXw6VT");
        useraccesslevel.setLevelDescription("y6M7LTfcYgxP2qxxxTevL3JIxXDZg6faVOIn5jZdNwNCWGp6n1");
        UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
        map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        user.setMultiFactorAuthEnabled(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setAllowMultipleLogin(1);
        user.setIsLocked(1);
        user.setPasswordAlgo("AsWWaTDrirCTuMZoYoNlP91SQU2sJ1sDxeXxle5Dd6Pyn5IjfJ");
        user.setPasswordExpiryDate(new java.sql.Timestamp(1458129755426l));
        user.setIsDeleted(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setGenTempOneTimePassword(1);
        user.setUserAccessCode(50395);
        user.setChangePasswordNextLogin(1);
        user.setSessionTimeout(3379);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1458129755452l));
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setLevelid(5);
        question.setQuestionDetails("bK2dqVSdns");
        question.setQuestion("CRKQvpKvqV7oveoMjvAFRBAOIYVLpx9LjeW3xBe42OIPJsACzz");
        question.setQuestionIcon("OImSRrdGN0rFZA9UBYz8AT0ux6D5NOh8gupwPbclDHrQpdXjAI");
        Question QuestionTest = questionRepository.save(question);
        map.put("QuestionPrimaryKey", question._getPrimarykey());
        passrecovery.setUser(user);
        passrecovery.setAnswer("hzduL7MQxCUsszVQntDk4b3zs0bjdfDkGM4YerJwNF4OjbTmqL");
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setUser(user);
        userdata.setPassword("Sy4cxfp85ViU6xhO61EqwpHF5gZCwdXsMxVXV4s9OfPgv4gn8i");
        userdata.setOneTimePassword("WcZJufh5uKPSWcssbGDEcA0auMRTVszp");
        userdata.setOneTimePasswordExpiry(2);
        userdata.setLast5Passwords("HrU6dcZsh8Ub5vM2JPSNVHfwrcFzbuLyP5AnkJ5T3somDvKVvc");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1458129755606l));
        user.setUserData(userdata);
        User UserTest = userRepository.save(user);
        map.put("UserPrimaryKey", user._getPrimarykey());
        UserRoleBridge userrolebridge = new UserRoleBridge();
        userrolebridge.setRoleId((java.lang.String) RolesTest._getPrimarykey()); /* ******Adding refrenced table data */
        userrolebridge.setUserId((java.lang.String) UserTest._getPrimarykey());
        userrolebridge.setEntityValidator(entityValidator);
        return userrolebridge;
    }

    @Test
    public void test1Save() {
        try {
            UserRoleBridge userrolebridge = createUserRoleBridge();
            userrolebridge.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            userrolebridge.isValid();
            userrolebridgeRepository.save(userrolebridge);
            map.put("UserRoleBridgePrimaryKey", userrolebridge._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private RolesRepository<Roles> rolesRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserRoleBridgePrimaryKey"));
            UserRoleBridge userrolebridge = userrolebridgeRepository.findById((java.lang.String) map.get("UserRoleBridgePrimaryKey"));
            userrolebridge.setVersionId(1);
            userrolebridge.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            userrolebridgeRepository.update(userrolebridge);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByroleId() {
        try {
            java.util.List<UserRoleBridge> listofroleId = userrolebridgeRepository.findByRoleId((java.lang.String) map.get("RolesPrimaryKey"));
            if (listofroleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<UserRoleBridge> listofuserId = userrolebridgeRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserRoleBridgePrimaryKey"));
            userrolebridgeRepository.findById((java.lang.String) map.get("UserRoleBridgePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserRoleBridgePrimaryKey"));
            userrolebridgeRepository.delete((java.lang.String) map.get("UserRoleBridgePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserRoleBridge(EntityTestCriteria contraints, UserRoleBridge userrolebridge) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            userrolebridge.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            userrolebridge.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            userrolebridgeRepository.save(userrolebridge);
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
